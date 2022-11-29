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
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.service.base.UserEnrollOfferLocalServiceBaseImpl;
import edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	property = "model.class.name=edu.uoc.mestemi.studentjob.model.UserEnrollOffer",
	service = AopService.class
)
public class UserEnrollOfferLocalServiceImpl
	extends UserEnrollOfferLocalServiceBaseImpl {
	
	public UserEnrollOffer addUserEnrollOffer(long groupId, long offerId, 
			long userId, ServiceContext serviceContext) throws PortalException {
		// Get group and user
		Group group = groupLocalService.getGroup(groupId);
		
		UserEnrollOfferPK userEnrollOfferPK = new UserEnrollOfferPK(userId, offerId);
		
		UserEnrollOffer userEnrollOffer = createUserEnrollOffer(userEnrollOfferPK);
		userEnrollOffer.setGroupId(group.getGroupId());
		userEnrollOffer.setCompanyId(group.getCompanyId());
		userEnrollOffer.setCreateDate(serviceContext.getCreateDate(new Date()));
	
		return super.addUserEnrollOffer(userEnrollOffer);
	}
	
	@Override
	public UserEnrollOffer addUserEnrollOffer(UserEnrollOffer userEnrollOffer) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Override
	public UserEnrollOffer updateUserEnrollOffer(UserEnrollOffer userEnrollOffer) {
		throw new UnsupportedOperationException("Not supported");
	}
	
	@Reference
	GroupLocalService groupLocalService;
}