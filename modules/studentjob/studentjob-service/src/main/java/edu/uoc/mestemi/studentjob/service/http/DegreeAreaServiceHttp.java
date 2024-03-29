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

import edu.uoc.mestemi.studentjob.service.DegreeAreaServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DegreeAreaServiceUtil</code> service
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
public class DegreeAreaServiceHttp {

	public static edu.uoc.mestemi.studentjob.model.DegreeArea addDegreeArea(
			HttpPrincipal httpPrincipal, long groupId,
			java.util.Map<java.util.Locale, String> nameMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeAreaServiceUtil.class, "addDegreeArea",
				_addDegreeAreaParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, nameMap, serviceContext);

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

			return (edu.uoc.mestemi.studentjob.model.DegreeArea)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.DegreeArea updateDegreeArea(
			HttpPrincipal httpPrincipal, long degreeAreaId,
			java.util.Map<java.util.Locale, String> nameMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeAreaServiceUtil.class, "updateDegreeArea",
				_updateDegreeAreaParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, degreeAreaId, nameMap, serviceContext);

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

			return (edu.uoc.mestemi.studentjob.model.DegreeArea)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.DegreeArea deleteDegreeArea(
			HttpPrincipal httpPrincipal, long degreeAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeAreaServiceUtil.class, "deleteDegreeArea",
				_deleteDegreeAreaParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, degreeAreaId);

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

			return (edu.uoc.mestemi.studentjob.model.DegreeArea)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.DegreeArea
			deleteDegreeAreaWithValidation(
				HttpPrincipal httpPrincipal, long degreeAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeAreaServiceUtil.class, "deleteDegreeAreaWithValidation",
				_deleteDegreeAreaWithValidationParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, degreeAreaId);

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

			return (edu.uoc.mestemi.studentjob.model.DegreeArea)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.DegreeArea getDegreeArea(
			HttpPrincipal httpPrincipal, long degreeAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeAreaServiceUtil.class, "getDegreeArea",
				_getDegreeAreaParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, degreeAreaId);

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

			return (edu.uoc.mestemi.studentjob.model.DegreeArea)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByGroupId(HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeAreaServiceUtil.class, "getDegreeAreasByGroupId",
				_getDegreeAreasByGroupIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeAreaServiceUtil.class, "getDegreeAreasByGroupId",
				_getDegreeAreasByGroupIdParameterTypes6);

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

			return (java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getCompanyProfilesByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.DegreeArea>
					orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeAreaServiceUtil.class, "getCompanyProfilesByGroupId",
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

			return (java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByKeywords(
			HttpPrincipal httpPrincipal, long groupId, String keywords,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.DegreeArea>
					orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeAreaServiceUtil.class, "getDegreeAreasByKeywords",
				_getDegreeAreasByKeywordsParameterTypes8);

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

			return (java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getDegreeAreasCountByKeywords(
		HttpPrincipal httpPrincipal, long groupId, String keywords) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeAreaServiceUtil.class, "getDegreeAreasCountByKeywords",
				_getDegreeAreasCountByKeywordsParameterTypes9);

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
		DegreeAreaServiceHttp.class);

	private static final Class<?>[] _addDegreeAreaParameterTypes0 =
		new Class[] {
			long.class, java.util.Map.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateDegreeAreaParameterTypes1 =
		new Class[] {
			long.class, java.util.Map.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteDegreeAreaParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[]
		_deleteDegreeAreaWithValidationParameterTypes3 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getDegreeAreaParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _getDegreeAreasByGroupIdParameterTypes5 =
		new Class[] {long.class};
	private static final Class<?>[] _getDegreeAreasByGroupIdParameterTypes6 =
		new Class[] {long.class, int.class, int.class};
	private static final Class<?>[]
		_getCompanyProfilesByGroupIdParameterTypes7 = new Class[] {
			long.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getDegreeAreasByKeywordsParameterTypes8 =
		new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getDegreeAreasCountByKeywordsParameterTypes9 = new Class[] {
			long.class, String.class
		};

}