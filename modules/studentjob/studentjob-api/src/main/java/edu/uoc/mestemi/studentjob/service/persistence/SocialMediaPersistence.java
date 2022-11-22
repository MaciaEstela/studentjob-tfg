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

import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException;
import edu.uoc.mestemi.studentjob.model.SocialMedia;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the social media service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaUtil
 * @generated
 */
@ProviderType
public interface SocialMediaPersistence extends BasePersistence<SocialMedia> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialMediaUtil} to access the social media persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the social medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social medias
	 */
	public java.util.List<SocialMedia> findByUuid(String uuid);

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
	public java.util.List<SocialMedia> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SocialMedia> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

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
	public java.util.List<SocialMedia> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public SocialMedia findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the first social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public SocialMedia fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

	/**
	 * Returns the last social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public SocialMedia findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the last social media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public SocialMedia fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

	/**
	 * Returns the social medias before and after the current social media in the ordered set where uuid = &#63;.
	 *
	 * @param socialMediaId the primary key of the current social media
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public SocialMedia[] findByUuid_PrevAndNext(
			long socialMediaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Removes all the social medias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of social medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social medias
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the social media where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSocialMediaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public SocialMedia findByUUID_G(String uuid, long groupId)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the social media where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public SocialMedia fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the social media where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public SocialMedia fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the social media where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social media that was removed
	 */
	public SocialMedia removeByUUID_G(String uuid, long groupId)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the number of social medias where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social medias
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social medias
	 */
	public java.util.List<SocialMedia> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<SocialMedia> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SocialMedia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

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
	public java.util.List<SocialMedia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public SocialMedia findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the first social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public SocialMedia fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

	/**
	 * Returns the last social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public SocialMedia findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the last social media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public SocialMedia fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

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
	public SocialMedia[] findByUuid_C_PrevAndNext(
			long socialMediaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Removes all the social medias where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of social medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social medias
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the social medias where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching social medias
	 */
	public java.util.List<SocialMedia> findByGroupId(long groupId);

	/**
	 * Returns a range of all the social medias where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of matching social medias
	 */
	public java.util.List<SocialMedia> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the social medias where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social medias
	 */
	public java.util.List<SocialMedia> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the social medias where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social medias
	 */
	public java.util.List<SocialMedia> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first social media in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public SocialMedia findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the first social media in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public SocialMedia fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

	/**
	 * Returns the last social media in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media
	 * @throws NoSuchSocialMediaException if a matching social media could not be found
	 */
	public SocialMedia findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the last social media in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public SocialMedia fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

	/**
	 * Returns the social medias before and after the current social media in the ordered set where groupId = &#63;.
	 *
	 * @param socialMediaId the primary key of the current social media
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public SocialMedia[] findByGroupId_PrevAndNext(
			long socialMediaId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Removes all the social medias where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of social medias where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching social medias
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching social medias
	 */
	public java.util.List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK);

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
	public java.util.List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK, int start, int end);

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
	public java.util.List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

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
	public java.util.List<SocialMedia> findByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator,
		boolean useFinderCache);

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
	public SocialMedia findByGroupIdAndClassNameAndClassPK_First(
			long groupId, String className, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the first social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public SocialMedia fetchByGroupIdAndClassNameAndClassPK_First(
		long groupId, String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

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
	public SocialMedia findByGroupIdAndClassNameAndClassPK_Last(
			long groupId, String className, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the last social media in the ordered set where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public SocialMedia fetchByGroupIdAndClassNameAndClassPK_Last(
		long groupId, String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

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
	public SocialMedia[] findByGroupIdAndClassNameAndClassPK_PrevAndNext(
			long socialMediaId, long groupId, String className, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
				orderByComparator)
		throws NoSuchSocialMediaException;

	/**
	 * Removes all the social medias where groupId = &#63; and className = &#63; and classPK = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 */
	public void removeByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK);

	/**
	 * Returns the number of social medias where groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching social medias
	 */
	public int countByGroupIdAndClassNameAndClassPK(
		long groupId, String className, long classPK);

	/**
	 * Caches the social media in the entity cache if it is enabled.
	 *
	 * @param socialMedia the social media
	 */
	public void cacheResult(SocialMedia socialMedia);

	/**
	 * Caches the social medias in the entity cache if it is enabled.
	 *
	 * @param socialMedias the social medias
	 */
	public void cacheResult(java.util.List<SocialMedia> socialMedias);

	/**
	 * Creates a new social media with the primary key. Does not add the social media to the database.
	 *
	 * @param socialMediaId the primary key for the new social media
	 * @return the new social media
	 */
	public SocialMedia create(long socialMediaId);

	/**
	 * Removes the social media with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media that was removed
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public SocialMedia remove(long socialMediaId)
		throws NoSuchSocialMediaException;

	public SocialMedia updateImpl(SocialMedia socialMedia);

	/**
	 * Returns the social media with the primary key or throws a <code>NoSuchSocialMediaException</code> if it could not be found.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media
	 * @throws NoSuchSocialMediaException if a social media with the primary key could not be found
	 */
	public SocialMedia findByPrimaryKey(long socialMediaId)
		throws NoSuchSocialMediaException;

	/**
	 * Returns the social media with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media, or <code>null</code> if a social media with the primary key could not be found
	 */
	public SocialMedia fetchByPrimaryKey(long socialMediaId);

	/**
	 * Returns all the social medias.
	 *
	 * @return the social medias
	 */
	public java.util.List<SocialMedia> findAll();

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
	public java.util.List<SocialMedia> findAll(int start, int end);

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
	public java.util.List<SocialMedia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator);

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
	public java.util.List<SocialMedia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialMedia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the social medias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of social medias.
	 *
	 * @return the number of social medias
	 */
	public int countAll();

}