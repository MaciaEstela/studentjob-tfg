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
 * Provides a wrapper for {@link SocialMediaService}.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaService
 * @generated
 */
public class SocialMediaServiceWrapper
	implements ServiceWrapper<SocialMediaService>, SocialMediaService {

	public SocialMediaServiceWrapper() {
		this(null);
	}

	public SocialMediaServiceWrapper(SocialMediaService socialMediaService) {
		_socialMediaService = socialMediaService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia addSocialMedia(
			long groupId, long socialMediaId, String socialURL,
			String className, long classPK,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaService.addSocialMedia(
			groupId, socialMediaId, socialURL, className, classPK,
			serviceContext);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia deleteSocialMedia(
			long socialMediaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaService.deleteSocialMedia(socialMediaId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _socialMediaService.getOSGiServiceIdentifier();
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia getSocialMedia(
			long socialMediaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaService.getSocialMedia(socialMediaId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMedia updateSocialMedia(
			long socialMediaId, String socialURL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaService.updateSocialMedia(
			socialMediaId, socialURL, serviceContext);
	}

	@Override
	public SocialMediaService getWrappedService() {
		return _socialMediaService;
	}

	@Override
	public void setWrappedService(SocialMediaService socialMediaService) {
		_socialMediaService = socialMediaService;
	}

	private SocialMediaService _socialMediaService;

}