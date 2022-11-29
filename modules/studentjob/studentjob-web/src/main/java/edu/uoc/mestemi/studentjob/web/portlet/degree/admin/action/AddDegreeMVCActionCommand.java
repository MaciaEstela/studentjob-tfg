package edu.uoc.mestemi.studentjob.web.portlet.degree.admin.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

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
 * MVC Action Command for adding degrees.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREE_ADMIN,
		"mvc.command.name=" + MVCCommandNames.ADD_DEGREE_ADMIN
	},
	service = MVCActionCommand.class
)
public class AddDegreeMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(AddDegreeMVCActionCommand.class);

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Degree.class.getName(), actionRequest);

		// Use LocalizationUtil to get a localized parameter.

		Map<Locale, String> nameMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "name");
		
		long[] degreeAreasId = ParamUtil.getLongValues(actionRequest, "degreeArea");
		List<Long> degreeAreasIdList = Arrays.stream(degreeAreasId).boxed().collect(Collectors.toList());
		
		try {
			// Call the service to add a a new degree.
			_degreeService.addDegree(
				themeDisplay.getScopeGroupId(), nameMap, degreeAreasIdList, serviceContext);
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (DegreeValidationException ove) {
			log.error("Error validating new Degree - Message: " + ove.getMessage());
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_DEGREE_ADMIN);
		}
		catch (PortalException pe) {
			log.error("Error creating a new Degree - Message: " + pe.getMessage());
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_DEGREE_ADMIN);
		}
	}

	@Reference
	protected DegreeService _degreeService;
	
	@Reference
	protected RegionService _regionService;

}