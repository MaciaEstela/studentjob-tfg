package edu.uoc.mestemi.studentjob.web.portlet.degreearea.admin.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.model.DegreeArea;
import edu.uoc.mestemi.studentjob.service.DegreeAreaService;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

/**
 * MVC command for showing the degreeAreas list.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREEAREA_ADMIN, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.LIST_DEGREEAREA_ADMIN
	}, 
	service = MVCRenderCommand.class
)
public class ViewDegreeAreasMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		// Add degreeArea list related attributes.
		addDegreeAreaListAttributes(renderRequest);

		// Add Clay management toolbar related attributes.
		addManagementToolbarAttributes(renderRequest, renderResponse);
		
		return "/degreeArea/admin/view.jsp";
	}

	/**
	 * Adds assigment list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addDegreeAreaListAttributes(RenderRequest renderRequest) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Resolve start and end for the search.

		int currentPage = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
			SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
			SearchContainer.DEFAULT_DELTA);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		String orderByCol =
			ParamUtil.getString(renderRequest, "orderByCol", "name");
		String orderByType =
			ParamUtil.getString(renderRequest, "orderByType", "asc");

		// Create comparator

		OrderByComparator<DegreeArea> comparator =
			OrderByComparatorFactoryUtil.create(
				"DegreeArea", orderByCol, !("asc").equals(orderByType));

		String keywords = ParamUtil.getString(renderRequest, "keywords");

		// Call the service to get the list of degreeAreas.
		List<DegreeArea> degreeAreas =_degreeAreaService.getDegreeAreasByKeywords(
				themeDisplay.getScopeGroupId(), keywords, start, end,
				comparator);
		
		// Set request attributes.
		renderRequest.setAttribute("degreeAreas", degreeAreas);
		renderRequest.setAttribute(
			"degreeAreaCount", _degreeAreaService.getDegreeAreasCountByKeywords(
				themeDisplay.getScopeGroupId(), keywords));
	}

	/**
	 * Adds Clay management toolbar context object to the request.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addManagementToolbarAttributes(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		LiferayPortletRequest liferayPortletRequest =
			_portal.getLiferayPortletRequest(renderRequest);

		LiferayPortletResponse liferayPortletResponse =
			_portal.getLiferayPortletResponse(renderResponse);

		DegreeAreasManagementToolbarDisplayContext degreeAreasManagementToolbarDisplayContext =
			new DegreeAreasManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse,
				_portal.getHttpServletRequest(renderRequest));

		renderRequest.setAttribute(
			"degreeAreasManagementToolbarDisplayContext",
			degreeAreasManagementToolbarDisplayContext);

	}

	@Reference
	private Portal _portal;
	
	@Reference
	protected DegreeAreaService _degreeAreaService;
	
	@Reference
	protected DegreeService _degreeService;
}
