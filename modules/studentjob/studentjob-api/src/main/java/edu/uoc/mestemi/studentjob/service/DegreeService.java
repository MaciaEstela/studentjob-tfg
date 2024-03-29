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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.DegreeArea;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Degree. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DegreeService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.DegreeServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the degree remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DegreeServiceUtil} if injection and service tracking are not available.
	 */
	public Degree addDegree(
			long groupId, Map<Locale, String> nameMap,
			List<Long> degreeAreasIds, ServiceContext serviceContext)
		throws PortalException;

	public Degree deleteDegree(long degreeId) throws PortalException;

	public Degree deleteDegreeWithValidation(long degreeId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Degree getDegree(long degreeId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeAreasByDegreeId(long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getDegreeAreasIdsByDegreeId(long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByGroupId(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Degree> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Degree> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getDegreesCountByKeywords(long groupId, String keywords);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Degree updateDegree(
			long degreeId, Map<Locale, String> nameMap,
			List<Long> degreeAreasIds, ServiceContext serviceContext)
		throws PortalException;

}