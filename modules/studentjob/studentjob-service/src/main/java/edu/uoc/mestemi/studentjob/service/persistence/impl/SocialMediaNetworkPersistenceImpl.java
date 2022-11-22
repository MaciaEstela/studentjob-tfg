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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaNetworkException;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetworkTable;
import edu.uoc.mestemi.studentjob.model.impl.SocialMediaNetworkImpl;
import edu.uoc.mestemi.studentjob.model.impl.SocialMediaNetworkModelImpl;
import edu.uoc.mestemi.studentjob.service.persistence.SocialMediaNetworkPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.SocialMediaNetworkUtil;
import edu.uoc.mestemi.studentjob.service.persistence.impl.constants.SJobPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the social media network service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {SocialMediaNetworkPersistence.class, BasePersistence.class}
)
public class SocialMediaNetworkPersistenceImpl
	extends BasePersistenceImpl<SocialMediaNetwork>
	implements SocialMediaNetworkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SocialMediaNetworkUtil</code> to access the social media network persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SocialMediaNetworkImpl.class.getName();

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
	 * Returns all the social media networks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social media networks
	 */
	@Override
	public List<SocialMediaNetwork> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<SocialMediaNetwork> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<SocialMediaNetwork> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<SocialMediaNetwork> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator,
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

		List<SocialMediaNetwork> list = null;

		if (useFinderCache) {
			list = (List<SocialMediaNetwork>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SocialMediaNetwork socialMediaNetwork : list) {
					if (!uuid.equals(socialMediaNetwork.getUuid())) {
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

			sb.append(_SQL_SELECT_SOCIALMEDIANETWORK_WHERE);

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
				sb.append(SocialMediaNetworkModelImpl.ORDER_BY_JPQL);
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

				list = (List<SocialMediaNetwork>)QueryUtil.list(
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
	 * Returns the first social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork findByUuid_First(
			String uuid,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws NoSuchSocialMediaNetworkException {

		SocialMediaNetwork socialMediaNetwork = fetchByUuid_First(
			uuid, orderByComparator);

		if (socialMediaNetwork != null) {
			return socialMediaNetwork;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSocialMediaNetworkException(sb.toString());
	}

	/**
	 * Returns the first social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork fetchByUuid_First(
		String uuid, OrderByComparator<SocialMediaNetwork> orderByComparator) {

		List<SocialMediaNetwork> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork findByUuid_Last(
			String uuid,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws NoSuchSocialMediaNetworkException {

		SocialMediaNetwork socialMediaNetwork = fetchByUuid_Last(
			uuid, orderByComparator);

		if (socialMediaNetwork != null) {
			return socialMediaNetwork;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSocialMediaNetworkException(sb.toString());
	}

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork fetchByUuid_Last(
		String uuid, OrderByComparator<SocialMediaNetwork> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SocialMediaNetwork> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social media networks before and after the current social media network in the ordered set where uuid = &#63;.
	 *
	 * @param socialMediaNetworkId the primary key of the current social media network
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media network
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	@Override
	public SocialMediaNetwork[] findByUuid_PrevAndNext(
			long socialMediaNetworkId, String uuid,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws NoSuchSocialMediaNetworkException {

		uuid = Objects.toString(uuid, "");

		SocialMediaNetwork socialMediaNetwork = findByPrimaryKey(
			socialMediaNetworkId);

		Session session = null;

		try {
			session = openSession();

			SocialMediaNetwork[] array = new SocialMediaNetworkImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, socialMediaNetwork, uuid, orderByComparator, true);

			array[1] = socialMediaNetwork;

			array[2] = getByUuid_PrevAndNext(
				session, socialMediaNetwork, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialMediaNetwork getByUuid_PrevAndNext(
		Session session, SocialMediaNetwork socialMediaNetwork, String uuid,
		OrderByComparator<SocialMediaNetwork> orderByComparator,
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

		sb.append(_SQL_SELECT_SOCIALMEDIANETWORK_WHERE);

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
			sb.append(SocialMediaNetworkModelImpl.ORDER_BY_JPQL);
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
						socialMediaNetwork)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SocialMediaNetwork> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social media networks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SocialMediaNetwork socialMediaNetwork :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(socialMediaNetwork);
		}
	}

	/**
	 * Returns the number of social media networks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social media networks
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SOCIALMEDIANETWORK_WHERE);

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
		"socialMediaNetwork.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(socialMediaNetwork.uuid IS NULL OR socialMediaNetwork.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the social media network where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSocialMediaNetworkException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork findByUUID_G(String uuid, long groupId)
		throws NoSuchSocialMediaNetworkException {

		SocialMediaNetwork socialMediaNetwork = fetchByUUID_G(uuid, groupId);

		if (socialMediaNetwork == null) {
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

			throw new NoSuchSocialMediaNetworkException(sb.toString());
		}

		return socialMediaNetwork;
	}

	/**
	 * Returns the social media network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the social media network where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork fetchByUUID_G(
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

		if (result instanceof SocialMediaNetwork) {
			SocialMediaNetwork socialMediaNetwork = (SocialMediaNetwork)result;

			if (!Objects.equals(uuid, socialMediaNetwork.getUuid()) ||
				(groupId != socialMediaNetwork.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SOCIALMEDIANETWORK_WHERE);

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

				List<SocialMediaNetwork> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SocialMediaNetwork socialMediaNetwork = list.get(0);

					result = socialMediaNetwork;

					cacheResult(socialMediaNetwork);
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
			return (SocialMediaNetwork)result;
		}
	}

	/**
	 * Removes the social media network where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social media network that was removed
	 */
	@Override
	public SocialMediaNetwork removeByUUID_G(String uuid, long groupId)
		throws NoSuchSocialMediaNetworkException {

		SocialMediaNetwork socialMediaNetwork = findByUUID_G(uuid, groupId);

		return remove(socialMediaNetwork);
	}

	/**
	 * Returns the number of social media networks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social media networks
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SOCIALMEDIANETWORK_WHERE);

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
		"socialMediaNetwork.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(socialMediaNetwork.uuid IS NULL OR socialMediaNetwork.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"socialMediaNetwork.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the social media networks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social media networks
	 */
	@Override
	public List<SocialMediaNetwork> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<SocialMediaNetwork> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator,
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

		List<SocialMediaNetwork> list = null;

		if (useFinderCache) {
			list = (List<SocialMediaNetwork>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SocialMediaNetwork socialMediaNetwork : list) {
					if (!uuid.equals(socialMediaNetwork.getUuid()) ||
						(companyId != socialMediaNetwork.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SOCIALMEDIANETWORK_WHERE);

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
				sb.append(SocialMediaNetworkModelImpl.ORDER_BY_JPQL);
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

				list = (List<SocialMediaNetwork>)QueryUtil.list(
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
	 * Returns the first social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws NoSuchSocialMediaNetworkException {

		SocialMediaNetwork socialMediaNetwork = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (socialMediaNetwork != null) {
			return socialMediaNetwork;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSocialMediaNetworkException(sb.toString());
	}

	/**
	 * Returns the first social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		List<SocialMediaNetwork> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws NoSuchSocialMediaNetworkException {

		SocialMediaNetwork socialMediaNetwork = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (socialMediaNetwork != null) {
			return socialMediaNetwork;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSocialMediaNetworkException(sb.toString());
	}

	/**
	 * Returns the last social media network in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SocialMediaNetwork> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public SocialMediaNetwork[] findByUuid_C_PrevAndNext(
			long socialMediaNetworkId, String uuid, long companyId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws NoSuchSocialMediaNetworkException {

		uuid = Objects.toString(uuid, "");

		SocialMediaNetwork socialMediaNetwork = findByPrimaryKey(
			socialMediaNetworkId);

		Session session = null;

		try {
			session = openSession();

			SocialMediaNetwork[] array = new SocialMediaNetworkImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, socialMediaNetwork, uuid, companyId, orderByComparator,
				true);

			array[1] = socialMediaNetwork;

			array[2] = getByUuid_C_PrevAndNext(
				session, socialMediaNetwork, uuid, companyId, orderByComparator,
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

	protected SocialMediaNetwork getByUuid_C_PrevAndNext(
		Session session, SocialMediaNetwork socialMediaNetwork, String uuid,
		long companyId, OrderByComparator<SocialMediaNetwork> orderByComparator,
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

		sb.append(_SQL_SELECT_SOCIALMEDIANETWORK_WHERE);

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
			sb.append(SocialMediaNetworkModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						socialMediaNetwork)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SocialMediaNetwork> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social media networks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SocialMediaNetwork socialMediaNetwork :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(socialMediaNetwork);
		}
	}

	/**
	 * Returns the number of social media networks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social media networks
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SOCIALMEDIANETWORK_WHERE);

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
		"socialMediaNetwork.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(socialMediaNetwork.uuid IS NULL OR socialMediaNetwork.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"socialMediaNetwork.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the social media networks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching social media networks
	 */
	@Override
	public List<SocialMediaNetwork> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social media networks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @return the range of matching social media networks
	 */
	@Override
	public List<SocialMediaNetwork> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social media networks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social media networks
	 */
	@Override
	public List<SocialMediaNetwork> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social media networks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social media networks
	 */
	@Override
	public List<SocialMediaNetwork> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator,
		boolean useFinderCache) {

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

		List<SocialMediaNetwork> list = null;

		if (useFinderCache) {
			list = (List<SocialMediaNetwork>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SocialMediaNetwork socialMediaNetwork : list) {
					if (groupId != socialMediaNetwork.getGroupId()) {
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

			sb.append(_SQL_SELECT_SOCIALMEDIANETWORK_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SocialMediaNetworkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<SocialMediaNetwork>)QueryUtil.list(
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
	 * Returns the first social media network in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork findByGroupId_First(
			long groupId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws NoSuchSocialMediaNetworkException {

		SocialMediaNetwork socialMediaNetwork = fetchByGroupId_First(
			groupId, orderByComparator);

		if (socialMediaNetwork != null) {
			return socialMediaNetwork;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSocialMediaNetworkException(sb.toString());
	}

	/**
	 * Returns the first social media network in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork fetchByGroupId_First(
		long groupId, OrderByComparator<SocialMediaNetwork> orderByComparator) {

		List<SocialMediaNetwork> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social media network in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network
	 * @throws NoSuchSocialMediaNetworkException if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork findByGroupId_Last(
			long groupId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws NoSuchSocialMediaNetworkException {

		SocialMediaNetwork socialMediaNetwork = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (socialMediaNetwork != null) {
			return socialMediaNetwork;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSocialMediaNetworkException(sb.toString());
	}

	/**
	 * Returns the last social media network in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	@Override
	public SocialMediaNetwork fetchByGroupId_Last(
		long groupId, OrderByComparator<SocialMediaNetwork> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SocialMediaNetwork> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social media networks before and after the current social media network in the ordered set where groupId = &#63;.
	 *
	 * @param socialMediaNetworkId the primary key of the current social media network
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media network
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	@Override
	public SocialMediaNetwork[] findByGroupId_PrevAndNext(
			long socialMediaNetworkId, long groupId,
			OrderByComparator<SocialMediaNetwork> orderByComparator)
		throws NoSuchSocialMediaNetworkException {

		SocialMediaNetwork socialMediaNetwork = findByPrimaryKey(
			socialMediaNetworkId);

		Session session = null;

		try {
			session = openSession();

			SocialMediaNetwork[] array = new SocialMediaNetworkImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, socialMediaNetwork, groupId, orderByComparator, true);

			array[1] = socialMediaNetwork;

			array[2] = getByGroupId_PrevAndNext(
				session, socialMediaNetwork, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialMediaNetwork getByGroupId_PrevAndNext(
		Session session, SocialMediaNetwork socialMediaNetwork, long groupId,
		OrderByComparator<SocialMediaNetwork> orderByComparator,
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

		sb.append(_SQL_SELECT_SOCIALMEDIANETWORK_WHERE);

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
			sb.append(SocialMediaNetworkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						socialMediaNetwork)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SocialMediaNetwork> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social media networks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (SocialMediaNetwork socialMediaNetwork :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(socialMediaNetwork);
		}
	}

	/**
	 * Returns the number of social media networks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching social media networks
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SOCIALMEDIANETWORK_WHERE);

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
		"socialMediaNetwork.groupId = ?";

	public SocialMediaNetworkPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SocialMediaNetwork.class);

		setModelImplClass(SocialMediaNetworkImpl.class);
		setModelPKClass(long.class);

		setTable(SocialMediaNetworkTable.INSTANCE);
	}

	/**
	 * Caches the social media network in the entity cache if it is enabled.
	 *
	 * @param socialMediaNetwork the social media network
	 */
	@Override
	public void cacheResult(SocialMediaNetwork socialMediaNetwork) {
		entityCache.putResult(
			SocialMediaNetworkImpl.class, socialMediaNetwork.getPrimaryKey(),
			socialMediaNetwork);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				socialMediaNetwork.getUuid(), socialMediaNetwork.getGroupId()
			},
			socialMediaNetwork);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the social media networks in the entity cache if it is enabled.
	 *
	 * @param socialMediaNetworks the social media networks
	 */
	@Override
	public void cacheResult(List<SocialMediaNetwork> socialMediaNetworks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (socialMediaNetworks.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SocialMediaNetwork socialMediaNetwork : socialMediaNetworks) {
			if (entityCache.getResult(
					SocialMediaNetworkImpl.class,
					socialMediaNetwork.getPrimaryKey()) == null) {

				cacheResult(socialMediaNetwork);
			}
		}
	}

	/**
	 * Clears the cache for all social media networks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SocialMediaNetworkImpl.class);

		finderCache.clearCache(SocialMediaNetworkImpl.class);
	}

	/**
	 * Clears the cache for the social media network.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialMediaNetwork socialMediaNetwork) {
		entityCache.removeResult(
			SocialMediaNetworkImpl.class, socialMediaNetwork);
	}

	@Override
	public void clearCache(List<SocialMediaNetwork> socialMediaNetworks) {
		for (SocialMediaNetwork socialMediaNetwork : socialMediaNetworks) {
			entityCache.removeResult(
				SocialMediaNetworkImpl.class, socialMediaNetwork);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SocialMediaNetworkImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SocialMediaNetworkImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SocialMediaNetworkModelImpl socialMediaNetworkModelImpl) {

		Object[] args = new Object[] {
			socialMediaNetworkModelImpl.getUuid(),
			socialMediaNetworkModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, socialMediaNetworkModelImpl);
	}

	/**
	 * Creates a new social media network with the primary key. Does not add the social media network to the database.
	 *
	 * @param socialMediaNetworkId the primary key for the new social media network
	 * @return the new social media network
	 */
	@Override
	public SocialMediaNetwork create(long socialMediaNetworkId) {
		SocialMediaNetwork socialMediaNetwork = new SocialMediaNetworkImpl();

		socialMediaNetwork.setNew(true);
		socialMediaNetwork.setPrimaryKey(socialMediaNetworkId);

		String uuid = _portalUUID.generate();

		socialMediaNetwork.setUuid(uuid);

		socialMediaNetwork.setCompanyId(CompanyThreadLocal.getCompanyId());

		return socialMediaNetwork;
	}

	/**
	 * Removes the social media network with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network that was removed
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	@Override
	public SocialMediaNetwork remove(long socialMediaNetworkId)
		throws NoSuchSocialMediaNetworkException {

		return remove((Serializable)socialMediaNetworkId);
	}

	/**
	 * Removes the social media network with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social media network
	 * @return the social media network that was removed
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	@Override
	public SocialMediaNetwork remove(Serializable primaryKey)
		throws NoSuchSocialMediaNetworkException {

		Session session = null;

		try {
			session = openSession();

			SocialMediaNetwork socialMediaNetwork =
				(SocialMediaNetwork)session.get(
					SocialMediaNetworkImpl.class, primaryKey);

			if (socialMediaNetwork == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialMediaNetworkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(socialMediaNetwork);
		}
		catch (NoSuchSocialMediaNetworkException noSuchEntityException) {
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
	protected SocialMediaNetwork removeImpl(
		SocialMediaNetwork socialMediaNetwork) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialMediaNetwork)) {
				socialMediaNetwork = (SocialMediaNetwork)session.get(
					SocialMediaNetworkImpl.class,
					socialMediaNetwork.getPrimaryKeyObj());
			}

			if (socialMediaNetwork != null) {
				session.delete(socialMediaNetwork);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (socialMediaNetwork != null) {
			clearCache(socialMediaNetwork);
		}

		return socialMediaNetwork;
	}

	@Override
	public SocialMediaNetwork updateImpl(
		SocialMediaNetwork socialMediaNetwork) {

		boolean isNew = socialMediaNetwork.isNew();

		if (!(socialMediaNetwork instanceof SocialMediaNetworkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(socialMediaNetwork.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					socialMediaNetwork);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in socialMediaNetwork proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SocialMediaNetwork implementation " +
					socialMediaNetwork.getClass());
		}

		SocialMediaNetworkModelImpl socialMediaNetworkModelImpl =
			(SocialMediaNetworkModelImpl)socialMediaNetwork;

		if (Validator.isNull(socialMediaNetwork.getUuid())) {
			String uuid = _portalUUID.generate();

			socialMediaNetwork.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (socialMediaNetwork.getCreateDate() == null)) {
			if (serviceContext == null) {
				socialMediaNetwork.setCreateDate(date);
			}
			else {
				socialMediaNetwork.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!socialMediaNetworkModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				socialMediaNetwork.setModifiedDate(date);
			}
			else {
				socialMediaNetwork.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(socialMediaNetwork);
			}
			else {
				socialMediaNetwork = (SocialMediaNetwork)session.merge(
					socialMediaNetwork);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SocialMediaNetworkImpl.class, socialMediaNetworkModelImpl, false,
			true);

		cacheUniqueFindersCache(socialMediaNetworkModelImpl);

		if (isNew) {
			socialMediaNetwork.setNew(false);
		}

		socialMediaNetwork.resetOriginalValues();

		return socialMediaNetwork;
	}

	/**
	 * Returns the social media network with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social media network
	 * @return the social media network
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	@Override
	public SocialMediaNetwork findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialMediaNetworkException {

		SocialMediaNetwork socialMediaNetwork = fetchByPrimaryKey(primaryKey);

		if (socialMediaNetwork == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialMediaNetworkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return socialMediaNetwork;
	}

	/**
	 * Returns the social media network with the primary key or throws a <code>NoSuchSocialMediaNetworkException</code> if it could not be found.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network
	 * @throws NoSuchSocialMediaNetworkException if a social media network with the primary key could not be found
	 */
	@Override
	public SocialMediaNetwork findByPrimaryKey(long socialMediaNetworkId)
		throws NoSuchSocialMediaNetworkException {

		return findByPrimaryKey((Serializable)socialMediaNetworkId);
	}

	/**
	 * Returns the social media network with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network, or <code>null</code> if a social media network with the primary key could not be found
	 */
	@Override
	public SocialMediaNetwork fetchByPrimaryKey(long socialMediaNetworkId) {
		return fetchByPrimaryKey((Serializable)socialMediaNetworkId);
	}

	/**
	 * Returns all the social media networks.
	 *
	 * @return the social media networks
	 */
	@Override
	public List<SocialMediaNetwork> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<SocialMediaNetwork> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<SocialMediaNetwork> findAll(
		int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<SocialMediaNetwork> findAll(
		int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator,
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

		List<SocialMediaNetwork> list = null;

		if (useFinderCache) {
			list = (List<SocialMediaNetwork>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SOCIALMEDIANETWORK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALMEDIANETWORK;

				sql = sql.concat(SocialMediaNetworkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SocialMediaNetwork>)QueryUtil.list(
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
	 * Removes all the social media networks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SocialMediaNetwork socialMediaNetwork : findAll()) {
			remove(socialMediaNetwork);
		}
	}

	/**
	 * Returns the number of social media networks.
	 *
	 * @return the number of social media networks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_SOCIALMEDIANETWORK);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "socialMediaNetworkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SOCIALMEDIANETWORK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SocialMediaNetworkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the social media network persistence.
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

		_setSocialMediaNetworkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSocialMediaNetworkUtilPersistence(null);

		entityCache.removeCache(SocialMediaNetworkImpl.class.getName());
	}

	private void _setSocialMediaNetworkUtilPersistence(
		SocialMediaNetworkPersistence socialMediaNetworkPersistence) {

		try {
			Field field = SocialMediaNetworkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, socialMediaNetworkPersistence);
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

	private static final String _SQL_SELECT_SOCIALMEDIANETWORK =
		"SELECT socialMediaNetwork FROM SocialMediaNetwork socialMediaNetwork";

	private static final String _SQL_SELECT_SOCIALMEDIANETWORK_WHERE =
		"SELECT socialMediaNetwork FROM SocialMediaNetwork socialMediaNetwork WHERE ";

	private static final String _SQL_COUNT_SOCIALMEDIANETWORK =
		"SELECT COUNT(socialMediaNetwork) FROM SocialMediaNetwork socialMediaNetwork";

	private static final String _SQL_COUNT_SOCIALMEDIANETWORK_WHERE =
		"SELECT COUNT(socialMediaNetwork) FROM SocialMediaNetwork socialMediaNetwork WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "socialMediaNetwork.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SocialMediaNetwork exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SocialMediaNetwork exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SocialMediaNetworkPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private SocialMediaNetworkModelArgumentsResolver
		_socialMediaNetworkModelArgumentsResolver;

}