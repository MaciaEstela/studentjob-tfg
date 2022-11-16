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

import edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException;
import edu.uoc.mestemi.studentjob.model.DegreeArea;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the degree area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DegreeAreaUtil
 * @generated
 */
@ProviderType
public interface DegreeAreaPersistence extends BasePersistence<DegreeArea> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DegreeAreaUtil} to access the degree area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the degree areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching degree areas
	 */
	public java.util.List<DegreeArea> findByUuid(String uuid);

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
	public java.util.List<DegreeArea> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<DegreeArea> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator);

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
	public java.util.List<DegreeArea> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	public DegreeArea findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
				orderByComparator)
		throws NoSuchDegreeAreaException;

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public DegreeArea fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator);

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	public DegreeArea findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
				orderByComparator)
		throws NoSuchDegreeAreaException;

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public DegreeArea fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator);

	/**
	 * Returns the degree areas before and after the current degree area in the ordered set where uuid = &#63;.
	 *
	 * @param degreeAreaId the primary key of the current degree area
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next degree area
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	public DegreeArea[] findByUuid_PrevAndNext(
			long degreeAreaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
				orderByComparator)
		throws NoSuchDegreeAreaException;

	/**
	 * Removes all the degree areas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of degree areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching degree areas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the degree area where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDegreeAreaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	public DegreeArea findByUUID_G(String uuid, long groupId)
		throws NoSuchDegreeAreaException;

	/**
	 * Returns the degree area where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public DegreeArea fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the degree area where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public DegreeArea fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the degree area where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the degree area that was removed
	 */
	public DegreeArea removeByUUID_G(String uuid, long groupId)
		throws NoSuchDegreeAreaException;

	/**
	 * Returns the number of degree areas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching degree areas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the degree areas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching degree areas
	 */
	public java.util.List<DegreeArea> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<DegreeArea> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<DegreeArea> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator);

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
	public java.util.List<DegreeArea> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	public DegreeArea findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
				orderByComparator)
		throws NoSuchDegreeAreaException;

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public DegreeArea fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator);

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	public DegreeArea findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
				orderByComparator)
		throws NoSuchDegreeAreaException;

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public DegreeArea fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator);

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
	public DegreeArea[] findByUuid_C_PrevAndNext(
			long degreeAreaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
				orderByComparator)
		throws NoSuchDegreeAreaException;

	/**
	 * Removes all the degree areas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of degree areas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching degree areas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the degree area in the entity cache if it is enabled.
	 *
	 * @param degreeArea the degree area
	 */
	public void cacheResult(DegreeArea degreeArea);

	/**
	 * Caches the degree areas in the entity cache if it is enabled.
	 *
	 * @param degreeAreas the degree areas
	 */
	public void cacheResult(java.util.List<DegreeArea> degreeAreas);

	/**
	 * Creates a new degree area with the primary key. Does not add the degree area to the database.
	 *
	 * @param degreeAreaId the primary key for the new degree area
	 * @return the new degree area
	 */
	public DegreeArea create(long degreeAreaId);

	/**
	 * Removes the degree area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area that was removed
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	public DegreeArea remove(long degreeAreaId)
		throws NoSuchDegreeAreaException;

	public DegreeArea updateImpl(DegreeArea degreeArea);

	/**
	 * Returns the degree area with the primary key or throws a <code>NoSuchDegreeAreaException</code> if it could not be found.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	public DegreeArea findByPrimaryKey(long degreeAreaId)
		throws NoSuchDegreeAreaException;

	/**
	 * Returns the degree area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area, or <code>null</code> if a degree area with the primary key could not be found
	 */
	public DegreeArea fetchByPrimaryKey(long degreeAreaId);

	/**
	 * Returns all the degree areas.
	 *
	 * @return the degree areas
	 */
	public java.util.List<DegreeArea> findAll();

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
	public java.util.List<DegreeArea> findAll(int start, int end);

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
	public java.util.List<DegreeArea> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator);

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
	public java.util.List<DegreeArea> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the degree areas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of degree areas.
	 *
	 * @return the number of degree areas
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of degrees associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @return long[] of the primaryKeys of degrees associated with the degree area
	 */
	public long[] getDegreePrimaryKeys(long pk);

	/**
	 * Returns all the degree area associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the degree areas associated with the degree
	 */
	public java.util.List<DegreeArea> getDegreeDegreeAreas(long pk);

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
	public java.util.List<DegreeArea> getDegreeDegreeAreas(
		long pk, int start, int end);

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
	public java.util.List<DegreeArea> getDegreeDegreeAreas(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DegreeArea>
			orderByComparator);

	/**
	 * Returns the number of degrees associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @return the number of degrees associated with the degree area
	 */
	public int getDegreesSize(long pk);

	/**
	 * Returns <code>true</code> if the degree is associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePK the primary key of the degree
	 * @return <code>true</code> if the degree is associated with the degree area; <code>false</code> otherwise
	 */
	public boolean containsDegree(long pk, long degreePK);

	/**
	 * Returns <code>true</code> if the degree area has any degrees associated with it.
	 *
	 * @param pk the primary key of the degree area to check for associations with degrees
	 * @return <code>true</code> if the degree area has any degrees associated with it; <code>false</code> otherwise
	 */
	public boolean containsDegrees(long pk);

	/**
	 * Adds an association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePK the primary key of the degree
	 */
	public void addDegree(long pk, long degreePK);

	/**
	 * Adds an association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degree the degree
	 */
	public void addDegree(
		long pk, edu.uoc.mestemi.studentjob.model.Degree degree);

	/**
	 * Adds an association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePKs the primary keys of the degrees
	 */
	public void addDegrees(long pk, long[] degreePKs);

	/**
	 * Adds an association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degrees the degrees
	 */
	public void addDegrees(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees);

	/**
	 * Clears all associations between the degree area and its degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area to clear the associated degrees from
	 */
	public void clearDegrees(long pk);

	/**
	 * Removes the association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePK the primary key of the degree
	 */
	public void removeDegree(long pk, long degreePK);

	/**
	 * Removes the association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degree the degree
	 */
	public void removeDegree(
		long pk, edu.uoc.mestemi.studentjob.model.Degree degree);

	/**
	 * Removes the association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePKs the primary keys of the degrees
	 */
	public void removeDegrees(long pk, long[] degreePKs);

	/**
	 * Removes the association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degrees the degrees
	 */
	public void removeDegrees(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees);

	/**
	 * Sets the degrees associated with the degree area, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePKs the primary keys of the degrees to be associated with the degree area
	 */
	public void setDegrees(long pk, long[] degreePKs);

	/**
	 * Sets the degrees associated with the degree area, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degrees the degrees to be associated with the degree area
	 */
	public void setDegrees(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees);

}