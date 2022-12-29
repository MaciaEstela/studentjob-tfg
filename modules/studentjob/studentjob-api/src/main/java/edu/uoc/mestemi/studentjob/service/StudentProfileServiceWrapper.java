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

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByOfferId(long studentProfileId) {

		return _studentProfileService.getDegreesByOfferId(studentProfileId);
	}

	@Override
	public java.util.List<Long> getDegreesIdsByOfferId(long studentProfileId) {
		return _studentProfileService.getDegreesIdsByOfferId(studentProfileId);
	}

	@Override
	public long getNewestStudentProfileId() {
		return _studentProfileService.getNewestStudentProfileId();
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
			long studentProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileService.getStudentProfile(studentProfileId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile
		getStudentProfileByGroupIdAndUserId(long groupId, long userId) {

		return _studentProfileService.getStudentProfileByGroupIdAndUserId(
			groupId, userId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfilesByGroupId(long groupId) {

		return _studentProfileService.getStudentProfilesByGroupId(groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfilesByGroupId(long groupId, int start, int end) {

		return _studentProfileService.getStudentProfilesByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfilesByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.StudentProfile>
					orderByComparator) {

		return _studentProfileService.getStudentProfilesByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfilesByKeywords(
			long groupId, String keywords, boolean onlyActives, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.StudentProfile>
					orderByComparator) {

		return _studentProfileService.getStudentProfilesByKeywords(
			groupId, keywords, onlyActives, start, end, orderByComparator);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			long groupId, String keywords, String preference, long regionId,
			long degreeId, boolean onlyActives, long newestId, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.StudentProfile>
					orderByComparator) {

		return _studentProfileService.
			getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(
				groupId, keywords, preference, regionId, degreeId, onlyActives,
				newestId, start, end, orderByComparator);
	}

	@Override
	public long getStudentProfilesCountByKeywords(
		long groupId, String keywords, boolean onlyActives) {

		return _studentProfileService.getStudentProfilesCountByKeywords(
			groupId, keywords, onlyActives);
	}

	@Override
	public long
		getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			long groupId, String keywords, String preference, long regionId,
			long degreeId, boolean onlyActives, long newestId) {

		return _studentProfileService.
			getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
				groupId, keywords, preference, regionId, degreeId, onlyActives,
				newestId);
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