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
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SocialMediaNetwork service. Represents a row in the &quot;SJob_SocialMediaNetwork&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaNetworkModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaNetworkImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaNetwork
 * @generated
 */
@ProviderType
public interface SocialMediaNetworkModel
	extends BaseModel<SocialMediaNetwork>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a social media network model instance should use the {@link SocialMediaNetwork} interface instead.
	 */

	/**
	 * Returns the primary key of this social media network.
	 *
	 * @return the primary key of this social media network
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this social media network.
	 *
	 * @param primaryKey the primary key of this social media network
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this social media network.
	 *
	 * @return the uuid of this social media network
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this social media network.
	 *
	 * @param uuid the uuid of this social media network
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the social media network ID of this social media network.
	 *
	 * @return the social media network ID of this social media network
	 */
	public long getSocialMediaNetworkId();

	/**
	 * Sets the social media network ID of this social media network.
	 *
	 * @param socialMediaNetworkId the social media network ID of this social media network
	 */
	public void setSocialMediaNetworkId(long socialMediaNetworkId);

	/**
	 * Returns the group ID of this social media network.
	 *
	 * @return the group ID of this social media network
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this social media network.
	 *
	 * @param groupId the group ID of this social media network
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this social media network.
	 *
	 * @return the company ID of this social media network
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this social media network.
	 *
	 * @param companyId the company ID of this social media network
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this social media network.
	 *
	 * @return the user ID of this social media network
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this social media network.
	 *
	 * @param userId the user ID of this social media network
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this social media network.
	 *
	 * @return the user uuid of this social media network
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this social media network.
	 *
	 * @param userUuid the user uuid of this social media network
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this social media network.
	 *
	 * @return the create date of this social media network
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this social media network.
	 *
	 * @param createDate the create date of this social media network
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this social media network.
	 *
	 * @return the modified date of this social media network
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this social media network.
	 *
	 * @param modifiedDate the modified date of this social media network
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user name of this social media network.
	 *
	 * @return the user name of this social media network
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this social media network.
	 *
	 * @param userName the user name of this social media network
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the name of this social media network.
	 *
	 * @return the name of this social media network
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this social media network.
	 *
	 * @param name the name of this social media network
	 */
	public void setName(String name);

	/**
	 * Returns the logo of this social media network.
	 *
	 * @return the logo of this social media network
	 */
	public long getLogo();

	/**
	 * Sets the logo of this social media network.
	 *
	 * @param logo the logo of this social media network
	 */
	public void setLogo(long logo);

	/**
	 * Returns the base url of this social media network.
	 *
	 * @return the base url of this social media network
	 */
	@AutoEscape
	public String getBaseURL();

	/**
	 * Sets the base url of this social media network.
	 *
	 * @param baseURL the base url of this social media network
	 */
	public void setBaseURL(String baseURL);

	@Override
	public SocialMediaNetwork cloneWithOriginalValues();

}