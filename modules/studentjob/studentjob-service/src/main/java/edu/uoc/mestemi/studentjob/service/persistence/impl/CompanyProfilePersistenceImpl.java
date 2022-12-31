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

import edu.uoc.mestemi.studentjob.exception.NoSuchCompanyProfileException;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.CompanyProfileTable;
import edu.uoc.mestemi.studentjob.model.impl.CompanyProfileImpl;
import edu.uoc.mestemi.studentjob.model.impl.CompanyProfileModelImpl;
import edu.uoc.mestemi.studentjob.service.persistence.CompanyProfilePersistence;
import edu.uoc.mestemi.studentjob.service.persistence.CompanyProfileUtil;
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
 * The persistence implementation for the company profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {CompanyProfilePersistence.class, BasePersistence.class})
public class CompanyProfilePersistenceImpl
	extends BasePersistenceImpl<CompanyProfile>
	implements CompanyProfilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CompanyProfileUtil</code> to access the company profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CompanyProfileImpl.class.getName();

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
	 * Returns all the company profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CompanyProfile> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<CompanyProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<CompanyProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator,
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

		List<CompanyProfile> list = null;

		if (useFinderCache) {
			list = (List<CompanyProfile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CompanyProfile companyProfile : list) {
					if (!uuid.equals(companyProfile.getUuid())) {
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

			sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

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
				sb.append(CompanyProfileModelImpl.ORDER_BY_JPQL);
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

				list = (List<CompanyProfile>)QueryUtil.list(
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
	 * Returns the first company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByUuid_First(
			String uuid, OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByUuid_First(
			uuid, orderByComparator);

		if (companyProfile != null) {
			return companyProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCompanyProfileException(sb.toString());
	}

	/**
	 * Returns the first company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByUuid_First(
		String uuid, OrderByComparator<CompanyProfile> orderByComparator) {

		List<CompanyProfile> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByUuid_Last(
			String uuid, OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByUuid_Last(
			uuid, orderByComparator);

		if (companyProfile != null) {
			return companyProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCompanyProfileException(sb.toString());
	}

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByUuid_Last(
		String uuid, OrderByComparator<CompanyProfile> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CompanyProfile> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the company profiles before and after the current company profile in the ordered set where uuid = &#63;.
	 *
	 * @param companyProfileId the primary key of the current company profile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	@Override
	public CompanyProfile[] findByUuid_PrevAndNext(
			long companyProfileId, String uuid,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		uuid = Objects.toString(uuid, "");

		CompanyProfile companyProfile = findByPrimaryKey(companyProfileId);

		Session session = null;

		try {
			session = openSession();

			CompanyProfile[] array = new CompanyProfileImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, companyProfile, uuid, orderByComparator, true);

			array[1] = companyProfile;

			array[2] = getByUuid_PrevAndNext(
				session, companyProfile, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CompanyProfile getByUuid_PrevAndNext(
		Session session, CompanyProfile companyProfile, String uuid,
		OrderByComparator<CompanyProfile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

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
			sb.append(CompanyProfileModelImpl.ORDER_BY_JPQL);
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
						companyProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CompanyProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the company profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CompanyProfile companyProfile :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(companyProfile);
		}
	}

	/**
	 * Returns the number of company profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching company profiles
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMPANYPROFILE_WHERE);

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
		"companyProfile.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(companyProfile.uuid IS NULL OR companyProfile.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the company profile where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCompanyProfileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByUUID_G(String uuid, long groupId)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByUUID_G(uuid, groupId);

		if (companyProfile == null) {
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

			throw new NoSuchCompanyProfileException(sb.toString());
		}

		return companyProfile;
	}

	/**
	 * Returns the company profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the company profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByUUID_G(
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

		if (result instanceof CompanyProfile) {
			CompanyProfile companyProfile = (CompanyProfile)result;

			if (!Objects.equals(uuid, companyProfile.getUuid()) ||
				(groupId != companyProfile.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

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

				List<CompanyProfile> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CompanyProfile companyProfile = list.get(0);

					result = companyProfile;

					cacheResult(companyProfile);
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
			return (CompanyProfile)result;
		}
	}

	/**
	 * Removes the company profile where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the company profile that was removed
	 */
	@Override
	public CompanyProfile removeByUUID_G(String uuid, long groupId)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = findByUUID_G(uuid, groupId);

		return remove(companyProfile);
	}

	/**
	 * Returns the number of company profiles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching company profiles
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMPANYPROFILE_WHERE);

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
		"companyProfile.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(companyProfile.uuid IS NULL OR companyProfile.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"companyProfile.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the company profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CompanyProfile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<CompanyProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<CompanyProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator,
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

		List<CompanyProfile> list = null;

		if (useFinderCache) {
			list = (List<CompanyProfile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CompanyProfile companyProfile : list) {
					if (!uuid.equals(companyProfile.getUuid()) ||
						(companyId != companyProfile.getCompanyId())) {

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

			sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

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
				sb.append(CompanyProfileModelImpl.ORDER_BY_JPQL);
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

				list = (List<CompanyProfile>)QueryUtil.list(
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
	 * Returns the first company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (companyProfile != null) {
			return companyProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCompanyProfileException(sb.toString());
	}

	/**
	 * Returns the first company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CompanyProfile> orderByComparator) {

		List<CompanyProfile> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (companyProfile != null) {
			return companyProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCompanyProfileException(sb.toString());
	}

	/**
	 * Returns the last company profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CompanyProfile> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CompanyProfile> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CompanyProfile[] findByUuid_C_PrevAndNext(
			long companyProfileId, String uuid, long companyId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		uuid = Objects.toString(uuid, "");

		CompanyProfile companyProfile = findByPrimaryKey(companyProfileId);

		Session session = null;

		try {
			session = openSession();

			CompanyProfile[] array = new CompanyProfileImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, companyProfile, uuid, companyId, orderByComparator,
				true);

			array[1] = companyProfile;

			array[2] = getByUuid_C_PrevAndNext(
				session, companyProfile, uuid, companyId, orderByComparator,
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

	protected CompanyProfile getByUuid_C_PrevAndNext(
		Session session, CompanyProfile companyProfile, String uuid,
		long companyId, OrderByComparator<CompanyProfile> orderByComparator,
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

		sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

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
			sb.append(CompanyProfileModelImpl.ORDER_BY_JPQL);
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
						companyProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CompanyProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the company profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CompanyProfile companyProfile :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(companyProfile);
		}
	}

	/**
	 * Returns the number of company profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching company profiles
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMPANYPROFILE_WHERE);

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
		"companyProfile.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(companyProfile.uuid IS NULL OR companyProfile.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"companyProfile.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the company profiles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the company profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @return the range of matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the company profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the company profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator,
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

		List<CompanyProfile> list = null;

		if (useFinderCache) {
			list = (List<CompanyProfile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CompanyProfile companyProfile : list) {
					if (groupId != companyProfile.getGroupId()) {
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

			sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CompanyProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<CompanyProfile>)QueryUtil.list(
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
	 * Returns the first company profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByGroupId_First(
			long groupId, OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByGroupId_First(
			groupId, orderByComparator);

		if (companyProfile != null) {
			return companyProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCompanyProfileException(sb.toString());
	}

	/**
	 * Returns the first company profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByGroupId_First(
		long groupId, OrderByComparator<CompanyProfile> orderByComparator) {

		List<CompanyProfile> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByGroupId_Last(
			long groupId, OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (companyProfile != null) {
			return companyProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCompanyProfileException(sb.toString());
	}

	/**
	 * Returns the last company profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByGroupId_Last(
		long groupId, OrderByComparator<CompanyProfile> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CompanyProfile> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the company profiles before and after the current company profile in the ordered set where groupId = &#63;.
	 *
	 * @param companyProfileId the primary key of the current company profile
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	@Override
	public CompanyProfile[] findByGroupId_PrevAndNext(
			long companyProfileId, long groupId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = findByPrimaryKey(companyProfileId);

		Session session = null;

		try {
			session = openSession();

			CompanyProfile[] array = new CompanyProfileImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, companyProfile, groupId, orderByComparator, true);

			array[1] = companyProfile;

			array[2] = getByGroupId_PrevAndNext(
				session, companyProfile, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CompanyProfile getByGroupId_PrevAndNext(
		Session session, CompanyProfile companyProfile, long groupId,
		OrderByComparator<CompanyProfile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

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
			sb.append(CompanyProfileModelImpl.ORDER_BY_JPQL);
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
						companyProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CompanyProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the company profiles where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (CompanyProfile companyProfile :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(companyProfile);
		}
	}

	/**
	 * Returns the number of company profiles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching company profiles
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMPANYPROFILE_WHERE);

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
		"companyProfile.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdAndActive;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdAndActive;
	private FinderPath _finderPathCountByGroupIdAndActive;

	/**
	 * Returns all the company profiles where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @return the matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupIdAndActive(
		long groupId, boolean active) {

		return findByGroupIdAndActive(
			groupId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the company profiles where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @return the range of matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupIdAndActive(
		long groupId, boolean active, int start, int end) {

		return findByGroupIdAndActive(groupId, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the company profiles where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupIdAndActive(
		long groupId, boolean active, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return findByGroupIdAndActive(
			groupId, active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the company profiles where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupIdAndActive(
		long groupId, boolean active, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupIdAndActive;
				finderArgs = new Object[] {groupId, active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupIdAndActive;
			finderArgs = new Object[] {
				groupId, active, start, end, orderByComparator
			};
		}

		List<CompanyProfile> list = null;

		if (useFinderCache) {
			list = (List<CompanyProfile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CompanyProfile companyProfile : list) {
					if ((groupId != companyProfile.getGroupId()) ||
						(active != companyProfile.isActive())) {

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

			sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDACTIVE_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CompanyProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(active);

				list = (List<CompanyProfile>)QueryUtil.list(
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
	 * Returns the first company profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByGroupIdAndActive_First(
			long groupId, boolean active,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByGroupIdAndActive_First(
			groupId, active, orderByComparator);

		if (companyProfile != null) {
			return companyProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchCompanyProfileException(sb.toString());
	}

	/**
	 * Returns the first company profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByGroupIdAndActive_First(
		long groupId, boolean active,
		OrderByComparator<CompanyProfile> orderByComparator) {

		List<CompanyProfile> list = findByGroupIdAndActive(
			groupId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByGroupIdAndActive_Last(
			long groupId, boolean active,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByGroupIdAndActive_Last(
			groupId, active, orderByComparator);

		if (companyProfile != null) {
			return companyProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchCompanyProfileException(sb.toString());
	}

	/**
	 * Returns the last company profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByGroupIdAndActive_Last(
		long groupId, boolean active,
		OrderByComparator<CompanyProfile> orderByComparator) {

		int count = countByGroupIdAndActive(groupId, active);

		if (count == 0) {
			return null;
		}

		List<CompanyProfile> list = findByGroupIdAndActive(
			groupId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the company profiles before and after the current company profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param companyProfileId the primary key of the current company profile
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	@Override
	public CompanyProfile[] findByGroupIdAndActive_PrevAndNext(
			long companyProfileId, long groupId, boolean active,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = findByPrimaryKey(companyProfileId);

		Session session = null;

		try {
			session = openSession();

			CompanyProfile[] array = new CompanyProfileImpl[3];

			array[0] = getByGroupIdAndActive_PrevAndNext(
				session, companyProfile, groupId, active, orderByComparator,
				true);

			array[1] = companyProfile;

			array[2] = getByGroupIdAndActive_PrevAndNext(
				session, companyProfile, groupId, active, orderByComparator,
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

	protected CompanyProfile getByGroupIdAndActive_PrevAndNext(
		Session session, CompanyProfile companyProfile, long groupId,
		boolean active, OrderByComparator<CompanyProfile> orderByComparator,
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

		sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDANDACTIVE_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDANDACTIVE_ACTIVE_2);

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
			sb.append(CompanyProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(active);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						companyProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CompanyProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the company profiles where groupId = &#63; and active = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 */
	@Override
	public void removeByGroupIdAndActive(long groupId, boolean active) {
		for (CompanyProfile companyProfile :
				findByGroupIdAndActive(
					groupId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(companyProfile);
		}
	}

	/**
	 * Returns the number of company profiles where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @return the number of matching company profiles
	 */
	@Override
	public int countByGroupIdAndActive(long groupId, boolean active) {
		FinderPath finderPath = _finderPathCountByGroupIdAndActive;

		Object[] finderArgs = new Object[] {groupId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMPANYPROFILE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDACTIVE_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDACTIVE_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(active);

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

	private static final String _FINDER_COLUMN_GROUPIDANDACTIVE_GROUPID_2 =
		"companyProfile.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDANDACTIVE_ACTIVE_2 =
		"companyProfile.active = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdAndUserId;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdAndUserId;
	private FinderPath _finderPathCountByGroupIdAndUserId;

	/**
	 * Returns all the company profiles where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupIdAndUserId(
		long groupId, long userId) {

		return findByGroupIdAndUserId(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the company profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @return the range of matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end) {

		return findByGroupIdAndUserId(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the company profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return findByGroupIdAndUserId(
			groupId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the company profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching company profiles
	 */
	@Override
	public List<CompanyProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator,
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

		List<CompanyProfile> list = null;

		if (useFinderCache) {
			list = (List<CompanyProfile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CompanyProfile companyProfile : list) {
					if ((groupId != companyProfile.getGroupId()) ||
						(userId != companyProfile.getUserId())) {

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

			sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CompanyProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<CompanyProfile>)QueryUtil.list(
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
	 * Returns the first company profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByGroupIdAndUserId_First(
			long groupId, long userId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByGroupIdAndUserId_First(
			groupId, userId, orderByComparator);

		if (companyProfile != null) {
			return companyProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCompanyProfileException(sb.toString());
	}

	/**
	 * Returns the first company profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByGroupIdAndUserId_First(
		long groupId, long userId,
		OrderByComparator<CompanyProfile> orderByComparator) {

		List<CompanyProfile> list = findByGroupIdAndUserId(
			groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile
	 * @throws NoSuchCompanyProfileException if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile findByGroupIdAndUserId_Last(
			long groupId, long userId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByGroupIdAndUserId_Last(
			groupId, userId, orderByComparator);

		if (companyProfile != null) {
			return companyProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCompanyProfileException(sb.toString());
	}

	/**
	 * Returns the last company profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public CompanyProfile fetchByGroupIdAndUserId_Last(
		long groupId, long userId,
		OrderByComparator<CompanyProfile> orderByComparator) {

		int count = countByGroupIdAndUserId(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<CompanyProfile> list = findByGroupIdAndUserId(
			groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the company profiles before and after the current company profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param companyProfileId the primary key of the current company profile
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	@Override
	public CompanyProfile[] findByGroupIdAndUserId_PrevAndNext(
			long companyProfileId, long groupId, long userId,
			OrderByComparator<CompanyProfile> orderByComparator)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = findByPrimaryKey(companyProfileId);

		Session session = null;

		try {
			session = openSession();

			CompanyProfile[] array = new CompanyProfileImpl[3];

			array[0] = getByGroupIdAndUserId_PrevAndNext(
				session, companyProfile, groupId, userId, orderByComparator,
				true);

			array[1] = companyProfile;

			array[2] = getByGroupIdAndUserId_PrevAndNext(
				session, companyProfile, groupId, userId, orderByComparator,
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

	protected CompanyProfile getByGroupIdAndUserId_PrevAndNext(
		Session session, CompanyProfile companyProfile, long groupId,
		long userId, OrderByComparator<CompanyProfile> orderByComparator,
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

		sb.append(_SQL_SELECT_COMPANYPROFILE_WHERE);

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
			sb.append(CompanyProfileModelImpl.ORDER_BY_JPQL);
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
						companyProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CompanyProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the company profiles where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByGroupIdAndUserId(long groupId, long userId) {
		for (CompanyProfile companyProfile :
				findByGroupIdAndUserId(
					groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(companyProfile);
		}
	}

	/**
	 * Returns the number of company profiles where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching company profiles
	 */
	@Override
	public int countByGroupIdAndUserId(long groupId, long userId) {
		FinderPath finderPath = _finderPathCountByGroupIdAndUserId;

		Object[] finderArgs = new Object[] {groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMPANYPROFILE_WHERE);

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
		"companyProfile.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDANDUSERID_USERID_2 =
		"companyProfile.userId = ?";

	public CompanyProfilePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CompanyProfile.class);

		setModelImplClass(CompanyProfileImpl.class);
		setModelPKClass(long.class);

		setTable(CompanyProfileTable.INSTANCE);
	}

	/**
	 * Caches the company profile in the entity cache if it is enabled.
	 *
	 * @param companyProfile the company profile
	 */
	@Override
	public void cacheResult(CompanyProfile companyProfile) {
		entityCache.putResult(
			CompanyProfileImpl.class, companyProfile.getPrimaryKey(),
			companyProfile);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				companyProfile.getUuid(), companyProfile.getGroupId()
			},
			companyProfile);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the company profiles in the entity cache if it is enabled.
	 *
	 * @param companyProfiles the company profiles
	 */
	@Override
	public void cacheResult(List<CompanyProfile> companyProfiles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (companyProfiles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CompanyProfile companyProfile : companyProfiles) {
			if (entityCache.getResult(
					CompanyProfileImpl.class, companyProfile.getPrimaryKey()) ==
						null) {

				cacheResult(companyProfile);
			}
		}
	}

	/**
	 * Clears the cache for all company profiles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CompanyProfileImpl.class);

		finderCache.clearCache(CompanyProfileImpl.class);
	}

	/**
	 * Clears the cache for the company profile.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CompanyProfile companyProfile) {
		entityCache.removeResult(CompanyProfileImpl.class, companyProfile);
	}

	@Override
	public void clearCache(List<CompanyProfile> companyProfiles) {
		for (CompanyProfile companyProfile : companyProfiles) {
			entityCache.removeResult(CompanyProfileImpl.class, companyProfile);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CompanyProfileImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CompanyProfileImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CompanyProfileModelImpl companyProfileModelImpl) {

		Object[] args = new Object[] {
			companyProfileModelImpl.getUuid(),
			companyProfileModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, companyProfileModelImpl);
	}

	/**
	 * Creates a new company profile with the primary key. Does not add the company profile to the database.
	 *
	 * @param companyProfileId the primary key for the new company profile
	 * @return the new company profile
	 */
	@Override
	public CompanyProfile create(long companyProfileId) {
		CompanyProfile companyProfile = new CompanyProfileImpl();

		companyProfile.setNew(true);
		companyProfile.setPrimaryKey(companyProfileId);

		String uuid = _portalUUID.generate();

		companyProfile.setUuid(uuid);

		companyProfile.setCompanyId(CompanyThreadLocal.getCompanyId());

		return companyProfile;
	}

	/**
	 * Removes the company profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile that was removed
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	@Override
	public CompanyProfile remove(long companyProfileId)
		throws NoSuchCompanyProfileException {

		return remove((Serializable)companyProfileId);
	}

	/**
	 * Removes the company profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the company profile
	 * @return the company profile that was removed
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	@Override
	public CompanyProfile remove(Serializable primaryKey)
		throws NoSuchCompanyProfileException {

		Session session = null;

		try {
			session = openSession();

			CompanyProfile companyProfile = (CompanyProfile)session.get(
				CompanyProfileImpl.class, primaryKey);

			if (companyProfile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompanyProfileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(companyProfile);
		}
		catch (NoSuchCompanyProfileException noSuchEntityException) {
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
	protected CompanyProfile removeImpl(CompanyProfile companyProfile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(companyProfile)) {
				companyProfile = (CompanyProfile)session.get(
					CompanyProfileImpl.class,
					companyProfile.getPrimaryKeyObj());
			}

			if (companyProfile != null) {
				session.delete(companyProfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (companyProfile != null) {
			clearCache(companyProfile);
		}

		return companyProfile;
	}

	@Override
	public CompanyProfile updateImpl(CompanyProfile companyProfile) {
		boolean isNew = companyProfile.isNew();

		if (!(companyProfile instanceof CompanyProfileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(companyProfile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					companyProfile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in companyProfile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CompanyProfile implementation " +
					companyProfile.getClass());
		}

		CompanyProfileModelImpl companyProfileModelImpl =
			(CompanyProfileModelImpl)companyProfile;

		if (Validator.isNull(companyProfile.getUuid())) {
			String uuid = _portalUUID.generate();

			companyProfile.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (companyProfile.getCreateDate() == null)) {
			if (serviceContext == null) {
				companyProfile.setCreateDate(date);
			}
			else {
				companyProfile.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!companyProfileModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				companyProfile.setModifiedDate(date);
			}
			else {
				companyProfile.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(companyProfile);
			}
			else {
				companyProfile = (CompanyProfile)session.merge(companyProfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CompanyProfileImpl.class, companyProfileModelImpl, false, true);

		cacheUniqueFindersCache(companyProfileModelImpl);

		if (isNew) {
			companyProfile.setNew(false);
		}

		companyProfile.resetOriginalValues();

		return companyProfile;
	}

	/**
	 * Returns the company profile with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the company profile
	 * @return the company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	@Override
	public CompanyProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompanyProfileException {

		CompanyProfile companyProfile = fetchByPrimaryKey(primaryKey);

		if (companyProfile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompanyProfileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return companyProfile;
	}

	/**
	 * Returns the company profile with the primary key or throws a <code>NoSuchCompanyProfileException</code> if it could not be found.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile
	 * @throws NoSuchCompanyProfileException if a company profile with the primary key could not be found
	 */
	@Override
	public CompanyProfile findByPrimaryKey(long companyProfileId)
		throws NoSuchCompanyProfileException {

		return findByPrimaryKey((Serializable)companyProfileId);
	}

	/**
	 * Returns the company profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile, or <code>null</code> if a company profile with the primary key could not be found
	 */
	@Override
	public CompanyProfile fetchByPrimaryKey(long companyProfileId) {
		return fetchByPrimaryKey((Serializable)companyProfileId);
	}

	/**
	 * Returns all the company profiles.
	 *
	 * @return the company profiles
	 */
	@Override
	public List<CompanyProfile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CompanyProfile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CompanyProfile> findAll(
		int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<CompanyProfile> findAll(
		int start, int end, OrderByComparator<CompanyProfile> orderByComparator,
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

		List<CompanyProfile> list = null;

		if (useFinderCache) {
			list = (List<CompanyProfile>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMPANYPROFILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMPANYPROFILE;

				sql = sql.concat(CompanyProfileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CompanyProfile>)QueryUtil.list(
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
	 * Removes all the company profiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CompanyProfile companyProfile : findAll()) {
			remove(companyProfile);
		}
	}

	/**
	 * Returns the number of company profiles.
	 *
	 * @return the number of company profiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMPANYPROFILE);

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
		return "companyProfileId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMPANYPROFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CompanyProfileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the company profile persistence.
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

		_finderPathWithPaginationFindByGroupIdAndActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndActive",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "active_"}, true);

		_finderPathWithoutPaginationFindByGroupIdAndActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupIdAndActive",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"groupId", "active_"}, true);

		_finderPathCountByGroupIdAndActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndActive",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"groupId", "active_"}, false);

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

		_setCompanyProfileUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCompanyProfileUtilPersistence(null);

		entityCache.removeCache(CompanyProfileImpl.class.getName());
	}

	private void _setCompanyProfileUtilPersistence(
		CompanyProfilePersistence companyProfilePersistence) {

		try {
			Field field = CompanyProfileUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, companyProfilePersistence);
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

	private static final String _SQL_SELECT_COMPANYPROFILE =
		"SELECT companyProfile FROM CompanyProfile companyProfile";

	private static final String _SQL_SELECT_COMPANYPROFILE_WHERE =
		"SELECT companyProfile FROM CompanyProfile companyProfile WHERE ";

	private static final String _SQL_COUNT_COMPANYPROFILE =
		"SELECT COUNT(companyProfile) FROM CompanyProfile companyProfile";

	private static final String _SQL_COUNT_COMPANYPROFILE_WHERE =
		"SELECT COUNT(companyProfile) FROM CompanyProfile companyProfile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "companyProfile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CompanyProfile exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CompanyProfile exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CompanyProfilePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private CompanyProfileModelArgumentsResolver
		_companyProfileModelArgumentsResolver;

}