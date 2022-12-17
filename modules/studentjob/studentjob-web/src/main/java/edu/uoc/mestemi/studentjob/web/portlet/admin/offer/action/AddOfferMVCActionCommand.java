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
import edu.uoc.mestemi.studentjob.util.CountryA3Constants;
import edu.uoc.mestemi.studentjob.util.ProvinceUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for adding offers.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_ADMIN,
		"mvc.command.name=" + MVCCommandNames.ADD_OFFER_ADMIN
	},
	service = MVCActionCommand.class
)
public class AddOfferMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(AddOfferMVCActionCommand.class);

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Offer.class.getName(), actionRequest);

		// Use LocalizationUtil to get a localized parameter.

		Map<Locale, String> titleMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "title");
		
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");

		// Get parameters from the request.

		String preference = ParamUtil.getString(actionRequest, "preference");
		
		String regionCode = ParamUtil.getString(actionRequest, "region");
		long countryId = ProvinceUtil.getCountryIdByCode(themeDisplay.getCompanyId(), CountryA3Constants.SPAIN);
		long regionId = ProvinceUtil.getRegionId(countryId, regionCode);
		
		long[] degreesId = ParamUtil.getLongValues(actionRequest, "degree");
		List<Long> degreesIdList = Arrays.stream(degreesId).boxed().collect(Collectors.toList());
		
		try {
			// Call the service to add a a new offer.
			_offerService.addOffer(
				themeDisplay.getScopeGroupId(), regionId, titleMap, descriptionMap, 
					preference, degreesIdList, serviceContext);
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (OfferValidationException ove) {
			log.error("Error validating new Offer", ove);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_OFFER_ADMIN);
		}
		catch (PortalException pe) {
			log.error("Error creating a new Offer", pe);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_OFFER_ADMIN);
		}
	}

	@Reference
	protected OfferService _offerService;
}