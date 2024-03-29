package edu.uoc.mestemi.studentjob.web.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.jsoup.Jsoup;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.dto.MyInscriptionDTO;
import edu.uoc.mestemi.studentjob.dto.OfferDTO;
import edu.uoc.mestemi.studentjob.dto.SocialMediaDTO;
import edu.uoc.mestemi.studentjob.dto.StudentProfileDTO;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.service.DegreeLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.OfferLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkLocalServiceUtil;
import edu.uoc.mestemi.studentjob.util.CommonUtilities;
import edu.uoc.mestemi.studentjob.util.DocumentLibraryUtil;

public class DTOUtil {

	private DTOUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	private static final String RESOURCE_STUDENTJOB_OFFERS = "studentjob.offers."; 
	
	public static OfferDTO getOfferDTOByOffer(Offer offer, ThemeDisplay themeDisplay, String portletURL) throws PortalException {
		OfferDTO offerDTO = null;
		User user = UserLocalServiceUtil.getUser(offer.getUserId());
		long differenceMinutes = CommonUtilities.getDifferenceMinutes(offer.getCreateDate(), new Date());
		String labelAgo = "created";
		
		if (offer.getCreateDate().getTime() != offer.getModifiedDate().getTime()) {
			differenceMinutes = CommonUtilities.getDifferenceMinutes(offer.getModifiedDate(), new Date());
			labelAgo = "modified";	
		}
		
		Locale locale = themeDisplay.getLocale();
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle(StudentjobConstants.CONTENT_LANGUAGE, locale, UTF8Control.INSTANCE);
		String agoText = StringPool.BLANK;
		
		if (differenceMinutes < 60) {
			if (differenceMinutes == 1) {
				agoText = LanguageUtil.format(resourceBundle, RESOURCE_STUDENTJOB_OFFERS + labelAgo + ".minute-ago", differenceMinutes);	
			} else {
				agoText = LanguageUtil.format(resourceBundle, RESOURCE_STUDENTJOB_OFFERS + labelAgo + ".minutes-ago", differenceMinutes);
			}
		} else if (differenceMinutes >= 60 && differenceMinutes < (48*60)) {
			int hours = (int) differenceMinutes / 60;
			if (hours == 1) {
				agoText = LanguageUtil.format(resourceBundle, RESOURCE_STUDENTJOB_OFFERS + labelAgo + ".hour-ago", hours);
			} else {
				agoText = LanguageUtil.format(resourceBundle, RESOURCE_STUDENTJOB_OFFERS + labelAgo + ".hours-ago", hours);
			}
		} else if (differenceMinutes >= (48*60)){
			int days = (int) differenceMinutes / 60 / 24;
			if (days == 1) {
				agoText = LanguageUtil.format(resourceBundle, RESOURCE_STUDENTJOB_OFFERS + labelAgo + ".day-ago", days);
			} else {
				agoText = LanguageUtil.format(resourceBundle, RESOURCE_STUDENTJOB_OFFERS + labelAgo + ".days-ago", days);
			}
		}
		
		String description = Jsoup.parse(offer.getDescription(locale)).text();
		
		if (description.length() > 200) {
			description = description.substring(0, 200) + "...";
		}
		
		String province = RegionLocalServiceUtil.getRegion(offer.getRegionId()).getName();
		
		offerDTO = new OfferDTO(
			offer.getTitle(locale), 
			(String) user.getExpandoBridge().getAttribute("userCompany"),
			user.getPortraitURL(themeDisplay), 
			LanguageUtil.get(resourceBundle, "studentjob.preference." + offer.getPreference()), 
			description, 
			agoText,
			portletURL,
			province
		);
		
		return offerDTO;
	}
	
	public static StudentProfileDTO getStudentProfileDTOByStudentProfile(StudentProfile studentProfile, 
			ThemeDisplay themeDisplay, String portletURL) throws PortalException {
 		
		StudentProfileDTO studentProfileDTO = null;
		Locale locale = themeDisplay.getLocale();
		
		User user = UserLocalServiceUtil.getUser(studentProfile.getUserId());
		String name = user.getFirstName();
		String surname = user.getLastName();
		List<Degree> degrees = DegreeLocalServiceUtil.getStudentProfileDegrees(studentProfile.getStudentProfileId(), 0, 3);
		List<String> degreesString = new ArrayList<>();
		
		for (Degree degree : degrees) {
			degreesString.add(degree.getName(locale));
		}
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle(StudentjobConstants.CONTENT_LANGUAGE, locale, UTF8Control.INSTANCE);

		Region region = RegionLocalServiceUtil.getRegion(studentProfile.getRegionId());
		
		studentProfileDTO = new StudentProfileDTO(
				studentProfile.getStudentProfileId(),
				name, 
				surname, 
				degreesString, 
				studentProfile.getTitle(locale), 
				region.getName(), 
				LanguageUtil.get(resourceBundle, "studentjob.preference." + studentProfile.getPreference()), 
				DocumentLibraryUtil.getFileDownloadURL(themeDisplay, studentProfile.getCurriculumId()), 
				user.getPortraitURL(themeDisplay),
				studentProfile.getDescription(locale), 
				studentProfile.getEmail(), 
				(String) user.getExpandoBridge().getAttribute(StudentjobConstants.USER_PHONE), 
				portletURL
			);
		
		return studentProfileDTO;
	}
	
	public static MyInscriptionDTO getMyInscriptionDTO(UserEnrollOffer userEnrollOffer, ThemeDisplay themeDisplay) throws PortalException {
		long offerId = userEnrollOffer.getOfferId();
		long userId = themeDisplay.getUserId();
		Locale locale = themeDisplay.getLocale();
		
		Offer offer = OfferLocalServiceUtil.getOffer(offerId);
		User companyUser = UserLocalServiceUtil.getUser(offer.getUserId());
		
		MyInscriptionDTO myInscriptionDTO = null;
		
		long differenceMinutes = CommonUtilities.getDifferenceMinutes(userEnrollOffer.getCreateDate(), new Date());
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle(StudentjobConstants.CONTENT_LANGUAGE, locale, UTF8Control.INSTANCE);
		String agoText = StringPool.BLANK;
		
		if (differenceMinutes < 60) {
			if (differenceMinutes == 1) {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.myinscriptions.created.minute-ago", differenceMinutes);	
			} else {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.myinscriptions.created.minutes-ago", differenceMinutes);
			}
		} else if (differenceMinutes >= 60 && differenceMinutes < (48*60)) {
			int hours = (int) differenceMinutes / 60;
			if (hours == 1) {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.myinscriptions.created.hour-ago", hours);
			} else {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.myinscriptions.created.hours-ago", hours);
			}
		} else if (differenceMinutes >= (48*60)){
			int days = (int) differenceMinutes / 60 / 24;
			if (days == 1) {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.myinscriptions.created.day-ago", days);
			} else {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.myinscriptions.created.days-ago", days);
			}
		}
		
		myInscriptionDTO = new MyInscriptionDTO(
				userId, 
				offerId, 
				companyUser.getPortraitURL(themeDisplay), 
				offer.getTitle(locale),
				(String) companyUser.getExpandoBridge().getAttribute("userCompany"), 
				agoText, 
				offer.getStatus() == WorkflowConstants.STATUS_APPROVED
			);
		
		return myInscriptionDTO;
	}
	
	public static SocialMediaDTO getSocialMediaDTO(ThemeDisplay themeDisplay, SocialMedia socialMedia) throws PortalException{
		SocialMediaNetwork socialMediaNetwork = SocialMediaNetworkLocalServiceUtil.getSocialMediaNetwork(
				socialMedia.getSocialMediaNetworkId());
		
		String logoUrl = DocumentLibraryUtil.getFileDownloadURL(themeDisplay, socialMediaNetwork.getLogo());
		
		return new SocialMediaDTO(
				socialMediaNetwork.getName(), logoUrl, socialMedia.getSocialURL());
	}
}
