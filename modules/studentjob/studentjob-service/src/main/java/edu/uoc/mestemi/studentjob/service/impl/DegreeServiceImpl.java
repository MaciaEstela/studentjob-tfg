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

import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.service.base.DegreeServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sjob",
		"json.web.service.context.path=Degree"
	},
	service = AopService.class
)
public class DegreeServiceImpl extends DegreeServiceBaseImpl {
	
	public Degree addDegree(long groupId, Map<Locale, String> nameMap, List<Long> degreeAreasIds, 
			ServiceContext serviceContext) throws PortalException {
		
		return degreeLocalService.addDegree(groupId, nameMap, degreeAreasIds, serviceContext);
	}
	
	public Degree updateDegree(long degreeId, Map<Locale, String> nameMap, List<Long> degreeAreasIds, 
			ServiceContext serviceContext) throws PortalException { 

		return degreeLocalService.updateDegree(degreeId, nameMap, degreeAreasIds, serviceContext);
	}
	
	public Degree deleteDegree(long degreeId) throws PortalException {
		return degreeLocalService.deleteDegree(degreeId);
	}
	
	public Degree getDegree(long degreeId) throws PortalException {
		return degreeLocalService.getDegree(degreeId);
	}
	
}