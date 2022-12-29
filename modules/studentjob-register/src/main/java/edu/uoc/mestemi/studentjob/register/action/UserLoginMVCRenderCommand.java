package edu.uoc.mestemi.studentjob.register.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.register.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;

/**
 * MVC Render for Student and Company User Login
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + StudentjobRegisterPortletKeys.STUDENTJOB_LOGIN,
			"mvc.command.name=" + MVCCommandNames.RENDER_LOGIN
		},
		service = MVCRenderCommand.class
	)
public class UserLoginMVCRenderCommand implements MVCRenderCommand {

	private static final String VIEW_JSP = "/login.jsp";
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return VIEW_JSP;
	}
	

}