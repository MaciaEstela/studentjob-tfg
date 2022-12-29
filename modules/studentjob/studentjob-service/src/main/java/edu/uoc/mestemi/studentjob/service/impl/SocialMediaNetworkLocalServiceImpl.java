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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.DegreeLocalService;
import edu.uoc.mestemi.studentjob.service.SocialMediaLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.base.SocialMediaNetworkLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	property = "model.class.name=edu.uoc.mestemi.studentjob.model.SocialMediaNetwork",
	service = AopService.class
)
public class SocialMediaNetworkLocalServiceImpl
	extends SocialMediaNetworkLocalServiceBaseImpl {
	
	public SocialMediaNetwork addSocialMediaNetwork(long groupId, String name, long logo, String baseURL, ServiceContext serviceContext) throws PortalException {
		
		// Get group and user
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);

		// Generate degree primary key
		long socialMediaNetworkId = counterLocalService.increment(SocialMediaNetwork.class.getName());
		
		SocialMediaNetwork socialMediaNetwork = createSocialMediaNetwork(socialMediaNetworkId);
		
		socialMediaNetwork.setCompanyId(group.getCompanyId());
		socialMediaNetwork.setGroupId(group.getGroupId());
		socialMediaNetwork.setCreateDate(serviceContext.getCreateDate(new Date()));
		socialMediaNetwork.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		socialMediaNetwork.setUserId(userId);
		socialMediaNetwork.setUserName(user.getScreenName());
		
		socialMediaNetwork.setName(name);
		socialMediaNetwork.setLogo(logo);
		socialMediaNetwork.setBaseURL(baseURL);
		
		return super.addSocialMediaNetwork(socialMediaNetwork);
	}
	
	public SocialMediaNetwork updateSocialMediaNetwork(long socialMediaNetworkId, String name, long logo, String baseURL, ServiceContext serviceContext) 
					throws PortalException {
		
		SocialMediaNetwork socialMediaNetwork = getSocialMediaNetwork(socialMediaNetworkId);
		
		socialMediaNetwork.setModifiedDate(new Date());
		
		socialMediaNetwork.setName(name);
		socialMediaNetwork.setLogo(logo);
		socialMediaNetwork.setBaseURL(baseURL);
		
		super.updateSocialMediaNetwork(socialMediaNetwork);
		
		return socialMediaNetwork;
	}
	
	
	public List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(long groupId) {
		return socialMediaNetworkPersistence.findByGroupId(groupId);
	}
	
	public List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(long groupId, int start, int end) {
		return socialMediaNetworkPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(long groupId, int start, int end, 
			OrderByComparator<SocialMediaNetwork> orderByComparator) {
		return socialMediaNetworkPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<SocialMediaNetwork> getSocialMediaNetworksByKeywords(long groupId, String keywords, int start, 
			int end, OrderByComparator<SocialMediaNetwork> orderByComparator) {
		return socialMediaNetworkPersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords), start, end, orderByComparator);
	}
	
	public long getSocialMediaNetworksCountByKeywords(long groupId, String keywords) {
		return socialMediaNetworkPersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords));
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			
			disjunctionQuery.add(RestrictionsFactoryUtil.like("name", "%" + keywords + "%"));
			
			dynamicQuery.add(disjunctionQuery);
		}
		
		return dynamicQuery;
	}
	
	@Override
	public SocialMediaNetwork addSocialMediaNetwork(SocialMediaNetwork smn) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Override
	public SocialMediaNetwork updateSocialMediaNetwork(SocialMediaNetwork smn) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Override
	public SocialMediaNetwork deleteSocialMediaNetwork(SocialMediaNetwork socialMediaNetwork) {
		List<SocialMedia> socialMedias = SocialMediaLocalServiceUtil.getSocialMedias(socialMediaNetwork.getSocialMediaNetworkId());
		
		for (SocialMedia socialMedia : socialMedias) {
			SocialMediaLocalServiceUtil.deleteSocialMedia(socialMedia);
		}
		
		return super.deleteSocialMediaNetwork(socialMediaNetwork);
	}
	
	@Override
	public SocialMediaNetwork deleteSocialMediaNetwork(long socialMediaNetworkId) throws PortalException {
		SocialMediaNetwork socialMediaNetwork = getSocialMediaNetwork(socialMediaNetworkId);
		return deleteSocialMediaNetwork(socialMediaNetwork);
	}



	@Reference
	GroupLocalService groupLocalService;
	
	@Reference
	DegreeLocalService degreeLocalService;
}