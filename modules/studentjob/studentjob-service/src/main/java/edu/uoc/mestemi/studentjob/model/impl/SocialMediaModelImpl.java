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
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.model.SocialMediaModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the SocialMedia service. Represents a row in the &quot;SJob_SocialMedia&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SocialMediaModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SocialMediaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaImpl
 * @generated
 */
@JSON(strict = true)
public class SocialMediaModelImpl
	extends BaseModelImpl<SocialMedia> implements SocialMediaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a social media model instance should use the <code>SocialMedia</code> interface instead.
	 */
	public static final String TABLE_NAME = "SJob_SocialMedia";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"socialMediaId", Types.BIGINT},
		{"socialMediaNetworkId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"socialURL", Types.VARCHAR},
		{"className", Types.VARCHAR}, {"classPK", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("socialMediaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("socialMediaNetworkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("socialURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("className", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SJob_SocialMedia (uuid_ VARCHAR(75) null,socialMediaId LONG not null primary key,socialMediaNetworkId LONG,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,socialURL VARCHAR(75) null,className VARCHAR(75) null,classPK LONG)";

	public static final String TABLE_SQL_DROP = "drop table SJob_SocialMedia";

	public static final String ORDER_BY_JPQL =
		" ORDER BY socialMedia.className ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SJob_SocialMedia.className ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CLASSNAME_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SOCIALMEDIANETWORKID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

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

	public SocialMediaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _socialMediaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSocialMediaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _socialMediaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SocialMedia.class;
	}

	@Override
	public String getModelClassName() {
		return SocialMedia.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SocialMedia, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SocialMedia, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SocialMedia, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SocialMedia)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SocialMedia, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SocialMedia, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SocialMedia)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SocialMedia, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SocialMedia, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<SocialMedia, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SocialMedia, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SocialMedia, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SocialMedia, Object>>();
		Map<String, BiConsumer<SocialMedia, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SocialMedia, ?>>();

		attributeGetterFunctions.put("uuid", SocialMedia::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<SocialMedia, String>)SocialMedia::setUuid);
		attributeGetterFunctions.put(
			"socialMediaId", SocialMedia::getSocialMediaId);
		attributeSetterBiConsumers.put(
			"socialMediaId",
			(BiConsumer<SocialMedia, Long>)SocialMedia::setSocialMediaId);
		attributeGetterFunctions.put(
			"socialMediaNetworkId", SocialMedia::getSocialMediaNetworkId);
		attributeSetterBiConsumers.put(
			"socialMediaNetworkId",
			(BiConsumer<SocialMedia, Long>)
				SocialMedia::setSocialMediaNetworkId);
		attributeGetterFunctions.put("groupId", SocialMedia::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<SocialMedia, Long>)SocialMedia::setGroupId);
		attributeGetterFunctions.put("companyId", SocialMedia::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SocialMedia, Long>)SocialMedia::setCompanyId);
		attributeGetterFunctions.put("userId", SocialMedia::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<SocialMedia, Long>)SocialMedia::setUserId);
		attributeGetterFunctions.put("userName", SocialMedia::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<SocialMedia, String>)SocialMedia::setUserName);
		attributeGetterFunctions.put("createDate", SocialMedia::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SocialMedia, Date>)SocialMedia::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", SocialMedia::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<SocialMedia, Date>)SocialMedia::setModifiedDate);
		attributeGetterFunctions.put("socialURL", SocialMedia::getSocialURL);
		attributeSetterBiConsumers.put(
			"socialURL",
			(BiConsumer<SocialMedia, String>)SocialMedia::setSocialURL);
		attributeGetterFunctions.put("className", SocialMedia::getClassName);
		attributeSetterBiConsumers.put(
			"className",
			(BiConsumer<SocialMedia, String>)SocialMedia::setClassName);
		attributeGetterFunctions.put("classPK", SocialMedia::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK", (BiConsumer<SocialMedia, Long>)SocialMedia::setClassPK);

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
	public long getSocialMediaId() {
		return _socialMediaId;
	}

	@Override
	public void setSocialMediaId(long socialMediaId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_socialMediaId = socialMediaId;
	}

	@JSON
	@Override
	public long getSocialMediaNetworkId() {
		return _socialMediaNetworkId;
	}

	@Override
	public void setSocialMediaNetworkId(long socialMediaNetworkId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_socialMediaNetworkId = socialMediaNetworkId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalSocialMediaNetworkId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("socialMediaNetworkId"));
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
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getSocialURL() {
		if (_socialURL == null) {
			return "";
		}
		else {
			return _socialURL;
		}
	}

	@Override
	public void setSocialURL(String socialURL) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_socialURL = socialURL;
	}

	@JSON
	@Override
	public String getClassName() {
		if (_className == null) {
			return "";
		}
		else {
			return _className;
		}
	}

	@Override
	public void setClassName(String className) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_className = className;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalClassName() {
		return getColumnOriginalValue("className");
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_classPK = classPK;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassPK() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("classPK"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(SocialMedia.class.getName()));
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
			getCompanyId(), SocialMedia.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SocialMedia toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SocialMedia>
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
		SocialMediaImpl socialMediaImpl = new SocialMediaImpl();

		socialMediaImpl.setUuid(getUuid());
		socialMediaImpl.setSocialMediaId(getSocialMediaId());
		socialMediaImpl.setSocialMediaNetworkId(getSocialMediaNetworkId());
		socialMediaImpl.setGroupId(getGroupId());
		socialMediaImpl.setCompanyId(getCompanyId());
		socialMediaImpl.setUserId(getUserId());
		socialMediaImpl.setUserName(getUserName());
		socialMediaImpl.setCreateDate(getCreateDate());
		socialMediaImpl.setModifiedDate(getModifiedDate());
		socialMediaImpl.setSocialURL(getSocialURL());
		socialMediaImpl.setClassName(getClassName());
		socialMediaImpl.setClassPK(getClassPK());

		socialMediaImpl.resetOriginalValues();

		return socialMediaImpl;
	}

	@Override
	public SocialMedia cloneWithOriginalValues() {
		SocialMediaImpl socialMediaImpl = new SocialMediaImpl();

		socialMediaImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		socialMediaImpl.setSocialMediaId(
			this.<Long>getColumnOriginalValue("socialMediaId"));
		socialMediaImpl.setSocialMediaNetworkId(
			this.<Long>getColumnOriginalValue("socialMediaNetworkId"));
		socialMediaImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		socialMediaImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		socialMediaImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		socialMediaImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		socialMediaImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		socialMediaImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		socialMediaImpl.setSocialURL(
			this.<String>getColumnOriginalValue("socialURL"));
		socialMediaImpl.setClassName(
			this.<String>getColumnOriginalValue("className"));
		socialMediaImpl.setClassPK(
			this.<Long>getColumnOriginalValue("classPK"));

		return socialMediaImpl;
	}

	@Override
	public int compareTo(SocialMedia socialMedia) {
		int value = 0;

		value = getClassName().compareTo(socialMedia.getClassName());

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

		if (!(object instanceof SocialMedia)) {
			return false;
		}

		SocialMedia socialMedia = (SocialMedia)object;

		long primaryKey = socialMedia.getPrimaryKey();

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

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<SocialMedia> toCacheModel() {
		SocialMediaCacheModel socialMediaCacheModel =
			new SocialMediaCacheModel();

		socialMediaCacheModel.uuid = getUuid();

		String uuid = socialMediaCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			socialMediaCacheModel.uuid = null;
		}

		socialMediaCacheModel.socialMediaId = getSocialMediaId();

		socialMediaCacheModel.socialMediaNetworkId = getSocialMediaNetworkId();

		socialMediaCacheModel.groupId = getGroupId();

		socialMediaCacheModel.companyId = getCompanyId();

		socialMediaCacheModel.userId = getUserId();

		socialMediaCacheModel.userName = getUserName();

		String userName = socialMediaCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			socialMediaCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			socialMediaCacheModel.createDate = createDate.getTime();
		}
		else {
			socialMediaCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			socialMediaCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			socialMediaCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		socialMediaCacheModel.socialURL = getSocialURL();

		String socialURL = socialMediaCacheModel.socialURL;

		if ((socialURL != null) && (socialURL.length() == 0)) {
			socialMediaCacheModel.socialURL = null;
		}

		socialMediaCacheModel.className = getClassName();

		String className = socialMediaCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			socialMediaCacheModel.className = null;
		}

		socialMediaCacheModel.classPK = getClassPK();

		return socialMediaCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SocialMedia, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SocialMedia, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SocialMedia, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((SocialMedia)this);

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
		Map<String, Function<SocialMedia, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SocialMedia, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SocialMedia, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SocialMedia)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SocialMedia>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					SocialMedia.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _socialMediaId;
	private long _socialMediaNetworkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _socialURL;
	private String _className;
	private long _classPK;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<SocialMedia, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((SocialMedia)this);
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
		_columnOriginalValues.put("socialMediaId", _socialMediaId);
		_columnOriginalValues.put(
			"socialMediaNetworkId", _socialMediaNetworkId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("socialURL", _socialURL);
		_columnOriginalValues.put("className", _className);
		_columnOriginalValues.put("classPK", _classPK);
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

		columnBitmasks.put("socialMediaId", 2L);

		columnBitmasks.put("socialMediaNetworkId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("socialURL", 512L);

		columnBitmasks.put("className", 1024L);

		columnBitmasks.put("classPK", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private SocialMedia _escapedModel;

}