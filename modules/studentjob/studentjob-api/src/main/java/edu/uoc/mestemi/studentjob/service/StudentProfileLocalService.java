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
import edu.uoc.mestemi.studentjob.model.StudentProfile;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for StudentProfile. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see StudentProfileLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface StudentProfileLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>edu.uoc.mestemi.studentjob.service.impl.StudentProfileLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the student profile local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link StudentProfileLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addDegreeStudentProfile(long degreeId, long studentProfileId);

	public void addDegreeStudentProfile(
		long degreeId, StudentProfile studentProfile);

	public void addDegreeStudentProfiles(
		long degreeId, List<StudentProfile> studentProfiles);

	public void addDegreeStudentProfiles(
		long degreeId, long[] studentProfileIds);

	public StudentProfile addStudentProfile(
			long groupId, long userId, long regionId, boolean active,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			String email, String preference, long curriculumId,
			List<Long> degreeIds, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Adds the student profile to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studentProfile the student profile
	 * @return the student profile that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public StudentProfile addStudentProfile(StudentProfile studentProfile);

	public void clearDegreeStudentProfiles(long degreeId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new student profile with the primary key. Does not add the student profile to the database.
	 *
	 * @param studentProfileId the primary key for the new student profile
	 * @return the new student profile
	 */
	@Transactional(enabled = false)
	public StudentProfile createStudentProfile(long studentProfileId);

	public void deleteDegreeStudentProfile(
		long degreeId, long studentProfileId);

	public void deleteDegreeStudentProfile(
		long degreeId, StudentProfile studentProfile);

	public void deleteDegreeStudentProfiles(
		long degreeId, List<StudentProfile> studentProfiles);

	public void deleteDegreeStudentProfiles(
		long degreeId, long[] studentProfileIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the student profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile that was removed
	 * @throws PortalException if a student profile with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public StudentProfile deleteStudentProfile(long studentProfileId)
		throws PortalException;

	/**
	 * Deletes the student profile from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studentProfile the student profile
	 * @return the student profile that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public StudentProfile deleteStudentProfile(StudentProfile studentProfile);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.StudentProfileModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.StudentProfileModelImpl</code>.
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
	public StudentProfile fetchStudentProfile(long studentProfileId);

	/**
	 * Returns the student profile matching the UUID and group.
	 *
	 * @param uuid the student profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching student profile, or <code>null</code> if a matching student profile could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StudentProfile fetchStudentProfileByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the degreeIds of the degrees associated with the student profile.
	 *
	 * @param studentProfileId the studentProfileId of the student profile
	 * @return long[] the degreeIds of degrees associated with the student profile
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getDegreePrimaryKeys(long studentProfileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Degree> getDegreesByOfferId(long studentProfileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getDegreesIdsByOfferId(long studentProfileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getDegreeStudentProfiles(long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getDegreeStudentProfiles(
		long degreeId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getDegreeStudentProfiles(
		long degreeId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDegreeStudentProfilesCount(long degreeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getNewestStudentProfileId();

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

	/**
	 * Returns the student profile with the primary key.
	 *
	 * @param studentProfileId the primary key of the student profile
	 * @return the student profile
	 * @throws PortalException if a student profile with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StudentProfile getStudentProfile(long studentProfileId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StudentProfile getStudentProfileByGroupIdAndUserId(
		long groupId, long userId);

	/**
	 * Returns the student profile matching the UUID and group.
	 *
	 * @param uuid the student profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching student profile
	 * @throws PortalException if a matching student profile could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StudentProfile getStudentProfileByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the student profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>edu.uoc.mestemi.studentjob.model.impl.StudentProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @return the range of student profiles
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getStudentProfiles(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getStudentProfilesByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getStudentProfilesByGroupId(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getStudentProfilesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getStudentProfilesByGroupIdAndActive(
		long groupId, boolean active);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getStudentProfilesByKeywords(
		long groupId, String keywords, boolean onlyActives, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile>
		getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			long groupId, String keywords, String preference, long regionId,
			long degreeId, boolean onlyActives, long newestId, int start,
			int end, OrderByComparator<StudentProfile> orderByComparator);

	/**
	 * Returns all the student profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the student profiles
	 * @param companyId the primary key of the company
	 * @return the matching student profiles, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getStudentProfilesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of student profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the student profiles
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of student profiles
	 * @param end the upper bound of the range of student profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching student profiles, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StudentProfile> getStudentProfilesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StudentProfile> orderByComparator);

	/**
	 * Returns the number of student profiles.
	 *
	 * @return the number of student profiles
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStudentProfilesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getStudentProfilesCountByKeywords(
		long groupId, String keywords, boolean onlyActives);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long
		getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			long groupId, String keywords, String preference, long regionId,
			long degreeId, boolean onlyActives, long newestId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDegreeStudentProfile(
		long degreeId, long studentProfileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasDegreeStudentProfiles(long degreeId);

	public void setDegreeStudentProfiles(
		long degreeId, long[] studentProfileIds);

	public StudentProfile updateStudentProfile(
			long studentProfileId, long regionId, boolean active,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			String email, String preference, long curriculumId,
			List<Long> degreeIds, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Updates the student profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studentProfile the student profile
	 * @return the student profile that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public StudentProfile updateStudentProfile(StudentProfile studentProfile);

}