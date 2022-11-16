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

import edu.uoc.mestemi.studentjob.model.SocialMedia;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialMedia in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SocialMediaCacheModel
	implements CacheModel<SocialMedia>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SocialMediaCacheModel)) {
			return false;
		}

		SocialMediaCacheModel socialMediaCacheModel =
			(SocialMediaCacheModel)object;

		if (socialMediaId == socialMediaCacheModel.socialMediaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, socialMediaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", socialMediaId=");
		sb.append(socialMediaId);
		sb.append(", socialMediaNetworkId=");
		sb.append(socialMediaNetworkId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", socialMediaType=");
		sb.append(socialMediaType);
		sb.append(", socialURL=");
		sb.append(socialURL);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialMedia toEntityModel() {
		SocialMediaImpl socialMediaImpl = new SocialMediaImpl();

		if (uuid == null) {
			socialMediaImpl.setUuid("");
		}
		else {
			socialMediaImpl.setUuid(uuid);
		}

		socialMediaImpl.setSocialMediaId(socialMediaId);
		socialMediaImpl.setSocialMediaNetworkId(socialMediaNetworkId);
		socialMediaImpl.setGroupId(groupId);
		socialMediaImpl.setCompanyId(companyId);
		socialMediaImpl.setUserId(userId);

		if (userName == null) {
			socialMediaImpl.setUserName("");
		}
		else {
			socialMediaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			socialMediaImpl.setCreateDate(null);
		}
		else {
			socialMediaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			socialMediaImpl.setModifiedDate(null);
		}
		else {
			socialMediaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (socialMediaType == null) {
			socialMediaImpl.setSocialMediaType("");
		}
		else {
			socialMediaImpl.setSocialMediaType(socialMediaType);
		}

		if (socialURL == null) {
			socialMediaImpl.setSocialURL("");
		}
		else {
			socialMediaImpl.setSocialURL(socialURL);
		}

		if (className == null) {
			socialMediaImpl.setClassName("");
		}
		else {
			socialMediaImpl.setClassName(className);
		}

		socialMediaImpl.setClassPK(classPK);

		socialMediaImpl.resetOriginalValues();

		return socialMediaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		socialMediaId = objectInput.readLong();

		socialMediaNetworkId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		socialMediaType = objectInput.readUTF();
		socialURL = objectInput.readUTF();
		className = objectInput.readUTF();

		classPK = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(socialMediaId);

		objectOutput.writeLong(socialMediaNetworkId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (socialMediaType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(socialMediaType);
		}

		if (socialURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(socialURL);
		}

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);
	}

	public String uuid;
	public long socialMediaId;
	public long socialMediaNetworkId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String socialMediaType;
	public String socialURL;
	public String className;
	public long classPK;

}