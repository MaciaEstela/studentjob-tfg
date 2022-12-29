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
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.base.OfferServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sjob",
		"json.web.service.context.path=Offer"
	},
	service = AopService.class
)
public class OfferServiceImpl extends OfferServiceBaseImpl {
	
	public Offer addOffer(long groupId, long regionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String preference, 
			List<Long> degreeIds, ServiceContext serviceContext) throws PortalException {
		
		return offerLocalService.addOffer(groupId, regionId, titleMap, descriptionMap, preference, degreeIds, serviceContext);
	}
	
	public Offer updateOffer(long offerId, long regionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String preference, 
			List<Long> degreeIds, ServiceContext serviceContext) 
					throws PortalException {
		
		return offerLocalService.updateOffer(offerId, regionId, titleMap, descriptionMap, preference, degreeIds, serviceContext);
	}
	
	public Offer deleteOffer(long offerId) throws PortalException {
		return offerLocalService.deleteOffer(offerId);
	}
	
	public Offer getOffer(long offerId) throws PortalException {
		return offerLocalService.getOffer(offerId);
	}
	
	public List<Offer> getOffersByGroupId(long groupId) {
		return offerLocalService.getOffersByGroupId(groupId);
	}
	
	public List<Offer> getOffersByGroupId(long groupId, int start, int end) {
		return offerLocalService.getOffersByGroupId(groupId, start, end);
	}
	
	public List<Long> getDegreesIdsByOfferId(long offerId){
		return offerLocalService.getDegreesIdsByOfferId(offerId);
	}
	
	public List<Degree> getDegreesByOfferId(long offerId){
		return offerLocalService.getDegreesByOfferId(offerId);
	}
	
	public List<Offer> getOffersByGroupId(long groupId, int start, int end, 
			OrderByComparator<Offer> orderByComparator) {
		return offerLocalService.getOffersByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<Offer> getOffersByKeywords(long groupId, long userId, String keywords, int workflowStatus, int start, 
			int end, OrderByComparator<Offer> orderByComparator) {
		return offerLocalService.getOffersByKeywords(groupId, userId, keywords, workflowStatus, start, end, orderByComparator);
	}
	
	public long getOffersCountByKeywords(long groupId, long userId, String keywords, int workflowStatus) {
		return offerLocalService.getOffersCountByKeywords(groupId, userId, keywords, workflowStatus);
	}
	
	public List<Offer> getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(long groupId, long userId, String keywords, String preference,
			long regionId, long degreeId, int workflowStatus, long newestId, int start, 
			int end, OrderByComparator<Offer> orderByComparator) {
		return offerLocalService.getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(groupId, userId, keywords, 
				preference, regionId, degreeId, workflowStatus, newestId, start, end, orderByComparator);
	}
	
	public long getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(long groupId, long userId, String keywords, String preference,
			long regionId, long degreeId, int workflowStatus, long newestId) {
		return offerLocalService.getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(groupId, userId,
				keywords, preference, regionId, degreeId, workflowStatus, newestId);
	}
	
	public long getNewestOfferId() {
		return offerLocalService.getNewestOfferId();
	}
	
	@Override
	public Offer addOffer(Offer offer) {
		return offerLocalService.addOffer(offer);
	}
	
	@Override
	public Offer updateOffer(Offer offer) {
		return offerLocalService.updateOffer(offer);
	}
	
	public Offer expireOffer(Offer offer) {
		return offerLocalService.expireOffer(offer);
	}
	
	public Offer expireOffer(long offerId) {
		try {
			return offerLocalService.expireOffer(offerId);
		} catch (Exception e) {
			return null;
		}
	}
	
}