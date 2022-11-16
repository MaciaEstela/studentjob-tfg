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

package edu.uoc.mestemi.studentjob.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CompanyProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompanyProfile
 * @generated
 */
public class CompanyProfileWrapper
	extends BaseModelWrapper<CompanyProfile>
	implements CompanyProfile, ModelWrapper<CompanyProfile> {

	public CompanyProfileWrapper(CompanyProfile companyProfile) {
		super(companyProfile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("companyProfileId", getCompanyProfileId());
		attributes.put("regionId", getRegionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("email", getEmail());
		attributes.put("sector", getSector());
		attributes.put("website", getWebsite());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long companyProfileId = (Long)attributes.get("companyProfileId");

		if (companyProfileId != null) {
			setCompanyProfileId(companyProfileId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String sector = (String)attributes.get("sector");

		if (sector != null) {
			setSector(sector);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}
	}

	@Override
	public CompanyProfile cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this company profile.
	 *
	 * @return the active of this company profile
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this company profile.
	 *
	 * @return the company ID of this company profile
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the company profile ID of this company profile.
	 *
	 * @return the company profile ID of this company profile
	 */
	@Override
	public long getCompanyProfileId() {
		return model.getCompanyProfileId();
	}

	/**
	 * Returns the create date of this company profile.
	 *
	 * @return the create date of this company profile
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this company profile.
	 *
	 * @return the description of this company profile
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this company profile in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this company profile
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this company profile in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this company profile. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this company profile in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this company profile
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this company profile in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this company profile
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this company profile.
	 *
	 * @return the locales and localized descriptions of this company profile
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the email of this company profile.
	 *
	 * @return the email of this company profile
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this company profile.
	 *
	 * @return the group ID of this company profile
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this company profile.
	 *
	 * @return the modified date of this company profile
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this company profile.
	 *
	 * @return the primary key of this company profile
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the region ID of this company profile.
	 *
	 * @return the region ID of this company profile
	 */
	@Override
	public long getRegionId() {
		return model.getRegionId();
	}

	/**
	 * Returns the sector of this company profile.
	 *
	 * @return the sector of this company profile
	 */
	@Override
	public String getSector() {
		return model.getSector();
	}

	/**
	 * Returns the localized sector of this company profile in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized sector of this company profile
	 */
	@Override
	public String getSector(java.util.Locale locale) {
		return model.getSector(locale);
	}

	/**
	 * Returns the localized sector of this company profile in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized sector of this company profile. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSector(java.util.Locale locale, boolean useDefault) {
		return model.getSector(locale, useDefault);
	}

	/**
	 * Returns the localized sector of this company profile in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized sector of this company profile
	 */
	@Override
	public String getSector(String languageId) {
		return model.getSector(languageId);
	}

	/**
	 * Returns the localized sector of this company profile in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized sector of this company profile
	 */
	@Override
	public String getSector(String languageId, boolean useDefault) {
		return model.getSector(languageId, useDefault);
	}

	@Override
	public String getSectorCurrentLanguageId() {
		return model.getSectorCurrentLanguageId();
	}

	@Override
	public String getSectorCurrentValue() {
		return model.getSectorCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized sectors of this company profile.
	 *
	 * @return the locales and localized sectors of this company profile
	 */
	@Override
	public Map<java.util.Locale, String> getSectorMap() {
		return model.getSectorMap();
	}

	/**
	 * Returns the title of this company profile.
	 *
	 * @return the title of this company profile
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this company profile in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this company profile
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this company profile in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this company profile. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this company profile in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this company profile
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this company profile in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this company profile
	 */
	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return model.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return model.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return model.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this company profile.
	 *
	 * @return the locales and localized titles of this company profile
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Returns the user ID of this company profile.
	 *
	 * @return the user ID of this company profile
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this company profile.
	 *
	 * @return the user name of this company profile
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this company profile.
	 *
	 * @return the user uuid of this company profile
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this company profile.
	 *
	 * @return the uuid of this company profile
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the website of this company profile.
	 *
	 * @return the website of this company profile
	 */
	@Override
	public String getWebsite() {
		return model.getWebsite();
	}

	/**
	 * Returns <code>true</code> if this company profile is active.
	 *
	 * @return <code>true</code> if this company profile is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets whether this company profile is active.
	 *
	 * @param active the active of this company profile
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this company profile.
	 *
	 * @param companyId the company ID of this company profile
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the company profile ID of this company profile.
	 *
	 * @param companyProfileId the company profile ID of this company profile
	 */
	@Override
	public void setCompanyProfileId(long companyProfileId) {
		model.setCompanyProfileId(companyProfileId);
	}

	/**
	 * Sets the create date of this company profile.
	 *
	 * @param createDate the create date of this company profile
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this company profile.
	 *
	 * @param description the description of this company profile
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this company profile in the language.
	 *
	 * @param description the localized description of this company profile
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this company profile in the language, and sets the default locale.
	 *
	 * @param description the localized description of this company profile
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this company profile from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this company profile
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this company profile from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this company profile
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the email of this company profile.
	 *
	 * @param email the email of this company profile
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this company profile.
	 *
	 * @param groupId the group ID of this company profile
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this company profile.
	 *
	 * @param modifiedDate the modified date of this company profile
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this company profile.
	 *
	 * @param primaryKey the primary key of this company profile
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the region ID of this company profile.
	 *
	 * @param regionId the region ID of this company profile
	 */
	@Override
	public void setRegionId(long regionId) {
		model.setRegionId(regionId);
	}

	/**
	 * Sets the sector of this company profile.
	 *
	 * @param sector the sector of this company profile
	 */
	@Override
	public void setSector(String sector) {
		model.setSector(sector);
	}

	/**
	 * Sets the localized sector of this company profile in the language.
	 *
	 * @param sector the localized sector of this company profile
	 * @param locale the locale of the language
	 */
	@Override
	public void setSector(String sector, java.util.Locale locale) {
		model.setSector(sector, locale);
	}

	/**
	 * Sets the localized sector of this company profile in the language, and sets the default locale.
	 *
	 * @param sector the localized sector of this company profile
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSector(
		String sector, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setSector(sector, locale, defaultLocale);
	}

	@Override
	public void setSectorCurrentLanguageId(String languageId) {
		model.setSectorCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized sectors of this company profile from the map of locales and localized sectors.
	 *
	 * @param sectorMap the locales and localized sectors of this company profile
	 */
	@Override
	public void setSectorMap(Map<java.util.Locale, String> sectorMap) {
		model.setSectorMap(sectorMap);
	}

	/**
	 * Sets the localized sectors of this company profile from the map of locales and localized sectors, and sets the default locale.
	 *
	 * @param sectorMap the locales and localized sectors of this company profile
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSectorMap(
		Map<java.util.Locale, String> sectorMap,
		java.util.Locale defaultLocale) {

		model.setSectorMap(sectorMap, defaultLocale);
	}

	/**
	 * Sets the title of this company profile.
	 *
	 * @param title the title of this company profile
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this company profile in the language.
	 *
	 * @param title the localized title of this company profile
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this company profile in the language, and sets the default locale.
	 *
	 * @param title the localized title of this company profile
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitle(
		String title, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		model.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this company profile from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this company profile
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this company profile from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this company profile
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this company profile.
	 *
	 * @param userId the user ID of this company profile
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this company profile.
	 *
	 * @param userName the user name of this company profile
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this company profile.
	 *
	 * @param userUuid the user uuid of this company profile
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this company profile.
	 *
	 * @param uuid the uuid of this company profile
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the website of this company profile.
	 *
	 * @param website the website of this company profile
	 */
	@Override
	public void setWebsite(String website) {
		model.setWebsite(website);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CompanyProfileWrapper wrap(CompanyProfile companyProfile) {
		return new CompanyProfileWrapper(companyProfile);
	}

}