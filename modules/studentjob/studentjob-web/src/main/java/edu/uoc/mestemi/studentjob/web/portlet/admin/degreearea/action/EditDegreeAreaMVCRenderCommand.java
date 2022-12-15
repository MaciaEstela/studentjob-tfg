package edu.uoc.mestemi.studentjob.web.portlet.admin.degreearea.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.NoSuchDegreeAreaException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.DegreeArea;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.DegreeAreaService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.util.StudentJobUtil;

/**
 * MVC Command for showing edit degreeArea view.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREEAREA_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EDIT_DEGREEAREA_ADMIN
	}, 
	service = MVCRenderCommand.class
)
public class EditDegreeAreaMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(EditDegreeAreaMVCRenderCommand.class);
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		DegreeArea degreeArea = null;

		long degreeAreaId = ParamUtil.getLong(renderRequest, "degreeAreaId", 0);

		if (degreeAreaId > 0) {
			try {
				// Call the service to get the degreeArea for editing.
				degreeArea = _degreeAreaService.getDegreeArea(degreeAreaId);
			}
			catch (NoSuchDegreeAreaException nsoe) {
				log.error("Can't find data for DegreeArea with degreeAreaId " + degreeAreaId + " - Message: " + nsoe.getMessage());
			}
			catch (PortalException pe) {
				log.error("Error on rendering data for DegreeArea with degreeAreaId " + degreeAreaId + " - Message: " + pe.getMessage());
			}
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		
		String redirect = renderRequest.getRenderParameters().getValue("redirect");

		portletDisplay.setURLBack(redirect);
		
		// Set degreeArea to the request attributes.
		renderRequest.setAttribute("degreeArea", degreeArea);
		renderRequest.setAttribute("degreeAreaClass", DegreeArea.class);
		renderRequest.setAttribute("locale", themeDisplay.getLocale());
		
		return "/degreeArea/admin/edit_degreeArea.jsp";
	}

	@Reference
	private DegreeAreaService _degreeAreaService;
	
	@Reference
	private RegionService _regionService;
	
	@Reference
	private CountryService _countryService;
	
	@Reference
	private DegreeService _degreeService;
}