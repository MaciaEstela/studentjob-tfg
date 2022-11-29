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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
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

import edu.uoc.mestemi.studentjob.exception.DegreeValidationException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.DegreeArea;
import edu.uoc.mestemi.studentjob.service.DegreeAreaLocalService;
import edu.uoc.mestemi.studentjob.service.base.DegreeLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=edu.uoc.mestemi.studentjob.model.Degree",
	service = AopService.class
)
public class DegreeLocalServiceImpl extends DegreeLocalServiceBaseImpl {
	
	public Degree addDegree(long groupId, Map<Locale, String> nameMap, List<Long> degreeAreasIds, ServiceContext serviceContext) throws PortalException {
		
		if (Validator.isNull(degreeAreasIds) && degreeAreasIds.isEmpty()) {
			throw new DegreeValidationException("Degree must have a DegreeArea associated");
		}
		
		// Get group and user
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);

		// Generate degree primary key
		long degreeId = counterLocalService.increment(Degree.class.getName());
		
		Degree degree = createDegree(degreeId);
		
		degree.setCompanyId(group.getCompanyId());
		degree.setGroupId(group.getGroupId());
		degree.setCreateDate(serviceContext.getCreateDate(new Date()));
		degree.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		degree.setUserId(userId);
		degree.setUserName(user.getScreenName());
		
		degree.setNameMap(nameMap);
		
		for (long degreeAreaId : degreeAreasIds) {
			addDegreeAreaDegree(degreeAreaId, degree);	
		}
		
		return super.addDegree(degree);
	}
	
	public Degree updateDegree(long degreeId, Map<Locale, String> nameMap, List<Long> degreeAreasIds, ServiceContext serviceContext) throws PortalException {
		
		Degree degree = getDegree(degreeId);
		
		degree.setModifiedDate(new Date());
		degree.setNameMap(nameMap);
		
		List<DegreeArea> degreeAreas = degreeAreaLocalService.getDegreeDegreeAreas(degreeId);
		
		for (DegreeArea degreeArea : degreeAreas)
			if (!degreeAreasIds.contains(degreeArea.getDegreeAreaId()))
				deleteDegreeAreaDegree(degreeArea.getDegreeAreaId(), degreeId);
		
		for (long degreeAreaId : degreeAreasIds)
			if (!hasDegreeAreaDegree(degreeAreaId, degreeId))
				addDegreeAreaDegree(degreeAreaId, degree);
		
		super.updateDegree(degree);
		
		return degree;
	}
	
	public List<Degree> getDegreesByGroupId(long groupId) {
		return degreePersistence.findByGroupId(groupId);
	}
	
	public List<Degree> getDegreesByGroupId(long groupId, int start, int end) {
		return degreePersistence.findByGroupId(groupId, start, end);
	}
	
	public List<Degree> getDegreesByGroupId(long groupId, int start, int end, 
			OrderByComparator<Degree> orderByComparator) {
		return degreePersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<Degree> getDegreesByKeywords(long groupId, String keywords, int start, 
			int end, OrderByComparator<Degree> orderByComparator) {
		return degreePersistence.findWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords), start, end, orderByComparator);
	}
	
	public long getDegreesCountByKeywords(long groupId, String keywords) {
		return degreePersistence.countWithDynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords));
	}
	
	public List<DegreeArea> getDegreeAreasByDegreeId(long degreeId){
		return degreeAreaPersistence.getDegreeDegreeAreas(degreeId);
	}
	
	public List<Long> getDegreeAreasIdsByDegreeId(long degreeId){
		List<DegreeArea> degreeAreas = getDegreeAreasByDegreeId(degreeId);
		List<Long> degreesIds = new ArrayList<>();
		
		for (DegreeArea degreeArea : degreeAreas)
			degreesIds.add(degreeArea.getDegreeAreaId());
		
		return degreesIds;
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
	
	public List<Degree> getDegreeAreaDegrees(long degreeAreaId, int start, int end, OrderByComparator<Degree> orderByComparator){
		return degreePersistence.getDegreeAreaDegrees(
				degreeAreaId, start, end, orderByComparator);
	}
	
//	public List<Degree> getDegreeAreaDegreesCount(long degreeAreaId, int start, int end, OrderByComparator<Degree> orderByComparator){
//		return degreePersistence.degreeAreas
//	}
	
//	public List<Degree> getDegreesByDegreeAreaId(String degreeAreaId)
//	{
//		Session session = degreePersistence.openSession();
//		SQLQuery query = session.createSQLQuery("select sdg.degreeId as degreeId from sjob_degree sdg inner join sjob_degrees_degreesareas sdd where sdg.degreeId = sdd.degreeId and sdd.degreeAreaId = ? LIMIT ? OFFSET ?");
//		query.addScalar("degreeId", Type.LONG);
//		QueryPos pos = QueryPos.getInstance(query);
//		pos.add(degreeAreaId);
//		
//		List<Long> list = query.list();
//		List<Degree> degrees = new ArrayList<>();
//		for (long degreeId : list) {
//			degrees.add(getDegree(degreeId));
//		}
//		
//		return degrees;
//	}
	
	@Override
	public Degree addDegree(Degree degree) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Override
	public Degree updateDegree(Degree degree) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Reference
	GroupLocalService groupLocalService;
	
	@Reference
	DegreeAreaLocalService degreeAreaLocalService;
}