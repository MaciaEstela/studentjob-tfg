package edu.uoc.mestemi.studentjob.web.portlet.admin.socialmedianetwork.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaNetworkException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.util.StudentJobUtil;

/**
 * MVC Command for showing edit socialMediaNetwork view.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_SOCIALMEDIANETWORK_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EDIT_SOCIALMEDIANETWORK_ADMIN
	}, 
	service = MVCRenderCommand.class
)
public class EditSocialMediaNetworkMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(EditSocialMediaNetworkMVCRenderCommand.class);
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		SocialMediaNetwork socialMediaNetwork = null;

		long socialMediaNetworkId = ParamUtil.getLong(renderRequest, "socialMediaNetworkId", 0);

		if (socialMediaNetworkId > 0) {
			try {
				// Call the service to get the socialMediaNetwork for editing.
				socialMediaNetwork = _socialMediaNetworkService.getSocialMediaNetwork(socialMediaNetworkId);
			}
			catch (NoSuchSocialMediaNetworkException nsoe) {
				log.error("Can't find data for SocialMediaNetwork with socialMediaNetworkId " + socialMediaNetworkId + " - Message: " + nsoe.getMessage());
			}
			catch (PortalException pe) {
				log.error("Error on rendering data for SocialMediaNetwork with socialMediaNetworkId " + socialMediaNetworkId + " - Message: " + pe.getMessage());
			}
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		
		String redirect = renderRequest.getRenderParameters().getValue("redirect");

		portletDisplay.setURLBack(redirect);
		
		// Set socialMediaNetwork to the request attributes.
		renderRequest.setAttribute("socialMediaNetwork", socialMediaNetwork);
		renderRequest.setAttribute("socialMediaNetworkClass", SocialMediaNetwork.class);
		renderRequest.setAttribute("locale", themeDisplay.getLocale());
		
		return "/socialMediaNetwork/admin/edit_socialMediaNetwork.jsp";
	}

	@Reference
	private SocialMediaNetworkService _socialMediaNetworkService;
	
	@Reference
	private RegionService _regionService;
	
	@Reference
	private CountryService _countryService;
	
	@Reference
	private DegreeService _degreeService;
}