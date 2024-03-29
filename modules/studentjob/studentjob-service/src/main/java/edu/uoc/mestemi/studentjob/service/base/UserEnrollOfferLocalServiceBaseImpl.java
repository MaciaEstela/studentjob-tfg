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

package edu.uoc.mestemi.studentjob.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferLocalService;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.persistence.CompanyProfilePersistence;
import edu.uoc.mestemi.studentjob.service.persistence.DegreeAreaPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.DegreePersistence;
import edu.uoc.mestemi.studentjob.service.persistence.OfferPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.SocialMediaNetworkPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.SocialMediaPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.StudentProfilePersistence;
import edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPK;
import edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the user enroll offer local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link edu.uoc.mestemi.studentjob.service.impl.UserEnrollOfferLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see edu.uoc.mestemi.studentjob.service.impl.UserEnrollOfferLocalServiceImpl
 * @generated
 */
public abstract class UserEnrollOfferLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   UserEnrollOfferLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>UserEnrollOfferLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>UserEnrollOfferLocalServiceUtil</code>.
	 */

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
	@Override
	public UserEnrollOffer addUserEnrollOffer(UserEnrollOffer userEnrollOffer) {
		userEnrollOffer.setNew(true);

		return userEnrollOfferPersistence.update(userEnrollOffer);
	}

	/**
	 * Creates a new user enroll offer with the primary key. Does not add the user enroll offer to the database.
	 *
	 * @param userEnrollOfferPK the primary key for the new user enroll offer
	 * @return the new user enroll offer
	 */
	@Override
	@Transactional(enabled = false)
	public UserEnrollOffer createUserEnrollOffer(
		UserEnrollOfferPK userEnrollOfferPK) {

		return userEnrollOfferPersistence.create(userEnrollOfferPK);
	}

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
	@Override
	public UserEnrollOffer deleteUserEnrollOffer(
			UserEnrollOfferPK userEnrollOfferPK)
		throws PortalException {

		return userEnrollOfferPersistence.remove(userEnrollOfferPK);
	}

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
	@Override
	public UserEnrollOffer deleteUserEnrollOffer(
		UserEnrollOffer userEnrollOffer) {

		return userEnrollOfferPersistence.remove(userEnrollOffer);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return userEnrollOfferPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			UserEnrollOffer.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return userEnrollOfferPersistence.findWithDynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return userEnrollOfferPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return userEnrollOfferPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return userEnrollOfferPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return userEnrollOfferPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public UserEnrollOffer fetchUserEnrollOffer(
		UserEnrollOfferPK userEnrollOfferPK) {

		return userEnrollOfferPersistence.fetchByPrimaryKey(userEnrollOfferPK);
	}

	/**
	 * Returns the user enroll offer matching the UUID and group.
	 *
	 * @param uuid the user enroll offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user enroll offer, or <code>null</code> if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer fetchUserEnrollOfferByUuidAndGroupId(
		String uuid, long groupId) {

		return userEnrollOfferPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user enroll offer with the primary key.
	 *
	 * @param userEnrollOfferPK the primary key of the user enroll offer
	 * @return the user enroll offer
	 * @throws PortalException if a user enroll offer with the primary key could not be found
	 */
	@Override
	public UserEnrollOffer getUserEnrollOffer(
			UserEnrollOfferPK userEnrollOfferPK)
		throws PortalException {

		return userEnrollOfferPersistence.findByPrimaryKey(userEnrollOfferPK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(userEnrollOfferLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(UserEnrollOffer.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("primaryKey.userId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			userEnrollOfferLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(UserEnrollOffer.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.userId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(userEnrollOfferLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(UserEnrollOffer.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("primaryKey.userId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return userEnrollOfferPersistence.create(
			(UserEnrollOfferPK)primaryKeyObj);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return userEnrollOfferLocalService.deleteUserEnrollOffer(
			(UserEnrollOffer)persistedModel);
	}

	@Override
	public BasePersistence<UserEnrollOffer> getBasePersistence() {
		return userEnrollOfferPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return userEnrollOfferPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the user enroll offer matching the UUID and group.
	 *
	 * @param uuid the user enroll offer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user enroll offer
	 * @throws PortalException if a matching user enroll offer could not be found
	 */
	@Override
	public UserEnrollOffer getUserEnrollOfferByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return userEnrollOfferPersistence.findByUUID_G(uuid, groupId);
	}

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
	@Override
	public List<UserEnrollOffer> getUserEnrollOffers(int start, int end) {
		return userEnrollOfferPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of user enroll offers.
	 *
	 * @return the number of user enroll offers
	 */
	@Override
	public int getUserEnrollOffersCount() {
		return userEnrollOfferPersistence.countAll();
	}

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
	@Override
	public UserEnrollOffer updateUserEnrollOffer(
		UserEnrollOffer userEnrollOffer) {

		return userEnrollOfferPersistence.update(userEnrollOffer);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			UserEnrollOfferLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		userEnrollOfferLocalService = (UserEnrollOfferLocalService)aopProxy;

		_setLocalServiceUtilService(userEnrollOfferLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return UserEnrollOfferLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return UserEnrollOffer.class;
	}

	protected String getModelClassName() {
		return UserEnrollOffer.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = userEnrollOfferPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		UserEnrollOfferLocalService userEnrollOfferLocalService) {

		try {
			Field field =
				UserEnrollOfferLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, userEnrollOfferLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected CompanyProfilePersistence companyProfilePersistence;

	@Reference
	protected DegreePersistence degreePersistence;

	@Reference
	protected DegreeAreaPersistence degreeAreaPersistence;

	@Reference
	protected OfferPersistence offerPersistence;

	@Reference
	protected SocialMediaPersistence socialMediaPersistence;

	@Reference
	protected SocialMediaNetworkPersistence socialMediaNetworkPersistence;

	@Reference
	protected StudentProfilePersistence studentProfilePersistence;

	protected UserEnrollOfferLocalService userEnrollOfferLocalService;

	@Reference
	protected UserEnrollOfferPersistence userEnrollOfferPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}