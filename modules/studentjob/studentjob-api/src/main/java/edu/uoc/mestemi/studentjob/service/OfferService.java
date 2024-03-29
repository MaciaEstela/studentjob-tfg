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

import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Offer. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see OfferServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OfferService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.OfferServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the offer remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link OfferServiceUtil} if injection and service tracking are not available.
	 */
	public Offer addOffer(
			long groupId, long regionId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String preference,
			List<Long> degreeIds, ServiceContext serviceContext)
		throws PortalException;

	public Offer addOffer(Offer offer);

	public Offer deleteOffer(long offerId) throws PortalException;

	public Offer expireOffer(long offerId);

	public Offer expireOffer(Offer offer);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByOfferId(long offerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getDegreesIdsByOfferId(long offerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getNewestOfferId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Offer getOffer(long offerId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByGroupId(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Offer> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByKeywords(
		long groupId, long userId, String keywords, int workflowStatus,
		int start, int end, OrderByComparator<Offer> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(
		long groupId, long userId, String keywords, String preference,
		long regionId, long degreeId, int workflowStatus, long newestId,
		int start, int end, OrderByComparator<Offer> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getOffersCountByKeywords(
		long groupId, long userId, String keywords, int workflowStatus);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
		long groupId, long userId, String keywords, String preference,
		long regionId, long degreeId, int workflowStatus, long newestId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Offer updateOffer(
			long offerId, long regionId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String preference,
			List<Long> degreeIds, ServiceContext serviceContext)
		throws PortalException;

	public Offer updateOffer(Offer offer);

}