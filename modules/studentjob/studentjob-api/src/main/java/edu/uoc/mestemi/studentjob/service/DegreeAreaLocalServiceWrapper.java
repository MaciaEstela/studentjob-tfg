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
 * Provides a wrapper for {@link DegreeAreaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeAreaLocalService
 * @generated
 */
public class DegreeAreaLocalServiceWrapper
	implements DegreeAreaLocalService, ServiceWrapper<DegreeAreaLocalService> {

	public DegreeAreaLocalServiceWrapper() {
		this(null);
	}

	public DegreeAreaLocalServiceWrapper(
		DegreeAreaLocalService degreeAreaLocalService) {

		_degreeAreaLocalService = degreeAreaLocalService;
	}

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
	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea addDegreeArea(
		edu.uoc.mestemi.studentjob.model.DegreeArea degreeArea) {

		return _degreeAreaLocalService.addDegreeArea(degreeArea);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea addDegreeArea(
			long groupId, java.util.Map<java.util.Locale, String> nameMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaLocalService.addDegreeArea(
			groupId, nameMap, serviceContext);
	}

	@Override
	public void addDegreeDegreeArea(
		long degreeId, edu.uoc.mestemi.studentjob.model.DegreeArea degreeArea) {

		_degreeAreaLocalService.addDegreeDegreeArea(degreeId, degreeArea);
	}

	@Override
	public void addDegreeDegreeArea(long degreeId, long degreeAreaId) {
		_degreeAreaLocalService.addDegreeDegreeArea(degreeId, degreeAreaId);
	}

	@Override
	public void addDegreeDegreeAreas(
		long degreeId,
		java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
			degreeAreas) {

		_degreeAreaLocalService.addDegreeDegreeAreas(degreeId, degreeAreas);
	}

	@Override
	public void addDegreeDegreeAreas(long degreeId, long[] degreeAreaIds) {
		_degreeAreaLocalService.addDegreeDegreeAreas(degreeId, degreeAreaIds);
	}

	@Override
	public void clearDegreeDegreeAreas(long degreeId) {
		_degreeAreaLocalService.clearDegreeDegreeAreas(degreeId);
	}

	/**
	 * Creates a new degree area with the primary key. Does not add the degree area to the database.
	 *
	 * @param degreeAreaId the primary key for the new degree area
	 * @return the new degree area
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea createDegreeArea(
		long degreeAreaId) {

		return _degreeAreaLocalService.createDegreeArea(degreeAreaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaLocalService.createPersistedModel(primaryKeyObj);
	}

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
	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea deleteDegreeArea(
		edu.uoc.mestemi.studentjob.model.DegreeArea degreeArea) {

		return _degreeAreaLocalService.deleteDegreeArea(degreeArea);
	}

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
	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea deleteDegreeArea(
			long degreeAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaLocalService.deleteDegreeArea(degreeAreaId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea
			deleteDegreeAreaWithValidation(long degreeAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaLocalService.deleteDegreeAreaWithValidation(
			degreeAreaId);
	}

	@Override
	public void deleteDegreeDegreeArea(
		long degreeId, edu.uoc.mestemi.studentjob.model.DegreeArea degreeArea) {

		_degreeAreaLocalService.deleteDegreeDegreeArea(degreeId, degreeArea);
	}

	@Override
	public void deleteDegreeDegreeArea(long degreeId, long degreeAreaId) {
		_degreeAreaLocalService.deleteDegreeDegreeArea(degreeId, degreeAreaId);
	}

	@Override
	public void deleteDegreeDegreeAreas(
		long degreeId,
		java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
			degreeAreas) {

		_degreeAreaLocalService.deleteDegreeDegreeAreas(degreeId, degreeAreas);
	}

	@Override
	public void deleteDegreeDegreeAreas(long degreeId, long[] degreeAreaIds) {
		_degreeAreaLocalService.deleteDegreeDegreeAreas(
			degreeId, degreeAreaIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _degreeAreaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _degreeAreaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _degreeAreaLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _degreeAreaLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _degreeAreaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _degreeAreaLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _degreeAreaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _degreeAreaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea fetchDegreeArea(
		long degreeAreaId) {

		return _degreeAreaLocalService.fetchDegreeArea(degreeAreaId);
	}

	/**
	 * Returns the degree area matching the UUID and group.
	 *
	 * @param uuid the degree area's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea
		fetchDegreeAreaByUuidAndGroupId(String uuid, long groupId) {

		return _degreeAreaLocalService.fetchDegreeAreaByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _degreeAreaLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getCompanyProfilesByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.DegreeArea>
					orderByComparator) {

		return _degreeAreaLocalService.getCompanyProfilesByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the degree area with the primary key.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area
	 * @throws PortalException if a degree area with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea getDegreeArea(
			long degreeAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaLocalService.getDegreeArea(degreeAreaId);
	}

	/**
	 * Returns the degree area matching the UUID and group.
	 *
	 * @param uuid the degree area's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree area
	 * @throws PortalException if a matching degree area could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea
			getDegreeAreaByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaLocalService.getDegreeAreaByUuidAndGroupId(
			uuid, groupId);
	}

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
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreas(int start, int end) {

		return _degreeAreaLocalService.getDegreeAreas(start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByGroupId(long groupId) {

		return _degreeAreaLocalService.getDegreeAreasByGroupId(groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByGroupId(long groupId, int start, int end) {

		return _degreeAreaLocalService.getDegreeAreasByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.DegreeArea>
					orderByComparator) {

		return _degreeAreaLocalService.getDegreeAreasByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns all the degree areas matching the UUID and company.
	 *
	 * @param uuid the UUID of the degree areas
	 * @param companyId the primary key of the company
	 * @return the matching degree areas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByUuidAndCompanyId(String uuid, long companyId) {

		return _degreeAreaLocalService.getDegreeAreasByUuidAndCompanyId(
			uuid, companyId);
	}

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
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.DegreeArea>
					orderByComparator) {

		return _degreeAreaLocalService.getDegreeAreasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of degree areas.
	 *
	 * @return the number of degree areas
	 */
	@Override
	public int getDegreeAreasCount() {
		return _degreeAreaLocalService.getDegreeAreasCount();
	}

	@Override
	public long getDegreeAreasCountByKeywords(long groupId, String keywords) {
		return _degreeAreaLocalService.getDegreeAreasCountByKeywords(
			groupId, keywords);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeDegreeAreas(long degreeId) {

		return _degreeAreaLocalService.getDegreeDegreeAreas(degreeId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeDegreeAreas(long degreeId, int start, int end) {

		return _degreeAreaLocalService.getDegreeDegreeAreas(
			degreeId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeDegreeAreas(
			long degreeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.DegreeArea>
					orderByComparator) {

		return _degreeAreaLocalService.getDegreeDegreeAreas(
			degreeId, start, end, orderByComparator);
	}

	@Override
	public int getDegreeDegreeAreasCount(long degreeId) {
		return _degreeAreaLocalService.getDegreeDegreeAreasCount(degreeId);
	}

	/**
	 * Returns the degreeIds of the degrees associated with the degree area.
	 *
	 * @param degreeAreaId the degreeAreaId of the degree area
	 * @return long[] the degreeIds of degrees associated with the degree area
	 */
	@Override
	public long[] getDegreePrimaryKeys(long degreeAreaId) {
		return _degreeAreaLocalService.getDegreePrimaryKeys(degreeAreaId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _degreeAreaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _degreeAreaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _degreeAreaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasDegreeDegreeArea(long degreeId, long degreeAreaId) {
		return _degreeAreaLocalService.hasDegreeDegreeArea(
			degreeId, degreeAreaId);
	}

	@Override
	public boolean hasDegreeDegreeAreas(long degreeId) {
		return _degreeAreaLocalService.hasDegreeDegreeAreas(degreeId);
	}

	@Override
	public void setDegreeDegreeAreas(long degreeId, long[] degreeAreaIds) {
		_degreeAreaLocalService.setDegreeDegreeAreas(degreeId, degreeAreaIds);
	}

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
	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea updateDegreeArea(
		edu.uoc.mestemi.studentjob.model.DegreeArea degreeArea) {

		return _degreeAreaLocalService.updateDegreeArea(degreeArea);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.DegreeArea updateDegreeArea(
			long degreeAreaId, java.util.Map<java.util.Locale, String> nameMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeAreaLocalService.updateDegreeArea(
			degreeAreaId, nameMap, serviceContext);
	}

	@Override
	public DegreeAreaLocalService getWrappedService() {
		return _degreeAreaLocalService;
	}

	@Override
	public void setWrappedService(
		DegreeAreaLocalService degreeAreaLocalService) {

		_degreeAreaLocalService = degreeAreaLocalService;
	}

	private DegreeAreaLocalService _degreeAreaLocalService;

}