package edu.uoc.mestemi.studentjob.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class CommonUtilities {

	private static final Log log = LogFactoryUtil.getLog(CommonUtilities.class);

	private CommonUtilities() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String capitalize(String s) {
		if (s.length() == 0) return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
}
