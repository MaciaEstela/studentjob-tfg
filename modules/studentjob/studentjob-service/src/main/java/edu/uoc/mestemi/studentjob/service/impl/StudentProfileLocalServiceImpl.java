/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package edu.uoc.mestemi.studentjob.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.service.DegreeLocalService;
import edu.uoc.mestemi.studentjob.service.base.StudentProfileLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	property = "model.class.name=edu.uoc.mestemi.studentjob.model.StudentProfile",
	service = AopService.class
)
public class StudentProfileLocalServiceImpl
	extends StudentProfileLocalServiceBaseImpl {
	
	public StudentProfile addStudentProfile(long groupId, long userId, long regionId, boolean active, 
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, String preference, 
			long curriculumId, List<Long> degreeIds, ServiceContext serviceContext) throws PortalException {
		
		// Get group and user
		Group group = groupLocalService.getGroup(groupId);
		User user = userLocalService.getUser(userId);
		
		// Generate companyprofile primary key
		long studentProfileId = counterLocalService.increment(StudentProfile.class.getName());
		
		StudentProfile studentProfile = createStudentProfile(studentProfileId);
		
		studentProfile.setCompanyId(group.getCompanyId());
		studentProfile.setGroupId(group.getGroupId());
		studentProfile.setCreateDate(serviceContext.getCreateDate(new Date()));
		studentProfile.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		studentProfile.setUserId(userId);
		studentProfile.setUserName(user.getScreenName());
		
		studentProfile.setRegionId(regionId);
		studentProfile.setActive(active);
		studentProfile.setTitleMap(titleMap);
		studentProfile.setDescriptionMap(descriptionMap);
		studentProfile.setEmail(email);
		studentProfile.setPreference(preference);
		studentProfile.setCurriculumId(curriculumId);
		
		for (long degreeId : degreeIds) {
			addDegreeStudentProfile(degreeId, studentProfileId);
		}
		
		return super.addStudentProfile(studentProfile);
	}
	
	public StudentProfile updateStudentProfile(long studentProfileId, long regionId, boolean active, 
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, String preference, 
			long curriculumId, List<Long> degreeIds, ServiceContext serviceContext) 
					throws PortalException {
		
		StudentProfile studentProfile = getStudentProfile(studentProfileId);
		
		studentProfile.setModifiedDate(new Date());
		
		studentProfile.setRegionId(regionId);
		studentProfile.setActive(active);
		studentProfile.setTitleMap(titleMap);
		studentProfile.setDescriptionMap(descriptionMap);
		studentProfile.setEmail(email);
		studentProfile.setPreference(preference);
		studentProfile.setCurriculumId(curriculumId);
		
		List<Degree> degrees = degreeLocalService.getStudentProfileDegrees(studentProfileId);
		for (Degree degree : degrees)
			if (!degreeIds.contains(degree.getDegreeId()))
				deleteDegreeStudentProfile(degree.getDegreeId(), studentProfileId);
		
		for (long degreeId : degreeIds)
			if (!hasDegreeStudentProfile(degreeId, studentProfileId))
				addDegreeStudentProfile(degreeId, studentProfileId);
		
		studentProfile = super.updateStudentProfile(studentProfile);
		
		return studentProfile;
	}
	
	public List<StudentProfile> getStudentProfilesByGroupId(long groupId) {
		return studentProfilePersistence.findByGroupId(groupId);
	}
	
	public List<StudentProfile> getStudentProfilesByGroupId(long groupId, int start, int end) {
		return studentProfilePersistence.findByGroupId(groupId, start, end);
	}
	
	public List<StudentProfile> getStudentProfilesByGroupId(long groupId, int start, int end, 
			OrderByComparator<StudentProfile> orderByComparator) {
		return studentProfilePersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	
	public StudentProfile getStudentProfileByGroupIdAndUserId(long groupId, long userId) {
		return studentProfilePersistence.findByGroupIdAndUserId(groupId, userId).get(0);
	}
	
	public List<StudentProfile> getStudentProfilesByKeywords(long groupId, String keywords, int start, 
			int end, OrderByComparator<StudentProfile> orderByComparator) {
		return studentProfilePersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords), start, end, orderByComparator);
	}
	
	public long getStudentProfilesCountByKeywords(long groupId, String keywords) {
		return studentProfilePersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords));
	}
	
	public List<Degree> getDegreesByOfferId(long studentProfileId){
		return degreeLocalService.getStudentProfileDegrees(studentProfileId);
	}
	
	public List<Long> getDegreesIdsByOfferId(long studentProfileId){
		return Arrays.stream(studentProfilePersistence.getDegreePrimaryKeys(studentProfileId)).boxed().collect(Collectors.toList());
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			
			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			
			dynamicQuery.add(disjunctionQuery);
		}
		
		return dynamicQuery;
	}
	
	@Override
	public StudentProfile addStudentProfile(StudentProfile studentProfile) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Override
	public StudentProfile updateStudentProfile(StudentProfile studentProfile) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Reference
	GroupLocalService groupLocalService;
	
	@Reference
	DegreeLocalService degreeLocalService;
}