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

import edu.uoc.mestemi.studentjob.exception.NoSuchUserEnrollOfferException;
import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;

import java.util.Date;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user enroll offer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserEnrollOfferUtil
 * @generated
 */
@ProviderType
public interface UserEnrollOfferPersistence
	extends BasePersistence<UserEnrollOffer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserEnrollOfferUtil} to access the user enroll offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user enroll offers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user enroll offers
	 */
	public java.util.List<UserEnrollOffer> findByUuid(String uuid);

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
	public java.util.List<UserEnrollOffer> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<UserEnrollOffer> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

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
	public java.util.List<UserEnrollOffer> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the first user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

	/**
	 * Returns the last user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the last user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

	/**
	 * Returns the user enroll offers before and after the current user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param userEnrollOfferPK the primary key of the current user enroll offer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	public UserEnrollOffer[] findByUuid_PrevAndNext(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK,
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Removes all the user enroll offers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user enroll offers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user enroll offers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the user enroll offer where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserEnrollOfferException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer findByUUID_G(String uuid, long groupId)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the user enroll offer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the user enroll offer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the user enroll offer where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user enroll offer that was removed
	 */
	public UserEnrollOffer removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the number of user enroll offers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user enroll offers
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the user enroll offers where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching user enroll offers
	 */
	public java.util.List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId);

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
	public java.util.List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end);

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
	public java.util.List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

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
	public java.util.List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer findByGroupIdAndUserId_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByGroupIdAndUserId_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer findByGroupIdAndUserId_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByGroupIdAndUserId_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

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
	public UserEnrollOffer[] findByGroupIdAndUserId_PrevAndNext(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK,
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Removes all the user enroll offers where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByGroupIdAndUserId(long groupId, long userId);

	/**
	 * Returns the number of user enroll offers where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching user enroll offers
	 */
	public int countByGroupIdAndUserId(long groupId, long userId);

	/**
	 * Returns the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; or throws a <code>NoSuchUserEnrollOfferException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer findByGroupIdAndUserIdAndOfferId(
			long groupId, long userId, long offerId)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByGroupIdAndUserIdAndOfferId(
		long groupId, long userId, long offerId);

	/**
	 * Returns the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByGroupIdAndUserIdAndOfferId(
		long groupId, long userId, long offerId, boolean useFinderCache);

	/**
	 * Removes the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the user enroll offer that was removed
	 */
	public UserEnrollOffer removeByGroupIdAndUserIdAndOfferId(
			long groupId, long userId, long offerId)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the number of user enroll offers where groupId = &#63; and userId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the number of matching user enroll offers
	 */
	public int countByGroupIdAndUserIdAndOfferId(
		long groupId, long userId, long offerId);

	/**
	 * Returns all the user enroll offers where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @return the matching user enroll offers
	 */
	public java.util.List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId);

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
	public java.util.List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId, int start, int end);

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
	public java.util.List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

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
	public java.util.List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer findByGroupIdAndOfferId_First(
			long groupId, long offerId,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByGroupIdAndOfferId_First(
		long groupId, long offerId,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer findByGroupIdAndOfferId_Last(
			long groupId, long offerId,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByGroupIdAndOfferId_Last(
		long groupId, long offerId,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

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
	public UserEnrollOffer[] findByGroupIdAndOfferId_PrevAndNext(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK,
			long groupId, long offerId,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Removes all the user enroll offers where groupId = &#63; and offerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 */
	public void removeByGroupIdAndOfferId(long groupId, long offerId);

	/**
	 * Returns the number of user enroll offers where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @return the number of matching user enroll offers
	 */
	public int countByGroupIdAndOfferId(long groupId, long offerId);

	/**
	 * Returns all the user enroll offers where groupId = &#63; and offerId = &#63; and createDate &gt; &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 * @return the matching user enroll offers
	 */
	public java.util.List<UserEnrollOffer>
		findByGroupIdAndOfferIdAndCreateDateGT(
			long groupId, long offerId, Date createDate);

	/**
	 * Returns a range of all the user enroll offers where groupId = &#63; and offerId = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @return the range of matching user enroll offers
	 */
	public java.util.List<UserEnrollOffer>
		findByGroupIdAndOfferIdAndCreateDateGT(
			long groupId, long offerId, Date createDate, int start, int end);

	/**
	 * Returns an ordered range of all the user enroll offers where groupId = &#63; and offerId = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user enroll offers
	 */
	public java.util.List<UserEnrollOffer>
		findByGroupIdAndOfferIdAndCreateDateGT(
			long groupId, long offerId, Date createDate, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator);

	/**
	 * Returns an ordered range of all the user enroll offers where groupId = &#63; and offerId = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user enroll offers
	 */
	public java.util.List<UserEnrollOffer>
		findByGroupIdAndOfferIdAndCreateDateGT(
			long groupId, long offerId, Date createDate, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and offerId = &#63; and createDate &gt; &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer findByGroupIdAndOfferIdAndCreateDateGT_First(
			long groupId, long offerId, Date createDate,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and offerId = &#63; and createDate &gt; &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByGroupIdAndOfferIdAndCreateDateGT_First(
		long groupId, long offerId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and offerId = &#63; and createDate &gt; &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer findByGroupIdAndOfferIdAndCreateDateGT_Last(
			long groupId, long offerId, Date createDate,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and offerId = &#63; and createDate &gt; &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public UserEnrollOffer fetchByGroupIdAndOfferIdAndCreateDateGT_Last(
		long groupId, long offerId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

	/**
	 * Returns the user enroll offers before and after the current user enroll offer in the ordered set where groupId = &#63; and offerId = &#63; and createDate &gt; &#63;.
	 *
	 * @param userEnrollOfferPK the primary key of the current user enroll offer
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	public UserEnrollOffer[] findByGroupIdAndOfferIdAndCreateDateGT_PrevAndNext(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK,
			long groupId, long offerId, Date createDate,
			com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
				orderByComparator)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Removes all the user enroll offers where groupId = &#63; and offerId = &#63; and createDate &gt; &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 */
	public void removeByGroupIdAndOfferIdAndCreateDateGT(
		long groupId, long offerId, Date createDate);

	/**
	 * Returns the number of user enroll offers where groupId = &#63; and offerId = &#63; and createDate &gt; &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param createDate the create date
	 * @return the number of matching user enroll offers
	 */
	public int countByGroupIdAndOfferIdAndCreateDateGT(
		long groupId, long offerId, Date createDate);

	/**
	 * Caches the user enroll offer in the entity cache if it is enabled.
	 *
	 * @param userEnrollOffer the user enroll offer
	 */
	public void cacheResult(UserEnrollOffer userEnrollOffer);

	/**
	 * Caches the user enroll offers in the entity cache if it is enabled.
	 *
	 * @param userEnrollOffers the user enroll offers
	 */
	public void cacheResult(java.util.List<UserEnrollOffer> userEnrollOffers);

	/**
	 * Creates a new user enroll offer with the primary key. Does not add the user enroll offer to the database.
	 *
	 * @param userEnrollOfferPK the primary key for the new user enroll offer
	 * @return the new user enroll offer
	 */
	public UserEnrollOffer create(
		edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
			userEnrollOfferPK);

	/**
	 * Removes the user enroll offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer that was removed
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	public UserEnrollOffer remove(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK)
		throws NoSuchUserEnrollOfferException;

	public UserEnrollOffer updateImpl(UserEnrollOffer userEnrollOffer);

	/**
	 * Returns the user enroll offer with the primary key or throws a <code>NoSuchUserEnrollOfferException</code> if it could not be found.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	public UserEnrollOffer findByPrimaryKey(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK)
		throws NoSuchUserEnrollOfferException;

	/**
	 * Returns the user enroll offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer, or <code>null</code> if a user enroll offer with the primary key could not be found
	 */
	public UserEnrollOffer fetchByPrimaryKey(
		edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
			userEnrollOfferPK);

	/**
	 * Returns all the user enroll offers.
	 *
	 * @return the user enroll offers
	 */
	public java.util.List<UserEnrollOffer> findAll();

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
	public java.util.List<UserEnrollOffer> findAll(int start, int end);

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
	public java.util.List<UserEnrollOffer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator);

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
	public java.util.List<UserEnrollOffer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserEnrollOffer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user enroll offers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user enroll offers.
	 *
	 * @return the number of user enroll offers
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}