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

package edu.uoc.mestemi.studentjob.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.DegreeArea;
import edu.uoc.mestemi.studentjob.model.DegreeAreaTable;
import edu.uoc.mestemi.studentjob.model.impl.DegreeAreaImpl;
import edu.uoc.mestemi.studentjob.model.impl.DegreeAreaModelImpl;
import edu.uoc.mestemi.studentjob.service.persistence.DegreeAreaPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.DegreeAreaUtil;
import edu.uoc.mestemi.studentjob.service.persistence.impl.constants.SJobPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the degree area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DegreeAreaPersistence.class, BasePersistence.class})
public class DegreeAreaPersistenceImpl
	extends BasePersistenceImpl<DegreeArea> implements DegreeAreaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DegreeAreaUtil</code> to access the degree area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DegreeAreaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the degree areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching degree areas
	 */
	@Override
	public List<DegreeArea> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<DegreeArea> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<DegreeArea> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<DegreeArea> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<DegreeArea> list = null;

		if (useFinderCache) {
			list = (List<DegreeArea>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DegreeArea degreeArea : list) {
					if (!uuid.equals(degreeArea.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DEGREEAREA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DegreeAreaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<DegreeArea>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	@Override
	public DegreeArea findByUuid_First(
			String uuid, OrderByComparator<DegreeArea> orderByComparator)
		throws NoSuchDegreeAreaException {

		DegreeArea degreeArea = fetchByUuid_First(uuid, orderByComparator);

		if (degreeArea != null) {
			return degreeArea;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDegreeAreaException(sb.toString());
	}

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	@Override
	public DegreeArea fetchByUuid_First(
		String uuid, OrderByComparator<DegreeArea> orderByComparator) {

		List<DegreeArea> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	@Override
	public DegreeArea findByUuid_Last(
			String uuid, OrderByComparator<DegreeArea> orderByComparator)
		throws NoSuchDegreeAreaException {

		DegreeArea degreeArea = fetchByUuid_Last(uuid, orderByComparator);

		if (degreeArea != null) {
			return degreeArea;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDegreeAreaException(sb.toString());
	}

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	@Override
	public DegreeArea fetchByUuid_Last(
		String uuid, OrderByComparator<DegreeArea> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DegreeArea> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the degree areas before and after the current degree area in the ordered set where uuid = &#63;.
	 *
	 * @param degreeAreaId the primary key of the current degree area
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next degree area
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	@Override
	public DegreeArea[] findByUuid_PrevAndNext(
			long degreeAreaId, String uuid,
			OrderByComparator<DegreeArea> orderByComparator)
		throws NoSuchDegreeAreaException {

		uuid = Objects.toString(uuid, "");

		DegreeArea degreeArea = findByPrimaryKey(degreeAreaId);

		Session session = null;

		try {
			session = openSession();

			DegreeArea[] array = new DegreeAreaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, degreeArea, uuid, orderByComparator, true);

			array[1] = degreeArea;

			array[2] = getByUuid_PrevAndNext(
				session, degreeArea, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DegreeArea getByUuid_PrevAndNext(
		Session session, DegreeArea degreeArea, String uuid,
		OrderByComparator<DegreeArea> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DEGREEAREA_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DegreeAreaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(degreeArea)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DegreeArea> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the degree areas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DegreeArea degreeArea :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(degreeArea);
		}
	}

	/**
	 * Returns the number of degree areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching degree areas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEGREEAREA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"degreeArea.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(degreeArea.uuid IS NULL OR degreeArea.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the degree area where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDegreeAreaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	@Override
	public DegreeArea findByUUID_G(String uuid, long groupId)
		throws NoSuchDegreeAreaException {

		DegreeArea degreeArea = fetchByUUID_G(uuid, groupId);

		if (degreeArea == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDegreeAreaException(sb.toString());
		}

		return degreeArea;
	}

	/**
	 * Returns the degree area where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	@Override
	public DegreeArea fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the degree area where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	@Override
	public DegreeArea fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof DegreeArea) {
			DegreeArea degreeArea = (DegreeArea)result;

			if (!Objects.equals(uuid, degreeArea.getUuid()) ||
				(groupId != degreeArea.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEGREEAREA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<DegreeArea> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DegreeArea degreeArea = list.get(0);

					result = degreeArea;

					cacheResult(degreeArea);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DegreeArea)result;
		}
	}

	/**
	 * Removes the degree area where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the degree area that was removed
	 */
	@Override
	public DegreeArea removeByUUID_G(String uuid, long groupId)
		throws NoSuchDegreeAreaException {

		DegreeArea degreeArea = findByUUID_G(uuid, groupId);

		return remove(degreeArea);
	}

	/**
	 * Returns the number of degree areas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching degree areas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEGREEAREA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"degreeArea.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(degreeArea.uuid IS NULL OR degreeArea.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"degreeArea.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the degree areas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching degree areas
	 */
	@Override
	public List<DegreeArea> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<DegreeArea> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<DegreeArea> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<DegreeArea> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<DegreeArea> list = null;

		if (useFinderCache) {
			list = (List<DegreeArea>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DegreeArea degreeArea : list) {
					if (!uuid.equals(degreeArea.getUuid()) ||
						(companyId != degreeArea.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DEGREEAREA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DegreeAreaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<DegreeArea>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	@Override
	public DegreeArea findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DegreeArea> orderByComparator)
		throws NoSuchDegreeAreaException {

		DegreeArea degreeArea = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (degreeArea != null) {
			return degreeArea;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDegreeAreaException(sb.toString());
	}

	/**
	 * Returns the first degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	@Override
	public DegreeArea fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DegreeArea> orderByComparator) {

		List<DegreeArea> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area
	 * @throws NoSuchDegreeAreaException if a matching degree area could not be found
	 */
	@Override
	public DegreeArea findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DegreeArea> orderByComparator)
		throws NoSuchDegreeAreaException {

		DegreeArea degreeArea = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (degreeArea != null) {
			return degreeArea;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDegreeAreaException(sb.toString());
	}

	/**
	 * Returns the last degree area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	@Override
	public DegreeArea fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DegreeArea> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DegreeArea> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public DegreeArea[] findByUuid_C_PrevAndNext(
			long degreeAreaId, String uuid, long companyId,
			OrderByComparator<DegreeArea> orderByComparator)
		throws NoSuchDegreeAreaException {

		uuid = Objects.toString(uuid, "");

		DegreeArea degreeArea = findByPrimaryKey(degreeAreaId);

		Session session = null;

		try {
			session = openSession();

			DegreeArea[] array = new DegreeAreaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, degreeArea, uuid, companyId, orderByComparator, true);

			array[1] = degreeArea;

			array[2] = getByUuid_C_PrevAndNext(
				session, degreeArea, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DegreeArea getByUuid_C_PrevAndNext(
		Session session, DegreeArea degreeArea, String uuid, long companyId,
		OrderByComparator<DegreeArea> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DEGREEAREA_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DegreeAreaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(degreeArea)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DegreeArea> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the degree areas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DegreeArea degreeArea :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(degreeArea);
		}
	}

	/**
	 * Returns the number of degree areas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching degree areas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEGREEAREA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"degreeArea.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(degreeArea.uuid IS NULL OR degreeArea.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"degreeArea.companyId = ?";

	public DegreeAreaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DegreeArea.class);

		setModelImplClass(DegreeAreaImpl.class);
		setModelPKClass(long.class);

		setTable(DegreeAreaTable.INSTANCE);
	}

	/**
	 * Caches the degree area in the entity cache if it is enabled.
	 *
	 * @param degreeArea the degree area
	 */
	@Override
	public void cacheResult(DegreeArea degreeArea) {
		entityCache.putResult(
			DegreeAreaImpl.class, degreeArea.getPrimaryKey(), degreeArea);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {degreeArea.getUuid(), degreeArea.getGroupId()},
			degreeArea);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the degree areas in the entity cache if it is enabled.
	 *
	 * @param degreeAreas the degree areas
	 */
	@Override
	public void cacheResult(List<DegreeArea> degreeAreas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (degreeAreas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DegreeArea degreeArea : degreeAreas) {
			if (entityCache.getResult(
					DegreeAreaImpl.class, degreeArea.getPrimaryKey()) == null) {

				cacheResult(degreeArea);
			}
		}
	}

	/**
	 * Clears the cache for all degree areas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DegreeAreaImpl.class);

		finderCache.clearCache(DegreeAreaImpl.class);
	}

	/**
	 * Clears the cache for the degree area.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DegreeArea degreeArea) {
		entityCache.removeResult(DegreeAreaImpl.class, degreeArea);
	}

	@Override
	public void clearCache(List<DegreeArea> degreeAreas) {
		for (DegreeArea degreeArea : degreeAreas) {
			entityCache.removeResult(DegreeAreaImpl.class, degreeArea);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DegreeAreaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DegreeAreaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DegreeAreaModelImpl degreeAreaModelImpl) {

		Object[] args = new Object[] {
			degreeAreaModelImpl.getUuid(), degreeAreaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, degreeAreaModelImpl);
	}

	/**
	 * Creates a new degree area with the primary key. Does not add the degree area to the database.
	 *
	 * @param degreeAreaId the primary key for the new degree area
	 * @return the new degree area
	 */
	@Override
	public DegreeArea create(long degreeAreaId) {
		DegreeArea degreeArea = new DegreeAreaImpl();

		degreeArea.setNew(true);
		degreeArea.setPrimaryKey(degreeAreaId);

		String uuid = _portalUUID.generate();

		degreeArea.setUuid(uuid);

		degreeArea.setCompanyId(CompanyThreadLocal.getCompanyId());

		return degreeArea;
	}

	/**
	 * Removes the degree area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area that was removed
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	@Override
	public DegreeArea remove(long degreeAreaId)
		throws NoSuchDegreeAreaException {

		return remove((Serializable)degreeAreaId);
	}

	/**
	 * Removes the degree area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the degree area
	 * @return the degree area that was removed
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	@Override
	public DegreeArea remove(Serializable primaryKey)
		throws NoSuchDegreeAreaException {

		Session session = null;

		try {
			session = openSession();

			DegreeArea degreeArea = (DegreeArea)session.get(
				DegreeAreaImpl.class, primaryKey);

			if (degreeArea == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDegreeAreaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(degreeArea);
		}
		catch (NoSuchDegreeAreaException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DegreeArea removeImpl(DegreeArea degreeArea) {
		degreeAreaToDegreeTableMapper.deleteLeftPrimaryKeyTableMappings(
			degreeArea.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(degreeArea)) {
				degreeArea = (DegreeArea)session.get(
					DegreeAreaImpl.class, degreeArea.getPrimaryKeyObj());
			}

			if (degreeArea != null) {
				session.delete(degreeArea);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (degreeArea != null) {
			clearCache(degreeArea);
		}

		return degreeArea;
	}

	@Override
	public DegreeArea updateImpl(DegreeArea degreeArea) {
		boolean isNew = degreeArea.isNew();

		if (!(degreeArea instanceof DegreeAreaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(degreeArea.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(degreeArea);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in degreeArea proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DegreeArea implementation " +
					degreeArea.getClass());
		}

		DegreeAreaModelImpl degreeAreaModelImpl =
			(DegreeAreaModelImpl)degreeArea;

		if (Validator.isNull(degreeArea.getUuid())) {
			String uuid = _portalUUID.generate();

			degreeArea.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(degreeArea);
			}
			else {
				degreeArea = (DegreeArea)session.merge(degreeArea);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DegreeAreaImpl.class, degreeAreaModelImpl, false, true);

		cacheUniqueFindersCache(degreeAreaModelImpl);

		if (isNew) {
			degreeArea.setNew(false);
		}

		degreeArea.resetOriginalValues();

		return degreeArea;
	}

	/**
	 * Returns the degree area with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the degree area
	 * @return the degree area
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	@Override
	public DegreeArea findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDegreeAreaException {

		DegreeArea degreeArea = fetchByPrimaryKey(primaryKey);

		if (degreeArea == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDegreeAreaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return degreeArea;
	}

	/**
	 * Returns the degree area with the primary key or throws a <code>NoSuchDegreeAreaException</code> if it could not be found.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area
	 * @throws NoSuchDegreeAreaException if a degree area with the primary key could not be found
	 */
	@Override
	public DegreeArea findByPrimaryKey(long degreeAreaId)
		throws NoSuchDegreeAreaException {

		return findByPrimaryKey((Serializable)degreeAreaId);
	}

	/**
	 * Returns the degree area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area, or <code>null</code> if a degree area with the primary key could not be found
	 */
	@Override
	public DegreeArea fetchByPrimaryKey(long degreeAreaId) {
		return fetchByPrimaryKey((Serializable)degreeAreaId);
	}

	/**
	 * Returns all the degree areas.
	 *
	 * @return the degree areas
	 */
	@Override
	public List<DegreeArea> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<DegreeArea> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<DegreeArea> findAll(
		int start, int end, OrderByComparator<DegreeArea> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<DegreeArea> findAll(
		int start, int end, OrderByComparator<DegreeArea> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DegreeArea> list = null;

		if (useFinderCache) {
			list = (List<DegreeArea>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEGREEAREA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEGREEAREA;

				sql = sql.concat(DegreeAreaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DegreeArea>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the degree areas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DegreeArea degreeArea : findAll()) {
			remove(degreeArea);
		}
	}

	/**
	 * Returns the number of degree areas.
	 *
	 * @return the number of degree areas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEGREEAREA);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of degrees associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @return long[] of the primaryKeys of degrees associated with the degree area
	 */
	@Override
	public long[] getDegreePrimaryKeys(long pk) {
		long[] pks = degreeAreaToDegreeTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the degree area associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the degree areas associated with the degree
	 */
	@Override
	public List<DegreeArea> getDegreeDegreeAreas(long pk) {
		return getDegreeDegreeAreas(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	@Override
	public List<DegreeArea> getDegreeDegreeAreas(long pk, int start, int end) {
		return getDegreeDegreeAreas(pk, start, end, null);
	}

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
	@Override
	public List<DegreeArea> getDegreeDegreeAreas(
		long pk, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return degreeAreaToDegreeTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of degrees associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @return the number of degrees associated with the degree area
	 */
	@Override
	public int getDegreesSize(long pk) {
		long[] pks = degreeAreaToDegreeTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the degree is associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePK the primary key of the degree
	 * @return <code>true</code> if the degree is associated with the degree area; <code>false</code> otherwise
	 */
	@Override
	public boolean containsDegree(long pk, long degreePK) {
		return degreeAreaToDegreeTableMapper.containsTableMapping(pk, degreePK);
	}

	/**
	 * Returns <code>true</code> if the degree area has any degrees associated with it.
	 *
	 * @param pk the primary key of the degree area to check for associations with degrees
	 * @return <code>true</code> if the degree area has any degrees associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsDegrees(long pk) {
		if (getDegreesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePK the primary key of the degree
	 */
	@Override
	public void addDegree(long pk, long degreePK) {
		DegreeArea degreeArea = fetchByPrimaryKey(pk);

		if (degreeArea == null) {
			degreeAreaToDegreeTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, degreePK);
		}
		else {
			degreeAreaToDegreeTableMapper.addTableMapping(
				degreeArea.getCompanyId(), pk, degreePK);
		}
	}

	/**
	 * Adds an association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degree the degree
	 */
	@Override
	public void addDegree(long pk, Degree degree) {
		DegreeArea degreeArea = fetchByPrimaryKey(pk);

		if (degreeArea == null) {
			degreeAreaToDegreeTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, degree.getPrimaryKey());
		}
		else {
			degreeAreaToDegreeTableMapper.addTableMapping(
				degreeArea.getCompanyId(), pk, degree.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePKs the primary keys of the degrees
	 */
	@Override
	public void addDegrees(long pk, long[] degreePKs) {
		long companyId = 0;

		DegreeArea degreeArea = fetchByPrimaryKey(pk);

		if (degreeArea == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = degreeArea.getCompanyId();
		}

		degreeAreaToDegreeTableMapper.addTableMappings(
			companyId, pk, degreePKs);
	}

	/**
	 * Adds an association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degrees the degrees
	 */
	@Override
	public void addDegrees(long pk, List<Degree> degrees) {
		addDegrees(
			pk, ListUtil.toLongArray(degrees, Degree.DEGREE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the degree area and its degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area to clear the associated degrees from
	 */
	@Override
	public void clearDegrees(long pk) {
		degreeAreaToDegreeTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePK the primary key of the degree
	 */
	@Override
	public void removeDegree(long pk, long degreePK) {
		degreeAreaToDegreeTableMapper.deleteTableMapping(pk, degreePK);
	}

	/**
	 * Removes the association between the degree area and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degree the degree
	 */
	@Override
	public void removeDegree(long pk, Degree degree) {
		degreeAreaToDegreeTableMapper.deleteTableMapping(
			pk, degree.getPrimaryKey());
	}

	/**
	 * Removes the association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePKs the primary keys of the degrees
	 */
	@Override
	public void removeDegrees(long pk, long[] degreePKs) {
		degreeAreaToDegreeTableMapper.deleteTableMappings(pk, degreePKs);
	}

	/**
	 * Removes the association between the degree area and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degrees the degrees
	 */
	@Override
	public void removeDegrees(long pk, List<Degree> degrees) {
		removeDegrees(
			pk, ListUtil.toLongArray(degrees, Degree.DEGREE_ID_ACCESSOR));
	}

	/**
	 * Sets the degrees associated with the degree area, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degreePKs the primary keys of the degrees to be associated with the degree area
	 */
	@Override
	public void setDegrees(long pk, long[] degreePKs) {
		Set<Long> newDegreePKsSet = SetUtil.fromArray(degreePKs);
		Set<Long> oldDegreePKsSet = SetUtil.fromArray(
			degreeAreaToDegreeTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeDegreePKsSet = new HashSet<Long>(oldDegreePKsSet);

		removeDegreePKsSet.removeAll(newDegreePKsSet);

		degreeAreaToDegreeTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeDegreePKsSet));

		newDegreePKsSet.removeAll(oldDegreePKsSet);

		long companyId = 0;

		DegreeArea degreeArea = fetchByPrimaryKey(pk);

		if (degreeArea == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = degreeArea.getCompanyId();
		}

		degreeAreaToDegreeTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newDegreePKsSet));
	}

	/**
	 * Sets the degrees associated with the degree area, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree area
	 * @param degrees the degrees to be associated with the degree area
	 */
	@Override
	public void setDegrees(long pk, List<Degree> degrees) {
		try {
			long[] degreePKs = new long[degrees.size()];

			for (int i = 0; i < degrees.size(); i++) {
				Degree degree = degrees.get(i);

				degreePKs[i] = degree.getPrimaryKey();
			}

			setDegrees(pk, degreePKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "degreeAreaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEGREEAREA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DegreeAreaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the degree area persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		degreeAreaToDegreeTableMapper = TableMapperFactory.getTableMapper(
			"SJob_Degrees_DegreesAreas#degreeAreaId",
			"SJob_Degrees_DegreesAreas", "companyId", "degreeAreaId",
			"degreeId", this, Degree.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_setDegreeAreaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDegreeAreaUtilPersistence(null);

		entityCache.removeCache(DegreeAreaImpl.class.getName());

		TableMapperFactory.removeTableMapper(
			"SJob_Degrees_DegreesAreas#degreeAreaId");
	}

	private void _setDegreeAreaUtilPersistence(
		DegreeAreaPersistence degreeAreaPersistence) {

		try {
			Field field = DegreeAreaUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, degreeAreaPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SJobPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SJobPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SJobPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	protected TableMapper<DegreeArea, Degree> degreeAreaToDegreeTableMapper;

	private static final String _SQL_SELECT_DEGREEAREA =
		"SELECT degreeArea FROM DegreeArea degreeArea";

	private static final String _SQL_SELECT_DEGREEAREA_WHERE =
		"SELECT degreeArea FROM DegreeArea degreeArea WHERE ";

	private static final String _SQL_COUNT_DEGREEAREA =
		"SELECT COUNT(degreeArea) FROM DegreeArea degreeArea";

	private static final String _SQL_COUNT_DEGREEAREA_WHERE =
		"SELECT COUNT(degreeArea) FROM DegreeArea degreeArea WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "degreeArea.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DegreeArea exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DegreeArea exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DegreeAreaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private DegreeAreaModelArgumentsResolver _degreeAreaModelArgumentsResolver;

}