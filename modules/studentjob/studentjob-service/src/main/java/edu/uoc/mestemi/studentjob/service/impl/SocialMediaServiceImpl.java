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

import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.service.base.SocialMediaServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sjob",
		"json.web.service.context.path=SocialMedia"
	},
	service = AopService.class
)
public class SocialMediaServiceImpl extends SocialMediaServiceBaseImpl {
	
	public SocialMedia addSocialMedia(long groupId, long socialMediaNetworkId, String socialURL, String className, 
			long classPK, ServiceContext serviceContext) throws PortalException {
		
		return socialMediaLocalService.addSocialMedia(groupId, 
				socialMediaNetworkId, socialURL, className, classPK, serviceContext);
	}
	
	public SocialMedia updateSocialMedia(long socialMediaId, String socialURL, ServiceContext serviceContext) 
			throws PortalException {
		return socialMediaLocalService.updateSocialMedia(socialMediaId, socialURL, serviceContext);
	}

	public SocialMedia deleteSocialMedia(long socialMediaId) throws PortalException {
		return socialMediaLocalService.deleteSocialMedia(socialMediaId);
	}
	
	public SocialMedia getSocialMedia(long socialMediaId) throws PortalException {
		return socialMediaLocalService.getSocialMedia(socialMediaId);
	}
	
	public List<SocialMedia> getSocialMediaNetworksByGroupId(long groupId) {
		return socialMediaLocalService.getSocialMediaNetworksByGroupId(groupId);
	}
	
	public List<SocialMedia> getSocialMediaNetworksByGroupId(long groupId, int start, int end) {
		return socialMediaLocalService.getSocialMediaNetworksByGroupId(groupId, start, end);
	}
	
	public List<SocialMedia> getSocialMediaNetworksByGroupId(long groupId, int start, int end, 
			OrderByComparator<SocialMedia> orderByComparator) {
		return socialMediaLocalService.getSocialMediaNetworksByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<SocialMedia> getSocialMediaNetworksByGroupIdAndClass(long groupId, String className, long classPK) {
		return socialMediaLocalService.getSocialMediaNetworksByGroupIdAndClass(groupId, className, classPK);
	}
	
	public SocialMedia getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
			long groupId, String className, long classPK, long socialMediaNetworkId) throws NoSuchSocialMediaException {
		return socialMediaLocalService.getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				groupId, className, classPK, socialMediaNetworkId);
	}
}