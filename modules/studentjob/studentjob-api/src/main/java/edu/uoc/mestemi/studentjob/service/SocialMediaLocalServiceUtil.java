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

package edu.uoc.mestemi.studentjob.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.SocialMedia;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SocialMedia. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.SocialMediaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaLocalService
 * @generated
 */
public class SocialMediaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.SocialMediaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SocialMedia addSocialMedia(
			long groupId, long socialMediaNetworkId, String socialURL,
			String className, long classPK,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addSocialMedia(
			groupId, socialMediaNetworkId, socialURL, className, classPK,
			serviceContext);
	}

	/**
	 * Adds the social media to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialMediaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialMedia the social media
	 * @return the social media that was added
	 */
	public static SocialMedia addSocialMedia(SocialMedia socialMedia) {
		return getService().addSocialMedia(socialMedia);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new social media with the primary key. Does not add the social media to the database.
	 *
	 * @param socialMediaId the primary key for the new social media
	 * @return the new social media
	 */
	public static SocialMedia createSocialMedia(long socialMediaId) {
		return getService().createSocialMedia(socialMediaId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the social media with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialMediaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media that was removed
	 * @throws PortalException if a social media with the primary key could not be found
	 */
	public static SocialMedia deleteSocialMedia(long socialMediaId)
		throws PortalException {

		return getService().deleteSocialMedia(socialMediaId);
	}

	/**
	 * Deletes the social media from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialMediaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialMedia the social media
	 * @return the social media that was removed
	 */
	public static SocialMedia deleteSocialMedia(SocialMedia socialMedia) {
		return getService().deleteSocialMedia(socialMedia);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static SocialMedia fetchSocialMedia(long socialMediaId) {
		return getService().fetchSocialMedia(socialMediaId);
	}

	/**
	 * Returns the social media matching the UUID and group.
	 *
	 * @param uuid the social media's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social media, or <code>null</code> if a matching social media could not be found
	 */
	public static SocialMedia fetchSocialMediaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSocialMediaByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the social media with the primary key.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media
	 * @throws PortalException if a social media with the primary key could not be found
	 */
	public static SocialMedia getSocialMedia(long socialMediaId)
		throws PortalException {

		return getService().getSocialMedia(socialMediaId);
	}

	/**
	 * Returns the social media matching the UUID and group.
	 *
	 * @param uuid the social media's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social media
	 * @throws PortalException if a matching social media could not be found
	 */
	public static SocialMedia getSocialMediaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSocialMediaByUuidAndGroupId(uuid, groupId);
	}

	public static SocialMedia
			getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				long groupId, String className, long classPK,
				long socialMediaNetworkId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return getService().
			getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				groupId, className, classPK, socialMediaNetworkId);
	}

	public static List<SocialMedia> getSocialMediaNetworksByGroupId(
		long groupId) {

		return getService().getSocialMediaNetworksByGroupId(groupId);
	}

	public static List<SocialMedia> getSocialMediaNetworksByGroupId(
		long groupId, int start, int end) {

		return getService().getSocialMediaNetworksByGroupId(
			groupId, start, end);
	}

	public static List<SocialMedia> getSocialMediaNetworksByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getService().getSocialMediaNetworksByGroupId(
			groupId, start, end, orderByComparator);
	}

	public static List<SocialMedia> getSocialMediaNetworksByGroupIdAndClass(
		long groupId, String className, long classPK) {

		return getService().getSocialMediaNetworksByGroupIdAndClass(
			groupId, className, classPK);
	}

	/**
	 * Returns a range of all the social medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @return the range of social medias
	 */
	public static List<SocialMedia> getSocialMedias(int start, int end) {
		return getService().getSocialMedias(start, end);
	}

	/**
	 * Returns all the social medias matching the UUID and company.
	 *
	 * @param uuid the UUID of the social medias
	 * @param companyId the primary key of the company
	 * @return the matching social medias, or an empty list if no matches were found
	 */
	public static List<SocialMedia> getSocialMediasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSocialMediasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of social medias matching the UUID and company.
	 *
	 * @param uuid the UUID of the social medias
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of social medias
	 * @param end the upper bound of the range of social medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching social medias, or an empty list if no matches were found
	 */
	public static List<SocialMedia> getSocialMediasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialMedia> orderByComparator) {

		return getService().getSocialMediasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of social medias.
	 *
	 * @return the number of social medias
	 */
	public static int getSocialMediasCount() {
		return getService().getSocialMediasCount();
	}

	public static SocialMedia updateSocialMedia(
			long socialMediaId, String socialURL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateSocialMedia(
			socialMediaId, socialURL, serviceContext);
	}

	/**
	 * Updates the social media in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialMediaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialMedia the social media
	 * @return the social media that was updated
	 */
	public static SocialMedia updateSocialMedia(SocialMedia socialMedia) {
		return getService().updateSocialMedia(socialMedia);
	}

	public static SocialMediaLocalService getService() {
		return _service;
	}

	private static volatile SocialMediaLocalService _service;

}