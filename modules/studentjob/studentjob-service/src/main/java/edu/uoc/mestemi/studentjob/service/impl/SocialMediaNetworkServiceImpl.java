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

package edu.uoc.mestemi.studentjob.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.base.SocialMediaNetworkServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sjob",
		"json.web.service.context.path=SocialMediaNetwork"
	},
	service = AopService.class
)
public class SocialMediaNetworkServiceImpl
	extends SocialMediaNetworkServiceBaseImpl {
	
	public SocialMediaNetwork addSocialMediaNetwork(long groupId, String name, long logo, 
			String baseURL, ServiceContext serviceContext) throws PortalException {
		
		return socialMediaNetworkLocalService.addSocialMediaNetwork(groupId, 
				name, logo, baseURL, serviceContext);
	}
	
	public SocialMediaNetwork updateSocialMediaNetwork(long socialMediaNetworkId, String name, long logo, 
			String baseURL, ServiceContext serviceContext) throws PortalException {

		return socialMediaNetworkLocalService.updateSocialMediaNetwork(socialMediaNetworkId, 
				name, logo, baseURL, serviceContext);
	}
	
	public SocialMediaNetwork deleteSocialMediaNetwork(long socialMediaNetworkId) throws PortalException {
		return socialMediaNetworkLocalService.deleteSocialMediaNetwork(socialMediaNetworkId);
	}
	
	public SocialMediaNetwork getSocialMediaNetwork(long socialMediaNetworkId) throws PortalException {
		return socialMediaNetworkLocalService.getSocialMediaNetwork(socialMediaNetworkId);
	}
	
	public List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(long groupId) {
		return socialMediaNetworkLocalService.getSocialMediaNetworksByGroupId(groupId);
	}
	
	public List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(long groupId, int start, int end) {
		return socialMediaNetworkLocalService.getSocialMediaNetworksByGroupId(groupId, start, end);
	}
	
	public List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(long groupId, int start, int end, 
			OrderByComparator<SocialMediaNetwork> orderByComparator) {
		return socialMediaNetworkLocalService.getSocialMediaNetworksByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<SocialMediaNetwork> getSocialMediaNetworksByKeywords(long groupId, String keywords, int start, 
			int end, OrderByComparator<SocialMediaNetwork> orderByComparator) {
		return socialMediaNetworkLocalService.getSocialMediaNetworksByKeywords(groupId, keywords, start, end, orderByComparator);
	}
	
	public long getSocialMediaNetworksCountByKeywords(long groupId, String keywords) {
		return socialMediaNetworkLocalService.getSocialMediaNetworksCountByKeywords(groupId, keywords);
	}
}