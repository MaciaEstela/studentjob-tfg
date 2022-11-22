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

import com.liferay.portal.kernel.exception.PortalException;

import edu.uoc.mestemi.studentjob.model.StudentProfile;

import java.util.List;
import java.util.Map;

/**
 * Provides the remote service utility for StudentProfile. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.StudentProfileServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see StudentProfileService
 * @generated
 */
public class StudentProfileServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.StudentProfileServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static StudentProfile addStudentProfile(
			long groupId, long regionId, boolean active,
			Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, String email,
			String preference, long curriculumId, List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addStudentProfile(
			groupId, regionId, active, titleMap, descriptionMap, email,
			preference, curriculumId, degreeIds, serviceContext);
	}

	public static StudentProfile deleteStudentProfile(long studentProfileId)
		throws PortalException {

		return getService().deleteStudentProfile(studentProfileId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static StudentProfile getStudentProfile(long socialMediaId)
		throws PortalException {

		return getService().getStudentProfile(socialMediaId);
	}

	public static StudentProfile updateStudentProfile(
			long studentProfileId, long regionId, boolean active,
			Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, String email,
			String preference, long curriculumId, List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStudentProfile(
			studentProfileId, regionId, active, titleMap, descriptionMap, email,
			preference, curriculumId, degreeIds, serviceContext);
	}

	public static StudentProfileService getService() {
		return _service;
	}

	private static volatile StudentProfileService _service;

}