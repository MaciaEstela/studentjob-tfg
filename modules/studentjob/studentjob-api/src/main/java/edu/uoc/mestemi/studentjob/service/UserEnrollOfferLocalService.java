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

package edu.uoc.mestemi.studentjob.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for UserEnrollOffer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserEnrollOfferLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface UserEnrollOfferLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.UserEnrollOfferLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the user enroll offer local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link UserEnrollOfferLocalServiceUtil} if injection and service tracking are not available.
	 */
	public UserEnrollOffer addUserEnrollOffer(
			long groupId, long offerId, long userId,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Adds the user enroll offer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEnrollOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEnrollOffer the user enroll offer
	 * @return the user enroll offer that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public UserEnrollOffer addUserEnrollOffer(UserEnrollOffer userEnrollOffer);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new user enroll offer with the primary key. Does not add the user enroll offer to the database.
	 *
	 * @param userEnrollOfferPK the primary key for the new user enroll offer
	 * @return the new user enroll offer
	 */
	@Transactional(enabled = false)
	public UserEnrollOffer createUserEnrollOffer(
		UserEnrollOfferPK userEnrollOfferPK);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the user enroll offer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEnrollOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEnrollOffer the user enroll offer
	 * @return the user enroll offer that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public UserEnrollOffer deleteUserEnrollOffer(
		UserEnrollOffer userEnrollOffer);

	/**
	 * Deletes the user enroll offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEnrollOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer that was removed
	 * @throws PortalException if a user enroll offer with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public UserEnrollOffer deleteUserEnrollOffer(
			UserEnrollOfferPK userEnrollOfferPK)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserEnrollOffer fetchUserEnrollOffer(
		UserEnrollOfferPK userEnrollOfferPK);

	/**
	 * Returns the user enroll offer matching the UUID and group.
	 *
	 * @param uuid the user enroll offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserEnrollOffer fetchUserEnrollOfferByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserEnrollOffer> getUserEnrolledOffers(
		long groupId, long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserEnrolledOffersCount(long groupId, long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserEnrollOffer getUserEnrollOffer(
		long groupId, long userId, long offerId);

	/**
	 * Returns the user enroll offer with the primary key.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer
	 * @throws PortalException if a user enroll offer with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserEnrollOffer getUserEnrollOffer(
			UserEnrollOfferPK userEnrollOfferPK)
		throws PortalException;

	/**
	 * Returns the user enroll offer matching the UUID and group.
	 *
	 * @param uuid the user enroll offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user enroll offer
	 * @throws PortalException if a matching user enroll offer could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserEnrollOffer getUserEnrollOfferByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the user enroll offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.UserEnrollOfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user enroll offers
	 * @param end the upper bound of the range of user enroll offers (not inclusive)
	 * @return the range of user enroll offers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserEnrollOffer> getUserEnrollOffers(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserEnrollOffer> getUserEnrollOffers(
		long groupId, long offerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserEnrollOffer> getUserEnrollOffersByCreateDate(
		long groupId, long offerId, Date createDateGT);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserEnrollOffersByCreateDateCount(
		long groupId, long offerId, Date createDateGT);

	/**
	 * Returns the number of user enroll offers.
	 *
	 * @return the number of user enroll offers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserEnrollOffersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserEnrollOffersCount(long groupId, long offerId);

	/**
	 * Updates the user enroll offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserEnrollOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userEnrollOffer the user enroll offer
	 * @return the user enroll offer that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public UserEnrollOffer updateUserEnrollOffer(
		UserEnrollOffer userEnrollOffer);

}