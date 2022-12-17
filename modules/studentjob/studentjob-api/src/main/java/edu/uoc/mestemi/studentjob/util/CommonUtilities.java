package edu.uoc.mestemi.studentjob.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonUtilities {

	private static final Log log = LogFactoryUtil.getLog(CommonUtilities.class);

	private CommonUtilities() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String capitalize(String s) {
		if (s.length() == 0) return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
	
	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public static long getDifferenceMinutes(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
	}
}
