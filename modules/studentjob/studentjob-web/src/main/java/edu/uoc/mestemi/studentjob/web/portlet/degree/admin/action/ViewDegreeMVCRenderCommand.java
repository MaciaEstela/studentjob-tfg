package edu.uoc.mestemi.studentjob.web.portlet.degree.admin.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.math.BigInteger;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.service.DegreeLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

/**
 * MVC command for showing the degrees list.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREE_ADMIN, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.LIST_DEGREE_ADMIN
	}, 
	service = MVCRenderCommand.class
)
public class ViewDegreeMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		// Add degree list related attributes.
		addDegreeListAttributes(renderRequest);

		// Add Clay management toolbar related attributes.
		addManagementToolbarAttributes(renderRequest, renderResponse);
		
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
		String instance=httpRequest.getParameter("degreeAreaId");
		System.out.println("instance es "+ instance);
		
//		List<Object[]> degrees = DegreeLocalServiceUtil.getDegreesByDegreeAreaId("1");
//		System.out.println(degrees.size());
//		
//		for (Object[] objects : degrees) {
//			System.out.println(objects.toString());
//			int studentId = (int)objects[0];
//		}
		
//		_degreeService.getDegreesByDegreeAreaId(1);
		
		return "/degree/admin/view.jsp";
	}

	/**
	 * Adds assigment list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addDegreeListAttributes(RenderRequest renderRequest) {

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

		OrderByComparator<Degree> comparator =
			OrderByComparatorFactoryUtil.create(
				"Degree", orderByCol, !("asc").equals(orderByType));

		String keywords = ParamUtil.getString(renderRequest, "keywords");

		// Call the service to get the list of degrees.
		List<Degree> degrees =_degreeService.getDegreesByKeywords(
				themeDisplay.getScopeGroupId(), keywords, start, end,
				comparator);
		
		// Set request attributes.
		renderRequest.setAttribute("degrees", degrees);
		renderRequest.setAttribute(
			"degreeCount", _degreeService.getDegreesCountByKeywords(
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

		DegreesManagementToolbarDisplayContext degreesManagementToolbarDisplayContext =
			new DegreesManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse,
				_portal.getHttpServletRequest(renderRequest));

		renderRequest.setAttribute(
			"degreesManagementToolbarDisplayContext",
			degreesManagementToolbarDisplayContext);

	}

	@Reference
	private Portal _portal;
	
	@Reference
	protected DegreeService _degreeService;
}
