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

import edu.uoc.mestemi.studentjob.exception.NoSuchOfferException;
import edu.uoc.mestemi.studentjob.model.Offer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the offer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OfferUtil
 * @generated
 */
@ProviderType
public interface OfferPersistence extends BasePersistence<Offer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OfferUtil} to access the offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the offers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching offers
	 */
	public java.util.List<Offer> findByUuid(String uuid);

	/**
	 * Returns a range of all the offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of matching offers
	 */
	public java.util.List<Offer> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offers
	 */
	public java.util.List<Offer> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the offers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching offers
	 */
	public java.util.List<Offer> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public Offer findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Offer>
				orderByComparator)
		throws NoSuchOfferException;

	/**
	 * Returns the first offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public Offer fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator);

	/**
	 * Returns the last offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public Offer findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Offer>
				orderByComparator)
		throws NoSuchOfferException;

	/**
	 * Returns the last offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public Offer fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator);

	/**
	 * Returns the offers before and after the current offer in the ordered set where uuid = &#63;.
	 *
	 * @param offerId the primary key of the current offer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public Offer[] findByUuid_PrevAndNext(
			long offerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Offer>
				orderByComparator)
		throws NoSuchOfferException;

	/**
	 * Removes all the offers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of offers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching offers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the offer where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchOfferException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public Offer findByUUID_G(String uuid, long groupId)
		throws NoSuchOfferException;

	/**
	 * Returns the offer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public Offer fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the offer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public Offer fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the offer where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the offer that was removed
	 */
	public Offer removeByUUID_G(String uuid, long groupId)
		throws NoSuchOfferException;

	/**
	 * Returns the number of offers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching offers
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the offers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching offers
	 */
	public java.util.List<Offer> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the offers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of matching offers
	 */
	public java.util.List<Offer> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the offers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offers
	 */
	public java.util.List<Offer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the offers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching offers
	 */
	public java.util.List<Offer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first offer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public Offer findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Offer>
				orderByComparator)
		throws NoSuchOfferException;

	/**
	 * Returns the first offer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public Offer fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator);

	/**
	 * Returns the last offer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public Offer findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Offer>
				orderByComparator)
		throws NoSuchOfferException;

	/**
	 * Returns the last offer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public Offer fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator);

	/**
	 * Returns the offers before and after the current offer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param offerId the primary key of the current offer
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public Offer[] findByUuid_C_PrevAndNext(
			long offerId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Offer>
				orderByComparator)
		throws NoSuchOfferException;

	/**
	 * Removes all the offers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of offers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching offers
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the offer in the entity cache if it is enabled.
	 *
	 * @param offer the offer
	 */
	public void cacheResult(Offer offer);

	/**
	 * Caches the offers in the entity cache if it is enabled.
	 *
	 * @param offers the offers
	 */
	public void cacheResult(java.util.List<Offer> offers);

	/**
	 * Creates a new offer with the primary key. Does not add the offer to the database.
	 *
	 * @param offerId the primary key for the new offer
	 * @return the new offer
	 */
	public Offer create(long offerId);

	/**
	 * Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer that was removed
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public Offer remove(long offerId) throws NoSuchOfferException;

	public Offer updateImpl(Offer offer);

	/**
	 * Returns the offer with the primary key or throws a <code>NoSuchOfferException</code> if it could not be found.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public Offer findByPrimaryKey(long offerId) throws NoSuchOfferException;

	/**
	 * Returns the offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer, or <code>null</code> if a offer with the primary key could not be found
	 */
	public Offer fetchByPrimaryKey(long offerId);

	/**
	 * Returns all the offers.
	 *
	 * @return the offers
	 */
	public java.util.List<Offer> findAll();

	/**
	 * Returns a range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of offers
	 */
	public java.util.List<Offer> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of offers
	 */
	public java.util.List<Offer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of offers
	 */
	public java.util.List<Offer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the offers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of offers.
	 *
	 * @return the number of offers
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of degrees associated with the offer.
	 *
	 * @param pk the primary key of the offer
	 * @return long[] of the primaryKeys of degrees associated with the offer
	 */
	public long[] getDegreePrimaryKeys(long pk);

	/**
	 * Returns all the offer associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the offers associated with the degree
	 */
	public java.util.List<Offer> getDegreeOffers(long pk);

	/**
	 * Returns all the offer associated with the degree.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the degree
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of offers associated with the degree
	 */
	public java.util.List<Offer> getDegreeOffers(long pk, int start, int end);

	/**
	 * Returns all the offer associated with the degree.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the degree
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of offers associated with the degree
	 */
	public java.util.List<Offer> getDegreeOffers(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offer>
			orderByComparator);

	/**
	 * Returns the number of degrees associated with the offer.
	 *
	 * @param pk the primary key of the offer
	 * @return the number of degrees associated with the offer
	 */
	public int getDegreesSize(long pk);

	/**
	 * Returns <code>true</code> if the degree is associated with the offer.
	 *
	 * @param pk the primary key of the offer
	 * @param degreePK the primary key of the degree
	 * @return <code>true</code> if the degree is associated with the offer; <code>false</code> otherwise
	 */
	public boolean containsDegree(long pk, long degreePK);

	/**
	 * Returns <code>true</code> if the offer has any degrees associated with it.
	 *
	 * @param pk the primary key of the offer to check for associations with degrees
	 * @return <code>true</code> if the offer has any degrees associated with it; <code>false</code> otherwise
	 */
	public boolean containsDegrees(long pk);

	/**
	 * Adds an association between the offer and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer
	 * @param degreePK the primary key of the degree
	 */
	public void addDegree(long pk, long degreePK);

	/**
	 * Adds an association between the offer and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer
	 * @param degree the degree
	 */
	public void addDegree(
		long pk, edu.uoc.mestemi.studentjob.model.Degree degree);

	/**
	 * Adds an association between the offer and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer
	 * @param degreePKs the primary keys of the degrees
	 */
	public void addDegrees(long pk, long[] degreePKs);

	/**
	 * Adds an association between the offer and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer
	 * @param degrees the degrees
	 */
	public void addDegrees(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees);

	/**
	 * Clears all associations between the offer and its degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer to clear the associated degrees from
	 */
	public void clearDegrees(long pk);

	/**
	 * Removes the association between the offer and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer
	 * @param degreePK the primary key of the degree
	 */
	public void removeDegree(long pk, long degreePK);

	/**
	 * Removes the association between the offer and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer
	 * @param degree the degree
	 */
	public void removeDegree(
		long pk, edu.uoc.mestemi.studentjob.model.Degree degree);

	/**
	 * Removes the association between the offer and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer
	 * @param degreePKs the primary keys of the degrees
	 */
	public void removeDegrees(long pk, long[] degreePKs);

	/**
	 * Removes the association between the offer and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer
	 * @param degrees the degrees
	 */
	public void removeDegrees(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees);

	/**
	 * Sets the degrees associated with the offer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer
	 * @param degreePKs the primary keys of the degrees to be associated with the offer
	 */
	public void setDegrees(long pk, long[] degreePKs);

	/**
	 * Sets the degrees associated with the offer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the offer
	 * @param degrees the degrees to be associated with the offer
	 */
	public void setDegrees(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees);

}