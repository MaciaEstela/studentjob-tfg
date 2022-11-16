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

import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.model.SocialMediaTable;
import edu.uoc.mestemi.studentjob.model.impl.SocialMediaImpl;
import edu.uoc.mestemi.studentjob.model.impl.SocialMediaModelImpl;
import edu.uoc.mestemi.studentjob.service.persistence.SocialMediaPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.SocialMediaUtil;
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
 * The persistence implementation for the social media service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {SocialMediaPersistence.class, BasePersistence.class})
public class SocialMediaPersistenceImpl
	extends BasePersistenceImpl<SocialMedia> implements SocialMediaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SocialMediaUtil</code> to access the social media persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SocialMediaImpl.class.getName();

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
	 * Returns all the social medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social medias
	 */
	@Override
	public List<SocialMedia> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social medias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of matching social medias
	 */
	@Override
	public List<SocialMedia> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social medias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social medias
	 */
	@Override
	public List<SocialMedia> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social medias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social medias
	 */
	@Override
	public List<SocialMedia> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator,
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

		List<SocialMedia> list = null;

		if (useFinderCache) {
			list = (List<SocialMedia>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SocialMedia socialMedia : list) {
					if (!uuid.equals(socialMedia.getUuid())) {
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

			sb.append(_SQL_SELECT_SOCIALMEDIA_WHERE);

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
				sb.append(SocialMediaModelImpl.ORDER_BY_JPQL);
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

				list = (List<SocialMedia>)QueryUtil.list(
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
	 * Returns the first social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	@Override
	public SocialMedia findByUuid_First(
			String uuid, OrderByComparator<SocialMedia> orderByComparator)
		throws NoSuchSocialMediaException {

		SocialMedia socialMedia = fetchByUuid_First(uuid, orderByComparator);

		if (socialMedia != null) {
			return socialMedia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSocialMediaException(sb.toString());
	}

	/**
	 * Returns the first social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	@Override
	public SocialMedia fetchByUuid_First(
		String uuid, OrderByComparator<SocialMedia> orderByComparator) {

		List<SocialMedia> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	@Override
	public SocialMedia findByUuid_Last(
			String uuid, OrderByComparator<SocialMedia> orderByComparator)
		throws NoSuchSocialMediaException {

		SocialMedia socialMedia = fetchByUuid_Last(uuid, orderByComparator);

		if (socialMedia != null) {
			return socialMedia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSocialMediaException(sb.toString());
	}

	/**
	 * Returns the last social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	@Override
	public SocialMedia fetchByUuid_Last(
		String uuid, OrderByComparator<SocialMedia> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SocialMedia> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social medias before and after the current social media in the ordered set where uuid = &#63;.
	 *
	 * @param socialMediaId the primary key of the current social media
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	@Override
	public SocialMedia[] findByUuid_PrevAndNext(
			long socialMediaId, String uuid,
			OrderByComparator<SocialMedia> orderByComparator)
		throws NoSuchSocialMediaException {

		uuid = Objects.toString(uuid, "");

		SocialMedia socialMedia = findByPrimaryKey(socialMediaId);

		Session session = null;

		try {
			session = openSession();

			SocialMedia[] array = new SocialMediaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, socialMedia, uuid, orderByComparator, true);

			array[1] = socialMedia;

			array[2] = getByUuid_PrevAndNext(
				session, socialMedia, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialMedia getByUuid_PrevAndNext(
		Session session, SocialMedia socialMedia, String uuid,
		OrderByComparator<SocialMedia> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SOCIALMEDIA_WHERE);

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
			sb.append(SocialMediaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(socialMedia)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SocialMedia> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social medias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SocialMedia socialMedia :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(socialMedia);
		}
	}

	/**
	 * Returns the number of social medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social medias
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SOCIALMEDIA_WHERE);

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
		"socialMedia.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(socialMedia.uuid IS NULL OR socialMedia.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the social media where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSocialMediaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	@Override
	public SocialMedia findByUUID_G(String uuid, long groupId)
		throws NoSuchSocialMediaException {

		SocialMedia socialMedia = fetchByUUID_G(uuid, groupId);

		if (socialMedia == null) {
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

			throw new NoSuchSocialMediaException(sb.toString());
		}

		return socialMedia;
	}

	/**
	 * Returns the social media where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media, or <code>null</code> if a matching social media could not be found
	 */
	@Override
	public SocialMedia fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the social media where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social media, or <code>null</code> if a matching social media could not be found
	 */
	@Override
	public SocialMedia fetchByUUID_G(
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

		if (result instanceof SocialMedia) {
			SocialMedia socialMedia = (SocialMedia)result;

			if (!Objects.equals(uuid, socialMedia.getUuid()) ||
				(groupId != socialMedia.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SOCIALMEDIA_WHERE);

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

				List<SocialMedia> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SocialMedia socialMedia = list.get(0);

					result = socialMedia;

					cacheResult(socialMedia);
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
			return (SocialMedia)result;
		}
	}

	/**
	 * Removes the social media where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social media that was removed
	 */
	@Override
	public SocialMedia removeByUUID_G(String uuid, long groupId)
		throws NoSuchSocialMediaException {

		SocialMedia socialMedia = findByUUID_G(uuid, groupId);

		return remove(socialMedia);
	}

	/**
	 * Returns the number of social medias where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social medias
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SOCIALMEDIA_WHERE);

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
		"socialMedia.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(socialMedia.uuid IS NULL OR socialMedia.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"socialMedia.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social medias
	 */
	@Override
	public List<SocialMedia> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of matching social medias
	 */
	@Override
	public List<SocialMedia> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social medias
	 */
	@Override
	public List<SocialMedia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social medias
	 */
	@Override
	public List<SocialMedia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator,
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

		List<SocialMedia> list = null;

		if (useFinderCache) {
			list = (List<SocialMedia>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SocialMedia socialMedia : list) {
					if (!uuid.equals(socialMedia.getUuid()) ||
						(companyId != socialMedia.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SOCIALMEDIA_WHERE);

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
				sb.append(SocialMediaModelImpl.ORDER_BY_JPQL);
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

				list = (List<SocialMedia>)QueryUtil.list(
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
	 * Returns the first social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	@Override
	public SocialMedia findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SocialMedia> orderByComparator)
		throws NoSuchSocialMediaException {

		SocialMedia socialMedia = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (socialMedia != null) {
			return socialMedia;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSocialMediaException(sb.toString());
	}

	/**
	 * Returns the first social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	@Override
	public SocialMedia fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SocialMedia> orderByComparator) {

		List<SocialMedia> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	@Override
	public SocialMedia findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SocialMedia> orderByComparator)
		throws NoSuchSocialMediaException {

		SocialMedia socialMedia = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (socialMedia != null) {
			return socialMedia;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSocialMediaException(sb.toString());
	}

	/**
	 * Returns the last social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	@Override
	public SocialMedia fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SocialMedia> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SocialMedia> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social medias before and after the current social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param socialMediaId the primary key of the current social media
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	@Override
	public SocialMedia[] findByUuid_C_PrevAndNext(
			long socialMediaId, String uuid, long companyId,
			OrderByComparator<SocialMedia> orderByComparator)
		throws NoSuchSocialMediaException {

		uuid = Objects.toString(uuid, "");

		SocialMedia socialMedia = findByPrimaryKey(socialMediaId);

		Session session = null;

		try {
			session = openSession();

			SocialMedia[] array = new SocialMediaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, socialMedia, uuid, companyId, orderByComparator, true);

			array[1] = socialMedia;

			array[2] = getByUuid_C_PrevAndNext(
				session, socialMedia, uuid, companyId, orderByComparator,
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

	protected SocialMedia getByUuid_C_PrevAndNext(
		Session session, SocialMedia socialMedia, String uuid, long companyId,
		OrderByComparator<SocialMedia> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SOCIALMEDIA_WHERE);

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
			sb.append(SocialMediaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(socialMedia)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SocialMedia> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social medias where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SocialMedia socialMedia :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(socialMedia);
		}
	}

	/**
	 * Returns the number of social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social medias
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SOCIALMEDIA_WHERE);

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
		"socialMedia.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(socialMedia.uuid IS NULL OR socialMedia.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"socialMedia.companyId = ?";

	private FinderPath
		_finderPathWithPaginationFindByGroupIdAndClassNameAndClassPK;
	private FinderPath
		_finderPathWithoutPaginationFindByGroupIdAndClassNameAndClassPK;
	private FinderPath _finderPathCountByGroupIdAndClassNameAndClassPK;

	/**
	 * Returns all the social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching social medias
	 */
	@Override
	public List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK) {

		return findByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of matching social medias
	 */
	@Override
	public List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK, int start, int end) {

		return findByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social medias
	 */
	@Override
	public List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return findByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social medias
	 */
	@Override
	public List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator,
		boolean useFinderCache) {

		className = Objects.toString(className, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroupIdAndClassNameAndClassPK;
				finderArgs = new Object[] {groupId, className, classPK};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroupIdAndClassNameAndClassPK;
			finderArgs = new Object[] {
				groupId, className, classPK, start, end, orderByComparator
			};
		}

		List<SocialMedia> list = null;

		if (useFinderCache) {
			list = (List<SocialMedia>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SocialMedia socialMedia : list) {
					if ((groupId != socialMedia.getGroupId()) ||
						!className.equals(socialMedia.getClassName()) ||
						(classPK != socialMedia.getClassPK())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_SOCIALMEDIA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_GROUPID_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(
					_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSNAME_2);
			}

			sb.append(_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SocialMediaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindClassName) {
					queryPos.add(className);
				}

				queryPos.add(classPK);

				list = (List<SocialMedia>)QueryUtil.list(
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
	 * Returns the first social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	@Override
	public SocialMedia findByGroupIdAndClassNameAndClassPK_First(
			long groupId, String className, long classPK,
			OrderByComparator<SocialMedia> orderByComparator)
		throws NoSuchSocialMediaException {

		SocialMedia socialMedia = fetchByGroupIdAndClassNameAndClassPK_First(
			groupId, className, classPK, orderByComparator);

		if (socialMedia != null) {
			return socialMedia;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", className=");
		sb.append(className);

		sb.append(", classPK=");
		sb.append(classPK);

		sb.append("}");

		throw new NoSuchSocialMediaException(sb.toString());
	}

	/**
	 * Returns the first social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	@Override
	public SocialMedia fetchByGroupIdAndClassNameAndClassPK_First(
		long groupId, String className, long classPK,
		OrderByComparator<SocialMedia> orderByComparator) {

		List<SocialMedia> list = findByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	@Override
	public SocialMedia findByGroupIdAndClassNameAndClassPK_Last(
			long groupId, String className, long classPK,
			OrderByComparator<SocialMedia> orderByComparator)
		throws NoSuchSocialMediaException {

		SocialMedia socialMedia = fetchByGroupIdAndClassNameAndClassPK_Last(
			groupId, className, classPK, orderByComparator);

		if (socialMedia != null) {
			return socialMedia;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", className=");
		sb.append(className);

		sb.append(", classPK=");
		sb.append(classPK);

		sb.append("}");

		throw new NoSuchSocialMediaException(sb.toString());
	}

	/**
	 * Returns the last social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	@Override
	public SocialMedia fetchByGroupIdAndClassNameAndClassPK_Last(
		long groupId, String className, long classPK,
		OrderByComparator<SocialMedia> orderByComparator) {

		int count = countByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK);

		if (count == 0) {
			return null;
		}

		List<SocialMedia> list = findByGroupIdAndClassNameAndClassPK(
			groupId, className, classPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social medias before and after the current social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param socialMediaId the primary key of the current social media
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	@Override
	public SocialMedia[] findByGroupIdAndClassNameAndClassPK_PrevAndNext(
			long socialMediaId, long groupId, String className, long classPK,
			OrderByComparator<SocialMedia> orderByComparator)
		throws NoSuchSocialMediaException {

		className = Objects.toString(className, "");

		SocialMedia socialMedia = findByPrimaryKey(socialMediaId);

		Session session = null;

		try {
			session = openSession();

			SocialMedia[] array = new SocialMediaImpl[3];

			array[0] = getByGroupIdAndClassNameAndClassPK_PrevAndNext(
				session, socialMedia, groupId, className, classPK,
				orderByComparator, true);

			array[1] = socialMedia;

			array[2] = getByGroupIdAndClassNameAndClassPK_PrevAndNext(
				session, socialMedia, groupId, className, classPK,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialMedia getByGroupIdAndClassNameAndClassPK_PrevAndNext(
		Session session, SocialMedia socialMedia, long groupId,
		String className, long classPK,
		OrderByComparator<SocialMedia> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_SOCIALMEDIA_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_GROUPID_2);

		boolean bindClassName = false;

		if (className.isEmpty()) {
			sb.append(_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			sb.append(_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSNAME_2);
		}

		sb.append(_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSPK_2);

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
			sb.append(SocialMediaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindClassName) {
			queryPos.add(className);
		}

		queryPos.add(classPK);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(socialMedia)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SocialMedia> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social medias where groupId = &#63; and className = &#63; and classPK = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 */
	@Override
	public void removeByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK) {

		for (SocialMedia socialMedia :
				findByGroupIdAndClassNameAndClassPK(
					groupId, className, classPK, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(socialMedia);
		}
	}

	/**
	 * Returns the number of social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching social medias
	 */
	@Override
	public int countByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK) {

		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByGroupIdAndClassNameAndClassPK;

		Object[] finderArgs = new Object[] {groupId, className, classPK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_SOCIALMEDIA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_GROUPID_2);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				sb.append(
					_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSNAME_2);
			}

			sb.append(_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindClassName) {
					queryPos.add(className);
				}

				queryPos.add(classPK);

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
		_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_GROUPID_2 =
			"socialMedia.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSNAME_2 =
			"socialMedia.className = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSNAME_3 =
			"(socialMedia.className IS NULL OR socialMedia.className = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDANDCLASSNAMEANDCLASSPK_CLASSPK_2 =
			"socialMedia.classPK = ?";

	public SocialMediaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SocialMedia.class);

		setModelImplClass(SocialMediaImpl.class);
		setModelPKClass(long.class);

		setTable(SocialMediaTable.INSTANCE);
	}

	/**
	 * Caches the social media in the entity cache if it is enabled.
	 *
	 * @param socialMedia the social media
	 */
	@Override
	public void cacheResult(SocialMedia socialMedia) {
		entityCache.putResult(
			SocialMediaImpl.class, socialMedia.getPrimaryKey(), socialMedia);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {socialMedia.getUuid(), socialMedia.getGroupId()},
			socialMedia);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the social medias in the entity cache if it is enabled.
	 *
	 * @param socialMedias the social medias
	 */
	@Override
	public void cacheResult(List<SocialMedia> socialMedias) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (socialMedias.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SocialMedia socialMedia : socialMedias) {
			if (entityCache.getResult(
					SocialMediaImpl.class, socialMedia.getPrimaryKey()) ==
						null) {

				cacheResult(socialMedia);
			}
		}
	}

	/**
	 * Clears the cache for all social medias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SocialMediaImpl.class);

		finderCache.clearCache(SocialMediaImpl.class);
	}

	/**
	 * Clears the cache for the social media.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialMedia socialMedia) {
		entityCache.removeResult(SocialMediaImpl.class, socialMedia);
	}

	@Override
	public void clearCache(List<SocialMedia> socialMedias) {
		for (SocialMedia socialMedia : socialMedias) {
			entityCache.removeResult(SocialMediaImpl.class, socialMedia);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SocialMediaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SocialMediaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SocialMediaModelImpl socialMediaModelImpl) {

		Object[] args = new Object[] {
			socialMediaModelImpl.getUuid(), socialMediaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, socialMediaModelImpl);
	}

	/**
	 * Creates a new social media with the primary key. Does not add the social media to the database.
	 *
	 * @param socialMediaId the primary key for the new social media
	 * @return the new social media
	 */
	@Override
	public SocialMedia create(long socialMediaId) {
		SocialMedia socialMedia = new SocialMediaImpl();

		socialMedia.setNew(true);
		socialMedia.setPrimaryKey(socialMediaId);

		String uuid = _portalUUID.generate();

		socialMedia.setUuid(uuid);

		socialMedia.setCompanyId(CompanyThreadLocal.getCompanyId());

		return socialMedia;
	}

	/**
	 * Removes the social media with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media that was removed
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	@Override
	public SocialMedia remove(long socialMediaId)
		throws NoSuchSocialMediaException {

		return remove((Serializable)socialMediaId);
	}

	/**
	 * Removes the social media with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social media
	 * @return the social media that was removed
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	@Override
	public SocialMedia remove(Serializable primaryKey)
		throws NoSuchSocialMediaException {

		Session session = null;

		try {
			session = openSession();

			SocialMedia socialMedia = (SocialMedia)session.get(
				SocialMediaImpl.class, primaryKey);

			if (socialMedia == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialMediaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(socialMedia);
		}
		catch (NoSuchSocialMediaException noSuchEntityException) {
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
	protected SocialMedia removeImpl(SocialMedia socialMedia) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialMedia)) {
				socialMedia = (SocialMedia)session.get(
					SocialMediaImpl.class, socialMedia.getPrimaryKeyObj());
			}

			if (socialMedia != null) {
				session.delete(socialMedia);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (socialMedia != null) {
			clearCache(socialMedia);
		}

		return socialMedia;
	}

	@Override
	public SocialMedia updateImpl(SocialMedia socialMedia) {
		boolean isNew = socialMedia.isNew();

		if (!(socialMedia instanceof SocialMediaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(socialMedia.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(socialMedia);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in socialMedia proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SocialMedia implementation " +
					socialMedia.getClass());
		}

		SocialMediaModelImpl socialMediaModelImpl =
			(SocialMediaModelImpl)socialMedia;

		if (Validator.isNull(socialMedia.getUuid())) {
			String uuid = _portalUUID.generate();

			socialMedia.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (socialMedia.getCreateDate() == null)) {
			if (serviceContext == null) {
				socialMedia.setCreateDate(date);
			}
			else {
				socialMedia.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!socialMediaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				socialMedia.setModifiedDate(date);
			}
			else {
				socialMedia.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(socialMedia);
			}
			else {
				socialMedia = (SocialMedia)session.merge(socialMedia);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SocialMediaImpl.class, socialMediaModelImpl, false, true);

		cacheUniqueFindersCache(socialMediaModelImpl);

		if (isNew) {
			socialMedia.setNew(false);
		}

		socialMedia.resetOriginalValues();

		return socialMedia;
	}

	/**
	 * Returns the social media with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social media
	 * @return the social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	@Override
	public SocialMedia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialMediaException {

		SocialMedia socialMedia = fetchByPrimaryKey(primaryKey);

		if (socialMedia == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialMediaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return socialMedia;
	}

	/**
	 * Returns the social media with the primary key or throws a <code>NoSuchSocialMediaException</code> if it could not be found.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	@Override
	public SocialMedia findByPrimaryKey(long socialMediaId)
		throws NoSuchSocialMediaException {

		return findByPrimaryKey((Serializable)socialMediaId);
	}

	/**
	 * Returns the social media with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media, or <code>null</code> if a social media with the primary key could not be found
	 */
	@Override
	public SocialMedia fetchByPrimaryKey(long socialMediaId) {
		return fetchByPrimaryKey((Serializable)socialMediaId);
	}

	/**
	 * Returns all the social medias.
	 *
	 * @return the social medias
	 */
	@Override
	public List<SocialMedia> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of social medias
	 */
	@Override
	public List<SocialMedia> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the social medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social medias
	 */
	@Override
	public List<SocialMedia> findAll(
		int start, int end, OrderByComparator<SocialMedia> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of social medias
	 */
	@Override
	public List<SocialMedia> findAll(
		int start, int end, OrderByComparator<SocialMedia> orderByComparator,
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

		List<SocialMedia> list = null;

		if (useFinderCache) {
			list = (List<SocialMedia>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SOCIALMEDIA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALMEDIA;

				sql = sql.concat(SocialMediaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SocialMedia>)QueryUtil.list(
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
	 * Removes all the social medias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SocialMedia socialMedia : findAll()) {
			remove(socialMedia);
		}
	}

	/**
	 * Returns the number of social medias.
	 *
	 * @return the number of social medias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SOCIALMEDIA);

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
		return "socialMediaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SOCIALMEDIA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SocialMediaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the social media persistence.
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

		_finderPathWithPaginationFindByGroupIdAndClassNameAndClassPK =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroupIdAndClassNameAndClassPK",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"groupId", "className", "classPK"}, true);

		_finderPathWithoutPaginationFindByGroupIdAndClassNameAndClassPK =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroupIdAndClassNameAndClassPK",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				new String[] {"groupId", "className", "classPK"}, true);

		_finderPathCountByGroupIdAndClassNameAndClassPK = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndClassNameAndClassPK",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"groupId", "className", "classPK"}, false);

		_setSocialMediaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSocialMediaUtilPersistence(null);

		entityCache.removeCache(SocialMediaImpl.class.getName());
	}

	private void _setSocialMediaUtilPersistence(
		SocialMediaPersistence socialMediaPersistence) {

		try {
			Field field = SocialMediaUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, socialMediaPersistence);
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

	private static final String _SQL_SELECT_SOCIALMEDIA =
		"SELECT socialMedia FROM SocialMedia socialMedia";

	private static final String _SQL_SELECT_SOCIALMEDIA_WHERE =
		"SELECT socialMedia FROM SocialMedia socialMedia WHERE ";

	private static final String _SQL_COUNT_SOCIALMEDIA =
		"SELECT COUNT(socialMedia) FROM SocialMedia socialMedia";

	private static final String _SQL_COUNT_SOCIALMEDIA_WHERE =
		"SELECT COUNT(socialMedia) FROM SocialMedia socialMedia WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "socialMedia.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SocialMedia exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SocialMedia exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SocialMediaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private SocialMediaModelArgumentsResolver
		_socialMediaModelArgumentsResolver;

}