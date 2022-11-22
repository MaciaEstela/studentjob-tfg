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

import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the social media network service. This utility wraps <code>edu.uoc.mestemi.studentjob.service.persistence.impl.SocialMediaNetworkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaNetworkPersistence
 * @generated
 */
public class SocialMediaNetworkUtil {

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
	public static void clearCache(SocialMediaNetwork socialMediaNetwork) {
		getPersistence().clearCache(socialMediaNetwork);
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
	public static Map<Serializable, SocialMediaNetwork> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SocialMediaNetwork> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SocialMediaNetwork> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SocialMediaNetwork> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SocialMediaNetwork update(
		SocialMediaNetwork socialMediaNetwork) {

		return getPersistence().update(socialMediaNetwork);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SocialMediaNetwork update(
		SocialMediaNetwork socialMediaNetwork, ServiceContext serviceContext) {

		return getPersistence().update(socialMediaNetwork, serviceContext);
	}

	/**
	 * Returns all the social media networks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social media networks
	 */
	public static List<SocialMediaNetwork> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the social media networks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @return the range of matching social media networks
	 */
	public static List<SocialMediaNetwork> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the social media networks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social media networks
	 */
	public static List<SocialMediaNetwork> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social media networks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social media networks
	 */
	public static List<SocialMediaNetwork> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public static SocialMediaNetwork findByUuid_First(
			String uuid,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public static SocialMediaNetwork fetchByUuid_First(
		String uuid, OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public static SocialMediaNetwork findByUuid_Last(
			String uuid,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public static SocialMediaNetwork fetchByUuid_Last(
		String uuid, OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the social media networks before and after the current social media network in the ordered set where uuid = &#63;.
	 *
	 * @param socialMediaNetworkId the primary key of the current social media network
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media network
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	public static SocialMediaNetwork[] findByUuid_PrevAndNext(
			long socialMediaNetworkId, String uuid,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByUuid_PrevAndNext(
			socialMediaNetworkId, uuid, orderByComparator);
	}

	/**
	 * Removes all the social media networks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of social media networks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social media networks
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the social media network where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSocialMediaNetworkException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public static SocialMediaNetwork findByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the social media network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public static SocialMediaNetwork fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the social media network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public static SocialMediaNetwork fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the social media network where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social media network that was removed
	 */
	public static SocialMediaNetwork removeByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of social media networks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social media networks
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the social media networks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social media networks
	 */
	public static List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the social media networks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @return the range of matching social media networks
	 */
	public static List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the social media networks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social media networks
	 */
	public static List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social media networks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social media networks
	 */
	public static List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public static SocialMediaNetwork findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public static SocialMediaNetwork fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public static SocialMediaNetwork findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public static SocialMediaNetwork fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the social media networks before and after the current social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param socialMediaNetworkId the primary key of the current social media network
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media network
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	public static SocialMediaNetwork[] findByUuid_C_PrevAndNext(
			long socialMediaNetworkId, String uuid, long companyId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByUuid_C_PrevAndNext(
			socialMediaNetworkId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the social media networks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of social media networks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social media networks
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the social media networks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching social media networks
	 */
	public static List<SocialMediaNetwork> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the social media networks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @return the range of matching social media networks
	 */
	public static List<SocialMediaNetwork> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the social media networks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social media networks
	 */
	public static List<SocialMediaNetwork> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social media networks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social media networks
	 */
	public static List<SocialMediaNetwork> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first social media network in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public static SocialMediaNetwork findByGroupId_First(
			long groupId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first social media network in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public static SocialMediaNetwork fetchByGroupId_First(
		long groupId, OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last social media network in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public static SocialMediaNetwork findByGroupId_Last(
			long groupId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last social media network in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public static SocialMediaNetwork fetchByGroupId_Last(
		long groupId, OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the social media networks before and after the current social media network in the ordered set where groupId = &#63;.
	 *
	 * @param socialMediaNetworkId the primary key of the current social media network
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media network
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	public static SocialMediaNetwork[] findByGroupId_PrevAndNext(
			long socialMediaNetworkId, long groupId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByGroupId_PrevAndNext(
			socialMediaNetworkId, groupId, orderByComparator);
	}

	/**
	 * Removes all the social media networks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of social media networks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching social media networks
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the social media network in the entity cache if it is enabled.
	 *
	 * @param socialMediaNetwork the social media network
	 */
	public static void cacheResult(SocialMediaNetwork socialMediaNetwork) {
		getPersistence().cacheResult(socialMediaNetwork);
	}

	/**
	 * Caches the social media networks in the entity cache if it is enabled.
	 *
	 * @param socialMediaNetworks the social media networks
	 */
	public static void cacheResult(
		List<SocialMediaNetwork> socialMediaNetworks) {

		getPersistence().cacheResult(socialMediaNetworks);
	}

	/**
	 * Creates a new social media network with the primary key. Does not add the social media network to the database.
	 *
	 * @param socialMediaNetworkId the primary key for the new social media network
	 * @return the new social media network
	 */
	public static SocialMediaNetwork create(long socialMediaNetworkId) {
		return getPersistence().create(socialMediaNetworkId);
	}

	/**
	 * Removes the social media network with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network that was removed
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	public static SocialMediaNetwork remove(long socialMediaNetworkId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().remove(socialMediaNetworkId);
	}

	public static SocialMediaNetwork updateImpl(
		SocialMediaNetwork socialMediaNetwork) {

		return getPersistence().updateImpl(socialMediaNetwork);
	}

	/**
	 * Returns the social media network with the primary key or throws a <code>NoSuchSocialMediaNetworkException</code> if it could not be found.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	public static SocialMediaNetwork findByPrimaryKey(long socialMediaNetworkId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchSocialMediaNetworkException {

		return getPersistence().findByPrimaryKey(socialMediaNetworkId);
	}

	/**
	 * Returns the social media network with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network, or <code>null</code> if a social media network with the primary key could not be found
	 */
	public static SocialMediaNetwork fetchByPrimaryKey(
		long socialMediaNetworkId) {

		return getPersistence().fetchByPrimaryKey(socialMediaNetworkId);
	}

	/**
	 * Returns all the social media networks.
	 *
	 * @return the social media networks
	 */
	public static List<SocialMediaNetwork> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the social media networks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @return the range of social media networks
	 */
	public static List<SocialMediaNetwork> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the social media networks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social media networks
	 */
	public static List<SocialMediaNetwork> findAll(
		int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social media networks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of social media networks
	 */
	public static List<SocialMediaNetwork> findAll(
		int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the social media networks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of social media networks.
	 *
	 * @return the number of social media networks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SocialMediaNetworkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SocialMediaNetworkPersistence _persistence;

}