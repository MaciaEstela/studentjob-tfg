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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserEnrollOffer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserEnrollOffer
 * @generated
 */
public class UserEnrollOfferWrapper
	extends BaseModelWrapper<UserEnrollOffer>
	implements ModelWrapper<UserEnrollOffer>, UserEnrollOffer {

	public UserEnrollOfferWrapper(UserEnrollOffer userEnrollOffer) {
		super(userEnrollOffer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userId", getUserId());
		attributes.put("offerId", getOfferId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long offerId = (Long)attributes.get("offerId");

		if (offerId != null) {
			setOfferId(offerId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public UserEnrollOffer cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this user enroll offer.
	 *
	 * @return the create date of this user enroll offer
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this user enroll offer.
	 *
	 * @return the group ID of this user enroll offer
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the offer ID of this user enroll offer.
	 *
	 * @return the offer ID of this user enroll offer
	 */
	@Override
	public long getOfferId() {
		return model.getOfferId();
	}

	/**
	 * Returns the primary key of this user enroll offer.
	 *
	 * @return the primary key of this user enroll offer
	 */
	@Override
	public edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this user enroll offer.
	 *
	 * @return the user ID of this user enroll offer
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this user enroll offer.
	 *
	 * @return the user uuid of this user enroll offer
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user enroll offer.
	 *
	 * @return the uuid of this user enroll offer
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this user enroll offer.
	 *
	 * @param createDate the create date of this user enroll offer
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this user enroll offer.
	 *
	 * @param groupId the group ID of this user enroll offer
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the offer ID of this user enroll offer.
	 *
	 * @param offerId the offer ID of this user enroll offer
	 */
	@Override
	public void setOfferId(long offerId) {
		model.setOfferId(offerId);
	}

	/**
	 * Sets the primary key of this user enroll offer.
	 *
	 * @param primaryKey the primary key of this user enroll offer
	 */
	@Override
	public void setPrimaryKey(
		edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this user enroll offer.
	 *
	 * @param userId the user ID of this user enroll offer
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this user enroll offer.
	 *
	 * @param userUuid the user uuid of this user enroll offer
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user enroll offer.
	 *
	 * @param uuid the uuid of this user enroll offer
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected UserEnrollOfferWrapper wrap(UserEnrollOffer userEnrollOffer) {
		return new UserEnrollOfferWrapper(userEnrollOffer);
	}

}