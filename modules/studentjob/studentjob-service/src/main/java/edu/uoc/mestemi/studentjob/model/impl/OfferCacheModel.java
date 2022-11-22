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

import edu.uoc.mestemi.studentjob.model.Offer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Offer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OfferCacheModel implements CacheModel<Offer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OfferCacheModel)) {
			return false;
		}

		OfferCacheModel offerCacheModel = (OfferCacheModel)object;

		if (offerId == offerCacheModel.offerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, offerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", offerId=");
		sb.append(offerId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", preference=");
		sb.append(preference);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Offer toEntityModel() {
		OfferImpl offerImpl = new OfferImpl();

		if (uuid == null) {
			offerImpl.setUuid("");
		}
		else {
			offerImpl.setUuid(uuid);
		}

		offerImpl.setOfferId(offerId);
		offerImpl.setRegionId(regionId);
		offerImpl.setGroupId(groupId);
		offerImpl.setCompanyId(companyId);
		offerImpl.setUserId(userId);

		if (userName == null) {
			offerImpl.setUserName("");
		}
		else {
			offerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			offerImpl.setCreateDate(null);
		}
		else {
			offerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			offerImpl.setModifiedDate(null);
		}
		else {
			offerImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			offerImpl.setName("");
		}
		else {
			offerImpl.setName(name);
		}

		if (preference == null) {
			offerImpl.setPreference("");
		}
		else {
			offerImpl.setPreference(preference);
		}

		if (description == null) {
			offerImpl.setDescription("");
		}
		else {
			offerImpl.setDescription(description);
		}

		offerImpl.resetOriginalValues();

		return offerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		offerId = objectInput.readLong();

		regionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		preference = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(offerId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (preference == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(preference);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long offerId;
	public long regionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String preference;
	public String description;

}