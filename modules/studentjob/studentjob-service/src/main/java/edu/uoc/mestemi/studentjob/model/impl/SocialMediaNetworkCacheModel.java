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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialMediaNetwork in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SocialMediaNetworkCacheModel
	implements CacheModel<SocialMediaNetwork>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SocialMediaNetworkCacheModel)) {
			return false;
		}

		SocialMediaNetworkCacheModel socialMediaNetworkCacheModel =
			(SocialMediaNetworkCacheModel)object;

		if (socialMediaNetworkId ==
				socialMediaNetworkCacheModel.socialMediaNetworkId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, socialMediaNetworkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", socialMediaNetworkId=");
		sb.append(socialMediaNetworkId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", name=");
		sb.append(name);
		sb.append(", logo=");
		sb.append(logo);
		sb.append(", baseURL=");
		sb.append(baseURL);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialMediaNetwork toEntityModel() {
		SocialMediaNetworkImpl socialMediaNetworkImpl =
			new SocialMediaNetworkImpl();

		if (uuid == null) {
			socialMediaNetworkImpl.setUuid("");
		}
		else {
			socialMediaNetworkImpl.setUuid(uuid);
		}

		socialMediaNetworkImpl.setSocialMediaNetworkId(socialMediaNetworkId);
		socialMediaNetworkImpl.setGroupId(groupId);
		socialMediaNetworkImpl.setCompanyId(companyId);
		socialMediaNetworkImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			socialMediaNetworkImpl.setCreateDate(null);
		}
		else {
			socialMediaNetworkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			socialMediaNetworkImpl.setModifiedDate(null);
		}
		else {
			socialMediaNetworkImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (userName == null) {
			socialMediaNetworkImpl.setUserName("");
		}
		else {
			socialMediaNetworkImpl.setUserName(userName);
		}

		if (name == null) {
			socialMediaNetworkImpl.setName("");
		}
		else {
			socialMediaNetworkImpl.setName(name);
		}

		socialMediaNetworkImpl.setLogo(logo);

		if (baseURL == null) {
			socialMediaNetworkImpl.setBaseURL("");
		}
		else {
			socialMediaNetworkImpl.setBaseURL(baseURL);
		}

		socialMediaNetworkImpl.resetOriginalValues();

		return socialMediaNetworkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		socialMediaNetworkId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userName = objectInput.readUTF();
		name = objectInput.readUTF();

		logo = objectInput.readLong();
		baseURL = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(socialMediaNetworkId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(logo);

		if (baseURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(baseURL);
		}
	}

	public String uuid;
	public long socialMediaNetworkId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String userName;
	public String name;
	public long logo;
	public String baseURL;

}