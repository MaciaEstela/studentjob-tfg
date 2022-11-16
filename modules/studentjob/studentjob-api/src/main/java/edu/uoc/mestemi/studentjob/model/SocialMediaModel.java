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
 * The base model interface for the SocialMedia service. Represents a row in the &quot;SJob_SocialMedia&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>edu.uoc.mestemi.studentjob.model.impl.SocialMediaImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialMedia
 * @generated
 */
@ProviderType
public interface SocialMediaModel
	extends BaseModel<SocialMedia>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a social media model instance should use the {@link SocialMedia} interface instead.
	 */

	/**
	 * Returns the primary key of this social media.
	 *
	 * @return the primary key of this social media
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this social media.
	 *
	 * @param primaryKey the primary key of this social media
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this social media.
	 *
	 * @return the uuid of this social media
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this social media.
	 *
	 * @param uuid the uuid of this social media
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the social media ID of this social media.
	 *
	 * @return the social media ID of this social media
	 */
	public long getSocialMediaId();

	/**
	 * Sets the social media ID of this social media.
	 *
	 * @param socialMediaId the social media ID of this social media
	 */
	public void setSocialMediaId(long socialMediaId);

	/**
	 * Returns the social media network ID of this social media.
	 *
	 * @return the social media network ID of this social media
	 */
	public long getSocialMediaNetworkId();

	/**
	 * Sets the social media network ID of this social media.
	 *
	 * @param socialMediaNetworkId the social media network ID of this social media
	 */
	public void setSocialMediaNetworkId(long socialMediaNetworkId);

	/**
	 * Returns the group ID of this social media.
	 *
	 * @return the group ID of this social media
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this social media.
	 *
	 * @param groupId the group ID of this social media
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this social media.
	 *
	 * @return the company ID of this social media
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this social media.
	 *
	 * @param companyId the company ID of this social media
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this social media.
	 *
	 * @return the user ID of this social media
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this social media.
	 *
	 * @param userId the user ID of this social media
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this social media.
	 *
	 * @return the user uuid of this social media
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this social media.
	 *
	 * @param userUuid the user uuid of this social media
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this social media.
	 *
	 * @return the user name of this social media
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this social media.
	 *
	 * @param userName the user name of this social media
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this social media.
	 *
	 * @return the create date of this social media
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this social media.
	 *
	 * @param createDate the create date of this social media
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this social media.
	 *
	 * @return the modified date of this social media
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this social media.
	 *
	 * @param modifiedDate the modified date of this social media
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the social media type of this social media.
	 *
	 * @return the social media type of this social media
	 */
	@AutoEscape
	public String getSocialMediaType();

	/**
	 * Sets the social media type of this social media.
	 *
	 * @param socialMediaType the social media type of this social media
	 */
	public void setSocialMediaType(String socialMediaType);

	/**
	 * Returns the social url of this social media.
	 *
	 * @return the social url of this social media
	 */
	@AutoEscape
	public String getSocialURL();

	/**
	 * Sets the social url of this social media.
	 *
	 * @param socialURL the social url of this social media
	 */
	public void setSocialURL(String socialURL);

	/**
	 * Returns the class name of this social media.
	 *
	 * @return the class name of this social media
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this social media.
	 *
	 * @param className the class name of this social media
	 */
	public void setClassName(String className);

	/**
	 * Returns the class pk of this social media.
	 *
	 * @return the class pk of this social media
	 */
	public long getClassPK();

	/**
	 * Sets the class pk of this social media.
	 *
	 * @param classPK the class pk of this social media
	 */
	public void setClassPK(long classPK);

	@Override
	public SocialMedia cloneWithOriginalValues();

}