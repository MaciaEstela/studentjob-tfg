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
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.Degree;

import java.util.List;
import java.util.Map;

/**
 * Provides the remote service utility for Degree. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.DegreeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeService
 * @generated
 */
public class DegreeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.DegreeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Degree addDegree(
			long groupId, Map<java.util.Locale, String> nameMap,
			List<Long> degreeAreasIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDegree(
			groupId, nameMap, degreeAreasIds, serviceContext);
	}

	public static Degree deleteDegree(long degreeId) throws PortalException {
		return getService().deleteDegree(degreeId);
	}

	public static Degree getDegree(long degreeId) throws PortalException {
		return getService().getDegree(degreeId);
	}

	public static List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByDegreeId(long degreeId) {

		return getService().getDegreeAreasByDegreeId(degreeId);
	}

	public static List<Long> getDegreeAreasIdsByDegreeId(long degreeId) {
		return getService().getDegreeAreasIdsByDegreeId(degreeId);
	}

	public static List<Degree> getDegreesByGroupId(long groupId) {
		return getService().getDegreesByGroupId(groupId);
	}

	public static List<Degree> getDegreesByGroupId(
		long groupId, int start, int end) {

		return getService().getDegreesByGroupId(groupId, start, end);
	}

	public static List<Degree> getDegreesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getService().getDegreesByGroupId(
			groupId, start, end, orderByComparator);
	}

	public static List<Degree> getDegreesByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getService().getDegreesByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public static long getDegreesCountByKeywords(
		long groupId, String keywords) {

		return getService().getDegreesCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Degree updateDegree(
			long degreeId, Map<java.util.Locale, String> nameMap,
			List<Long> degreeAreasIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDegree(
			degreeId, nameMap, degreeAreasIds, serviceContext);
	}

	public static DegreeService getService() {
		return _service;
	}

	private static volatile DegreeService _service;

}