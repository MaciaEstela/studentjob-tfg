package edu.uoc.mestemi.studentjob.register.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Ticket;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.TicketLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.register.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;
import edu.uoc.mestemi.studentjob.register.portlet.StudentjobRegisterPortlet;
import edu.uoc.mestemi.studentjob.register.util.RegisterUtil;
import edu.uoc.mestemi.studentjob.register.util.TemplateProcessor;
import edu.uoc.mestemi.studentjob.util.UserManagementUtil;

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
		long companyId = themeDisplay.getCompanyId();
		
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));		
		String token = httpReq.getParameter("token");
		String screenName = httpReq.getParameter("user");
		
		renderRequest.setAttribute("validated", false);
		
		try {
			Ticket ticket = _ticketLocalService.getTicket(token);
			User user = _userLocalService.getUserByScreenName(
					themeDisplay.getCompanyId(), screenName);
			
			if (ticket.getClassPK() == user.getPrimaryKey()) {
				user.setEmailAddressVerified(true);
				boolean manualApprovement = true;
				
				if (RoleLocalServiceUtil.hasUserRole(user.getUserId(), companyId, StudentjobConstants.STUDENT_ROLE, true)) {
					user.setStatus(WorkflowConstants.STATUS_APPROVED);
					manualApprovement = false;
				} else {
					try {
						List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(
								UserManagementUtil.getRoleById(
										PortalUtil.getDefaultCompanyId(), RoleConstants.ADMINISTRATOR).getRoleId());
						
						for (User adminUserMail : adminUsers) {
							TemplateProcessor templateProcessor = new TemplateProcessor("/META-INF/resources/mails/companyRegisteredMailTpl.ftl");
							Map<String,Object> params = new HashMap<>();
							params.put("userCompany", user.getExpandoBridge().getAttribute(StudentjobConstants.USER_COMPANY_EXPANDO));
							params.put("fullName", user.getFullName());
							params.put("email", user.getEmailAddress());
							Locale userLocale = adminUserMail.getLocale();
							ResourceBundle resourceBundle = ResourceBundle.getBundle("content.Language", userLocale, UTF8Control.INSTANCE);
							
							params.put("new-company-user", LanguageUtil.get(resourceBundle, "mail.text.new-company-user"));
							params.put("new-company-user", LanguageUtil.get(resourceBundle, "mail.text.new-company-user-requires-approval"));
							params.put("you-can-unsuscribe", LanguageUtil.get(resourceBundle, "mail.text.you-can-unsuscribe"));
							
							RegisterUtil.sendMailMessage(
									StudentjobConstants.EMAIL_SENDER, 
									adminUserMail.getEmailAddress(),
									LanguageUtil.get(resourceBundle, "mail.text.new-company-registered"),
									templateProcessor.process(params, TemplateConstants.LANG_TYPE_FTL)
								);
						}
					} catch (Exception e) {
						log.error("Error processing new register mail", e);
					}
				}
				
				_userLocalService.updateUser(user);
				
				_ticketLocalService.deleteTicket(ticket.getTicketId());
				renderRequest.setAttribute("manualApprovement", manualApprovement);
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
