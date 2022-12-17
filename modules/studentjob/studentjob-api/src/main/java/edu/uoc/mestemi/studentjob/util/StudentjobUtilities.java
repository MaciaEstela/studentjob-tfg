package edu.uoc.mestemi.studentjob.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaException;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.SocialMediaLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkLocalServiceUtil;

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
}
