package edu.uoc.mestemi.studentjob.register.portlet;

import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.expando.kernel.service.permission.ExpandoColumnPermission;
import com.liferay.expando.kernel.service.permission.ExpandoColumnPermissionUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterConstants;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;
import edu.uoc.mestemi.studentjob.register.util.RegisterUtil;

/**
 * @author macia
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.studentjob",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=StudentjobRegister Validate",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/validate.jsp",
		"javax.portlet.name=" + StudentjobRegisterPortletKeys.STUDENTJOB_REGISTER_VALIDATE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentjobRegisterValidatePortlet extends MVCPortlet {
	private static final Log log = LogFactoryUtil.getLog(StudentjobRegisterValidatePortlet.class);

}