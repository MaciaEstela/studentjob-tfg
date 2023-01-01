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

import edu.uoc.mestemi.studentjob.service.DegreeServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DegreeServiceUtil</code> service
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
public class DegreeServiceHttp {

	public static edu.uoc.mestemi.studentjob.model.Degree addDegree(
			HttpPrincipal httpPrincipal, long groupId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.List<Long> degreeAreasIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "addDegree",
				_addDegreeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, nameMap, degreeAreasIds, serviceContext);

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

			return (edu.uoc.mestemi.studentjob.model.Degree)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.Degree updateDegree(
			HttpPrincipal httpPrincipal, long degreeId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.List<Long> degreeAreasIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "updateDegree",
				_updateDegreeParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, degreeId, nameMap, degreeAreasIds, serviceContext);

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

			return (edu.uoc.mestemi.studentjob.model.Degree)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.Degree deleteDegree(
			HttpPrincipal httpPrincipal, long degreeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "deleteDegree",
				_deleteDegreeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, degreeId);

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

			return (edu.uoc.mestemi.studentjob.model.Degree)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.Degree
			deleteDegreeWithValidation(
				HttpPrincipal httpPrincipal, long degreeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "deleteDegreeWithValidation",
				_deleteDegreeWithValidationParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, degreeId);

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

			return (edu.uoc.mestemi.studentjob.model.Degree)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.Degree getDegree(
			HttpPrincipal httpPrincipal, long degreeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "getDegree",
				_getDegreeParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, degreeId);

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

			return (edu.uoc.mestemi.studentjob.model.Degree)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByGroupId(HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "getDegreesByGroupId",
				_getDegreesByGroupIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<edu.uoc.mestemi.studentjob.model.Degree>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "getDegreesByGroupId",
				_getDegreesByGroupIdParameterTypes6);

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

			return (java.util.List<edu.uoc.mestemi.studentjob.model.Degree>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Degree> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "getDegreesByGroupId",
				_getDegreesByGroupIdParameterTypes7);

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

			return (java.util.List<edu.uoc.mestemi.studentjob.model.Degree>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.DegreeArea>
		getDegreeAreasByDegreeId(HttpPrincipal httpPrincipal, long degreeId) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "getDegreeAreasByDegreeId",
				_getDegreeAreasByDegreeIdParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, degreeId);

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

	public static java.util.List<Long> getDegreeAreasIdsByDegreeId(
		HttpPrincipal httpPrincipal, long degreeId) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "getDegreeAreasIdsByDegreeId",
				_getDegreeAreasIdsByDegreeIdParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, degreeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<Long>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.Degree>
		getDegreesByKeywords(
			HttpPrincipal httpPrincipal, long groupId, String keywords,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Degree> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "getDegreesByKeywords",
				_getDegreesByKeywordsParameterTypes10);

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

			return (java.util.List<edu.uoc.mestemi.studentjob.model.Degree>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getDegreesCountByKeywords(
		HttpPrincipal httpPrincipal, long groupId, String keywords) {

		try {
			MethodKey methodKey = new MethodKey(
				DegreeServiceUtil.class, "getDegreesCountByKeywords",
				_getDegreesCountByKeywordsParameterTypes11);

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

	private static Log _log = LogFactoryUtil.getLog(DegreeServiceHttp.class);

	private static final Class<?>[] _addDegreeParameterTypes0 = new Class[] {
		long.class, java.util.Map.class, java.util.List.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateDegreeParameterTypes1 = new Class[] {
		long.class, java.util.Map.class, java.util.List.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteDegreeParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _deleteDegreeWithValidationParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _getDegreeParameterTypes4 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getDegreesByGroupIdParameterTypes5 =
		new Class[] {long.class};
	private static final Class<?>[] _getDegreesByGroupIdParameterTypes6 =
		new Class[] {long.class, int.class, int.class};
	private static final Class<?>[] _getDegreesByGroupIdParameterTypes7 =
		new Class[] {
			long.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getDegreeAreasByDegreeIdParameterTypes8 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getDegreeAreasIdsByDegreeIdParameterTypes9 = new Class[] {long.class};
	private static final Class<?>[] _getDegreesByKeywordsParameterTypes10 =
		new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getDegreesCountByKeywordsParameterTypes11 =
		new Class[] {long.class, String.class};

}