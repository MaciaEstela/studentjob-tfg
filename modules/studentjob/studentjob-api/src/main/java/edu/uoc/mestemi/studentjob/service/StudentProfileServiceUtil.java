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
import com.liferay.portal.kernel.util.OrderByComparator;

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
			long groupId, long userId, long regionId, boolean active,
			Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, String email,
			String preference, long curriculumId, List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addStudentProfile(
			groupId, userId, regionId, active, titleMap, descriptionMap, email,
			preference, curriculumId, degreeIds, serviceContext);
	}

	public static StudentProfile deleteStudentProfile(long studentProfileId)
		throws PortalException {

		return getService().deleteStudentProfile(studentProfileId);
	}

	public static List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByOfferId(long studentProfileId) {

		return getService().getDegreesByOfferId(studentProfileId);
	}

	public static List<Long> getDegreesIdsByOfferId(long studentProfileId) {
		return getService().getDegreesIdsByOfferId(studentProfileId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static StudentProfile getStudentProfile(long studentProfileId)
		throws PortalException {

		return getService().getStudentProfile(studentProfileId);
	}

	public static StudentProfile getStudentProfileByGroupIdAndUserId(
		long groupId, long userId) {

		return getService().getStudentProfileByGroupIdAndUserId(
			groupId, userId);
	}

	public static List<StudentProfile> getStudentProfilesByGroupId(
		long groupId) {

		return getService().getStudentProfilesByGroupId(groupId);
	}

	public static List<StudentProfile> getStudentProfilesByGroupId(
		long groupId, int start, int end) {

		return getService().getStudentProfilesByGroupId(groupId, start, end);
	}

	public static List<StudentProfile> getStudentProfilesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getService().getStudentProfilesByGroupId(
			groupId, start, end, orderByComparator);
	}

	public static List<StudentProfile> getStudentProfilesByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getService().getStudentProfilesByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public static List<StudentProfile>
		getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			long groupId, String keywords, String preference, long regionId,
			long degreeId, long newestId, int start, int end,
			OrderByComparator<StudentProfile> orderByComparator) {

		return getService().
			getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(
				groupId, keywords, preference, regionId, degreeId, newestId,
				start, end, orderByComparator);
	}

	public static long getStudentProfilesCountByKeywords(
		long groupId, String keywords) {

		return getService().getStudentProfilesCountByKeywords(
			groupId, keywords);
	}

	public static long
		getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			long groupId, String keywords, String preference, long regionId,
			long degreeId, long newestId) {

		return getService().
			getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
				groupId, keywords, preference, regionId, degreeId, newestId);
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