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
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.dto.OfferDTO;
import edu.uoc.mestemi.studentjob.web.util.StudentJobUtil;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.DegreeAreaService;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.service.StudentProfileService;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferService;
import edu.uoc.mestemi.studentjob.util.TemplateProcessor;
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
		
		if (cmd.equals(MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND_GET_OFFERS)) {
			
			String degree = ParamUtil.getString(resourceRequest, "degree", StringPool.BLANK);
			String preference = ParamUtil.getString(resourceRequest, "preference", StringPool.BLANK);
			String region = ParamUtil.getString(resourceRequest, "region", StringPool.BLANK);
			String keywords = ParamUtil.getString(resourceRequest, "keywords", StringPool.BLANK);
			long newestOfferId = ParamUtil.getLong(resourceRequest, "newestOfferId", 0);
			
			System.out.println("newestOfferId es " + newestOfferId);
			long regionId = 0;
			long degreeId = 0;
			
			if (!region.trim().isEmpty()) {
				regionId = StudentJobUtil.getRegionId(
						StudentJobUtil.getCountryIdByCode(companyId, "ESP"), region);
			}
			
			if (!degree.trim().isEmpty()) {
				degreeId = Long.valueOf(degree);
			}
			
			String orderByCol = "modifiedDate";
			String orderByType = "asc";
			
			OrderByComparator<Offer> comparator =
					OrderByComparatorFactoryUtil.create(
						"Offer", orderByCol, !("asc").equals(orderByType));
			
			int start = ParamUtil.getInteger(resourceRequest, "start", 0);
			
			System.out.println("Entro get offers");
			
			System.out.println("degree " + degree + " - preference " + preference + " - region " + region);
			System.out.println("CMD es "+ cmd + " cmd length " + cmd.length());
			System.out.println("start eas "+ start);

			List<Offer> offers =_offerService.getOffersByKeywordsAndPreferenceAndRegionIdAndDegreeId(
					themeDisplay.getScopeGroupId(), keywords, preference, regionId, degreeId, newestOfferId, start, 
					start + StudentjobConstants.OFFERS_OFFSET, comparator);
			
			StringBuilder offersHTML = new StringBuilder(StringPool.BLANK);
			PortletContext portletContext = resourceRequest.getPortletContext();
			
			System.out.println("offers length " + offers.size());
			for (Offer offer : offers) {
				try {
					Map<String,Object> params = new HashMap<>();
					
					String portletURL = PortletURLBuilder.createRenderURL(
							resourceResponse
						).setMVCRenderCommandName(
							MVCCommandNames.VIEW_DETAIL_PUBLIC
						).setParameter(
							"offerId", offer.getOfferId()
						).buildString();
					
					OfferDTO offerDTO = StudentJobUtil.getOfferDTOByOffer(offer, themeDisplay, portletURL); 
					
					TemplateProcessor templateProcessor = new TemplateProcessor(
							portletContext.getResource("/offer/public/card.jspf").getPath()
						);
					params.put("offer", offerDTO);
					offersHTML.append(templateProcessor.process(params, TemplateConstants.LANG_TYPE_FTL));
					
				} catch (PortalException e) {
					log.error("Cant transform Offer with id " + offer.getOfferId() + " to a OfferDTO Object", e);
				}
			}
			
			resourceResponse.setContentType("text/html");
			resourceResponse.setCharacterEncoding("UTF-8"); 
			resourceResponse.getWriter().write(offersHTML.toString());
			
		} else if (cmd.equals(MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND_AUX_DATA)) {
			
			String degree = ParamUtil.getString(resourceRequest, "degree", StringPool.BLANK);
			String preference = ParamUtil.getString(resourceRequest, "preference", StringPool.BLANK);
			String region = ParamUtil.getString(resourceRequest, "region", StringPool.BLANK);
			String keywords = ParamUtil.getString(resourceRequest, "keywords", StringPool.BLANK);
			long newestOfferId = ParamUtil.getLong(resourceRequest, "newestOfferId", 0);
			
			System.out.println("newestOfferId es " + newestOfferId);
			long regionId = 0;
			long degreeId = 0;
			
			if (!region.trim().isEmpty()) {
				regionId = StudentJobUtil.getRegionId(
						StudentJobUtil.getCountryIdByCode(companyId, "ESP"), region);
			}
			
			if (!degree.trim().isEmpty()) {
				degreeId = Long.valueOf(degree);
			}
			
			String orderByCol = "modifiedDate";
			String orderByType = "asc";
			
			orderByCol = "createDate";
			
			OrderByComparator<Offer> comparatorCreate =
					OrderByComparatorFactoryUtil.create(
						"Offer", orderByCol, !("asc").equals(orderByType));
			
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
	
	@Reference
	protected OfferService _offerService;

	@Reference
	protected DegreeAreaService _degreeAreaService;
	
	@Reference
	protected DegreeService _degreeService;
	
	@Reference
	protected StudentProfileService _studentProfileService;
	
	@Reference
	protected UserEnrollOfferService _userEnrollOffer;
}
