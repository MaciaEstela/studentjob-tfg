package edu.uoc.mestemi.studentjob.web.portlet.admin.degree.action;

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

import edu.uoc.mestemi.studentjob.exception.DegreeValidationException;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for deleting degrees.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREE_ADMIN,
		"mvc.command.name=" + MVCCommandNames.DELETE_DEGREE_ADMIN
	},
	service = MVCActionCommand.class
)
public class DeleteDegreeMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(DeleteDegreeMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		// Get degree id from request.
		long degreeId = ParamUtil.getLong(actionRequest, "degreeId");

		try {
			// Call service to delete the degree.
			degreeService.deleteDegreeWithValidation(degreeId);
		} catch (DegreeValidationException dve) {
			dve.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));
			log.error("Error deleting degree with degreeId " + degreeId, dve);
		} catch (PortalException pe) {
			log.error("Error deleting degree with degreeId " + degreeId, pe);
		}
	}

	@Reference
	protected DegreeService degreeService;
}