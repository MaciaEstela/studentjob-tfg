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

import edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException;
import edu.uoc.mestemi.studentjob.model.Degree;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the degree service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DegreeUtil
 * @generated
 */
@ProviderType
public interface DegreePersistence extends BasePersistence<Degree> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DegreeUtil} to access the degree persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the degrees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching degrees
	 */
	public java.util.List<Degree> findByUuid(String uuid);

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
	public java.util.List<Degree> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Degree> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator);

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
	public java.util.List<Degree> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public Degree findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Degree>
				orderByComparator)
		throws NoSuchDegreeException;

	/**
	 * Returns the first degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public Degree fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator);

	/**
	 * Returns the last degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public Degree findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Degree>
				orderByComparator)
		throws NoSuchDegreeException;

	/**
	 * Returns the last degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public Degree fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator);

	/**
	 * Returns the degrees before and after the current degree in the ordered set where uuid = &#63;.
	 *
	 * @param degreeId the primary key of the current degree
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next degree
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	public Degree[] findByUuid_PrevAndNext(
			long degreeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Degree>
				orderByComparator)
		throws NoSuchDegreeException;

	/**
	 * Removes all the degrees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of degrees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching degrees
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the degree where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDegreeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public Degree findByUUID_G(String uuid, long groupId)
		throws NoSuchDegreeException;

	/**
	 * Returns the degree where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public Degree fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the degree where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public Degree fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the degree where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the degree that was removed
	 */
	public Degree removeByUUID_G(String uuid, long groupId)
		throws NoSuchDegreeException;

	/**
	 * Returns the number of degrees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching degrees
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the degrees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching degrees
	 */
	public java.util.List<Degree> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Degree> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Degree> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator);

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
	public java.util.List<Degree> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public Degree findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Degree>
				orderByComparator)
		throws NoSuchDegreeException;

	/**
	 * Returns the first degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public Degree fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator);

	/**
	 * Returns the last degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	public Degree findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Degree>
				orderByComparator)
		throws NoSuchDegreeException;

	/**
	 * Returns the last degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public Degree fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator);

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
	public Degree[] findByUuid_C_PrevAndNext(
			long degreeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Degree>
				orderByComparator)
		throws NoSuchDegreeException;

	/**
	 * Removes all the degrees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of degrees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching degrees
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the degree in the entity cache if it is enabled.
	 *
	 * @param degree the degree
	 */
	public void cacheResult(Degree degree);

	/**
	 * Caches the degrees in the entity cache if it is enabled.
	 *
	 * @param degrees the degrees
	 */
	public void cacheResult(java.util.List<Degree> degrees);

	/**
	 * Creates a new degree with the primary key. Does not add the degree to the database.
	 *
	 * @param degreeId the primary key for the new degree
	 * @return the new degree
	 */
	public Degree create(long degreeId);

	/**
	 * Removes the degree with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree that was removed
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	public Degree remove(long degreeId) throws NoSuchDegreeException;

	public Degree updateImpl(Degree degree);

	/**
	 * Returns the degree with the primary key or throws a <code>NoSuchDegreeException</code> if it could not be found.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	public Degree findByPrimaryKey(long degreeId) throws NoSuchDegreeException;

	/**
	 * Returns the degree with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree, or <code>null</code> if a degree with the primary key could not be found
	 */
	public Degree fetchByPrimaryKey(long degreeId);

	/**
	 * Returns all the degrees.
	 *
	 * @return the degrees
	 */
	public java.util.List<Degree> findAll();

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
	public java.util.List<Degree> findAll(int start, int end);

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
	public java.util.List<Degree> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator);

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
	public java.util.List<Degree> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the degrees from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of degrees.
	 *
	 * @return the number of degrees
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of degree areas associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return long[] of the primaryKeys of degree areas associated with the degree
	 */
	public long[] getDegreeAreaPrimaryKeys(long pk);

	/**
	 * Returns all the degree associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @return the degrees associated with the degree area
	 */
	public java.util.List<Degree> getDegreeAreaDegrees(long pk);

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
	public java.util.List<Degree> getDegreeAreaDegrees(
		long pk, int start, int end);

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
	public java.util.List<Degree> getDegreeAreaDegrees(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator);

	/**
	 * Returns the number of degree areas associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the number of degree areas associated with the degree
	 */
	public int getDegreeAreasSize(long pk);

	/**
	 * Returns <code>true</code> if the degree area is associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPK the primary key of the degree area
	 * @return <code>true</code> if the degree area is associated with the degree; <code>false</code> otherwise
	 */
	public boolean containsDegreeArea(long pk, long degreeAreaPK);

	/**
	 * Returns <code>true</code> if the degree has any degree areas associated with it.
	 *
	 * @param pk the primary key of the degree to check for associations with degree areas
	 * @return <code>true</code> if the degree has any degree areas associated with it; <code>false</code> otherwise
	 */
	public boolean containsDegreeAreas(long pk);

	/**
	 * Adds an association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPK the primary key of the degree area
	 */
	public void addDegreeArea(long pk, long degreeAreaPK);

	/**
	 * Adds an association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeArea the degree area
	 */
	public void addDegreeArea(
		long pk, edu.uoc.mestemi.studentjob.model.DegreeArea degreeArea);

	/**
	 * Adds an association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPKs the primary keys of the degree areas
	 */
	public void addDegreeAreas(long pk, long[] degreeAreaPKs);

	/**
	 * Adds an association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreas the degree areas
	 */
	public void addDegreeAreas(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
			degreeAreas);

	/**
	 * Clears all associations between the degree and its degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree to clear the associated degree areas from
	 */
	public void clearDegreeAreas(long pk);

	/**
	 * Removes the association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPK the primary key of the degree area
	 */
	public void removeDegreeArea(long pk, long degreeAreaPK);

	/**
	 * Removes the association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeArea the degree area
	 */
	public void removeDegreeArea(
		long pk, edu.uoc.mestemi.studentjob.model.DegreeArea degreeArea);

	/**
	 * Removes the association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPKs the primary keys of the degree areas
	 */
	public void removeDegreeAreas(long pk, long[] degreeAreaPKs);

	/**
	 * Removes the association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreas the degree areas
	 */
	public void removeDegreeAreas(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
			degreeAreas);

	/**
	 * Sets the degree areas associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPKs the primary keys of the degree areas to be associated with the degree
	 */
	public void setDegreeAreas(long pk, long[] degreeAreaPKs);

	/**
	 * Sets the degree areas associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreas the degree areas to be associated with the degree
	 */
	public void setDegreeAreas(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
			degreeAreas);

	/**
	 * Returns the primaryKeys of student profiles associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return long[] of the primaryKeys of student profiles associated with the degree
	 */
	public long[] getStudentProfilePrimaryKeys(long pk);

	/**
	 * Returns all the degree associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @return the degrees associated with the student profile
	 */
	public java.util.List<Degree> getStudentProfileDegrees(long pk);

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
	public java.util.List<Degree> getStudentProfileDegrees(
		long pk, int start, int end);

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
	public java.util.List<Degree> getStudentProfileDegrees(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator);

	/**
	 * Returns the number of student profiles associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the number of student profiles associated with the degree
	 */
	public int getStudentProfilesSize(long pk);

	/**
	 * Returns <code>true</code> if the student profile is associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePK the primary key of the student profile
	 * @return <code>true</code> if the student profile is associated with the degree; <code>false</code> otherwise
	 */
	public boolean containsStudentProfile(long pk, long studentProfilePK);

	/**
	 * Returns <code>true</code> if the degree has any student profiles associated with it.
	 *
	 * @param pk the primary key of the degree to check for associations with student profiles
	 * @return <code>true</code> if the degree has any student profiles associated with it; <code>false</code> otherwise
	 */
	public boolean containsStudentProfiles(long pk);

	/**
	 * Adds an association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePK the primary key of the student profile
	 */
	public void addStudentProfile(long pk, long studentProfilePK);

	/**
	 * Adds an association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfile the student profile
	 */
	public void addStudentProfile(
		long pk,
		edu.uoc.mestemi.studentjob.model.StudentProfile studentProfile);

	/**
	 * Adds an association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePKs the primary keys of the student profiles
	 */
	public void addStudentProfiles(long pk, long[] studentProfilePKs);

	/**
	 * Adds an association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfiles the student profiles
	 */
	public void addStudentProfiles(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
			studentProfiles);

	/**
	 * Clears all associations between the degree and its student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree to clear the associated student profiles from
	 */
	public void clearStudentProfiles(long pk);

	/**
	 * Removes the association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePK the primary key of the student profile
	 */
	public void removeStudentProfile(long pk, long studentProfilePK);

	/**
	 * Removes the association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfile the student profile
	 */
	public void removeStudentProfile(
		long pk,
		edu.uoc.mestemi.studentjob.model.StudentProfile studentProfile);

	/**
	 * Removes the association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePKs the primary keys of the student profiles
	 */
	public void removeStudentProfiles(long pk, long[] studentProfilePKs);

	/**
	 * Removes the association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfiles the student profiles
	 */
	public void removeStudentProfiles(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
			studentProfiles);

	/**
	 * Sets the student profiles associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePKs the primary keys of the student profiles to be associated with the degree
	 */
	public void setStudentProfiles(long pk, long[] studentProfilePKs);

	/**
	 * Sets the student profiles associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfiles the student profiles to be associated with the degree
	 */
	public void setStudentProfiles(
		long pk,
		java.util.List<edu.uoc.mestemi.studentjob.model.StudentProfile>
			studentProfiles);

	/**
	 * Returns the primaryKeys of offers associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return long[] of the primaryKeys of offers associated with the degree
	 */
	public long[] getOfferPrimaryKeys(long pk);

	/**
	 * Returns all the degree associated with the offer.
	 *
	 * @param pk the primary key of the offer
	 * @return the degrees associated with the offer
	 */
	public java.util.List<Degree> getOfferDegrees(long pk);

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
	public java.util.List<Degree> getOfferDegrees(long pk, int start, int end);

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
	public java.util.List<Degree> getOfferDegrees(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Degree>
			orderByComparator);

	/**
	 * Returns the number of offers associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the number of offers associated with the degree
	 */
	public int getOffersSize(long pk);

	/**
	 * Returns <code>true</code> if the offer is associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPK the primary key of the offer
	 * @return <code>true</code> if the offer is associated with the degree; <code>false</code> otherwise
	 */
	public boolean containsOffer(long pk, long offerPK);

	/**
	 * Returns <code>true</code> if the degree has any offers associated with it.
	 *
	 * @param pk the primary key of the degree to check for associations with offers
	 * @return <code>true</code> if the degree has any offers associated with it; <code>false</code> otherwise
	 */
	public boolean containsOffers(long pk);

	/**
	 * Adds an association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPK the primary key of the offer
	 */
	public void addOffer(long pk, long offerPK);

	/**
	 * Adds an association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offer the offer
	 */
	public void addOffer(long pk, edu.uoc.mestemi.studentjob.model.Offer offer);

	/**
	 * Adds an association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPKs the primary keys of the offers
	 */
	public void addOffers(long pk, long[] offerPKs);

	/**
	 * Adds an association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offers the offers
	 */
	public void addOffers(
		long pk, java.util.List<edu.uoc.mestemi.studentjob.model.Offer> offers);

	/**
	 * Clears all associations between the degree and its offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree to clear the associated offers from
	 */
	public void clearOffers(long pk);

	/**
	 * Removes the association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPK the primary key of the offer
	 */
	public void removeOffer(long pk, long offerPK);

	/**
	 * Removes the association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offer the offer
	 */
	public void removeOffer(
		long pk, edu.uoc.mestemi.studentjob.model.Offer offer);

	/**
	 * Removes the association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPKs the primary keys of the offers
	 */
	public void removeOffers(long pk, long[] offerPKs);

	/**
	 * Removes the association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offers the offers
	 */
	public void removeOffers(
		long pk, java.util.List<edu.uoc.mestemi.studentjob.model.Offer> offers);

	/**
	 * Sets the offers associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPKs the primary keys of the offers to be associated with the degree
	 */
	public void setOffers(long pk, long[] offerPKs);

	/**
	 * Sets the offers associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offers the offers to be associated with the degree
	 */
	public void setOffers(
		long pk, java.util.List<edu.uoc.mestemi.studentjob.model.Offer> offers);

}