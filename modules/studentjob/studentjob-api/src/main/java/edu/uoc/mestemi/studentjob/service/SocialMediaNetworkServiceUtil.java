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

import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;

/**
 * Provides the remote service utility for SocialMediaNetwork. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.SocialMediaNetworkServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaNetworkService
 * @generated
 */
public class SocialMediaNetworkServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.SocialMediaNetworkServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SocialMediaNetwork addSocialMediaNetwork(
			long groupId, String name, long logo, String baseURL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addSocialMediaNetwork(
			groupId, name, logo, baseURL, serviceContext);
	}

	public static SocialMediaNetwork deleteSocialMediaNetwork(
			long socialMediaNetworkId)
		throws PortalException {

		return getService().deleteSocialMediaNetwork(socialMediaNetworkId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SocialMediaNetwork getSocialMediaNetwork(
			long socialMediaNetworkId)
		throws PortalException {

		return getService().getSocialMediaNetwork(socialMediaNetworkId);
	}

	public static SocialMediaNetwork updateSocialMediaNetwork(
			long socialMediaNetworkId, String name, long logo, String baseURL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateSocialMediaNetwork(
			socialMediaNetworkId, name, logo, baseURL, serviceContext);
	}

	public static SocialMediaNetworkService getService() {
		return _service;
	}

	private static volatile SocialMediaNetworkService _service;

}