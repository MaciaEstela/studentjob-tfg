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

package edu.uoc.mestemi.studentjob.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import edu.uoc.mestemi.studentjob.model.DegreeArea;
import edu.uoc.mestemi.studentjob.model.DegreeAreaModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DegreeArea service. Represents a row in the &quot;SJob_DegreeArea&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DegreeAreaModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DegreeAreaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DegreeAreaImpl
 * @generated
 */
@JSON(strict = true)
public class DegreeAreaModelImpl
	extends BaseModelImpl<DegreeArea> implements DegreeAreaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a degree area model instance should use the <code>DegreeArea</code> interface instead.
	 */
	public static final String TABLE_NAME = "SJob_DegreeArea";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"degreeAreaId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("degreeAreaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SJob_DegreeArea (uuid_ VARCHAR(75) null,degreeAreaId LONG not null primary key,groupId LONG,companyId LONG,name STRING null)";

	public static final String TABLE_SQL_DROP = "drop table SJob_DegreeArea";

	public static final String ORDER_BY_JPQL = " ORDER BY degreeArea.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SJob_DegreeArea.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public static final String MAPPING_TABLE_SJOB_DEGREES_DEGREESAREAS_NAME =
		"SJob_Degrees_DegreesAreas";

	public static final Object[][]
		MAPPING_TABLE_SJOB_DEGREES_DEGREESAREAS_COLUMNS = {
			{"companyId", Types.BIGINT}, {"degreeId", Types.BIGINT},
			{"degreeAreaId", Types.BIGINT}
		};

	public static final String
		MAPPING_TABLE_SJOB_DEGREES_DEGREESAREAS_SQL_CREATE =
			"create table SJob_Degrees_DegreesAreas (companyId LONG not null,degreeId LONG not null,degreeAreaId LONG not null,primary key (degreeId, degreeAreaId))";

	public DegreeAreaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _degreeAreaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDegreeAreaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _degreeAreaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DegreeArea.class;
	}

	@Override
	public String getModelClassName() {
		return DegreeArea.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DegreeArea, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DegreeArea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DegreeArea, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((DegreeArea)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DegreeArea, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DegreeArea, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DegreeArea)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DegreeArea, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DegreeArea, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DegreeArea, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DegreeArea, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DegreeArea, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DegreeArea, Object>>();
		Map<String, BiConsumer<DegreeArea, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DegreeArea, ?>>();

		attributeGetterFunctions.put("uuid", DegreeArea::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<DegreeArea, String>)DegreeArea::setUuid);
		attributeGetterFunctions.put(
			"degreeAreaId", DegreeArea::getDegreeAreaId);
		attributeSetterBiConsumers.put(
			"degreeAreaId",
			(BiConsumer<DegreeArea, Long>)DegreeArea::setDegreeAreaId);
		attributeGetterFunctions.put("groupId", DegreeArea::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<DegreeArea, Long>)DegreeArea::setGroupId);
		attributeGetterFunctions.put("companyId", DegreeArea::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DegreeArea, Long>)DegreeArea::setCompanyId);
		attributeGetterFunctions.put("name", DegreeArea::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<DegreeArea, String>)DegreeArea::setName);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getDegreeAreaId() {
		return _degreeAreaId;
	}

	@Override
	public void setDegreeAreaId(long degreeAreaId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_degreeAreaId = degreeAreaId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getName(), languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(
				LocalizationUtil.updateLocalization(
					getName(), "Name", name, languageId, defaultLanguageId));
		}
		else {
			setName(
				LocalizationUtil.removeLocalization(
					getName(), "Name", languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(
			LocalizationUtil.updateLocalization(
				nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DegreeArea.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			DegreeArea.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public DegreeArea toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DegreeArea>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DegreeAreaImpl degreeAreaImpl = new DegreeAreaImpl();

		degreeAreaImpl.setUuid(getUuid());
		degreeAreaImpl.setDegreeAreaId(getDegreeAreaId());
		degreeAreaImpl.setGroupId(getGroupId());
		degreeAreaImpl.setCompanyId(getCompanyId());
		degreeAreaImpl.setName(getName());

		degreeAreaImpl.resetOriginalValues();

		return degreeAreaImpl;
	}

	@Override
	public DegreeArea cloneWithOriginalValues() {
		DegreeAreaImpl degreeAreaImpl = new DegreeAreaImpl();

		degreeAreaImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		degreeAreaImpl.setDegreeAreaId(
			this.<Long>getColumnOriginalValue("degreeAreaId"));
		degreeAreaImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		degreeAreaImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		degreeAreaImpl.setName(this.<String>getColumnOriginalValue("name"));

		return degreeAreaImpl;
	}

	@Override
	public int compareTo(DegreeArea degreeArea) {
		int value = 0;

		value = getName().compareTo(degreeArea.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DegreeArea)) {
			return false;
		}

		DegreeArea degreeArea = (DegreeArea)object;

		long primaryKey = degreeArea.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<DegreeArea> toCacheModel() {
		DegreeAreaCacheModel degreeAreaCacheModel = new DegreeAreaCacheModel();

		degreeAreaCacheModel.uuid = getUuid();

		String uuid = degreeAreaCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			degreeAreaCacheModel.uuid = null;
		}

		degreeAreaCacheModel.degreeAreaId = getDegreeAreaId();

		degreeAreaCacheModel.groupId = getGroupId();

		degreeAreaCacheModel.companyId = getCompanyId();

		degreeAreaCacheModel.name = getName();

		String name = degreeAreaCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			degreeAreaCacheModel.name = null;
		}

		return degreeAreaCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DegreeArea, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DegreeArea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DegreeArea, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DegreeArea)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<DegreeArea, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DegreeArea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DegreeArea, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DegreeArea)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DegreeArea>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DegreeArea.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _degreeAreaId;
	private long _groupId;
	private long _companyId;
	private String _name;
	private String _nameCurrentLanguageId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DegreeArea, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DegreeArea)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("degreeAreaId", _degreeAreaId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("name", _name);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("degreeAreaId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("name", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DegreeArea _escapedModel;

}