package edu.uoc.mestemi.studentjob.web.portlet.user.offer.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.portlet.util.DTOUtil;
import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.dto.OfferDTO;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.service.StudentProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.util.CountryA3Constants;
import edu.uoc.mestemi.studentjob.util.ProvinceUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

/**
 * MVC command for showing the offers list.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_USER, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.LIST_OFFER_USER
	}, 
	service = MVCRenderCommand.class
)
public class ViewPublicOffersMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewPublicOffersMVCRenderCommand.class);

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		// Add offer list related attributes.
		addOfferListAttributes(renderRequest, renderResponse);

		List<Region> regions = ProvinceUtil.getRegionsByCountryA3(companyId, CountryA3Constants.SPAIN, true);
		List<Degree> degrees = _degreeService.getDegreesByGroupId(groupId);
		
		renderRequest.setAttribute("regions", regions);
		renderRequest.setAttribute("preferences", StudentjobConstants.JOB_PREFERENCE);
		renderRequest.setAttribute("degrees", degrees);
		
		return "/offer/user/list.jsp";
	}

	/**
	 * Adds assigment list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addOfferListAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
		long groupId = themeDisplay.getScopeGroupId();
		
		String orderByColModified =
			ParamUtil.getString(renderRequest, StudentjobConstants.ORDER_BY_COL, 
					StudentjobConstants.ORDER_MODIFIED_DATE);
		
		String orderByType =
			ParamUtil.getString(renderRequest, StudentjobConstants.ORDER_BY_TYPE, StudentjobConstants.ORDER_ASC);

		// Create comparator

		OrderByComparator<Offer> comparator =
			OrderByComparatorFactoryUtil.create(
				"Offer", orderByColModified, !(StudentjobConstants.ORDER_ASC).equals(orderByType));

		String keywords = ParamUtil.getString(renderRequest, "keywords");

		if (keywords.isEmpty()) {
			// Get HTTP param
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			keywords = httpReq.getParameter("keywords");
		}
		
		List<Offer> offers =_offerService.getOffersByKeywords(
				groupId, 0, keywords, WorkflowConstants.STATUS_APPROVED, 0, StudentjobConstants.OFFERS_OFFSET,
				comparator);
		
		List<OfferDTO> offersDTO = new ArrayList<>();
		
		for (Offer offer : offers) {
			try {
				String portletURL = PortletURLBuilder.createRenderURL(
						renderResponse
					).setMVCRenderCommandName(
						MVCCommandNames.VIEW_DETAIL_USER
					).setParameter(
						"offerId", offer.getOfferId()
					).buildString();
				offersDTO.add(DTOUtil.getOfferDTOByOffer(offer, themeDisplay, portletURL));
			} catch (PortalException e) {
				log.error("Cant transform Offer with id " + offer.getOfferId() + " to a OfferDTO Object", e);
			}
		}
		renderRequest.setAttribute("offersDTO", offersDTO);
		
		// Get newest offer id to avoid duplicated results on pagination
		long newestOfferId = _offerService.getNewestOfferId();
		renderRequest.setAttribute("newestOfferId", newestOfferId);
		
		// Set request attributes.
		renderRequest.setAttribute("offers", offers);
		
		renderRequest.setAttribute(
			"offerCount", _offerService.getOffersCountByKeywords(groupId, 0, keywords, WorkflowConstants.STATUS_APPROVED));
	}

	@Reference
	protected OfferService _offerService;

	@Reference
	protected DegreeService _degreeService;
}
