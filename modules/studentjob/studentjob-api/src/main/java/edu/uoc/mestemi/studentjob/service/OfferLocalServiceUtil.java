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

import edu.uoc.mestemi.studentjob.model.Offer;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Offer. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.OfferLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see OfferLocalService
 * @generated
 */
public class OfferLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.OfferLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addDegreeOffer(long degreeId, long offerId) {
		getService().addDegreeOffer(degreeId, offerId);
	}

	public static void addDegreeOffer(long degreeId, Offer offer) {
		getService().addDegreeOffer(degreeId, offer);
	}

	public static void addDegreeOffers(long degreeId, List<Offer> offers) {
		getService().addDegreeOffers(degreeId, offers);
	}

	public static void addDegreeOffers(long degreeId, long[] offerIds) {
		getService().addDegreeOffers(degreeId, offerIds);
	}

	public static Offer addOffer(
			long groupId, long regionId, Map<java.util.Locale, String> nameMap,
			Map<java.util.Locale, String> descriptionMap, String preference,
			List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addOffer(
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
	public static Offer addOffer(Offer offer) {
		return getService().addOffer(offer);
	}

	public static void clearDegreeOffers(long degreeId) {
		getService().clearDegreeOffers(degreeId);
	}

	/**
	 * Creates a new offer with the primary key. Does not add the offer to the database.
	 *
	 * @param offerId the primary key for the new offer
	 * @return the new offer
	 */
	public static Offer createOffer(long offerId) {
		return getService().createOffer(offerId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteDegreeOffer(long degreeId, long offerId) {
		getService().deleteDegreeOffer(degreeId, offerId);
	}

	public static void deleteDegreeOffer(long degreeId, Offer offer) {
		getService().deleteDegreeOffer(degreeId, offer);
	}

	public static void deleteDegreeOffers(long degreeId, List<Offer> offers) {
		getService().deleteDegreeOffers(degreeId, offers);
	}

	public static void deleteDegreeOffers(long degreeId, long[] offerIds) {
		getService().deleteDegreeOffers(degreeId, offerIds);
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
	public static Offer deleteOffer(long offerId) throws PortalException {
		return getService().deleteOffer(offerId);
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
	public static Offer deleteOffer(Offer offer) {
		return getService().deleteOffer(offer);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.OfferModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.OfferModelImpl</code>.
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

	public static Offer fetchOffer(long offerId) {
		return getService().fetchOffer(offerId);
	}

	/**
	 * Returns the offer matching the UUID and group.
	 *
	 * @param uuid the offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchOfferByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchOfferByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Offer> getDegreeOffers(long degreeId) {
		return getService().getDegreeOffers(degreeId);
	}

	public static List<Offer> getDegreeOffers(
		long degreeId, int start, int end) {

		return getService().getDegreeOffers(degreeId, start, end);
	}

	public static List<Offer> getDegreeOffers(
		long degreeId, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getService().getDegreeOffers(
			degreeId, start, end, orderByComparator);
	}

	public static int getDegreeOffersCount(long degreeId) {
		return getService().getDegreeOffersCount(degreeId);
	}

	/**
	 * Returns the degreeIds of the degrees associated with the offer.
	 *
	 * @param offerId the offerId of the offer
	 * @return long[] the degreeIds of degrees associated with the offer
	 */
	public static long[] getDegreePrimaryKeys(long offerId) {
		return getService().getDegreePrimaryKeys(offerId);
	}

	public static List<Offer> getDegreesByGroupId(
		long groupId, int start, int end) {

		return getService().getDegreesByGroupId(groupId, start, end);
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
	 * Returns the offer with the primary key.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer
	 * @throws PortalException if a offer with the primary key could not be found
	 */
	public static Offer getOffer(long offerId) throws PortalException {
		return getService().getOffer(offerId);
	}

	/**
	 * Returns the offer matching the UUID and group.
	 *
	 * @param uuid the offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching offer
	 * @throws PortalException if a matching offer could not be found
	 */
	public static Offer getOfferByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getOfferByUuidAndGroupId(uuid, groupId);
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
	public static List<Offer> getOffers(int start, int end) {
		return getService().getOffers(start, end);
	}

	public static List<Offer> getOffersByGroupId(long groupId) {
		return getService().getOffersByGroupId(groupId);
	}

	public static List<Offer> getOffersByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getService().getOffersByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns all the offers matching the UUID and company.
	 *
	 * @param uuid the UUID of the offers
	 * @param companyId the primary key of the company
	 * @return the matching offers, or an empty list if no matches were found
	 */
	public static List<Offer> getOffersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getOffersByUuidAndCompanyId(uuid, companyId);
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
	public static List<Offer> getOffersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getService().getOffersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of offers.
	 *
	 * @return the number of offers
	 */
	public static int getOffersCount() {
		return getService().getOffersCount();
	}

	public static long getOffersCountByKeywords(long groupId, String keywords) {
		return getService().getOffersCountByKeywords(groupId, keywords);
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

	public static boolean hasDegreeOffer(long degreeId, long offerId) {
		return getService().hasDegreeOffer(degreeId, offerId);
	}

	public static boolean hasDegreeOffers(long degreeId) {
		return getService().hasDegreeOffers(degreeId);
	}

	public static void setDegreeOffers(long degreeId, long[] offerIds) {
		getService().setDegreeOffers(degreeId, offerIds);
	}

	public static Offer updateOffer(
			long offerId, long regionId, Map<java.util.Locale, String> nameMap,
			Map<java.util.Locale, String> descriptionMap, String preference,
			List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateOffer(
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
	public static Offer updateOffer(Offer offer) {
		return getService().updateOffer(offer);
	}

	public static OfferLocalService getService() {
		return _service;
	}

	private static volatile OfferLocalService _service;

}