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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.model.DegreeArea;
import edu.uoc.mestemi.studentjob.service.base.DegreeAreaServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sjob",
		"json.web.service.context.path=DegreeArea"
	},
	service = AopService.class
)
public class DegreeAreaServiceImpl extends DegreeAreaServiceBaseImpl {
	
	public DegreeArea addDegreeArea(long groupId, Map<Locale, String> nameMap, 
			ServiceContext serviceContext) throws PortalException {
		
		return degreeAreaLocalService.addDegreeArea(groupId, nameMap, serviceContext);
	}
	
	public DegreeArea updateDegreeArea(long degreeAreaId, Map<Locale, String> nameMap, 
			ServiceContext serviceContext) throws PortalException {

		return degreeAreaLocalService.updateDegreeArea(degreeAreaId, nameMap, serviceContext);
	}
	
	public DegreeArea deleteDegreeArea(long degreeAreaId) throws PortalException {
		return degreeAreaLocalService.deleteDegreeArea(degreeAreaId);
	}
	
	public DegreeArea deleteDegreeAreaWithValidation(long degreeAreaId) throws PortalException {
		return degreeAreaLocalService.deleteDegreeAreaWithValidation(degreeAreaId);
	}
	
	public DegreeArea getDegreeArea(long degreeAreaId) throws PortalException {
		return degreeAreaLocalService.getDegreeArea(degreeAreaId);
	}
	
	public List<DegreeArea> getDegreeAreasByGroupId(long groupId) {
		return degreeAreaLocalService.getDegreeAreasByGroupId(groupId);
	}
	
	public List<DegreeArea> getDegreeAreasByGroupId(long groupId, int start, int end) {
		return degreeAreaLocalService.getDegreeAreasByGroupId(groupId, start, end);
	}
	
	public List<DegreeArea> getCompanyProfilesByGroupId(long groupId, int start, int end, 
			OrderByComparator<DegreeArea> orderByComparator) {
		return degreeAreaLocalService.getCompanyProfilesByGroupId(groupId, start, end, orderByComparator);
	}
	
	public List<DegreeArea> getDegreeAreasByKeywords(long groupId, String keywords, int start, 
			int end, OrderByComparator<DegreeArea> orderByComparator) {
		return degreeAreaLocalService.getDegreeAreasByKeywords(groupId, keywords, start, end, orderByComparator);
	}
	
	public long getDegreeAreasCountByKeywords(long groupId, String keywords) {
		return degreeAreaLocalService.getDegreeAreasCountByKeywords(groupId, keywords);
	}

}