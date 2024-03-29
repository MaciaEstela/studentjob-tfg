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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.service.CompanyProfileService;
import edu.uoc.mestemi.studentjob.service.CompanyProfileServiceUtil;
import edu.uoc.mestemi.studentjob.service.persistence.CompanyProfilePersistence;
import edu.uoc.mestemi.studentjob.service.persistence.DegreeAreaPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.DegreePersistence;
import edu.uoc.mestemi.studentjob.service.persistence.OfferPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.SocialMediaNetworkPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.SocialMediaPersistence;
import edu.uoc.mestemi.studentjob.service.persistence.StudentProfilePersistence;
import edu.uoc.mestemi.studentjob.service.persistence.UserEnrollOfferPersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the company profile remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link edu.uoc.mestemi.studentjob.service.impl.CompanyProfileServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see edu.uoc.mestemi.studentjob.service.impl.CompanyProfileServiceImpl
 * @generated
 */
public abstract class CompanyProfileServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, CompanyProfileService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CompanyProfileService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CompanyProfileServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CompanyProfileService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		companyProfileService = (CompanyProfileService)aopProxy;

		_setServiceUtilService(companyProfileService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CompanyProfileService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CompanyProfile.class;
	}

	protected String getModelClassName() {
		return CompanyProfile.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = companyProfilePersistence.getDataSource();

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

	private void _setServiceUtilService(
		CompanyProfileService companyProfileService) {

		try {
			Field field = CompanyProfileServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, companyProfileService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected edu.uoc.mestemi.studentjob.service.CompanyProfileLocalService
		companyProfileLocalService;

	protected CompanyProfileService companyProfileService;

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

	@Reference
	protected UserEnrollOfferPersistence userEnrollOfferPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetCategoryLocalService
		assetCategoryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetCategoryService
		assetCategoryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

}