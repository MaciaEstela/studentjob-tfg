package edu.uoc.mestemi.studentjob.register.util;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

public class RegisterUtil {

	private RegisterUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Get a Role based on her name
	 *
	 * @param companyId		companyId
	 * @param name			role name to search
	 *
	 * @return Role
	 */
	public static Role getRoleById(final long companyId, final String name) throws Exception{
		return RoleLocalServiceUtil.getRole(companyId, name);
	}
}
