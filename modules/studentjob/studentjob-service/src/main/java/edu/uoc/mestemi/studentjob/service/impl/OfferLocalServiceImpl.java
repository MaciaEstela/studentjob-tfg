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
	
	public List<Offer> getOffersByKeywords(long groupId, String keywords, int start, 
			int end, OrderByComparator<Offer> orderByComparator) {
		return offerPersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords), start, end, orderByComparator);
	}
	
	public long getOffersCountByKeywords(long groupId, String keywords) {
		return offerPersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords));
	}
	
	public List<Offer> getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(long groupId, String keywords, String preference,
			long regionId, long degreeId, long newestId, int start, int end, OrderByComparator<Offer> orderByComparator) {
		return offerPersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords, preference, regionId, degreeId, newestId), start, end, orderByComparator);
	}
	
	public long getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(long groupId, String keywords, String preference,
			long regionId, long degreeId, long newestId) {
		return offerPersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords, preference, regionId, degreeId, newestId));
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			
			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			
			dynamicQuery.add(disjunctionQuery);
		}
		
		return dynamicQuery;
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords, 
			String preference, long regionId, long degreeId, long newestId) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
		Conjunction conjunctionQuery = RestrictionsFactoryUtil.conjunction();
		
		if (Validator.isNotNull(keywords)) {
			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			conjunctionQuery.add(disjunctionQuery);
		}
		
		if (Validator.isNotNull(newestId) && newestId != 0) {
			System.out.println("newestID es " + newestId);
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
	
	@Reference
	GroupLocalService groupLocalService;
	
	@Reference
	DegreeLocalService degreeLocalService;

}