package edu.uoc.mestemi.studentjob.web.portlet.admin.socialmedianetwork.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for deleting socialMediaNetworks.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_SOCIALMEDIANETWORK_ADMIN,
		"mvc.command.name=" + MVCCommandNames.DELETE_SOCIALMEDIANETWORK_ADMIN
	},
	service = MVCActionCommand.class
)
public class DeleteSocialMediaNetworkMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(DeleteSocialMediaNetworkMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		// Get socialMediaNetwork id from request.
		long socialMediaNetworkId = ParamUtil.getLong(actionRequest, "socialMediaNetworkId");

		try {
			// Call service to delete the socialMediaNetwork.
			_socialMediaNetworkService.deleteSocialMediaNetwork(socialMediaNetworkId);
		}
		catch (PortalException pe) {
			log.error("Error deleting socialMediaNetwork with socialMediaNetworkId " + socialMediaNetworkId, pe);
		}
	}

	@Reference
	protected SocialMediaNetworkService _socialMediaNetworkService;
}