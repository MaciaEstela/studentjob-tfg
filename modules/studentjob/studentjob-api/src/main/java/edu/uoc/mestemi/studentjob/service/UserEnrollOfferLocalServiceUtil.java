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

import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UserEnrollOffer. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.UserEnrollOfferLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserEnrollOfferLocalService
 * @generated
 */
public class UserEnrollOfferLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.UserEnrollOfferLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static UserEnrollOffer addUserEnrollOffer(
			long groupId, long offerId, long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addUserEnrollOffer(
			groupId, offerId, userId, serviceContext);
	}

	/**
	 * Adds the user enroll offer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEnrollOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEnrollOffer the user enroll offer
	 * @return the user enroll offer that was added
	 */
	public static UserEnrollOffer addUserEnrollOffer(
		UserEnrollOffer userEnrollOffer) {

		return getService().addUserEnrollOffer(userEnrollOffer);
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
	 * Creates a new user enroll offer with the primary key. Does not add the user enroll offer to the database.
	 *
	 * @param userEnrollOfferPK the primary key for the new user enroll offer
	 * @return the new user enroll offer
	 */
	public static UserEnrollOffer createUserEnrollOffer(
		edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
			userEnrollOfferPK) {

		return getService().createUserEnrollOffer(userEnrollOfferPK);
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
	 * Deletes the user enroll offer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEnrollOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEnrollOffer the user enroll offer
	 * @return the user enroll offer that was removed
	 */
	public static UserEnrollOffer deleteUserEnrollOffer(
		UserEnrollOffer userEnrollOffer) {

		return getService().deleteUserEnrollOffer(userEnrollOffer);
	}

	/**
	 * Deletes the user enroll offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEnrollOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer that was removed
	 * @throws PortalException if a user enroll offer with the primary key could not be found
	 */
	public static UserEnrollOffer deleteUserEnrollOffer(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK)
		throws PortalException {

		return getService().deleteUserEnrollOffer(userEnrollOfferPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.UserEnrollOfferModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.UserEnrollOfferModelImpl</code>.
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

	public static UserEnrollOffer fetchUserEnrollOffer(
		edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
			userEnrollOfferPK) {

		return getService().fetchUserEnrollOffer(userEnrollOfferPK);
	}

	/**
	 * Returns the user enroll offer matching the UUID and group.
	 *
	 * @param uuid the user enroll offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer fetchUserEnrollOfferByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchUserEnrollOfferByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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

	public static List<UserEnrollOffer> getUserEnrolledOffers(
		long groupId, long userId) {

		return getService().getUserEnrolledOffers(groupId, userId);
	}

	public static int getUserEnrolledOffersCount(long groupId, long userId) {
		return getService().getUserEnrolledOffersCount(groupId, userId);
	}

	public static UserEnrollOffer getUserEnrollOffer(
		long groupId, long userId, long offerId) {

		return getService().getUserEnrollOffer(groupId, userId, offerId);
	}

	/**
	 * Returns the user enroll offer with the primary key.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer
	 * @throws PortalException if a user enroll offer with the primary key could not be found
	 */
	public static UserEnrollOffer getUserEnrollOffer(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK)
		throws PortalException {

		return getService().getUserEnrollOffer(userEnrollOfferPK);
	}

	/**
	 * Returns the user enroll offer matching the UUID and group.
	 *
	 * @param uuid the user enroll offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user enroll offer
	 * @throws PortalException if a matching user enroll offer could not be found
	 */
	public static UserEnrollOffer getUserEnrollOfferByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getUserEnrollOfferByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the user enroll offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @return the range of user enroll offers
	 */
	public static List<UserEnrollOffer> getUserEnrollOffers(
		int start, int end) {

		return getService().getUserEnrollOffers(start, end);
	}

	public static List<UserEnrollOffer> getUserEnrollOffers(
		long groupId, long offerId) {

		return getService().getUserEnrollOffers(groupId, offerId);
	}

	/**
	 * Returns the number of user enroll offers.
	 *
	 * @return the number of user enroll offers
	 */
	public static int getUserEnrollOffersCount() {
		return getService().getUserEnrollOffersCount();
	}

	public static int getUserEnrollOffersCount(long groupId, long offerId) {
		return getService().getUserEnrollOffersCount(groupId, offerId);
	}

	/**
	 * Updates the user enroll offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEnrollOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEnrollOffer the user enroll offer
	 * @return the user enroll offer that was updated
	 */
	public static UserEnrollOffer updateUserEnrollOffer(
		UserEnrollOffer userEnrollOffer) {

		return getService().updateUserEnrollOffer(userEnrollOffer);
	}

	public static UserEnrollOfferLocalService getService() {
		return _service;
	}

	private static volatile UserEnrollOfferLocalService _service;

}