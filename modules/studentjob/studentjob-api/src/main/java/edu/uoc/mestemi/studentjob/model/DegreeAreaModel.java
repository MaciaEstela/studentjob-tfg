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
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DegreeArea service. Represents a row in the &quot;SJob_DegreeArea&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>edu.uoc.mestemi.studentjob.model.impl.DegreeAreaModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>edu.uoc.mestemi.studentjob.model.impl.DegreeAreaImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DegreeArea
 * @generated
 */
@ProviderType
public interface DegreeAreaModel
	extends BaseModel<DegreeArea>, LocalizedModel, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a degree area model instance should use the {@link DegreeArea} interface instead.
	 */

	/**
	 * Returns the primary key of this degree area.
	 *
	 * @return the primary key of this degree area
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this degree area.
	 *
	 * @param primaryKey the primary key of this degree area
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this degree area.
	 *
	 * @return the uuid of this degree area
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this degree area.
	 *
	 * @param uuid the uuid of this degree area
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the degree area ID of this degree area.
	 *
	 * @return the degree area ID of this degree area
	 */
	public long getDegreeAreaId();

	/**
	 * Sets the degree area ID of this degree area.
	 *
	 * @param degreeAreaId the degree area ID of this degree area
	 */
	public void setDegreeAreaId(long degreeAreaId);

	/**
	 * Returns the group ID of this degree area.
	 *
	 * @return the group ID of this degree area
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this degree area.
	 *
	 * @param groupId the group ID of this degree area
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this degree area.
	 *
	 * @return the company ID of this degree area
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this degree area.
	 *
	 * @param companyId the company ID of this degree area
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this degree area.
	 *
	 * @return the user ID of this degree area
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this degree area.
	 *
	 * @param userId the user ID of this degree area
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this degree area.
	 *
	 * @return the user uuid of this degree area
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this degree area.
	 *
	 * @param userUuid the user uuid of this degree area
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this degree area.
	 *
	 * @return the create date of this degree area
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this degree area.
	 *
	 * @param createDate the create date of this degree area
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this degree area.
	 *
	 * @return the modified date of this degree area
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this degree area.
	 *
	 * @param modifiedDate the modified date of this degree area
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this degree area.
	 *
	 * @return the name of this degree area
	 */
	public String getName();

	/**
	 * Returns the localized name of this degree area in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this degree area
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this degree area in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this degree area. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this degree area in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this degree area
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this degree area in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this degree area
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this degree area.
	 *
	 * @return the locales and localized names of this degree area
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this degree area.
	 *
	 * @param name the name of this degree area
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this degree area in the language.
	 *
	 * @param name the localized name of this degree area
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this degree area in the language, and sets the default locale.
	 *
	 * @param name the localized name of this degree area
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this degree area from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this degree area
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this degree area from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this degree area
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

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
	public DegreeArea cloneWithOriginalValues();

}