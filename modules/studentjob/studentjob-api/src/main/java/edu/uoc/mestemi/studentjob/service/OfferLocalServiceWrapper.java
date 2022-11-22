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
 * Provides a wrapper for {@link OfferLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OfferLocalService
 * @generated
 */
public class OfferLocalServiceWrapper
	implements OfferLocalService, ServiceWrapper<OfferLocalService> {

	public OfferLocalServiceWrapper() {
		this(null);
	}

	public OfferLocalServiceWrapper(OfferLocalService offerLocalService) {
		_offerLocalService = offerLocalService;
	}

	@Override
	public void addDegreeOffer(long degreeId, long offerId) {
		_offerLocalService.addDegreeOffer(degreeId, offerId);
	}

	@Override
	public void addDegreeOffer(
		long degreeId, edu.uoc.mestemi.studentjob.model.Offer offer) {

		_offerLocalService.addDegreeOffer(degreeId, offer);
	}

	@Override
	public void addDegreeOffers(
		long degreeId,
		java.util.List<edu.uoc.mestemi.studentjob.model.Offer> offers) {

		_offerLocalService.addDegreeOffers(degreeId, offers);
	}

	@Override
	public void addDegreeOffers(long degreeId, long[] offerIds) {
		_offerLocalService.addDegreeOffers(degreeId, offerIds);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer addOffer(
			long groupId, long regionId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String preference, java.util.List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.addOffer(
			groupId, regionId, nameMap, descriptionMap, preference, degreeIds,
			serviceContext);
	}

	/**
	 * Adds the offer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offer the offer
	 * @return the offer that was added
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Offer addOffer(
		edu.uoc.mestemi.studentjob.model.Offer offer) {

		return _offerLocalService.addOffer(offer);
	}

	@Override
	public void clearDegreeOffers(long degreeId) {
		_offerLocalService.clearDegreeOffers(degreeId);
	}

	/**
	 * Creates a new offer with the primary key. Does not add the offer to the database.
	 *
	 * @param offerId the primary key for the new offer
	 * @return the new offer
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Offer createOffer(long offerId) {
		return _offerLocalService.createOffer(offerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteDegreeOffer(long degreeId, long offerId) {
		_offerLocalService.deleteDegreeOffer(degreeId, offerId);
	}

	@Override
	public void deleteDegreeOffer(
		long degreeId, edu.uoc.mestemi.studentjob.model.Offer offer) {

		_offerLocalService.deleteDegreeOffer(degreeId, offer);
	}

	@Override
	public void deleteDegreeOffers(
		long degreeId,
		java.util.List<edu.uoc.mestemi.studentjob.model.Offer> offers) {

		_offerLocalService.deleteDegreeOffers(degreeId, offers);
	}

	@Override
	public void deleteDegreeOffers(long degreeId, long[] offerIds) {
		_offerLocalService.deleteDegreeOffers(degreeId, offerIds);
	}

	/**
	 * Deletes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer that was removed
	 * @throws PortalException if a offer with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Offer deleteOffer(long offerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.deleteOffer(offerId);
	}

	/**
	 * Deletes the offer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offer the offer
	 * @return the offer that was removed
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Offer deleteOffer(
		edu.uoc.mestemi.studentjob.model.Offer offer) {

		return _offerLocalService.deleteOffer(offer);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _offerLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _offerLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _offerLocalService.dynamicQuery();
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

		return _offerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.OfferModelImpl</code>.
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

		return _offerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.OfferModelImpl</code>.
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

		return _offerLocalService.dynamicQuery(
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

		return _offerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _offerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer fetchOffer(long offerId) {
		return _offerLocalService.fetchOffer(offerId);
	}

	/**
	 * Returns the offer matching the UUID and group.
	 *
	 * @param uuid the offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching offer, or <code>null</code> if a matching offer could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Offer fetchOfferByUuidAndGroupId(
		String uuid, long groupId) {

		return _offerLocalService.fetchOfferByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _offerLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getDegreeOffers(long degreeId) {

		return _offerLocalService.getDegreeOffers(degreeId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getDegreeOffers(long degreeId, int start, int end) {

		return _offerLocalService.getDegreeOffers(degreeId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getDegreeOffers(
			long degreeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Offer> orderByComparator) {

		return _offerLocalService.getDegreeOffers(
			degreeId, start, end, orderByComparator);
	}

	@Override
	public int getDegreeOffersCount(long degreeId) {
		return _offerLocalService.getDegreeOffersCount(degreeId);
	}

	/**
	 * Returns the degreeIds of the degrees associated with the offer.
	 *
	 * @param offerId the offerId of the offer
	 * @return long[] the degreeIds of degrees associated with the offer
	 */
	@Override
	public long[] getDegreePrimaryKeys(long offerId) {
		return _offerLocalService.getDegreePrimaryKeys(offerId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getDegreesByGroupId(long groupId, int start, int end) {

		return _offerLocalService.getDegreesByGroupId(groupId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _offerLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _offerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the offer with the primary key.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer
	 * @throws PortalException if a offer with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Offer getOffer(long offerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.getOffer(offerId);
	}

	/**
	 * Returns the offer matching the UUID and group.
	 *
	 * @param uuid the offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching offer
	 * @throws PortalException if a matching offer could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Offer getOfferByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.getOfferByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.OfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of offers
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer> getOffers(
		int start, int end) {

		return _offerLocalService.getOffers(start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByGroupId(long groupId) {

		return _offerLocalService.getOffersByGroupId(groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Offer> orderByComparator) {

		return _offerLocalService.getOffersByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns all the offers matching the UUID and company.
	 *
	 * @param uuid the UUID of the offers
	 * @param companyId the primary key of the company
	 * @return the matching offers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByUuidAndCompanyId(String uuid, long companyId) {

		return _offerLocalService.getOffersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of offers matching the UUID and company.
	 *
	 * @param uuid the UUID of the offers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching offers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Offer> orderByComparator) {

		return _offerLocalService.getOffersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of offers.
	 *
	 * @return the number of offers
	 */
	@Override
	public int getOffersCount() {
		return _offerLocalService.getOffersCount();
	}

	@Override
	public long getOffersCountByKeywords(long groupId, String keywords) {
		return _offerLocalService.getOffersCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _offerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasDegreeOffer(long degreeId, long offerId) {
		return _offerLocalService.hasDegreeOffer(degreeId, offerId);
	}

	@Override
	public boolean hasDegreeOffers(long degreeId) {
		return _offerLocalService.hasDegreeOffers(degreeId);
	}

	@Override
	public void setDegreeOffers(long degreeId, long[] offerIds) {
		_offerLocalService.setDegreeOffers(degreeId, offerIds);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer updateOffer(
			long offerId, long regionId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String preference, java.util.List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.updateOffer(
			offerId, regionId, nameMap, descriptionMap, preference, degreeIds,
			serviceContext);
	}

	/**
	 * Updates the offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offer the offer
	 * @return the offer that was updated
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Offer updateOffer(
		edu.uoc.mestemi.studentjob.model.Offer offer) {

		return _offerLocalService.updateOffer(offer);
	}

	@Override
	public OfferLocalService getWrappedService() {
		return _offerLocalService;
	}

	@Override
	public void setWrappedService(OfferLocalService offerLocalService) {
		_offerLocalService = offerLocalService;
	}

	private OfferLocalService _offerLocalService;

}