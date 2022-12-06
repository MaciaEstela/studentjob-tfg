package edu.uoc.mestemi.studentjob.register.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.TicketLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.register.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;
import edu.uoc.mestemi.studentjob.register.portlet.StudentjobRegisterPortlet;

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

	private static final Log log = LogFactoryUtil.getLog(StudentjobRegisterPortlet.class);
	private static final String viewJSP = "/view.jsp";
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		return viewJSP;
	}
	

}
