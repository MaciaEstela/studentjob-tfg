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
import edu.uoc.mestemi.studentjob.model.DegreeArea;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Degree. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DegreeLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DegreeLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.DegreeLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the degree local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DegreeLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the degree to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degree the degree
	 * @return the degree that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Degree addDegree(Degree degree);

	public Degree addDegree(
			long groupId, Map<Locale, String> nameMap,
			List<Long> degreeAreasIds, ServiceContext serviceContext)
		throws PortalException;

	public void addDegreeAreaDegree(long degreeAreaId, Degree degree);

	public void addDegreeAreaDegree(long degreeAreaId, long degreeId);

	public void addDegreeAreaDegrees(long degreeAreaId, List<Degree> degrees);

	public void addDegreeAreaDegrees(long degreeAreaId, long[] degreeIds);

	public void addOfferDegree(long offerId, Degree degree);

	public void addOfferDegree(long offerId, long degreeId);

	public void addOfferDegrees(long offerId, List<Degree> degrees);

	public void addOfferDegrees(long offerId, long[] degreeIds);

	public void addStudentProfileDegree(long studentProfileId, Degree degree);

	public void addStudentProfileDegree(long studentProfileId, long degreeId);

	public void addStudentProfileDegrees(
		long studentProfileId, List<Degree> degrees);

	public void addStudentProfileDegrees(
		long studentProfileId, long[] degreeIds);

	public void clearDegreeAreaDegrees(long degreeAreaId);

	public void clearOfferDegrees(long offerId);

	public void clearStudentProfileDegrees(long studentProfileId);

	/**
	 * Creates a new degree with the primary key. Does not add the degree to the database.
	 *
	 * @param degreeId the primary key for the new degree
	 * @return the new degree
	 */
	@Transactional(enabled = false)
	public Degree createDegree(long degreeId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the degree from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degree the degree
	 * @return the degree that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Degree deleteDegree(Degree degree);

	/**
	 * Deletes the degree with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree that was removed
	 * @throws PortalException if a degree with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Degree deleteDegree(long degreeId) throws PortalException;

	public void deleteDegreeAreaDegree(long degreeAreaId, Degree degree);

	public void deleteDegreeAreaDegree(long degreeAreaId, long degreeId);

	public void deleteDegreeAreaDegrees(
		long degreeAreaId, List<Degree> degrees);

	public void deleteDegreeAreaDegrees(long degreeAreaId, long[] degreeIds);

	public Degree deleteDegreeWithValidation(Degree degree)
		throws PortalException;

	public Degree deleteDegreeWithValidation(long degreeId)
		throws PortalException;

	public void deleteOfferDegree(long offerId, Degree degree);

	public void deleteOfferDegree(long offerId, long degreeId);

	public void deleteOfferDegrees(long offerId, List<Degree> degrees);

	public void deleteOfferDegrees(long offerId, long[] degreeIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deleteStudentProfileDegree(
		long studentProfileId, Degree degree);

	public void deleteStudentProfileDegree(
		long studentProfileId, long degreeId);

	public void deleteStudentProfileDegrees(
		long studentProfileId, List<Degree> degrees);

	public void deleteStudentProfileDegrees(
		long studentProfileId, long[] degreeIds);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeModelImpl</code>.
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
	public Degree fetchDegree(long degreeId);

	/**
	 * Returns the degree matching the UUID and group.
	 *
	 * @param uuid the degree's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree, or <code>null</code> if a matching degree could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Degree fetchDegreeByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the degree with the primary key.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree
	 * @throws PortalException if a degree with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Degree getDegree(long degreeId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreeAreaDegrees(long degreeAreaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreeAreaDegrees(
		long degreeAreaId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreeAreaDegrees(
		long degreeAreaId, int start, int end,
		OrderByComparator<Degree> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDegreeAreaDegreesCount(long degreeAreaId);

	/**
	 * Returns the degreeAreaIds of the degree areas associated with the degree.
	 *
	 * @param degreeId the degreeId of the degree
	 * @return long[] the degreeAreaIds of degree areas associated with the degree
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getDegreeAreaPrimaryKeys(long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DegreeArea> getDegreeAreasByDegreeId(long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getDegreeAreasIdsByDegreeId(long degreeId);

	/**
	 * Returns the degree matching the UUID and group.
	 *
	 * @param uuid the degree's UUID
	 * @param groupId the primary key of the group
	 * @return the matching degree
	 * @throws PortalException if a matching degree could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Degree getDegreeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the degrees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.DegreeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @return the range of degrees
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegrees(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByGroupId(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Degree> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Degree> orderByComparator);

	/**
	 * Returns all the degrees matching the UUID and company.
	 *
	 * @param uuid the UUID of the degrees
	 * @param companyId the primary key of the company
	 * @return the matching degrees, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of degrees matching the UUID and company.
	 *
	 * @param uuid the UUID of the degrees
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of degrees
	 * @param end the upper bound of the range of degrees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching degrees, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Degree> orderByComparator);

	/**
	 * Returns the number of degrees.
	 *
	 * @return the number of degrees
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDegreesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getDegreesCountByKeywords(long groupId, String keywords);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getOfferDegrees(long offerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getOfferDegrees(long offerId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getOfferDegrees(
		long offerId, int start, int end,
		OrderByComparator<Degree> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOfferDegreesCount(long offerId);

	/**
	 * Returns the offerIds of the offers associated with the degree.
	 *
	 * @param degreeId the degreeId of the degree
	 * @return long[] the offerIds of offers associated with the degree
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getOfferPrimaryKeys(long degreeId);

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
	public List<Degree> getStudentProfileDegrees(long studentProfileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getStudentProfileDegrees(
		long studentProfileId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getStudentProfileDegrees(
		long studentProfileId, int start, int end,
		OrderByComparator<Degree> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStudentProfileDegreesCount(long studentProfileId);

	/**
	 * Returns the studentProfileIds of the student profiles associated with the degree.
	 *
	 * @param degreeId the degreeId of the degree
	 * @return long[] the studentProfileIds of student profiles associated with the degree
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getStudentProfilePrimaryKeys(long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDegreeAreaDegree(long degreeAreaId, long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDegreeAreaDegrees(long degreeAreaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasOfferDegree(long offerId, long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasOfferDegrees(long offerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasStudentProfileDegree(
		long studentProfileId, long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasStudentProfileDegrees(long studentProfileId);

	public void setDegreeAreaDegrees(long degreeAreaId, long[] degreeIds);

	public void setOfferDegrees(long offerId, long[] degreeIds);

	public void setStudentProfileDegrees(
		long studentProfileId, long[] degreeIds);

	/**
	 * Updates the degree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DegreeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param degree the degree
	 * @return the degree that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Degree updateDegree(Degree degree);

	public Degree updateDegree(
			long degreeId, Map<Locale, String> nameMap,
			List<Long> degreeAreasIds, ServiceContext serviceContext)
		throws PortalException;

}