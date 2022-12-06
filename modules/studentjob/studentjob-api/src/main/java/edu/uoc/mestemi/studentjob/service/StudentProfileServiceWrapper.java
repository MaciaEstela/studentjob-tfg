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

package edu.uoc.mestemi.studentjob.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudentProfileService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentProfileService
 * @generated
 */
public class StudentProfileServiceWrapper
	implements ServiceWrapper<StudentProfileService>, StudentProfileService {

	public StudentProfileServiceWrapper() {
		this(null);
	}

	public StudentProfileServiceWrapper(
		StudentProfileService studentProfileService) {

		_studentProfileService = studentProfileService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile addStudentProfile(
			long groupId, long userId, long regionId, boolean active,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String email, String preference, long curriculumId,
			java.util.List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileService.addStudentProfile(
			groupId, userId, regionId, active, titleMap, descriptionMap, email,
			preference, curriculumId, degreeIds, serviceContext);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile deleteStudentProfile(
			long studentProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileService.deleteStudentProfile(studentProfileId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _studentProfileService.getOSGiServiceIdentifier();
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile getStudentProfile(
			long socialMediaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileService.getStudentProfile(socialMediaId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile updateStudentProfile(
			long studentProfileId, long regionId, boolean active,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String email, String preference, long curriculumId,
			java.util.List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileService.updateStudentProfile(
			studentProfileId, regionId, active, titleMap, descriptionMap, email,
			preference, curriculumId, degreeIds, serviceContext);
	}

	@Override
	public StudentProfileService getWrappedService() {
		return _studentProfileService;
	}

	@Override
	public void setWrappedService(StudentProfileService studentProfileService) {
		_studentProfileService = studentProfileService;
	}

	private StudentProfileService _studentProfileService;

}