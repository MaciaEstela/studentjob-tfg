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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.DegreeArea;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for DegreeArea. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.DegreeAreaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeAreaLocalService
 * @generated
 */
public class DegreeAreaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.DegreeAreaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static DegreeArea addDegreeArea(DegreeArea degreeArea) {
		return getService().addDegreeArea(degreeArea);
	}

	public static DegreeArea addDegreeArea(
			long groupId, Map<java.util.Locale, String> nameMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDegreeArea(groupId, nameMap, serviceContext);
	}

	public static void addDegreeDegreeArea(
		long degreeId, DegreeArea degreeArea) {

		getService().addDegreeDegreeArea(degreeId, degreeArea);
	}

	public static void addDegreeDegreeArea(long degreeId, long degreeAreaId) {
		getService().addDegreeDegreeArea(degreeId, degreeAreaId);
	}

	public static void addDegreeDegreeAreas(
		long degreeId, List<DegreeArea> degreeAreas) {

		getService().addDegreeDegreeAreas(degreeId, degreeAreas);
	}

	public static void addDegreeDegreeAreas(
		long degreeId, long[] degreeAreaIds) {

		getService().addDegreeDegreeAreas(degreeId, degreeAreaIds);
	}

	public static void clearDegreeDegreeAreas(long degreeId) {
		getService().clearDegreeDegreeAreas(degreeId);
	}

	/**
	 * Creates a new degree area with the primary key. Does not add the degree area to the database.
	 *
	 * @param degreeAreaId the primary key for the new degree area
	 * @return the new degree area
	 */
	public static DegreeArea createDegreeArea(long degreeAreaId) {
		return getService().createDegreeArea(degreeAreaId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static DegreeArea deleteDegreeArea(DegreeArea degreeArea) {
		return getService().deleteDegreeArea(degreeArea);
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
	public static DegreeArea deleteDegreeArea(long degreeAreaId)
		throws PortalException {

		return getService().deleteDegreeArea(degreeAreaId);
	}

	public static DegreeArea deleteDegreeAreaWithValidation(long degreeAreaId)
		throws PortalException {

		return getService().deleteDegreeAreaWithValidation(degreeAreaId);
	}

	public static void deleteDegreeDegreeArea(
		long degreeId, DegreeArea degreeArea) {

		getService().deleteDegreeDegreeArea(degreeId, degreeArea);
	}

	public static void deleteDegreeDegreeArea(
		long degreeId, long degreeAreaId) {

		getService().deleteDegreeDegreeArea(degreeId, degreeAreaId);
	}

	public static void deleteDegreeDegreeAreas(
		long degreeId, List<DegreeArea> degreeAreas) {

		getService().deleteDegreeDegreeAreas(degreeId, degreeAreas);
	}

	public static void deleteDegreeDegreeAreas(
		long degreeId, long[] degreeAreaIds) {

		getService().deleteDegreeDegreeAreas(degreeId, degreeAreaIds);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DegreeArea fetchDegreeArea(long degreeAreaId) {
		return getService().fetchDegreeArea(degreeAreaId);
	}

	/**
	 * Returns the degree area matching the UUID and group.
	 *
	 * @param uuid the degree area's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree area, or <code>null</code> if a matching degree area could not be found
	 */
	public static DegreeArea fetchDegreeAreaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDegreeAreaByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<DegreeArea> getCompanyProfilesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return getService().getCompanyProfilesByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the degree area with the primary key.
	 *
	 * @param degreeAreaId the primary key of the degree area
	 * @return the degree area
	 * @throws PortalException if a degree area with the primary key could not be found
	 */
	public static DegreeArea getDegreeArea(long degreeAreaId)
		throws PortalException {

		return getService().getDegreeArea(degreeAreaId);
	}

	/**
	 * Returns the degree area matching the UUID and group.
	 *
	 * @param uuid the degree area's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree area
	 * @throws PortalException if a matching degree area could not be found
	 */
	public static DegreeArea getDegreeAreaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDegreeAreaByUuidAndGroupId(uuid, groupId);
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
	public static List<DegreeArea> getDegreeAreas(int start, int end) {
		return getService().getDegreeAreas(start, end);
	}

	public static List<DegreeArea> getDegreeAreasByGroupId(long groupId) {
		return getService().getDegreeAreasByGroupId(groupId);
	}

	public static List<DegreeArea> getDegreeAreasByGroupId(
		long groupId, int start, int end) {

		return getService().getDegreeAreasByGroupId(groupId, start, end);
	}

	public static List<DegreeArea> getDegreeAreasByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return getService().getDegreeAreasByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns all the degree areas matching the UUID and company.
	 *
	 * @param uuid the UUID of the degree areas
	 * @param companyId the primary key of the company
	 * @return the matching degree areas, or an empty list if no matches were found
	 */
	public static List<DegreeArea> getDegreeAreasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDegreeAreasByUuidAndCompanyId(uuid, companyId);
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
	public static List<DegreeArea> getDegreeAreasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return getService().getDegreeAreasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of degree areas.
	 *
	 * @return the number of degree areas
	 */
	public static int getDegreeAreasCount() {
		return getService().getDegreeAreasCount();
	}

	public static long getDegreeAreasCountByKeywords(
		long groupId, String keywords) {

		return getService().getDegreeAreasCountByKeywords(groupId, keywords);
	}

	public static List<DegreeArea> getDegreeDegreeAreas(long degreeId) {
		return getService().getDegreeDegreeAreas(degreeId);
	}

	public static List<DegreeArea> getDegreeDegreeAreas(
		long degreeId, int start, int end) {

		return getService().getDegreeDegreeAreas(degreeId, start, end);
	}

	public static List<DegreeArea> getDegreeDegreeAreas(
		long degreeId, int start, int end,
		OrderByComparator<DegreeArea> orderByComparator) {

		return getService().getDegreeDegreeAreas(
			degreeId, start, end, orderByComparator);
	}

	public static int getDegreeDegreeAreasCount(long degreeId) {
		return getService().getDegreeDegreeAreasCount(degreeId);
	}

	/**
	 * Returns the degreeIds of the degrees associated with the degree area.
	 *
	 * @param degreeAreaId the degreeAreaId of the degree area
	 * @return long[] the degreeIds of degrees associated with the degree area
	 */
	public static long[] getDegreePrimaryKeys(long degreeAreaId) {
		return getService().getDegreePrimaryKeys(degreeAreaId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasDegreeDegreeArea(
		long degreeId, long degreeAreaId) {

		return getService().hasDegreeDegreeArea(degreeId, degreeAreaId);
	}

	public static boolean hasDegreeDegreeAreas(long degreeId) {
		return getService().hasDegreeDegreeAreas(degreeId);
	}

	public static void setDegreeDegreeAreas(
		long degreeId, long[] degreeAreaIds) {

		getService().setDegreeDegreeAreas(degreeId, degreeAreaIds);
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
	public static DegreeArea updateDegreeArea(DegreeArea degreeArea) {
		return getService().updateDegreeArea(degreeArea);
	}

	public static DegreeArea updateDegreeArea(
			long degreeAreaId, Map<java.util.Locale, String> nameMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDegreeArea(
			degreeAreaId, nameMap, serviceContext);
	}

	public static DegreeAreaLocalService getService() {
		return _service;
	}

	private static volatile DegreeAreaLocalService _service;

}