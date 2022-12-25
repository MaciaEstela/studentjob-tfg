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

import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.exception.OfferValidationException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.DegreeLocalService;
import edu.uoc.mestemi.studentjob.service.base.OfferLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	property = "model.class.name=edu.uoc.mestemi.studentjob.model.Offer",
	service = AopService.class
)
public class OfferLocalServiceImpl extends OfferLocalServiceBaseImpl {
	
	public Offer addOffer(long groupId, long regionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String preference, 
			List<Long> degreeIds, ServiceContext serviceContext) throws PortalException {
		
		if (Validator.isNull(degreeIds) && degreeIds.isEmpty()) {
			throw new OfferValidationException("Offer must have a degrees associated");
		}
		
		// Get group and user
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);

		// Generate degree primary key
		long offerId = counterLocalService.increment(Offer.class.getName());
		
		Offer offer = createOffer(offerId);
		
		offer.setGroupId(group.getGroupId());
		offer.setCompanyId(group.getCompanyId());
		offer.setCreateDate(serviceContext.getCreateDate(new Date()));
		offer.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		offer.setUserId(userId);
		offer.setUserName(user.getScreenName());
		
		offer.setTitleMap(titleMap);
		offer.setRegionId(regionId);
		offer.setPreference(preference);
		offer.setDescriptionMap(descriptionMap);
		offer.setStatus(WorkflowConstants.STATUS_APPROVED);
		
		for (long degreeId : degreeIds) {
			addDegreeOffer(degreeId, offerId);
		}
		
		return super.addOffer(offer);
	}
	
	public Offer updateOffer(long offerId, long regionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String preference, 
			List<Long> degreeIds, ServiceContext serviceContext) 
					throws PortalException {
		
		Offer offer = getOffer(offerId);
		
		offer.setModifiedDate(new Date());
		
		offer.setTitleMap(titleMap);
		offer.setRegionId(regionId);
		offer.setPreference(preference);
		offer.setDescriptionMap(descriptionMap);
		
		List<Degree> degrees = degreeLocalService.getOfferDegrees(offerId);
		for (Degree degree : degrees)
			if (!degreeIds.contains(degree.getDegreeId()))
				deleteDegreeOffer(degree.getDegreeId(), offerId);
		
		for (long degreeId : degreeIds)
			if (!hasDegreeOffer(degreeId, offerId))
				addDegreeOffer(degreeId, offerId);
		
		offer = super.updateOffer(offer);
		
		return offer;
	}
	
	public List<Offer> getOffersByGroupId(long groupId) {
		return offerPersistence.findByGroupId(groupId);
	}
	
	public List<Offer> getOffersByGroupId(long groupId, int start, int end) {
		return offerPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<Degree> getDegreesByOfferId(long offerId){
		return degreePersistence.getOfferDegrees(offerId);
	}
	
	public List<Long> getDegreesIdsByOfferId(long offerId){
		List<Degree> degrees = getDegreesByOfferId(offerId);
		List<Long> degreesIds = new ArrayList<>();
		
		for (Degree degree : degrees)
			degreesIds.add(degree.getDegreeId());
		
		return degreesIds;
	}
	
	public List<Offer> getOffersByGroupId(long groupId, int start, int end, 
			OrderByComparator<Offer> orderByComparator) {
		return offerPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<Offer> getOffersByKeywords(long groupId, long userId, String keywords, int workflowStatus, int start,  
			int end, OrderByComparator<Offer> orderByComparator) {
		return offerPersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, userId, keywords, workflowStatus), start, end, orderByComparator);
	}
	
	public long getOffersCountByKeywords(long groupId, long userId, String keywords, int workflowStatus) {
		return offerPersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, userId, keywords, workflowStatus));
	}
	
	public List<Offer> getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(long groupId, long userId, String keywords, String preference,
			long regionId, long degreeId, int workflowStatus, long newestId, int start, int end, OrderByComparator<Offer> orderByComparator) {
		return offerPersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, userId, keywords, preference, regionId, degreeId, workflowStatus, newestId), start, end, orderByComparator);
	}
	
	public long getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(long groupId, long userId, String keywords, String preference,
			long regionId, long degreeId, int workflowStatus, long newestId) {
		return offerPersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, userId, keywords, preference, regionId, degreeId, workflowStatus, newestId));
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, long userId, String keywords, int workflowStatus) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		
		if (userId != 0) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
		}
		
		if (workflowStatus != WorkflowConstants.STATUS_ANY) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("status", workflowStatus));
		}
		
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			
			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			
			dynamicQuery.add(disjunctionQuery);
		}
		
		return dynamicQuery;
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, long userId, String keywords, 
			String preference, long regionId, long degreeId, int workflowStatus, long newestId) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
		Conjunction conjunctionQuery = RestrictionsFactoryUtil.conjunction();
		
		if (userId != 0) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
		}
		
		if (workflowStatus != WorkflowConstants.STATUS_ANY) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("status", workflowStatus));
		}
		
		if (Validator.isNotNull(keywords)) {
			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			conjunctionQuery.add(disjunctionQuery);
		}
		
		if (Validator.isNotNull(newestId) && newestId != 0) {
			conjunctionQuery.add(RestrictionsFactoryUtil.le("offerId", newestId));
		}
		
		if (Validator.isNotNull(preference) && !preference.isEmpty()) {
			conjunctionQuery.add(RestrictionsFactoryUtil.like("preference", "%" + preference + "%"));
		}
		
		if (Validator.isNotNull(regionId) && regionId != 0) {
			conjunctionQuery.add(RestrictionsFactoryUtil.like("regionId", regionId));
		}
		
		if (Validator.isNotNull(degreeId) && degreeId != 0) {
			List<Offer> allOffersDegree = getDegreeOffers(degreeId);
			List<Long> offersIds = new ArrayList<>();
			
			for (Offer offer : allOffersDegree) {
				offersIds.add(offer.getOfferId());
			}
			
			conjunctionQuery.add(RestrictionsFactoryUtil.in("offerId", offersIds));
		}
		
		dynamicQuery.add(conjunctionQuery);
		
		return dynamicQuery;
	}
	
	@Override
	public Offer addOffer(Offer offer) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Override
	public Offer updateOffer(Offer offer) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	public Offer expireOffer(Offer offer) {
		offer.setStatus(WorkflowConstants.STATUS_EXPIRED);
		offerPersistence.update(offer);
		return offer;
	}
	
	public Offer expireOffer(long offerId) {
		try {
			Offer offer = getOffer(offerId);
			return expireOffer(offer);
		} catch (PortalException e) {
			return null;
		}
	}
	
	@Reference
	GroupLocalService groupLocalService;
	
	@Reference
	DegreeLocalService degreeLocalService;

}