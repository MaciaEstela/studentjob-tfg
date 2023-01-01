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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.DegreeArea;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DegreeArea. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeAreaLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DegreeAreaLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.DegreeAreaLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the degree area local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DegreeAreaLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the degree area to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degreeArea the degree area
	 * @return the degree area that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DegreeArea addDegreeArea(DegreeArea degreeArea);

	public DegreeArea addDegreeArea(
			long groupId, Map<Locale, String> nameMap,
			ServiceContext serviceContext)
		throws PortalException;

	public void addDegreeDegreeArea(long degreeId, DegreeArea degreeArea);

	public void addDegreeDegreeArea(long degreeId, long degreeAreaId);

	public void addDegreeDegreeAreas(
		long degreeId, List<DegreeArea> degreeAreas);

	public void addDegreeDegreeAreas(long degreeId, long[] degreeAreaIds);

	public void clearDegreeDegreeAreas(long degreeId);

	/**
	 * Creates a new degree area with the primary key. Does not add the degree area to the database.
	 *
	 * @param degreeAreaId the primary key for the new degree area
	 * @return the new degree area
	 */
	@Transactional(enabled = false)
	public DegreeArea createDegreeArea(long degreeAreaId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the degree area from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degreeArea the degree area
	 * @return the degree area that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DegreeArea deleteDegreeArea(DegreeArea degreeArea);

	/**
	 * Deletes the degree area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area that was removed
	 * @throws PortalException if a degree area with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DegreeArea deleteDegreeArea(long degreeAreaId)
		throws PortalException;

	public DegreeArea deleteDegreeAreaWithValidation(long degreeAreaId)
		throws PortalException;

	public void deleteDegreeDegreeArea(long degreeId, DegreeArea degreeArea);

	public void deleteDegreeDegreeArea(long degreeId, long degreeAreaId);

	public void deleteDegreeDegreeAreas(
		long degreeId, List<DegreeArea> degreeAreas);

	public void deleteDegreeDegreeAreas(long degreeId, long[] degreeAreaIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DegreeArea fetchDegreeArea(long degreeAreaId);

	/**
	 * Returns the degree area matching the UUID and group.
	 *
	 * @param uuid the degree area's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DegreeArea fetchDegreeAreaByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getCompanyProfilesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator);

	/**
	 * Returns the degree area with the primary key.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area
	 * @throws PortalException if a degree area with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DegreeArea getDegreeArea(long degreeAreaId) throws PortalException;

	/**
	 * Returns the degree area matching the UUID and group.
	 *
	 * @param uuid the degree area's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree area
	 * @throws PortalException if a matching degree area could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DegreeArea getDegreeAreaByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the degree areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @return the range of degree areas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeAreas(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeAreasByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeAreasByGroupId(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeAreasByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator);

	/**
	 * Returns all the degree areas matching the UUID and company.
	 *
	 * @param uuid the UUID of the degree areas
	 * @param companyId the primary key of the company
	 * @return the matching degree areas, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeAreasByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of degree areas matching the UUID and company.
	 *
	 * @param uuid the UUID of the degree areas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of degree areas
	 * @param end the upper bound of the range of degree areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching degree areas, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeAreasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator);

	/**
	 * Returns the number of degree areas.
	 *
	 * @return the number of degree areas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDegreeAreasCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getDegreeAreasCountByKeywords(long groupId, String keywords);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeDegreeAreas(long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeDegreeAreas(
		long degreeId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeDegreeAreas(
		long degreeId, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDegreeDegreeAreasCount(long degreeId);

	/**
	 * Returns the degreeIds of the degrees associated with the degree area.
	 *
	 * @param degreeAreaId the degreeAreaId of the degree area
	 * @return long[] the degreeIds of degrees associated with the degree area
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getDegreePrimaryKeys(long degreeAreaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDegreeDegreeArea(long degreeId, long degreeAreaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDegreeDegreeAreas(long degreeId);

	public void setDegreeDegreeAreas(long degreeId, long[] degreeAreaIds);

	/**
	 * Updates the degree area in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degreeArea the degree area
	 * @return the degree area that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DegreeArea updateDegreeArea(DegreeArea degreeArea);

	public DegreeArea updateDegreeArea(
			long degreeAreaId, Map<Locale, String> nameMap,
			ServiceContext serviceContext)
		throws PortalException;

}