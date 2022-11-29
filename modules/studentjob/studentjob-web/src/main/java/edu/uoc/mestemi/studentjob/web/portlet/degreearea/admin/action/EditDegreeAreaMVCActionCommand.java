package edu.uoc.mestemi.studentjob.web.portlet.degreearea.admin.action;

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

import edu.uoc.mestemi.studentjob.exception.DegreeAreaValidationException;
import edu.uoc.mestemi.studentjob.model.DegreeArea;
import edu.uoc.mestemi.studentjob.service.DegreeAreaService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for editing degreeAreas.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 *
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREEAREA_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EDIT_DEGREEAREA_ADMIN
	},
	service = MVCActionCommand.class
)
public class EditDegreeAreaMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(EditDegreeAreaMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(DegreeArea.class.getName(), actionRequest);

		// Get parameters from the request.

		long degreeAreaId = ParamUtil.getLong(actionRequest, "degreeAreaId");

		Map<Locale, String> nameMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "name");
			
		try {
			// Call the service to update the degreeArea
			_degreeAreaService.updateDegreeArea(
				degreeAreaId, nameMap, serviceContext);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (DegreeAreaValidationException ove) {
			log.error("Error validating DegreeArea edit with degreeAreaId " + degreeAreaId + " - Message: " + ove.getMessage());
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_DEGREEAREA_ADMIN);
		}
		catch (PortalException pe) {
			log.error("Error editing DegreeArea with degreeAreaId " + degreeAreaId + " - Message: " + pe.getMessage());
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_DEGREEAREA_ADMIN);
		}
	}

	@Reference
	protected DegreeAreaService _degreeAreaService;
}