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
 * Provides a wrapper for {@link StudentProfileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentProfileLocalService
 * @generated
 */
public class StudentProfileLocalServiceWrapper
	implements ServiceWrapper<StudentProfileLocalService>,
			   StudentProfileLocalService {

	public StudentProfileLocalServiceWrapper() {
		this(null);
	}

	public StudentProfileLocalServiceWrapper(
		StudentProfileLocalService studentProfileLocalService) {

		_studentProfileLocalService = studentProfileLocalService;
	}

	@Override
	public void addDegreeStudentProfile(long degreeId, long studentProfileId) {
		_studentProfileLocalService.addDegreeStudentProfile(
			degreeId, studentProfileId);
	}

	@Override
	public void addDegreeStudentProfile(
		long degreeId,
		edu.uoc.mestemi.studentjob.model.StudentProfile studentProfile) {

		_studentProfileLocalService.addDegreeStudentProfile(
			degreeId, studentProfile);
	}

	@Override
	public void addDegreeStudentProfiles(
		long degreeId,
		java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
			studentProfiles) {

		_studentProfileLocalService.addDegreeStudentProfiles(
			degreeId, studentProfiles);
	}

	@Override
	public void addDegreeStudentProfiles(
		long degreeId, long[] studentProfileIds) {

		_studentProfileLocalService.addDegreeStudentProfiles(
			degreeId, studentProfileIds);
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

		return _studentProfileLocalService.addStudentProfile(
			groupId, userId, regionId, active, titleMap, descriptionMap, email,
			preference, curriculumId, degreeIds, serviceContext);
	}

	/**
	 * Adds the student profile to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studentProfile the student profile
	 * @return the student profile that was added
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile addStudentProfile(
		edu.uoc.mestemi.studentjob.model.StudentProfile studentProfile) {

		return _studentProfileLocalService.addStudentProfile(studentProfile);
	}

	@Override
	public void clearDegreeStudentProfiles(long degreeId) {
		_studentProfileLocalService.clearDegreeStudentProfiles(degreeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new student profile with the primary key. Does not add the student profile to the database.
	 *
	 * @param studentProfileId the primary key for the new student profile
	 * @return the new student profile
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile createStudentProfile(
		long studentProfileId) {

		return _studentProfileLocalService.createStudentProfile(
			studentProfileId);
	}

	@Override
	public void deleteDegreeStudentProfile(
		long degreeId, long studentProfileId) {

		_studentProfileLocalService.deleteDegreeStudentProfile(
			degreeId, studentProfileId);
	}

	@Override
	public void deleteDegreeStudentProfile(
		long degreeId,
		edu.uoc.mestemi.studentjob.model.StudentProfile studentProfile) {

		_studentProfileLocalService.deleteDegreeStudentProfile(
			degreeId, studentProfile);
	}

	@Override
	public void deleteDegreeStudentProfiles(
		long degreeId,
		java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
			studentProfiles) {

		_studentProfileLocalService.deleteDegreeStudentProfiles(
			degreeId, studentProfiles);
	}

	@Override
	public void deleteDegreeStudentProfiles(
		long degreeId, long[] studentProfileIds) {

		_studentProfileLocalService.deleteDegreeStudentProfiles(
			degreeId, studentProfileIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the student profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile that was removed
	 * @throws PortalException if a student profile with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile deleteStudentProfile(
			long studentProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileLocalService.deleteStudentProfile(
			studentProfileId);
	}

	/**
	 * Deletes the student profile from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studentProfile the student profile
	 * @return the student profile that was removed
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile deleteStudentProfile(
		edu.uoc.mestemi.studentjob.model.StudentProfile studentProfile) {

		return _studentProfileLocalService.deleteStudentProfile(studentProfile);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _studentProfileLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _studentProfileLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studentProfileLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _studentProfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _studentProfileLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _studentProfileLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _studentProfileLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _studentProfileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile fetchStudentProfile(
		long studentProfileId) {

		return _studentProfileLocalService.fetchStudentProfile(
			studentProfileId);
	}

	/**
	 * Returns the student profile matching the UUID and group.
	 *
	 * @param uuid the student profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile
		fetchStudentProfileByUuidAndGroupId(String uuid, long groupId) {

		return _studentProfileLocalService.fetchStudentProfileByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _studentProfileLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the degreeIds of the degrees associated with the student profile.
	 *
	 * @param studentProfileId the studentProfileId of the student profile
	 * @return long[] the degreeIds of degrees associated with the student profile
	 */
	@Override
	public long[] getDegreePrimaryKeys(long studentProfileId) {
		return _studentProfileLocalService.getDegreePrimaryKeys(
			studentProfileId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByOfferId(long studentProfileId) {

		return _studentProfileLocalService.getDegreesByOfferId(
			studentProfileId);
	}

	@Override
	public java.util.List<Long> getDegreesIdsByOfferId(long studentProfileId) {
		return _studentProfileLocalService.getDegreesIdsByOfferId(
			studentProfileId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getDegreeStudentProfiles(long degreeId) {

		return _studentProfileLocalService.getDegreeStudentProfiles(degreeId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getDegreeStudentProfiles(long degreeId, int start, int end) {

		return _studentProfileLocalService.getDegreeStudentProfiles(
			degreeId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getDegreeStudentProfiles(
			long degreeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.StudentProfile>
					orderByComparator) {

		return _studentProfileLocalService.getDegreeStudentProfiles(
			degreeId, start, end, orderByComparator);
	}

	@Override
	public int getDegreeStudentProfilesCount(long degreeId) {
		return _studentProfileLocalService.getDegreeStudentProfilesCount(
			degreeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _studentProfileLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _studentProfileLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public long getNewestStudentProfileId() {
		return _studentProfileLocalService.getNewestStudentProfileId();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _studentProfileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the student profile with the primary key.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile
	 * @throws PortalException if a student profile with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile getStudentProfile(
			long studentProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileLocalService.getStudentProfile(studentProfileId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile
		getStudentProfileByGroupIdAndUserId(long groupId, long userId) {

		return _studentProfileLocalService.getStudentProfileByGroupIdAndUserId(
			groupId, userId);
	}

	/**
	 * Returns the student profile matching the UUID and group.
	 *
	 * @param uuid the student profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching student profile
	 * @throws PortalException if a matching student profile could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile
			getStudentProfileByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentProfileLocalService.getStudentProfileByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the student profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of student profiles
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfiles(int start, int end) {

		return _studentProfileLocalService.getStudentProfiles(start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfilesByGroupId(long groupId) {

		return _studentProfileLocalService.getStudentProfilesByGroupId(groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfilesByGroupId(long groupId, int start, int end) {

		return _studentProfileLocalService.getStudentProfilesByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfilesByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.StudentProfile>
					orderByComparator) {

		return _studentProfileLocalService.getStudentProfilesByGroupId(
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

		return _studentProfileLocalService.getStudentProfilesByKeywords(
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

		return _studentProfileLocalService.
			getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(
				groupId, keywords, preference, regionId, degreeId, onlyActives,
				newestId, start, end, orderByComparator);
	}

	/**
	 * Returns all the student profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the student profiles
	 * @param companyId the primary key of the company
	 * @return the matching student profiles, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfilesByUuidAndCompanyId(String uuid, long companyId) {

		return _studentProfileLocalService.getStudentProfilesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of student profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the student profiles
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching student profiles, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
		getStudentProfilesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.StudentProfile>
					orderByComparator) {

		return _studentProfileLocalService.getStudentProfilesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of student profiles.
	 *
	 * @return the number of student profiles
	 */
	@Override
	public int getStudentProfilesCount() {
		return _studentProfileLocalService.getStudentProfilesCount();
	}

	@Override
	public long getStudentProfilesCountByKeywords(
		long groupId, String keywords, boolean onlyActives) {

		return _studentProfileLocalService.getStudentProfilesCountByKeywords(
			groupId, keywords, onlyActives);
	}

	@Override
	public long
		getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			long groupId, String keywords, String preference, long regionId,
			long degreeId, boolean onlyActives, long newestId) {

		return _studentProfileLocalService.
			getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
				groupId, keywords, preference, regionId, degreeId, onlyActives,
				newestId);
	}

	@Override
	public boolean hasDegreeStudentProfile(
		long degreeId, long studentProfileId) {

		return _studentProfileLocalService.hasDegreeStudentProfile(
			degreeId, studentProfileId);
	}

	@Override
	public boolean hasDegreeStudentProfiles(long degreeId) {
		return _studentProfileLocalService.hasDegreeStudentProfiles(degreeId);
	}

	@Override
	public void setDegreeStudentProfiles(
		long degreeId, long[] studentProfileIds) {

		_studentProfileLocalService.setDegreeStudentProfiles(
			degreeId, studentProfileIds);
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

		return _studentProfileLocalService.updateStudentProfile(
			studentProfileId, regionId, active, titleMap, descriptionMap, email,
			preference, curriculumId, degreeIds, serviceContext);
	}

	/**
	 * Updates the student profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studentProfile the student profile
	 * @return the student profile that was updated
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.StudentProfile updateStudentProfile(
		edu.uoc.mestemi.studentjob.model.StudentProfile studentProfile) {

		return _studentProfileLocalService.updateStudentProfile(studentProfile);
	}

	@Override
	public StudentProfileLocalService getWrappedService() {
		return _studentProfileLocalService;
	}

	@Override
	public void setWrappedService(
		StudentProfileLocalService studentProfileLocalService) {

		_studentProfileLocalService = studentProfileLocalService;
	}

	private StudentProfileLocalService _studentProfileLocalService;

}