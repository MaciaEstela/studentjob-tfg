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

package edu.uoc.mestemi.studentjob.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.StudentProfile;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the student profile service. This utility wraps <code>edu.uoc.mestemi.studentjob.service.persistence.impl.StudentProfilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentProfilePersistence
 * @generated
 */
public class StudentProfileUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(StudentProfile studentProfile) {
		getPersistence().clearCache(studentProfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, StudentProfile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StudentProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StudentProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StudentProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StudentProfile update(StudentProfile studentProfile) {
		return getPersistence().update(studentProfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StudentProfile update(
		StudentProfile studentProfile, ServiceContext serviceContext) {

		return getPersistence().update(studentProfile, serviceContext);
	}

	/**
	 * Returns all the student profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching student profiles
	 */
	public static List<StudentProfile> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the student profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of matching student profiles
	 */
	public static List<StudentProfile> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the student profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student profiles
	 */
	public static List<StudentProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the student profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student profiles
	 */
	public static List<StudentProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByUuid_First(
			String uuid, OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByUuid_First(
		String uuid, OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByUuid_Last(
			String uuid, OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByUuid_Last(
		String uuid, OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where uuid = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public static StudentProfile[] findByUuid_PrevAndNext(
			long studentProfileId, String uuid,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByUuid_PrevAndNext(
			studentProfileId, uuid, orderByComparator);
	}

	/**
	 * Removes all the student profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of student profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching student profiles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the student profile where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStudentProfileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the student profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the student profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the student profile where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the student profile that was removed
	 */
	public static StudentProfile removeByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of student profiles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching student profiles
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching student profiles
	 */
	public static List<StudentProfile> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of matching student profiles
	 */
	public static List<StudentProfile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student profiles
	 */
	public static List<StudentProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student profiles
	 */
	public static List<StudentProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public static StudentProfile[] findByUuid_C_PrevAndNext(
			long studentProfileId, String uuid, long companyId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByUuid_C_PrevAndNext(
			studentProfileId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the student profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching student profiles
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the student profiles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching student profiles
	 */
	public static List<StudentProfile> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the student profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of matching student profiles
	 */
	public static List<StudentProfile> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student profiles
	 */
	public static List<StudentProfile> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student profiles
	 */
	public static List<StudentProfile> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByGroupId_First(
			long groupId, OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByGroupId_First(
		long groupId, OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByGroupId_Last(
			long groupId, OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByGroupId_Last(
		long groupId, OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where groupId = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public static StudentProfile[] findByGroupId_PrevAndNext(
			long studentProfileId, long groupId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByGroupId_PrevAndNext(
			studentProfileId, groupId, orderByComparator);
	}

	/**
	 * Removes all the student profiles where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of student profiles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching student profiles
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the student profiles where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @return the matching student profiles
	 */
	public static List<StudentProfile> findByGroupIdAndActive(
		long groupId, boolean active) {

		return getPersistence().findByGroupIdAndActive(groupId, active);
	}

	/**
	 * Returns a range of all the student profiles where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of matching student profiles
	 */
	public static List<StudentProfile> findByGroupIdAndActive(
		long groupId, boolean active, int start, int end) {

		return getPersistence().findByGroupIdAndActive(
			groupId, active, start, end);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student profiles
	 */
	public static List<StudentProfile> findByGroupIdAndActive(
		long groupId, boolean active, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().findByGroupIdAndActive(
			groupId, active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student profiles
	 */
	public static List<StudentProfile> findByGroupIdAndActive(
		long groupId, boolean active, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdAndActive(
			groupId, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByGroupIdAndActive_First(
			long groupId, boolean active,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByGroupIdAndActive_First(
			groupId, active, orderByComparator);
	}

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByGroupIdAndActive_First(
		long groupId, boolean active,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().fetchByGroupIdAndActive_First(
			groupId, active, orderByComparator);
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByGroupIdAndActive_Last(
			long groupId, boolean active,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByGroupIdAndActive_Last(
			groupId, active, orderByComparator);
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByGroupIdAndActive_Last(
		long groupId, boolean active,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().fetchByGroupIdAndActive_Last(
			groupId, active, orderByComparator);
	}

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public static StudentProfile[] findByGroupIdAndActive_PrevAndNext(
			long studentProfileId, long groupId, boolean active,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByGroupIdAndActive_PrevAndNext(
			studentProfileId, groupId, active, orderByComparator);
	}

	/**
	 * Removes all the student profiles where groupId = &#63; and active = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 */
	public static void removeByGroupIdAndActive(long groupId, boolean active) {
		getPersistence().removeByGroupIdAndActive(groupId, active);
	}

	/**
	 * Returns the number of student profiles where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @return the number of matching student profiles
	 */
	public static int countByGroupIdAndActive(long groupId, boolean active) {
		return getPersistence().countByGroupIdAndActive(groupId, active);
	}

	/**
	 * Returns all the student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching student profiles
	 */
	public static List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId) {

		return getPersistence().findByGroupIdAndUserId(groupId, userId);
	}

	/**
	 * Returns a range of all the student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of matching student profiles
	 */
	public static List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByGroupIdAndUserId(
			groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student profiles
	 */
	public static List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().findByGroupIdAndUserId(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student profiles
	 */
	public static List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdAndUserId(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByGroupIdAndUserId_First(
			long groupId, long userId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByGroupIdAndUserId_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByGroupIdAndUserId_First(
		long groupId, long userId,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().fetchByGroupIdAndUserId_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public static StudentProfile findByGroupIdAndUserId_Last(
			long groupId, long userId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByGroupIdAndUserId_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public static StudentProfile fetchByGroupIdAndUserId_Last(
		long groupId, long userId,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().fetchByGroupIdAndUserId_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public static StudentProfile[] findByGroupIdAndUserId_PrevAndNext(
			long studentProfileId, long groupId, long userId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByGroupIdAndUserId_PrevAndNext(
			studentProfileId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the student profiles where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByGroupIdAndUserId(long groupId, long userId) {
		getPersistence().removeByGroupIdAndUserId(groupId, userId);
	}

	/**
	 * Returns the number of student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching student profiles
	 */
	public static int countByGroupIdAndUserId(long groupId, long userId) {
		return getPersistence().countByGroupIdAndUserId(groupId, userId);
	}

	/**
	 * Caches the student profile in the entity cache if it is enabled.
	 *
	 * @param studentProfile the student profile
	 */
	public static void cacheResult(StudentProfile studentProfile) {
		getPersistence().cacheResult(studentProfile);
	}

	/**
	 * Caches the student profiles in the entity cache if it is enabled.
	 *
	 * @param studentProfiles the student profiles
	 */
	public static void cacheResult(List<StudentProfile> studentProfiles) {
		getPersistence().cacheResult(studentProfiles);
	}

	/**
	 * Creates a new student profile with the primary key. Does not add the student profile to the database.
	 *
	 * @param studentProfileId the primary key for the new student profile
	 * @return the new student profile
	 */
	public static StudentProfile create(long studentProfileId) {
		return getPersistence().create(studentProfileId);
	}

	/**
	 * Removes the student profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile that was removed
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public static StudentProfile remove(long studentProfileId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().remove(studentProfileId);
	}

	public static StudentProfile updateImpl(StudentProfile studentProfile) {
		return getPersistence().updateImpl(studentProfile);
	}

	/**
	 * Returns the student profile with the primary key or throws a <code>NoSuchStudentProfileException</code> if it could not be found.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public static StudentProfile findByPrimaryKey(long studentProfileId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchStudentProfileException {

		return getPersistence().findByPrimaryKey(studentProfileId);
	}

	/**
	 * Returns the student profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile, or <code>null</code> if a student profile with the primary key could not be found
	 */
	public static StudentProfile fetchByPrimaryKey(long studentProfileId) {
		return getPersistence().fetchByPrimaryKey(studentProfileId);
	}

	/**
	 * Returns all the student profiles.
	 *
	 * @return the student profiles
	 */
	public static List<StudentProfile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the student profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of student profiles
	 */
	public static List<StudentProfile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the student profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student profiles
	 */
	public static List<StudentProfile> findAll(
		int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the student profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of student profiles
	 */
	public static List<StudentProfile> findAll(
		int start, int end, OrderByComparator<StudentProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the student profiles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of student profiles.
	 *
	 * @return the number of student profiles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of degrees associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @return long[] of the primaryKeys of degrees associated with the student profile
	 */
	public static long[] getDegreePrimaryKeys(long pk) {
		return getPersistence().getDegreePrimaryKeys(pk);
	}

	/**
	 * Returns all the student profile associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the student profiles associated with the degree
	 */
	public static List<StudentProfile> getDegreeStudentProfiles(long pk) {
		return getPersistence().getDegreeStudentProfiles(pk);
	}

	/**
	 * Returns all the student profile associated with the degree.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the degree
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of student profiles associated with the degree
	 */
	public static List<StudentProfile> getDegreeStudentProfiles(
		long pk, int start, int end) {

		return getPersistence().getDegreeStudentProfiles(pk, start, end);
	}

	/**
	 * Returns all the student profile associated with the degree.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the degree
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student profiles associated with the degree
	 */
	public static List<StudentProfile> getDegreeStudentProfiles(
		long pk, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return getPersistence().getDegreeStudentProfiles(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of degrees associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @return the number of degrees associated with the student profile
	 */
	public static int getDegreesSize(long pk) {
		return getPersistence().getDegreesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the degree is associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePK the primary key of the degree
	 * @return <code>true</code> if the degree is associated with the student profile; <code>false</code> otherwise
	 */
	public static boolean containsDegree(long pk, long degreePK) {
		return getPersistence().containsDegree(pk, degreePK);
	}

	/**
	 * Returns <code>true</code> if the student profile has any degrees associated with it.
	 *
	 * @param pk the primary key of the student profile to check for associations with degrees
	 * @return <code>true</code> if the student profile has any degrees associated with it; <code>false</code> otherwise
	 */
	public static boolean containsDegrees(long pk) {
		return getPersistence().containsDegrees(pk);
	}

	/**
	 * Adds an association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePK the primary key of the degree
	 */
	public static void addDegree(long pk, long degreePK) {
		getPersistence().addDegree(pk, degreePK);
	}

	/**
	 * Adds an association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degree the degree
	 */
	public static void addDegree(
		long pk, edu.uoc.mestemi.studentjob.model.Degree degree) {

		getPersistence().addDegree(pk, degree);
	}

	/**
	 * Adds an association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePKs the primary keys of the degrees
	 */
	public static void addDegrees(long pk, long[] degreePKs) {
		getPersistence().addDegrees(pk, degreePKs);
	}

	/**
	 * Adds an association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degrees the degrees
	 */
	public static void addDegrees(
		long pk, List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		getPersistence().addDegrees(pk, degrees);
	}

	/**
	 * Clears all associations between the student profile and its degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile to clear the associated degrees from
	 */
	public static void clearDegrees(long pk) {
		getPersistence().clearDegrees(pk);
	}

	/**
	 * Removes the association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePK the primary key of the degree
	 */
	public static void removeDegree(long pk, long degreePK) {
		getPersistence().removeDegree(pk, degreePK);
	}

	/**
	 * Removes the association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degree the degree
	 */
	public static void removeDegree(
		long pk, edu.uoc.mestemi.studentjob.model.Degree degree) {

		getPersistence().removeDegree(pk, degree);
	}

	/**
	 * Removes the association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePKs the primary keys of the degrees
	 */
	public static void removeDegrees(long pk, long[] degreePKs) {
		getPersistence().removeDegrees(pk, degreePKs);
	}

	/**
	 * Removes the association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degrees the degrees
	 */
	public static void removeDegrees(
		long pk, List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		getPersistence().removeDegrees(pk, degrees);
	}

	/**
	 * Sets the degrees associated with the student profile, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePKs the primary keys of the degrees to be associated with the student profile
	 */
	public static void setDegrees(long pk, long[] degreePKs) {
		getPersistence().setDegrees(pk, degreePKs);
	}

	/**
	 * Sets the degrees associated with the student profile, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degrees the degrees to be associated with the student profile
	 */
	public static void setDegrees(
		long pk, List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		getPersistence().setDegrees(pk, degrees);
	}

	public static StudentProfilePersistence getPersistence() {
		return _persistence;
	}

	private static volatile StudentProfilePersistence _persistence;

}