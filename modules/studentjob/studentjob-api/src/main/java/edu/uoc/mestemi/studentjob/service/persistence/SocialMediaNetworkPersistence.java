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

import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaNetworkException;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the social media network service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaNetworkUtil
 * @generated
 */
@ProviderType
public interface SocialMediaNetworkPersistence
	extends BasePersistence<SocialMediaNetwork> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialMediaNetworkUtil} to access the social media network persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the social media networks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social media networks
	 */
	public java.util.List<SocialMediaNetwork> findByUuid(String uuid);

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
	public java.util.List<SocialMediaNetwork> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SocialMediaNetwork> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
			orderByComparator);

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
	public java.util.List<SocialMediaNetwork> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public SocialMediaNetwork findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
				orderByComparator)
		throws NoSuchSocialMediaNetworkException;

	/**
	 * Returns the first social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public SocialMediaNetwork fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
			orderByComparator);

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public SocialMediaNetwork findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
				orderByComparator)
		throws NoSuchSocialMediaNetworkException;

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public SocialMediaNetwork fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
			orderByComparator);

	/**
	 * Returns the social media networks before and after the current social media network in the ordered set where uuid = &#63;.
	 *
	 * @param socialMediaNetworkId the primary key of the current social media network
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media network
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	public SocialMediaNetwork[] findByUuid_PrevAndNext(
			long socialMediaNetworkId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
				orderByComparator)
		throws NoSuchSocialMediaNetworkException;

	/**
	 * Removes all the social media networks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of social media networks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social media networks
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the social media network where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSocialMediaNetworkException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public SocialMediaNetwork findByUUID_G(String uuid, long groupId)
		throws NoSuchSocialMediaNetworkException;

	/**
	 * Returns the social media network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public SocialMediaNetwork fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the social media network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public SocialMediaNetwork fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the social media network where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social media network that was removed
	 */
	public SocialMediaNetwork removeByUUID_G(String uuid, long groupId)
		throws NoSuchSocialMediaNetworkException;

	/**
	 * Returns the number of social media networks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social media networks
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the social media networks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social media networks
	 */
	public java.util.List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
			orderByComparator);

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
	public java.util.List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public SocialMediaNetwork findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
				orderByComparator)
		throws NoSuchSocialMediaNetworkException;

	/**
	 * Returns the first social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public SocialMediaNetwork fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
			orderByComparator);

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	public SocialMediaNetwork findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
				orderByComparator)
		throws NoSuchSocialMediaNetworkException;

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public SocialMediaNetwork fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
			orderByComparator);

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
	public SocialMediaNetwork[] findByUuid_C_PrevAndNext(
			long socialMediaNetworkId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
				orderByComparator)
		throws NoSuchSocialMediaNetworkException;

	/**
	 * Removes all the social media networks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of social media networks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social media networks
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the social media network in the entity cache if it is enabled.
	 *
	 * @param socialMediaNetwork the social media network
	 */
	public void cacheResult(SocialMediaNetwork socialMediaNetwork);

	/**
	 * Caches the social media networks in the entity cache if it is enabled.
	 *
	 * @param socialMediaNetworks the social media networks
	 */
	public void cacheResult(
		java.util.List<SocialMediaNetwork> socialMediaNetworks);

	/**
	 * Creates a new social media network with the primary key. Does not add the social media network to the database.
	 *
	 * @param socialMediaNetworkId the primary key for the new social media network
	 * @return the new social media network
	 */
	public SocialMediaNetwork create(long socialMediaNetworkId);

	/**
	 * Removes the social media network with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network that was removed
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	public SocialMediaNetwork remove(long socialMediaNetworkId)
		throws NoSuchSocialMediaNetworkException;

	public SocialMediaNetwork updateImpl(SocialMediaNetwork socialMediaNetwork);

	/**
	 * Returns the social media network with the primary key or throws a <code>NoSuchSocialMediaNetworkException</code> if it could not be found.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	public SocialMediaNetwork findByPrimaryKey(long socialMediaNetworkId)
		throws NoSuchSocialMediaNetworkException;

	/**
	 * Returns the social media network with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network, or <code>null</code> if a social media network with the primary key could not be found
	 */
	public SocialMediaNetwork fetchByPrimaryKey(long socialMediaNetworkId);

	/**
	 * Returns all the social media networks.
	 *
	 * @return the social media networks
	 */
	public java.util.List<SocialMediaNetwork> findAll();

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
	public java.util.List<SocialMediaNetwork> findAll(int start, int end);

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
	public java.util.List<SocialMediaNetwork> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
			orderByComparator);

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
	public java.util.List<SocialMediaNetwork> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMediaNetwork>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the social media networks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of social media networks.
	 *
	 * @return the number of social media networks
	 */
	public int countAll();

}