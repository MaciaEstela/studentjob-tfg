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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import edu.uoc.mestemi.studentjob.exception.NoSuchStudentProfileException;
import edu.uoc.mestemi.studentjob.model.StudentProfile;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the student profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentProfileUtil
 * @generated
 */
@ProviderType
public interface StudentProfilePersistence
	extends BasePersistence<StudentProfile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentProfileUtil} to access the student profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the student profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching student profiles
	 */
	public java.util.List<StudentProfile> findByUuid(String uuid);

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
	public java.util.List<StudentProfile> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<StudentProfile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

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
	public java.util.List<StudentProfile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public StudentProfile findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the first student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public StudentProfile fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public StudentProfile findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public StudentProfile fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where uuid = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public StudentProfile[] findByUuid_PrevAndNext(
			long studentProfileId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Removes all the student profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of student profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching student profiles
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the student profile where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStudentProfileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public StudentProfile findByUUID_G(String uuid, long groupId)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the student profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public StudentProfile fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the student profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public StudentProfile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the student profile where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the student profile that was removed
	 */
	public StudentProfile removeByUUID_G(String uuid, long groupId)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the number of student profiles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching student profiles
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching student profiles
	 */
	public java.util.List<StudentProfile> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<StudentProfile> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<StudentProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

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
	public java.util.List<StudentProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public StudentProfile findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the first student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public StudentProfile fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public StudentProfile findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public StudentProfile fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

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
	public StudentProfile[] findByUuid_C_PrevAndNext(
			long studentProfileId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Removes all the student profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching student profiles
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the student profiles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching student profiles
	 */
	public java.util.List<StudentProfile> findByGroupId(long groupId);

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
	public java.util.List<StudentProfile> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<StudentProfile> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

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
	public java.util.List<StudentProfile> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public StudentProfile findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public StudentProfile fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public StudentProfile findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public StudentProfile fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where groupId = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public StudentProfile[] findByGroupId_PrevAndNext(
			long studentProfileId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Removes all the student profiles where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of student profiles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching student profiles
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching student profiles
	 */
	public java.util.List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId);

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
	public java.util.List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end);

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
	public java.util.List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

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
	public java.util.List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public StudentProfile findByGroupIdAndUserId_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public StudentProfile fetchByGroupIdAndUserId_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	public StudentProfile findByGroupIdAndUserId_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	public StudentProfile fetchByGroupIdAndUserId_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

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
	public StudentProfile[] findByGroupIdAndUserId_PrevAndNext(
			long studentProfileId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
				orderByComparator)
		throws NoSuchStudentProfileException;

	/**
	 * Removes all the student profiles where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByGroupIdAndUserId(long groupId, long userId);

	/**
	 * Returns the number of student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching student profiles
	 */
	public int countByGroupIdAndUserId(long groupId, long userId);

	/**
	 * Caches the student profile in the entity cache if it is enabled.
	 *
	 * @param studentProfile the student profile
	 */
	public void cacheResult(StudentProfile studentProfile);

	/**
	 * Caches the student profiles in the entity cache if it is enabled.
	 *
	 * @param studentProfiles the student profiles
	 */
	public void cacheResult(java.util.List<StudentProfile> studentProfiles);

	/**
	 * Creates a new student profile with the primary key. Does not add the student profile to the database.
	 *
	 * @param studentProfileId the primary key for the new student profile
	 * @return the new student profile
	 */
	public StudentProfile create(long studentProfileId);

	/**
	 * Removes the student profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile that was removed
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public StudentProfile remove(long studentProfileId)
		throws NoSuchStudentProfileException;

	public StudentProfile updateImpl(StudentProfile studentProfile);

	/**
	 * Returns the student profile with the primary key or throws a <code>NoSuchStudentProfileException</code> if it could not be found.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	public StudentProfile findByPrimaryKey(long studentProfileId)
		throws NoSuchStudentProfileException;

	/**
	 * Returns the student profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile, or <code>null</code> if a student profile with the primary key could not be found
	 */
	public StudentProfile fetchByPrimaryKey(long studentProfileId);

	/**
	 * Returns all the student profiles.
	 *
	 * @return the student profiles
	 */
	public java.util.List<StudentProfile> findAll();

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
	public java.util.List<StudentProfile> findAll(int start, int end);

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
	public java.util.List<StudentProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

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
	public java.util.List<StudentProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the student profiles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of student profiles.
	 *
	 * @return the number of student profiles
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of degrees associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @return long[] of the primaryKeys of degrees associated with the student profile
	 */
	public long[] getDegreePrimaryKeys(long pk);

	/**
	 * Returns all the student profile associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the student profiles associated with the degree
	 */
	public java.util.List<StudentProfile> getDegreeStudentProfiles(long pk);

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
	public java.util.List<StudentProfile> getDegreeStudentProfiles(
		long pk, int start, int end);

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
	public java.util.List<StudentProfile> getDegreeStudentProfiles(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentProfile>
			orderByComparator);

	/**
	 * Returns the number of degrees associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @return the number of degrees associated with the student profile
	 */
	public int getDegreesSize(long pk);

	/**
	 * Returns <code>true</code> if the degree is associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePK the primary key of the degree
	 * @return <code>true</code> if the degree is associated with the student profile; <code>false</code> otherwise
	 */
	public boolean containsDegree(long pk, long degreePK);

	/**
	 * Returns <code>true</code> if the student profile has any degrees associated with it.
	 *
	 * @param pk the primary key of the student profile to check for associations with degrees
	 * @return <code>true</code> if the student profile has any degrees associated with it; <code>false</code> otherwise
	 */
	public boolean containsDegrees(long pk);

	/**
	 * Adds an association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePK the primary key of the degree
	 */
	public void addDegree(long pk, long degreePK);

	/**
	 * Adds an association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degree the degree
	 */
	public void addDegree(
		long pk, edu.uoc.mestemi.studentjob.model.Degree degree);

	/**
	 * Adds an association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePKs the primary keys of the degrees
	 */
	public void addDegrees(long pk, long[] degreePKs);

	/**
	 * Adds an association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degrees the degrees
	 */
	public void addDegrees(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees);

	/**
	 * Clears all associations between the student profile and its degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile to clear the associated degrees from
	 */
	public void clearDegrees(long pk);

	/**
	 * Removes the association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePK the primary key of the degree
	 */
	public void removeDegree(long pk, long degreePK);

	/**
	 * Removes the association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degree the degree
	 */
	public void removeDegree(
		long pk, edu.uoc.mestemi.studentjob.model.Degree degree);

	/**
	 * Removes the association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePKs the primary keys of the degrees
	 */
	public void removeDegrees(long pk, long[] degreePKs);

	/**
	 * Removes the association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degrees the degrees
	 */
	public void removeDegrees(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees);

	/**
	 * Sets the degrees associated with the student profile, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePKs the primary keys of the degrees to be associated with the student profile
	 */
	public void setDegrees(long pk, long[] degreePKs);

	/**
	 * Sets the degrees associated with the student profile, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degrees the degrees to be associated with the student profile
	 */
	public void setDegrees(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees);

}