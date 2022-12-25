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

import edu.uoc.mestemi.studentjob.service.UserEnrollOfferServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>UserEnrollOfferServiceUtil</code> service
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
public class UserEnrollOfferServiceHttp {

	public static edu.uoc.mestemi.studentjob.model.UserEnrollOffer
			addUserEnrollOffer(
				HttpPrincipal httpPrincipal, long groupId, long offerId,
				long userId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				UserEnrollOfferServiceUtil.class, "addUserEnrollOffer",
				_addUserEnrollOfferParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, offerId, userId, serviceContext);

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

			return (edu.uoc.mestemi.studentjob.model.UserEnrollOffer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.UserEnrollOffer
			deleteEnrollOffer(
				HttpPrincipal httpPrincipal, long offerId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				UserEnrollOfferServiceUtil.class, "deleteEnrollOffer",
				_deleteEnrollOfferParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, offerId, userId);

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

			return (edu.uoc.mestemi.studentjob.model.UserEnrollOffer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.UserEnrollOffer
		getUserEnrollOffer(
			HttpPrincipal httpPrincipal, long groupId, long userId,
			long offerId) {

		try {
			MethodKey methodKey = new MethodKey(
				UserEnrollOfferServiceUtil.class, "getUserEnrollOffer",
				_getUserEnrollOfferParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userId, offerId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.UserEnrollOffer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<edu.uoc.mestemi.studentjob.model.UserEnrollOffer> getUserEnrollOffers(
			HttpPrincipal httpPrincipal, long groupId, long offerId) {

		try {
			MethodKey methodKey = new MethodKey(
				UserEnrollOfferServiceUtil.class, "getUserEnrollOffers",
				_getUserEnrollOffersParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, offerId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<edu.uoc.mestemi.studentjob.model.UserEnrollOffer>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<edu.uoc.mestemi.studentjob.model.UserEnrollOffer>
			getUserEnrolledOffers(
				HttpPrincipal httpPrincipal, long groupId, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				UserEnrollOfferServiceUtil.class, "getUserEnrolledOffers",
				_getUserEnrolledOffersParameterTypes4);

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

			return (java.util.List
				<edu.uoc.mestemi.studentjob.model.UserEnrollOffer>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getUserEnrolledOffersCount(
		HttpPrincipal httpPrincipal, long groupId, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				UserEnrollOfferServiceUtil.class, "getUserEnrolledOffersCount",
				_getUserEnrolledOffersCountParameterTypes5);

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

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		UserEnrollOfferServiceHttp.class);

	private static final Class<?>[] _addUserEnrollOfferParameterTypes0 =
		new Class[] {
			long.class, long.class, long.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteEnrollOfferParameterTypes1 =
		new Class[] {long.class, long.class};
	private static final Class<?>[] _getUserEnrollOfferParameterTypes2 =
		new Class[] {long.class, long.class, long.class};
	private static final Class<?>[] _getUserEnrollOffersParameterTypes3 =
		new Class[] {long.class, long.class};
	private static final Class<?>[] _getUserEnrolledOffersParameterTypes4 =
		new Class[] {long.class, long.class};
	private static final Class<?>[] _getUserEnrolledOffersCountParameterTypes5 =
		new Class[] {long.class, long.class};

}