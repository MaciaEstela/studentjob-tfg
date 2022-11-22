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
 * Provides a wrapper for {@link UserEnrollOfferService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserEnrollOfferService
 * @generated
 */
public class UserEnrollOfferServiceWrapper
	implements ServiceWrapper<UserEnrollOfferService>, UserEnrollOfferService {

	public UserEnrollOfferServiceWrapper() {
		this(null);
	}

	public UserEnrollOfferServiceWrapper(
		UserEnrollOfferService userEnrollOfferService) {

		_userEnrollOfferService = userEnrollOfferService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer addUserEnrollOffer(
			long groupId, long offerId, long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEnrollOfferService.addUserEnrollOffer(
			groupId, offerId, userId, serviceContext);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.UserEnrollOffer deleteEnrollOffer(
			long offerId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userEnrollOfferService.deleteEnrollOffer(offerId, userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userEnrollOfferService.getOSGiServiceIdentifier();
	}

	@Override
	public UserEnrollOfferService getWrappedService() {
		return _userEnrollOfferService;
	}

	@Override
	public void setWrappedService(
		UserEnrollOfferService userEnrollOfferService) {

		_userEnrollOfferService = userEnrollOfferService;
	}

	private UserEnrollOfferService _userEnrollOfferService;

}