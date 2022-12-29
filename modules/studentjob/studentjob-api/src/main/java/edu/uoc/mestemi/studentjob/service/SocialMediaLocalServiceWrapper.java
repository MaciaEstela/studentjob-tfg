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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SocialMediaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaLocalService
 * @generated
 */
public class SocialMediaLocalServiceWrapper
	implements ServiceWrapper<SocialMediaLocalService>,
			   SocialMediaLocalService {

	public SocialMediaLocalServiceWrapper() {
		this(null);
	}

	public SocialMediaLocalServiceWrapper(
		SocialMediaLocalService socialMediaLocalService) {

		_socialMediaLocalService = socialMediaLocalService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia addSocialMedia(
			long groupId, long socialMediaNetworkId, String socialURL,
			String className, long classPK,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaLocalService.addSocialMedia(
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
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia addSocialMedia(
		edu.uoc.mestemi.studentjob.model.SocialMedia socialMedia) {

		return _socialMediaLocalService.addSocialMedia(socialMedia);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new social media with the primary key. Does not add the social media to the database.
	 *
	 * @param socialMediaId the primary key for the new social media
	 * @return the new social media
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia createSocialMedia(
		long socialMediaId) {

		return _socialMediaLocalService.createSocialMedia(socialMediaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia deleteSocialMedia(
			long socialMediaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaLocalService.deleteSocialMedia(socialMediaId);
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
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia deleteSocialMedia(
		edu.uoc.mestemi.studentjob.model.SocialMedia socialMedia) {

		return _socialMediaLocalService.deleteSocialMedia(socialMedia);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _socialMediaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _socialMediaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _socialMediaLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _socialMediaLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _socialMediaLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _socialMediaLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _socialMediaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _socialMediaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia fetchSocialMedia(
		long socialMediaId) {

		return _socialMediaLocalService.fetchSocialMedia(socialMediaId);
	}

	/**
	 * Returns the social media matching the UUID and group.
	 *
	 * @param uuid the social media's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social media, or <code>null</code> if a matching social media could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia
		fetchSocialMediaByUuidAndGroupId(String uuid, long groupId) {

		return _socialMediaLocalService.fetchSocialMediaByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _socialMediaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _socialMediaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _socialMediaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _socialMediaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the social media with the primary key.
	 *
	 * @param socialMediaId the primary key of the social media
	 * @return the social media
	 * @throws PortalException if a social media with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia getSocialMedia(
			long socialMediaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaLocalService.getSocialMedia(socialMediaId);
	}

	/**
	 * Returns the social media matching the UUID and group.
	 *
	 * @param uuid the social media's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social media
	 * @throws PortalException if a matching social media could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia
			getSocialMediaByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaLocalService.getSocialMediaByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia
			getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				long groupId, String className, long classPK,
				long socialMediaNetworkId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		return _socialMediaLocalService.
			getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				groupId, className, classPK, socialMediaNetworkId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMediaNetworksByGroupId(long groupId) {

		return _socialMediaLocalService.getSocialMediaNetworksByGroupId(
			groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMediaNetworksByGroupId(long groupId, int start, int end) {

		return _socialMediaLocalService.getSocialMediaNetworksByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMediaNetworksByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.SocialMedia>
					orderByComparator) {

		return _socialMediaLocalService.getSocialMediaNetworksByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMediaNetworksByGroupIdAndClass(
			long groupId, String className, long classPK) {

		return _socialMediaLocalService.getSocialMediaNetworksByGroupIdAndClass(
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
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMedias(int start, int end) {

		return _socialMediaLocalService.getSocialMedias(start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMedias(long socialMediaNetworkId) {

		return _socialMediaLocalService.getSocialMedias(socialMediaNetworkId);
	}

	/**
	 * Returns all the social medias matching the UUID and company.
	 *
	 * @param uuid the UUID of the social medias
	 * @param companyId the primary key of the company
	 * @return the matching social medias, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMediasByUuidAndCompanyId(String uuid, long companyId) {

		return _socialMediaLocalService.getSocialMediasByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMediasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.SocialMedia>
					orderByComparator) {

		return _socialMediaLocalService.getSocialMediasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of social medias.
	 *
	 * @return the number of social medias
	 */
	@Override
	public int getSocialMediasCount() {
		return _socialMediaLocalService.getSocialMediasCount();
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia updateSocialMedia(
			long socialMediaId, String socialURL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaLocalService.updateSocialMedia(
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
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia updateSocialMedia(
		edu.uoc.mestemi.studentjob.model.SocialMedia socialMedia) {

		return _socialMediaLocalService.updateSocialMedia(socialMedia);
	}

	@Override
	public SocialMediaLocalService getWrappedService() {
		return _socialMediaLocalService;
	}

	@Override
	public void setWrappedService(
		SocialMediaLocalService socialMediaLocalService) {

		_socialMediaLocalService = socialMediaLocalService;
	}

	private SocialMediaLocalService _socialMediaLocalService;

}