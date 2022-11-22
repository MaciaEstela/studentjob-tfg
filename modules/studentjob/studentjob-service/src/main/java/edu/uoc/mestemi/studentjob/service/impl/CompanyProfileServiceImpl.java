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

import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.model.CompanyProfile;
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
	
	public CompanyProfile addCompanyProfile(long groupId, long regionId, boolean active, 
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, 
			Map<Locale, String> sectorMap, String website, ServiceContext serviceContext) throws PortalException {
		
		return companyProfileLocalService.addCompanyProfile(groupId, 
				regionId, active, titleMap, descriptionMap, email, sectorMap, website, serviceContext);
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
	
	public CompanyProfile getCompanyProfile(long companyProfileId) throws PortalException {
		return companyProfileLocalService.getCompanyProfile(companyProfileId);
	}
	
}