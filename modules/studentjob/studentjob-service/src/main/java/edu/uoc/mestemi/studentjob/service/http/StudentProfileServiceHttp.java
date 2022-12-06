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

import edu.uoc.mestemi.studentjob.service.StudentProfileServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>StudentProfileServiceUtil</code> service
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
public class StudentProfileServiceHttp {

	public static edu.uoc.mestemi.studentjob.model.StudentProfile
			addStudentProfile(
				HttpPrincipal httpPrincipal, long groupId, long userId,
				long regionId, boolean active,
				java.util.Map<java.util.Locale, String> titleMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String email, String preference, long curriculumId,
				java.util.List<Long> degreeIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				StudentProfileServiceUtil.class, "addStudentProfile",
				_addStudentProfileParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userId, regionId, active, titleMap,
				descriptionMap, email, preference, curriculumId, degreeIds,
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

			return (edu.uoc.mestemi.studentjob.model.StudentProfile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.StudentProfile
			updateStudentProfile(
				HttpPrincipal httpPrincipal, long studentProfileId,
				long regionId, boolean active,
				java.util.Map<java.util.Locale, String> titleMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String email, String preference, long curriculumId,
				java.util.List<Long> degreeIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				StudentProfileServiceUtil.class, "updateStudentProfile",
				_updateStudentProfileParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, studentProfileId, regionId, active, titleMap,
				descriptionMap, email, preference, curriculumId, degreeIds,
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

			return (edu.uoc.mestemi.studentjob.model.StudentProfile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.StudentProfile
			deleteStudentProfile(
				HttpPrincipal httpPrincipal, long studentProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				StudentProfileServiceUtil.class, "deleteStudentProfile",
				_deleteStudentProfileParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, studentProfileId);

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

			return (edu.uoc.mestemi.studentjob.model.StudentProfile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.StudentProfile
			getStudentProfile(HttpPrincipal httpPrincipal, long socialMediaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				StudentProfileServiceUtil.class, "getStudentProfile",
				_getStudentProfileParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, socialMediaId);

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

			return (edu.uoc.mestemi.studentjob.model.StudentProfile)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		StudentProfileServiceHttp.class);

	private static final Class<?>[] _addStudentProfileParameterTypes0 =
		new Class[] {
			long.class, long.class, long.class, boolean.class,
			java.util.Map.class, java.util.Map.class, String.class,
			String.class, long.class, java.util.List.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateStudentProfileParameterTypes1 =
		new Class[] {
			long.class, long.class, boolean.class, java.util.Map.class,
			java.util.Map.class, String.class, String.class, long.class,
			java.util.List.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteStudentProfileParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getStudentProfileParameterTypes3 =
		new Class[] {long.class};

}