package edu.uoc.mestemi.studentjob.web.portlet.admin.socialmedianetwork.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Locale;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.SocialMediaNetworkValidationException;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for editing socialMediaNetworks.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 *
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_SOCIALMEDIANETWORK_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EDIT_SOCIALMEDIANETWORK_ADMIN
	},
	service = MVCActionCommand.class
)
public class EditSocialMediaNetworkMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(EditSocialMediaNetworkMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(SocialMediaNetwork.class.getName(), actionRequest);

		// Get parameters from the request.

		long socialMediaNetworkId = ParamUtil.getLong(actionRequest, "socialMediaNetworkId");

		String name = ParamUtil.getString(actionRequest, "name");
		long logoId = ParamUtil.getLong(actionRequest, "logoId");
		String baseURL = ParamUtil.getString(actionRequest, "baseURL");
			
		try {
			// Call the service to update the socialMediaNetwork
			_socialMediaNetworkService.updateSocialMediaNetwork(
				socialMediaNetworkId, name, logoId, baseURL, serviceContext);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (SocialMediaNetworkValidationException ove) {
			log.error("Error validating SocialMediaNetwork edit with socialMediaNetworkId " + socialMediaNetworkId, ove);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_SOCIALMEDIANETWORK_ADMIN);
		}
		catch (PortalException pe) {
			log.error("Error editing SocialMediaNetwork with socialMediaNetworkId " + socialMediaNetworkId, pe);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_SOCIALMEDIANETWORK_ADMIN);
		}
	}

	@Reference
	protected SocialMediaNetworkService _socialMediaNetworkService;
}