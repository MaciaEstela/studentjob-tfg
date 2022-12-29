package edu.uoc.mestemi.studentjob.register.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.register.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;

/**
 * MVC Render for Student and Company User Register
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + StudentjobRegisterPortletKeys.STUDENTJOB_MY_ACCOUNT,
			"mvc.command.name=" + MVCCommandNames.RENDER_MY_ACCOUNT
		},
		service = MVCRenderCommand.class
	)
public class MyAccountMVCRenderCommand implements MVCRenderCommand {

	private static final String VIEW_JSP = "/myaccount.jsp";
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		
		User user = themeDisplay.getUser();
		long userId = user.getUserId();
		boolean isStudent = false;
		
		renderRequest.setAttribute("companyExpando", StudentjobConstants.USER_COMPANY_EXPANDO);
		renderRequest.setAttribute("mailOffersExpando", StudentjobConstants.USER_EMAIL_OFFERS);
		renderRequest.setAttribute("nifExpando", StudentjobConstants.USER_NIF);
		renderRequest.setAttribute("phoneExpando", StudentjobConstants.USER_PHONE);
		
		try {
			if (RoleLocalServiceUtil.hasUserRole(userId, companyId, StudentjobConstants.STUDENT_ROLE, true)) {
				isStudent = true;
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		renderRequest.setAttribute("isStudent", isStudent);
		renderRequest.setAttribute("user", user);

		return VIEW_JSP;
	}
	

}
