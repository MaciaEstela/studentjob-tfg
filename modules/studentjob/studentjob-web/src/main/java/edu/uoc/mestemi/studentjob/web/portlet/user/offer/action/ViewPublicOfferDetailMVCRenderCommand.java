package edu.uoc.mestemi.studentjob.web.portlet.user.offer.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.dto.OfferDTO;
import edu.uoc.mestemi.studentjob.exception.NoSuchOfferException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.service.CompanyProfileLocalService;
import edu.uoc.mestemi.studentjob.service.CompanyProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferLocalService;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferLocalServiceUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.portlet.util.DTOUtil;

/**
 * MVC Command for viewing offer details
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_USER,
		"mvc.command.name=" + MVCCommandNames.VIEW_DETAIL_USER
	}, 
	service = MVCRenderCommand.class
)
public class ViewPublicOfferDetailMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewPublicOfferDetailMVCRenderCommand.class);
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {
		
		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Offer offer = null;

		long offerId = ParamUtil.getLong(renderRequest, "offerId", 0);
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		
		if (offerId > 0) {
			try {
				// Call the service to get the offer for show
				offer = _offerService.getOffer(offerId);
			}
			catch (NoSuchOfferException nsoe) {
				log.error("Can't find data for Offer with offerId " + offerId, nsoe);
			}
			catch (PortalException pe) {
				log.error("Error on rendering data for Offer with offerId " + offerId, pe);
			}
		}
		
		if (offer == null) {
			return ""; // TODO: Return 404
		}

		
		OfferDTO offerDTO = null;
		String province = StringPool.BLANK;
		
		try {
			province = RegionLocalServiceUtil.getRegion(offer.getRegionId()).getName();	
		} catch (PortalException e) {
			log.error("Error on get Region for regionID " + offer.getRegionId(), e);
		}
		
		try {
			offerDTO = DTOUtil.getOfferDTOByOffer(offer, themeDisplay, StringPool.BLANK);
		} catch (PortalException e) {
			log.error("Error on get OfferDTO for offerID " + offer.getOfferId(), e);
		}
		
		UserEnrollOffer userEnrollOffer = UserEnrollOfferLocalServiceUtil.getUserEnrollOffer(groupId, userId, offerId);
		renderRequest.setAttribute("enrolled", userEnrollOffer != null);
		
		List<Degree> currentOfferDegrees = _offerService.getDegreesByOfferId(offer.getOfferId());
		
		long companyUserId = offer.getUserId();
		long companyProfileId = CompanyProfileLocalServiceUtil.getCompanyProfileByGroupIdAndUserId(
				groupId, companyUserId).getCompanyProfileId();
		
		// Set offer to the request attributes.
		renderRequest.setAttribute("offer", offer);
		renderRequest.setAttribute("companyProfileId", companyProfileId);
		renderRequest.setAttribute("offerDTO", offerDTO);
		renderRequest.setAttribute("province", province);
		renderRequest.setAttribute("currentOfferDegrees", currentOfferDegrees);
		
		return "/offer/user/detail.jsp";
	}

	@Reference
	private OfferService _offerService;
}