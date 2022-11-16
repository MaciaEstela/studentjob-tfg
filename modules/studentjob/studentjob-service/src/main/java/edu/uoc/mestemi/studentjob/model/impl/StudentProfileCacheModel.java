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

import edu.uoc.mestemi.studentjob.model.StudentProfile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StudentProfile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentProfileCacheModel
	implements CacheModel<StudentProfile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StudentProfileCacheModel)) {
			return false;
		}

		StudentProfileCacheModel studentProfileCacheModel =
			(StudentProfileCacheModel)object;

		if (studentProfileId == studentProfileCacheModel.studentProfileId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentProfileId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", studentProfileId=");
		sb.append(studentProfileId);
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
		sb.append(", preference=");
		sb.append(preference);
		sb.append(", curriculumId=");
		sb.append(curriculumId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StudentProfile toEntityModel() {
		StudentProfileImpl studentProfileImpl = new StudentProfileImpl();

		if (uuid == null) {
			studentProfileImpl.setUuid("");
		}
		else {
			studentProfileImpl.setUuid(uuid);
		}

		studentProfileImpl.setStudentProfileId(studentProfileId);
		studentProfileImpl.setRegionId(regionId);
		studentProfileImpl.setGroupId(groupId);
		studentProfileImpl.setCompanyId(companyId);
		studentProfileImpl.setUserId(userId);

		if (userName == null) {
			studentProfileImpl.setUserName("");
		}
		else {
			studentProfileImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			studentProfileImpl.setCreateDate(null);
		}
		else {
			studentProfileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			studentProfileImpl.setModifiedDate(null);
		}
		else {
			studentProfileImpl.setModifiedDate(new Date(modifiedDate));
		}

		studentProfileImpl.setActive(active);

		if (title == null) {
			studentProfileImpl.setTitle("");
		}
		else {
			studentProfileImpl.setTitle(title);
		}

		if (description == null) {
			studentProfileImpl.setDescription("");
		}
		else {
			studentProfileImpl.setDescription(description);
		}

		if (email == null) {
			studentProfileImpl.setEmail("");
		}
		else {
			studentProfileImpl.setEmail(email);
		}

		if (preference == null) {
			studentProfileImpl.setPreference("");
		}
		else {
			studentProfileImpl.setPreference(preference);
		}

		studentProfileImpl.setCurriculumId(curriculumId);

		studentProfileImpl.resetOriginalValues();

		return studentProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		studentProfileId = objectInput.readLong();

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
		preference = objectInput.readUTF();

		curriculumId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(studentProfileId);

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

		if (preference == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(preference);
		}

		objectOutput.writeLong(curriculumId);
	}

	public String uuid;
	public long studentProfileId;
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
	public String preference;
	public long curriculumId;

}