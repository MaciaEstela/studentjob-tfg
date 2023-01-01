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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.service.base.CompanyProfileServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sjob",
		"json.web.service.context.path=CompanyProfile"
	},
	service = AopService.class
)
public class CompanyProfileServiceImpl extends CompanyProfileServiceBaseImpl {
	
	public CompanyProfile addCompanyProfile(long groupId, long userId, long regionId, boolean active, 
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, 
			Map<Locale, String> sectorMap, String website, List<SocialMedia> socialMedias, 
			ServiceContext serviceContext) throws PortalException {
		
		return companyProfileLocalService.addCompanyProfile(groupId, userId,
				regionId, active, titleMap, descriptionMap, email, sectorMap, website, socialMedias, serviceContext);
	}
	
	public CompanyProfile updateCompanyProfile(long companyProfileId, long regionId, boolean active, 
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, 
			Map<Locale, String> sectorMap, String website, ServiceContext serviceContext) 
					throws PortalException {
		
		return companyProfileLocalService.updateCompanyProfile(companyProfileId, 
				regionId, active, titleMap, descriptionMap, email, sectorMap, website, serviceContext);
	}
	
	public CompanyProfile deleteCompanyProfile(long companyProfileId) throws PortalException {
		return companyProfileLocalService.deleteCompanyProfile(companyProfileId);
	}
	
	public List<CompanyProfile> getCompanyProfilesByGroupIdAndActive(long groupId, boolean active) {
		return companyProfileLocalService.getCompanyProfilesByGroupIdAndActive(groupId, active);
	}
	
	public CompanyProfile getCompanyProfileByGroupIdAndUserId(long groupId, long userId) {
		return companyProfileLocalService.getCompanyProfileByGroupIdAndUserId(groupId, userId);
	}
	
	public CompanyProfile getCompanyProfile(long companyProfileId) throws PortalException {
		return companyProfileLocalService.getCompanyProfile(companyProfileId);
	}
	
	public List<CompanyProfile> getCompanyProfilesByGroupId(long groupId) {
		return companyProfileLocalService.getCompanyProfilesByGroupId(groupId);
	}
	
	public List<CompanyProfile> getCompanyProfilesByGroupId(long groupId, int start, int end) {
		return companyProfileLocalService.getCompanyProfilesByGroupId(groupId, start, end);
	}
	
	public long getNewestCompanyProfileId() {
		return companyProfileLocalService.getNewestCompanyProfileId();
	}
	
	public List<CompanyProfile> getCompanyProfilesByGroupId(long groupId, int start, int end, 
			OrderByComparator<CompanyProfile> orderByComparator) {
		return companyProfileLocalService.getCompanyProfilesByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<CompanyProfile> getCompanyProfilesByKeywords(long groupId, String keywords, boolean onlyActives, int start, 
			int end, OrderByComparator<CompanyProfile> orderByComparator) {
		return companyProfileLocalService.getCompanyProfilesByKeywords(
				groupId, keywords, onlyActives, start, end, orderByComparator);
	}
	
	public long getCompanyProfilesCountByKeywords(long groupId, String keywords, boolean onlyActives) {
		return companyProfileLocalService.getCompanyProfilesCountByKeywords(
				groupId, keywords, onlyActives);
	}
}