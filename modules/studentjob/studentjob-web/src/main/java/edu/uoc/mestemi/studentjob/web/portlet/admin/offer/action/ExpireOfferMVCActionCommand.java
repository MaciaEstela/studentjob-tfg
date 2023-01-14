package edu.uoc.mestemi.studentjob.web.portlet.admin.offer.action;

import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for deleting offers.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EXPIRE_OFFER_ADMIN
	},
	service = MVCActionCommand.class
)
public class ExpireOfferMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		// Get offer id from request.
		long offerId = ParamUtil.getLong(actionRequest, "offerId");
		Offer offer = offerService.getOffer(offerId);
		
		if (offer.getUserId() != userId && !themeDisplay.getPermissionChecker().isOmniadmin()) {
			PortletResponse portletResponse = (PortletResponse) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);
			LiferayPortletResponse liferayPortletResponse = PortalUtil.getLiferayPortletResponse(portletResponse);
			LiferayPortletURL renderUrl = liferayPortletResponse.createLiferayPortletURL(themeDisplay.getPlid(), StudentjobPortletKeys.STUDENTJOB_OFFER_ADMIN, PortletRequest.RENDER_PHASE);
			sendRedirect(actionRequest, actionResponse, renderUrl.toString());
		}

		offer = offerService.expireOffer(offerId);
		

	}

	@Reference
	protected OfferService offerService;
}