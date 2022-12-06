package edu.uoc.mestemi.studentjob.web.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;

import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.SocialMediaLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkLocalService;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkService;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobConstants;

public class StudentJobUtil {

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
}
