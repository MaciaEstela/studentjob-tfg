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

import edu.uoc.mestemi.studentjob.model.Degree;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Degree. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.DegreeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeLocalService
 * @generated
 */
public class DegreeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.DegreeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Degree addDegree(Degree degree) {
		return getService().addDegree(degree);
	}

	public static Degree addDegree(
			long groupId, Map<java.util.Locale, String> nameMap,
			List<Long> degreeAreasIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDegree(
			groupId, nameMap, degreeAreasIds, serviceContext);
	}

	public static void addDegreeAreaDegree(long degreeAreaId, Degree degree) {
		getService().addDegreeAreaDegree(degreeAreaId, degree);
	}

	public static void addDegreeAreaDegree(long degreeAreaId, long degreeId) {
		getService().addDegreeAreaDegree(degreeAreaId, degreeId);
	}

	public static void addDegreeAreaDegrees(
		long degreeAreaId, List<Degree> degrees) {

		getService().addDegreeAreaDegrees(degreeAreaId, degrees);
	}

	public static void addDegreeAreaDegrees(
		long degreeAreaId, long[] degreeIds) {

		getService().addDegreeAreaDegrees(degreeAreaId, degreeIds);
	}

	public static void addOfferDegree(long offerId, Degree degree) {
		getService().addOfferDegree(offerId, degree);
	}

	public static void addOfferDegree(long offerId, long degreeId) {
		getService().addOfferDegree(offerId, degreeId);
	}

	public static void addOfferDegrees(long offerId, List<Degree> degrees) {
		getService().addOfferDegrees(offerId, degrees);
	}

	public static void addOfferDegrees(long offerId, long[] degreeIds) {
		getService().addOfferDegrees(offerId, degreeIds);
	}

	public static void addStudentProfileDegree(
		long studentProfileId, Degree degree) {

		getService().addStudentProfileDegree(studentProfileId, degree);
	}

	public static void addStudentProfileDegree(
		long studentProfileId, long degreeId) {

		getService().addStudentProfileDegree(studentProfileId, degreeId);
	}

	public static void addStudentProfileDegrees(
		long studentProfileId, List<Degree> degrees) {

		getService().addStudentProfileDegrees(studentProfileId, degrees);
	}

	public static void addStudentProfileDegrees(
		long studentProfileId, long[] degreeIds) {

		getService().addStudentProfileDegrees(studentProfileId, degreeIds);
	}

	public static void clearDegreeAreaDegrees(long degreeAreaId) {
		getService().clearDegreeAreaDegrees(degreeAreaId);
	}

	public static void clearOfferDegrees(long offerId) {
		getService().clearOfferDegrees(offerId);
	}

	public static void clearStudentProfileDegrees(long studentProfileId) {
		getService().clearStudentProfileDegrees(studentProfileId);
	}

	/**
	 * Creates a new degree with the primary key. Does not add the degree to the database.
	 *
	 * @param degreeId the primary key for the new degree
	 * @return the new degree
	 */
	public static Degree createDegree(long degreeId) {
		return getService().createDegree(degreeId);
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
	 * Deletes the degree from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degree the degree
	 * @return the degree that was removed
	 */
	public static Degree deleteDegree(Degree degree) {
		return getService().deleteDegree(degree);
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
	public static Degree deleteDegree(long degreeId) throws PortalException {
		return getService().deleteDegree(degreeId);
	}

	public static void deleteDegreeAreaDegree(
		long degreeAreaId, Degree degree) {

		getService().deleteDegreeAreaDegree(degreeAreaId, degree);
	}

	public static void deleteDegreeAreaDegree(
		long degreeAreaId, long degreeId) {

		getService().deleteDegreeAreaDegree(degreeAreaId, degreeId);
	}

	public static void deleteDegreeAreaDegrees(
		long degreeAreaId, List<Degree> degrees) {

		getService().deleteDegreeAreaDegrees(degreeAreaId, degrees);
	}

	public static void deleteDegreeAreaDegrees(
		long degreeAreaId, long[] degreeIds) {

		getService().deleteDegreeAreaDegrees(degreeAreaId, degreeIds);
	}

	public static void deleteOfferDegree(long offerId, Degree degree) {
		getService().deleteOfferDegree(offerId, degree);
	}

	public static void deleteOfferDegree(long offerId, long degreeId) {
		getService().deleteOfferDegree(offerId, degreeId);
	}

	public static void deleteOfferDegrees(long offerId, List<Degree> degrees) {
		getService().deleteOfferDegrees(offerId, degrees);
	}

	public static void deleteOfferDegrees(long offerId, long[] degreeIds) {
		getService().deleteOfferDegrees(offerId, degreeIds);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteStudentProfileDegree(
		long studentProfileId, Degree degree) {

		getService().deleteStudentProfileDegree(studentProfileId, degree);
	}

	public static void deleteStudentProfileDegree(
		long studentProfileId, long degreeId) {

		getService().deleteStudentProfileDegree(studentProfileId, degreeId);
	}

	public static void deleteStudentProfileDegrees(
		long studentProfileId, List<Degree> degrees) {

		getService().deleteStudentProfileDegrees(studentProfileId, degrees);
	}

	public static void deleteStudentProfileDegrees(
		long studentProfileId, long[] degreeIds) {

		getService().deleteStudentProfileDegrees(studentProfileId, degreeIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeModelImpl</code>.
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

	public static Degree fetchDegree(long degreeId) {
		return getService().fetchDegree(degreeId);
	}

	/**
	 * Returns the degree matching the UUID and group.
	 *
	 * @param uuid the degree's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree, or <code>null</code> if a matching degree could not be found
	 */
	public static Degree fetchDegreeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDegreeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static long getCompanyProfilesCountByKeywords(
		long groupId, String keywords) {

		return getService().getCompanyProfilesCountByKeywords(
			groupId, keywords);
	}

	/**
	 * Returns the degree with the primary key.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree
	 * @throws PortalException if a degree with the primary key could not be found
	 */
	public static Degree getDegree(long degreeId) throws PortalException {
		return getService().getDegree(degreeId);
	}

	public static List<Degree> getDegreeAreaDegrees(long degreeAreaId) {
		return getService().getDegreeAreaDegrees(degreeAreaId);
	}

	public static List<Degree> getDegreeAreaDegrees(
		long degreeAreaId, int start, int end) {

		return getService().getDegreeAreaDegrees(degreeAreaId, start, end);
	}

	public static List<Degree> getDegreeAreaDegrees(
		long degreeAreaId, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getService().getDegreeAreaDegrees(
			degreeAreaId, start, end, orderByComparator);
	}

	public static int getDegreeAreaDegreesCount(long degreeAreaId) {
		return getService().getDegreeAreaDegreesCount(degreeAreaId);
	}

	/**
	 * Returns the degreeAreaIds of the degree areas associated with the degree.
	 *
	 * @param degreeId the degreeId of the degree
	 * @return long[] the degreeAreaIds of degree areas associated with the degree
	 */
	public static long[] getDegreeAreaPrimaryKeys(long degreeId) {
		return getService().getDegreeAreaPrimaryKeys(degreeId);
	}

	/**
	 * Returns the degree matching the UUID and group.
	 *
	 * @param uuid the degree's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree
	 * @throws PortalException if a matching degree could not be found
	 */
	public static Degree getDegreeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getDegreeByUuidAndGroupId(uuid, groupId);
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
	public static List<Degree> getDegrees(int start, int end) {
		return getService().getDegrees(start, end);
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

	/**
	 * Returns all the degrees matching the UUID and company.
	 *
	 * @param uuid the UUID of the degrees
	 * @param companyId the primary key of the company
	 * @return the matching degrees, or an empty list if no matches were found
	 */
	public static List<Degree> getDegreesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDegreesByUuidAndCompanyId(uuid, companyId);
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
	public static List<Degree> getDegreesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getService().getDegreesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of degrees.
	 *
	 * @return the number of degrees
	 */
	public static int getDegreesCount() {
		return getService().getDegreesCount();
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

	public static List<Degree> getOfferDegrees(long offerId) {
		return getService().getOfferDegrees(offerId);
	}

	public static List<Degree> getOfferDegrees(
		long offerId, int start, int end) {

		return getService().getOfferDegrees(offerId, start, end);
	}

	public static List<Degree> getOfferDegrees(
		long offerId, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getService().getOfferDegrees(
			offerId, start, end, orderByComparator);
	}

	public static int getOfferDegreesCount(long offerId) {
		return getService().getOfferDegreesCount(offerId);
	}

	/**
	 * Returns the offerIds of the offers associated with the degree.
	 *
	 * @param degreeId the degreeId of the degree
	 * @return long[] the offerIds of offers associated with the degree
	 */
	public static long[] getOfferPrimaryKeys(long degreeId) {
		return getService().getOfferPrimaryKeys(degreeId);
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

	public static List<Degree> getStudentProfileDegrees(long studentProfileId) {
		return getService().getStudentProfileDegrees(studentProfileId);
	}

	public static List<Degree> getStudentProfileDegrees(
		long studentProfileId, int start, int end) {

		return getService().getStudentProfileDegrees(
			studentProfileId, start, end);
	}

	public static List<Degree> getStudentProfileDegrees(
		long studentProfileId, int start, int end,
		OrderByComparator<Degree> orderByComparator) {

		return getService().getStudentProfileDegrees(
			studentProfileId, start, end, orderByComparator);
	}

	public static int getStudentProfileDegreesCount(long studentProfileId) {
		return getService().getStudentProfileDegreesCount(studentProfileId);
	}

	/**
	 * Returns the studentProfileIds of the student profiles associated with the degree.
	 *
	 * @param degreeId the degreeId of the degree
	 * @return long[] the studentProfileIds of student profiles associated with the degree
	 */
	public static long[] getStudentProfilePrimaryKeys(long degreeId) {
		return getService().getStudentProfilePrimaryKeys(degreeId);
	}

	public static boolean hasDegreeAreaDegree(
		long degreeAreaId, long degreeId) {

		return getService().hasDegreeAreaDegree(degreeAreaId, degreeId);
	}

	public static boolean hasDegreeAreaDegrees(long degreeAreaId) {
		return getService().hasDegreeAreaDegrees(degreeAreaId);
	}

	public static boolean hasOfferDegree(long offerId, long degreeId) {
		return getService().hasOfferDegree(offerId, degreeId);
	}

	public static boolean hasOfferDegrees(long offerId) {
		return getService().hasOfferDegrees(offerId);
	}

	public static boolean hasStudentProfileDegree(
		long studentProfileId, long degreeId) {

		return getService().hasStudentProfileDegree(studentProfileId, degreeId);
	}

	public static boolean hasStudentProfileDegrees(long studentProfileId) {
		return getService().hasStudentProfileDegrees(studentProfileId);
	}

	public static void setDegreeAreaDegrees(
		long degreeAreaId, long[] degreeIds) {

		getService().setDegreeAreaDegrees(degreeAreaId, degreeIds);
	}

	public static void setOfferDegrees(long offerId, long[] degreeIds) {
		getService().setOfferDegrees(offerId, degreeIds);
	}

	public static void setStudentProfileDegrees(
		long studentProfileId, long[] degreeIds) {

		getService().setStudentProfileDegrees(studentProfileId, degreeIds);
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
	public static Degree updateDegree(Degree degree) {
		return getService().updateDegree(degree);
	}

	public static Degree updateDegree(
			long degreeId, Map<java.util.Locale, String> nameMap,
			List<Long> degreeAreasIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDegree(
			degreeId, nameMap, degreeAreasIds, serviceContext);
	}

	public static DegreeLocalService getService() {
		return _service;
	}

	private static volatile DegreeLocalService _service;

}