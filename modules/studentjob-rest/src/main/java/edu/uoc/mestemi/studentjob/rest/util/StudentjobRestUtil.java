package edu.uoc.mestemi.studentjob.rest.util;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.util.UserManagementUtil;

public class StudentjobRestUtil {

	public static boolean isUserCompany(long companyId, long userId) {
		Role companyRole;
		try {
			companyRole = UserManagementUtil.getRoleById(companyId, StudentjobConstants.COMPANY_ROLE);
			if (UserLocalServiceUtil.hasRoleUser(companyRole.getRoleId(), userId)) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
}
