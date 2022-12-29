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
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException;
import edu.uoc.mestemi.studentjob.exception.OfferValidationException;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkLocalService;
import edu.uoc.mestemi.studentjob.service.base.SocialMediaLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	property = "model.class.name=edu.uoc.mestemi.studentjob.model.SocialMedia",
	service = AopService.class
)
public class SocialMediaLocalServiceImpl
	extends SocialMediaLocalServiceBaseImpl {
	
	public SocialMedia addSocialMedia(long groupId, long socialMediaNetworkId, String socialURL, String className, 
			long classPK, ServiceContext serviceContext) throws PortalException {
		
		if (Validator.isNull(socialMediaNetworkId)) {
			throw new OfferValidationException("SocialMedia should have a SocialMediaNetwork associated");
		}
		
		// Get group and user
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);

		// Generate degree primary key
		long socialMediaId = counterLocalService.increment(SocialMedia.class.getName());
		
		SocialMedia socialMedia = createSocialMedia(socialMediaId);
		
		socialMedia.setCompanyId(group.getCompanyId());
		socialMedia.setGroupId(group.getGroupId());
		socialMedia.setCreateDate(serviceContext.getCreateDate(new Date()));
		socialMedia.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		socialMedia.setUserId(userId);
		socialMedia.setUserName(user.getScreenName());
		
		socialMedia.setSocialMediaNetworkId(socialMediaNetworkId);
		socialMedia.setSocialURL(socialURL);
		socialMedia.setClassName(className);
		socialMedia.setClassPK(classPK);
		
		return super.addSocialMedia(socialMedia);
	}
	
	public SocialMedia updateSocialMedia(long socialMediaId, String socialURL, ServiceContext serviceContext) 
			throws PortalException {

		SocialMedia socialMedia = getSocialMedia(socialMediaId);
		
		socialMedia.setModifiedDate(new Date());
		
		socialMedia.setSocialURL(socialURL);
		
		super.updateSocialMedia(socialMedia);
		
		return socialMedia;
	}
	
	public List<SocialMedia> getSocialMediaNetworksByGroupId(long groupId) {
		return socialMediaPersistence.findByGroupId(groupId);
	}
	
	public List<SocialMedia> getSocialMediaNetworksByGroupId(long groupId, int start, int end) {
		return socialMediaPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<SocialMedia> getSocialMediaNetworksByGroupId(long groupId, int start, int end, 
			OrderByComparator<SocialMedia> orderByComparator) {
		return socialMediaPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<SocialMedia> getSocialMediaNetworksByGroupIdAndClass(long groupId, String className, long classPK) {
		return socialMediaPersistence.findByGroupIdAndClassNameAndClassPK(groupId, className, classPK);
	}
	
	public SocialMedia getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
			long groupId, String className, long classPK, long socialMediaNetworkId) throws NoSuchSocialMediaException {
		return socialMediaPersistence.findByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				groupId, className, classPK, socialMediaNetworkId);
	}
	
	public List<SocialMedia> getSocialMedias(long socialMediaNetworkId){
		return socialMediaPersistence.findBySocialMediaNetworkId(socialMediaNetworkId);
	}
	
	@Override
	public SocialMedia addSocialMedia(SocialMedia offer) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Override
	public SocialMedia updateSocialMedia(SocialMedia offer) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Reference
	GroupLocalService groupLocalService;
	
	@Reference
	SocialMediaNetworkLocalService socialMediaNetworkLocalService;
}