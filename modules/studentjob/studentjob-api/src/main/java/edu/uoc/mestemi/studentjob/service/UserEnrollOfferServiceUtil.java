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

import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;

import java.util.List;

/**
 * Provides the remote service utility for UserEnrollOffer. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.UserEnrollOfferServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserEnrollOfferService
 * @generated
 */
public class UserEnrollOfferServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.UserEnrollOfferServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static UserEnrollOffer addUserEnrollOffer(
			long groupId, long offerId, long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addUserEnrollOffer(
			groupId, offerId, userId, serviceContext);
	}

	public static UserEnrollOffer deleteEnrollOffer(long offerId, long userId)
		throws PortalException {

		return getService().deleteEnrollOffer(offerId, userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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

	public static List<UserEnrollOffer> getUserEnrollOffers(
		long groupId, long offerId) {

		return getService().getUserEnrollOffers(groupId, offerId);
	}

	public static UserEnrollOfferService getService() {
		return _service;
	}

	private static volatile UserEnrollOfferService _service;

}