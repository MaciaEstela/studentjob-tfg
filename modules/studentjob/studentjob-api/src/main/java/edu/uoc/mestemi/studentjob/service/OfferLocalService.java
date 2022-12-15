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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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

import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Offer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see OfferLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OfferLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.OfferLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the offer local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link OfferLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addDegreeOffer(long degreeId, long offerId);

	public void addDegreeOffer(long degreeId, Offer offer);

	public void addDegreeOffers(long degreeId, List<Offer> offers);

	public void addDegreeOffers(long degreeId, long[] offerIds);

	public Offer addOffer(
			long groupId, long regionId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String preference,
			List<Long> degreeIds, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Adds the offer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offer the offer
	 * @return the offer that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Offer addOffer(Offer offer);

	public void clearDegreeOffers(long degreeId);

	/**
	 * Creates a new offer with the primary key. Does not add the offer to the database.
	 *
	 * @param offerId the primary key for the new offer
	 * @return the new offer
	 */
	@Transactional(enabled = false)
	public Offer createOffer(long offerId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void deleteDegreeOffer(long degreeId, long offerId);

	public void deleteDegreeOffer(long degreeId, Offer offer);

	public void deleteDegreeOffers(long degreeId, List<Offer> offers);

	public void deleteDegreeOffers(long degreeId, long[] offerIds);

	/**
	 * Deletes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer that was removed
	 * @throws PortalException if a offer with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Offer deleteOffer(long offerId) throws PortalException;

	/**
	 * Deletes the offer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offer the offer
	 * @return the offer that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Offer deleteOffer(Offer offer);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.OfferModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.OfferModelImpl</code>.
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
	public Offer fetchOffer(long offerId);

	/**
	 * Returns the offer matching the UUID and group.
	 *
	 * @param uuid the offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching offer, or <code>null</code> if a matching offer could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Offer fetchOfferByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getDegreeOffers(long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getDegreeOffers(long degreeId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getDegreeOffers(
		long degreeId, int start, int end,
		OrderByComparator<Offer> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDegreeOffersCount(long degreeId);

	/**
	 * Returns the degreeIds of the degrees associated with the offer.
	 *
	 * @param offerId the offerId of the offer
	 * @return long[] the degreeIds of degrees associated with the offer
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getDegreePrimaryKeys(long offerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByOfferId(long offerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getDegreesIdsByOfferId(long offerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the offer with the primary key.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer
	 * @throws PortalException if a offer with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Offer getOffer(long offerId) throws PortalException;

	/**
	 * Returns the offer matching the UUID and group.
	 *
	 * @param uuid the offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching offer
	 * @throws PortalException if a matching offer could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Offer getOfferByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.OfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of offers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffers(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByGroupId(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Offer> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Offer> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(
		long groupId, String keywords, String preference, long regionId,
		long degreeId, long newestId, int start, int end,
		OrderByComparator<Offer> orderByComparator);

	/**
	 * Returns all the offers matching the UUID and company.
	 *
	 * @param uuid the UUID of the offers
	 * @param companyId the primary key of the company
	 * @return the matching offers, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByUuidAndCompanyId(String uuid, long companyId);

	/**
	 * Returns a range of offers matching the UUID and company.
	 *
	 * @param uuid the UUID of the offers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching offers, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Offer> getOffersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Offer> orderByComparator);

	/**
	 * Returns the number of offers.
	 *
	 * @return the number of offers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOffersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getOffersCountByKeywords(long groupId, String keywords);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
		long groupId, String keywords, String preference, long regionId,
		long degreeId, long newestId);

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
	public boolean hasDegreeOffer(long degreeId, long offerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDegreeOffers(long degreeId);

	public void setDegreeOffers(long degreeId, long[] offerIds);

	public Offer updateOffer(
			long offerId, long regionId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String preference,
			List<Long> degreeIds, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Updates the offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offer the offer
	 * @return the offer that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Offer updateOffer(Offer offer);

}