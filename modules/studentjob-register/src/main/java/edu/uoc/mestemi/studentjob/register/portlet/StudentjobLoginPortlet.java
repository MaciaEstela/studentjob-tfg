package edu.uoc.mestemi.studentjob.register.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.Portlet;
import org.osgi.service.component.annotations.Component;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.studentjob",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=StudentjobLogin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StudentjobRegisterPortletKeys.STUDENTJOB_LOGIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentjobLoginPortlet extends MVCPortlet {
}