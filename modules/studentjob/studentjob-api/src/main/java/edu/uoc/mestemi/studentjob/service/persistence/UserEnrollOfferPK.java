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

package edu.uoc.mestemi.studentjob.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserEnrollOfferPK
	implements Comparable<UserEnrollOfferPK>, Serializable {

	public long userId;
	public long offerId;

	public UserEnrollOfferPK() {
	}

	public UserEnrollOfferPK(long userId, long offerId) {
		this.userId = userId;
		this.offerId = offerId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	@Override
	public int compareTo(UserEnrollOfferPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (userId < pk.userId) {
			value = -1;
		}
		else if (userId > pk.userId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (offerId < pk.offerId) {
			value = -1;
		}
		else if (offerId > pk.offerId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserEnrollOfferPK)) {
			return false;
		}

		UserEnrollOfferPK pk = (UserEnrollOfferPK)object;

		if ((userId == pk.userId) && (offerId == pk.offerId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, userId);
		hashCode = HashUtil.hash(hashCode, offerId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("userId=");

		sb.append(userId);
		sb.append(", offerId=");

		sb.append(offerId);

		sb.append("}");

		return sb.toString();
	}

}