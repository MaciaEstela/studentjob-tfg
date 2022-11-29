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
 * Provides a wrapper for {@link DegreeService}.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeService
 * @generated
 */
public class DegreeServiceWrapper
	implements DegreeService, ServiceWrapper<DegreeService> {

	public DegreeServiceWrapper() {
		this(null);
	}

	public DegreeServiceWrapper(DegreeService degreeService) {
		_degreeService = degreeService;
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Degree addDegree(
			long groupId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.List<Long> degreeAreasIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeService.addDegree(
			groupId, nameMap, degreeAreasIds, serviceContext);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Degree deleteDegree(long degreeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeService.deleteDegree(degreeId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Degree getDegree(long degreeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeService.getDegree(degreeId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByDegreeId(long degreeId) {

		return _degreeService.getDegreeAreasByDegreeId(degreeId);
	}

	@Override
	public java.util.List<Long> getDegreeAreasIdsByDegreeId(long degreeId) {
		return _degreeService.getDegreeAreasIdsByDegreeId(degreeId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByGroupId(long groupId) {

		return _degreeService.getDegreesByGroupId(groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByGroupId(long groupId, int start, int end) {

		return _degreeService.getDegreesByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Degree> orderByComparator) {

		return _degreeService.getDegreesByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Degree> orderByComparator) {

		return _degreeService.getDegreesByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public long getDegreesCountByKeywords(long groupId, String keywords) {
		return _degreeService.getDegreesCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _degreeService.getOSGiServiceIdentifier();
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Degree updateDegree(
			long degreeId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.List<Long> degreeAreasIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeService.updateDegree(
			degreeId, nameMap, degreeAreasIds, serviceContext);
	}

	@Override
	public DegreeService getWrappedService() {
		return _degreeService;
	}

	@Override
	public void setWrappedService(DegreeService degreeService) {
		_degreeService = degreeService;
	}

	private DegreeService _degreeService;

}