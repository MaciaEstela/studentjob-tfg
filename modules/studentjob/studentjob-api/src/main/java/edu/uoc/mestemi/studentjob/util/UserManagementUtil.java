package edu.uoc.mestemi.studentjob.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class UserManagementUtil {

	private static final Log log = LogFactoryUtil.getLog(UserManagementUtil.class);

	private UserManagementUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Get a User with ADMINISTRATOR role
	 *
	 * @param companyId		companyId
	 *
	 * @return User
	 */
	public static User getAdminUser(long companyId) {
		User adminUser = null;
		try {
			adminUser = UserLocalServiceUtil.getRoleUsers(
					RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR).getRoleId()
			).get(0);
		} catch (PortalException e) {
			log.error("Error obtaining user with role ADMINISTRATOR. " + e.getMessage());
		}
		
		return adminUser;
	}
	
	/**
	 * Get a Role based on their name
	 *
	 * @param companyId		companyId
	 * @param name			role name to search
	 *
	 * @return Role
	 */
	public static Role getRoleById(final long companyId, final String name) throws PortalException{
		return RoleLocalServiceUtil.getRole(companyId, name);
	}
	
}
