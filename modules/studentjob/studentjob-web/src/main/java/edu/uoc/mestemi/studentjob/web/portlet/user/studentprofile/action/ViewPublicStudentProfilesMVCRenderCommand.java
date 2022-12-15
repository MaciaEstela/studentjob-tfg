package edu.uoc.mestemi.studentjob.web.portlet.user.studentprofile.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.dto.OfferDTO;
import edu.uoc.mestemi.studentjob.web.util.StudentJobUtil;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.DegreeAreaService;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobConstants;

/**
 * MVC command for showing the offers list.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_VIEW_COMPANYPROFILE_USER, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.LIST_COMPANYPROFILE_PUBLIC
	}, 
	service = MVCRenderCommand.class
)
public class ViewPublicStudentProfilesMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewPublicStudentProfilesMVCRenderCommand.class);

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

		List<Region> regions = null;
		List<Degree> degrees = null;
		
		try {
			regions = StudentJobUtil.getRegionsByCountryA3(companyId, "ESP", true);
		} catch (PortalException e) {
			log.error("Error on loading Regions  - Message: " + e.getMessage());
		}

		degrees = _degreeService.getDegreesByGroupId(groupId);
		
		renderRequest.setAttribute("regions", regions);
		renderRequest.setAttribute("preferences", StudentjobConstants.JOB_PREFERENCE);
		renderRequest.setAttribute("degrees", degrees);
		
//		 <portlet:renderURL var="editOfferURL">
//			<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.EDIT_OFFER_ADMIN %>" />
//			<portlet:param name="redirect" value="${currentURL}" />
//			<portlet:param name="offerId" value="${entry.offerId}" />
//		 </portlet:renderURL>
				
		return "/offer/public/list.jsp";
	}

	/**
	 * Adds assigment list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addOfferListAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
		String orderByColModified =
			ParamUtil.getString(renderRequest, "orderByCol", "modifiedDate");
		
		String orderByColCreated =
				ParamUtil.getString(renderRequest, "orderByCol", "createDate");
		
		String orderByType =
			ParamUtil.getString(renderRequest, "orderByType", "asc");

		// Create comparator

		OrderByComparator<Offer> comparator =
			OrderByComparatorFactoryUtil.create(
				"Offer", orderByColModified, !("asc").equals(orderByType));

		String keywords = ParamUtil.getString(renderRequest, "keywords");

		// Call the service to get the list of offers.
//		List<Offer> offers =_offerService.getOffersByKeywords(
//				themeDisplay.getScopeGroupId(), keywords, 0, StudentjobConstants.OFFERS_OFFSET,
//				comparator);
		
		List<Offer> offers =_offerService.getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(
				themeDisplay.getScopeGroupId(), "", "", 0, 0, 0, 0, 
				StudentjobConstants.OFFERS_OFFSET, comparator);
		
		Locale locale = themeDisplay.getLocale();
		List<OfferDTO> offersDTO = new ArrayList<>();
		
		for (Offer offer : offers) {
			try {
				String portletURL = PortletURLBuilder.createRenderURL(
						renderResponse
					).setMVCRenderCommandName(
						MVCCommandNames.VIEW_DETAIL_PUBLIC
					).setParameter(
						"offerId", offer.getOfferId()
					).buildString();
				offersDTO.add(StudentJobUtil.getOfferDTOByOffer(offer, themeDisplay, portletURL));
			} catch (PortalException e) {
				log.error("Cant transform Offer with id " + offer.getOfferId() + " to a OfferDTO Object", e);
			}
		}
		renderRequest.setAttribute("offersDTO", offersDTO);
		
		// Get newest offer id to avoid duplicated results on pagination
		long newestOfferId = 0;
		OrderByComparator<Offer> comparatorCreated =
				OrderByComparatorFactoryUtil.create(
					"Offer", orderByColCreated, !("asc").equals(orderByType));
		
		List<Offer> offersCreated =_offerService.getOffersByKeywords(
				themeDisplay.getScopeGroupId(), keywords, 0, 1,
				comparatorCreated);
		
		if (!offersCreated.isEmpty()) {
			newestOfferId = offersCreated.get(0).getOfferId();
		}
		
		renderRequest.setAttribute("newestOfferId", newestOfferId);
		
		// Set request attributes.
		renderRequest.setAttribute("offers", offers);
		renderRequest.setAttribute(
			"offerCount", _offerService.getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
				themeDisplay.getScopeGroupId(), "", "", 0, 0, 0));
	}

	@Reference
	protected OfferService _offerService;

	@Reference
	private Portal _portal;
	
	@Reference
	protected DegreeAreaService _degreeAreaService;
	
	@Reference
	protected DegreeService _degreeService;
}
