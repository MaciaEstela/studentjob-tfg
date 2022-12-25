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

import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserEnrollOffer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserEnrollOfferCacheModel
	implements CacheModel<UserEnrollOffer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserEnrollOfferCacheModel)) {
			return false;
		}

		UserEnrollOfferCacheModel userEnrollOfferCacheModel =
			(UserEnrollOfferCacheModel)object;

		if (userEnrollOfferPK.equals(
				userEnrollOfferCacheModel.userEnrollOfferPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userEnrollOfferPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", offerId=");
		sb.append(offerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserEnrollOffer toEntityModel() {
		UserEnrollOfferImpl userEnrollOfferImpl = new UserEnrollOfferImpl();

		if (uuid == null) {
			userEnrollOfferImpl.setUuid("");
		}
		else {
			userEnrollOfferImpl.setUuid(uuid);
		}

		userEnrollOfferImpl.setUserId(userId);
		userEnrollOfferImpl.setOfferId(offerId);
		userEnrollOfferImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			userEnrollOfferImpl.setCreateDate(null);
		}
		else {
			userEnrollOfferImpl.setCreateDate(new Date(createDate));
		}

		userEnrollOfferImpl.resetOriginalValues();

		return userEnrollOfferImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userId = objectInput.readLong();

		offerId = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();

		userEnrollOfferPK = new UserEnrollOfferPK(userId, offerId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(offerId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
	}

	public String uuid;
	public long userId;
	public long offerId;
	public long groupId;
	public long createDate;
	public transient UserEnrollOfferPK userEnrollOfferPK;

}