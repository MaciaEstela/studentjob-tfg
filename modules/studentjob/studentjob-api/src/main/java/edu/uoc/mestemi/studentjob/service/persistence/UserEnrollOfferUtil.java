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

import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user enroll offer service. This utility wraps <code>edu.uoc.mestemi.studentjob.service.persistence.impl.UserEnrollOfferPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserEnrollOfferPersistence
 * @generated
 */
public class UserEnrollOfferUtil {

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
	public static void clearCache(UserEnrollOffer userEnrollOffer) {
		getPersistence().clearCache(userEnrollOffer);
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
	public static Map<Serializable, UserEnrollOffer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserEnrollOffer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserEnrollOffer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserEnrollOffer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserEnrollOffer update(UserEnrollOffer userEnrollOffer) {
		return getPersistence().update(userEnrollOffer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserEnrollOffer update(
		UserEnrollOffer userEnrollOffer, ServiceContext serviceContext) {

		return getPersistence().update(userEnrollOffer, serviceContext);
	}

	/**
	 * Returns all the user enroll offers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user enroll offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @return the range of matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user enroll offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user enroll offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer findByUuid_First(
			String uuid, OrderByComparator<UserEnrollOffer> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchByUuid_First(
		String uuid, OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer findByUuid_Last(
			String uuid, OrderByComparator<UserEnrollOffer> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchByUuid_Last(
		String uuid, OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user enroll offers before and after the current user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param userEnrollOfferPK the primary key of the current user enroll offer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	public static UserEnrollOffer[] findByUuid_PrevAndNext(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK,
			String uuid, OrderByComparator<UserEnrollOffer> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByUuid_PrevAndNext(
			userEnrollOfferPK, uuid, orderByComparator);
	}

	/**
	 * Removes all the user enroll offers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user enroll offers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user enroll offers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the user enroll offer where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserEnrollOfferException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer findByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user enroll offer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user enroll offer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the user enroll offer where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user enroll offer that was removed
	 */
	public static UserEnrollOffer removeByUUID_G(String uuid, long groupId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of user enroll offers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user enroll offers
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the user enroll offers where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId) {

		return getPersistence().findByGroupIdAndUserId(groupId, userId);
	}

	/**
	 * Returns a range of all the user enroll offers where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @return the range of matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByGroupIdAndUserId(
			groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the user enroll offers where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().findByGroupIdAndUserId(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user enroll offers where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdAndUserId(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer findByGroupIdAndUserId_First(
			long groupId, long userId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByGroupIdAndUserId_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchByGroupIdAndUserId_First(
		long groupId, long userId,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().fetchByGroupIdAndUserId_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer findByGroupIdAndUserId_Last(
			long groupId, long userId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByGroupIdAndUserId_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchByGroupIdAndUserId_Last(
		long groupId, long userId,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().fetchByGroupIdAndUserId_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the user enroll offers before and after the current user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param userEnrollOfferPK the primary key of the current user enroll offer
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	public static UserEnrollOffer[] findByGroupIdAndUserId_PrevAndNext(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK,
			long groupId, long userId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByGroupIdAndUserId_PrevAndNext(
			userEnrollOfferPK, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the user enroll offers where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByGroupIdAndUserId(long groupId, long userId) {
		getPersistence().removeByGroupIdAndUserId(groupId, userId);
	}

	/**
	 * Returns the number of user enroll offers where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching user enroll offers
	 */
	public static int countByGroupIdAndUserId(long groupId, long userId) {
		return getPersistence().countByGroupIdAndUserId(groupId, userId);
	}

	/**
	 * Returns the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; or throws a <code>NoSuchUserEnrollOfferException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer findByGroupIdAndUserIdAndOfferId(
			long groupId, long userId, long offerId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByGroupIdAndUserIdAndOfferId(
			groupId, userId, offerId);
	}

	/**
	 * Returns the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchByGroupIdAndUserIdAndOfferId(
		long groupId, long userId, long offerId) {

		return getPersistence().fetchByGroupIdAndUserIdAndOfferId(
			groupId, userId, offerId);
	}

	/**
	 * Returns the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchByGroupIdAndUserIdAndOfferId(
		long groupId, long userId, long offerId, boolean useFinderCache) {

		return getPersistence().fetchByGroupIdAndUserIdAndOfferId(
			groupId, userId, offerId, useFinderCache);
	}

	/**
	 * Removes the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the user enroll offer that was removed
	 */
	public static UserEnrollOffer removeByGroupIdAndUserIdAndOfferId(
			long groupId, long userId, long offerId)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().removeByGroupIdAndUserIdAndOfferId(
			groupId, userId, offerId);
	}

	/**
	 * Returns the number of user enroll offers where groupId = &#63; and userId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the number of matching user enroll offers
	 */
	public static int countByGroupIdAndUserIdAndOfferId(
		long groupId, long userId, long offerId) {

		return getPersistence().countByGroupIdAndUserIdAndOfferId(
			groupId, userId, offerId);
	}

	/**
	 * Returns all the user enroll offers where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @return the matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId) {

		return getPersistence().findByGroupIdAndOfferId(groupId, offerId);
	}

	/**
	 * Returns a range of all the user enroll offers where groupId = &#63; and offerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @return the range of matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId, int start, int end) {

		return getPersistence().findByGroupIdAndOfferId(
			groupId, offerId, start, end);
	}

	/**
	 * Returns an ordered range of all the user enroll offers where groupId = &#63; and offerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().findByGroupIdAndOfferId(
			groupId, offerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user enroll offers where groupId = &#63; and offerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user enroll offers
	 */
	public static List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdAndOfferId(
			groupId, offerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer findByGroupIdAndOfferId_First(
			long groupId, long offerId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByGroupIdAndOfferId_First(
			groupId, offerId, orderByComparator);
	}

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchByGroupIdAndOfferId_First(
		long groupId, long offerId,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().fetchByGroupIdAndOfferId_First(
			groupId, offerId, orderByComparator);
	}

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer findByGroupIdAndOfferId_Last(
			long groupId, long offerId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByGroupIdAndOfferId_Last(
			groupId, offerId, orderByComparator);
	}

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchByGroupIdAndOfferId_Last(
		long groupId, long offerId,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().fetchByGroupIdAndOfferId_Last(
			groupId, offerId, orderByComparator);
	}

	/**
	 * Returns the user enroll offers before and after the current user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param userEnrollOfferPK the primary key of the current user enroll offer
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	public static UserEnrollOffer[] findByGroupIdAndOfferId_PrevAndNext(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK,
			long groupId, long offerId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByGroupIdAndOfferId_PrevAndNext(
			userEnrollOfferPK, groupId, offerId, orderByComparator);
	}

	/**
	 * Removes all the user enroll offers where groupId = &#63; and offerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 */
	public static void removeByGroupIdAndOfferId(long groupId, long offerId) {
		getPersistence().removeByGroupIdAndOfferId(groupId, offerId);
	}

	/**
	 * Returns the number of user enroll offers where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @return the number of matching user enroll offers
	 */
	public static int countByGroupIdAndOfferId(long groupId, long offerId) {
		return getPersistence().countByGroupIdAndOfferId(groupId, offerId);
	}

	/**
	 * Caches the user enroll offer in the entity cache if it is enabled.
	 *
	 * @param userEnrollOffer the user enroll offer
	 */
	public static void cacheResult(UserEnrollOffer userEnrollOffer) {
		getPersistence().cacheResult(userEnrollOffer);
	}

	/**
	 * Caches the user enroll offers in the entity cache if it is enabled.
	 *
	 * @param userEnrollOffers the user enroll offers
	 */
	public static void cacheResult(List<UserEnrollOffer> userEnrollOffers) {
		getPersistence().cacheResult(userEnrollOffers);
	}

	/**
	 * Creates a new user enroll offer with the primary key. Does not add the user enroll offer to the database.
	 *
	 * @param userEnrollOfferPK the primary key for the new user enroll offer
	 * @return the new user enroll offer
	 */
	public static UserEnrollOffer create(
		edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
			userEnrollOfferPK) {

		return getPersistence().create(userEnrollOfferPK);
	}

	/**
	 * Removes the user enroll offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer that was removed
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	public static UserEnrollOffer remove(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().remove(userEnrollOfferPK);
	}

	public static UserEnrollOffer updateImpl(UserEnrollOffer userEnrollOffer) {
		return getPersistence().updateImpl(userEnrollOffer);
	}

	/**
	 * Returns the user enroll offer with the primary key or throws a <code>NoSuchUserEnrollOfferException</code> if it could not be found.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	public static UserEnrollOffer findByPrimaryKey(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK)
		throws edu.uoc.mestemi.studentjob.exception.
			NoSuchUserEnrollOfferException {

		return getPersistence().findByPrimaryKey(userEnrollOfferPK);
	}

	/**
	 * Returns the user enroll offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer, or <code>null</code> if a user enroll offer with the primary key could not be found
	 */
	public static UserEnrollOffer fetchByPrimaryKey(
		edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
			userEnrollOfferPK) {

		return getPersistence().fetchByPrimaryKey(userEnrollOfferPK);
	}

	/**
	 * Returns all the user enroll offers.
	 *
	 * @return the user enroll offers
	 */
	public static List<UserEnrollOffer> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user enroll offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @return the range of user enroll offers
	 */
	public static List<UserEnrollOffer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user enroll offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user enroll offers
	 */
	public static List<UserEnrollOffer> findAll(
		int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user enroll offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user enroll offers
	 */
	public static List<UserEnrollOffer> findAll(
		int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user enroll offers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user enroll offers.
	 *
	 * @return the number of user enroll offers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static UserEnrollOfferPersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserEnrollOfferPersistence _persistence;

}