package edu.uoc.mestemi.studentjob.web.portlet.admin.companyprofile.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
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
import edu.uoc.mestemi.studentjob.util.StudentjobUtilities;
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

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		CompanyProfile companyProfile = companyProfileService.getCompanyProfileByGroupIdAndUserId(groupId, userId);
		long companyProfileId = companyProfile.getCompanyProfileId();

		if (companyProfile.getUserId() != userId && !themeDisplay.getPermissionChecker().isOmniadmin()) {
			PortletResponse portletResponse = (PortletResponse) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);
			LiferayPortletResponse liferayPortletResponse = PortalUtil.getLiferayPortletResponse(portletResponse);
			LiferayPortletURL renderUrl = liferayPortletResponse.createLiferayPortletURL(themeDisplay.getPlid(), StudentjobPortletKeys.STUDENTJOB_COMPANYPROFILE_ADMIN, PortletRequest.RENDER_PHASE);
			return renderUrl.toString();
		}
		
		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		
		String redirect = renderRequest.getRenderParameters().getValue("redirect");

		portletDisplay.setURLBack(redirect);
		
		List<Region> regions = ProvinceUtil.getRegionsByCountryA3(companyId, CountryA3Constants.SPAIN, true);
		List<SocialMediaNetwork> socialMediaNetworks = socialMediaNetworkService.getSocialMediaNetworksByGroupId(groupId);
		
		List<SocialMedia> socialMedias = socialMediaService.getSocialMediaNetworksByGroupIdAndClass(
				groupId, CompanyProfile.class.getName(), companyProfileId);
		
		boolean canHide = true;
		if (StudentjobUtilities.userHasOffers(groupId, userId))
			canHide = false;
		
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
		
		// Set companyProfile to the request attributes.
		renderRequest.setAttribute("companyProfile", companyProfile);
		renderRequest.setAttribute("regions", regions);
		renderRequest.setAttribute("socialMediaPrefix", StudentjobConstants.SOCIALMEDIA_FORM_PREFIX);
		renderRequest.setAttribute("socialMediaNetworks", socialMediaNetworks);
		renderRequest.setAttribute("socialMediasList", socialMediasList);
		renderRequest.setAttribute("companyProfileClass", CompanyProfile.class);
		renderRequest.setAttribute("locale", themeDisplay.getLocale());
		renderRequest.setAttribute("canHide", canHide);
		
		return "/companyProfile/user/edit_companyProfile.jsp";
	}
	
	@Reference
	private CompanyProfileService companyProfileService;
	
	@Reference
	private SocialMediaNetworkService socialMediaNetworkService;
	
	@Reference
	private SocialMediaService socialMediaService;
}