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
 * Provides a wrapper for {@link OfferService}.
 *
 * @author Brian Wing Shun Chan
 * @see OfferService
 * @generated
 */
public class OfferServiceWrapper
	implements OfferService, ServiceWrapper<OfferService> {

	public OfferServiceWrapper() {
		this(null);
	}

	public OfferServiceWrapper(OfferService offerService) {
		_offerService = offerService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer addOffer(
			long groupId, long regionId,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String preference, java.util.List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerService.addOffer(
			groupId, regionId, titleMap, descriptionMap, preference, degreeIds,
			serviceContext);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer addOffer(
		edu.uoc.mestemi.studentjob.model.Offer offer) {

		return _offerService.addOffer(offer);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer deleteOffer(long offerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerService.deleteOffer(offerId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByOfferId(long offerId) {

		return _offerService.getDegreesByOfferId(offerId);
	}

	@Override
	public java.util.List<Long> getDegreesIdsByOfferId(long offerId) {
		return _offerService.getDegreesIdsByOfferId(offerId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer getOffer(long offerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerService.getOffer(offerId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByGroupId(long groupId) {

		return _offerService.getOffersByGroupId(groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByGroupId(long groupId, int start, int end) {

		return _offerService.getOffersByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Offer> orderByComparator) {

		return _offerService.getOffersByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Offer> orderByComparator) {

		return _offerService.getOffersByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public long getOffersCountByKeywords(long groupId, String keywords) {
		return _offerService.getOffersCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _offerService.getOSGiServiceIdentifier();
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer updateOffer(
			long offerId, long regionId,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String preference, java.util.List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerService.updateOffer(
			offerId, regionId, titleMap, descriptionMap, preference, degreeIds,
			serviceContext);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer updateOffer(
		edu.uoc.mestemi.studentjob.model.Offer offer) {

		return _offerService.updateOffer(offer);
	}

	@Override
	public OfferService getWrappedService() {
		return _offerService;
	}

	@Override
	public void setWrappedService(OfferService offerService) {
		_offerService = offerService;
	}

	private OfferService _offerService;

}