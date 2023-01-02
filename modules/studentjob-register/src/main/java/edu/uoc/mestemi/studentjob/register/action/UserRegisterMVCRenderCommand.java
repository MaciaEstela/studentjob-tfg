package edu.uoc.mestemi.studentjob.register.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.PropsUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
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
			"javax.portlet.name=" + StudentjobRegisterPortletKeys.STUDENTJOB_REGISTER,
			"mvc.command.name=" + MVCCommandNames.RENDER_REGISTER
		},
		service = MVCRenderCommand.class
	)
public class UserRegisterMVCRenderCommand implements MVCRenderCommand {

	private static final String VIEW_JSP = "/view.jsp";
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		renderRequest.setAttribute("publicKey", PropsUtil.get("captcha.public.key"));
		return VIEW_JSP;
	}
	

}
