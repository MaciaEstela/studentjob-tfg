package edu.uoc.mestemi.studentjob.contributor.context.contributor;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.template.TemplateContextContributor;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * @author macia
 */
@Component(
	immediate = true,
	property = {"type=" + TemplateContextContributor.TYPE_GLOBAL},
	service = TemplateContextContributor.class
)
public class StudentjobContextContributorTemplateContextContributor
	implements TemplateContextContributor {

	private static final Log log = LogFactoryUtil.getLog(StudentjobContextContributorTemplateContextContributor.class);
	
	@Override
	public void prepare(
		Map<String, Object> contextObjects, HttpServletRequest request) {
		
		ThemeDisplay themeDisplay =
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long companyId = themeDisplay.getCompanyId();
		int studentsCount = 50;
		int companiesCount = 50;
		
		long companyRoleId = 0;
		long studentRoleId = 0;
		try {
			studentRoleId = RoleLocalServiceUtil.getRole(companyId, "studentRole").getRoleId();
			studentsCount = UserLocalServiceUtil.getRoleUsersCount(studentRoleId);
			
			companyRoleId = RoleLocalServiceUtil.getRole(companyId, "companyRole").getRoleId();
			companiesCount = UserLocalServiceUtil.getRoleUsersCount(companyRoleId);
		} catch (Exception e) {
			log.error("Error obtaining company and student users count", e);
		}
		
		contextObjects.put("companyRoleId", companyRoleId);
		contextObjects.put("studentRoleId", studentRoleId);
		contextObjects.put("userLocalServiceUtil", UserLocalServiceUtil.class);
		
		contextObjects.put("studentsCount", studentsCount);
		contextObjects.put("companiesCount", companiesCount);
	}
}