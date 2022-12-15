package edu.uoc.mestemi.studentjob.web.portlet.admin.offer.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.OfferValidationException;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.util.StudentJobUtil;

/**
 * MVC Action Command for editing offers.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 *
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EDIT_OFFER_ADMIN
	},
	service = MVCActionCommand.class
)
public class EditOfferMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(EditOfferMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(Offer.class.getName(), actionRequest);

		long companyId = themeDisplay.getCompanyId();
		
		// Get parameters from the request.

		long offerId = ParamUtil.getLong(actionRequest, "offerId");

		Map<Locale, String> titleMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "title");
			
		String regionCode = ParamUtil.getString(actionRequest, "region");
		long regionId = StudentJobUtil.getRegionId(
				StudentJobUtil.getCountryIdByCode(companyId, "ESP"), 
				regionCode);
		
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");

		String preference = ParamUtil.getString(actionRequest, "preference");
		
		long[] degreeIds = ParamUtil.getLongValues(actionRequest, "degree");
		List<Long> degreesList = Arrays.stream(degreeIds).boxed().collect(Collectors.toList());

		try {
			// Call the service to update the offer
			_offerService.updateOffer(
				offerId, regionId, titleMap, descriptionMap, preference, degreesList, serviceContext);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (OfferValidationException ove) {
			log.error("Error validating Offer edit with offerId " + offerId + " - Message: " + ove.getMessage());
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_OFFER_ADMIN);
		}
		catch (PortalException pe) {
			log.error("Error editing Offer with offerId " + offerId + " - Message: " + pe.getMessage());
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_OFFER_ADMIN);
		}
	}

	@Reference
	protected OfferService _offerService;
}