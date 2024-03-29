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

import edu.uoc.mestemi.studentjob.model.DegreeArea;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DegreeArea in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DegreeAreaCacheModel
	implements CacheModel<DegreeArea>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DegreeAreaCacheModel)) {
			return false;
		}

		DegreeAreaCacheModel degreeAreaCacheModel =
			(DegreeAreaCacheModel)object;

		if (degreeAreaId == degreeAreaCacheModel.degreeAreaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, degreeAreaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", degreeAreaId=");
		sb.append(degreeAreaId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DegreeArea toEntityModel() {
		DegreeAreaImpl degreeAreaImpl = new DegreeAreaImpl();

		if (uuid == null) {
			degreeAreaImpl.setUuid("");
		}
		else {
			degreeAreaImpl.setUuid(uuid);
		}

		degreeAreaImpl.setDegreeAreaId(degreeAreaId);
		degreeAreaImpl.setGroupId(groupId);
		degreeAreaImpl.setCompanyId(companyId);
		degreeAreaImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			degreeAreaImpl.setCreateDate(null);
		}
		else {
			degreeAreaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			degreeAreaImpl.setModifiedDate(null);
		}
		else {
			degreeAreaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (userName == null) {
			degreeAreaImpl.setUserName("");
		}
		else {
			degreeAreaImpl.setUserName(userName);
		}

		if (name == null) {
			degreeAreaImpl.setName("");
		}
		else {
			degreeAreaImpl.setName(name);
		}

		degreeAreaImpl.resetOriginalValues();

		return degreeAreaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		degreeAreaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userName = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(degreeAreaId);

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
	}

	public String uuid;
	public long degreeAreaId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String userName;
	public String name;

}