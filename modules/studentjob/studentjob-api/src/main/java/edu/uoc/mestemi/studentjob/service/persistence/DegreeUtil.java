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

import edu.uoc.mestemi.studentjob.model.Degree;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the degree service. This utility wraps <code>edu.uoc.mestemi.studentjob.service.persistence.impl.DegreePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DegreePersistence
 * @generated
 */
public class DegreeUtil {

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
	public static void clearCache(Degree degree) {
		getPersistence().clearCache(degree);
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
	public static Map<Serializable, Degree> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Degree> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Degree> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Degree> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Degree update(Degree degree) {
		return getPersistence().update(degree);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Degree update(Degree degree, ServiceContext serviceContext) {
		return getPersistence().update(degree, serviceContext);
	}

	/**
	 * Returns all the degrees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching degrees
	 */
	public static List<Degree> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the degrees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of matching degrees
	 */
	public static List<Degree> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the degrees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching degrees
	 */
	public static List<Degree> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the degrees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching degrees
	 */
	public static List<Degree> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Degree> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public static Degree findByUuid_First(
			String uuid, OrderByComparator<Degree> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public static Degree fetchByUuid_First(
		String uuid, OrderByComparator<Degree> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public static Degree findByUuid_Last(
			String uuid, OrderByComparator<Degree> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public static Degree fetchByUuid_Last(
		String uuid, OrderByComparator<Degree> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the degrees before and after the current degree in the ordered set where uuid = &#63;.
	 *
	 * @param degreeId the primary key of the current degree
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next degree
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	public static Degree[] findByUuid_PrevAndNext(
			long degreeId, String uuid,
			OrderByComparator<Degree> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByUuid_PrevAndNext(
			degreeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the degrees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of degrees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching degrees
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the degree where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDegreeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public static Degree findByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the degree where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public static Degree fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the degree where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public static Degree fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the degree where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the degree that was removed
	 */
	public static Degree removeByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of degrees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching degrees
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the degrees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching degrees
	 */
	public static List<Degree> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the degrees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of matching degrees
	 */
	public static List<Degree> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the degrees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching degrees
	 */
	public static List<Degree> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the degrees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching degrees
	 */
	public static List<Degree> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Degree> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public static Degree findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Degree> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public static Degree fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Degree> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public static Degree findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Degree> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public static Degree fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Degree> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the degrees before and after the current degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param degreeId the primary key of the current degree
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next degree
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	public static Degree[] findByUuid_C_PrevAndNext(
			long degreeId, String uuid, long companyId,
			OrderByComparator<Degree> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			degreeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the degrees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of degrees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching degrees
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the degrees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching degrees
	 */
	public static List<Degree> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the degrees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of matching degrees
	 */
	public static List<Degree> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the degrees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching degrees
	 */
	public static List<Degree> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the degrees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching degrees
	 */
	public static List<Degree> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Degree> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first degree in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public static Degree findByGroupId_First(
			long groupId, OrderByComparator<Degree> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first degree in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public static Degree fetchByGroupId_First(
		long groupId, OrderByComparator<Degree> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last degree in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public static Degree findByGroupId_Last(
			long groupId, OrderByComparator<Degree> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last degree in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public static Degree fetchByGroupId_Last(
		long groupId, OrderByComparator<Degree> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the degrees before and after the current degree in the ordered set where groupId = &#63;.
	 *
	 * @param degreeId the primary key of the current degree
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next degree
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	public static Degree[] findByGroupId_PrevAndNext(
			long degreeId, long groupId,
			OrderByComparator<Degree> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByGroupId_PrevAndNext(
			degreeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the degrees where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of degrees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching degrees
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the degree in the entity cache if it is enabled.
	 *
	 * @param degree the degree
	 */
	public static void cacheResult(Degree degree) {
		getPersistence().cacheResult(degree);
	}

	/**
	 * Caches the degrees in the entity cache if it is enabled.
	 *
	 * @param degrees the degrees
	 */
	public static void cacheResult(List<Degree> degrees) {
		getPersistence().cacheResult(degrees);
	}

	/**
	 * Creates a new degree with the primary key. Does not add the degree to the database.
	 *
	 * @param degreeId the primary key for the new degree
	 * @return the new degree
	 */
	public static Degree create(long degreeId) {
		return getPersistence().create(degreeId);
	}

	/**
	 * Removes the degree with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree that was removed
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	public static Degree remove(long degreeId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().remove(degreeId);
	}

	public static Degree updateImpl(Degree degree) {
		return getPersistence().updateImpl(degree);
	}

	/**
	 * Returns the degree with the primary key or throws a <code>NoSuchDegreeException</code> if it could not be found.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	public static Degree findByPrimaryKey(long degreeId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException {

		return getPersistence().findByPrimaryKey(degreeId);
	}

	/**
	 * Returns the degree with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree, or <code>null</code> if a degree with the primary key could not be found
	 */
	public static Degree fetchByPrimaryKey(long degreeId) {
		return getPersistence().fetchByPrimaryKey(degreeId);
	}

	/**
	 * Returns all the degrees.
	 *
	 * @return the degrees
	 */
	public static List<Degree> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the degrees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of degrees
	 */
	public static List<Degree> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the degrees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of degrees
	 */
	public static List<Degree> findAll(
		int start, int end, OrderByComparator<Degree> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the degrees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of degrees
	 */
	public static List<Degree> findAll(
		int start, int end, OrderByComparator<Degree> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the degrees from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of degrees.
	 *
	 * @return the number of degrees
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of degree areas associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return long[] of the primaryKeys of degree areas associated with the degree
	 */
	public static long[] getDegreeAreaPrimaryKeys(long pk) {
		return getPersistence().getDegreeAreaPrimaryKeys(pk);
	}

	/**
	 * Returns all the degree associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @return the degrees associated with the degree area
	 */
	public static List<Degree> getDegreeAreaDegrees(long pk) {
		return getPersistence().getDegreeAreaDegrees(pk);
	}

	/**
	 * Returns all the degree associated with the degree area.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the degree area
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @return the range of degrees associated with the degree area
	 */
	public static List<Degree> getDegreeAreaDegrees(
		long pk, int start, int end) {

		return getPersistence().getDegreeAreaDegrees(pk, start, end);
	}

	/**
	 * Returns all the degree associated with the degree area.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the degree area
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of degrees associated with the degree area
	 */
	public static List<Degree> getDegreeAreaDegrees(
		long pk, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getPersistence().getDegreeAreaDegrees(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of degree areas associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the number of degree areas associated with the degree
	 */
	public static int getDegreeAreasSize(long pk) {
		return getPersistence().getDegreeAreasSize(pk);
	}

	/**
	 * Returns <code>true</code> if the degree area is associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPK the primary key of the degree area
	 * @return <code>true</code> if the degree area is associated with the degree; <code>false</code> otherwise
	 */
	public static boolean containsDegreeArea(long pk, long degreeAreaPK) {
		return getPersistence().containsDegreeArea(pk, degreeAreaPK);
	}

	/**
	 * Returns <code>true</code> if the degree has any degree areas associated with it.
	 *
	 * @param pk the primary key of the degree to check for associations with degree areas
	 * @return <code>true</code> if the degree has any degree areas associated with it; <code>false</code> otherwise
	 */
	public static boolean containsDegreeAreas(long pk) {
		return getPersistence().containsDegreeAreas(pk);
	}

	/**
	 * Adds an association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPK the primary key of the degree area
	 */
	public static void addDegreeArea(long pk, long degreeAreaPK) {
		getPersistence().addDegreeArea(pk, degreeAreaPK);
	}

	/**
	 * Adds an association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeArea the degree area
	 */
	public static void addDegreeArea(
		long pk, edu.uoc.mestemi.studentjob.model.DegreeArea degreeArea) {

		getPersistence().addDegreeArea(pk, degreeArea);
	}

	/**
	 * Adds an association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPKs the primary keys of the degree areas
	 */
	public static void addDegreeAreas(long pk, long[] degreeAreaPKs) {
		getPersistence().addDegreeAreas(pk, degreeAreaPKs);
	}

	/**
	 * Adds an association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreas the degree areas
	 */
	public static void addDegreeAreas(
		long pk,
		List<edu.uoc.mestemi.studentjob.model.DegreeArea> degreeAreas) {

		getPersistence().addDegreeAreas(pk, degreeAreas);
	}

	/**
	 * Clears all associations between the degree and its degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree to clear the associated degree areas from
	 */
	public static void clearDegreeAreas(long pk) {
		getPersistence().clearDegreeAreas(pk);
	}

	/**
	 * Removes the association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPK the primary key of the degree area
	 */
	public static void removeDegreeArea(long pk, long degreeAreaPK) {
		getPersistence().removeDegreeArea(pk, degreeAreaPK);
	}

	/**
	 * Removes the association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeArea the degree area
	 */
	public static void removeDegreeArea(
		long pk, edu.uoc.mestemi.studentjob.model.DegreeArea degreeArea) {

		getPersistence().removeDegreeArea(pk, degreeArea);
	}

	/**
	 * Removes the association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPKs the primary keys of the degree areas
	 */
	public static void removeDegreeAreas(long pk, long[] degreeAreaPKs) {
		getPersistence().removeDegreeAreas(pk, degreeAreaPKs);
	}

	/**
	 * Removes the association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreas the degree areas
	 */
	public static void removeDegreeAreas(
		long pk,
		List<edu.uoc.mestemi.studentjob.model.DegreeArea> degreeAreas) {

		getPersistence().removeDegreeAreas(pk, degreeAreas);
	}

	/**
	 * Sets the degree areas associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPKs the primary keys of the degree areas to be associated with the degree
	 */
	public static void setDegreeAreas(long pk, long[] degreeAreaPKs) {
		getPersistence().setDegreeAreas(pk, degreeAreaPKs);
	}

	/**
	 * Sets the degree areas associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreas the degree areas to be associated with the degree
	 */
	public static void setDegreeAreas(
		long pk,
		List<edu.uoc.mestemi.studentjob.model.DegreeArea> degreeAreas) {

		getPersistence().setDegreeAreas(pk, degreeAreas);
	}

	/**
	 * Returns the primaryKeys of student profiles associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return long[] of the primaryKeys of student profiles associated with the degree
	 */
	public static long[] getStudentProfilePrimaryKeys(long pk) {
		return getPersistence().getStudentProfilePrimaryKeys(pk);
	}

	/**
	 * Returns all the degree associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @return the degrees associated with the student profile
	 */
	public static List<Degree> getStudentProfileDegrees(long pk) {
		return getPersistence().getStudentProfileDegrees(pk);
	}

	/**
	 * Returns all the degree associated with the student profile.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student profile
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of degrees associated with the student profile
	 */
	public static List<Degree> getStudentProfileDegrees(
		long pk, int start, int end) {

		return getPersistence().getStudentProfileDegrees(pk, start, end);
	}

	/**
	 * Returns all the degree associated with the student profile.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student profile
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of degrees associated with the student profile
	 */
	public static List<Degree> getStudentProfileDegrees(
		long pk, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getPersistence().getStudentProfileDegrees(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of student profiles associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the number of student profiles associated with the degree
	 */
	public static int getStudentProfilesSize(long pk) {
		return getPersistence().getStudentProfilesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the student profile is associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePK the primary key of the student profile
	 * @return <code>true</code> if the student profile is associated with the degree; <code>false</code> otherwise
	 */
	public static boolean containsStudentProfile(
		long pk, long studentProfilePK) {

		return getPersistence().containsStudentProfile(pk, studentProfilePK);
	}

	/**
	 * Returns <code>true</code> if the degree has any student profiles associated with it.
	 *
	 * @param pk the primary key of the degree to check for associations with student profiles
	 * @return <code>true</code> if the degree has any student profiles associated with it; <code>false</code> otherwise
	 */
	public static boolean containsStudentProfiles(long pk) {
		return getPersistence().containsStudentProfiles(pk);
	}

	/**
	 * Adds an association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePK the primary key of the student profile
	 */
	public static void addStudentProfile(long pk, long studentProfilePK) {
		getPersistence().addStudentProfile(pk, studentProfilePK);
	}

	/**
	 * Adds an association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfile the student profile
	 */
	public static void addStudentProfile(
		long pk,
		edu.uoc.mestemi.studentjob.model.StudentProfile studentProfile) {

		getPersistence().addStudentProfile(pk, studentProfile);
	}

	/**
	 * Adds an association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePKs the primary keys of the student profiles
	 */
	public static void addStudentProfiles(long pk, long[] studentProfilePKs) {
		getPersistence().addStudentProfiles(pk, studentProfilePKs);
	}

	/**
	 * Adds an association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfiles the student profiles
	 */
	public static void addStudentProfiles(
		long pk,
		List<edu.uoc.mestemi.studentjob.model.StudentProfile> studentProfiles) {

		getPersistence().addStudentProfiles(pk, studentProfiles);
	}

	/**
	 * Clears all associations between the degree and its student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree to clear the associated student profiles from
	 */
	public static void clearStudentProfiles(long pk) {
		getPersistence().clearStudentProfiles(pk);
	}

	/**
	 * Removes the association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePK the primary key of the student profile
	 */
	public static void removeStudentProfile(long pk, long studentProfilePK) {
		getPersistence().removeStudentProfile(pk, studentProfilePK);
	}

	/**
	 * Removes the association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfile the student profile
	 */
	public static void removeStudentProfile(
		long pk,
		edu.uoc.mestemi.studentjob.model.StudentProfile studentProfile) {

		getPersistence().removeStudentProfile(pk, studentProfile);
	}

	/**
	 * Removes the association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePKs the primary keys of the student profiles
	 */
	public static void removeStudentProfiles(
		long pk, long[] studentProfilePKs) {

		getPersistence().removeStudentProfiles(pk, studentProfilePKs);
	}

	/**
	 * Removes the association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfiles the student profiles
	 */
	public static void removeStudentProfiles(
		long pk,
		List<edu.uoc.mestemi.studentjob.model.StudentProfile> studentProfiles) {

		getPersistence().removeStudentProfiles(pk, studentProfiles);
	}

	/**
	 * Sets the student profiles associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePKs the primary keys of the student profiles to be associated with the degree
	 */
	public static void setStudentProfiles(long pk, long[] studentProfilePKs) {
		getPersistence().setStudentProfiles(pk, studentProfilePKs);
	}

	/**
	 * Sets the student profiles associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfiles the student profiles to be associated with the degree
	 */
	public static void setStudentProfiles(
		long pk,
		List<edu.uoc.mestemi.studentjob.model.StudentProfile> studentProfiles) {

		getPersistence().setStudentProfiles(pk, studentProfiles);
	}

	/**
	 * Returns the primaryKeys of offers associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return long[] of the primaryKeys of offers associated with the degree
	 */
	public static long[] getOfferPrimaryKeys(long pk) {
		return getPersistence().getOfferPrimaryKeys(pk);
	}

	/**
	 * Returns all the degree associated with the offer.
	 *
	 * @param pk the primary key of the offer
	 * @return the degrees associated with the offer
	 */
	public static List<Degree> getOfferDegrees(long pk) {
		return getPersistence().getOfferDegrees(pk);
	}

	/**
	 * Returns all the degree associated with the offer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the offer
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of degrees associated with the offer
	 */
	public static List<Degree> getOfferDegrees(long pk, int start, int end) {
		return getPersistence().getOfferDegrees(pk, start, end);
	}

	/**
	 * Returns all the degree associated with the offer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the offer
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of degrees associated with the offer
	 */
	public static List<Degree> getOfferDegrees(
		long pk, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getPersistence().getOfferDegrees(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of offers associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the number of offers associated with the degree
	 */
	public static int getOffersSize(long pk) {
		return getPersistence().getOffersSize(pk);
	}

	/**
	 * Returns <code>true</code> if the offer is associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPK the primary key of the offer
	 * @return <code>true</code> if the offer is associated with the degree; <code>false</code> otherwise
	 */
	public static boolean containsOffer(long pk, long offerPK) {
		return getPersistence().containsOffer(pk, offerPK);
	}

	/**
	 * Returns <code>true</code> if the degree has any offers associated with it.
	 *
	 * @param pk the primary key of the degree to check for associations with offers
	 * @return <code>true</code> if the degree has any offers associated with it; <code>false</code> otherwise
	 */
	public static boolean containsOffers(long pk) {
		return getPersistence().containsOffers(pk);
	}

	/**
	 * Adds an association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPK the primary key of the offer
	 */
	public static void addOffer(long pk, long offerPK) {
		getPersistence().addOffer(pk, offerPK);
	}

	/**
	 * Adds an association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offer the offer
	 */
	public static void addOffer(
		long pk, edu.uoc.mestemi.studentjob.model.Offer offer) {

		getPersistence().addOffer(pk, offer);
	}

	/**
	 * Adds an association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPKs the primary keys of the offers
	 */
	public static void addOffers(long pk, long[] offerPKs) {
		getPersistence().addOffers(pk, offerPKs);
	}

	/**
	 * Adds an association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offers the offers
	 */
	public static void addOffers(
		long pk, List<edu.uoc.mestemi.studentjob.model.Offer> offers) {

		getPersistence().addOffers(pk, offers);
	}

	/**
	 * Clears all associations between the degree and its offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree to clear the associated offers from
	 */
	public static void clearOffers(long pk) {
		getPersistence().clearOffers(pk);
	}

	/**
	 * Removes the association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPK the primary key of the offer
	 */
	public static void removeOffer(long pk, long offerPK) {
		getPersistence().removeOffer(pk, offerPK);
	}

	/**
	 * Removes the association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offer the offer
	 */
	public static void removeOffer(
		long pk, edu.uoc.mestemi.studentjob.model.Offer offer) {

		getPersistence().removeOffer(pk, offer);
	}

	/**
	 * Removes the association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPKs the primary keys of the offers
	 */
	public static void removeOffers(long pk, long[] offerPKs) {
		getPersistence().removeOffers(pk, offerPKs);
	}

	/**
	 * Removes the association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offers the offers
	 */
	public static void removeOffers(
		long pk, List<edu.uoc.mestemi.studentjob.model.Offer> offers) {

		getPersistence().removeOffers(pk, offers);
	}

	/**
	 * Sets the offers associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPKs the primary keys of the offers to be associated with the degree
	 */
	public static void setOffers(long pk, long[] offerPKs) {
		getPersistence().setOffers(pk, offerPKs);
	}

	/**
	 * Sets the offers associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offers the offers to be associated with the degree
	 */
	public static void setOffers(
		long pk, List<edu.uoc.mestemi.studentjob.model.Offer> offers) {

		getPersistence().setOffers(pk, offers);
	}

	public static DegreePersistence getPersistence() {
		return _persistence;
	}

	private static volatile DegreePersistence _persistence;

}