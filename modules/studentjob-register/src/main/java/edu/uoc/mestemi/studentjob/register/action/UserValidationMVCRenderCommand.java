package edu.uoc.mestemi.studentjob.register.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Ticket;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.TicketLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.register.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;
import edu.uoc.mestemi.studentjob.register.portlet.StudentjobRegisterPortlet;

/**
 * MVC Render for Student and Company User Validation
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + StudentjobRegisterPortletKeys.STUDENTJOB_REGISTER_VALIDATE,
			"mvc.command.name=" + MVCCommandNames.RENDER_VALIDATION
		},
		service = MVCRenderCommand.class
	)
public class UserValidationMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(StudentjobRegisterPortlet.class);
	private static final String VIEW_JSP = "/validate.jsp";
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));		
		String token = httpReq.getParameter("token");
		String screenName = httpReq.getParameter("user");
		
		renderRequest.setAttribute("validated", false);
		
		try {
			Ticket ticket = _ticketLocalService.getTicket(token);
			User user = _userLocalService.getUserByScreenName(
					themeDisplay.getCompanyId(), screenName);
			
			if (ticket.getClassPK() == user.getPrimaryKey()) {
				user.setStatus(WorkflowConstants.STATUS_APPROVED);
				_userLocalService.updateUser(user);
				renderRequest.setAttribute("validated", true);
				
			}
		} catch (PortalException e) {
			log.error("Can't validate ticket with ticket key " + token + " and user " + screenName, e);
		}
		
		return VIEW_JSP;
	}
	
	@Reference
	TicketLocalService _ticketLocalService;
	
	@Reference
	UserLocalService _userLocalService;
}
