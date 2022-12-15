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
 * Provides a wrapper for {@link CompanyProfileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CompanyProfileLocalService
 * @generated
 */
public class CompanyProfileLocalServiceWrapper
	implements CompanyProfileLocalService,
			   ServiceWrapper<CompanyProfileLocalService> {

	public CompanyProfileLocalServiceWrapper() {
		this(null);
	}

	public CompanyProfileLocalServiceWrapper(
		CompanyProfileLocalService companyProfileLocalService) {

		_companyProfileLocalService = companyProfileLocalService;
	}

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
	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile addCompanyProfile(
		edu.uoc.mestemi.studentjob.model.CompanyProfile companyProfile) {

		return _companyProfileLocalService.addCompanyProfile(companyProfile);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile addCompanyProfile(
			long groupId, long userId, long regionId, boolean active,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String email, java.util.Map<java.util.Locale, String> sectorMap,
			String website,
			java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
				socialMedias,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileLocalService.addCompanyProfile(
			groupId, userId, regionId, active, titleMap, descriptionMap, email,
			sectorMap, website, socialMedias, serviceContext);
	}

	/**
	 * Creates a new company profile with the primary key. Does not add the company profile to the database.
	 *
	 * @param companyProfileId the primary key for the new company profile
	 * @return the new company profile
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile createCompanyProfile(
		long companyProfileId) {

		return _companyProfileLocalService.createCompanyProfile(
			companyProfileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile deleteCompanyProfile(
		edu.uoc.mestemi.studentjob.model.CompanyProfile companyProfile) {

		return _companyProfileLocalService.deleteCompanyProfile(companyProfile);
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
	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile deleteCompanyProfile(
			long companyProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileLocalService.deleteCompanyProfile(
			companyProfileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _companyProfileLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _companyProfileLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _companyProfileLocalService.dynamicQuery();
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

		return _companyProfileLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _companyProfileLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _companyProfileLocalService.dynamicQuery(
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

		return _companyProfileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _companyProfileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile fetchCompanyProfile(
		long companyProfileId) {

		return _companyProfileLocalService.fetchCompanyProfile(
			companyProfileId);
	}

	/**
	 * Returns the company profile matching the UUID and group.
	 *
	 * @param uuid the company profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching company profile, or <code>null</code> if a matching company profile could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile
		fetchCompanyProfileByUuidAndGroupId(String uuid, long groupId) {

		return _companyProfileLocalService.fetchCompanyProfileByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _companyProfileLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the company profile with the primary key.
	 *
	 * @param companyProfileId the primary key of the company profile
	 * @return the company profile
	 * @throws PortalException if a company profile with the primary key could not be found
	 */
	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile getCompanyProfile(
			long companyProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileLocalService.getCompanyProfile(companyProfileId);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile
		getCompanyProfileByGroupIdAndUserId(long groupId, long userId) {

		return _companyProfileLocalService.getCompanyProfileByGroupIdAndUserId(
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
	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile
			getCompanyProfileByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileLocalService.getCompanyProfileByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.CompanyProfile>
		getCompanyProfiles(int start, int end) {

		return _companyProfileLocalService.getCompanyProfiles(start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.CompanyProfile>
		getCompanyProfilesByGroupId(long groupId) {

		return _companyProfileLocalService.getCompanyProfilesByGroupId(groupId);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.CompanyProfile>
		getCompanyProfilesByGroupId(long groupId, int start, int end) {

		return _companyProfileLocalService.getCompanyProfilesByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.CompanyProfile>
		getCompanyProfilesByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.CompanyProfile>
					orderByComparator) {

		return _companyProfileLocalService.getCompanyProfilesByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.CompanyProfile>
		getCompanyProfilesByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.CompanyProfile>
					orderByComparator) {

		return _companyProfileLocalService.getCompanyProfilesByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns all the company profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the company profiles
	 * @param companyId the primary key of the company
	 * @return the matching company profiles, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.CompanyProfile>
		getCompanyProfilesByUuidAndCompanyId(String uuid, long companyId) {

		return _companyProfileLocalService.getCompanyProfilesByUuidAndCompanyId(
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
	@Override
	public java.util.List<edu.uoc.mestemi.studentjob.model.CompanyProfile>
		getCompanyProfilesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.CompanyProfile>
					orderByComparator) {

		return _companyProfileLocalService.getCompanyProfilesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of company profiles.
	 *
	 * @return the number of company profiles
	 */
	@Override
	public int getCompanyProfilesCount() {
		return _companyProfileLocalService.getCompanyProfilesCount();
	}

	@Override
	public long getCompanyProfilesCountByKeywords(
		long groupId, String keywords) {

		return _companyProfileLocalService.getCompanyProfilesCountByKeywords(
			groupId, keywords);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _companyProfileLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _companyProfileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _companyProfileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile updateCompanyProfile(
		edu.uoc.mestemi.studentjob.model.CompanyProfile companyProfile) {

		return _companyProfileLocalService.updateCompanyProfile(companyProfile);
	}

	@Override
	public edu.uoc.mestemi.studentjob.model.CompanyProfile updateCompanyProfile(
			long companyProfileId, long regionId, boolean active,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String email, java.util.Map<java.util.Locale, String> sectorMap,
			String website,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _companyProfileLocalService.updateCompanyProfile(
			companyProfileId, regionId, active, titleMap, descriptionMap, email,
			sectorMap, website, serviceContext);
	}

	@Override
	public CompanyProfileLocalService getWrappedService() {
		return _companyProfileLocalService;
	}

	@Override
	public void setWrappedService(
		CompanyProfileLocalService companyProfileLocalService) {

		_companyProfileLocalService = companyProfileLocalService;
	}

	private CompanyProfileLocalService _companyProfileLocalService;

}