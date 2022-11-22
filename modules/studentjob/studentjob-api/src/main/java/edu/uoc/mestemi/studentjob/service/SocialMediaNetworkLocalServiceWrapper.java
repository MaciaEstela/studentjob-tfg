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
 * Provides a wrapper for {@link SocialMediaNetworkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaNetworkLocalService
 * @generated
 */
public class SocialMediaNetworkLocalServiceWrapper
	implements ServiceWrapper<SocialMediaNetworkLocalService>,
			   SocialMediaNetworkLocalService {

	public SocialMediaNetworkLocalServiceWrapper() {
		this(null);
	}

	public SocialMediaNetworkLocalServiceWrapper(
		SocialMediaNetworkLocalService socialMediaNetworkLocalService) {

		_socialMediaNetworkLocalService = socialMediaNetworkLocalService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
			addSocialMediaNetwork(
				long groupId, String name, long logo, String baseURL,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkLocalService.addSocialMediaNetwork(
			groupId, name, logo, baseURL, serviceContext);
	}

	/**
	 * Adds the social media network to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialMediaNetworkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialMediaNetwork the social media network
	 * @return the social media network that was added
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
		addSocialMediaNetwork(
			edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
				socialMediaNetwork) {

		return _socialMediaNetworkLocalService.addSocialMediaNetwork(
			socialMediaNetwork);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new social media network with the primary key. Does not add the social media network to the database.
	 *
	 * @param socialMediaNetworkId the primary key for the new social media network
	 * @return the new social media network
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
		createSocialMediaNetwork(long socialMediaNetworkId) {

		return _socialMediaNetworkLocalService.createSocialMediaNetwork(
			socialMediaNetworkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the social media network with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialMediaNetworkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network that was removed
	 * @throws PortalException if a social media network with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
			deleteSocialMediaNetwork(long socialMediaNetworkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkLocalService.deleteSocialMediaNetwork(
			socialMediaNetworkId);
	}

	/**
	 * Deletes the social media network from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialMediaNetworkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialMediaNetwork the social media network
	 * @return the social media network that was removed
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
		deleteSocialMediaNetwork(
			edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
				socialMediaNetwork) {

		return _socialMediaNetworkLocalService.deleteSocialMediaNetwork(
			socialMediaNetwork);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _socialMediaNetworkLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _socialMediaNetworkLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _socialMediaNetworkLocalService.dynamicQuery();
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

		return _socialMediaNetworkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaNetworkModelImpl</code>.
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

		return _socialMediaNetworkLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaNetworkModelImpl</code>.
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

		return _socialMediaNetworkLocalService.dynamicQuery(
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

		return _socialMediaNetworkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _socialMediaNetworkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
		fetchSocialMediaNetwork(long socialMediaNetworkId) {

		return _socialMediaNetworkLocalService.fetchSocialMediaNetwork(
			socialMediaNetworkId);
	}

	/**
	 * Returns the social media network matching the UUID and group.
	 *
	 * @param uuid the social media network's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
		fetchSocialMediaNetworkByUuidAndGroupId(String uuid, long groupId) {

		return _socialMediaNetworkLocalService.
			fetchSocialMediaNetworkByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _socialMediaNetworkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _socialMediaNetworkLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _socialMediaNetworkLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _socialMediaNetworkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the social media network with the primary key.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network
	 * @throws PortalException if a social media network with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
			getSocialMediaNetwork(long socialMediaNetworkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkLocalService.getSocialMediaNetwork(
			socialMediaNetworkId);
	}

	/**
	 * Returns the social media network matching the UUID and group.
	 *
	 * @param uuid the social media network's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social media network
	 * @throws PortalException if a matching social media network could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
			getSocialMediaNetworkByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkLocalService.
			getSocialMediaNetworkByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the social media networks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaNetworkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @return the range of social media networks
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
		getSocialMediaNetworks(int start, int end) {

		return _socialMediaNetworkLocalService.getSocialMediaNetworks(
			start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
		getSocialMediaNetworksByGroupId(long groupId) {

		return _socialMediaNetworkLocalService.getSocialMediaNetworksByGroupId(
			groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
		getSocialMediaNetworksByGroupId(long groupId, int start, int end) {

		return _socialMediaNetworkLocalService.getSocialMediaNetworksByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
		getSocialMediaNetworksByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
					orderByComparator) {

		return _socialMediaNetworkLocalService.getSocialMediaNetworksByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns all the social media networks matching the UUID and company.
	 *
	 * @param uuid the UUID of the social media networks
	 * @param companyId the primary key of the company
	 * @return the matching social media networks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
		getSocialMediaNetworksByUuidAndCompanyId(String uuid, long companyId) {

		return _socialMediaNetworkLocalService.
			getSocialMediaNetworksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of social media networks matching the UUID and company.
	 *
	 * @param uuid the UUID of the social media networks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of social media networks
	 * @param end the upper bound of the range of social media networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching social media networks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
		getSocialMediaNetworksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
					orderByComparator) {

		return _socialMediaNetworkLocalService.
			getSocialMediaNetworksByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of social media networks.
	 *
	 * @return the number of social media networks
	 */
	@Override
	public int getSocialMediaNetworksCount() {
		return _socialMediaNetworkLocalService.getSocialMediaNetworksCount();
	}

	@Override
	public long getSocialMediaNetworksCountByKeywords(
		long groupId, String keywords) {

		return _socialMediaNetworkLocalService.
			getSocialMediaNetworksCountByKeywords(groupId, keywords);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
			updateSocialMediaNetwork(
				long socialMediaNetworkId, String name, long logo,
				String baseURL,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkLocalService.updateSocialMediaNetwork(
			socialMediaNetworkId, name, logo, baseURL, serviceContext);
	}

	/**
	 * Updates the social media network in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialMediaNetworkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialMediaNetwork the social media network
	 * @return the social media network that was updated
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
		updateSocialMediaNetwork(
			edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
				socialMediaNetwork) {

		return _socialMediaNetworkLocalService.updateSocialMediaNetwork(
			socialMediaNetwork);
	}

	@Override
	public SocialMediaNetworkLocalService getWrappedService() {
		return _socialMediaNetworkLocalService;
	}

	@Override
	public void setWrappedService(
		SocialMediaNetworkLocalService socialMediaNetworkLocalService) {

		_socialMediaNetworkLocalService = socialMediaNetworkLocalService;
	}

	private SocialMediaNetworkLocalService _socialMediaNetworkLocalService;

}