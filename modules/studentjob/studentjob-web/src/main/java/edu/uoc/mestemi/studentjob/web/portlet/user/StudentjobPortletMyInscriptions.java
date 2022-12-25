package edu.uoc.mestemi.studentjob.web.portlet.user;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author macia
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.display-category=category.studentjob.public",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=StudentjobPortletMyInscriptions",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/degreearea/admin/view.jsp",
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_MYINSCRIPTIONS_USER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentjobPortletMyInscriptions extends MVCPortlet {
}