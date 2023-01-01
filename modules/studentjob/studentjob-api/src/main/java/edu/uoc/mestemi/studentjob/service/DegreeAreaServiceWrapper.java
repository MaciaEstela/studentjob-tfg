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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DegreeAreaService}.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeAreaService
 * @generated
 */
public class DegreeAreaServiceWrapper
	implements DegreeAreaService, ServiceWrapper<DegreeAreaService> {

	public DegreeAreaServiceWrapper() {
		this(null);
	}

	public DegreeAreaServiceWrapper(DegreeAreaService degreeAreaService) {
		_degreeAreaService = degreeAreaService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea addDegreeArea(
			long groupId, java.util.Map<java.util.Locale, String> nameMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaService.addDegreeArea(
			groupId, nameMap, serviceContext);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea deleteDegreeArea(
			long degreeAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaService.deleteDegreeArea(degreeAreaId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea
			deleteDegreeAreaWithValidation(long degreeAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaService.deleteDegreeAreaWithValidation(degreeAreaId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getCompanyProfilesByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.DegreeArea>
					orderByComparator) {

		return _degreeAreaService.getCompanyProfilesByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea getDegreeArea(
			long degreeAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaService.getDegreeArea(degreeAreaId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByGroupId(long groupId) {

		return _degreeAreaService.getDegreeAreasByGroupId(groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByGroupId(long groupId, int start, int end) {

		return _degreeAreaService.getDegreeAreasByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.DegreeArea>
					orderByComparator) {

		return _degreeAreaService.getDegreeAreasByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public long getDegreeAreasCountByKeywords(long groupId, String keywords) {
		return _degreeAreaService.getDegreeAreasCountByKeywords(
			groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _degreeAreaService.getOSGiServiceIdentifier();
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea updateDegreeArea(
			long degreeAreaId, java.util.Map<java.util.Locale, String> nameMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaService.updateDegreeArea(
			degreeAreaId, nameMap, serviceContext);
	}

	@Override
	public DegreeAreaService getWrappedService() {
		return _degreeAreaService;
	}

	@Override
	public void setWrappedService(DegreeAreaService degreeAreaService) {
		_degreeAreaService = degreeAreaService;
	}

	private DegreeAreaService _degreeAreaService;

}