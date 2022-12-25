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

import edu.uoc.mestemi.studentjob.service.OfferServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>OfferServiceUtil</code> service
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
public class OfferServiceHttp {

	public static edu.uoc.mestemi.studentjob.model.Offer addOffer(
			HttpPrincipal httpPrincipal, long groupId, long regionId,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String preference, java.util.List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "addOffer", _addOfferParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, regionId, titleMap, descriptionMap,
				preference, degreeIds, serviceContext);

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

			return (edu.uoc.mestemi.studentjob.model.Offer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.Offer updateOffer(
			HttpPrincipal httpPrincipal, long offerId, long regionId,
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String preference, java.util.List<Long> degreeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "updateOffer",
				_updateOfferParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, offerId, regionId, titleMap, descriptionMap,
				preference, degreeIds, serviceContext);

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

			return (edu.uoc.mestemi.studentjob.model.Offer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.Offer deleteOffer(
			HttpPrincipal httpPrincipal, long offerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "deleteOffer",
				_deleteOfferParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, offerId);

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

			return (edu.uoc.mestemi.studentjob.model.Offer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.Offer getOffer(
			HttpPrincipal httpPrincipal, long offerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "getOffer", _getOfferParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, offerId);

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

			return (edu.uoc.mestemi.studentjob.model.Offer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByGroupId(HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "getOffersByGroupId",
				_getOffersByGroupIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<edu.uoc.mestemi.studentjob.model.Offer>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "getOffersByGroupId",
				_getOffersByGroupIdParameterTypes5);

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

			return (java.util.List<edu.uoc.mestemi.studentjob.model.Offer>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<Long> getDegreesIdsByOfferId(
		HttpPrincipal httpPrincipal, long offerId) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "getDegreesIdsByOfferId",
				_getDegreesIdsByOfferIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, offerId);

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
		getDegreesByOfferId(HttpPrincipal httpPrincipal, long offerId) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "getDegreesByOfferId",
				_getDegreesByOfferIdParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, offerId);

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

	public static java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Offer> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "getOffersByGroupId",
				_getOffersByGroupIdParameterTypes8);

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

			return (java.util.List<edu.uoc.mestemi.studentjob.model.Offer>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByKeywords(
			HttpPrincipal httpPrincipal, long groupId, long userId,
			String keywords, int workflowStatus, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Offer> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "getOffersByKeywords",
				_getOffersByKeywordsParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userId, keywords, workflowStatus, start,
				end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<edu.uoc.mestemi.studentjob.model.Offer>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getOffersCountByKeywords(
		HttpPrincipal httpPrincipal, long groupId, long userId, String keywords,
		int workflowStatus) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "getOffersCountByKeywords",
				_getOffersCountByKeywordsParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userId, keywords, workflowStatus);

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

	public static java.util.List<edu.uoc.mestemi.studentjob.model.Offer>
		getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			HttpPrincipal httpPrincipal, long groupId, long userId,
			String keywords, String preference, long regionId, long degreeId,
			int workflowStatus, long newestId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<edu.uoc.mestemi.studentjob.model.Offer> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class,
				"getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId",
				_getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeIdParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userId, keywords, preference, regionId,
				degreeId, workflowStatus, newestId, start, end,
				orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<edu.uoc.mestemi.studentjob.model.Offer>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long
		getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
			HttpPrincipal httpPrincipal, long groupId, long userId,
			String keywords, String preference, long regionId, long degreeId,
			int workflowStatus, long newestId) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class,
				"getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId",
				_getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeIdParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userId, keywords, preference, regionId,
				degreeId, workflowStatus, newestId);

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

	public static edu.uoc.mestemi.studentjob.model.Offer addOffer(
		HttpPrincipal httpPrincipal,
		edu.uoc.mestemi.studentjob.model.Offer offer) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "addOffer", _addOfferParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey, offer);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.Offer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.Offer updateOffer(
		HttpPrincipal httpPrincipal,
		edu.uoc.mestemi.studentjob.model.Offer offer) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "updateOffer",
				_updateOfferParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey, offer);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.Offer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.Offer expireOffer(
		HttpPrincipal httpPrincipal,
		edu.uoc.mestemi.studentjob.model.Offer offer) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "expireOffer",
				_expireOfferParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(methodKey, offer);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.Offer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static edu.uoc.mestemi.studentjob.model.Offer expireOffer(
		HttpPrincipal httpPrincipal, long offerId) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "expireOffer",
				_expireOfferParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(methodKey, offerId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (edu.uoc.mestemi.studentjob.model.Offer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(OfferServiceHttp.class);

	private static final Class<?>[] _addOfferParameterTypes0 = new Class[] {
		long.class, long.class, java.util.Map.class, java.util.Map.class,
		String.class, java.util.List.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateOfferParameterTypes1 = new Class[] {
		long.class, long.class, java.util.Map.class, java.util.Map.class,
		String.class, java.util.List.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteOfferParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getOfferParameterTypes3 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getOffersByGroupIdParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _getOffersByGroupIdParameterTypes5 =
		new Class[] {long.class, int.class, int.class};
	private static final Class<?>[] _getDegreesIdsByOfferIdParameterTypes6 =
		new Class[] {long.class};
	private static final Class<?>[] _getDegreesByOfferIdParameterTypes7 =
		new Class[] {long.class};
	private static final Class<?>[] _getOffersByGroupIdParameterTypes8 =
		new Class[] {
			long.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getOffersByKeywordsParameterTypes9 =
		new Class[] {
			long.class, long.class, String.class, int.class, int.class,
			int.class, com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getOffersCountByKeywordsParameterTypes10 =
		new Class[] {long.class, long.class, String.class, int.class};
	private static final Class<?>[]
		_getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeIdParameterTypes11 =
			new Class[] {
				long.class, long.class, String.class, String.class, long.class,
				long.class, int.class, long.class, int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class
			};
	private static final Class<?>[]
		_getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeIdParameterTypes12 =
			new Class[] {
				long.class, long.class, String.class, String.class, long.class,
				long.class, int.class, long.class
			};
	private static final Class<?>[] _addOfferParameterTypes13 = new Class[] {
		edu.uoc.mestemi.studentjob.model.Offer.class
	};
	private static final Class<?>[] _updateOfferParameterTypes14 = new Class[] {
		edu.uoc.mestemi.studentjob.model.Offer.class
	};
	private static final Class<?>[] _expireOfferParameterTypes15 = new Class[] {
		edu.uoc.mestemi.studentjob.model.Offer.class
	};
	private static final Class<?>[] _expireOfferParameterTypes16 = new Class[] {
		long.class
	};

}