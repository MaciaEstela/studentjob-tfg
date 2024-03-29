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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the StudentProfile service. Represents a row in the &quot;SJob_StudentProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>edu.uoc.mestemi.studentjob.model.impl.StudentProfileModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>edu.uoc.mestemi.studentjob.model.impl.StudentProfileImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentProfile
 * @generated
 */
@ProviderType
public interface StudentProfileModel
	extends BaseModel<StudentProfile>, GroupedModel, LocalizedModel,
			ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a student profile model instance should use the {@link StudentProfile} interface instead.
	 */

	/**
	 * Returns the primary key of this student profile.
	 *
	 * @return the primary key of this student profile
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this student profile.
	 *
	 * @param primaryKey the primary key of this student profile
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this student profile.
	 *
	 * @return the uuid of this student profile
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this student profile.
	 *
	 * @param uuid the uuid of this student profile
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the student profile ID of this student profile.
	 *
	 * @return the student profile ID of this student profile
	 */
	public long getStudentProfileId();

	/**
	 * Sets the student profile ID of this student profile.
	 *
	 * @param studentProfileId the student profile ID of this student profile
	 */
	public void setStudentProfileId(long studentProfileId);

	/**
	 * Returns the region ID of this student profile.
	 *
	 * @return the region ID of this student profile
	 */
	public long getRegionId();

	/**
	 * Sets the region ID of this student profile.
	 *
	 * @param regionId the region ID of this student profile
	 */
	public void setRegionId(long regionId);

	/**
	 * Returns the group ID of this student profile.
	 *
	 * @return the group ID of this student profile
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this student profile.
	 *
	 * @param groupId the group ID of this student profile
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this student profile.
	 *
	 * @return the company ID of this student profile
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this student profile.
	 *
	 * @param companyId the company ID of this student profile
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this student profile.
	 *
	 * @return the user ID of this student profile
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this student profile.
	 *
	 * @param userId the user ID of this student profile
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this student profile.
	 *
	 * @return the user uuid of this student profile
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this student profile.
	 *
	 * @param userUuid the user uuid of this student profile
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this student profile.
	 *
	 * @return the user name of this student profile
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this student profile.
	 *
	 * @param userName the user name of this student profile
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this student profile.
	 *
	 * @return the create date of this student profile
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this student profile.
	 *
	 * @param createDate the create date of this student profile
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this student profile.
	 *
	 * @return the modified date of this student profile
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this student profile.
	 *
	 * @param modifiedDate the modified date of this student profile
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the active of this student profile.
	 *
	 * @return the active of this student profile
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this student profile is active.
	 *
	 * @return <code>true</code> if this student profile is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this student profile is active.
	 *
	 * @param active the active of this student profile
	 */
	public void setActive(boolean active);

	/**
	 * Returns the title of this student profile.
	 *
	 * @return the title of this student profile
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this student profile in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this student profile
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this student profile in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this student profile. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this student profile in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this student profile
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this student profile in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this student profile
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this student profile.
	 *
	 * @return the locales and localized titles of this student profile
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this student profile.
	 *
	 * @param title the title of this student profile
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this student profile in the language.
	 *
	 * @param title the localized title of this student profile
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this student profile in the language, and sets the default locale.
	 *
	 * @param title the localized title of this student profile
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this student profile from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this student profile
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this student profile from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this student profile
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this student profile.
	 *
	 * @return the description of this student profile
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this student profile in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this student profile
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this student profile in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this student profile. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this student profile in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this student profile
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this student profile in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this student profile
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this student profile.
	 *
	 * @return the locales and localized descriptions of this student profile
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this student profile.
	 *
	 * @param description the description of this student profile
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this student profile in the language.
	 *
	 * @param description the localized description of this student profile
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this student profile in the language, and sets the default locale.
	 *
	 * @param description the localized description of this student profile
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this student profile from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this student profile
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this student profile from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this student profile
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the email of this student profile.
	 *
	 * @return the email of this student profile
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this student profile.
	 *
	 * @param email the email of this student profile
	 */
	public void setEmail(String email);

	/**
	 * Returns the preference of this student profile.
	 *
	 * @return the preference of this student profile
	 */
	@AutoEscape
	public String getPreference();

	/**
	 * Sets the preference of this student profile.
	 *
	 * @param preference the preference of this student profile
	 */
	public void setPreference(String preference);

	/**
	 * Returns the curriculum ID of this student profile.
	 *
	 * @return the curriculum ID of this student profile
	 */
	public long getCurriculumId();

	/**
	 * Sets the curriculum ID of this student profile.
	 *
	 * @param curriculumId the curriculum ID of this student profile
	 */
	public void setCurriculumId(long curriculumId);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public StudentProfile cloneWithOriginalValues();

}