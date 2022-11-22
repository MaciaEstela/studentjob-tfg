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
 * Provides a wrapper for {@link CompanyProfileService}.
 *
 * @author Brian Wing Shun Chan
 * @see CompanyProfileService
 * @generated
 */
public class CompanyProfileServiceWrapper
	implements CompanyProfileService, ServiceWrapper<CompanyProfileService> {

	public CompanyProfileServiceWrapper() {
		this(null);
	}

	public CompanyProfileServiceWrapper(
		CompanyProfileService companyProfileService) {

		_companyProfileService = companyProfileService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile addCompanyProfile(
			long groupId, long regionId, boolean active,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String email, java.util.Map<java.util.Locale, String> sectorMap,
			String website,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileService.addCompanyProfile(
			groupId, regionId, active, titleMap, descriptionMap, email,
			sectorMap, website, serviceContext);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile deleteCompanyProfile(
			long companyProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileService.deleteCompanyProfile(companyProfileId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile getCompanyProfile(
			long companyProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileService.getCompanyProfile(companyProfileId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _companyProfileService.getOSGiServiceIdentifier();
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile updateCompanyProfile(
			long companyProfileId, long regionId, boolean active,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String email, java.util.Map<java.util.Locale, String> sectorMap,
			String website,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileService.updateCompanyProfile(
			companyProfileId, regionId, active, titleMap, descriptionMap, email,
			sectorMap, website, serviceContext);
	}

	@Override
	public CompanyProfileService getWrappedService() {
		return _companyProfileService;
	}

	@Override
	public void setWrappedService(CompanyProfileService companyProfileService) {
		_companyProfileService = companyProfileService;
	}

	private CompanyProfileService _companyProfileService;

}