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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.CompanyProfile;

import java.util.List;
import java.util.Map;

/**
 * Provides the remote service utility for CompanyProfile. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.CompanyProfileServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CompanyProfileService
 * @generated
 */
public class CompanyProfileServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.CompanyProfileServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static CompanyProfile addCompanyProfile(
			long groupId, long userId, long regionId, boolean active,
			Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, String email,
			Map<java.util.Locale, String> sectorMap, String website,
			List<edu.uoc.mestemi.studentjob.model.SocialMedia> socialMedias,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addCompanyProfile(
			groupId, userId, regionId, active, titleMap, descriptionMap, email,
			sectorMap, website, socialMedias, serviceContext);
	}

	public static CompanyProfile deleteCompanyProfile(long companyProfileId)
		throws PortalException {

		return getService().deleteCompanyProfile(companyProfileId);
	}

	public static CompanyProfile getCompanyProfile(long companyProfileId)
		throws PortalException {

		return getService().getCompanyProfile(companyProfileId);
	}

	public static CompanyProfile getCompanyProfileByGroupIdAndUserId(
		long groupId, long userId) {

		return getService().getCompanyProfileByGroupIdAndUserId(
			groupId, userId);
	}

	public static List<CompanyProfile> getCompanyProfilesByGroupId(
		long groupId) {

		return getService().getCompanyProfilesByGroupId(groupId);
	}

	public static List<CompanyProfile> getCompanyProfilesByGroupId(
		long groupId, int start, int end) {

		return getService().getCompanyProfilesByGroupId(groupId, start, end);
	}

	public static List<CompanyProfile> getCompanyProfilesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getService().getCompanyProfilesByGroupId(
			groupId, start, end, orderByComparator);
	}

	public static List<CompanyProfile> getCompanyProfilesByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getService().getCompanyProfilesByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public static long getCompanyProfilesCountByKeywords(
		long groupId, String keywords) {

		return getService().getCompanyProfilesCountByKeywords(
			groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CompanyProfile updateCompanyProfile(
			long companyProfileId, long regionId, boolean active,
			Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, String email,
			Map<java.util.Locale, String> sectorMap, String website,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateCompanyProfile(
			companyProfileId, regionId, active, titleMap, descriptionMap, email,
			sectorMap, website, serviceContext);
	}

	public static CompanyProfileService getService() {
		return _service;
	}

	private static volatile CompanyProfileService _service;

}