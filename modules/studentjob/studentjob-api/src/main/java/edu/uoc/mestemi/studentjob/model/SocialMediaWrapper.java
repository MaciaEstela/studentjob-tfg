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
 * This class is a wrapper for {@link SocialMedia}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialMedia
 * @generated
 */
public class SocialMediaWrapper
	extends BaseModelWrapper<SocialMedia>
	implements ModelWrapper<SocialMedia>, SocialMedia {

	public SocialMediaWrapper(SocialMedia socialMedia) {
		super(socialMedia);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("socialMediaId", getSocialMediaId());
		attributes.put("socialMediaNetworkId", getSocialMediaNetworkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("socialMediaType", getSocialMediaType());
		attributes.put("socialURL", getSocialURL());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long socialMediaId = (Long)attributes.get("socialMediaId");

		if (socialMediaId != null) {
			setSocialMediaId(socialMediaId);
		}

		Long socialMediaNetworkId = (Long)attributes.get(
			"socialMediaNetworkId");

		if (socialMediaNetworkId != null) {
			setSocialMediaNetworkId(socialMediaNetworkId);
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

		String socialMediaType = (String)attributes.get("socialMediaType");

		if (socialMediaType != null) {
			setSocialMediaType(socialMediaType);
		}

		String socialURL = (String)attributes.get("socialURL");

		if (socialURL != null) {
			setSocialURL(socialURL);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}
	}

	@Override
	public SocialMedia cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the class name of this social media.
	 *
	 * @return the class name of this social media
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this social media.
	 *
	 * @return the class pk of this social media
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the company ID of this social media.
	 *
	 * @return the company ID of this social media
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this social media.
	 *
	 * @return the create date of this social media
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this social media.
	 *
	 * @return the group ID of this social media
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this social media.
	 *
	 * @return the modified date of this social media
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this social media.
	 *
	 * @return the primary key of this social media
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the social media ID of this social media.
	 *
	 * @return the social media ID of this social media
	 */
	@Override
	public long getSocialMediaId() {
		return model.getSocialMediaId();
	}

	/**
	 * Returns the social media network ID of this social media.
	 *
	 * @return the social media network ID of this social media
	 */
	@Override
	public long getSocialMediaNetworkId() {
		return model.getSocialMediaNetworkId();
	}

	/**
	 * Returns the social media type of this social media.
	 *
	 * @return the social media type of this social media
	 */
	@Override
	public String getSocialMediaType() {
		return model.getSocialMediaType();
	}

	/**
	 * Returns the social url of this social media.
	 *
	 * @return the social url of this social media
	 */
	@Override
	public String getSocialURL() {
		return model.getSocialURL();
	}

	/**
	 * Returns the user ID of this social media.
	 *
	 * @return the user ID of this social media
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this social media.
	 *
	 * @return the user name of this social media
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this social media.
	 *
	 * @return the user uuid of this social media
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this social media.
	 *
	 * @return the uuid of this social media
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the class name of this social media.
	 *
	 * @param className the class name of this social media
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this social media.
	 *
	 * @param classPK the class pk of this social media
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the company ID of this social media.
	 *
	 * @param companyId the company ID of this social media
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this social media.
	 *
	 * @param createDate the create date of this social media
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this social media.
	 *
	 * @param groupId the group ID of this social media
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this social media.
	 *
	 * @param modifiedDate the modified date of this social media
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this social media.
	 *
	 * @param primaryKey the primary key of this social media
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the social media ID of this social media.
	 *
	 * @param socialMediaId the social media ID of this social media
	 */
	@Override
	public void setSocialMediaId(long socialMediaId) {
		model.setSocialMediaId(socialMediaId);
	}

	/**
	 * Sets the social media network ID of this social media.
	 *
	 * @param socialMediaNetworkId the social media network ID of this social media
	 */
	@Override
	public void setSocialMediaNetworkId(long socialMediaNetworkId) {
		model.setSocialMediaNetworkId(socialMediaNetworkId);
	}

	/**
	 * Sets the social media type of this social media.
	 *
	 * @param socialMediaType the social media type of this social media
	 */
	@Override
	public void setSocialMediaType(String socialMediaType) {
		model.setSocialMediaType(socialMediaType);
	}

	/**
	 * Sets the social url of this social media.
	 *
	 * @param socialURL the social url of this social media
	 */
	@Override
	public void setSocialURL(String socialURL) {
		model.setSocialURL(socialURL);
	}

	/**
	 * Sets the user ID of this social media.
	 *
	 * @param userId the user ID of this social media
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this social media.
	 *
	 * @param userName the user name of this social media
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this social media.
	 *
	 * @param userUuid the user uuid of this social media
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this social media.
	 *
	 * @param uuid the uuid of this social media
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected SocialMediaWrapper wrap(SocialMedia socialMedia) {
		return new SocialMediaWrapper(socialMedia);
	}

}