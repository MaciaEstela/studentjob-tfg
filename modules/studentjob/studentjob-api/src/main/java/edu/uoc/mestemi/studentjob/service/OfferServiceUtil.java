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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.Offer;

import java.util.List;
import java.util.Map;

/**
 * Provides the remote service utility for Offer. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.OfferServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see OfferService
 * @generated
 */
public class OfferServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.OfferServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Offer addOffer(
			long groupId, long regionId, Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, String preference,
			List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addOffer(
			groupId, regionId, titleMap, descriptionMap, preference, degreeIds,
			serviceContext);
	}

	public static Offer addOffer(Offer offer) {
		return getService().addOffer(offer);
	}

	public static Offer deleteOffer(long offerId) throws PortalException {
		return getService().deleteOffer(offerId);
	}

	public static Offer expireOffer(long offerId) {
		return getService().expireOffer(offerId);
	}

	public static Offer expireOffer(Offer offer) {
		return getService().expireOffer(offer);
	}

	public static List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByOfferId(long offerId) {

		return getService().getDegreesByOfferId(offerId);
	}

	public static List<Long> getDegreesIdsByOfferId(long offerId) {
		return getService().getDegreesIdsByOfferId(offerId);
	}

	public static Offer getOffer(long offerId) throws PortalException {
		return getService().getOffer(offerId);
	}

	public static List<Offer> getOffersByGroupId(long groupId) {
		return getService().getOffersByGroupId(groupId);
	}

	public static List<Offer> getOffersByGroupId(
		long groupId, int start, int end) {

		return getService().getOffersByGroupId(groupId, start, end);
	}

	public static List<Offer> getOffersByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getService().getOffersByGroupId(
			groupId, start, end, orderByComparator);
	}

	public static List<Offer> getOffersByKeywords(
		long groupId, long userId, String keywords, int workflowStatus,
		int start, int end, OrderByComparator<Offer> orderByComparator) {

		return getService().getOffersByKeywords(
			groupId, userId, keywords, workflowStatus, start, end,
			orderByComparator);
	}

	public static List<Offer>
		getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			long groupId, long userId, String keywords, String preference,
			long regionId, long degreeId, int workflowStatus, long newestId,
			int start, int end, OrderByComparator<Offer> orderByComparator) {

		return getService().
			getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(
				groupId, userId, keywords, preference, regionId, degreeId,
				workflowStatus, newestId, start, end, orderByComparator);
	}

	public static long getOffersCountByKeywords(
		long groupId, long userId, String keywords, int workflowStatus) {

		return getService().getOffersCountByKeywords(
			groupId, userId, keywords, workflowStatus);
	}

	public static long
		getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			long groupId, long userId, String keywords, String preference,
			long regionId, long degreeId, int workflowStatus, long newestId) {

		return getService().
			getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
				groupId, userId, keywords, preference, regionId, degreeId,
				workflowStatus, newestId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Offer updateOffer(
			long offerId, long regionId, Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, String preference,
			List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateOffer(
			offerId, regionId, titleMap, descriptionMap, preference, degreeIds,
			serviceContext);
	}

	public static Offer updateOffer(Offer offer) {
		return getService().updateOffer(offer);
	}

	public static OfferService getService() {
		return _service;
	}

	private static volatile OfferService _service;

}