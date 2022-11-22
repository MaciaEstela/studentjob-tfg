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
 * This class is a wrapper for {@link SocialMediaNetwork}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaNetwork
 * @generated
 */
public class SocialMediaNetworkWrapper
	extends BaseModelWrapper<SocialMediaNetwork>
	implements ModelWrapper<SocialMediaNetwork>, SocialMediaNetwork {

	public SocialMediaNetworkWrapper(SocialMediaNetwork socialMediaNetwork) {
		super(socialMediaNetwork);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("socialMediaNetworkId", getSocialMediaNetworkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("logo", getLogo());
		attributes.put("baseURL", getBaseURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long logo = (Long)attributes.get("logo");

		if (logo != null) {
			setLogo(logo);
		}

		String baseURL = (String)attributes.get("baseURL");

		if (baseURL != null) {
			setBaseURL(baseURL);
		}
	}

	@Override
	public SocialMediaNetwork cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the base url of this social media network.
	 *
	 * @return the base url of this social media network
	 */
	@Override
	public String getBaseURL() {
		return model.getBaseURL();
	}

	/**
	 * Returns the company ID of this social media network.
	 *
	 * @return the company ID of this social media network
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this social media network.
	 *
	 * @return the create date of this social media network
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this social media network.
	 *
	 * @return the group ID of this social media network
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the logo of this social media network.
	 *
	 * @return the logo of this social media network
	 */
	@Override
	public long getLogo() {
		return model.getLogo();
	}

	/**
	 * Returns the modified date of this social media network.
	 *
	 * @return the modified date of this social media network
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this social media network.
	 *
	 * @return the name of this social media network
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this social media network.
	 *
	 * @return the primary key of this social media network
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the social media network ID of this social media network.
	 *
	 * @return the social media network ID of this social media network
	 */
	@Override
	public long getSocialMediaNetworkId() {
		return model.getSocialMediaNetworkId();
	}

	/**
	 * Returns the user ID of this social media network.
	 *
	 * @return the user ID of this social media network
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this social media network.
	 *
	 * @return the user uuid of this social media network
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this social media network.
	 *
	 * @return the uuid of this social media network
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
	 * Sets the base url of this social media network.
	 *
	 * @param baseURL the base url of this social media network
	 */
	@Override
	public void setBaseURL(String baseURL) {
		model.setBaseURL(baseURL);
	}

	/**
	 * Sets the company ID of this social media network.
	 *
	 * @param companyId the company ID of this social media network
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this social media network.
	 *
	 * @param createDate the create date of this social media network
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this social media network.
	 *
	 * @param groupId the group ID of this social media network
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the logo of this social media network.
	 *
	 * @param logo the logo of this social media network
	 */
	@Override
	public void setLogo(long logo) {
		model.setLogo(logo);
	}

	/**
	 * Sets the modified date of this social media network.
	 *
	 * @param modifiedDate the modified date of this social media network
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this social media network.
	 *
	 * @param name the name of this social media network
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this social media network.
	 *
	 * @param primaryKey the primary key of this social media network
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the social media network ID of this social media network.
	 *
	 * @param socialMediaNetworkId the social media network ID of this social media network
	 */
	@Override
	public void setSocialMediaNetworkId(long socialMediaNetworkId) {
		model.setSocialMediaNetworkId(socialMediaNetworkId);
	}

	/**
	 * Sets the user ID of this social media network.
	 *
	 * @param userId the user ID of this social media network
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this social media network.
	 *
	 * @param userUuid the user uuid of this social media network
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this social media network.
	 *
	 * @param uuid the uuid of this social media network
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
	protected SocialMediaNetworkWrapper wrap(
		SocialMediaNetwork socialMediaNetwork) {

		return new SocialMediaNetworkWrapper(socialMediaNetwork);
	}

}