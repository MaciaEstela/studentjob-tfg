package edu.uoc.mestemi.studentjob.web.portlet.admin.degree.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.DegreeValidationException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for editing degrees.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 *
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREE_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EDIT_DEGREE_ADMIN
	},
	service = MVCActionCommand.class
)
public class EditDegreeMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(EditDegreeMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(Degree.class.getName(), actionRequest);

		// Get parameters from the request.

		long degreeId = ParamUtil.getLong(actionRequest, "degreeId");

		Map<Locale, String> nameMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "name");
		
		long[] degreeAreasId = ParamUtil.getLongValues(actionRequest, "degreeArea");
		List<Long> degreeAreasIdList = Arrays.stream(degreeAreasId).boxed().collect(Collectors.toList());
		
		try {
			// Call the service to update the degree
			_degreeService.updateDegree(
				degreeId, nameMap, degreeAreasIdList, serviceContext);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (DegreeValidationException ove) {
			log.error("Error validating Degree edit with degreeId " + degreeId, ove);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_DEGREE_ADMIN);
		}
		catch (PortalException pe) {
			log.error("Error editing Degree with degreeId " + degreeId, pe);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_DEGREE_ADMIN);
		}
	}

	@Reference
	protected DegreeService _degreeService;
}