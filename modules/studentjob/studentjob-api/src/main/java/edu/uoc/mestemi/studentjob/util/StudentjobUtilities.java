package edu.uoc.mestemi.studentjob.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;

import javax.portlet.ActionRequest;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.service.OfferLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.SocialMediaLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.StudentProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferLocalServiceUtil;

public class StudentjobUtilities {

	private static final Log log = LogFactoryUtil.getLog(StudentjobUtilities.class);
	
	private StudentjobUtilities() {
		throw new IllegalStateException("Utility class");
	}
	
	public static void updateSocialMedia(long groupId, ActionRequest actionRequest, 
			String className, long classPK, ServiceContext serviceContext) throws PortalException {
		List<SocialMediaNetwork> socialMediaNetworks = SocialMediaNetworkLocalServiceUtil.getSocialMediaNetworksByGroupId(groupId);
		
		for (SocialMediaNetwork socialMediaNetwork : socialMediaNetworks) {
			long socialMediaNetworkId = socialMediaNetwork.getSocialMediaNetworkId();
			String socialURL = ParamUtil.get(actionRequest, 
					StudentjobConstants.SOCIALMEDIA_FORM_PREFIX + socialMediaNetworkId, StringPool.BLANK).trim();
			
			try {
				SocialMedia socialMedia = SocialMediaLocalServiceUtil.
					getSocialMediaNetworkByGroupIdAndClassNameAndClassPKAndSocialMediaNetworkId(
						groupId, 
						className, 
						classPK, 
						socialMediaNetworkId);
				SocialMediaLocalServiceUtil.updateSocialMedia(socialMedia.getSocialMediaId(), socialURL, serviceContext);
			} catch (NoSuchSocialMediaException e) {
				SocialMediaLocalServiceUtil.addSocialMedia(
						groupId,
						socialMediaNetworkId,
						socialURL,
						className,
						classPK,
						serviceContext
					);
			}
		}
	}
	
	public static boolean userHasEnrolledOffers(long groupId, long userId) {
		List<UserEnrollOffer> userEnrollOffers = UserEnrollOfferLocalServiceUtil.getUserEnrolledOffers(groupId, userId);
		
		for (UserEnrollOffer userEnrollOffer : userEnrollOffers) {
			try {
				Offer offer = OfferLocalServiceUtil.getOffer(userEnrollOffer.getOfferId());
				if (offer.getStatus().equals(WorkflowConstants.STATUS_APPROVED)) {
					return true;
				}
			} catch (Exception e) {
				log.error("Error parsing offer " + userEnrollOffer.getOfferId(), e);
			}
		}
		
		return false;
	}
	
	public static void removeUserEnrolledOffersByUser(long groupId, long userId) {
		List<UserEnrollOffer> userEnrollOffers = UserEnrollOfferLocalServiceUtil.getUserEnrolledOffers(groupId, userId);
		
		for (UserEnrollOffer userEnrollOffer : userEnrollOffers) {
			UserEnrollOfferLocalServiceUtil.deleteUserEnrollOffer(userEnrollOffer);
		}
	}
	
	public static void removeUserEnrollOffersByOffer(long groupId, long offerId) {
		List<UserEnrollOffer> userEnrollOffers = UserEnrollOfferLocalServiceUtil.getUserEnrollOffers(groupId, offerId);
		
		for (UserEnrollOffer userEnrollOffer : userEnrollOffers) {
			UserEnrollOfferLocalServiceUtil.deleteUserEnrollOffer(userEnrollOffer);
		}
	}
	
	public static boolean userHasOffers(long groupId, long userId) {
		List<Offer> offers = OfferLocalServiceUtil.getOffersByGroupIdAndUserId(groupId, userId);
		for (Offer offer : offers) {
			if (offer.getStatus().equals(WorkflowConstants.STATUS_APPROVED)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void removeCompanyOffers(long groupId, long userId) {
		List<Offer> offers = OfferLocalServiceUtil.getOffersByGroupIdAndUserId(groupId, userId);
		
		for (Offer offer : offers) {
			OfferLocalServiceUtil.deleteOffer(offer);
		}
	}
}
