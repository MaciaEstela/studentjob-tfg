package edu.uoc.mestemi.studentjob.web.portlet.admin.degreearea.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.DegreeAreaValidationException;
import edu.uoc.mestemi.studentjob.service.DegreeAreaService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for deleting degreeAreas.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREEAREA_ADMIN,
		"mvc.command.name=" + MVCCommandNames.DELETE_DEGREEAREA_ADMIN
	},
	service = MVCActionCommand.class
)
public class DeleteDegreeAreaMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(DeleteDegreeAreaMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		// Get degreeArea id from request.
		long degreeAreaId = ParamUtil.getLong(actionRequest, "degreeAreaId");

		try {
			// Call service to delete the degreeArea.
			degreeAreaService.deleteDegreeAreaWithValidation(degreeAreaId);
		} catch (DegreeAreaValidationException dve) {
			dve.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));
			log.error("Error deleting degreeArea with degreeAreaId " + degreeAreaId, dve);
		} catch (PortalException pe) {
			log.error("Error deleting degreeArea with degreeAreaId " + degreeAreaId, pe);
		}
	}

	@Reference
	protected DegreeAreaService degreeAreaService;
}