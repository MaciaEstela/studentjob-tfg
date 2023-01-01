package edu.uoc.mestemi.studentjob.util.validator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.service.DegreeLocalServiceUtil;
import edu.uoc.mestemi.studentjob.util.CountryA3Constants;

public class ValidatorUtilities {
	
	private static final Log log = LogFactoryUtil.getLog(ValidatorUtilities.class);
	
	private ValidatorUtilities() {
		throw new IllegalStateException("Utility class");
	}
	
	public static boolean mapHasLocaleKey(Map<Locale, String> textMap, String locale) {
		try {
			for (Entry<Locale, String> entry : textMap.entrySet()) {
				if (entry.getKey().toString().equals(locale) && !entry.getValue().isEmpty()) {
					return true;
				}
			}
		} catch (Exception e) {
			log.error("Textmap doesn't contain the locale " + locale, e);
		}
		
		return false;
	}
	
	public static boolean isRegionValidCountry(long regionId, String countryA3) {
		boolean result = true;
		
		try {
			Region region = RegionLocalServiceUtil.getRegion(regionId);
			Country country = CountryLocalServiceUtil.getCountry(region.getCountryId());
			if (!country.getA3().equals(CountryA3Constants.SPAIN) || !region.isActive()) {
				result = false;
			}
		} catch (Exception e) {
			result = false;
			log.error("Region with id " + regionId + " is not valid for country " + countryA3, e);
		}
		
		return result;
	}
	
	public static boolean isValidPreference(String preference) {
		boolean result = true;
		
		try {
			if (!Arrays.asList(StudentjobConstants.JOB_PREFERENCE).contains(preference)) {
				result = false;
			}
		} catch (Exception e) {
			result = false;
			log.error("Error parsing job preference " + preference, e);
		}
		
		return result;
	}
	
	public static boolean isValidDegree(long degreeId) {
		boolean result = true;
		
		try {
			if (DegreeLocalServiceUtil.getDegree(degreeId) == null) {
				result = false;
			}
		} catch (Exception e) {
			result = false;
			log.error("Error getting degree " + degreeId, e);
		}
		
		return result;
	}
	
	public static boolean isRegionIdValid(long regionId, List<String> errors) {
		boolean result = true;
		
		if (!ValidatorUtilities.isRegionValidCountry(regionId, CountryA3Constants.SPAIN)) {
			errors.add("invalid-region-id");
			result = false;
		}
		
		return result;
	}
	
	public static boolean isTitleValid(Map<Locale, String> titleMap, List<String> errors) {
		boolean result = true;
		
		if (!ValidatorUtilities.mapHasLocaleKey(titleMap, "es_ES")) {
			errors.add("title-missing-spanish");
			result = false;
		}
		
		return result;
	}
	
	public static boolean isDescriptionValid(Map<Locale, String> descriptionMap, List<String> errors) {
		boolean result = true;
		
		if (!ValidatorUtilities.mapHasLocaleKey(descriptionMap, "es_ES")) {
			errors.add("description-missing-spanish");
			result = false;
		}
		
		return result;
	}
	
	public static boolean isPreferenceValid(String preference, List<String> errors) {
		boolean result = true;
		
		if (!ValidatorUtilities.isValidPreference(preference)) {
			errors.add("invalid-preference");
			result = false;
		}
		
		return result;
	}
	
	public static boolean isDegreeIdsValid(List<Long> degreeIds, List<String> errors) {
		boolean result = true;
		
		if (Validator.isNull(degreeIds) || degreeIds.isEmpty()) {
			errors.add("empty-degree");
			result = false;
		}
		
		for (long degreeId : degreeIds) {
			if (!ValidatorUtilities.isValidDegree(degreeId)) {
				errors.add("invalid-degree");
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	public static boolean isEmailValid(String email, List<String> errors) {
		boolean result = true;
		
		if (!Validator.isEmailAddress(email)) {
			result = false;
			errors.add("invalid-email");
		}
		
		return result;
	}
}


