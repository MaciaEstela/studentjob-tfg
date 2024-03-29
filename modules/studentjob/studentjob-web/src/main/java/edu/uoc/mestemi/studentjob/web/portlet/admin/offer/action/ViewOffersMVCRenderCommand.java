package edu.uoc.mestemi.studentjob.web.portlet.admin.offer.action;

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
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.CompanyProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.DegreeAreaService;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

/**
 * MVC command for showing the offers list.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_ADMIN, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.LIST_OFFER_ADMIN
	}, 
	service = MVCRenderCommand.class
)
public class ViewOffersMVCRenderCommand implements MVCRenderCommand {
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {
		
		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		boolean activeCompany = true;
		
		try {
			CompanyProfile companyProfile = CompanyProfileLocalServiceUtil.getCompanyProfileByGroupIdAndUserId(groupId, userId);
			if (!companyProfile.isActive())
				activeCompany = false;
		} catch (Exception e) {
			activeCompany = false;
		}
		
		renderRequest.setAttribute("activeCompany", activeCompany);
		
		if (!activeCompany) {
			return "/offer/admin/view.jsp";
		}
		
		// Add offer list related attributes.
		addOfferListAttributes(renderRequest);

		// Add Clay management toolbar related attributes.
		addManagementToolbarAttributes(renderRequest, renderResponse);
		
		return "/offer/admin/view.jsp";
	}

	/**
	 * Adds assigment list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addOfferListAttributes(RenderRequest renderRequest) {

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

		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		
		String orderByCol =
			ParamUtil.getString(renderRequest, "orderByCol", "title");
		String orderByType =
			ParamUtil.getString(renderRequest, "orderByType", "asc");
		
		int workflowStatus =
				ParamUtil.getInteger(renderRequest, "filterByStatus", WorkflowConstants.STATUS_APPROVED);
		
		// Create comparator

		OrderByComparator<Offer> comparator =
			OrderByComparatorFactoryUtil.create(
				"Offer", orderByCol, !("asc").equals(orderByType));

		String keywords = ParamUtil.getString(renderRequest, "keywords");

		// Call the service to get the list of offers.
		List<Offer> offers =offerService.getOffersByKeywords(
				groupId, userId, keywords, workflowStatus, start, end,
				comparator);
		
		// Set request attributes.
		renderRequest.setAttribute("offers", offers);
		renderRequest.setAttribute(
			"offerCount", offerService.getOffersCountByKeywords(
				groupId, userId, keywords, workflowStatus));
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
			portal.getLiferayPortletRequest(renderRequest);

		LiferayPortletResponse liferayPortletResponse =
			portal.getLiferayPortletResponse(renderResponse);

		OffersManagementToolbarDisplayContext offersManagementToolbarDisplayContext =
			new OffersManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse,
				portal.getHttpServletRequest(renderRequest));

		renderRequest.setAttribute(
			"offersManagementToolbarDisplayContext",
			offersManagementToolbarDisplayContext);

	}

	@Reference
	protected OfferService offerService;

	@Reference
	private Portal portal;
	
	@Reference
	protected DegreeAreaService degreeAreaService;
	
	@Reference
	protected DegreeService degreeService;
}
