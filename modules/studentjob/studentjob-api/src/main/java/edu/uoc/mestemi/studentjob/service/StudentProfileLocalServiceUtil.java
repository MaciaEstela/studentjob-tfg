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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.StudentProfile;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for StudentProfile. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.StudentProfileLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StudentProfileLocalService
 * @generated
 */
public class StudentProfileLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.StudentProfileLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addDegreeStudentProfile(
		long degreeId, long studentProfileId) {

		getService().addDegreeStudentProfile(degreeId, studentProfileId);
	}

	public static void addDegreeStudentProfile(
		long degreeId, StudentProfile studentProfile) {

		getService().addDegreeStudentProfile(degreeId, studentProfile);
	}

	public static void addDegreeStudentProfiles(
		long degreeId, List<StudentProfile> studentProfiles) {

		getService().addDegreeStudentProfiles(degreeId, studentProfiles);
	}

	public static void addDegreeStudentProfiles(
		long degreeId, long[] studentProfileIds) {

		getService().addDegreeStudentProfiles(degreeId, studentProfileIds);
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
	public static StudentProfile addStudentProfile(
		StudentProfile studentProfile) {

		return getService().addStudentProfile(studentProfile);
	}

	public static void clearDegreeStudentProfiles(long degreeId) {
		getService().clearDegreeStudentProfiles(degreeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new student profile with the primary key. Does not add the student profile to the database.
	 *
	 * @param studentProfileId the primary key for the new student profile
	 * @return the new student profile
	 */
	public static StudentProfile createStudentProfile(long studentProfileId) {
		return getService().createStudentProfile(studentProfileId);
	}

	public static void deleteDegreeStudentProfile(
		long degreeId, long studentProfileId) {

		getService().deleteDegreeStudentProfile(degreeId, studentProfileId);
	}

	public static void deleteDegreeStudentProfile(
		long degreeId, StudentProfile studentProfile) {

		getService().deleteDegreeStudentProfile(degreeId, studentProfile);
	}

	public static void deleteDegreeStudentProfiles(
		long degreeId, List<StudentProfile> studentProfiles) {

		getService().deleteDegreeStudentProfiles(degreeId, studentProfiles);
	}

	public static void deleteDegreeStudentProfiles(
		long degreeId, long[] studentProfileIds) {

		getService().deleteDegreeStudentProfiles(degreeId, studentProfileIds);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static StudentProfile deleteStudentProfile(long studentProfileId)
		throws PortalException {

		return getService().deleteStudentProfile(studentProfileId);
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
	public static StudentProfile deleteStudentProfile(
		StudentProfile studentProfile) {

		return getService().deleteStudentProfile(studentProfile);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static StudentProfile fetchStudentProfile(long studentProfileId) {
		return getService().fetchStudentProfile(studentProfileId);
	}

	/**
	 * Returns the student profile matching the UUID and group.
	 *
	 * @param uuid the student profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchStudentProfileByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchStudentProfileByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the degreeIds of the degrees associated with the student profile.
	 *
	 * @param studentProfileId the studentProfileId of the student profile
	 * @return long[] the degreeIds of degrees associated with the student profile
	 */
	public static long[] getDegreePrimaryKeys(long studentProfileId) {
		return getService().getDegreePrimaryKeys(studentProfileId);
	}

	public static List<StudentProfile> getDegreeStudentProfiles(long degreeId) {
		return getService().getDegreeStudentProfiles(degreeId);
	}

	public static List<StudentProfile> getDegreeStudentProfiles(
		long degreeId, int start, int end) {

		return getService().getDegreeStudentProfiles(degreeId, start, end);
	}

	public static List<StudentProfile> getDegreeStudentProfiles(
		long degreeId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getService().getDegreeStudentProfiles(
			degreeId, start, end, orderByComparator);
	}

	public static int getDegreeStudentProfilesCount(long degreeId) {
		return getService().getDegreeStudentProfilesCount(degreeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the student profile with the primary key.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile
	 * @throws PortalException if a student profile with the primary key could not be found
	 */
	public static StudentProfile getStudentProfile(long studentProfileId)
		throws PortalException {

		return getService().getStudentProfile(studentProfileId);
	}

	/**
	 * Returns the student profile matching the UUID and group.
	 *
	 * @param uuid the student profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching student profile
	 * @throws PortalException if a matching student profile could not be found
	 */
	public static StudentProfile getStudentProfileByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getStudentProfileByUuidAndGroupId(uuid, groupId);
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
	public static List<StudentProfile> getStudentProfiles(int start, int end) {
		return getService().getStudentProfiles(start, end);
	}

	/**
	 * Returns all the student profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the student profiles
	 * @param companyId the primary key of the company
	 * @return the matching student profiles, or an empty list if no matches were found
	 */
	public static List<StudentProfile> getStudentProfilesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getStudentProfilesByUuidAndCompanyId(
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
	public static List<StudentProfile> getStudentProfilesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getService().getStudentProfilesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of student profiles.
	 *
	 * @return the number of student profiles
	 */
	public static int getStudentProfilesCount() {
		return getService().getStudentProfilesCount();
	}

	public static boolean hasDegreeStudentProfile(
		long degreeId, long studentProfileId) {

		return getService().hasDegreeStudentProfile(degreeId, studentProfileId);
	}

	public static boolean hasDegreeStudentProfiles(long degreeId) {
		return getService().hasDegreeStudentProfiles(degreeId);
	}

	public static void setDegreeStudentProfiles(
		long degreeId, long[] studentProfileIds) {

		getService().setDegreeStudentProfiles(degreeId, studentProfileIds);
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
	public static StudentProfile updateStudentProfile(
		StudentProfile studentProfile) {

		return getService().updateStudentProfile(studentProfile);
	}

	public static StudentProfileLocalService getService() {
		return _service;
	}

	private static volatile StudentProfileLocalService _service;

}