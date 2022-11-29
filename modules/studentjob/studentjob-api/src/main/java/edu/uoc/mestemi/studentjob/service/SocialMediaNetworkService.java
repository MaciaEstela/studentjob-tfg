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

import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for SocialMediaNetwork. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaNetworkServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SocialMediaNetworkService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.SocialMediaNetworkServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the social media network remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SocialMediaNetworkServiceUtil} if injection and service tracking are not available.
	 */
	public SocialMediaNetwork addSocialMediaNetwork(
			long groupId, String name, long logo, String baseURL,
			ServiceContext serviceContext)
		throws PortalException;

	public SocialMediaNetwork deleteSocialMediaNetwork(
			long socialMediaNetworkId)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SocialMediaNetwork getSocialMediaNetwork(long socialMediaNetworkId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SocialMediaNetwork> getSocialMediaNetworksByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SocialMediaNetwork> getSocialMediaNetworksByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<SocialMediaNetwork> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getSocialMediaNetworksCountByKeywords(
		long groupId, String keywords);

	public SocialMediaNetwork updateSocialMediaNetwork(
			long socialMediaNetworkId, String name, long logo, String baseURL,
			ServiceContext serviceContext)
		throws PortalException;

}