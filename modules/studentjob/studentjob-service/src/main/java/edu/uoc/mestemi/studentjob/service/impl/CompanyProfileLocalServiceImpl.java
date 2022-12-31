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
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
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
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.service.SocialMediaLocalService;
import edu.uoc.mestemi.studentjob.service.base.CompanyProfileLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	property = "model.class.name=edu.uoc.mestemi.studentjob.model.CompanyProfile",
	service = AopService.class
)
public class CompanyProfileLocalServiceImpl
	extends CompanyProfileLocalServiceBaseImpl {
	
	public CompanyProfile addCompanyProfile(long groupId, long userId, long regionId, boolean active, 
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, 
			Map<Locale, String> sectorMap, String website, List<SocialMedia> socialMedias, 
			ServiceContext serviceContext) throws PortalException {
		
		// Get group and user
		Group group = groupLocalService.getGroup(groupId);
		User user = userLocalService.getUser(userId);
		
		// Generate companyprofile primary key
		long companyProfileId = counterLocalService.increment(CompanyProfile.class.getName());
		
		CompanyProfile companyProfile = createCompanyProfile(companyProfileId);
		
		companyProfile.setCompanyId(group.getCompanyId());
		companyProfile.setGroupId(group.getGroupId());
		companyProfile.setCreateDate(serviceContext.getCreateDate(new Date()));
		companyProfile.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		companyProfile.setUserId(userId);
		companyProfile.setUserName(user.getScreenName());
		
		companyProfile.setRegionId(regionId);
		companyProfile.setActive(active);
		companyProfile.setTitleMap(titleMap);
		companyProfile.setDescriptionMap(descriptionMap);
		companyProfile.setEmail(email);
		companyProfile.setSectorMap(sectorMap);
		companyProfile.setWebsite(website);

		for (SocialMedia socialMedia : socialMedias) {
			socialMediaLocalService.addSocialMedia(socialMedia);
		}
		
		return super.addCompanyProfile(companyProfile);
	}
	
	public CompanyProfile updateCompanyProfile(long companyProfileId, long regionId, boolean active, 
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, 
			Map<Locale, String> sectorMap, String website, ServiceContext serviceContext) 
					throws PortalException {
		
		CompanyProfile companyProfile = getCompanyProfile(companyProfileId);
		
		companyProfile.setModifiedDate(new Date());
		
		companyProfile.setRegionId(regionId);
		companyProfile.setActive(active);
		companyProfile.setTitleMap(titleMap);
		companyProfile.setDescriptionMap(descriptionMap);
		companyProfile.setEmail(email);
		companyProfile.setSectorMap(sectorMap);
		companyProfile.setWebsite(website);
		
		companyProfile = super.updateCompanyProfile(companyProfile);
		
		return companyProfile;
	}
	
	public List<CompanyProfile> getCompanyProfilesByGroupId(long groupId) {
		return companyProfilePersistence.findByGroupId(groupId);
	}
	
	public List<CompanyProfile> getCompanyProfilesByGroupId(long groupId, int start, int end) {
		return companyProfilePersistence.findByGroupId(groupId, start, end);
	}
	
	public List<CompanyProfile> getCompanyProfilesByGroupIdAndActive(long groupId, boolean active) {
		return companyProfilePersistence.findByGroupIdAndActive(groupId, active);
	}
	
	public CompanyProfile getCompanyProfileByGroupIdAndUserId(long groupId, long userId) {
		return companyProfilePersistence.findByGroupIdAndUserId(groupId, userId).get(0);
	}
	
	public List<CompanyProfile> getCompanyProfilesByGroupId(long groupId, int start, int end, 
			OrderByComparator<CompanyProfile> orderByComparator) {
		return companyProfilePersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<CompanyProfile> getCompanyProfilesByKeywords(long groupId, String keywords, boolean onlyActives, int start, 
			int end, OrderByComparator<CompanyProfile> orderByComparator) {
		return companyProfilePersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords, onlyActives), start, end, orderByComparator);
	}
	
	public long getCompanyProfilesCountByKeywords(long groupId, String keywords, boolean onlyActives) {
		return companyProfilePersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords, onlyActives));
	}
	
	public long getNewestCompanyProfileId() {
		long companyProfileId = 0;
		
		DynamicQuery latestCompanyDynamicQuery = dynamicQuery();
		
		Order order = OrderFactoryUtil.desc("createDate");
		latestCompanyDynamicQuery.addOrder(order);
		latestCompanyDynamicQuery.setLimit(0, 1);
		
		List<CompanyProfile> companies = dynamicQuery(latestCompanyDynamicQuery);
		
		
		if (!companies.isEmpty()) {
			companyProfileId = companies.get(0).getCompanyProfileId();
		}
		
		return companyProfileId;
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords, boolean onlyActives) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		
		if (onlyActives) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("active", true));
		}
		
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			
			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("sector", "%" + keywords + "%"));
			
			dynamicQuery.add(disjunctionQuery);
			
//			DynamicQuery dynamicUser = DynamicQueryFactoryUtil.forClass(User.class, User.class.getClassLoader());
//			Disjunction disjunctionQueryUser  = RestrictionsFactoryUtil.disjunction();
//			if (keywords.contains(" ")) {
//				String[] splittedKeywords = keywords.split(" ");
//				
//			}
		}
		
		return dynamicQuery;
	}
	
	@Override
	public CompanyProfile addCompanyProfile(CompanyProfile companyProfile) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Override
	public CompanyProfile updateCompanyProfile(CompanyProfile companyProfile) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Reference
	GroupLocalService groupLocalService;
	
	@Reference
	SocialMediaLocalService socialMediaLocalService;
}