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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import edu.uoc.mestemi.studentjob.exception.NoSuchUserEnrollOfferException;
import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.model.UserEnrollOfferTable;
import edu.uoc.mestemi.studentjob.model.impl.UserEnrollOfferImpl;
import edu.uoc.mestemi.studentjob.model.impl.UserEnrollOfferModelImpl;
import edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK;
import edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferUtil;
import edu.uoc.mestemi.studentjob.service.persistence.impl.constants.SJobPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the user enroll offer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {UserEnrollOfferPersistence.class, BasePersistence.class})
public class UserEnrollOfferPersistenceImpl
	extends BasePersistenceImpl<UserEnrollOffer>
	implements UserEnrollOfferPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserEnrollOfferUtil</code> to access the user enroll offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserEnrollOfferImpl.class.getName();

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
	 * Returns all the user enroll offers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user enroll offers
	 */
	@Override
	public List<UserEnrollOffer> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserEnrollOffer> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<UserEnrollOffer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<UserEnrollOffer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator,
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

		List<UserEnrollOffer> list = null;

		if (useFinderCache) {
			list = (List<UserEnrollOffer>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserEnrollOffer userEnrollOffer : list) {
					if (!uuid.equals(userEnrollOffer.getUuid())) {
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

			sb.append(_SQL_SELECT_USERENROLLOFFER_WHERE);

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
				sb.append(UserEnrollOfferModelImpl.ORDER_BY_JPQL);
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

				list = (List<UserEnrollOffer>)QueryUtil.list(
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
	 * Returns the first user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer findByUuid_First(
			String uuid, OrderByComparator<UserEnrollOffer> orderByComparator)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = fetchByUuid_First(
			uuid, orderByComparator);

		if (userEnrollOffer != null) {
			return userEnrollOffer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserEnrollOfferException(sb.toString());
	}

	/**
	 * Returns the first user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer fetchByUuid_First(
		String uuid, OrderByComparator<UserEnrollOffer> orderByComparator) {

		List<UserEnrollOffer> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer findByUuid_Last(
			String uuid, OrderByComparator<UserEnrollOffer> orderByComparator)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = fetchByUuid_Last(
			uuid, orderByComparator);

		if (userEnrollOffer != null) {
			return userEnrollOffer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserEnrollOfferException(sb.toString());
	}

	/**
	 * Returns the last user enroll offer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer fetchByUuid_Last(
		String uuid, OrderByComparator<UserEnrollOffer> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserEnrollOffer> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserEnrollOffer[] findByUuid_PrevAndNext(
			UserEnrollOfferPK userEnrollOfferPK, String uuid,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws NoSuchUserEnrollOfferException {

		uuid = Objects.toString(uuid, "");

		UserEnrollOffer userEnrollOffer = findByPrimaryKey(userEnrollOfferPK);

		Session session = null;

		try {
			session = openSession();

			UserEnrollOffer[] array = new UserEnrollOfferImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userEnrollOffer, uuid, orderByComparator, true);

			array[1] = userEnrollOffer;

			array[2] = getByUuid_PrevAndNext(
				session, userEnrollOffer, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEnrollOffer getByUuid_PrevAndNext(
		Session session, UserEnrollOffer userEnrollOffer, String uuid,
		OrderByComparator<UserEnrollOffer> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERENROLLOFFER_WHERE);

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
			sb.append(UserEnrollOfferModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						userEnrollOffer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserEnrollOffer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user enroll offers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserEnrollOffer userEnrollOffer :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userEnrollOffer);
		}
	}

	/**
	 * Returns the number of user enroll offers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user enroll offers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERENROLLOFFER_WHERE);

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
		"userEnrollOffer.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userEnrollOffer.uuid IS NULL OR userEnrollOffer.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the user enroll offer where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserEnrollOfferException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer findByUUID_G(String uuid, long groupId)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = fetchByUUID_G(uuid, groupId);

		if (userEnrollOffer == null) {
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

			throw new NoSuchUserEnrollOfferException(sb.toString());
		}

		return userEnrollOffer;
	}

	/**
	 * Returns the user enroll offer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the user enroll offer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer fetchByUUID_G(
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

		if (result instanceof UserEnrollOffer) {
			UserEnrollOffer userEnrollOffer = (UserEnrollOffer)result;

			if (!Objects.equals(uuid, userEnrollOffer.getUuid()) ||
				(groupId != userEnrollOffer.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_USERENROLLOFFER_WHERE);

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

				List<UserEnrollOffer> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					UserEnrollOffer userEnrollOffer = list.get(0);

					result = userEnrollOffer;

					cacheResult(userEnrollOffer);
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
			return (UserEnrollOffer)result;
		}
	}

	/**
	 * Removes the user enroll offer where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user enroll offer that was removed
	 */
	@Override
	public UserEnrollOffer removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = findByUUID_G(uuid, groupId);

		return remove(userEnrollOffer);
	}

	/**
	 * Returns the number of user enroll offers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user enroll offers
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_USERENROLLOFFER_WHERE);

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
		"userEnrollOffer.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(userEnrollOffer.uuid IS NULL OR userEnrollOffer.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"userEnrollOffer.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdAndUserId;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdAndUserId;
	private FinderPath _finderPathCountByGroupIdAndUserId;

	/**
	 * Returns all the user enroll offers where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching user enroll offers
	 */
	@Override
	public List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId) {

		return findByGroupIdAndUserId(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end) {

		return findByGroupIdAndUserId(groupId, userId, start, end, null);
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
	@Override
	public List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return findByGroupIdAndUserId(
			groupId, userId, start, end, orderByComparator, true);
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
	@Override
	public List<UserEnrollOffer> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupIdAndUserId;
				finderArgs = new Object[] {groupId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupIdAndUserId;
			finderArgs = new Object[] {
				groupId, userId, start, end, orderByComparator
			};
		}

		List<UserEnrollOffer> list = null;

		if (useFinderCache) {
			list = (List<UserEnrollOffer>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserEnrollOffer userEnrollOffer : list) {
					if ((groupId != userEnrollOffer.getGroupId()) ||
						(userId != userEnrollOffer.getUserId())) {

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

			sb.append(_SQL_SELECT_USERENROLLOFFER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserEnrollOfferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<UserEnrollOffer>)QueryUtil.list(
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
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer findByGroupIdAndUserId_First(
			long groupId, long userId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = fetchByGroupIdAndUserId_First(
			groupId, userId, orderByComparator);

		if (userEnrollOffer != null) {
			return userEnrollOffer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchUserEnrollOfferException(sb.toString());
	}

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer fetchByGroupIdAndUserId_First(
		long groupId, long userId,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		List<UserEnrollOffer> list = findByGroupIdAndUserId(
			groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserEnrollOffer findByGroupIdAndUserId_Last(
			long groupId, long userId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = fetchByGroupIdAndUserId_Last(
			groupId, userId, orderByComparator);

		if (userEnrollOffer != null) {
			return userEnrollOffer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchUserEnrollOfferException(sb.toString());
	}

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer fetchByGroupIdAndUserId_Last(
		long groupId, long userId,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		int count = countByGroupIdAndUserId(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<UserEnrollOffer> list = findByGroupIdAndUserId(
			groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserEnrollOffer[] findByGroupIdAndUserId_PrevAndNext(
			UserEnrollOfferPK userEnrollOfferPK, long groupId, long userId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = findByPrimaryKey(userEnrollOfferPK);

		Session session = null;

		try {
			session = openSession();

			UserEnrollOffer[] array = new UserEnrollOfferImpl[3];

			array[0] = getByGroupIdAndUserId_PrevAndNext(
				session, userEnrollOffer, groupId, userId, orderByComparator,
				true);

			array[1] = userEnrollOffer;

			array[2] = getByGroupIdAndUserId_PrevAndNext(
				session, userEnrollOffer, groupId, userId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEnrollOffer getByGroupIdAndUserId_PrevAndNext(
		Session session, UserEnrollOffer userEnrollOffer, long groupId,
		long userId, OrderByComparator<UserEnrollOffer> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_USERENROLLOFFER_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDANDUSERID_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDANDUSERID_USERID_2);

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
			sb.append(UserEnrollOfferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userEnrollOffer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserEnrollOffer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user enroll offers where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByGroupIdAndUserId(long groupId, long userId) {
		for (UserEnrollOffer userEnrollOffer :
				findByGroupIdAndUserId(
					groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userEnrollOffer);
		}
	}

	/**
	 * Returns the number of user enroll offers where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching user enroll offers
	 */
	@Override
	public int countByGroupIdAndUserId(long groupId, long userId) {
		FinderPath finderPath = _finderPathCountByGroupIdAndUserId;

		Object[] finderArgs = new Object[] {groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_USERENROLLOFFER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_GROUPIDANDUSERID_GROUPID_2 =
		"userEnrollOffer.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDANDUSERID_USERID_2 =
		"userEnrollOffer.id.userId = ?";

	private FinderPath _finderPathFetchByGroupIdAndUserIdAndOfferId;
	private FinderPath _finderPathCountByGroupIdAndUserIdAndOfferId;

	/**
	 * Returns the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; or throws a <code>NoSuchUserEnrollOfferException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer findByGroupIdAndUserIdAndOfferId(
			long groupId, long userId, long offerId)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = fetchByGroupIdAndUserIdAndOfferId(
			groupId, userId, offerId);

		if (userEnrollOffer == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", userId=");
			sb.append(userId);

			sb.append(", offerId=");
			sb.append(offerId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchUserEnrollOfferException(sb.toString());
		}

		return userEnrollOffer;
	}

	/**
	 * Returns the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer fetchByGroupIdAndUserIdAndOfferId(
		long groupId, long userId, long offerId) {

		return fetchByGroupIdAndUserIdAndOfferId(
			groupId, userId, offerId, true);
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
	@Override
	public UserEnrollOffer fetchByGroupIdAndUserIdAndOfferId(
		long groupId, long userId, long offerId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, userId, offerId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGroupIdAndUserIdAndOfferId, finderArgs);
		}

		if (result instanceof UserEnrollOffer) {
			UserEnrollOffer userEnrollOffer = (UserEnrollOffer)result;

			if ((groupId != userEnrollOffer.getGroupId()) ||
				(userId != userEnrollOffer.getUserId()) ||
				(offerId != userEnrollOffer.getOfferId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_USERENROLLOFFER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERIDANDOFFERID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERIDANDOFFERID_USERID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERIDANDOFFERID_OFFERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(offerId);

				List<UserEnrollOffer> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGroupIdAndUserIdAndOfferId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, userId, offerId
								};
							}

							_log.warn(
								"UserEnrollOfferPersistenceImpl.fetchByGroupIdAndUserIdAndOfferId(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserEnrollOffer userEnrollOffer = list.get(0);

					result = userEnrollOffer;

					cacheResult(userEnrollOffer);
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
			return (UserEnrollOffer)result;
		}
	}

	/**
	 * Removes the user enroll offer where groupId = &#63; and userId = &#63; and offerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the user enroll offer that was removed
	 */
	@Override
	public UserEnrollOffer removeByGroupIdAndUserIdAndOfferId(
			long groupId, long userId, long offerId)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = findByGroupIdAndUserIdAndOfferId(
			groupId, userId, offerId);

		return remove(userEnrollOffer);
	}

	/**
	 * Returns the number of user enroll offers where groupId = &#63; and userId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param offerId the offer ID
	 * @return the number of matching user enroll offers
	 */
	@Override
	public int countByGroupIdAndUserIdAndOfferId(
		long groupId, long userId, long offerId) {

		FinderPath finderPath = _finderPathCountByGroupIdAndUserIdAndOfferId;

		Object[] finderArgs = new Object[] {groupId, userId, offerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_USERENROLLOFFER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERIDANDOFFERID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERIDANDOFFERID_USERID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERIDANDOFFERID_OFFERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				queryPos.add(offerId);

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

	private static final String
		_FINDER_COLUMN_GROUPIDANDUSERIDANDOFFERID_GROUPID_2 =
			"userEnrollOffer.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDANDUSERIDANDOFFERID_USERID_2 =
			"userEnrollOffer.id.userId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDANDUSERIDANDOFFERID_OFFERID_2 =
			"userEnrollOffer.id.offerId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdAndOfferId;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdAndOfferId;
	private FinderPath _finderPathCountByGroupIdAndOfferId;

	/**
	 * Returns all the user enroll offers where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @return the matching user enroll offers
	 */
	@Override
	public List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId) {

		return findByGroupIdAndOfferId(
			groupId, offerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId, int start, int end) {

		return findByGroupIdAndOfferId(groupId, offerId, start, end, null);
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
	@Override
	public List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return findByGroupIdAndOfferId(
			groupId, offerId, start, end, orderByComparator, true);
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
	@Override
	public List<UserEnrollOffer> findByGroupIdAndOfferId(
		long groupId, long offerId, int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroupIdAndOfferId;
				finderArgs = new Object[] {groupId, offerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupIdAndOfferId;
			finderArgs = new Object[] {
				groupId, offerId, start, end, orderByComparator
			};
		}

		List<UserEnrollOffer> list = null;

		if (useFinderCache) {
			list = (List<UserEnrollOffer>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserEnrollOffer userEnrollOffer : list) {
					if ((groupId != userEnrollOffer.getGroupId()) ||
						(offerId != userEnrollOffer.getOfferId())) {

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

			sb.append(_SQL_SELECT_USERENROLLOFFER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDOFFERID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDOFFERID_OFFERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserEnrollOfferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(offerId);

				list = (List<UserEnrollOffer>)QueryUtil.list(
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
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer findByGroupIdAndOfferId_First(
			long groupId, long offerId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = fetchByGroupIdAndOfferId_First(
			groupId, offerId, orderByComparator);

		if (userEnrollOffer != null) {
			return userEnrollOffer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", offerId=");
		sb.append(offerId);

		sb.append("}");

		throw new NoSuchUserEnrollOfferException(sb.toString());
	}

	/**
	 * Returns the first user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer fetchByGroupIdAndOfferId_First(
		long groupId, long offerId,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		List<UserEnrollOffer> list = findByGroupIdAndOfferId(
			groupId, offerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserEnrollOffer findByGroupIdAndOfferId_Last(
			long groupId, long offerId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = fetchByGroupIdAndOfferId_Last(
			groupId, offerId, orderByComparator);

		if (userEnrollOffer != null) {
			return userEnrollOffer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", offerId=");
		sb.append(offerId);

		sb.append("}");

		throw new NoSuchUserEnrollOfferException(sb.toString());
	}

	/**
	 * Returns the last user enroll offer in the ordered set where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer fetchByGroupIdAndOfferId_Last(
		long groupId, long offerId,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		int count = countByGroupIdAndOfferId(groupId, offerId);

		if (count == 0) {
			return null;
		}

		List<UserEnrollOffer> list = findByGroupIdAndOfferId(
			groupId, offerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserEnrollOffer[] findByGroupIdAndOfferId_PrevAndNext(
			UserEnrollOfferPK userEnrollOfferPK, long groupId, long offerId,
			OrderByComparator<UserEnrollOffer> orderByComparator)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = findByPrimaryKey(userEnrollOfferPK);

		Session session = null;

		try {
			session = openSession();

			UserEnrollOffer[] array = new UserEnrollOfferImpl[3];

			array[0] = getByGroupIdAndOfferId_PrevAndNext(
				session, userEnrollOffer, groupId, offerId, orderByComparator,
				true);

			array[1] = userEnrollOffer;

			array[2] = getByGroupIdAndOfferId_PrevAndNext(
				session, userEnrollOffer, groupId, offerId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEnrollOffer getByGroupIdAndOfferId_PrevAndNext(
		Session session, UserEnrollOffer userEnrollOffer, long groupId,
		long offerId, OrderByComparator<UserEnrollOffer> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_USERENROLLOFFER_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDANDOFFERID_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDANDOFFERID_OFFERID_2);

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
			sb.append(UserEnrollOfferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(offerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userEnrollOffer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserEnrollOffer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user enroll offers where groupId = &#63; and offerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 */
	@Override
	public void removeByGroupIdAndOfferId(long groupId, long offerId) {
		for (UserEnrollOffer userEnrollOffer :
				findByGroupIdAndOfferId(
					groupId, offerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userEnrollOffer);
		}
	}

	/**
	 * Returns the number of user enroll offers where groupId = &#63; and offerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param offerId the offer ID
	 * @return the number of matching user enroll offers
	 */
	@Override
	public int countByGroupIdAndOfferId(long groupId, long offerId) {
		FinderPath finderPath = _finderPathCountByGroupIdAndOfferId;

		Object[] finderArgs = new Object[] {groupId, offerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_USERENROLLOFFER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDOFFERID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDOFFERID_OFFERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(offerId);

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

	private static final String _FINDER_COLUMN_GROUPIDANDOFFERID_GROUPID_2 =
		"userEnrollOffer.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDANDOFFERID_OFFERID_2 =
		"userEnrollOffer.id.offerId = ?";

	public UserEnrollOfferPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UserEnrollOffer.class);

		setModelImplClass(UserEnrollOfferImpl.class);
		setModelPKClass(UserEnrollOfferPK.class);

		setTable(UserEnrollOfferTable.INSTANCE);
	}

	/**
	 * Caches the user enroll offer in the entity cache if it is enabled.
	 *
	 * @param userEnrollOffer the user enroll offer
	 */
	@Override
	public void cacheResult(UserEnrollOffer userEnrollOffer) {
		entityCache.putResult(
			UserEnrollOfferImpl.class, userEnrollOffer.getPrimaryKey(),
			userEnrollOffer);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				userEnrollOffer.getUuid(), userEnrollOffer.getGroupId()
			},
			userEnrollOffer);

		finderCache.putResult(
			_finderPathFetchByGroupIdAndUserIdAndOfferId,
			new Object[] {
				userEnrollOffer.getGroupId(), userEnrollOffer.getUserId(),
				userEnrollOffer.getOfferId()
			},
			userEnrollOffer);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user enroll offers in the entity cache if it is enabled.
	 *
	 * @param userEnrollOffers the user enroll offers
	 */
	@Override
	public void cacheResult(List<UserEnrollOffer> userEnrollOffers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userEnrollOffers.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserEnrollOffer userEnrollOffer : userEnrollOffers) {
			if (entityCache.getResult(
					UserEnrollOfferImpl.class,
					userEnrollOffer.getPrimaryKey()) == null) {

				cacheResult(userEnrollOffer);
			}
		}
	}

	/**
	 * Clears the cache for all user enroll offers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserEnrollOfferImpl.class);

		finderCache.clearCache(UserEnrollOfferImpl.class);
	}

	/**
	 * Clears the cache for the user enroll offer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserEnrollOffer userEnrollOffer) {
		entityCache.removeResult(UserEnrollOfferImpl.class, userEnrollOffer);
	}

	@Override
	public void clearCache(List<UserEnrollOffer> userEnrollOffers) {
		for (UserEnrollOffer userEnrollOffer : userEnrollOffers) {
			entityCache.removeResult(
				UserEnrollOfferImpl.class, userEnrollOffer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserEnrollOfferImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserEnrollOfferImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		UserEnrollOfferModelImpl userEnrollOfferModelImpl) {

		Object[] args = new Object[] {
			userEnrollOfferModelImpl.getUuid(),
			userEnrollOfferModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, userEnrollOfferModelImpl);

		args = new Object[] {
			userEnrollOfferModelImpl.getGroupId(),
			userEnrollOfferModelImpl.getUserId(),
			userEnrollOfferModelImpl.getOfferId()
		};

		finderCache.putResult(
			_finderPathCountByGroupIdAndUserIdAndOfferId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByGroupIdAndUserIdAndOfferId, args,
			userEnrollOfferModelImpl);
	}

	/**
	 * Creates a new user enroll offer with the primary key. Does not add the user enroll offer to the database.
	 *
	 * @param userEnrollOfferPK the primary key for the new user enroll offer
	 * @return the new user enroll offer
	 */
	@Override
	public UserEnrollOffer create(UserEnrollOfferPK userEnrollOfferPK) {
		UserEnrollOffer userEnrollOffer = new UserEnrollOfferImpl();

		userEnrollOffer.setNew(true);
		userEnrollOffer.setPrimaryKey(userEnrollOfferPK);

		String uuid = _portalUUID.generate();

		userEnrollOffer.setUuid(uuid);

		return userEnrollOffer;
	}

	/**
	 * Removes the user enroll offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer that was removed
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	@Override
	public UserEnrollOffer remove(UserEnrollOfferPK userEnrollOfferPK)
		throws NoSuchUserEnrollOfferException {

		return remove((Serializable)userEnrollOfferPK);
	}

	/**
	 * Removes the user enroll offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user enroll offer
	 * @return the user enroll offer that was removed
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	@Override
	public UserEnrollOffer remove(Serializable primaryKey)
		throws NoSuchUserEnrollOfferException {

		Session session = null;

		try {
			session = openSession();

			UserEnrollOffer userEnrollOffer = (UserEnrollOffer)session.get(
				UserEnrollOfferImpl.class, primaryKey);

			if (userEnrollOffer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserEnrollOfferException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userEnrollOffer);
		}
		catch (NoSuchUserEnrollOfferException noSuchEntityException) {
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
	protected UserEnrollOffer removeImpl(UserEnrollOffer userEnrollOffer) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userEnrollOffer)) {
				userEnrollOffer = (UserEnrollOffer)session.get(
					UserEnrollOfferImpl.class,
					userEnrollOffer.getPrimaryKeyObj());
			}

			if (userEnrollOffer != null) {
				session.delete(userEnrollOffer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userEnrollOffer != null) {
			clearCache(userEnrollOffer);
		}

		return userEnrollOffer;
	}

	@Override
	public UserEnrollOffer updateImpl(UserEnrollOffer userEnrollOffer) {
		boolean isNew = userEnrollOffer.isNew();

		if (!(userEnrollOffer instanceof UserEnrollOfferModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userEnrollOffer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userEnrollOffer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userEnrollOffer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserEnrollOffer implementation " +
					userEnrollOffer.getClass());
		}

		UserEnrollOfferModelImpl userEnrollOfferModelImpl =
			(UserEnrollOfferModelImpl)userEnrollOffer;

		if (Validator.isNull(userEnrollOffer.getUuid())) {
			String uuid = _portalUUID.generate();

			userEnrollOffer.setUuid(uuid);
		}

		if (isNew && (userEnrollOffer.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				userEnrollOffer.setCreateDate(date);
			}
			else {
				userEnrollOffer.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userEnrollOffer);
			}
			else {
				userEnrollOffer = (UserEnrollOffer)session.merge(
					userEnrollOffer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserEnrollOfferImpl.class, userEnrollOfferModelImpl, false, true);

		cacheUniqueFindersCache(userEnrollOfferModelImpl);

		if (isNew) {
			userEnrollOffer.setNew(false);
		}

		userEnrollOffer.resetOriginalValues();

		return userEnrollOffer;
	}

	/**
	 * Returns the user enroll offer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user enroll offer
	 * @return the user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	@Override
	public UserEnrollOffer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserEnrollOfferException {

		UserEnrollOffer userEnrollOffer = fetchByPrimaryKey(primaryKey);

		if (userEnrollOffer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserEnrollOfferException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userEnrollOffer;
	}

	/**
	 * Returns the user enroll offer with the primary key or throws a <code>NoSuchUserEnrollOfferException</code> if it could not be found.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer
	 * @throws NoSuchUserEnrollOfferException if a user enroll offer with the primary key could not be found
	 */
	@Override
	public UserEnrollOffer findByPrimaryKey(UserEnrollOfferPK userEnrollOfferPK)
		throws NoSuchUserEnrollOfferException {

		return findByPrimaryKey((Serializable)userEnrollOfferPK);
	}

	/**
	 * Returns the user enroll offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer, or <code>null</code> if a user enroll offer with the primary key could not be found
	 */
	@Override
	public UserEnrollOffer fetchByPrimaryKey(
		UserEnrollOfferPK userEnrollOfferPK) {

		return fetchByPrimaryKey((Serializable)userEnrollOfferPK);
	}

	/**
	 * Returns all the user enroll offers.
	 *
	 * @return the user enroll offers
	 */
	@Override
	public List<UserEnrollOffer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserEnrollOffer> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserEnrollOffer> findAll(
		int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserEnrollOffer> findAll(
		int start, int end,
		OrderByComparator<UserEnrollOffer> orderByComparator,
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

		List<UserEnrollOffer> list = null;

		if (useFinderCache) {
			list = (List<UserEnrollOffer>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERENROLLOFFER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERENROLLOFFER;

				sql = sql.concat(UserEnrollOfferModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserEnrollOffer>)QueryUtil.list(
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
	 * Removes all the user enroll offers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserEnrollOffer userEnrollOffer : findAll()) {
			remove(userEnrollOffer);
		}
	}

	/**
	 * Returns the number of user enroll offers.
	 *
	 * @return the number of user enroll offers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERENROLLOFFER);

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

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userEnrollOfferPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERENROLLOFFER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserEnrollOfferModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user enroll offer persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

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

		_finderPathWithPaginationFindByGroupIdAndUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "userId"}, true);

		_finderPathWithoutPaginationFindByGroupIdAndUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupIdAndUserId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "userId"}, true);

		_finderPathCountByGroupIdAndUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndUserId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "userId"}, false);

		_finderPathFetchByGroupIdAndUserIdAndOfferId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupIdAndUserIdAndOfferId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"groupId", "userId", "offerId"}, true);

		_finderPathCountByGroupIdAndUserIdAndOfferId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndUserIdAndOfferId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"groupId", "userId", "offerId"}, false);

		_finderPathWithPaginationFindByGroupIdAndOfferId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndOfferId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "offerId"}, true);

		_finderPathWithoutPaginationFindByGroupIdAndOfferId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndOfferId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "offerId"}, true);

		_finderPathCountByGroupIdAndOfferId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndOfferId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "offerId"}, false);

		_setUserEnrollOfferUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserEnrollOfferUtilPersistence(null);

		entityCache.removeCache(UserEnrollOfferImpl.class.getName());
	}

	private void _setUserEnrollOfferUtilPersistence(
		UserEnrollOfferPersistence userEnrollOfferPersistence) {

		try {
			Field field = UserEnrollOfferUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, userEnrollOfferPersistence);
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

	private static final String _SQL_SELECT_USERENROLLOFFER =
		"SELECT userEnrollOffer FROM UserEnrollOffer userEnrollOffer";

	private static final String _SQL_SELECT_USERENROLLOFFER_WHERE =
		"SELECT userEnrollOffer FROM UserEnrollOffer userEnrollOffer WHERE ";

	private static final String _SQL_COUNT_USERENROLLOFFER =
		"SELECT COUNT(userEnrollOffer) FROM UserEnrollOffer userEnrollOffer";

	private static final String _SQL_COUNT_USERENROLLOFFER_WHERE =
		"SELECT COUNT(userEnrollOffer) FROM UserEnrollOffer userEnrollOffer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userEnrollOffer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserEnrollOffer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserEnrollOffer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserEnrollOfferPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"userId", "offerId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private UserEnrollOfferModelArgumentsResolver
		_userEnrollOfferModelArgumentsResolver;

}