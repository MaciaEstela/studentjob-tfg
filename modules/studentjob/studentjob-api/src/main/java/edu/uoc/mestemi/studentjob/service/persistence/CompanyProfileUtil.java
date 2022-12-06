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

import edu.uoc.mestemi.studentjob.model.CompanyProfile;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the company profile service. This utility wraps <code>edu.uoc.mestemi.studentjob.service.persistence.impl.CompanyProfilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompanyProfilePersistence
 * @generated
 */
public class CompanyProfileUtil {

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
	public static void clearCache(CompanyProfile companyProfile) {
		getPersistence().clearCache(companyProfile);
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
	public static Map<Serializable, CompanyProfile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CompanyProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CompanyProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CompanyProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CompanyProfile update(CompanyProfile companyProfile) {
		return getPersistence().update(companyProfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CompanyProfile update(
		CompanyProfile companyProfile, ServiceContext serviceContext) {

		return getPersistence().update(companyProfile, serviceContext);
	}

	/**
	 * Returns all the company profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching company profiles
	 */
	public static List<CompanyProfile> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the company profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @return the range of matching company profiles
	 */
	public static List<CompanyProfile> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the company profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching company profiles
	 */
	public static List<CompanyProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the company profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching company profiles
	 */
	public static List<CompanyProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public static CompanyProfile findByUuid_First(
			String uuid, OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchByUuid_First(
		String uuid, OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public static CompanyProfile findByUuid_Last(
			String uuid, OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchByUuid_Last(
		String uuid, OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the company profiles before and after the current company profile in the ordered set where uuid = &#63;.
	 *
	 * @param companyProfileId the primary key of the current company profile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	public static CompanyProfile[] findByUuid_PrevAndNext(
			long companyProfileId, String uuid,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByUuid_PrevAndNext(
			companyProfileId, uuid, orderByComparator);
	}

	/**
	 * Removes all the company profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of company profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching company profiles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the company profile where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCompanyProfileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public static CompanyProfile findByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the company profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the company profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the company profile where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the company profile that was removed
	 */
	public static CompanyProfile removeByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of company profiles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching company profiles
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the company profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching company profiles
	 */
	public static List<CompanyProfile> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the company profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @return the range of matching company profiles
	 */
	public static List<CompanyProfile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the company profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching company profiles
	 */
	public static List<CompanyProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the company profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching company profiles
	 */
	public static List<CompanyProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public static CompanyProfile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public static CompanyProfile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the company profiles before and after the current company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param companyProfileId the primary key of the current company profile
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	public static CompanyProfile[] findByUuid_C_PrevAndNext(
			long companyProfileId, String uuid, long companyId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByUuid_C_PrevAndNext(
			companyProfileId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the company profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of company profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching company profiles
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the company profiles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching company profiles
	 */
	public static List<CompanyProfile> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the company profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @return the range of matching company profiles
	 */
	public static List<CompanyProfile> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the company profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching company profiles
	 */
	public static List<CompanyProfile> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the company profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching company profiles
	 */
	public static List<CompanyProfile> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first company profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public static CompanyProfile findByGroupId_First(
			long groupId, OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first company profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchByGroupId_First(
		long groupId, OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last company profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public static CompanyProfile findByGroupId_Last(
			long groupId, OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last company profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchByGroupId_Last(
		long groupId, OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the company profiles before and after the current company profile in the ordered set where groupId = &#63;.
	 *
	 * @param companyProfileId the primary key of the current company profile
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	public static CompanyProfile[] findByGroupId_PrevAndNext(
			long companyProfileId, long groupId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByGroupId_PrevAndNext(
			companyProfileId, groupId, orderByComparator);
	}

	/**
	 * Removes all the company profiles where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of company profiles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching company profiles
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the company profiles where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching company profiles
	 */
	public static List<CompanyProfile> findByGroupIdAndUserId(
		long groupId, long userId) {

		return getPersistence().findByGroupIdAndUserId(groupId, userId);
	}

	/**
	 * Returns a range of all the company profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @return the range of matching company profiles
	 */
	public static List<CompanyProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByGroupIdAndUserId(
			groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the company profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching company profiles
	 */
	public static List<CompanyProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().findByGroupIdAndUserId(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the company profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching company profiles
	 */
	public static List<CompanyProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdAndUserId(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first company profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public static CompanyProfile findByGroupIdAndUserId_First(
			long groupId, long userId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByGroupIdAndUserId_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first company profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchByGroupIdAndUserId_First(
		long groupId, long userId,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().fetchByGroupIdAndUserId_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last company profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public static CompanyProfile findByGroupIdAndUserId_Last(
			long groupId, long userId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByGroupIdAndUserId_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last company profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchByGroupIdAndUserId_Last(
		long groupId, long userId,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().fetchByGroupIdAndUserId_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the company profiles before and after the current company profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param companyProfileId the primary key of the current company profile
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	public static CompanyProfile[] findByGroupIdAndUserId_PrevAndNext(
			long companyProfileId, long groupId, long userId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByGroupIdAndUserId_PrevAndNext(
			companyProfileId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the company profiles where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByGroupIdAndUserId(long groupId, long userId) {
		getPersistence().removeByGroupIdAndUserId(groupId, userId);
	}

	/**
	 * Returns the number of company profiles where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching company profiles
	 */
	public static int countByGroupIdAndUserId(long groupId, long userId) {
		return getPersistence().countByGroupIdAndUserId(groupId, userId);
	}

	/**
	 * Caches the company profile in the entity cache if it is enabled.
	 *
	 * @param companyProfile the company profile
	 */
	public static void cacheResult(CompanyProfile companyProfile) {
		getPersistence().cacheResult(companyProfile);
	}

	/**
	 * Caches the company profiles in the entity cache if it is enabled.
	 *
	 * @param companyProfiles the company profiles
	 */
	public static void cacheResult(List<CompanyProfile> companyProfiles) {
		getPersistence().cacheResult(companyProfiles);
	}

	/**
	 * Creates a new company profile with the primary key. Does not add the company profile to the database.
	 *
	 * @param companyProfileId the primary key for the new company profile
	 * @return the new company profile
	 */
	public static CompanyProfile create(long companyProfileId) {
		return getPersistence().create(companyProfileId);
	}

	/**
	 * Removes the company profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile that was removed
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	public static CompanyProfile remove(long companyProfileId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().remove(companyProfileId);
	}

	public static CompanyProfile updateImpl(CompanyProfile companyProfile) {
		return getPersistence().updateImpl(companyProfile);
	}

	/**
	 * Returns the company profile with the primary key or throws a <code>NoSuchCompanyProfileException</code> if it could not be found.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	public static CompanyProfile findByPrimaryKey(long companyProfileId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchCompanyProfileException {

		return getPersistence().findByPrimaryKey(companyProfileId);
	}

	/**
	 * Returns the company profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile, or <code>null</code> if a company profile with the primary key could not be found
	 */
	public static CompanyProfile fetchByPrimaryKey(long companyProfileId) {
		return getPersistence().fetchByPrimaryKey(companyProfileId);
	}

	/**
	 * Returns all the company profiles.
	 *
	 * @return the company profiles
	 */
	public static List<CompanyProfile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the company profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @return the range of company profiles
	 */
	public static List<CompanyProfile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the company profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of company profiles
	 */
	public static List<CompanyProfile> findAll(
		int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the company profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of company profiles
	 */
	public static List<CompanyProfile> findAll(
		int start, int end, OrderByComparator<CompanyProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the company profiles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of company profiles.
	 *
	 * @return the number of company profiles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CompanyProfilePersistence getPersistence() {
		return _persistence;
	}

	private static volatile CompanyProfilePersistence _persistence;

}