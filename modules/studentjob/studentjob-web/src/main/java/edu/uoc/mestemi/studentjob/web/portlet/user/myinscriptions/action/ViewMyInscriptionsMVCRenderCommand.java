package edu.uoc.mestemi.studentjob.web.portlet.user.myinscriptions.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.portlet.util.DTOUtil;
import edu.uoc.mestemi.studentjob.dto.MyInscriptionDTO;
import edu.uoc.mestemi.studentjob.model.UserEnrollOffer;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

/**
 * MVC command for showing the companyProfiles list.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_MYINSCRIPTIONS_USER, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.LIST_MYINSCRIPTIONS_USER
	}, 
	service = MVCRenderCommand.class
)
public class ViewMyInscriptionsMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewMyInscriptionsMVCRenderCommand.class);

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		
		List<UserEnrollOffer> userEnrolledOffers = UserEnrollOfferLocalServiceUtil.getUserEnrolledOffers(groupId, userId);
		List<MyInscriptionDTO> myInscriptionsDTO = new ArrayList<>();
		
		for (UserEnrollOffer userEnroll : userEnrolledOffers) {
			try {
				myInscriptionsDTO.add(DTOUtil.getMyInscriptionDTO(userEnroll, themeDisplay));
			} catch (PortalException e) {
				log.error("Cannot convert userEnrollOffer with userId " + userEnroll.getUserId() + " - offerId " + userEnroll.getOfferId(), e);
			}
		}
		
		renderRequest.setAttribute("myInscriptionsDTO", myInscriptionsDTO);
		
		return "/myInscriptions/public/list.jsp";
	}

	@Reference
	protected UserEnrollOfferService _userEnrollOfferService;
}
