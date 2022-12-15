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

import edu.uoc.mestemi.studentjob.model.CompanyProfile;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for CompanyProfile. This utility wraps
 * <code>edu.uoc.mestemi.studentjob.service.impl.CompanyProfileLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CompanyProfileLocalService
 * @generated
 */
public class CompanyProfileLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.CompanyProfileLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the company profile to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompanyProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param companyProfile the company profile
	 * @return the company profile that was added
	 */
	public static CompanyProfile addCompanyProfile(
		CompanyProfile companyProfile) {

		return getService().addCompanyProfile(companyProfile);
	}

	public static CompanyProfile addCompanyProfile(
			long groupId, long userId, long regionId, boolean active,
			Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, String email,
			Map<java.util.Locale, String> sectorMap, String website,
			List<edu.uoc.mestemi.studentjob.model.SocialMedia> socialMedias,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addCompanyProfile(
			groupId, userId, regionId, active, titleMap, descriptionMap, email,
			sectorMap, website, socialMedias, serviceContext);
	}

	/**
	 * Creates a new company profile with the primary key. Does not add the company profile to the database.
	 *
	 * @param companyProfileId the primary key for the new company profile
	 * @return the new company profile
	 */
	public static CompanyProfile createCompanyProfile(long companyProfileId) {
		return getService().createCompanyProfile(companyProfileId);
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
	 * Deletes the company profile from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompanyProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param companyProfile the company profile
	 * @return the company profile that was removed
	 */
	public static CompanyProfile deleteCompanyProfile(
		CompanyProfile companyProfile) {

		return getService().deleteCompanyProfile(companyProfile);
	}

	/**
	 * Deletes the company profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompanyProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile that was removed
	 * @throws PortalException if a company profile with the primary key could not be found
	 */
	public static CompanyProfile deleteCompanyProfile(long companyProfileId)
		throws PortalException {

		return getService().deleteCompanyProfile(companyProfileId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.CompanyProfileModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.CompanyProfileModelImpl</code>.
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

	public static CompanyProfile fetchCompanyProfile(long companyProfileId) {
		return getService().fetchCompanyProfile(companyProfileId);
	}

	/**
	 * Returns the company profile matching the UUID and group.
	 *
	 * @param uuid the company profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	public static CompanyProfile fetchCompanyProfileByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCompanyProfileByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the company profile with the primary key.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile
	 * @throws PortalException if a company profile with the primary key could not be found
	 */
	public static CompanyProfile getCompanyProfile(long companyProfileId)
		throws PortalException {

		return getService().getCompanyProfile(companyProfileId);
	}

	public static CompanyProfile getCompanyProfileByGroupIdAndUserId(
		long groupId, long userId) {

		return getService().getCompanyProfileByGroupIdAndUserId(
			groupId, userId);
	}

	/**
	 * Returns the company profile matching the UUID and group.
	 *
	 * @param uuid the company profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching company profile
	 * @throws PortalException if a matching company profile could not be found
	 */
	public static CompanyProfile getCompanyProfileByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCompanyProfileByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the company profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.CompanyProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @return the range of company profiles
	 */
	public static List<CompanyProfile> getCompanyProfiles(int start, int end) {
		return getService().getCompanyProfiles(start, end);
	}

	public static List<CompanyProfile> getCompanyProfilesByGroupId(
		long groupId) {

		return getService().getCompanyProfilesByGroupId(groupId);
	}

	public static List<CompanyProfile> getCompanyProfilesByGroupId(
		long groupId, int start, int end) {

		return getService().getCompanyProfilesByGroupId(groupId, start, end);
	}

	public static List<CompanyProfile> getCompanyProfilesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getService().getCompanyProfilesByGroupId(
			groupId, start, end, orderByComparator);
	}

	public static List<CompanyProfile> getCompanyProfilesByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getService().getCompanyProfilesByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns all the company profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the company profiles
	 * @param companyId the primary key of the company
	 * @return the matching company profiles, or an empty list if no matches were found
	 */
	public static List<CompanyProfile> getCompanyProfilesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCompanyProfilesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of company profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the company profiles
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of company profiles
	 * @param end the upper bound of the range of company profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching company profiles, or an empty list if no matches were found
	 */
	public static List<CompanyProfile> getCompanyProfilesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompanyProfile> orderByComparator) {

		return getService().getCompanyProfilesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of company profiles.
	 *
	 * @return the number of company profiles
	 */
	public static int getCompanyProfilesCount() {
		return getService().getCompanyProfilesCount();
	}

	public static long getCompanyProfilesCountByKeywords(
		long groupId, String keywords) {

		return getService().getCompanyProfilesCountByKeywords(
			groupId, keywords);
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

	/**
	 * Updates the company profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompanyProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param companyProfile the company profile
	 * @return the company profile that was updated
	 */
	public static CompanyProfile updateCompanyProfile(
		CompanyProfile companyProfile) {

		return getService().updateCompanyProfile(companyProfile);
	}

	public static CompanyProfile updateCompanyProfile(
			long companyProfileId, long regionId, boolean active,
			Map<java.util.Locale, String> titleMap,
			Map<java.util.Locale, String> descriptionMap, String email,
			Map<java.util.Locale, String> sectorMap, String website,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateCompanyProfile(
			companyProfileId, regionId, active, titleMap, descriptionMap, email,
			sectorMap, website, serviceContext);
	}

	public static CompanyProfileLocalService getService() {
		return _service;
	}

	private static volatile CompanyProfileLocalService _service;

}