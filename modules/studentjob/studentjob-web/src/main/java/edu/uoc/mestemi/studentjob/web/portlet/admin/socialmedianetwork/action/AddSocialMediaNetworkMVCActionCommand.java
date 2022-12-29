package edu.uoc.mestemi.studentjob.web.portlet.admin.socialmedianetwork.action;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.Locale;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.exception.SocialMediaNetworkValidationException;
import edu.uoc.mestemi.studentjob.model.SocialMediaNetwork;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkService;
import edu.uoc.mestemi.studentjob.util.DocumentLibraryUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for adding socialMediaNetworks.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_SOCIALMEDIANETWORK_ADMIN,
		"mvc.command.name=" + MVCCommandNames.ADD_SOCIALMEDIANETWORK_ADMIN
	},
	service = MVCActionCommand.class
)
public class AddSocialMediaNetworkMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(AddSocialMediaNetworkMVCActionCommand.class);

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			SocialMediaNetwork.class.getName(), actionRequest);

		String name = ParamUtil.getString(actionRequest, "name");
		String baseURL = ParamUtil.getString(actionRequest, "baseURL");
		
		long logoId = 0;
		
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			File file = uploadRequest.getFile("logo");
			String fileName = uploadRequest.getFileName("logo");
			
			FileEntry curriculum = DocumentLibraryUtil.addFile(actionRequest, 
					StudentjobConstants.SOCIALMEDIANETWORK_IMAGE_FOLDER, file, fileName);
			logoId = curriculum.getFileEntryId();
			
			// Call the service to add a a new socialMediaNetwork.
			_socialMediaNetworkService.addSocialMediaNetwork(
				themeDisplay.getScopeGroupId(), name, logoId, baseURL, serviceContext);
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (SocialMediaNetworkValidationException ove) {
			log.error("Error validating new SocialMediaNetwork", ove);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_SOCIALMEDIANETWORK_ADMIN);
		}
		catch (PortalException pe) {
			log.error("Error creating a new SocialMediaNetwork", pe);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_SOCIALMEDIANETWORK_ADMIN);
		}
	}

	@Reference
	protected SocialMediaNetworkService _socialMediaNetworkService;
}