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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.model.DegreeArea;
import edu.uoc.mestemi.studentjob.service.base.DegreeAreaLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	property = "model.class.name=edu.uoc.mestemi.studentjob.model.DegreeArea",
	service = AopService.class
)
public class DegreeAreaLocalServiceImpl extends DegreeAreaLocalServiceBaseImpl {
	
	public DegreeArea addDegreeArea(long groupId, Map<Locale, String> nameMap, ServiceContext serviceContext) throws PortalException {
		
		// Get group and user
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		
		// Generate companyprofile primary key
		long degreeAreaId = counterLocalService.increment(DegreeArea.class.getName());
		
		DegreeArea degreeArea = createDegreeArea(degreeAreaId);
		
		degreeArea.setCompanyId(group.getCompanyId());
		degreeArea.setGroupId(group.getGroupId());
		degreeArea.setCreateDate(serviceContext.getCreateDate(new Date()));
		degreeArea.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		degreeArea.setUserId(userId);
		degreeArea.setUserName(user.getScreenName());
		
		degreeArea.setNameMap(nameMap);
		
		return super.addDegreeArea(degreeArea);
	}
	
	public DegreeArea updateDegreeArea(long degreeAreaId, Map<Locale, String> nameMap, ServiceContext serviceContext) throws PortalException {
		
		DegreeArea degreeArea = getDegreeArea(degreeAreaId);
		
		degreeArea.setModifiedDate(new Date());
		degreeArea.setNameMap(nameMap);
		
		super.updateDegreeArea(degreeArea);
		
		return degreeArea;
	}
	
	public List<DegreeArea> getDegreeAreasByGroupId(long groupId) {
		return degreeAreaPersistence.findByGroupId(groupId);
	}
	
	public List<DegreeArea> getDegreeAreasByGroupId(long groupId, int start, int end) {
		return degreeAreaPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<DegreeArea> getCompanyProfilesByGroupId(long groupId, int start, int end, 
			OrderByComparator<DegreeArea> orderByComparator) {
		return degreeAreaPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<DegreeArea> getDegreeAreasByKeywords(long groupId, String keywords, int start, 
			int end, OrderByComparator<DegreeArea> orderByComparator) {
		return degreeAreaPersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords), start, end, orderByComparator);
	}
	
	public long getDegreeAreasCountByKeywords(long groupId, String keywords) {
		return degreeAreaPersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords));
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			
			disjunctionQuery.add(RestrictionsFactoryUtil.like("name", "%" + keywords + "%"));
			
			dynamicQuery.add(disjunctionQuery);
		}
		
		return dynamicQuery;
	}
	
	@Override
	public DegreeArea addDegreeArea(DegreeArea degreeArea) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Override
	public DegreeArea updateDegreeArea(DegreeArea degreeArea) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Reference
	GroupLocalService groupLocalService;
}