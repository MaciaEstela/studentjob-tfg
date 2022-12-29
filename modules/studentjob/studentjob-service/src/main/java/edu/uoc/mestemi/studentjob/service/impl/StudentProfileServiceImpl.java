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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.service.base.StudentProfileServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sjob",
		"json.web.service.context.path=StudentProfile"
	},
	service = AopService.class
)
public class StudentProfileServiceImpl extends StudentProfileServiceBaseImpl {
	
	public StudentProfile addStudentProfile(long groupId, long userId, long regionId, boolean active, 
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, String preference, 
			long curriculumId, List<Long> degreeIds, ServiceContext serviceContext) throws PortalException {
		
		return studentProfileLocalService.addStudentProfile(groupId, userId, regionId, active, 
				titleMap, descriptionMap, email, preference, curriculumId, degreeIds, serviceContext);
	}
	
	public StudentProfile updateStudentProfile(long studentProfileId, long regionId, boolean active, 
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, String preference, 
			long curriculumId, List<Long> degreeIds, ServiceContext serviceContext) 
					throws PortalException {
		
		return studentProfileLocalService.updateStudentProfile(studentProfileId, regionId, active, 
				titleMap, descriptionMap, email, preference, curriculumId, degreeIds, serviceContext);
	}
	
	public StudentProfile deleteStudentProfile(long studentProfileId) throws PortalException{
		return studentProfileLocalService.deleteStudentProfile(studentProfileId);
	}
	
	public StudentProfile getStudentProfile(long studentProfileId) throws PortalException {
		return studentProfileLocalService.getStudentProfile(studentProfileId);
	}
	
	public StudentProfile getStudentProfileByGroupIdAndUserId(long groupId, long userId) {
		return studentProfileLocalService.getStudentProfileByGroupIdAndUserId(groupId, userId);
	}
	
	public List<StudentProfile> getStudentProfilesByGroupId(long groupId) {
		return studentProfileLocalService.getStudentProfilesByGroupId(groupId);
	}
	
	public List<StudentProfile> getStudentProfilesByGroupId(long groupId, int start, int end) {
		return studentProfileLocalService.getStudentProfilesByGroupId(groupId, start, end);
	}
	
	public List<Degree> getDegreesByOfferId(long studentProfileId){
		return studentProfileLocalService.getDegreesByOfferId(studentProfileId);
	}
	
	public List<Long> getDegreesIdsByOfferId(long studentProfileId){
		return studentProfileLocalService.getDegreesIdsByOfferId(studentProfileId);
	}
	
	public List<StudentProfile> getStudentProfilesByGroupId(long groupId, int start, int end, 
			OrderByComparator<StudentProfile> orderByComparator) {
		return studentProfileLocalService.getStudentProfilesByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<StudentProfile> getStudentProfilesByKeywords(long groupId, String keywords, boolean onlyActives, int start, 
			int end, OrderByComparator<StudentProfile> orderByComparator) {
		return studentProfileLocalService.getStudentProfilesByKeywords(groupId, keywords, onlyActives, start, end, orderByComparator);
	}
	
	public long getStudentProfilesCountByKeywords(long groupId, String keywords, boolean onlyActives) {
		return studentProfileLocalService.getStudentProfilesCountByKeywords(groupId, keywords, onlyActives);
	}
	
	public long getNewestStudentProfileId() {
		return studentProfileLocalService.getNewestStudentProfileId();
	}
	
	public List<StudentProfile> getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(long groupId, 
			String keywords, String preference, long regionId, long degreeId, boolean onlyActives, 
			long newestId, int start, int end, OrderByComparator<StudentProfile> orderByComparator) {
		return studentProfileLocalService.getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(groupId, 
				keywords, preference, regionId, degreeId, onlyActives, newestId, start, end, orderByComparator);
	}
	
	public long getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(long groupId, 
			String keywords, String preference,	long regionId, long degreeId, boolean onlyActives, long newestId) {
		return studentProfileLocalService.getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(groupId, 
				keywords, preference, regionId, degreeId, onlyActives, newestId);
	}
	
}