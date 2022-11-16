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

import edu.uoc.mestemi.studentjob.exception.NoSuchCompanyProfileException;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the company profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompanyProfileUtil
 * @generated
 */
@ProviderType
public interface CompanyProfilePersistence
	extends BasePersistence<CompanyProfile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompanyProfileUtil} to access the company profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the company profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching company profiles
	 */
	public java.util.List<CompanyProfile> findByUuid(String uuid);

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
	public java.util.List<CompanyProfile> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CompanyProfile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
			orderByComparator);

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
	public java.util.List<CompanyProfile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public CompanyProfile findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
				orderByComparator)
		throws NoSuchCompanyProfileException;

	/**
	 * Returns the first company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public CompanyProfile fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
			orderByComparator);

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public CompanyProfile findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
				orderByComparator)
		throws NoSuchCompanyProfileException;

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public CompanyProfile fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
			orderByComparator);

	/**
	 * Returns the company profiles before and after the current company profile in the ordered set where uuid = &#63;.
	 *
	 * @param companyProfileId the primary key of the current company profile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	public CompanyProfile[] findByUuid_PrevAndNext(
			long companyProfileId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
				orderByComparator)
		throws NoSuchCompanyProfileException;

	/**
	 * Removes all the company profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of company profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching company profiles
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the company profile where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCompanyProfileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public CompanyProfile findByUUID_G(String uuid, long groupId)
		throws NoSuchCompanyProfileException;

	/**
	 * Returns the company profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public CompanyProfile fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the company profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public CompanyProfile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the company profile where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the company profile that was removed
	 */
	public CompanyProfile removeByUUID_G(String uuid, long groupId)
		throws NoSuchCompanyProfileException;

	/**
	 * Returns the number of company profiles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching company profiles
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the company profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching company profiles
	 */
	public java.util.List<CompanyProfile> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CompanyProfile> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CompanyProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
			orderByComparator);

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
	public java.util.List<CompanyProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public CompanyProfile findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
				orderByComparator)
		throws NoSuchCompanyProfileException;

	/**
	 * Returns the first company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public CompanyProfile fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
			orderByComparator);

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	public CompanyProfile findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
				orderByComparator)
		throws NoSuchCompanyProfileException;

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public CompanyProfile fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
			orderByComparator);

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
	public CompanyProfile[] findByUuid_C_PrevAndNext(
			long companyProfileId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
				orderByComparator)
		throws NoSuchCompanyProfileException;

	/**
	 * Removes all the company profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of company profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching company profiles
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the company profile in the entity cache if it is enabled.
	 *
	 * @param companyProfile the company profile
	 */
	public void cacheResult(CompanyProfile companyProfile);

	/**
	 * Caches the company profiles in the entity cache if it is enabled.
	 *
	 * @param companyProfiles the company profiles
	 */
	public void cacheResult(java.util.List<CompanyProfile> companyProfiles);

	/**
	 * Creates a new company profile with the primary key. Does not add the company profile to the database.
	 *
	 * @param companyProfileId the primary key for the new company profile
	 * @return the new company profile
	 */
	public CompanyProfile create(long companyProfileId);

	/**
	 * Removes the company profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile that was removed
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	public CompanyProfile remove(long companyProfileId)
		throws NoSuchCompanyProfileException;

	public CompanyProfile updateImpl(CompanyProfile companyProfile);

	/**
	 * Returns the company profile with the primary key or throws a <code>NoSuchCompanyProfileException</code> if it could not be found.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	public CompanyProfile findByPrimaryKey(long companyProfileId)
		throws NoSuchCompanyProfileException;

	/**
	 * Returns the company profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile, or <code>null</code> if a company profile with the primary key could not be found
	 */
	public CompanyProfile fetchByPrimaryKey(long companyProfileId);

	/**
	 * Returns all the company profiles.
	 *
	 * @return the company profiles
	 */
	public java.util.List<CompanyProfile> findAll();

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
	public java.util.List<CompanyProfile> findAll(int start, int end);

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
	public java.util.List<CompanyProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
			orderByComparator);

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
	public java.util.List<CompanyProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompanyProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the company profiles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of company profiles.
	 *
	 * @return the number of company profiles
	 */
	public int countAll();

}