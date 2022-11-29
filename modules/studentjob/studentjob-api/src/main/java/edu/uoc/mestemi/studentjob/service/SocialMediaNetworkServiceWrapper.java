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
 * Provides a wrapper for {@link SocialMediaNetworkService}.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaNetworkService
 * @generated
 */
public class SocialMediaNetworkServiceWrapper
	implements ServiceWrapper<SocialMediaNetworkService>,
			   SocialMediaNetworkService {

	public SocialMediaNetworkServiceWrapper() {
		this(null);
	}

	public SocialMediaNetworkServiceWrapper(
		SocialMediaNetworkService socialMediaNetworkService) {

		_socialMediaNetworkService = socialMediaNetworkService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
			addSocialMediaNetwork(
				long groupId, String name, long logo, String baseURL,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkService.addSocialMediaNetwork(
			groupId, name, logo, baseURL, serviceContext);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
			deleteSocialMediaNetwork(long socialMediaNetworkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkService.deleteSocialMediaNetwork(
			socialMediaNetworkId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _socialMediaNetworkService.getOSGiServiceIdentifier();
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
			getSocialMediaNetwork(long socialMediaNetworkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkService.getSocialMediaNetwork(
			socialMediaNetworkId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
		getSocialMediaNetworksByGroupId(long groupId) {

		return _socialMediaNetworkService.getSocialMediaNetworksByGroupId(
			groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
		getSocialMediaNetworksByGroupId(long groupId, int start, int end) {

		return _socialMediaNetworkService.getSocialMediaNetworksByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
		getSocialMediaNetworksByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
					orderByComparator) {

		return _socialMediaNetworkService.getSocialMediaNetworksByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
		getSocialMediaNetworksByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.SocialMediaNetwork>
					orderByComparator) {

		return _socialMediaNetworkService.getSocialMediaNetworksByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public long getSocialMediaNetworksCountByKeywords(
		long groupId, String keywords) {

		return _socialMediaNetworkService.getSocialMediaNetworksCountByKeywords(
			groupId, keywords);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.SocialMediaNetwork
			updateSocialMediaNetwork(
				long socialMediaNetworkId, String name, long logo,
				String baseURL,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialMediaNetworkService.updateSocialMediaNetwork(
			socialMediaNetworkId, name, logo, baseURL, serviceContext);
	}

	@Override
	public SocialMediaNetworkService getWrappedService() {
		return _socialMediaNetworkService;
	}

	@Override
	public void setWrappedService(
		SocialMediaNetworkService socialMediaNetworkService) {

		_socialMediaNetworkService = socialMediaNetworkService;
	}

	private SocialMediaNetworkService _socialMediaNetworkService;

}