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

import edu.uoc.mestemi.studentjob.service.SocialMediaServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>SocialMediaServiceUtil</code> service
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
public class SocialMediaServiceHttp {

	public static edu.uoc.mestemi.studentjob.model.SocialMedia addSocialMedia(
			HttpPrincipal httpPrincipal, long groupId,
			long socialMediaNetworkId, String socialURL, String className,
			long classPK,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SocialMediaServiceUtil.class, "addSocialMedia",
				_addSocialMediaParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, socialMediaNetworkId, socialURL, className,
				classPK, serviceContext);

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

			return (edu.uoc.mestemi.studentjob.model.SocialMedia)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.SocialMedia
			updateSocialMedia(
				HttpPrincipal httpPrincipal, long socialMediaId,
				String socialURL,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SocialMediaServiceUtil.class, "updateSocialMedia",
				_updateSocialMediaParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, socialMediaId, socialURL, serviceContext);

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

			return (edu.uoc.mestemi.studentjob.model.SocialMedia)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.SocialMedia
			deleteSocialMedia(HttpPrincipal httpPrincipal, long socialMediaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SocialMediaServiceUtil.class, "deleteSocialMedia",
				_deleteSocialMediaParameterTypes2);

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

			return (edu.uoc.mestemi.studentjob.model.SocialMedia)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.SocialMedia getSocialMedia(
			HttpPrincipal httpPrincipal, long socialMediaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SocialMediaServiceUtil.class, "getSocialMedia",
				_getSocialMediaParameterTypes3);

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

			return (edu.uoc.mestemi.studentjob.model.SocialMedia)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMediaNetworksByGroupId(
			HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				SocialMediaServiceUtil.class, "getSocialMediaNetworksByGroupId",
				_getSocialMediaNetworksByGroupIdParameterTypes4);

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
				<edu.uoc.mestemi.studentjob.model.SocialMedia>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMediaNetworksByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				SocialMediaServiceUtil.class, "getSocialMediaNetworksByGroupId",
				_getSocialMediaNetworksByGroupIdParameterTypes5);

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
				<edu.uoc.mestemi.studentjob.model.SocialMedia>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMediaNetworksByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.SocialMedia>
					orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				SocialMediaServiceUtil.class, "getSocialMediaNetworksByGroupId",
				_getSocialMediaNetworksByGroupIdParameterTypes6);

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
				<edu.uoc.mestemi.studentjob.model.SocialMedia>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.SocialMedia>
		getSocialMediaNetworksByGroupIdAndClass(
			HttpPrincipal httpPrincipal, long groupId, String className,
			long classPK) {

		try {
			MethodKey methodKey = new MethodKey(
				SocialMediaServiceUtil.class,
				"getSocialMediaNetworksByGroupIdAndClass",
				_getSocialMediaNetworksByGroupIdAndClassParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, className, classPK);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<edu.uoc.mestemi.studentjob.model.SocialMedia>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.SocialMedia
			getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
				HttpPrincipal httpPrincipal, long groupId, String className,
				long classPK, long socialMediaNetworkId)
		throws edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException {

		try {
			MethodKey methodKey = new MethodKey(
				SocialMediaServiceUtil.class,
				"getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId",
				_getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkIdParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, className, classPK, socialMediaNetworkId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						edu.uoc.mestemi.studentjob.exception.
							NoSuchSocialMediaException) {

					throw (edu.uoc.mestemi.studentjob.exception.
						NoSuchSocialMediaException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.SocialMedia)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SocialMediaServiceHttp.class);

	private static final Class<?>[] _addSocialMediaParameterTypes0 =
		new Class[] {
			long.class, long.class, String.class, String.class, long.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateSocialMediaParameterTypes1 =
		new Class[] {
			long.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteSocialMediaParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getSocialMediaParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getSocialMediaNetworksByGroupIdParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getSocialMediaNetworksByGroupIdParameterTypes5 = new Class[] {
			long.class, int.class, int.class
		};
	private static final Class<?>[]
		_getSocialMediaNetworksByGroupIdParameterTypes6 = new Class[] {
			long.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getSocialMediaNetworksByGroupIdAndClassParameterTypes7 = new Class[] {
			long.class, String.class, long.class
		};
	private static final Class<?>[]
		_getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkIdParameterTypes8 =
			new Class[] {long.class, String.class, long.class, long.class};

}