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
 * Provides a wrapper for {@link UserEnrollOfferLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserEnrollOfferLocalService
 * @generated
 */
public class UserEnrollOfferLocalServiceWrapper
	implements ServiceWrapper<UserEnrollOfferLocalService>,
			   UserEnrollOfferLocalService {

	public UserEnrollOfferLocalServiceWrapper() {
		this(null);
	}

	public UserEnrollOfferLocalServiceWrapper(
		UserEnrollOfferLocalService userEnrollOfferLocalService) {

		_userEnrollOfferLocalService = userEnrollOfferLocalService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer addUserEnrollOffer(
			long groupId, long offerId, long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEnrollOfferLocalService.addUserEnrollOffer(
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
	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer addUserEnrollOffer(
		edu.uoc.mestemi.studentjob.model.UserEnrollOffer userEnrollOffer) {

		return _userEnrollOfferLocalService.addUserEnrollOffer(userEnrollOffer);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEnrollOfferLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user enroll offer with the primary key. Does not add the user enroll offer to the database.
	 *
	 * @param userEnrollOfferPK the primary key for the new user enroll offer
	 * @return the new user enroll offer
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer
		createUserEnrollOffer(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK) {

		return _userEnrollOfferLocalService.createUserEnrollOffer(
			userEnrollOfferPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEnrollOfferLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer
		deleteUserEnrollOffer(
			edu.uoc.mestemi.studentjob.model.UserEnrollOffer userEnrollOffer) {

		return _userEnrollOfferLocalService.deleteUserEnrollOffer(
			userEnrollOffer);
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
	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer
			deleteUserEnrollOffer(
				edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
					userEnrollOfferPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEnrollOfferLocalService.deleteUserEnrollOffer(
			userEnrollOfferPK);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _userEnrollOfferLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _userEnrollOfferLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userEnrollOfferLocalService.dynamicQuery();
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

		return _userEnrollOfferLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userEnrollOfferLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userEnrollOfferLocalService.dynamicQuery(
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

		return _userEnrollOfferLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userEnrollOfferLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer
		fetchUserEnrollOffer(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK) {

		return _userEnrollOfferLocalService.fetchUserEnrollOffer(
			userEnrollOfferPK);
	}

	/**
	 * Returns the user enroll offer matching the UUID and group.
	 *
	 * @param uuid the user enroll offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer
		fetchUserEnrollOfferByUuidAndGroupId(String uuid, long groupId) {

		return _userEnrollOfferLocalService.
			fetchUserEnrollOfferByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userEnrollOfferLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userEnrollOfferLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userEnrollOfferLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEnrollOfferLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.UserEnrollOffer>
		getUserEnrolledOffers(long groupId, long userId) {

		return _userEnrollOfferLocalService.getUserEnrolledOffers(
			groupId, userId);
	}

	@Override
	public int getUserEnrolledOffersCount(long groupId, long userId) {
		return _userEnrollOfferLocalService.getUserEnrolledOffersCount(
			groupId, userId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer getUserEnrollOffer(
		long groupId, long userId, long offerId) {

		return _userEnrollOfferLocalService.getUserEnrollOffer(
			groupId, userId, offerId);
	}

	/**
	 * Returns the user enroll offer with the primary key.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer
	 * @throws PortalException if a user enroll offer with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer getUserEnrollOffer(
			edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
				userEnrollOfferPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEnrollOfferLocalService.getUserEnrollOffer(
			userEnrollOfferPK);
	}

	/**
	 * Returns the user enroll offer matching the UUID and group.
	 *
	 * @param uuid the user enroll offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user enroll offer
	 * @throws PortalException if a matching user enroll offer could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer
			getUserEnrollOfferByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEnrollOfferLocalService.getUserEnrollOfferByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.UserEnrollOffer>
		getUserEnrollOffers(int start, int end) {

		return _userEnrollOfferLocalService.getUserEnrollOffers(start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.UserEnrollOffer>
		getUserEnrollOffers(long groupId, long offerId) {

		return _userEnrollOfferLocalService.getUserEnrollOffers(
			groupId, offerId);
	}

	/**
	 * Returns the number of user enroll offers.
	 *
	 * @return the number of user enroll offers
	 */
	@Override
	public int getUserEnrollOffersCount() {
		return _userEnrollOfferLocalService.getUserEnrollOffersCount();
	}

	@Override
	public int getUserEnrollOffersCount(long groupId, long offerId) {
		return _userEnrollOfferLocalService.getUserEnrollOffersCount(
			groupId, offerId);
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
	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer
		updateUserEnrollOffer(
			edu.uoc.mestemi.studentjob.model.UserEnrollOffer userEnrollOffer) {

		return _userEnrollOfferLocalService.updateUserEnrollOffer(
			userEnrollOffer);
	}

	@Override
	public UserEnrollOfferLocalService getWrappedService() {
		return _userEnrollOfferLocalService;
	}

	@Override
	public void setWrappedService(
		UserEnrollOfferLocalService userEnrollOfferLocalService) {

		_userEnrollOfferLocalService = userEnrollOfferLocalService;
	}

	private UserEnrollOfferLocalService _userEnrollOfferLocalService;

}