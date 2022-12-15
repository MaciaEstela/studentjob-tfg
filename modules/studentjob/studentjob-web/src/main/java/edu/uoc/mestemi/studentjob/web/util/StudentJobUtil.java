package edu.uoc.mestemi.studentjob.web.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.portlet.ActionRequest;

import org.jsoup.Jsoup;

import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.SocialMediaLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkLocalService;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.web.dto.OfferDTO;

public class StudentJobUtil {
	
	private static final Log log = LogFactoryUtil.getLog(StudentJobUtil.class);


	private StudentJobUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static long getCountryIdByCode(long companyId, String codeA3) throws PortalException {
		return CountryLocalServiceUtil.getCountryByA3(companyId, codeA3).getCountryId();
	}
	
	public static long getRegionId(long countryId, String regionCode) throws PortalException {
		return RegionLocalServiceUtil.getRegion(countryId, regionCode).getRegionId();
	}
	
	public static List<Region> getRegionsByCountryA3(long companyId, String countryA3, boolean active) throws PortalException {
		Country country = CountryLocalServiceUtil.getCountryByA3(companyId, countryA3);
		return RegionLocalServiceUtil.getRegions(country.getCountryId(), active);
	}
	
	public static void updateSocialMediaNetwork(long groupId, ActionRequest actionRequest, 
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
	
	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public static long getDifferenceMinutes(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public static OfferDTO getOfferDTOByOffer(Offer offer, ThemeDisplay themeDisplay, String portletURL) throws PortalException {
		OfferDTO offerDTO = null;
		User user = UserLocalServiceUtil.getUser(offer.getUserId());
		long differenceMinutes = StudentJobUtil.getDifferenceMinutes(offer.getCreateDate(), new Date());
		String labelAgo = "created";
		
		if (offer.getCreateDate().getTime() != offer.getModifiedDate().getTime()) {
			differenceMinutes = StudentJobUtil.getDifferenceMinutes(offer.getModifiedDate(), new Date());
			labelAgo = "modified";	
		}
		
		Locale locale = themeDisplay.getLocale();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("content.Language", locale, UTF8Control.INSTANCE);
		String agoText = StringPool.BLANK;
		
		if (differenceMinutes < 60) {
			if (differenceMinutes == 1) {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.offers." + labelAgo + ".minute-ago", differenceMinutes);	
			} else {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.offers." + labelAgo + ".minutes-ago", differenceMinutes);
			}
		} else if (differenceMinutes >= 60 && differenceMinutes < (48*60)) {
			int hours = (int) differenceMinutes / 60;
			if (hours == 1) {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.offers." + labelAgo + ".hour-ago", hours);
			} else {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.offers." + labelAgo + ".hours-ago", hours);
			}
		} else if (differenceMinutes >= (48*60)){
			int days = (int) differenceMinutes / 60 / 24;
			if (days == 1) {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.offers." + labelAgo + ".day-ago", days);
			} else {
				agoText = LanguageUtil.format(resourceBundle, "studentjob.offers." + labelAgo + ".days-ago", days);
			}
		}
		
		String description = Jsoup.parse(offer.getDescription(locale)).text();
		
		if (description.length() > 200) {
			description = description.substring(0, 200) + "...";
		}
		
		offerDTO = new OfferDTO(
			offer.getTitle(locale), 
			(String) user.getExpandoBridge().getAttribute("userCompany"),
			user.getPortraitURL(themeDisplay), 
			LanguageUtil.get(resourceBundle, "studentjob.offers.preference." + offer.getPreference()), 
			description, 
			agoText,
			portletURL
		);
		
		return offerDTO;
	}
	
	public static User getAdminUser(long companyId) {
		User adminUser = null;
		try {
			adminUser = UserLocalServiceUtil.getRoleUsers(
					RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR).getRoleId()
			).get(0);
		} catch (PortalException e) {
			log.error("Error obtaining user with admin role", e);
		}
		
		return adminUser;
	}
}
