package edu.uoc.mestemi.studentjob.web.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import java.util.List;

public class StudentJobUtil {

	private StudentJobUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static long getCountryIdByCode(long companyId, String codeA3) throws PortalException {
		return CountryLocalServiceUtil.getCountryByA3(companyId, codeA3).getCountryId();
	}
	
	public static long getRegionId(long countryId, String regionCode) throws PortalException {
		return RegionLocalServiceUtil.getRegion(countryId, regionCode).getRegionId();
	}
	
	public static List<Region> getRegionsByCountryA3(long companyId, String countryA3, boolean active) throws PortalException {
		Country country = CountryLocalServiceUtil.getCountryByA3(companyId, countryA3);
		return RegionLocalServiceUtil.getRegions(country.getCountryId(), active);
	}
	
}
