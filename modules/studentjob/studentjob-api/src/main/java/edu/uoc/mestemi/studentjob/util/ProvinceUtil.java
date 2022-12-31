package edu.uoc.mestemi.studentjob.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

public class ProvinceUtil {

	private static final Log log = LogFactoryUtil.getLog(ProvinceUtil.class);
	
	private ProvinceUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	public static long getCountryIdByCode(long companyId, String codeA3) throws PortalException {
		return CountryLocalServiceUtil.getCountryByA3(companyId, codeA3).getCountryId();
	}
	
	public static Country getCountryByCode(long companyId, String codeA3) throws PortalException {
		return CountryLocalServiceUtil.getCountryByA3(companyId, codeA3);
	}
	
	public static long getRegionIdByCode(long companyId, String countryCode, String regionCode) throws PortalException{
		Region region = RegionLocalServiceUtil.getRegion(getCountryIdByCode(companyId, countryCode), regionCode);
		return region.getRegionId();
	}
	
	public static long getRegionId(long companyId, String countryCodeA3, String regionCodeA3) throws PortalException {
		Country country = CountryLocalServiceUtil.getCountryByA3(companyId, countryCodeA3);
		return RegionLocalServiceUtil.getRegion(country.getCountryId(), regionCodeA3).getRegionId();
	}
	
	public static long getRegionId(long countryId, String regionCode) throws PortalException {
		return RegionLocalServiceUtil.getRegion(countryId, regionCode).getRegionId();
	}
	
	public static List<Region> getRegionsByCountryA3(long companyId, String countryA3, boolean active) {
		List<Region> regions = new ArrayList<>();
		try {
			Country country = CountryLocalServiceUtil.getCountryByA3(companyId, countryA3);
			regions = RegionLocalServiceUtil.getRegions(country.getCountryId(), active);
		} catch (PortalException e) {
			log.error("Error obtaining Regions", e);
		}
		
		return regions;
	}
	
}
