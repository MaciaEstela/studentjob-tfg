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

import edu.uoc.mestemi.studentjob.exception.NoSuchStudentProfileException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.model.StudentProfileTable;
import edu.uoc.mestemi.studentjob.model.impl.StudentProfileImpl;
import edu.uoc.mestemi.studentjob.model.impl.StudentProfileModelImpl;
import edu.uoc.mestemi.studentjob.service.persistence.StudentProfilePersistence;
import edu.uoc.mestemi.studentjob.service.persistence.StudentProfileUtil;
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
 * The persistence implementation for the student profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {StudentProfilePersistence.class, BasePersistence.class})
public class StudentProfilePersistenceImpl
	extends BasePersistenceImpl<StudentProfile>
	implements StudentProfilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StudentProfileUtil</code> to access the student profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StudentProfileImpl.class.getName();

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
	 * Returns all the student profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching student profiles
	 */
	@Override
	public List<StudentProfile> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator,
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

		List<StudentProfile> list = null;

		if (useFinderCache) {
			list = (List<StudentProfile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (StudentProfile studentProfile : list) {
					if (!uuid.equals(studentProfile.getUuid())) {
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

			sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

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
				sb.append(StudentProfileModelImpl.ORDER_BY_JPQL);
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

				list = (List<StudentProfile>)QueryUtil.list(
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
	 * Returns the first student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByUuid_First(
			String uuid, OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByUuid_First(
			uuid, orderByComparator);

		if (studentProfile != null) {
			return studentProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStudentProfileException(sb.toString());
	}

	/**
	 * Returns the first student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByUuid_First(
		String uuid, OrderByComparator<StudentProfile> orderByComparator) {

		List<StudentProfile> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByUuid_Last(
			String uuid, OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByUuid_Last(
			uuid, orderByComparator);

		if (studentProfile != null) {
			return studentProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStudentProfileException(sb.toString());
	}

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByUuid_Last(
		String uuid, OrderByComparator<StudentProfile> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<StudentProfile> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where uuid = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	@Override
	public StudentProfile[] findByUuid_PrevAndNext(
			long studentProfileId, String uuid,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		uuid = Objects.toString(uuid, "");

		StudentProfile studentProfile = findByPrimaryKey(studentProfileId);

		Session session = null;

		try {
			session = openSession();

			StudentProfile[] array = new StudentProfileImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, studentProfile, uuid, orderByComparator, true);

			array[1] = studentProfile;

			array[2] = getByUuid_PrevAndNext(
				session, studentProfile, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StudentProfile getByUuid_PrevAndNext(
		Session session, StudentProfile studentProfile, String uuid,
		OrderByComparator<StudentProfile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

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
			sb.append(StudentProfileModelImpl.ORDER_BY_JPQL);
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
						studentProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StudentProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (StudentProfile studentProfile :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(studentProfile);
		}
	}

	/**
	 * Returns the number of student profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching student profiles
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STUDENTPROFILE_WHERE);

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
		"studentProfile.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(studentProfile.uuid IS NULL OR studentProfile.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the student profile where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStudentProfileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByUUID_G(String uuid, long groupId)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByUUID_G(uuid, groupId);

		if (studentProfile == null) {
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

			throw new NoSuchStudentProfileException(sb.toString());
		}

		return studentProfile;
	}

	/**
	 * Returns the student profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the student profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByUUID_G(
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

		if (result instanceof StudentProfile) {
			StudentProfile studentProfile = (StudentProfile)result;

			if (!Objects.equals(uuid, studentProfile.getUuid()) ||
				(groupId != studentProfile.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

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

				List<StudentProfile> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					StudentProfile studentProfile = list.get(0);

					result = studentProfile;

					cacheResult(studentProfile);
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
			return (StudentProfile)result;
		}
	}

	/**
	 * Removes the student profile where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the student profile that was removed
	 */
	@Override
	public StudentProfile removeByUUID_G(String uuid, long groupId)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = findByUUID_G(uuid, groupId);

		return remove(studentProfile);
	}

	/**
	 * Returns the number of student profiles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching student profiles
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STUDENTPROFILE_WHERE);

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
		"studentProfile.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(studentProfile.uuid IS NULL OR studentProfile.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"studentProfile.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching student profiles
	 */
	@Override
	public List<StudentProfile> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator,
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

		List<StudentProfile> list = null;

		if (useFinderCache) {
			list = (List<StudentProfile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (StudentProfile studentProfile : list) {
					if (!uuid.equals(studentProfile.getUuid()) ||
						(companyId != studentProfile.getCompanyId())) {

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

			sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

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
				sb.append(StudentProfileModelImpl.ORDER_BY_JPQL);
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

				list = (List<StudentProfile>)QueryUtil.list(
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
	 * Returns the first student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (studentProfile != null) {
			return studentProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchStudentProfileException(sb.toString());
	}

	/**
	 * Returns the first student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<StudentProfile> orderByComparator) {

		List<StudentProfile> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (studentProfile != null) {
			return studentProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchStudentProfileException(sb.toString());
	}

	/**
	 * Returns the last student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<StudentProfile> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<StudentProfile> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	@Override
	public StudentProfile[] findByUuid_C_PrevAndNext(
			long studentProfileId, String uuid, long companyId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		uuid = Objects.toString(uuid, "");

		StudentProfile studentProfile = findByPrimaryKey(studentProfileId);

		Session session = null;

		try {
			session = openSession();

			StudentProfile[] array = new StudentProfileImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, studentProfile, uuid, companyId, orderByComparator,
				true);

			array[1] = studentProfile;

			array[2] = getByUuid_C_PrevAndNext(
				session, studentProfile, uuid, companyId, orderByComparator,
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

	protected StudentProfile getByUuid_C_PrevAndNext(
		Session session, StudentProfile studentProfile, String uuid,
		long companyId, OrderByComparator<StudentProfile> orderByComparator,
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

		sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

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
			sb.append(StudentProfileModelImpl.ORDER_BY_JPQL);
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
						studentProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StudentProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (StudentProfile studentProfile :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(studentProfile);
		}
	}

	/**
	 * Returns the number of student profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching student profiles
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STUDENTPROFILE_WHERE);

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
		"studentProfile.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(studentProfile.uuid IS NULL OR studentProfile.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"studentProfile.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the student profiles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator,
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

		List<StudentProfile> list = null;

		if (useFinderCache) {
			list = (List<StudentProfile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (StudentProfile studentProfile : list) {
					if (groupId != studentProfile.getGroupId()) {
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

			sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StudentProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<StudentProfile>)QueryUtil.list(
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
	 * Returns the first student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByGroupId_First(
			long groupId, OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByGroupId_First(
			groupId, orderByComparator);

		if (studentProfile != null) {
			return studentProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchStudentProfileException(sb.toString());
	}

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByGroupId_First(
		long groupId, OrderByComparator<StudentProfile> orderByComparator) {

		List<StudentProfile> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByGroupId_Last(
			long groupId, OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (studentProfile != null) {
			return studentProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchStudentProfileException(sb.toString());
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByGroupId_Last(
		long groupId, OrderByComparator<StudentProfile> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<StudentProfile> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where groupId = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	@Override
	public StudentProfile[] findByGroupId_PrevAndNext(
			long studentProfileId, long groupId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = findByPrimaryKey(studentProfileId);

		Session session = null;

		try {
			session = openSession();

			StudentProfile[] array = new StudentProfileImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, studentProfile, groupId, orderByComparator, true);

			array[1] = studentProfile;

			array[2] = getByGroupId_PrevAndNext(
				session, studentProfile, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StudentProfile getByGroupId_PrevAndNext(
		Session session, StudentProfile studentProfile, long groupId,
		OrderByComparator<StudentProfile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

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
			sb.append(StudentProfileModelImpl.ORDER_BY_JPQL);
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
						studentProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StudentProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student profiles where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (StudentProfile studentProfile :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(studentProfile);
		}
	}

	/**
	 * Returns the number of student profiles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching student profiles
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STUDENTPROFILE_WHERE);

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
		"studentProfile.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdAndActive;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdAndActive;
	private FinderPath _finderPathCountByGroupIdAndActive;

	/**
	 * Returns all the student profiles where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @return the matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupIdAndActive(
		long groupId, boolean active) {

		return findByGroupIdAndActive(
			groupId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student profiles where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupIdAndActive(
		long groupId, boolean active, int start, int end) {

		return findByGroupIdAndActive(groupId, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupIdAndActive(
		long groupId, boolean active, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return findByGroupIdAndActive(
			groupId, active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupIdAndActive(
		long groupId, boolean active, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator,
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

		List<StudentProfile> list = null;

		if (useFinderCache) {
			list = (List<StudentProfile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (StudentProfile studentProfile : list) {
					if ((groupId != studentProfile.getGroupId()) ||
						(active != studentProfile.isActive())) {

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

			sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDACTIVE_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StudentProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(active);

				list = (List<StudentProfile>)QueryUtil.list(
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
	 * Returns the first student profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByGroupIdAndActive_First(
			long groupId, boolean active,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByGroupIdAndActive_First(
			groupId, active, orderByComparator);

		if (studentProfile != null) {
			return studentProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchStudentProfileException(sb.toString());
	}

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByGroupIdAndActive_First(
		long groupId, boolean active,
		OrderByComparator<StudentProfile> orderByComparator) {

		List<StudentProfile> list = findByGroupIdAndActive(
			groupId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByGroupIdAndActive_Last(
			long groupId, boolean active,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByGroupIdAndActive_Last(
			groupId, active, orderByComparator);

		if (studentProfile != null) {
			return studentProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchStudentProfileException(sb.toString());
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByGroupIdAndActive_Last(
		long groupId, boolean active,
		OrderByComparator<StudentProfile> orderByComparator) {

		int count = countByGroupIdAndActive(groupId, active);

		if (count == 0) {
			return null;
		}

		List<StudentProfile> list = findByGroupIdAndActive(
			groupId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	@Override
	public StudentProfile[] findByGroupIdAndActive_PrevAndNext(
			long studentProfileId, long groupId, boolean active,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = findByPrimaryKey(studentProfileId);

		Session session = null;

		try {
			session = openSession();

			StudentProfile[] array = new StudentProfileImpl[3];

			array[0] = getByGroupIdAndActive_PrevAndNext(
				session, studentProfile, groupId, active, orderByComparator,
				true);

			array[1] = studentProfile;

			array[2] = getByGroupIdAndActive_PrevAndNext(
				session, studentProfile, groupId, active, orderByComparator,
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

	protected StudentProfile getByGroupIdAndActive_PrevAndNext(
		Session session, StudentProfile studentProfile, long groupId,
		boolean active, OrderByComparator<StudentProfile> orderByComparator,
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

		sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

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
			sb.append(StudentProfileModelImpl.ORDER_BY_JPQL);
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
						studentProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StudentProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student profiles where groupId = &#63; and active = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 */
	@Override
	public void removeByGroupIdAndActive(long groupId, boolean active) {
		for (StudentProfile studentProfile :
				findByGroupIdAndActive(
					groupId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(studentProfile);
		}
	}

	/**
	 * Returns the number of student profiles where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @return the number of matching student profiles
	 */
	@Override
	public int countByGroupIdAndActive(long groupId, boolean active) {
		FinderPath finderPath = _finderPathCountByGroupIdAndActive;

		Object[] finderArgs = new Object[] {groupId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STUDENTPROFILE_WHERE);

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
		"studentProfile.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDANDACTIVE_ACTIVE_2 =
		"studentProfile.active = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdAndUserId;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdAndUserId;
	private FinderPath _finderPathCountByGroupIdAndUserId;

	/**
	 * Returns all the student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId) {

		return findByGroupIdAndUserId(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end) {

		return findByGroupIdAndUserId(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return findByGroupIdAndUserId(
			groupId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student profiles
	 */
	@Override
	public List<StudentProfile> findByGroupIdAndUserId(
		long groupId, long userId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator,
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

		List<StudentProfile> list = null;

		if (useFinderCache) {
			list = (List<StudentProfile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (StudentProfile studentProfile : list) {
					if ((groupId != studentProfile.getGroupId()) ||
						(userId != studentProfile.getUserId())) {

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

			sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StudentProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<StudentProfile>)QueryUtil.list(
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
	 * Returns the first student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByGroupIdAndUserId_First(
			long groupId, long userId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByGroupIdAndUserId_First(
			groupId, userId, orderByComparator);

		if (studentProfile != null) {
			return studentProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchStudentProfileException(sb.toString());
	}

	/**
	 * Returns the first student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByGroupIdAndUserId_First(
		long groupId, long userId,
		OrderByComparator<StudentProfile> orderByComparator) {

		List<StudentProfile> list = findByGroupIdAndUserId(
			groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile
	 * @throws NoSuchStudentProfileException if a matching student profile could not be found
	 */
	@Override
	public StudentProfile findByGroupIdAndUserId_Last(
			long groupId, long userId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByGroupIdAndUserId_Last(
			groupId, userId, orderByComparator);

		if (studentProfile != null) {
			return studentProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchStudentProfileException(sb.toString());
	}

	/**
	 * Returns the last student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Override
	public StudentProfile fetchByGroupIdAndUserId_Last(
		long groupId, long userId,
		OrderByComparator<StudentProfile> orderByComparator) {

		int count = countByGroupIdAndUserId(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<StudentProfile> list = findByGroupIdAndUserId(
			groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student profiles before and after the current student profile in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param studentProfileId the primary key of the current student profile
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	@Override
	public StudentProfile[] findByGroupIdAndUserId_PrevAndNext(
			long studentProfileId, long groupId, long userId,
			OrderByComparator<StudentProfile> orderByComparator)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = findByPrimaryKey(studentProfileId);

		Session session = null;

		try {
			session = openSession();

			StudentProfile[] array = new StudentProfileImpl[3];

			array[0] = getByGroupIdAndUserId_PrevAndNext(
				session, studentProfile, groupId, userId, orderByComparator,
				true);

			array[1] = studentProfile;

			array[2] = getByGroupIdAndUserId_PrevAndNext(
				session, studentProfile, groupId, userId, orderByComparator,
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

	protected StudentProfile getByGroupIdAndUserId_PrevAndNext(
		Session session, StudentProfile studentProfile, long groupId,
		long userId, OrderByComparator<StudentProfile> orderByComparator,
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

		sb.append(_SQL_SELECT_STUDENTPROFILE_WHERE);

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
			sb.append(StudentProfileModelImpl.ORDER_BY_JPQL);
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
						studentProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StudentProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student profiles where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByGroupIdAndUserId(long groupId, long userId) {
		for (StudentProfile studentProfile :
				findByGroupIdAndUserId(
					groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(studentProfile);
		}
	}

	/**
	 * Returns the number of student profiles where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching student profiles
	 */
	@Override
	public int countByGroupIdAndUserId(long groupId, long userId) {
		FinderPath finderPath = _finderPathCountByGroupIdAndUserId;

		Object[] finderArgs = new Object[] {groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STUDENTPROFILE_WHERE);

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
		"studentProfile.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDANDUSERID_USERID_2 =
		"studentProfile.userId = ?";

	public StudentProfilePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(StudentProfile.class);

		setModelImplClass(StudentProfileImpl.class);
		setModelPKClass(long.class);

		setTable(StudentProfileTable.INSTANCE);
	}

	/**
	 * Caches the student profile in the entity cache if it is enabled.
	 *
	 * @param studentProfile the student profile
	 */
	@Override
	public void cacheResult(StudentProfile studentProfile) {
		entityCache.putResult(
			StudentProfileImpl.class, studentProfile.getPrimaryKey(),
			studentProfile);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				studentProfile.getUuid(), studentProfile.getGroupId()
			},
			studentProfile);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the student profiles in the entity cache if it is enabled.
	 *
	 * @param studentProfiles the student profiles
	 */
	@Override
	public void cacheResult(List<StudentProfile> studentProfiles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (studentProfiles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (StudentProfile studentProfile : studentProfiles) {
			if (entityCache.getResult(
					StudentProfileImpl.class, studentProfile.getPrimaryKey()) ==
						null) {

				cacheResult(studentProfile);
			}
		}
	}

	/**
	 * Clears the cache for all student profiles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StudentProfileImpl.class);

		finderCache.clearCache(StudentProfileImpl.class);
	}

	/**
	 * Clears the cache for the student profile.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StudentProfile studentProfile) {
		entityCache.removeResult(StudentProfileImpl.class, studentProfile);
	}

	@Override
	public void clearCache(List<StudentProfile> studentProfiles) {
		for (StudentProfile studentProfile : studentProfiles) {
			entityCache.removeResult(StudentProfileImpl.class, studentProfile);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(StudentProfileImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StudentProfileImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		StudentProfileModelImpl studentProfileModelImpl) {

		Object[] args = new Object[] {
			studentProfileModelImpl.getUuid(),
			studentProfileModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, studentProfileModelImpl);
	}

	/**
	 * Creates a new student profile with the primary key. Does not add the student profile to the database.
	 *
	 * @param studentProfileId the primary key for the new student profile
	 * @return the new student profile
	 */
	@Override
	public StudentProfile create(long studentProfileId) {
		StudentProfile studentProfile = new StudentProfileImpl();

		studentProfile.setNew(true);
		studentProfile.setPrimaryKey(studentProfileId);

		String uuid = _portalUUID.generate();

		studentProfile.setUuid(uuid);

		studentProfile.setCompanyId(CompanyThreadLocal.getCompanyId());

		return studentProfile;
	}

	/**
	 * Removes the student profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile that was removed
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	@Override
	public StudentProfile remove(long studentProfileId)
		throws NoSuchStudentProfileException {

		return remove((Serializable)studentProfileId);
	}

	/**
	 * Removes the student profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student profile
	 * @return the student profile that was removed
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	@Override
	public StudentProfile remove(Serializable primaryKey)
		throws NoSuchStudentProfileException {

		Session session = null;

		try {
			session = openSession();

			StudentProfile studentProfile = (StudentProfile)session.get(
				StudentProfileImpl.class, primaryKey);

			if (studentProfile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentProfileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(studentProfile);
		}
		catch (NoSuchStudentProfileException noSuchEntityException) {
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
	protected StudentProfile removeImpl(StudentProfile studentProfile) {
		studentProfileToDegreeTableMapper.deleteLeftPrimaryKeyTableMappings(
			studentProfile.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(studentProfile)) {
				studentProfile = (StudentProfile)session.get(
					StudentProfileImpl.class,
					studentProfile.getPrimaryKeyObj());
			}

			if (studentProfile != null) {
				session.delete(studentProfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (studentProfile != null) {
			clearCache(studentProfile);
		}

		return studentProfile;
	}

	@Override
	public StudentProfile updateImpl(StudentProfile studentProfile) {
		boolean isNew = studentProfile.isNew();

		if (!(studentProfile instanceof StudentProfileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(studentProfile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					studentProfile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in studentProfile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StudentProfile implementation " +
					studentProfile.getClass());
		}

		StudentProfileModelImpl studentProfileModelImpl =
			(StudentProfileModelImpl)studentProfile;

		if (Validator.isNull(studentProfile.getUuid())) {
			String uuid = _portalUUID.generate();

			studentProfile.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (studentProfile.getCreateDate() == null)) {
			if (serviceContext == null) {
				studentProfile.setCreateDate(date);
			}
			else {
				studentProfile.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!studentProfileModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				studentProfile.setModifiedDate(date);
			}
			else {
				studentProfile.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(studentProfile);
			}
			else {
				studentProfile = (StudentProfile)session.merge(studentProfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			StudentProfileImpl.class, studentProfileModelImpl, false, true);

		cacheUniqueFindersCache(studentProfileModelImpl);

		if (isNew) {
			studentProfile.setNew(false);
		}

		studentProfile.resetOriginalValues();

		return studentProfile;
	}

	/**
	 * Returns the student profile with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student profile
	 * @return the student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	@Override
	public StudentProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentProfileException {

		StudentProfile studentProfile = fetchByPrimaryKey(primaryKey);

		if (studentProfile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentProfileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return studentProfile;
	}

	/**
	 * Returns the student profile with the primary key or throws a <code>NoSuchStudentProfileException</code> if it could not be found.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile
	 * @throws NoSuchStudentProfileException if a student profile with the primary key could not be found
	 */
	@Override
	public StudentProfile findByPrimaryKey(long studentProfileId)
		throws NoSuchStudentProfileException {

		return findByPrimaryKey((Serializable)studentProfileId);
	}

	/**
	 * Returns the student profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile, or <code>null</code> if a student profile with the primary key could not be found
	 */
	@Override
	public StudentProfile fetchByPrimaryKey(long studentProfileId) {
		return fetchByPrimaryKey((Serializable)studentProfileId);
	}

	/**
	 * Returns all the student profiles.
	 *
	 * @return the student profiles
	 */
	@Override
	public List<StudentProfile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of student profiles
	 */
	@Override
	public List<StudentProfile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the student profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student profiles
	 */
	@Override
	public List<StudentProfile> findAll(
		int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of student profiles
	 */
	@Override
	public List<StudentProfile> findAll(
		int start, int end, OrderByComparator<StudentProfile> orderByComparator,
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

		List<StudentProfile> list = null;

		if (useFinderCache) {
			list = (List<StudentProfile>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STUDENTPROFILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENTPROFILE;

				sql = sql.concat(StudentProfileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StudentProfile>)QueryUtil.list(
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
	 * Removes all the student profiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StudentProfile studentProfile : findAll()) {
			remove(studentProfile);
		}
	}

	/**
	 * Returns the number of student profiles.
	 *
	 * @return the number of student profiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STUDENTPROFILE);

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
	 * Returns the primaryKeys of degrees associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @return long[] of the primaryKeys of degrees associated with the student profile
	 */
	@Override
	public long[] getDegreePrimaryKeys(long pk) {
		long[] pks = studentProfileToDegreeTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the student profile associated with the degree.
	 *
	 * @param pk the primary key of the degree
	 * @return the student profiles associated with the degree
	 */
	@Override
	public List<StudentProfile> getDegreeStudentProfiles(long pk) {
		return getDegreeStudentProfiles(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the student profile associated with the degree.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the degree
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of student profiles associated with the degree
	 */
	@Override
	public List<StudentProfile> getDegreeStudentProfiles(
		long pk, int start, int end) {

		return getDegreeStudentProfiles(pk, start, end, null);
	}

	/**
	 * Returns all the student profile associated with the degree.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the degree
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student profiles associated with the degree
	 */
	@Override
	public List<StudentProfile> getDegreeStudentProfiles(
		long pk, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator) {

		return studentProfileToDegreeTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of degrees associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @return the number of degrees associated with the student profile
	 */
	@Override
	public int getDegreesSize(long pk) {
		long[] pks = studentProfileToDegreeTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the degree is associated with the student profile.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePK the primary key of the degree
	 * @return <code>true</code> if the degree is associated with the student profile; <code>false</code> otherwise
	 */
	@Override
	public boolean containsDegree(long pk, long degreePK) {
		return studentProfileToDegreeTableMapper.containsTableMapping(
			pk, degreePK);
	}

	/**
	 * Returns <code>true</code> if the student profile has any degrees associated with it.
	 *
	 * @param pk the primary key of the student profile to check for associations with degrees
	 * @return <code>true</code> if the student profile has any degrees associated with it; <code>false</code> otherwise
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
	 * Adds an association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePK the primary key of the degree
	 */
	@Override
	public void addDegree(long pk, long degreePK) {
		StudentProfile studentProfile = fetchByPrimaryKey(pk);

		if (studentProfile == null) {
			studentProfileToDegreeTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, degreePK);
		}
		else {
			studentProfileToDegreeTableMapper.addTableMapping(
				studentProfile.getCompanyId(), pk, degreePK);
		}
	}

	/**
	 * Adds an association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degree the degree
	 */
	@Override
	public void addDegree(long pk, Degree degree) {
		StudentProfile studentProfile = fetchByPrimaryKey(pk);

		if (studentProfile == null) {
			studentProfileToDegreeTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, degree.getPrimaryKey());
		}
		else {
			studentProfileToDegreeTableMapper.addTableMapping(
				studentProfile.getCompanyId(), pk, degree.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePKs the primary keys of the degrees
	 */
	@Override
	public void addDegrees(long pk, long[] degreePKs) {
		long companyId = 0;

		StudentProfile studentProfile = fetchByPrimaryKey(pk);

		if (studentProfile == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = studentProfile.getCompanyId();
		}

		studentProfileToDegreeTableMapper.addTableMappings(
			companyId, pk, degreePKs);
	}

	/**
	 * Adds an association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degrees the degrees
	 */
	@Override
	public void addDegrees(long pk, List<Degree> degrees) {
		addDegrees(
			pk, ListUtil.toLongArray(degrees, Degree.DEGREE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the student profile and its degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile to clear the associated degrees from
	 */
	@Override
	public void clearDegrees(long pk) {
		studentProfileToDegreeTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePK the primary key of the degree
	 */
	@Override
	public void removeDegree(long pk, long degreePK) {
		studentProfileToDegreeTableMapper.deleteTableMapping(pk, degreePK);
	}

	/**
	 * Removes the association between the student profile and the degree. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degree the degree
	 */
	@Override
	public void removeDegree(long pk, Degree degree) {
		studentProfileToDegreeTableMapper.deleteTableMapping(
			pk, degree.getPrimaryKey());
	}

	/**
	 * Removes the association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePKs the primary keys of the degrees
	 */
	@Override
	public void removeDegrees(long pk, long[] degreePKs) {
		studentProfileToDegreeTableMapper.deleteTableMappings(pk, degreePKs);
	}

	/**
	 * Removes the association between the student profile and the degrees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degrees the degrees
	 */
	@Override
	public void removeDegrees(long pk, List<Degree> degrees) {
		removeDegrees(
			pk, ListUtil.toLongArray(degrees, Degree.DEGREE_ID_ACCESSOR));
	}

	/**
	 * Sets the degrees associated with the student profile, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degreePKs the primary keys of the degrees to be associated with the student profile
	 */
	@Override
	public void setDegrees(long pk, long[] degreePKs) {
		Set<Long> newDegreePKsSet = SetUtil.fromArray(degreePKs);
		Set<Long> oldDegreePKsSet = SetUtil.fromArray(
			studentProfileToDegreeTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeDegreePKsSet = new HashSet<Long>(oldDegreePKsSet);

		removeDegreePKsSet.removeAll(newDegreePKsSet);

		studentProfileToDegreeTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeDegreePKsSet));

		newDegreePKsSet.removeAll(oldDegreePKsSet);

		long companyId = 0;

		StudentProfile studentProfile = fetchByPrimaryKey(pk);

		if (studentProfile == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = studentProfile.getCompanyId();
		}

		studentProfileToDegreeTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newDegreePKsSet));
	}

	/**
	 * Sets the degrees associated with the student profile, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student profile
	 * @param degrees the degrees to be associated with the student profile
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
		return "studentProfileId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STUDENTPROFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StudentProfileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the student profile persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		studentProfileToDegreeTableMapper = TableMapperFactory.getTableMapper(
			"SJob_Students_Degrees#studentProfileId", "SJob_Students_Degrees",
			"companyId", "studentProfileId", "degreeId", this, Degree.class);

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

		_setStudentProfileUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStudentProfileUtilPersistence(null);

		entityCache.removeCache(StudentProfileImpl.class.getName());

		TableMapperFactory.removeTableMapper(
			"SJob_Students_Degrees#studentProfileId");
	}

	private void _setStudentProfileUtilPersistence(
		StudentProfilePersistence studentProfilePersistence) {

		try {
			Field field = StudentProfileUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, studentProfilePersistence);
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

	protected TableMapper<StudentProfile, Degree>
		studentProfileToDegreeTableMapper;

	private static final String _SQL_SELECT_STUDENTPROFILE =
		"SELECT studentProfile FROM StudentProfile studentProfile";

	private static final String _SQL_SELECT_STUDENTPROFILE_WHERE =
		"SELECT studentProfile FROM StudentProfile studentProfile WHERE ";

	private static final String _SQL_COUNT_STUDENTPROFILE =
		"SELECT COUNT(studentProfile) FROM StudentProfile studentProfile";

	private static final String _SQL_COUNT_STUDENTPROFILE_WHERE =
		"SELECT COUNT(studentProfile) FROM StudentProfile studentProfile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "studentProfile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StudentProfile exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StudentProfile exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StudentProfilePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private StudentProfileModelArgumentsResolver
		_studentProfileModelArgumentsResolver;

}