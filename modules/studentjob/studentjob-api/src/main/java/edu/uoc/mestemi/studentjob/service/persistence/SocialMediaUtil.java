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

import edu.uoc.mestemi.studentjob.model.SocialMedia;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the social media service. This utility wraps <code>edu.uoc.mestemi.studentjob.service.persistence.impl.SocialMediaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaPersistence
 * @generated
 */
public class SocialMediaUtil {

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
	public static void clearCache(SocialMedia socialMedia) {
		getPersistence().clearCache(socialMedia);
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
	public static Map<Serializable, SocialMedia> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SocialMedia> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SocialMedia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SocialMedia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SocialMedia update(SocialMedia socialMedia) {
		return getPersistence().update(socialMedia);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SocialMedia update(
		SocialMedia socialMedia, ServiceContext serviceContext) {

		return getPersistence().update(socialMedia, serviceContext);
	}

	/**
	 * Returns all the social medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social medias
	 */
	public static List<SocialMedia> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the social medias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of matching social medias
	 */
	public static List<SocialMedia> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the social medias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social medias
	 */
	public static List<SocialMedia> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social medias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social medias
	 */
	public static List<SocialMedia> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findByUuid_First(
			String uuid, OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchByUuid_First(
		String uuid, OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findByUuid_Last(
			String uuid, OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchByUuid_Last(
		String uuid, OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the social medias before and after the current social media in the ordered set where uuid = &#63;.
	 *
	 * @param socialMediaId the primary key of the current social media
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public static SocialMedia[] findByUuid_PrevAndNext(
			long socialMediaId, String uuid,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByUuid_PrevAndNext(
			socialMediaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the social medias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of social medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social medias
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the social media where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSocialMediaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the social media where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the social media where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the social media where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social media that was removed
	 */
	public static SocialMedia removeByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of social medias where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social medias
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social medias
	 */
	public static List<SocialMedia> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of matching social medias
	 */
	public static List<SocialMedia> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social medias
	 */
	public static List<SocialMedia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social medias
	 */
	public static List<SocialMedia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the social medias before and after the current social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param socialMediaId the primary key of the current social media
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public static SocialMedia[] findByUuid_C_PrevAndNext(
			long socialMediaId, String uuid, long companyId,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			socialMediaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the social medias where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social medias
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the social medias where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching social medias
	 */
	public static List<SocialMedia> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the social medias where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of matching social medias
	 */
	public static List<SocialMedia> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the social medias where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social medias
	 */
	public static List<SocialMedia> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social medias where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social medias
	 */
	public static List<SocialMedia> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first social media in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findByGroupId_First(
			long groupId, OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first social media in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchByGroupId_First(
		long groupId, OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last social media in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findByGroupId_Last(
			long groupId, OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last social media in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchByGroupId_Last(
		long groupId, OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the social medias before and after the current social media in the ordered set where groupId = &#63;.
	 *
	 * @param socialMediaId the primary key of the current social media
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public static SocialMedia[] findByGroupId_PrevAndNext(
			long socialMediaId, long groupId,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByGroupId_PrevAndNext(
			socialMediaId, groupId, orderByComparator);
	}

	/**
	 * Removes all the social medias where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of social medias where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching social medias
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching social medias
	 */
	public static List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK) {

		return getPersistence().findByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK);
	}

	/**
	 * Returns a range of all the social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of matching social medias
	 */
	public static List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK, int start, int end) {

		return getPersistence().findByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK, start, end);
	}

	/**
	 * Returns an ordered range of all the social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social medias
	 */
	public static List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().findByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social medias
	 */
	public static List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findByGroupIdAndClassNameAndClassPK_First(
			long groupId, String className, long classPK,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByGroupIdAndClassNameAndClassPK_First(
			groupId, className, classPK, orderByComparator);
	}

	/**
	 * Returns the first social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchByGroupIdAndClassNameAndClassPK_First(
		long groupId, String className, long classPK,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().fetchByGroupIdAndClassNameAndClassPK_First(
			groupId, className, classPK, orderByComparator);
	}

	/**
	 * Returns the last social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findByGroupIdAndClassNameAndClassPK_Last(
			long groupId, String className, long classPK,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByGroupIdAndClassNameAndClassPK_Last(
			groupId, className, classPK, orderByComparator);
	}

	/**
	 * Returns the last social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchByGroupIdAndClassNameAndClassPK_Last(
		long groupId, String className, long classPK,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().fetchByGroupIdAndClassNameAndClassPK_Last(
			groupId, className, classPK, orderByComparator);
	}

	/**
	 * Returns the social medias before and after the current social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param socialMediaId the primary key of the current social media
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public static SocialMedia[] findByGroupIdAndClassNameAndClassPK_PrevAndNext(
			long socialMediaId, long groupId, String className, long classPK,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByGroupIdAndClassNameAndClassPK_PrevAndNext(
			socialMediaId, groupId, className, classPK, orderByComparator);
	}

	/**
	 * Removes all the social medias where groupId = &#63; and className = &#63; and classPK = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 */
	public static void removeByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK) {

		getPersistence().removeByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK);
	}

	/**
	 * Returns the number of social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching social medias
	 */
	public static int countByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK) {

		return getPersistence().countByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK);
	}

	/**
	 * Returns the social media where groupId = &#63; and className = &#63; and classPK = &#63; and socialMediaNetworkId = &#63; or throws a <code>NoSuchSocialMediaException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param socialMediaNetworkId the social media network ID
	 * @return the matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia
			findByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				long groupId, String className, long classPK,
				long socialMediaNetworkId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().
			findByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				groupId, className, classPK, socialMediaNetworkId);
	}

	/**
	 * Returns the social media where groupId = &#63; and className = &#63; and classPK = &#63; and socialMediaNetworkId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param socialMediaNetworkId the social media network ID
	 * @return the matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia
		fetchByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
			long groupId, String className, long classPK,
			long socialMediaNetworkId) {

		return getPersistence().
			fetchByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				groupId, className, classPK, socialMediaNetworkId);
	}

	/**
	 * Returns the social media where groupId = &#63; and className = &#63; and classPK = &#63; and socialMediaNetworkId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param socialMediaNetworkId the social media network ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia
		fetchByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
			long groupId, String className, long classPK,
			long socialMediaNetworkId, boolean useFinderCache) {

		return getPersistence().
			fetchByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				groupId, className, classPK, socialMediaNetworkId,
				useFinderCache);
	}

	/**
	 * Removes the social media where groupId = &#63; and className = &#63; and classPK = &#63; and socialMediaNetworkId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param socialMediaNetworkId the social media network ID
	 * @return the social media that was removed
	 */
	public static SocialMedia
			removeByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				long groupId, String className, long classPK,
				long socialMediaNetworkId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().
			removeByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				groupId, className, classPK, socialMediaNetworkId);
	}

	/**
	 * Returns the number of social medias where groupId = &#63; and className = &#63; and classPK = &#63; and socialMediaNetworkId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param socialMediaNetworkId the social media network ID
	 * @return the number of matching social medias
	 */
	public static int
		countByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
			long groupId, String className, long classPK,
			long socialMediaNetworkId) {

		return getPersistence().
			countByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				groupId, className, classPK, socialMediaNetworkId);
	}

	/**
	 * Returns all the social medias where socialMediaNetworkId = &#63;.
	 *
	 * @param socialMediaNetworkId the social media network ID
	 * @return the matching social medias
	 */
	public static List<SocialMedia> findBySocialMediaNetworkId(
		long socialMediaNetworkId) {

		return getPersistence().findBySocialMediaNetworkId(
			socialMediaNetworkId);
	}

	/**
	 * Returns a range of all the social medias where socialMediaNetworkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param socialMediaNetworkId the social media network ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of matching social medias
	 */
	public static List<SocialMedia> findBySocialMediaNetworkId(
		long socialMediaNetworkId, int start, int end) {

		return getPersistence().findBySocialMediaNetworkId(
			socialMediaNetworkId, start, end);
	}

	/**
	 * Returns an ordered range of all the social medias where socialMediaNetworkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param socialMediaNetworkId the social media network ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social medias
	 */
	public static List<SocialMedia> findBySocialMediaNetworkId(
		long socialMediaNetworkId, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().findBySocialMediaNetworkId(
			socialMediaNetworkId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social medias where socialMediaNetworkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param socialMediaNetworkId the social media network ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social medias
	 */
	public static List<SocialMedia> findBySocialMediaNetworkId(
		long socialMediaNetworkId, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySocialMediaNetworkId(
			socialMediaNetworkId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first social media in the ordered set where socialMediaNetworkId = &#63;.
	 *
	 * @param socialMediaNetworkId the social media network ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findBySocialMediaNetworkId_First(
			long socialMediaNetworkId,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findBySocialMediaNetworkId_First(
			socialMediaNetworkId, orderByComparator);
	}

	/**
	 * Returns the first social media in the ordered set where socialMediaNetworkId = &#63;.
	 *
	 * @param socialMediaNetworkId the social media network ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchBySocialMediaNetworkId_First(
		long socialMediaNetworkId,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().fetchBySocialMediaNetworkId_First(
			socialMediaNetworkId, orderByComparator);
	}

	/**
	 * Returns the last social media in the ordered set where socialMediaNetworkId = &#63;.
	 *
	 * @param socialMediaNetworkId the social media network ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public static SocialMedia findBySocialMediaNetworkId_Last(
			long socialMediaNetworkId,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findBySocialMediaNetworkId_Last(
			socialMediaNetworkId, orderByComparator);
	}

	/**
	 * Returns the last social media in the ordered set where socialMediaNetworkId = &#63;.
	 *
	 * @param socialMediaNetworkId the social media network ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchBySocialMediaNetworkId_Last(
		long socialMediaNetworkId,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().fetchBySocialMediaNetworkId_Last(
			socialMediaNetworkId, orderByComparator);
	}

	/**
	 * Returns the social medias before and after the current social media in the ordered set where socialMediaNetworkId = &#63;.
	 *
	 * @param socialMediaId the primary key of the current social media
	 * @param socialMediaNetworkId the social media network ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public static SocialMedia[] findBySocialMediaNetworkId_PrevAndNext(
			long socialMediaId, long socialMediaNetworkId,
			OrderByComparator<SocialMedia> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findBySocialMediaNetworkId_PrevAndNext(
			socialMediaId, socialMediaNetworkId, orderByComparator);
	}

	/**
	 * Removes all the social medias where socialMediaNetworkId = &#63; from the database.
	 *
	 * @param socialMediaNetworkId the social media network ID
	 */
	public static void removeBySocialMediaNetworkId(long socialMediaNetworkId) {
		getPersistence().removeBySocialMediaNetworkId(socialMediaNetworkId);
	}

	/**
	 * Returns the number of social medias where socialMediaNetworkId = &#63;.
	 *
	 * @param socialMediaNetworkId the social media network ID
	 * @return the number of matching social medias
	 */
	public static int countBySocialMediaNetworkId(long socialMediaNetworkId) {
		return getPersistence().countBySocialMediaNetworkId(
			socialMediaNetworkId);
	}

	/**
	 * Caches the social media in the entity cache if it is enabled.
	 *
	 * @param socialMedia the social media
	 */
	public static void cacheResult(SocialMedia socialMedia) {
		getPersistence().cacheResult(socialMedia);
	}

	/**
	 * Caches the social medias in the entity cache if it is enabled.
	 *
	 * @param socialMedias the social medias
	 */
	public static void cacheResult(List<SocialMedia> socialMedias) {
		getPersistence().cacheResult(socialMedias);
	}

	/**
	 * Creates a new social media with the primary key. Does not add the social media to the database.
	 *
	 * @param socialMediaId the primary key for the new social media
	 * @return the new social media
	 */
	public static SocialMedia create(long socialMediaId) {
		return getPersistence().create(socialMediaId);
	}

	/**
	 * Removes the social media with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media that was removed
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public static SocialMedia remove(long socialMediaId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().remove(socialMediaId);
	}

	public static SocialMedia updateImpl(SocialMedia socialMedia) {
		return getPersistence().updateImpl(socialMedia);
	}

	/**
	 * Returns the social media with the primary key or throws a <code>NoSuchSocialMediaException</code> if it could not be found.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public static SocialMedia findByPrimaryKey(long socialMediaId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getPersistence().findByPrimaryKey(socialMediaId);
	}

	/**
	 * Returns the social media with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media, or <code>null</code> if a social media with the primary key could not be found
	 */
	public static SocialMedia fetchByPrimaryKey(long socialMediaId) {
		return getPersistence().fetchByPrimaryKey(socialMediaId);
	}

	/**
	 * Returns all the social medias.
	 *
	 * @return the social medias
	 */
	public static List<SocialMedia> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the social medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of social medias
	 */
	public static List<SocialMedia> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the social medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social medias
	 */
	public static List<SocialMedia> findAll(
		int start, int end, OrderByComparator<SocialMedia> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of social medias
	 */
	public static List<SocialMedia> findAll(
		int start, int end, OrderByComparator<SocialMedia> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the social medias from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of social medias.
	 *
	 * @return the number of social medias
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SocialMediaPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SocialMediaPersistence _persistence;

}