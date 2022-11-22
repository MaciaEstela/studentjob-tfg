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

import edu.uoc.mestemi.studentjob.model.SocialMedia;

/**
 * Provides the remote service utility for SocialMedia. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.SocialMediaServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaService
 * @generated
 */
public class SocialMediaServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.SocialMediaServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SocialMedia addSocialMedia(
			long groupId, long socialMediaId, String socialURL,
			String className, long classPK,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addSocialMedia(
			groupId, socialMediaId, socialURL, className, classPK,
			serviceContext);
	}

	public static SocialMedia deleteSocialMedia(long socialMediaId)
		throws PortalException {

		return getService().deleteSocialMedia(socialMediaId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SocialMedia getSocialMedia(long socialMediaId)
		throws PortalException {

		return getService().getSocialMedia(socialMediaId);
	}

	public static SocialMedia updateSocialMedia(
			long socialMediaId, String socialURL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateSocialMedia(
			socialMediaId, socialURL, serviceContext);
	}

	public static SocialMediaService getService() {
		return _service;
	}

	private static volatile SocialMediaService _service;

}