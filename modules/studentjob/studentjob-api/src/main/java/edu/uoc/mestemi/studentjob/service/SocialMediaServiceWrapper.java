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
	public SocialMediaService getWrappedService() {
		return _socialMediaService;
	}

	@Override
	public void setWrappedService(SocialMediaService socialMediaService) {
		_socialMediaService = socialMediaService;
	}

	private SocialMediaService _socialMediaService;

}