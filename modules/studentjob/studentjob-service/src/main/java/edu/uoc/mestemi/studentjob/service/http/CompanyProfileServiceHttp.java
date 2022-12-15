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

package edu.uoc.mestemi.studentjob.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import edu.uoc.mestemi.studentjob.service.CompanyProfileServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>CompanyProfileServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CompanyProfileServiceHttp {

	public static edu.uoc.mestemi.studentjob.model.CompanyProfile
			addCompanyProfile(
				HttpPrincipal httpPrincipal, long groupId, long userId,
				long regionId, boolean active,
				java.util.Map<java.util.Locale, String> titleMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String email, java.util.Map<java.util.Locale, String> sectorMap,
				String website,
				java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
					socialMedias,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CompanyProfileServiceUtil.class, "addCompanyProfile",
				_addCompanyProfileParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userId, regionId, active, titleMap,
				descriptionMap, email, sectorMap, website, socialMedias,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.CompanyProfile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.CompanyProfile
			updateCompanyProfile(
				HttpPrincipal httpPrincipal, long companyProfileId,
				long regionId, boolean active,
				java.util.Map<java.util.Locale, String> titleMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String email, java.util.Map<java.util.Locale, String> sectorMap,
				String website,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CompanyProfileServiceUtil.class, "updateCompanyProfile",
				_updateCompanyProfileParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyProfileId, regionId, active, titleMap,
				descriptionMap, email, sectorMap, website, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.CompanyProfile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.CompanyProfile
			deleteCompanyProfile(
				HttpPrincipal httpPrincipal, long companyProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CompanyProfileServiceUtil.class, "deleteCompanyProfile",
				_deleteCompanyProfileParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyProfileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.CompanyProfile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.CompanyProfile
		getCompanyProfileByGroupIdAndUserId(
			HttpPrincipal httpPrincipal, long groupId, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				CompanyProfileServiceUtil.class,
				"getCompanyProfileByGroupIdAndUserId",
				_getCompanyProfileByGroupIdAndUserIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.CompanyProfile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.CompanyProfile
			getCompanyProfile(
				HttpPrincipal httpPrincipal, long companyProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CompanyProfileServiceUtil.class, "getCompanyProfile",
				_getCompanyProfileParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyProfileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.CompanyProfile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<edu.uoc.mestemi.studentjob.model.CompanyProfile>
			getCompanyProfilesByGroupId(
				HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				CompanyProfileServiceUtil.class, "getCompanyProfilesByGroupId",
				_getCompanyProfilesByGroupIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<edu.uoc.mestemi.studentjob.model.CompanyProfile>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<edu.uoc.mestemi.studentjob.model.CompanyProfile>
			getCompanyProfilesByGroupId(
				HttpPrincipal httpPrincipal, long groupId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				CompanyProfileServiceUtil.class, "getCompanyProfilesByGroupId",
				_getCompanyProfilesByGroupIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<edu.uoc.mestemi.studentjob.model.CompanyProfile>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<edu.uoc.mestemi.studentjob.model.CompanyProfile>
			getCompanyProfilesByGroupId(
				HttpPrincipal httpPrincipal, long groupId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<edu.uoc.mestemi.studentjob.model.CompanyProfile>
						orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				CompanyProfileServiceUtil.class, "getCompanyProfilesByGroupId",
				_getCompanyProfilesByGroupIdParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<edu.uoc.mestemi.studentjob.model.CompanyProfile>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<edu.uoc.mestemi.studentjob.model.CompanyProfile>
			getCompanyProfilesByKeywords(
				HttpPrincipal httpPrincipal, long groupId, String keywords,
				int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<edu.uoc.mestemi.studentjob.model.CompanyProfile>
						orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				CompanyProfileServiceUtil.class, "getCompanyProfilesByKeywords",
				_getCompanyProfilesByKeywordsParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<edu.uoc.mestemi.studentjob.model.CompanyProfile>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getCompanyProfilesCountByKeywords(
		HttpPrincipal httpPrincipal, long groupId, String keywords) {

		try {
			MethodKey methodKey = new MethodKey(
				CompanyProfileServiceUtil.class,
				"getCompanyProfilesCountByKeywords",
				_getCompanyProfilesCountByKeywordsParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CompanyProfileServiceHttp.class);

	private static final Class<?>[] _addCompanyProfileParameterTypes0 =
		new Class[] {
			long.class, long.class, long.class, boolean.class,
			java.util.Map.class, java.util.Map.class, String.class,
			java.util.Map.class, String.class, java.util.List.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateCompanyProfileParameterTypes1 =
		new Class[] {
			long.class, long.class, boolean.class, java.util.Map.class,
			java.util.Map.class, String.class, java.util.Map.class,
			String.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteCompanyProfileParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getCompanyProfileByGroupIdAndUserIdParameterTypes3 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getCompanyProfileParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getCompanyProfilesByGroupIdParameterTypes5 = new Class[] {long.class};
	private static final Class<?>[]
		_getCompanyProfilesByGroupIdParameterTypes6 = new Class[] {
			long.class, int.class, int.class
		};
	private static final Class<?>[]
		_getCompanyProfilesByGroupIdParameterTypes7 = new Class[] {
			long.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getCompanyProfilesByKeywordsParameterTypes8 = new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getCompanyProfilesCountByKeywordsParameterTypes9 = new Class[] {
			long.class, String.class
		};

}