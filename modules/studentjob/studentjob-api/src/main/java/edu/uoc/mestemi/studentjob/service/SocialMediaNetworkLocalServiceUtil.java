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

import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SocialMediaNetwork. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.SocialMediaNetworkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaNetworkLocalService
 * @generated
 */
public class SocialMediaNetworkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.SocialMediaNetworkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SocialMediaNetwork addSocialMediaNetwork(
			long groupId, String name, long logo, String baseURL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addSocialMediaNetwork(
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
	public static SocialMediaNetwork addSocialMediaNetwork(
		SocialMediaNetwork socialMediaNetwork) {

		return getService().addSocialMediaNetwork(socialMediaNetwork);
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
	 * Creates a new social media network with the primary key. Does not add the social media network to the database.
	 *
	 * @param socialMediaNetworkId the primary key for the new social media network
	 * @return the new social media network
	 */
	public static SocialMediaNetwork createSocialMediaNetwork(
		long socialMediaNetworkId) {

		return getService().createSocialMediaNetwork(socialMediaNetworkId);
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
	public static SocialMediaNetwork deleteSocialMediaNetwork(
			long socialMediaNetworkId)
		throws PortalException {

		return getService().deleteSocialMediaNetwork(socialMediaNetworkId);
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
	public static SocialMediaNetwork deleteSocialMediaNetwork(
		SocialMediaNetwork socialMediaNetwork) {

		return getService().deleteSocialMediaNetwork(socialMediaNetwork);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaNetworkModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaNetworkModelImpl</code>.
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

	public static SocialMediaNetwork fetchSocialMediaNetwork(
		long socialMediaNetworkId) {

		return getService().fetchSocialMediaNetwork(socialMediaNetworkId);
	}

	/**
	 * Returns the social media network matching the UUID and group.
	 *
	 * @param uuid the social media network's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social media network, or <code>null</code> if a matching social media network could not be found
	 */
	public static SocialMediaNetwork fetchSocialMediaNetworkByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSocialMediaNetworkByUuidAndGroupId(
			uuid, groupId);
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
	 * Returns the social media network with the primary key.
	 *
	 * @param socialMediaNetworkId the primary key of the social media network
	 * @return the social media network
	 * @throws PortalException if a social media network with the primary key could not be found
	 */
	public static SocialMediaNetwork getSocialMediaNetwork(
			long socialMediaNetworkId)
		throws PortalException {

		return getService().getSocialMediaNetwork(socialMediaNetworkId);
	}

	/**
	 * Returns the social media network matching the UUID and group.
	 *
	 * @param uuid the social media network's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social media network
	 * @throws PortalException if a matching social media network could not be found
	 */
	public static SocialMediaNetwork getSocialMediaNetworkByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSocialMediaNetworkByUuidAndGroupId(
			uuid, groupId);
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
	public static List<SocialMediaNetwork> getSocialMediaNetworks(
		int start, int end) {

		return getService().getSocialMediaNetworks(start, end);
	}

	public static List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(
		long groupId) {

		return getService().getSocialMediaNetworksByGroupId(groupId);
	}

	public static List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(
		long groupId, int start, int end) {

		return getService().getSocialMediaNetworksByGroupId(
			groupId, start, end);
	}

	public static List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getService().getSocialMediaNetworksByGroupId(
			groupId, start, end, orderByComparator);
	}

	public static List<SocialMediaNetwork> getSocialMediaNetworksByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getService().getSocialMediaNetworksByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns all the social media networks matching the UUID and company.
	 *
	 * @param uuid the UUID of the social media networks
	 * @param companyId the primary key of the company
	 * @return the matching social media networks, or an empty list if no matches were found
	 */
	public static List<SocialMediaNetwork>
		getSocialMediaNetworksByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getSocialMediaNetworksByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<SocialMediaNetwork>
		getSocialMediaNetworksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<SocialMediaNetwork> orderByComparator) {

		return getService().getSocialMediaNetworksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of social media networks.
	 *
	 * @return the number of social media networks
	 */
	public static int getSocialMediaNetworksCount() {
		return getService().getSocialMediaNetworksCount();
	}

	public static long getSocialMediaNetworksCountByKeywords(
		long groupId, String keywords) {

		return getService().getSocialMediaNetworksCountByKeywords(
			groupId, keywords);
	}

	public static SocialMediaNetwork updateSocialMediaNetwork(
			long socialMediaNetworkId, String name, long logo, String baseURL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateSocialMediaNetwork(
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
	public static SocialMediaNetwork updateSocialMediaNetwork(
		SocialMediaNetwork socialMediaNetwork) {

		return getService().updateSocialMediaNetwork(socialMediaNetwork);
	}

	public static SocialMediaNetworkLocalService getService() {
		return _service;
	}

	private static volatile SocialMediaNetworkLocalService _service;

}