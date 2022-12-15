package edu.uoc.mestemi.studentjob.web.portlet.user.studentprofile.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.NoSuchStudentProfileException;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.StudentProfileService;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkService;
import edu.uoc.mestemi.studentjob.service.SocialMediaService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.util.SocialMediaFormDTO;
import edu.uoc.mestemi.studentjob.web.util.StudentJobUtil;

/**
 * MVC Command for showing edit studentProfile view.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_STUDENTPROFILE_USER,
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.EDIT_STUDENTPROFILE_USER
	}, 
	service = MVCRenderCommand.class
)
public class EditStudentProfileMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(EditStudentProfileMVCRenderCommand.class);
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		// TODO : if user is not signed in or user is not in company group return 404
		
		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		StudentProfile studentProfile = _studentProfileService.getStudentProfileByGroupIdAndUserId(groupId, userId);
		long studentProfileId = studentProfile.getStudentProfileId();

		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		
		String redirect = renderRequest.getRenderParameters().getValue("redirect");

		portletDisplay.setURLBack(redirect);
		
		List<Region> regions = null;
		try {
			regions = StudentJobUtil.getRegionsByCountryA3(companyId, "ESP", true);
		} catch (PortalException e) {
			log.error("Error on loading Regions", e);
		}
		
		List<SocialMediaNetwork> socialMediaNetworks = _socialMediaNetworkService.getSocialMediaNetworksByGroupId(groupId);
		
		List<SocialMedia> socialMedias = _socialMediaService.getSocialMediaNetworksByGroupIdAndClass(
				groupId, StudentProfile.class.getName(), studentProfileId);
		
		List<SocialMediaFormDTO> socialMediasList = new ArrayList<>();
		for (SocialMediaNetwork socialMediaNetwork : socialMediaNetworks) {
			String socialURL = StringPool.BLANK;
			for (SocialMedia socialMedia : socialMedias) {
				if (socialMedia.getSocialMediaNetworkId() == socialMediaNetwork.getSocialMediaNetworkId()) {
					socialURL = socialMedia.getSocialURL();
					break;
				}
			}
			socialMediasList.add(new SocialMediaFormDTO(
					socialURL, socialMediaNetwork.getName(), socialMediaNetwork.getSocialMediaNetworkId()));
		}
		
		List<Long> currentStudentProfileDegreesIds = _studentProfileService.getDegreesIdsByOfferId(studentProfileId);
		System.out.println(" currentStudentProfileDegreesIds " + currentStudentProfileDegreesIds.size());
		
		System.out.println("active es " + studentProfile.isActive());
		System.out.println(JSONFactoryUtil.createJSONArray(socialMediasList).toJSONString());
		
		List<Degree> degrees = _degreeService.getDegreesByGroupId(groupId);
		
		// Set studentProfile to the request attributes.
		renderRequest.setAttribute("preferences", StudentjobConstants.JOB_PREFERENCE);
		renderRequest.setAttribute("studentProfile", studentProfile);
		renderRequest.setAttribute("currentStudentProfileDegreesIds", currentStudentProfileDegreesIds);
		renderRequest.setAttribute("regions", regions);
		renderRequest.setAttribute("degrees", degrees);
		renderRequest.setAttribute("socialMediaPrefix", StudentjobConstants.SOCIALMEDIA_FORM_PREFIX);
		renderRequest.setAttribute("socialMediaNetworks", socialMediaNetworks);
		renderRequest.setAttribute("socialMediasList", socialMediasList);
		renderRequest.setAttribute("studentProfileClass", StudentProfile.class);
		renderRequest.setAttribute("locale", themeDisplay.getLocale());
		
		return "/studentProfile/user/edit_studentProfile.jsp";
	}

	@Reference
	private RegionService _regionService;
	
	@Reference
	private CountryService _countryService;
	
	@Reference
	private StudentProfileService _studentProfileService;
	
	@Reference
	private SocialMediaNetworkService _socialMediaNetworkService;
	
	@Reference
	private SocialMediaService _socialMediaService;
	
	@Reference
	private DegreeService _degreeService;
}