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
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String preference, java.util.List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerService.addOffer(
			groupId, regionId, nameMap, descriptionMap, preference, degreeIds,
			serviceContext);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer deleteOffer(long offerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerService.deleteOffer(offerId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Offer getOffer(long offerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerService.getOffer(offerId);
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
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String preference, java.util.List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerService.updateOffer(
			offerId, regionId, nameMap, descriptionMap, preference, degreeIds,
			serviceContext);
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