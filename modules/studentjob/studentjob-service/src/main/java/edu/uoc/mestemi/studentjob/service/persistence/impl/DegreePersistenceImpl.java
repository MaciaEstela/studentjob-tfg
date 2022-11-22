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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
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

import edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.DegreeArea;
import edu.uoc.mestemi.studentjob.model.DegreeTable;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.model.impl.DegreeImpl;
import edu.uoc.mestemi.studentjob.model.impl.DegreeModelImpl;
import edu.uoc.mestemi.studentjob.service.persistence.DegreePersistence;
import edu.uoc.mestemi.studentjob.service.persistence.DegreeUtil;
import edu.uoc.mestemi.studentjob.service.persistence.impl.constants.SJobPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
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
 * The persistence implementation for the degree service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DegreePersistence.class, BasePersistence.class})
public class DegreePersistenceImpl
	extends BasePersistenceImpl<Degree> implements DegreePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DegreeUtil</code> to access the degree persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DegreeImpl.class.getName();

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
	 * Returns all the degrees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching degrees
	 */
	@Override
	public List<Degree> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Degree> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<Degree> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Degree> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Degree> orderByComparator, boolean useFinderCache) {

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

		List<Degree> list = null;

		if (useFinderCache) {
			list = (List<Degree>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Degree degree : list) {
					if (!uuid.equals(degree.getUuid())) {
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

			sb.append(_SQL_SELECT_DEGREE_WHERE);

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
				sb.append(DegreeModelImpl.ORDER_BY_JPQL);
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

				list = (List<Degree>)QueryUtil.list(
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
	 * Returns the first degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	@Override
	public Degree findByUuid_First(
			String uuid, OrderByComparator<Degree> orderByComparator)
		throws NoSuchDegreeException {

		Degree degree = fetchByUuid_First(uuid, orderByComparator);

		if (degree != null) {
			return degree;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDegreeException(sb.toString());
	}

	/**
	 * Returns the first degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree, or <code>null</code> if a matching degree could not be found
	 */
	@Override
	public Degree fetchByUuid_First(
		String uuid, OrderByComparator<Degree> orderByComparator) {

		List<Degree> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	@Override
	public Degree findByUuid_Last(
			String uuid, OrderByComparator<Degree> orderByComparator)
		throws NoSuchDegreeException {

		Degree degree = fetchByUuid_Last(uuid, orderByComparator);

		if (degree != null) {
			return degree;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDegreeException(sb.toString());
	}

	/**
	 * Returns the last degree in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree, or <code>null</code> if a matching degree could not be found
	 */
	@Override
	public Degree fetchByUuid_Last(
		String uuid, OrderByComparator<Degree> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Degree> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the degrees before and after the current degree in the ordered set where uuid = &#63;.
	 *
	 * @param degreeId the primary key of the current degree
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next degree
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	@Override
	public Degree[] findByUuid_PrevAndNext(
			long degreeId, String uuid,
			OrderByComparator<Degree> orderByComparator)
		throws NoSuchDegreeException {

		uuid = Objects.toString(uuid, "");

		Degree degree = findByPrimaryKey(degreeId);

		Session session = null;

		try {
			session = openSession();

			Degree[] array = new DegreeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, degree, uuid, orderByComparator, true);

			array[1] = degree;

			array[2] = getByUuid_PrevAndNext(
				session, degree, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Degree getByUuid_PrevAndNext(
		Session session, Degree degree, String uuid,
		OrderByComparator<Degree> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DEGREE_WHERE);

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
			sb.append(DegreeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(degree)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Degree> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the degrees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Degree degree :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(degree);
		}
	}

	/**
	 * Returns the number of degrees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching degrees
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEGREE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "degree.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(degree.uuid IS NULL OR degree.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the degree where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDegreeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	@Override
	public Degree findByUUID_G(String uuid, long groupId)
		throws NoSuchDegreeException {

		Degree degree = fetchByUUID_G(uuid, groupId);

		if (degree == null) {
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

			throw new NoSuchDegreeException(sb.toString());
		}

		return degree;
	}

	/**
	 * Returns the degree where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching degree, or <code>null</code> if a matching degree could not be found
	 */
	@Override
	public Degree fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the degree where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching degree, or <code>null</code> if a matching degree could not be found
	 */
	@Override
	public Degree fetchByUUID_G(
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

		if (result instanceof Degree) {
			Degree degree = (Degree)result;

			if (!Objects.equals(uuid, degree.getUuid()) ||
				(groupId != degree.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEGREE_WHERE);

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

				List<Degree> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Degree degree = list.get(0);

					result = degree;

					cacheResult(degree);
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
			return (Degree)result;
		}
	}

	/**
	 * Removes the degree where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the degree that was removed
	 */
	@Override
	public Degree removeByUUID_G(String uuid, long groupId)
		throws NoSuchDegreeException {

		Degree degree = findByUUID_G(uuid, groupId);

		return remove(degree);
	}

	/**
	 * Returns the number of degrees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching degrees
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEGREE_WHERE);

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
		"degree.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(degree.uuid IS NULL OR degree.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"degree.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the degrees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching degrees
	 */
	@Override
	public List<Degree> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Degree> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<Degree> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Degree> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Degree> orderByComparator, boolean useFinderCache) {

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

		List<Degree> list = null;

		if (useFinderCache) {
			list = (List<Degree>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Degree degree : list) {
					if (!uuid.equals(degree.getUuid()) ||
						(companyId != degree.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DEGREE_WHERE);

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
				sb.append(DegreeModelImpl.ORDER_BY_JPQL);
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

				list = (List<Degree>)QueryUtil.list(
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
	 * Returns the first degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	@Override
	public Degree findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Degree> orderByComparator)
		throws NoSuchDegreeException {

		Degree degree = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (degree != null) {
			return degree;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDegreeException(sb.toString());
	}

	/**
	 * Returns the first degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree, or <code>null</code> if a matching degree could not be found
	 */
	@Override
	public Degree fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Degree> orderByComparator) {

		List<Degree> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	@Override
	public Degree findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Degree> orderByComparator)
		throws NoSuchDegreeException {

		Degree degree = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (degree != null) {
			return degree;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDegreeException(sb.toString());
	}

	/**
	 * Returns the last degree in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree, or <code>null</code> if a matching degree could not be found
	 */
	@Override
	public Degree fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Degree> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Degree> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Degree[] findByUuid_C_PrevAndNext(
			long degreeId, String uuid, long companyId,
			OrderByComparator<Degree> orderByComparator)
		throws NoSuchDegreeException {

		uuid = Objects.toString(uuid, "");

		Degree degree = findByPrimaryKey(degreeId);

		Session session = null;

		try {
			session = openSession();

			Degree[] array = new DegreeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, degree, uuid, companyId, orderByComparator, true);

			array[1] = degree;

			array[2] = getByUuid_C_PrevAndNext(
				session, degree, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Degree getByUuid_C_PrevAndNext(
		Session session, Degree degree, String uuid, long companyId,
		OrderByComparator<Degree> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DEGREE_WHERE);

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
			sb.append(DegreeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(degree)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Degree> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the degrees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Degree degree :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(degree);
		}
	}

	/**
	 * Returns the number of degrees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching degrees
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEGREE_WHERE);

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
		"degree.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(degree.uuid IS NULL OR degree.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"degree.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the degrees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching degrees
	 */
	@Override
	public List<Degree> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the degrees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of matching degrees
	 */
	@Override
	public List<Degree> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the degrees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching degrees
	 */
	@Override
	public List<Degree> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the degrees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching degrees
	 */
	@Override
	public List<Degree> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Degree> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Degree> list = null;

		if (useFinderCache) {
			list = (List<Degree>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Degree degree : list) {
					if (groupId != degree.getGroupId()) {
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

			sb.append(_SQL_SELECT_DEGREE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DegreeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Degree>)QueryUtil.list(
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
	 * Returns the first degree in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	@Override
	public Degree findByGroupId_First(
			long groupId, OrderByComparator<Degree> orderByComparator)
		throws NoSuchDegreeException {

		Degree degree = fetchByGroupId_First(groupId, orderByComparator);

		if (degree != null) {
			return degree;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDegreeException(sb.toString());
	}

	/**
	 * Returns the first degree in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching degree, or <code>null</code> if a matching degree could not be found
	 */
	@Override
	public Degree fetchByGroupId_First(
		long groupId, OrderByComparator<Degree> orderByComparator) {

		List<Degree> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last degree in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree
	 * @throws NoSuchDegreeException if a matching degree could not be found
	 */
	@Override
	public Degree findByGroupId_Last(
			long groupId, OrderByComparator<Degree> orderByComparator)
		throws NoSuchDegreeException {

		Degree degree = fetchByGroupId_Last(groupId, orderByComparator);

		if (degree != null) {
			return degree;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDegreeException(sb.toString());
	}

	/**
	 * Returns the last degree in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching degree, or <code>null</code> if a matching degree could not be found
	 */
	@Override
	public Degree fetchByGroupId_Last(
		long groupId, OrderByComparator<Degree> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Degree> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the degrees before and after the current degree in the ordered set where groupId = &#63;.
	 *
	 * @param degreeId the primary key of the current degree
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next degree
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	@Override
	public Degree[] findByGroupId_PrevAndNext(
			long degreeId, long groupId,
			OrderByComparator<Degree> orderByComparator)
		throws NoSuchDegreeException {

		Degree degree = findByPrimaryKey(degreeId);

		Session session = null;

		try {
			session = openSession();

			Degree[] array = new DegreeImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, degree, groupId, orderByComparator, true);

			array[1] = degree;

			array[2] = getByGroupId_PrevAndNext(
				session, degree, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Degree getByGroupId_PrevAndNext(
		Session session, Degree degree, long groupId,
		OrderByComparator<Degree> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DEGREE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			sb.append(DegreeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(degree)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Degree> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the degrees where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Degree degree :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(degree);
		}
	}

	/**
	 * Returns the number of degrees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching degrees
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEGREE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"degree.groupId = ?";

	public DegreePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Degree.class);

		setModelImplClass(DegreeImpl.class);
		setModelPKClass(long.class);

		setTable(DegreeTable.INSTANCE);
	}

	/**
	 * Caches the degree in the entity cache if it is enabled.
	 *
	 * @param degree the degree
	 */
	@Override
	public void cacheResult(Degree degree) {
		entityCache.putResult(DegreeImpl.class, degree.getPrimaryKey(), degree);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {degree.getUuid(), degree.getGroupId()}, degree);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the degrees in the entity cache if it is enabled.
	 *
	 * @param degrees the degrees
	 */
	@Override
	public void cacheResult(List<Degree> degrees) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (degrees.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Degree degree : degrees) {
			if (entityCache.getResult(
					DegreeImpl.class, degree.getPrimaryKey()) == null) {

				cacheResult(degree);
			}
		}
	}

	/**
	 * Clears the cache for all degrees.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DegreeImpl.class);

		finderCache.clearCache(DegreeImpl.class);
	}

	/**
	 * Clears the cache for the degree.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Degree degree) {
		entityCache.removeResult(DegreeImpl.class, degree);
	}

	@Override
	public void clearCache(List<Degree> degrees) {
		for (Degree degree : degrees) {
			entityCache.removeResult(DegreeImpl.class, degree);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DegreeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DegreeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(DegreeModelImpl degreeModelImpl) {
		Object[] args = new Object[] {
			degreeModelImpl.getUuid(), degreeModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, degreeModelImpl);
	}

	/**
	 * Creates a new degree with the primary key. Does not add the degree to the database.
	 *
	 * @param degreeId the primary key for the new degree
	 * @return the new degree
	 */
	@Override
	public Degree create(long degreeId) {
		Degree degree = new DegreeImpl();

		degree.setNew(true);
		degree.setPrimaryKey(degreeId);

		String uuid = _portalUUID.generate();

		degree.setUuid(uuid);

		degree.setCompanyId(CompanyThreadLocal.getCompanyId());

		return degree;
	}

	/**
	 * Removes the degree with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree that was removed
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	@Override
	public Degree remove(long degreeId) throws NoSuchDegreeException {
		return remove((Serializable)degreeId);
	}

	/**
	 * Removes the degree with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the degree
	 * @return the degree that was removed
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	@Override
	public Degree remove(Serializable primaryKey) throws NoSuchDegreeException {
		Session session = null;

		try {
			session = openSession();

			Degree degree = (Degree)session.get(DegreeImpl.class, primaryKey);

			if (degree == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDegreeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(degree);
		}
		catch (NoSuchDegreeException noSuchEntityException) {
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
	protected Degree removeImpl(Degree degree) {
		degreeToDegreeAreaTableMapper.deleteLeftPrimaryKeyTableMappings(
			degree.getPrimaryKey());

		degreeToStudentProfileTableMapper.deleteLeftPrimaryKeyTableMappings(
			degree.getPrimaryKey());

		degreeToOfferTableMapper.deleteLeftPrimaryKeyTableMappings(
			degree.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(degree)) {
				degree = (Degree)session.get(
					DegreeImpl.class, degree.getPrimaryKeyObj());
			}

			if (degree != null) {
				session.delete(degree);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (degree != null) {
			clearCache(degree);
		}

		return degree;
	}

	@Override
	public Degree updateImpl(Degree degree) {
		boolean isNew = degree.isNew();

		if (!(degree instanceof DegreeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(degree.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(degree);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in degree proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Degree implementation " +
					degree.getClass());
		}

		DegreeModelImpl degreeModelImpl = (DegreeModelImpl)degree;

		if (Validator.isNull(degree.getUuid())) {
			String uuid = _portalUUID.generate();

			degree.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (degree.getCreateDate() == null)) {
			if (serviceContext == null) {
				degree.setCreateDate(date);
			}
			else {
				degree.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!degreeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				degree.setModifiedDate(date);
			}
			else {
				degree.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(degree);
			}
			else {
				degree = (Degree)session.merge(degree);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DegreeImpl.class, degreeModelImpl, false, true);

		cacheUniqueFindersCache(degreeModelImpl);

		if (isNew) {
			degree.setNew(false);
		}

		degree.resetOriginalValues();

		return degree;
	}

	/**
	 * Returns the degree with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the degree
	 * @return the degree
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	@Override
	public Degree findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDegreeException {

		Degree degree = fetchByPrimaryKey(primaryKey);

		if (degree == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDegreeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return degree;
	}

	/**
	 * Returns the degree with the primary key or throws a <code>NoSuchDegreeException</code> if it could not be found.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree
	 * @throws NoSuchDegreeException if a degree with the primary key could not be found
	 */
	@Override
	public Degree findByPrimaryKey(long degreeId) throws NoSuchDegreeException {
		return findByPrimaryKey((Serializable)degreeId);
	}

	/**
	 * Returns the degree with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree, or <code>null</code> if a degree with the primary key could not be found
	 */
	@Override
	public Degree fetchByPrimaryKey(long degreeId) {
		return fetchByPrimaryKey((Serializable)degreeId);
	}

	/**
	 * Returns all the degrees.
	 *
	 * @return the degrees
	 */
	@Override
	public List<Degree> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Degree> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Degree> findAll(
		int start, int end, OrderByComparator<Degree> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Degree> findAll(
		int start, int end, OrderByComparator<Degree> orderByComparator,
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

		List<Degree> list = null;

		if (useFinderCache) {
			list = (List<Degree>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEGREE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEGREE;

				sql = sql.concat(DegreeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Degree>)QueryUtil.list(
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
	 * Removes all the degrees from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Degree degree : findAll()) {
			remove(degree);
		}
	}

	/**
	 * Returns the number of degrees.
	 *
	 * @return the number of degrees
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEGREE);

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
	 * Returns the primaryKeys of degree areas associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return long[] of the primaryKeys of degree areas associated with the degree
	 */
	@Override
	public long[] getDegreeAreaPrimaryKeys(long pk) {
		long[] pks = degreeToDegreeAreaTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the degree associated with the degree area.
	 *
	 * @param pk the primary key of the degree area
	 * @return the degrees associated with the degree area
	 */
	@Override
	public List<Degree> getDegreeAreaDegrees(long pk) {
		return getDegreeAreaDegrees(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	@Override
	public List<Degree> getDegreeAreaDegrees(long pk, int start, int end) {
		return getDegreeAreaDegrees(pk, start, end, null);
	}

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
	@Override
	public List<Degree> getDegreeAreaDegrees(
		long pk, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return degreeToDegreeAreaTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of degree areas associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the number of degree areas associated with the degree
	 */
	@Override
	public int getDegreeAreasSize(long pk) {
		long[] pks = degreeToDegreeAreaTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the degree area is associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPK the primary key of the degree area
	 * @return <code>true</code> if the degree area is associated with the degree; <code>false</code> otherwise
	 */
	@Override
	public boolean containsDegreeArea(long pk, long degreeAreaPK) {
		return degreeToDegreeAreaTableMapper.containsTableMapping(
			pk, degreeAreaPK);
	}

	/**
	 * Returns <code>true</code> if the degree has any degree areas associated with it.
	 *
	 * @param pk the primary key of the degree to check for associations with degree areas
	 * @return <code>true</code> if the degree has any degree areas associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsDegreeAreas(long pk) {
		if (getDegreeAreasSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPK the primary key of the degree area
	 */
	@Override
	public void addDegreeArea(long pk, long degreeAreaPK) {
		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			degreeToDegreeAreaTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, degreeAreaPK);
		}
		else {
			degreeToDegreeAreaTableMapper.addTableMapping(
				degree.getCompanyId(), pk, degreeAreaPK);
		}
	}

	/**
	 * Adds an association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeArea the degree area
	 */
	@Override
	public void addDegreeArea(long pk, DegreeArea degreeArea) {
		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			degreeToDegreeAreaTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				degreeArea.getPrimaryKey());
		}
		else {
			degreeToDegreeAreaTableMapper.addTableMapping(
				degree.getCompanyId(), pk, degreeArea.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPKs the primary keys of the degree areas
	 */
	@Override
	public void addDegreeAreas(long pk, long[] degreeAreaPKs) {
		long companyId = 0;

		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = degree.getCompanyId();
		}

		degreeToDegreeAreaTableMapper.addTableMappings(
			companyId, pk, degreeAreaPKs);
	}

	/**
	 * Adds an association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreas the degree areas
	 */
	@Override
	public void addDegreeAreas(long pk, List<DegreeArea> degreeAreas) {
		addDegreeAreas(
			pk,
			ListUtil.toLongArray(
				degreeAreas, DegreeArea.DEGREE_AREA_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the degree and its degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree to clear the associated degree areas from
	 */
	@Override
	public void clearDegreeAreas(long pk) {
		degreeToDegreeAreaTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPK the primary key of the degree area
	 */
	@Override
	public void removeDegreeArea(long pk, long degreeAreaPK) {
		degreeToDegreeAreaTableMapper.deleteTableMapping(pk, degreeAreaPK);
	}

	/**
	 * Removes the association between the degree and the degree area. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeArea the degree area
	 */
	@Override
	public void removeDegreeArea(long pk, DegreeArea degreeArea) {
		degreeToDegreeAreaTableMapper.deleteTableMapping(
			pk, degreeArea.getPrimaryKey());
	}

	/**
	 * Removes the association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPKs the primary keys of the degree areas
	 */
	@Override
	public void removeDegreeAreas(long pk, long[] degreeAreaPKs) {
		degreeToDegreeAreaTableMapper.deleteTableMappings(pk, degreeAreaPKs);
	}

	/**
	 * Removes the association between the degree and the degree areas. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreas the degree areas
	 */
	@Override
	public void removeDegreeAreas(long pk, List<DegreeArea> degreeAreas) {
		removeDegreeAreas(
			pk,
			ListUtil.toLongArray(
				degreeAreas, DegreeArea.DEGREE_AREA_ID_ACCESSOR));
	}

	/**
	 * Sets the degree areas associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreaPKs the primary keys of the degree areas to be associated with the degree
	 */
	@Override
	public void setDegreeAreas(long pk, long[] degreeAreaPKs) {
		Set<Long> newDegreeAreaPKsSet = SetUtil.fromArray(degreeAreaPKs);
		Set<Long> oldDegreeAreaPKsSet = SetUtil.fromArray(
			degreeToDegreeAreaTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeDegreeAreaPKsSet = new HashSet<Long>(
			oldDegreeAreaPKsSet);

		removeDegreeAreaPKsSet.removeAll(newDegreeAreaPKsSet);

		degreeToDegreeAreaTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeDegreeAreaPKsSet));

		newDegreeAreaPKsSet.removeAll(oldDegreeAreaPKsSet);

		long companyId = 0;

		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = degree.getCompanyId();
		}

		degreeToDegreeAreaTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newDegreeAreaPKsSet));
	}

	/**
	 * Sets the degree areas associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param degreeAreas the degree areas to be associated with the degree
	 */
	@Override
	public void setDegreeAreas(long pk, List<DegreeArea> degreeAreas) {
		try {
			long[] degreeAreaPKs = new long[degreeAreas.size()];

			for (int i = 0; i < degreeAreas.size(); i++) {
				DegreeArea degreeArea = degreeAreas.get(i);

				degreeAreaPKs[i] = degreeArea.getPrimaryKey();
			}

			setDegreeAreas(pk, degreeAreaPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	/**
	 * Returns the primaryKeys of student profiles associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return long[] of the primaryKeys of student profiles associated with the degree
	 */
	@Override
	public long[] getStudentProfilePrimaryKeys(long pk) {
		long[] pks = degreeToStudentProfileTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the degree associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @return the degrees associated with the student profile
	 */
	@Override
	public List<Degree> getStudentProfileDegrees(long pk) {
		return getStudentProfileDegrees(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	@Override
	public List<Degree> getStudentProfileDegrees(long pk, int start, int end) {
		return getStudentProfileDegrees(pk, start, end, null);
	}

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
	@Override
	public List<Degree> getStudentProfileDegrees(
		long pk, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return degreeToStudentProfileTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of student profiles associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the number of student profiles associated with the degree
	 */
	@Override
	public int getStudentProfilesSize(long pk) {
		long[] pks = degreeToStudentProfileTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the student profile is associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePK the primary key of the student profile
	 * @return <code>true</code> if the student profile is associated with the degree; <code>false</code> otherwise
	 */
	@Override
	public boolean containsStudentProfile(long pk, long studentProfilePK) {
		return degreeToStudentProfileTableMapper.containsTableMapping(
			pk, studentProfilePK);
	}

	/**
	 * Returns <code>true</code> if the degree has any student profiles associated with it.
	 *
	 * @param pk the primary key of the degree to check for associations with student profiles
	 * @return <code>true</code> if the degree has any student profiles associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsStudentProfiles(long pk) {
		if (getStudentProfilesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePK the primary key of the student profile
	 */
	@Override
	public void addStudentProfile(long pk, long studentProfilePK) {
		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			degreeToStudentProfileTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, studentProfilePK);
		}
		else {
			degreeToStudentProfileTableMapper.addTableMapping(
				degree.getCompanyId(), pk, studentProfilePK);
		}
	}

	/**
	 * Adds an association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfile the student profile
	 */
	@Override
	public void addStudentProfile(long pk, StudentProfile studentProfile) {
		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			degreeToStudentProfileTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				studentProfile.getPrimaryKey());
		}
		else {
			degreeToStudentProfileTableMapper.addTableMapping(
				degree.getCompanyId(), pk, studentProfile.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePKs the primary keys of the student profiles
	 */
	@Override
	public void addStudentProfiles(long pk, long[] studentProfilePKs) {
		long companyId = 0;

		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = degree.getCompanyId();
		}

		degreeToStudentProfileTableMapper.addTableMappings(
			companyId, pk, studentProfilePKs);
	}

	/**
	 * Adds an association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfiles the student profiles
	 */
	@Override
	public void addStudentProfiles(
		long pk, List<StudentProfile> studentProfiles) {

		addStudentProfiles(
			pk,
			ListUtil.toLongArray(
				studentProfiles, StudentProfile.STUDENT_PROFILE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the degree and its student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree to clear the associated student profiles from
	 */
	@Override
	public void clearStudentProfiles(long pk) {
		degreeToStudentProfileTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePK the primary key of the student profile
	 */
	@Override
	public void removeStudentProfile(long pk, long studentProfilePK) {
		degreeToStudentProfileTableMapper.deleteTableMapping(
			pk, studentProfilePK);
	}

	/**
	 * Removes the association between the degree and the student profile. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfile the student profile
	 */
	@Override
	public void removeStudentProfile(long pk, StudentProfile studentProfile) {
		degreeToStudentProfileTableMapper.deleteTableMapping(
			pk, studentProfile.getPrimaryKey());
	}

	/**
	 * Removes the association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePKs the primary keys of the student profiles
	 */
	@Override
	public void removeStudentProfiles(long pk, long[] studentProfilePKs) {
		degreeToStudentProfileTableMapper.deleteTableMappings(
			pk, studentProfilePKs);
	}

	/**
	 * Removes the association between the degree and the student profiles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfiles the student profiles
	 */
	@Override
	public void removeStudentProfiles(
		long pk, List<StudentProfile> studentProfiles) {

		removeStudentProfiles(
			pk,
			ListUtil.toLongArray(
				studentProfiles, StudentProfile.STUDENT_PROFILE_ID_ACCESSOR));
	}

	/**
	 * Sets the student profiles associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfilePKs the primary keys of the student profiles to be associated with the degree
	 */
	@Override
	public void setStudentProfiles(long pk, long[] studentProfilePKs) {
		Set<Long> newStudentProfilePKsSet = SetUtil.fromArray(
			studentProfilePKs);
		Set<Long> oldStudentProfilePKsSet = SetUtil.fromArray(
			degreeToStudentProfileTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeStudentProfilePKsSet = new HashSet<Long>(
			oldStudentProfilePKsSet);

		removeStudentProfilePKsSet.removeAll(newStudentProfilePKsSet);

		degreeToStudentProfileTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeStudentProfilePKsSet));

		newStudentProfilePKsSet.removeAll(oldStudentProfilePKsSet);

		long companyId = 0;

		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = degree.getCompanyId();
		}

		degreeToStudentProfileTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newStudentProfilePKsSet));
	}

	/**
	 * Sets the student profiles associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param studentProfiles the student profiles to be associated with the degree
	 */
	@Override
	public void setStudentProfiles(
		long pk, List<StudentProfile> studentProfiles) {

		try {
			long[] studentProfilePKs = new long[studentProfiles.size()];

			for (int i = 0; i < studentProfiles.size(); i++) {
				StudentProfile studentProfile = studentProfiles.get(i);

				studentProfilePKs[i] = studentProfile.getPrimaryKey();
			}

			setStudentProfiles(pk, studentProfilePKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	/**
	 * Returns the primaryKeys of offers associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return long[] of the primaryKeys of offers associated with the degree
	 */
	@Override
	public long[] getOfferPrimaryKeys(long pk) {
		long[] pks = degreeToOfferTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the degree associated with the offer.
	 *
	 * @param pk the primary key of the offer
	 * @return the degrees associated with the offer
	 */
	@Override
	public List<Degree> getOfferDegrees(long pk) {
		return getOfferDegrees(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	@Override
	public List<Degree> getOfferDegrees(long pk, int start, int end) {
		return getOfferDegrees(pk, start, end, null);
	}

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
	@Override
	public List<Degree> getOfferDegrees(
		long pk, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return degreeToOfferTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of offers associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the number of offers associated with the degree
	 */
	@Override
	public int getOffersSize(long pk) {
		long[] pks = degreeToOfferTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the offer is associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPK the primary key of the offer
	 * @return <code>true</code> if the offer is associated with the degree; <code>false</code> otherwise
	 */
	@Override
	public boolean containsOffer(long pk, long offerPK) {
		return degreeToOfferTableMapper.containsTableMapping(pk, offerPK);
	}

	/**
	 * Returns <code>true</code> if the degree has any offers associated with it.
	 *
	 * @param pk the primary key of the degree to check for associations with offers
	 * @return <code>true</code> if the degree has any offers associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsOffers(long pk) {
		if (getOffersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPK the primary key of the offer
	 */
	@Override
	public void addOffer(long pk, long offerPK) {
		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			degreeToOfferTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, offerPK);
		}
		else {
			degreeToOfferTableMapper.addTableMapping(
				degree.getCompanyId(), pk, offerPK);
		}
	}

	/**
	 * Adds an association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offer the offer
	 */
	@Override
	public void addOffer(long pk, Offer offer) {
		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			degreeToOfferTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, offer.getPrimaryKey());
		}
		else {
			degreeToOfferTableMapper.addTableMapping(
				degree.getCompanyId(), pk, offer.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPKs the primary keys of the offers
	 */
	@Override
	public void addOffers(long pk, long[] offerPKs) {
		long companyId = 0;

		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = degree.getCompanyId();
		}

		degreeToOfferTableMapper.addTableMappings(companyId, pk, offerPKs);
	}

	/**
	 * Adds an association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offers the offers
	 */
	@Override
	public void addOffers(long pk, List<Offer> offers) {
		addOffers(pk, ListUtil.toLongArray(offers, Offer.OFFER_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the degree and its offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree to clear the associated offers from
	 */
	@Override
	public void clearOffers(long pk) {
		degreeToOfferTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPK the primary key of the offer
	 */
	@Override
	public void removeOffer(long pk, long offerPK) {
		degreeToOfferTableMapper.deleteTableMapping(pk, offerPK);
	}

	/**
	 * Removes the association between the degree and the offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offer the offer
	 */
	@Override
	public void removeOffer(long pk, Offer offer) {
		degreeToOfferTableMapper.deleteTableMapping(pk, offer.getPrimaryKey());
	}

	/**
	 * Removes the association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPKs the primary keys of the offers
	 */
	@Override
	public void removeOffers(long pk, long[] offerPKs) {
		degreeToOfferTableMapper.deleteTableMappings(pk, offerPKs);
	}

	/**
	 * Removes the association between the degree and the offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offers the offers
	 */
	@Override
	public void removeOffers(long pk, List<Offer> offers) {
		removeOffers(pk, ListUtil.toLongArray(offers, Offer.OFFER_ID_ACCESSOR));
	}

	/**
	 * Sets the offers associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offerPKs the primary keys of the offers to be associated with the degree
	 */
	@Override
	public void setOffers(long pk, long[] offerPKs) {
		Set<Long> newOfferPKsSet = SetUtil.fromArray(offerPKs);
		Set<Long> oldOfferPKsSet = SetUtil.fromArray(
			degreeToOfferTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeOfferPKsSet = new HashSet<Long>(oldOfferPKsSet);

		removeOfferPKsSet.removeAll(newOfferPKsSet);

		degreeToOfferTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeOfferPKsSet));

		newOfferPKsSet.removeAll(oldOfferPKsSet);

		long companyId = 0;

		Degree degree = fetchByPrimaryKey(pk);

		if (degree == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = degree.getCompanyId();
		}

		degreeToOfferTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newOfferPKsSet));
	}

	/**
	 * Sets the offers associated with the degree, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the degree
	 * @param offers the offers to be associated with the degree
	 */
	@Override
	public void setOffers(long pk, List<Offer> offers) {
		try {
			long[] offerPKs = new long[offers.size()];

			for (int i = 0; i < offers.size(); i++) {
				Offer offer = offers.get(i);

				offerPKs[i] = offer.getPrimaryKey();
			}

			setOffers(pk, offerPKs);
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
		return "degreeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEGREE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DegreeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the degree persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		degreeToDegreeAreaTableMapper = TableMapperFactory.getTableMapper(
			"SJob_Degrees_DegreesAreas#degreeId", "SJob_Degrees_DegreesAreas",
			"companyId", "degreeId", "degreeAreaId", this, DegreeArea.class);

		degreeToStudentProfileTableMapper = TableMapperFactory.getTableMapper(
			"SJob_Students_Degrees#degreeId", "SJob_Students_Degrees",
			"companyId", "degreeId", "studentProfileId", this,
			StudentProfile.class);

		degreeToOfferTableMapper = TableMapperFactory.getTableMapper(
			"SJob_Offers_Degrees#degreeId", "SJob_Offers_Degrees", "companyId",
			"degreeId", "offerId", this, Offer.class);

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

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_setDegreeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDegreeUtilPersistence(null);

		entityCache.removeCache(DegreeImpl.class.getName());

		TableMapperFactory.removeTableMapper(
			"SJob_Degrees_DegreesAreas#degreeId");
		TableMapperFactory.removeTableMapper("SJob_Students_Degrees#degreeId");
		TableMapperFactory.removeTableMapper("SJob_Offers_Degrees#degreeId");
	}

	private void _setDegreeUtilPersistence(
		DegreePersistence degreePersistence) {

		try {
			Field field = DegreeUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, degreePersistence);
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

	protected TableMapper<Degree, DegreeArea> degreeToDegreeAreaTableMapper;
	protected TableMapper<Degree, StudentProfile>
		degreeToStudentProfileTableMapper;
	protected TableMapper<Degree, Offer> degreeToOfferTableMapper;

	private static final String _SQL_SELECT_DEGREE =
		"SELECT degree FROM Degree degree";

	private static final String _SQL_SELECT_DEGREE_WHERE =
		"SELECT degree FROM Degree degree WHERE ";

	private static final String _SQL_COUNT_DEGREE =
		"SELECT COUNT(degree) FROM Degree degree";

	private static final String _SQL_COUNT_DEGREE_WHERE =
		"SELECT COUNT(degree) FROM Degree degree WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "degree.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Degree exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Degree exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DegreePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private DegreeModelArgumentsResolver _degreeModelArgumentsResolver;

}