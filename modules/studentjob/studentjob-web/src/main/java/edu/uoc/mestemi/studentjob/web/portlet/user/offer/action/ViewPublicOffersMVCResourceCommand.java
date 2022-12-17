package edu.uoc.mestemi.studentjob.web.portlet.user.offer.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.portlet.util.DTOUtil;
import edu.uoc.mestemi.studentjob.web.portlet.util.TemplateProcessor;
import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.dto.OfferDTO;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferService;
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
		"mvc.command.name=" + MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND
	}, 
	service = MVCResourceCommand.class
)
public class ViewPublicOffersMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewPublicOffersMVCRenderCommand.class);
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		long userId = themeDisplay.getUserId();
		
		String cmd = ParamUtil.getString(resourceRequest, StudentjobConstants.CMD);
		
		if (cmd.equals(MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND_GET_OFFERS) || 
				cmd.equals(MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND_AUX_DATA)) {
			
			String degree = ParamUtil.getString(resourceRequest, "degree", StringPool.BLANK);
			String preference = ParamUtil.getString(resourceRequest, "preference", StringPool.BLANK);
			String region = ParamUtil.getString(resourceRequest, "region", StringPool.BLANK);
			String keywords = ParamUtil.getString(resourceRequest, "keywords", StringPool.BLANK);
			long newestOfferId = ParamUtil.getLong(resourceRequest, "newestOfferId", 0);
			
			long regionId = 0;
			long degreeId = 0;
			
			if (!region.trim().isEmpty()) {
				regionId = ProvinceUtil.getRegionId(
						ProvinceUtil.getCountryIdByCode(companyId, CountryA3Constants.SPAIN), region);
			}
			
			if (!degree.trim().isEmpty()) {
				degreeId = Long.valueOf(degree);
			}
			
			String orderByCol = StudentjobConstants.ORDER_MODIFIED_DATE;
			String orderByType = StudentjobConstants.ORDER_ASC;
			
			if (cmd.equals(MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND_GET_OFFERS)) {
				
				OrderByComparator<Offer> comparator =
						OrderByComparatorFactoryUtil.create(
							"Offer", orderByCol, !(StudentjobConstants.ORDER_ASC).equals(orderByType));
				
				int start = ParamUtil.getInteger(resourceRequest, "start", 0);
				
				List<Offer> offers =_offerService.getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(
						themeDisplay.getScopeGroupId(), keywords, preference, regionId, degreeId, newestOfferId, start, 
						start + StudentjobConstants.OFFERS_OFFSET, comparator);
				
				PortletContext portletContext = resourceRequest.getPortletContext();
				
				String offersHTML = getProcessedHTMLOffers(offers, themeDisplay, portletContext, resourceResponse);
				
				resourceResponse.setContentType("text/html");
				resourceResponse.setCharacterEncoding("UTF-8"); 
				resourceResponse.getWriter().write(offersHTML);
				
			} else { // cmd.equals(MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND_AUX_DATA)
				
				orderByCol = StudentjobConstants.ORDER_CREATE_DATE;
				
				OrderByComparator<Offer> comparatorCreate =
						OrderByComparatorFactoryUtil.create(
							"Offer", orderByCol, !(StudentjobConstants.ORDER_ASC).equals(orderByType));
				
				List<Offer> offers =_offerService.getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(
						themeDisplay.getScopeGroupId(), keywords, preference, regionId, degreeId, 0, 0, 1,
						comparatorCreate);
				
				JSONObject dataJson = JSONFactoryUtil.createJSONObject();
				long offerCount = _offerService.getOffersCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
						themeDisplay.getScopeGroupId(), keywords, preference, regionId, degreeId, 0);
				
				if (!offers.isEmpty()) {
					dataJson.put("newestOfferId", String.valueOf(offers.get(0).getOfferId()));
					dataJson.put("offerCount", String.valueOf(offerCount));
					
					resourceResponse.setContentType("application/json");
					resourceResponse.setCharacterEncoding("UTF-8");
					resourceResponse.getWriter().write(dataJson.toString());
				}
			}
			
		} else if (cmd.equals(MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND_ENROLL)) {
			
			long offerId = ParamUtil.getLong(resourceRequest, "offerId", 0);
			
			if (offerId != 0) {
				_userEnrollOffer.addUserEnrollOffer(
						groupId, 
						offerId, 
						userId, 
						ServiceContextFactory.getInstance(resourceRequest)
					);
			}
			
		}
	}
	
	private String getProcessedHTMLOffers(List<Offer> offers, ThemeDisplay themeDisplay, 
			PortletContext portletContext, ResourceResponse resourceResponse) {
		
		StringBuilder offersHTML = new StringBuilder(StringPool.BLANK);
		
		for (Offer offer : offers) {
			offersHTML.append(getProcessedOfferDTOTemplate(offer, 
					themeDisplay, portletContext, resourceResponse));
		}
		
		return offersHTML.toString();
	}
	
	private String getProcessedOfferDTOTemplate(Offer offer, ThemeDisplay themeDisplay, 
			PortletContext portletContext, ResourceResponse resourceResponse) {
		String offerDTOHtml = StringPool.BLANK;
		try {
			Map<String,Object> params = new HashMap<>();
			
			String portletURL = PortletURLBuilder.createRenderURL(
					resourceResponse
				).setMVCRenderCommandName(
					MVCCommandNames.VIEW_DETAIL_USER
				).setParameter(
					"offerId", offer.getOfferId()
				).buildString();
			
			OfferDTO offerDTO = DTOUtil.getOfferDTOByOffer(offer, themeDisplay, portletURL); 
			
			TemplateProcessor templateProcessor = new TemplateProcessor(
					portletContext.getResource("/offer/user/card.jspf").getPath()
				);
			params.put("offer", offerDTO);
			offerDTOHtml = templateProcessor.process(params, TemplateConstants.LANG_TYPE_FTL);
			
		} catch (PortalException | MalformedURLException e) {
			log.error("Cant transform Offer with id " + offer.getOfferId() + " to a OfferDTO Object", e);
		}
		
		return offerDTOHtml;
	}
	
	@Reference
	protected OfferService _offerService;

	@Reference
	protected UserEnrollOfferService _userEnrollOffer;
}
