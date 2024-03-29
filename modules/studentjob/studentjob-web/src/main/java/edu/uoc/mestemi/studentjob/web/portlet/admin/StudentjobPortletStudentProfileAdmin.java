package edu.uoc.mestemi.studentjob.web.portlet.admin;

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
		"com.liferay.portlet.display-category=category.studentjob",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Studentjob STUDENTPROFILE ADMIN",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/studentProfile/admin/edit_studentProfile.jsp",
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_STUDENTPROFILE_ADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentjobPortletStudentProfileAdmin extends MVCPortlet {
}