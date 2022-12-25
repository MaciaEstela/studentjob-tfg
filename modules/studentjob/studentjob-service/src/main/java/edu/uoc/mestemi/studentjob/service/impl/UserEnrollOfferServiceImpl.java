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

package edu.uoc.mestemi.studentjob.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import edu.uoc.mestemi.studentjob.exception.NoSuchUserEnrollOfferException;
import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.service.base.UserEnrollOfferServiceBaseImpl;
import edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sjob",
		"json.web.service.context.path=UserEnrollOffer"
	},
	service = AopService.class
)
public class UserEnrollOfferServiceImpl extends UserEnrollOfferServiceBaseImpl {
	
	public UserEnrollOffer addUserEnrollOffer(long groupId, long offerId, long userId,
			ServiceContext serviceContext) throws PortalException {
		return userEnrollOfferLocalService.addUserEnrollOffer(groupId, offerId, userId, serviceContext);
	}
	
	public UserEnrollOffer deleteEnrollOffer(long offerId, long userId) throws PortalException {
		return userEnrollOfferLocalService.deleteUserEnrollOffer(
				new UserEnrollOfferPK(userId, offerId));
	}
	
	public UserEnrollOffer getUserEnrollOffer(long groupId, long userId, long offerId) {
		return userEnrollOfferLocalService.getUserEnrollOffer(groupId, userId, offerId);
	}
	
	public List<UserEnrollOffer> getUserEnrollOffers(long groupId, long offerId){
		return userEnrollOfferLocalService.getUserEnrollOffers(groupId, offerId);
	}

	public List<UserEnrollOffer> getUserEnrolledOffers(long groupId, long userId){
		return userEnrollOfferLocalService.getUserEnrolledOffers(groupId, userId);
	}
	
	public int getUserEnrolledOffersCount(long groupId, long userId){
		return userEnrollOfferLocalService.getUserEnrolledOffersCount(groupId, userId);
	}
}