package edu.uoc.mestemi.studentjob.web.portlet.admin.degree.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
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

import edu.uoc.mestemi.studentjob.exception.NoSuchDegreeException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.DegreeArea;
import edu.uoc.mestemi.studentjob.service.DegreeAreaService;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Command for showing edit degree view.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREE_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EDIT_DEGREE_ADMIN
	}, 
	service = MVCRenderCommand.class
)
public class EditDegreeMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(EditDegreeMVCRenderCommand.class);
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		Degree degree = null;

		long degreeId = ParamUtil.getLong(renderRequest, "degreeId", 0);

		if (degreeId > 0) {
			try {
				// Call the service to get the degree for editing.
				degree = degreeService.getDegree(degreeId);
			}
			catch (NoSuchDegreeException nsoe) {
				log.error("Can't find data for Degree with degreeId " + degreeId, nsoe);
			}
		catch (PortalException pe) {
				log.error("Error on rendering data for Degree with degreeId " + degreeId, pe);
			}
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		
		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		
		String redirect = renderRequest.getRenderParameters().getValue("redirect");

		portletDisplay.setURLBack(redirect);

		List<Long> currentDegreeAreasDegreeIds = degreeService.getDegreeAreasIdsByDegreeId(degreeId);
		List<DegreeArea> degreeAreas = degreeAreaService.getDegreeAreasByGroupId(groupId);
		
		// Set degree to the request attributes.
		renderRequest.setAttribute("degree", degree);
		renderRequest.setAttribute("degreeAreas", degreeAreas);
		renderRequest.setAttribute("degreeClass", Degree.class);
		renderRequest.setAttribute("currentDegreeAreasDegreeIds", currentDegreeAreasDegreeIds);
		renderRequest.setAttribute("locale", themeDisplay.getLocale());
		
		return "/degree/admin/edit_degree.jsp";
	}
	
	@Reference
	private DegreeService degreeService;
	
	@Reference
	private DegreeAreaService degreeAreaService;
}