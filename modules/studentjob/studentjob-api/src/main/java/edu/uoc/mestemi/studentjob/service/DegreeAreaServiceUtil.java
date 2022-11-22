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

import edu.uoc.mestemi.studentjob.model.DegreeArea;

import java.util.Map;

/**
 * Provides the remote service utility for DegreeArea. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.DegreeAreaServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeAreaService
 * @generated
 */
public class DegreeAreaServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.DegreeAreaServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static DegreeArea addDegreeArea(
			long groupId, Map<java.util.Locale, String> nameMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDegreeArea(groupId, nameMap, serviceContext);
	}

	public static DegreeArea deleteDegreeArea(long degreeAreaId)
		throws PortalException {

		return getService().deleteDegreeArea(degreeAreaId);
	}

	public static DegreeArea getDegreeArea(long degreeAreaId)
		throws PortalException {

		return getService().getDegreeArea(degreeAreaId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DegreeArea updateDegreeArea(
			long degreeAreaId, Map<java.util.Locale, String> nameMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDegreeArea(
			degreeAreaId, nameMap, serviceContext);
	}

	public static DegreeAreaService getService() {
		return _service;
	}

	private static volatile DegreeAreaService _service;

}