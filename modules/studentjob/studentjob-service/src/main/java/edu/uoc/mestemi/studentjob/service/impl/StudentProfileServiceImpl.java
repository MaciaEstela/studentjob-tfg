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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
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
	
	public StudentProfile addStudentProfile(long groupId, long regionId, boolean active, 
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, String preference, 
			long curriculumId, List<Long> degreeIds, ServiceContext serviceContext) throws PortalException {
		
		return studentProfileLocalService.addStudentProfile(groupId, regionId, active, 
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
	
	public StudentProfile getStudentProfile(long socialMediaId) throws PortalException {
		return studentProfileLocalService.getStudentProfile(socialMediaId);
	}
}