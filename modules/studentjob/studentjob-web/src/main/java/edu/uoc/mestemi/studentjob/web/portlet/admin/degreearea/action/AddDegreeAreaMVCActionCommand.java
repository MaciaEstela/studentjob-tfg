package edu.uoc.mestemi.studentjob.web.portlet.admin.degreearea.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.WebKeys;

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
 * MVC Action Command for adding degreeAreas.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREEAREA_ADMIN,
		"mvc.command.name=" + MVCCommandNames.ADD_DEGREEAREA_ADMIN
	},
	service = MVCActionCommand.class
)
public class AddDegreeAreaMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(AddDegreeAreaMVCActionCommand.class);

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			DegreeArea.class.getName(), actionRequest);

		// Use LocalizationUtil to get a localized parameter.

		Map<Locale, String> nameMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "name");
		
		try {
			// Call the service to add a a new degreeArea.
			_degreeAreaService.addDegreeArea(
				themeDisplay.getScopeGroupId(), nameMap, serviceContext);
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (DegreeAreaValidationException ove) {
			log.error("Error validating new DegreeArea", ove);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_DEGREEAREA_ADMIN);
		}
		catch (PortalException pe) {
			log.error("Error creating a new DegreeArea", pe);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_DEGREEAREA_ADMIN);
		}
	}

	@Reference
	protected DegreeAreaService _degreeAreaService;

}