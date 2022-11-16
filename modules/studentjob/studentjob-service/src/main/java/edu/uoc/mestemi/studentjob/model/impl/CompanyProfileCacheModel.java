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

import edu.uoc.mestemi.studentjob.model.CompanyProfile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CompanyProfile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CompanyProfileCacheModel
	implements CacheModel<CompanyProfile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CompanyProfileCacheModel)) {
			return false;
		}

		CompanyProfileCacheModel companyProfileCacheModel =
			(CompanyProfileCacheModel)object;

		if (companyProfileId == companyProfileCacheModel.companyProfileId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, companyProfileId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", companyProfileId=");
		sb.append(companyProfileId);
		sb.append(", regionId=");
		sb.append(regionId);
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
		sb.append(", active=");
		sb.append(active);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", email=");
		sb.append(email);
		sb.append(", sector=");
		sb.append(sector);
		sb.append(", website=");
		sb.append(website);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CompanyProfile toEntityModel() {
		CompanyProfileImpl companyProfileImpl = new CompanyProfileImpl();

		if (uuid == null) {
			companyProfileImpl.setUuid("");
		}
		else {
			companyProfileImpl.setUuid(uuid);
		}

		companyProfileImpl.setCompanyProfileId(companyProfileId);
		companyProfileImpl.setRegionId(regionId);
		companyProfileImpl.setGroupId(groupId);
		companyProfileImpl.setCompanyId(companyId);
		companyProfileImpl.setUserId(userId);

		if (userName == null) {
			companyProfileImpl.setUserName("");
		}
		else {
			companyProfileImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			companyProfileImpl.setCreateDate(null);
		}
		else {
			companyProfileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			companyProfileImpl.setModifiedDate(null);
		}
		else {
			companyProfileImpl.setModifiedDate(new Date(modifiedDate));
		}

		companyProfileImpl.setActive(active);

		if (title == null) {
			companyProfileImpl.setTitle("");
		}
		else {
			companyProfileImpl.setTitle(title);
		}

		if (description == null) {
			companyProfileImpl.setDescription("");
		}
		else {
			companyProfileImpl.setDescription(description);
		}

		if (email == null) {
			companyProfileImpl.setEmail("");
		}
		else {
			companyProfileImpl.setEmail(email);
		}

		if (sector == null) {
			companyProfileImpl.setSector("");
		}
		else {
			companyProfileImpl.setSector(sector);
		}

		if (website == null) {
			companyProfileImpl.setWebsite("");
		}
		else {
			companyProfileImpl.setWebsite(website);
		}

		companyProfileImpl.resetOriginalValues();

		return companyProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		companyProfileId = objectInput.readLong();

		regionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		email = objectInput.readUTF();
		sector = objectInput.readUTF();
		website = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(companyProfileId);

		objectOutput.writeLong(regionId);

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

		objectOutput.writeBoolean(active);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (sector == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sector);
		}

		if (website == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(website);
		}
	}

	public String uuid;
	public long companyProfileId;
	public long regionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public String title;
	public String description;
	public String email;
	public String sector;
	public String website;

}