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

import edu.uoc.mestemi.studentjob.model.DegreeArea;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the degree area service. This utility wraps <code>edu.uoc.mestemi.studentjob.service.persistence.impl.DegreeAreaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DegreeAreaPersistence
 * @generated
 */
public class DegreeAreaUtil {

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
	public static void clearCache(DegreeArea degreeArea) {
		getPersistence().clearCache(degreeArea);
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
	public static Map<Serializable, DegreeArea> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DegreeArea> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DegreeArea> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DegreeArea> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DegreeArea update(DegreeArea degreeArea) {
		return getPersistence().update(degreeArea);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DegreeArea update(
		DegreeArea degreeArea, ServiceContext serviceContext) {

		return getPersistence().update(degreeArea, serviceContext);
	}

	/**
	 * Returns all the degree areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching degree areas
	 */
	public static List<DegreeArea> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the degree areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @return the range of matching degree areas
	 */
	public static List<DegreeArea> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the degree areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching degree areas
	 */
	public static List<DegreeArea> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the degree areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching degree areas
	 */
	public static List<DegreeArea> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	public static DegreeArea findByUuid_First(
			String uuid, OrderByComparator<DegreeArea> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public static DegreeArea fetchByUuid_First(
		String uuid, OrderByComparator<DegreeArea> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	public static DegreeArea findByUuid_Last(
			String uuid, OrderByComparator<DegreeArea> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public static DegreeArea fetchByUuid_Last(
		String uuid, OrderByComparator<DegreeArea> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the degree areas before and after the current degree area in the ordered set where uuid = &#63;.
	 *
	 * @param degreeAreaId the primary key of the current degree area
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next degree area
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	public static DegreeArea[] findByUuid_PrevAndNext(
			long degreeAreaId, String uuid,
			OrderByComparator<DegreeArea> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException {

		return getPersistence().findByUuid_PrevAndNext(
			degreeAreaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the degree areas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of degree areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching degree areas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the degree area where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDegreeAreaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	public static DegreeArea findByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the degree area where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public static DegreeArea fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the degree area where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public static DegreeArea fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the degree area where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the degree area that was removed
	 */
	public static DegreeArea removeByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of degree areas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching degree areas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the degree areas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching degree areas
	 */
	public static List<DegreeArea> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the degree areas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @return the range of matching degree areas
	 */
	public static List<DegreeArea> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the degree areas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching degree areas
	 */
	public static List<DegreeArea> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the degree areas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching degree areas
	 */
	public static List<DegreeArea> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	public static DegreeArea findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DegreeArea> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public static DegreeArea fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DegreeArea> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	public static DegreeArea findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DegreeArea> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public static DegreeArea fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DegreeArea> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the degree areas before and after the current degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param degreeAreaId the primary key of the current degree area
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next degree area
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	public static DegreeArea[] findByUuid_C_PrevAndNext(
			long degreeAreaId, String uuid, long companyId,
			OrderByComparator<DegreeArea> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			degreeAreaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the degree areas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of degree areas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching degree areas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the degree area in the entity cache if it is enabled.
	 *
	 * @param degreeArea the degree area
	 */
	public static void cacheResult(DegreeArea degreeArea) {
		getPersistence().cacheResult(degreeArea);
	}

	/**
	 * Caches the degree areas in the entity cache if it is enabled.
	 *
	 * @param degreeAreas the degree areas
	 */
	public static void cacheResult(List<DegreeArea> degreeAreas) {
		getPersistence().cacheResult(degreeAreas);
	}

	/**
	 * Creates a new degree area with the primary key. Does not add the degree area to the database.
	 *
	 * @param degreeAreaId the primary key for the new degree area
	 * @return the new degree area
	 */
	public static DegreeArea create(long degreeAreaId) {
		return getPersistence().create(degreeAreaId);
	}

	/**
	 * Removes the degree area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area that was removed
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	public static DegreeArea remove(long degreeAreaId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException {

		return getPersistence().remove(degreeAreaId);
	}

	public static DegreeArea updateImpl(DegreeArea degreeArea) {
		return getPersistence().updateImpl(degreeArea);
	}

	/**
	 * Returns the degree area with the primary key or throws a <code>NoSuchDegreeAreaException</code> if it could not be found.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	public static DegreeArea findByPrimaryKey(long degreeAreaId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException {

		return getPersistence().findByPrimaryKey(degreeAreaId);
	}

	/**
	 * Returns the degree area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area, or <code>null</code> if a degree area with the primary key could not be found
	 */
	public static DegreeArea fetchByPrimaryKey(long degreeAreaId) {
		return getPersistence().fetchByPrimaryKey(degreeAreaId);
	}

	/**
	 * Returns all the degree areas.
	 *
	 * @return the degree areas
	 */
	public static List<DegreeArea> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the degree areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @return the range of degree areas
	 */
	public static List<DegreeArea> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the degree areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of degree areas
	 */
	public static List<DegreeArea> findAll(
		int start, int end, OrderByComparator<DegreeArea> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the degree areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of degree areas
	 */
	public static List<DegreeArea> findAll(
		int start, int end, OrderByComparator<DegreeArea> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the degree areas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of degree areas.
	 *
	 * @return the number of degree areas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of degrees associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @return long[] of the primaryKeys of degrees associated with the degree area
	 */
	public static long[] getDegreePrimaryKeys(long pk) {
		return getPersistence().getDegreePrimaryKeys(pk);
	}

	/**
	 * Returns all the degree area associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the degree areas associated with the degree
	 */
	public static List<DegreeArea> getDegreeDegreeAreas(long pk) {
		return getPersistence().getDegreeDegreeAreas(pk);
	}

	/**
	 * Returns all the degree area associated with the degree.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the degree
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of degree areas associated with the degree
	 */
	public static List<DegreeArea> getDegreeDegreeAreas(
		long pk, int start, int end) {

		return getPersistence().getDegreeDegreeAreas(pk, start, end);
	}

	/**
	 * Returns all the degree area associated with the degree.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the degree
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of degree areas associated with the degree
	 */
	public static List<DegreeArea> getDegreeDegreeAreas(
		long pk, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return getPersistence().getDegreeDegreeAreas(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of degrees associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @return the number of degrees associated with the degree area
	 */
	public static int getDegreesSize(long pk) {
		return getPersistence().getDegreesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the degree is associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePK the primary key of the degree
	 * @return <code>true</code> if the degree is associated with the degree area; <code>false</code> otherwise
	 */
	public static boolean containsDegree(long pk, long degreePK) {
		return getPersistence().containsDegree(pk, degreePK);
	}

	/**
	 * Returns <code>true</code> if the degree area has any degrees associated with it.
	 *
	 * @param pk the primary key of the degree area to check for associations with degrees
	 * @return <code>true</code> if the degree area has any degrees associated with it; <code>false</code> otherwise
	 */
	public static boolean containsDegrees(long pk) {
		return getPersistence().containsDegrees(pk);
	}

	/**
	 * Adds an association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePK the primary key of the degree
	 */
	public static void addDegree(long pk, long degreePK) {
		getPersistence().addDegree(pk, degreePK);
	}

	/**
	 * Adds an association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degree the degree
	 */
	public static void addDegree(
		long pk, edu.uoc.mestemi.studentjob.model.Degree degree) {

		getPersistence().addDegree(pk, degree);
	}

	/**
	 * Adds an association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePKs the primary keys of the degrees
	 */
	public static void addDegrees(long pk, long[] degreePKs) {
		getPersistence().addDegrees(pk, degreePKs);
	}

	/**
	 * Adds an association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degrees the degrees
	 */
	public static void addDegrees(
		long pk, List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		getPersistence().addDegrees(pk, degrees);
	}

	/**
	 * Clears all associations between the degree area and its degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area to clear the associated degrees from
	 */
	public static void clearDegrees(long pk) {
		getPersistence().clearDegrees(pk);
	}

	/**
	 * Removes the association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePK the primary key of the degree
	 */
	public static void removeDegree(long pk, long degreePK) {
		getPersistence().removeDegree(pk, degreePK);
	}

	/**
	 * Removes the association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degree the degree
	 */
	public static void removeDegree(
		long pk, edu.uoc.mestemi.studentjob.model.Degree degree) {

		getPersistence().removeDegree(pk, degree);
	}

	/**
	 * Removes the association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePKs the primary keys of the degrees
	 */
	public static void removeDegrees(long pk, long[] degreePKs) {
		getPersistence().removeDegrees(pk, degreePKs);
	}

	/**
	 * Removes the association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degrees the degrees
	 */
	public static void removeDegrees(
		long pk, List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		getPersistence().removeDegrees(pk, degrees);
	}

	/**
	 * Sets the degrees associated with the degree area, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePKs the primary keys of the degrees to be associated with the degree area
	 */
	public static void setDegrees(long pk, long[] degreePKs) {
		getPersistence().setDegrees(pk, degreePKs);
	}

	/**
	 * Sets the degrees associated with the degree area, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degrees the degrees to be associated with the degree area
	 */
	public static void setDegrees(
		long pk, List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		getPersistence().setDegrees(pk, degrees);
	}

	public static DegreeAreaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DegreeAreaPersistence _persistence;

}