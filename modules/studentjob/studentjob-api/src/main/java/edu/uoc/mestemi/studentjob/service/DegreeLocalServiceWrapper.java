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
 * Provides a wrapper for {@link DegreeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeLocalService
 * @generated
 */
public class DegreeLocalServiceWrapper
	implements DegreeLocalService, ServiceWrapper<DegreeLocalService> {

	public DegreeLocalServiceWrapper() {
		this(null);
	}

	public DegreeLocalServiceWrapper(DegreeLocalService degreeLocalService) {
		_degreeLocalService = degreeLocalService;
	}

	/**
	 * Adds the degree to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degree the degree
	 * @return the degree that was added
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Degree addDegree(
		edu.uoc.mestemi.studentjob.model.Degree degree) {

		return _degreeLocalService.addDegree(degree);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Degree addDegree(
			long groupId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.List<Long> degreeAreasIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeLocalService.addDegree(
			groupId, nameMap, degreeAreasIds, serviceContext);
	}

	@Override
	public void addDegreeAreaDegree(
		long degreeAreaId, edu.uoc.mestemi.studentjob.model.Degree degree) {

		_degreeLocalService.addDegreeAreaDegree(degreeAreaId, degree);
	}

	@Override
	public void addDegreeAreaDegree(long degreeAreaId, long degreeId) {
		_degreeLocalService.addDegreeAreaDegree(degreeAreaId, degreeId);
	}

	@Override
	public void addDegreeAreaDegrees(
		long degreeAreaId,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		_degreeLocalService.addDegreeAreaDegrees(degreeAreaId, degrees);
	}

	@Override
	public void addDegreeAreaDegrees(long degreeAreaId, long[] degreeIds) {
		_degreeLocalService.addDegreeAreaDegrees(degreeAreaId, degreeIds);
	}

	@Override
	public void addOfferDegree(
		long offerId, edu.uoc.mestemi.studentjob.model.Degree degree) {

		_degreeLocalService.addOfferDegree(offerId, degree);
	}

	@Override
	public void addOfferDegree(long offerId, long degreeId) {
		_degreeLocalService.addOfferDegree(offerId, degreeId);
	}

	@Override
	public void addOfferDegrees(
		long offerId,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		_degreeLocalService.addOfferDegrees(offerId, degrees);
	}

	@Override
	public void addOfferDegrees(long offerId, long[] degreeIds) {
		_degreeLocalService.addOfferDegrees(offerId, degreeIds);
	}

	@Override
	public void addStudentProfileDegree(
		long studentProfileId, edu.uoc.mestemi.studentjob.model.Degree degree) {

		_degreeLocalService.addStudentProfileDegree(studentProfileId, degree);
	}

	@Override
	public void addStudentProfileDegree(long studentProfileId, long degreeId) {
		_degreeLocalService.addStudentProfileDegree(studentProfileId, degreeId);
	}

	@Override
	public void addStudentProfileDegrees(
		long studentProfileId,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		_degreeLocalService.addStudentProfileDegrees(studentProfileId, degrees);
	}

	@Override
	public void addStudentProfileDegrees(
		long studentProfileId, long[] degreeIds) {

		_degreeLocalService.addStudentProfileDegrees(
			studentProfileId, degreeIds);
	}

	@Override
	public void clearDegreeAreaDegrees(long degreeAreaId) {
		_degreeLocalService.clearDegreeAreaDegrees(degreeAreaId);
	}

	@Override
	public void clearOfferDegrees(long offerId) {
		_degreeLocalService.clearOfferDegrees(offerId);
	}

	@Override
	public void clearStudentProfileDegrees(long studentProfileId) {
		_degreeLocalService.clearStudentProfileDegrees(studentProfileId);
	}

	/**
	 * Creates a new degree with the primary key. Does not add the degree to the database.
	 *
	 * @param degreeId the primary key for the new degree
	 * @return the new degree
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Degree createDegree(long degreeId) {
		return _degreeLocalService.createDegree(degreeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the degree from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degree the degree
	 * @return the degree that was removed
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Degree deleteDegree(
		edu.uoc.mestemi.studentjob.model.Degree degree) {

		return _degreeLocalService.deleteDegree(degree);
	}

	/**
	 * Deletes the degree with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree that was removed
	 * @throws PortalException if a degree with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Degree deleteDegree(long degreeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeLocalService.deleteDegree(degreeId);
	}

	@Override
	public void deleteDegreeAreaDegree(
		long degreeAreaId, edu.uoc.mestemi.studentjob.model.Degree degree) {

		_degreeLocalService.deleteDegreeAreaDegree(degreeAreaId, degree);
	}

	@Override
	public void deleteDegreeAreaDegree(long degreeAreaId, long degreeId) {
		_degreeLocalService.deleteDegreeAreaDegree(degreeAreaId, degreeId);
	}

	@Override
	public void deleteDegreeAreaDegrees(
		long degreeAreaId,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		_degreeLocalService.deleteDegreeAreaDegrees(degreeAreaId, degrees);
	}

	@Override
	public void deleteDegreeAreaDegrees(long degreeAreaId, long[] degreeIds) {
		_degreeLocalService.deleteDegreeAreaDegrees(degreeAreaId, degreeIds);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Degree deleteDegreeWithValidation(
			edu.uoc.mestemi.studentjob.model.Degree degree)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeLocalService.deleteDegreeWithValidation(degree);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Degree deleteDegreeWithValidation(
			long degreeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeLocalService.deleteDegreeWithValidation(degreeId);
	}

	@Override
	public void deleteOfferDegree(
		long offerId, edu.uoc.mestemi.studentjob.model.Degree degree) {

		_degreeLocalService.deleteOfferDegree(offerId, degree);
	}

	@Override
	public void deleteOfferDegree(long offerId, long degreeId) {
		_degreeLocalService.deleteOfferDegree(offerId, degreeId);
	}

	@Override
	public void deleteOfferDegrees(
		long offerId,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		_degreeLocalService.deleteOfferDegrees(offerId, degrees);
	}

	@Override
	public void deleteOfferDegrees(long offerId, long[] degreeIds) {
		_degreeLocalService.deleteOfferDegrees(offerId, degreeIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteStudentProfileDegree(
		long studentProfileId, edu.uoc.mestemi.studentjob.model.Degree degree) {

		_degreeLocalService.deleteStudentProfileDegree(
			studentProfileId, degree);
	}

	@Override
	public void deleteStudentProfileDegree(
		long studentProfileId, long degreeId) {

		_degreeLocalService.deleteStudentProfileDegree(
			studentProfileId, degreeId);
	}

	@Override
	public void deleteStudentProfileDegrees(
		long studentProfileId,
		java.util.List<edu.uoc.mestemi.studentjob.model.Degree> degrees) {

		_degreeLocalService.deleteStudentProfileDegrees(
			studentProfileId, degrees);
	}

	@Override
	public void deleteStudentProfileDegrees(
		long studentProfileId, long[] degreeIds) {

		_degreeLocalService.deleteStudentProfileDegrees(
			studentProfileId, degreeIds);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _degreeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _degreeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _degreeLocalService.dynamicQuery();
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

		return _degreeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeModelImpl</code>.
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

		return _degreeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeModelImpl</code>.
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

		return _degreeLocalService.dynamicQuery(
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

		return _degreeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _degreeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Degree fetchDegree(long degreeId) {
		return _degreeLocalService.fetchDegree(degreeId);
	}

	/**
	 * Returns the degree matching the UUID and group.
	 *
	 * @param uuid the degree's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree, or <code>null</code> if a matching degree could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Degree fetchDegreeByUuidAndGroupId(
		String uuid, long groupId) {

		return _degreeLocalService.fetchDegreeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _degreeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the degree with the primary key.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree
	 * @throws PortalException if a degree with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Degree getDegree(long degreeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeLocalService.getDegree(degreeId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreeAreaDegrees(long degreeAreaId) {

		return _degreeLocalService.getDegreeAreaDegrees(degreeAreaId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreeAreaDegrees(long degreeAreaId, int start, int end) {

		return _degreeLocalService.getDegreeAreaDegrees(
			degreeAreaId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreeAreaDegrees(
			long degreeAreaId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Degree> orderByComparator) {

		return _degreeLocalService.getDegreeAreaDegrees(
			degreeAreaId, start, end, orderByComparator);
	}

	@Override
	public int getDegreeAreaDegreesCount(long degreeAreaId) {
		return _degreeLocalService.getDegreeAreaDegreesCount(degreeAreaId);
	}

	/**
	 * Returns the degreeAreaIds of the degree areas associated with the degree.
	 *
	 * @param degreeId the degreeId of the degree
	 * @return long[] the degreeAreaIds of degree areas associated with the degree
	 */
	@Override
	public long[] getDegreeAreaPrimaryKeys(long degreeId) {
		return _degreeLocalService.getDegreeAreaPrimaryKeys(degreeId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByDegreeId(long degreeId) {

		return _degreeLocalService.getDegreeAreasByDegreeId(degreeId);
	}

	@Override
	public java.util.List<Long> getDegreeAreasIdsByDegreeId(long degreeId) {
		return _degreeLocalService.getDegreeAreasIdsByDegreeId(degreeId);
	}

	/**
	 * Returns the degree matching the UUID and group.
	 *
	 * @param uuid the degree's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree
	 * @throws PortalException if a matching degree could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Degree getDegreeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeLocalService.getDegreeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the degrees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of degrees
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree> getDegrees(
		int start, int end) {

		return _degreeLocalService.getDegrees(start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByGroupId(long groupId) {

		return _degreeLocalService.getDegreesByGroupId(groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByGroupId(long groupId, int start, int end) {

		return _degreeLocalService.getDegreesByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Degree> orderByComparator) {

		return _degreeLocalService.getDegreesByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Degree> orderByComparator) {

		return _degreeLocalService.getDegreesByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns all the degrees matching the UUID and company.
	 *
	 * @param uuid the UUID of the degrees
	 * @param companyId the primary key of the company
	 * @return the matching degrees, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByUuidAndCompanyId(String uuid, long companyId) {

		return _degreeLocalService.getDegreesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of degrees matching the UUID and company.
	 *
	 * @param uuid the UUID of the degrees
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching degrees, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Degree> orderByComparator) {

		return _degreeLocalService.getDegreesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of degrees.
	 *
	 * @return the number of degrees
	 */
	@Override
	public int getDegreesCount() {
		return _degreeLocalService.getDegreesCount();
	}

	@Override
	public long getDegreesCountByKeywords(long groupId, String keywords) {
		return _degreeLocalService.getDegreesCountByKeywords(groupId, keywords);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _degreeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _degreeLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getOfferDegrees(long offerId) {

		return _degreeLocalService.getOfferDegrees(offerId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getOfferDegrees(long offerId, int start, int end) {

		return _degreeLocalService.getOfferDegrees(offerId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getOfferDegrees(
			long offerId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Degree> orderByComparator) {

		return _degreeLocalService.getOfferDegrees(
			offerId, start, end, orderByComparator);
	}

	@Override
	public int getOfferDegreesCount(long offerId) {
		return _degreeLocalService.getOfferDegreesCount(offerId);
	}

	/**
	 * Returns the offerIds of the offers associated with the degree.
	 *
	 * @param degreeId the degreeId of the degree
	 * @return long[] the offerIds of offers associated with the degree
	 */
	@Override
	public long[] getOfferPrimaryKeys(long degreeId) {
		return _degreeLocalService.getOfferPrimaryKeys(degreeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _degreeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getStudentProfileDegrees(long studentProfileId) {

		return _degreeLocalService.getStudentProfileDegrees(studentProfileId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getStudentProfileDegrees(long studentProfileId, int start, int end) {

		return _degreeLocalService.getStudentProfileDegrees(
			studentProfileId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getStudentProfileDegrees(
			long studentProfileId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Degree> orderByComparator) {

		return _degreeLocalService.getStudentProfileDegrees(
			studentProfileId, start, end, orderByComparator);
	}

	@Override
	public int getStudentProfileDegreesCount(long studentProfileId) {
		return _degreeLocalService.getStudentProfileDegreesCount(
			studentProfileId);
	}

	/**
	 * Returns the studentProfileIds of the student profiles associated with the degree.
	 *
	 * @param degreeId the degreeId of the degree
	 * @return long[] the studentProfileIds of student profiles associated with the degree
	 */
	@Override
	public long[] getStudentProfilePrimaryKeys(long degreeId) {
		return _degreeLocalService.getStudentProfilePrimaryKeys(degreeId);
	}

	@Override
	public boolean hasDegreeAreaDegree(long degreeAreaId, long degreeId) {
		return _degreeLocalService.hasDegreeAreaDegree(degreeAreaId, degreeId);
	}

	@Override
	public boolean hasDegreeAreaDegrees(long degreeAreaId) {
		return _degreeLocalService.hasDegreeAreaDegrees(degreeAreaId);
	}

	@Override
	public boolean hasOfferDegree(long offerId, long degreeId) {
		return _degreeLocalService.hasOfferDegree(offerId, degreeId);
	}

	@Override
	public boolean hasOfferDegrees(long offerId) {
		return _degreeLocalService.hasOfferDegrees(offerId);
	}

	@Override
	public boolean hasStudentProfileDegree(
		long studentProfileId, long degreeId) {

		return _degreeLocalService.hasStudentProfileDegree(
			studentProfileId, degreeId);
	}

	@Override
	public boolean hasStudentProfileDegrees(long studentProfileId) {
		return _degreeLocalService.hasStudentProfileDegrees(studentProfileId);
	}

	@Override
	public void setDegreeAreaDegrees(long degreeAreaId, long[] degreeIds) {
		_degreeLocalService.setDegreeAreaDegrees(degreeAreaId, degreeIds);
	}

	@Override
	public void setOfferDegrees(long offerId, long[] degreeIds) {
		_degreeLocalService.setOfferDegrees(offerId, degreeIds);
	}

	@Override
	public void setStudentProfileDegrees(
		long studentProfileId, long[] degreeIds) {

		_degreeLocalService.setStudentProfileDegrees(
			studentProfileId, degreeIds);
	}

	/**
	 * Updates the degree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degree the degree
	 * @return the degree that was updated
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.Degree updateDegree(
		edu.uoc.mestemi.studentjob.model.Degree degree) {

		return _degreeLocalService.updateDegree(degree);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.Degree updateDegree(
			long degreeId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.List<Long> degreeAreasIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _degreeLocalService.updateDegree(
			degreeId, nameMap, degreeAreasIds, serviceContext);
	}

	@Override
	public DegreeLocalService getWrappedService() {
		return _degreeLocalService;
	}

	@Override
	public void setWrappedService(DegreeLocalService degreeLocalService) {
		_degreeLocalService = degreeLocalService;
	}

	private DegreeLocalService _degreeLocalService;

}