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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.SocialMedia;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for CompanyProfile. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CompanyProfileServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CompanyProfileService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.CompanyProfileServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the company profile remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CompanyProfileServiceUtil} if injection and service tracking are not available.
	 */
	public CompanyProfile addCompanyProfile(
			long groupId, long userId, long regionId, boolean active,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			String email, Map<Locale, String> sectorMap, String website,
			List<SocialMedia> socialMedias, ServiceContext serviceContext)
		throws PortalException;

	public CompanyProfile deleteCompanyProfile(long companyProfileId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CompanyProfile getCompanyProfile(long companyProfileId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CompanyProfile getCompanyProfileByGroupIdAndUserId(
		long groupId, long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CompanyProfile> getCompanyProfilesByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CompanyProfile> getCompanyProfilesByGroupId(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CompanyProfile> getCompanyProfilesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CompanyProfile> getCompanyProfilesByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getCompanyProfilesCountByKeywords(
		long groupId, String keywords);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public CompanyProfile updateCompanyProfile(
			long companyProfileId, long regionId, boolean active,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			String email, Map<Locale, String> sectorMap, String website,
			ServiceContext serviceContext)
		throws PortalException;

}