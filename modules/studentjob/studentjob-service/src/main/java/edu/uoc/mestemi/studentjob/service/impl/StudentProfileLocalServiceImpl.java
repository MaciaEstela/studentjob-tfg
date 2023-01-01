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
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
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
import edu.uoc.mestemi.studentjob.service.DegreeLocalService;
import edu.uoc.mestemi.studentjob.service.base.StudentProfileLocalServiceBaseImpl;
import edu.uoc.mestemi.studentjob.util.validator.OfferValidatorImpl;
import edu.uoc.mestemi.studentjob.util.validator.StudentProfileValidatorImpl;

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
		
		StudentProfileValidatorImpl studentProfileValidatorImpl = new StudentProfileValidatorImpl();
		studentProfileValidatorImpl.validate(regionId, titleMap, descriptionMap, email, preference, degreeIds);
		
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
		
		// Add a hidden user first and second name to the map to make it able to search by name or surnames
		String userName = user.getFirstName() + " " + user.getLastName();
		try {
			for(Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
				Locale key = entry.getKey();
				String value = entry.getValue();
				
				if (!value.contains(userName)) {
					value = value + "<p style=\"display: none\">" + userName + "</p>";
					descriptionMap.replace(key, value);
				}
			}
		} catch (Exception e) {}
		
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
		
		StudentProfileValidatorImpl studentProfileValidatorImpl = new StudentProfileValidatorImpl();
		studentProfileValidatorImpl.validate(regionId, titleMap, descriptionMap, email, preference, degreeIds);
		
		StudentProfile studentProfile = getStudentProfile(studentProfileId);
		User studentUser = UserLocalServiceUtil.getUser(studentProfile.getUserId());
		
		studentProfile.setModifiedDate(new Date());
		
		studentProfile.setRegionId(regionId);
		studentProfile.setActive(active);
		studentProfile.setTitleMap(titleMap);

		// Add a hidden user first and second name to the map to make it able to search by name or surnames
		String userName = studentUser.getFirstName() + " " + studentUser.getLastName();
		try {
			for(Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
				Locale key = entry.getKey();
				String value = entry.getValue();
				
				if (!value.contains(userName)) {
					value = value + "<p style=\"display: none\">" + userName + "</p>";
					descriptionMap.replace(key, value);
				}
			}
		} catch (Exception e) {}
		studentProfile.setDescriptionMap(descriptionMap);
		
		studentProfile.setEmail(email);
		studentProfile.setPreference(preference);
		studentProfile.setCurriculumId(curriculumId);
		
		List<Degree> degrees = degreeLocalService.getStudentProfileDegrees(studentProfileId);
		for (Degree degree : degrees) {
			if (!degreeIds.contains(degree.getDegreeId())) {
				deleteDegreeStudentProfile(degree.getDegreeId(), studentProfileId);
			}
		}
		
		for (long degreeId : degreeIds) {
			if (!hasDegreeStudentProfile(degreeId, studentProfileId)) {
				addDegreeStudentProfile(degreeId, studentProfileId);
			}
		}
		
		studentProfile = super.updateStudentProfile(studentProfile);
		
		return studentProfile;
	}
	
	public List<StudentProfile> getStudentProfilesByGroupId(long groupId) {
		return studentProfilePersistence.findByGroupId(groupId);
	}
	
	public List<StudentProfile> getStudentProfilesByGroupIdAndActive(long groupId, boolean active) {
		return studentProfilePersistence.findByGroupIdAndActive(groupId, active);
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
	
	public List<StudentProfile> getStudentProfilesByKeywords(long groupId, String keywords, boolean onlyActives, int start, 
			int end, OrderByComparator<StudentProfile> orderByComparator) {
		return studentProfilePersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords, onlyActives), start, end, orderByComparator);
	}
	
	public long getStudentProfilesCountByKeywords(long groupId, String keywords, boolean onlyActives) {
		return studentProfilePersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords, onlyActives));
	}
	
	public List<Degree> getDegreesByOfferId(long studentProfileId){
		return degreeLocalService.getStudentProfileDegrees(studentProfileId);
	}
	
	public List<Long> getDegreesIdsByOfferId(long studentProfileId){
		return Arrays.stream(studentProfilePersistence.getDegreePrimaryKeys(studentProfileId)).boxed().collect(Collectors.toList());
	}
	
	public long getNewestStudentProfileId() {
		long studentProfileId = 0;
		
		DynamicQuery latestStudentDynamicQuery = dynamicQuery();
		Order order = OrderFactoryUtil.desc("createDate");
		latestStudentDynamicQuery.addOrder(order);
		latestStudentDynamicQuery.setLimit(0, 1);
		
		List<StudentProfile> students = dynamicQuery(latestStudentDynamicQuery);
		
		
		if (!students.isEmpty()) {
			studentProfileId = students.get(0).getStudentProfileId();
		}
		
		return studentProfileId;
	}
	
	public List<StudentProfile> getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(long groupId, 
			String keywords, String preference, long regionId, long degreeId, boolean onlyActives,  
			long newestId, int start, int end, OrderByComparator<StudentProfile> orderByComparator) {
		return studentProfilePersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords, preference, regionId, degreeId, onlyActives, newestId), 
				start, end, orderByComparator);
	}
	
	public long getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(long groupId, 
			String keywords, String preference,	long regionId, long degreeId, boolean onlyActives, long newestId) {
		return studentProfilePersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords, preference, regionId, degreeId, onlyActives, newestId));
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords, boolean onlyActives) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		
		if (onlyActives) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("active", true));
		}
		
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			
			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			
			dynamicQuery.add(disjunctionQuery);
		}
		
		return dynamicQuery;
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords, 
			String preference, long regionId, long degreeId, boolean onlyActives, long newestId) {
		
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
		Conjunction conjunctionQuery = RestrictionsFactoryUtil.conjunction();
		
		if (onlyActives) {
			conjunctionQuery.add(RestrictionsFactoryUtil.eq("active", true));
		}
		
		if (Validator.isNotNull(keywords)) {
			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			conjunctionQuery.add(disjunctionQuery);
		}
		
		if (Validator.isNotNull(newestId) && newestId != 0) {
			conjunctionQuery.add(RestrictionsFactoryUtil.le("studentProfileId", newestId));
		}
		
		if (Validator.isNotNull(preference) && !preference.isEmpty()) {
			conjunctionQuery.add(RestrictionsFactoryUtil.like("preference", "%" + preference + "%"));
		}
		
		if (Validator.isNotNull(regionId) && regionId != 0) {
			conjunctionQuery.add(RestrictionsFactoryUtil.like("regionId", regionId));
		}
		
		if (Validator.isNotNull(degreeId) && degreeId != 0) {
			List<StudentProfile> allStudentProfilesDegree = getDegreeStudentProfiles(degreeId);
			List<Long> studentProfileIds = new ArrayList<>();
			
			for (StudentProfile studentProfile : allStudentProfilesDegree) {
				studentProfileIds.add(studentProfile.getStudentProfileId());
			}
			
			conjunctionQuery.add(RestrictionsFactoryUtil.in("studentProfileId", studentProfileIds));
		}
		
		dynamicQuery.add(conjunctionQuery);
		
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