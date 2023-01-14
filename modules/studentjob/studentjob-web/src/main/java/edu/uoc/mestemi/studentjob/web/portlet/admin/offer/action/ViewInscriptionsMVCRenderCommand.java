package edu.uoc.mestemi.studentjob.web.portlet.admin.offer.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.dto.StudentProfileDTO;
import edu.uoc.mestemi.studentjob.exception.NoSuchOfferException;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.service.StudentProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferServiceUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.portlet.util.DTOUtil;

/**
 * MVC Command for showing edit offer view.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_ADMIN,
		"mvc.command.name=" + MVCCommandNames.VIEW_INSCRIPTIONS
	}, 
	service = MVCRenderCommand.class
)
public class ViewInscriptionsMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewInscriptionsMVCRenderCommand.class);
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		
		Offer offer = null;

		long offerId = ParamUtil.getLong(renderRequest, "offerId", 0);
		
		if (offerId > 0) {
			try {
				// Call the service to get the offer for editing.
				offer = offerService.getOffer(offerId);
			}
			catch (NoSuchOfferException nsoe) {
				log.error("Can't find data for Offer with offerId " + offerId + " - Message: " + nsoe.getMessage());
			}
			catch (PortalException pe) {
				log.error("Error on rendering data for Offer with offerId " + offerId + " - Message: " + pe.getMessage());
			}
		}
		
		if (offer == null || offer.getUserId() != userId && !themeDisplay.getPermissionChecker().isOmniadmin()) {
			PortletResponse portletResponse = (PortletResponse) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);
			LiferayPortletResponse liferayPortletResponse = PortalUtil.getLiferayPortletResponse(portletResponse);
			LiferayPortletURL renderUrl = liferayPortletResponse.createLiferayPortletURL(themeDisplay.getPlid(), StudentjobPortletKeys.STUDENTJOB_OFFER_ADMIN, PortletRequest.RENDER_PHASE);
			return renderUrl.toString();
		}
		
		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		long groupId = themeDisplay.getScopeGroupId();
		portletDisplay.setShowBackIcon(true);

		List<UserEnrollOffer> userEnrollOffers = UserEnrollOfferServiceUtil.getUserEnrollOffers(groupId, offerId);
		List<StudentProfileDTO> studentProfilesDTO = new ArrayList<>();
		
		for (UserEnrollOffer userEnrollOffer : userEnrollOffers) {
			StudentProfile studentProfile = StudentProfileLocalServiceUtil.getStudentProfileByGroupIdAndUserId(
					groupId, userEnrollOffer.getUserId()); 
			
			try {
				String portletURL = PortletURLBuilder.createRenderURL(
						renderResponse
					).setMVCRenderCommandName(
						MVCCommandNames.VIEW_STUDENTPROFILE_USER
					).setParameter(
						"studentProfileId", studentProfile.getStudentProfileId()
					).buildString();
				
				studentProfilesDTO.add(DTOUtil.getStudentProfileDTOByStudentProfile(
						studentProfile, themeDisplay, portletURL));
				
			} catch (PortalException e) {
				log.error("Cant transform StudentProfile with id " + studentProfile.getStudentProfileId() + 
						" to a StudentProfileDTO Object", e);
			}
		}
		
		String redirect = renderRequest.getRenderParameters().getValue("redirect");

		portletDisplay.setURLBack(redirect);
		renderRequest.setAttribute("offerTitle", offer.getTitle(themeDisplay.getLocale()));
		renderRequest.setAttribute("studentProfilesDTO", studentProfilesDTO);
		
		return "/offer/admin/list_inscriptions.jsp";
	}

	@Reference
	private OfferService offerService;
	
	@Reference
	private RegionService regionService;
	
	@Reference
	private CountryService countryService;
	
	@Reference
	private DegreeService degreeService;
	
}