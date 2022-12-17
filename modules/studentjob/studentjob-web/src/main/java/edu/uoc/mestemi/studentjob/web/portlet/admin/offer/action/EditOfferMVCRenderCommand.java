package edu.uoc.mestemi.studentjob.web.portlet.admin.offer.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
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

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.exception.NoSuchOfferException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.util.CountryA3Constants;
import edu.uoc.mestemi.studentjob.util.ProvinceUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Command for showing edit offer view.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EDIT_OFFER_ADMIN
	}, 
	service = MVCRenderCommand.class
)
public class EditOfferMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(EditOfferMVCRenderCommand.class);
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		Offer offer = null;

		long offerId = ParamUtil.getLong(renderRequest, "offerId", 0);

		if (offerId > 0) {
			try {
				// Call the service to get the offer for editing.
				offer = _offerService.getOffer(offerId);
			}
			catch (NoSuchOfferException nsoe) {
				log.error("Can't find data for Offer with offerId " + offerId + " - Message: " + nsoe.getMessage());
			}
			catch (PortalException pe) {
				log.error("Error on rendering data for Offer with offerId " + offerId + " - Message: " + pe.getMessage());
			}
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		portletDisplay.setShowBackIcon(true);
		
		String redirect = renderRequest.getRenderParameters().getValue("redirect");

		portletDisplay.setURLBack(redirect);

		List<Region> regions = ProvinceUtil.getRegionsByCountryA3(companyId, CountryA3Constants.SPAIN, true);
		List<Degree> degrees = _degreeService.getDegreesByGroupId(groupId);
		List<Long> currentOfferDegreesIds = _offerService.getDegreesIdsByOfferId(offerId);
		
		// Set offer to the request attributes.
		renderRequest.setAttribute("regions", regions);
		renderRequest.setAttribute("preferences", StudentjobConstants.JOB_PREFERENCE);
		renderRequest.setAttribute("degrees", degrees);
		renderRequest.setAttribute("offer", offer);
		renderRequest.setAttribute("currentOfferDegreesIds", currentOfferDegreesIds);
		renderRequest.setAttribute("offerClass", Offer.class);
		renderRequest.setAttribute("locale", themeDisplay.getLocale());
		
		return "/offer/admin/edit_offer.jsp";
	}

	@Reference
	private OfferService _offerService;
	
	@Reference
	private RegionService _regionService;
	
	@Reference
	private CountryService _countryService;
	
	@Reference
	private DegreeService _degreeService;
}