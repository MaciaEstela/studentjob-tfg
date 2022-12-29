package edu.uoc.mestemi.studentjob.web.portlet.admin.socialmedianetwork.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.NoSuchSocialMediaNetworkException;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkService;
import edu.uoc.mestemi.studentjob.util.DocumentLibraryUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

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

		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SocialMediaNetwork socialMediaNetwork = null;
		
		long socialMediaNetworkId = ParamUtil.getLong(renderRequest, "socialMediaNetworkId", 0);
		String logoURL = StringPool.BLANK;
		
		if (socialMediaNetworkId > 0) {
			try {
				// Call the service to get the socialMediaNetwork for editing.
				socialMediaNetwork = _socialMediaNetworkService.getSocialMediaNetwork(socialMediaNetworkId);
				logoURL = DocumentLibraryUtil.getFileDownloadURL(themeDisplay, socialMediaNetwork.getLogo());
			}
			catch (NoSuchSocialMediaNetworkException nsoe) {
				log.error("Can't find data for SocialMediaNetwork with socialMediaNetworkId " + socialMediaNetworkId, nsoe);
			}
			catch (PortalException pe) {
				log.error("Error on rendering data for SocialMediaNetwork with socialMediaNetworkId " + socialMediaNetworkId, pe);
			}
		}

		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		
		String redirect = renderRequest.getRenderParameters().getValue("redirect");

		portletDisplay.setURLBack(redirect);
		
		// Set socialMediaNetwork to the request attributes.
		renderRequest.setAttribute("socialMediaNetwork", socialMediaNetwork);
		renderRequest.setAttribute("socialMediaNetworkClass", SocialMediaNetwork.class);
		renderRequest.setAttribute("locale", themeDisplay.getLocale());
		renderRequest.setAttribute("logoUrl", logoURL);
		
		return "/socialMediaNetwork/admin/edit_socialMediaNetwork.jsp";
	}

	@Reference
	private SocialMediaNetworkService _socialMediaNetworkService;
}