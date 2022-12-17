package edu.uoc.mestemi.studentjob.web.portlet.admin.companyprofile.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.dto.SocialMediaFormDTO;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.SocialMedia;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.CompanyProfileService;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkService;
import edu.uoc.mestemi.studentjob.service.SocialMediaService;
import edu.uoc.mestemi.studentjob.util.CountryA3Constants;
import edu.uoc.mestemi.studentjob.util.ProvinceUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Command for showing edit companyProfile view.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_COMPANYPROFILE_ADMIN,
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.EDIT_STUDENTPROFILE_ADMIN_RENDER
	}, 
	service = MVCRenderCommand.class
)
public class EditCompanyProfileMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(EditCompanyProfileMVCRenderCommand.class);
	
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
		
		CompanyProfile companyProfile = _companyProfileService.getCompanyProfileByGroupIdAndUserId(groupId, userId);
		long companyProfileId = companyProfile.getCompanyProfileId();

		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		
		String redirect = renderRequest.getRenderParameters().getValue("redirect");

		portletDisplay.setURLBack(redirect);
		
		List<Region> regions = ProvinceUtil.getRegionsByCountryA3(companyId, CountryA3Constants.SPAIN, true);
		List<SocialMediaNetwork> socialMediaNetworks = _socialMediaNetworkService.getSocialMediaNetworksByGroupId(groupId);
		
		List<SocialMedia> socialMedias = _socialMediaService.getSocialMediaNetworksByGroupIdAndClass(
				groupId, CompanyProfile.class.getName(), companyProfileId);
		
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
		
		System.out.println("active es " + companyProfile.isActive());
		System.out.println(JSONFactoryUtil.createJSONArray(socialMediasList).toJSONString());
		// Set companyProfile to the request attributes.
		
		renderRequest.setAttribute("companyProfile", companyProfile);
		renderRequest.setAttribute("regions", regions);
		renderRequest.setAttribute("socialMediaPrefix", StudentjobConstants.SOCIALMEDIA_FORM_PREFIX);
		renderRequest.setAttribute("socialMediaNetworks", socialMediaNetworks);
		renderRequest.setAttribute("socialMediasList", socialMediasList);
		renderRequest.setAttribute("companyProfileClass", CompanyProfile.class);
		renderRequest.setAttribute("locale", themeDisplay.getLocale());
		
		return "/companyProfile/user/edit_companyProfile.jsp";
	}
	
	@Reference
	private CompanyProfileService _companyProfileService;
	
	@Reference
	private SocialMediaNetworkService _socialMediaNetworkService;
	
	@Reference
	private SocialMediaService _socialMediaService;
}