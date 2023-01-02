package edu.uoc.mestemi.studentjob.util.validator;

import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
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
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.service.DegreeAreaLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.DegreeLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.OfferLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.StudentProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.util.CountryA3Constants;
import edu.uoc.mestemi.studentjob.util.DocumentLibraryUtil;

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
	
	public static boolean isDegreeAreaEmpty(long degreeAreaId, List<String> errors) {
		boolean result = true;
		
		if (DegreeLocalServiceUtil.hasDegreeAreaDegrees(degreeAreaId)) {
			errors.add("degreearea-has-degree");
			result = false;
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
	
	public static boolean isSectorValid(Map<Locale, String> sectorMap, List<String> errors) {
		boolean result = true;
		
		if (!ValidatorUtilities.mapHasLocaleKey(sectorMap, "es_ES")) {
			errors.add("sector-missing-spanish");
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
	
	public static boolean isWebsiteValid(String website, List<String> errors) {
		boolean result = true;
		
		if (!Validator.isBlank(website) && !Validator.isUrl(website)) {
			result = false;
			errors.add("invalid-website");
		}
		
		return result;
	}
	
	public static boolean areDegreeAreasValid(List<Long> degreeAreasIds, List<String> errors) {
		
		if (Validator.isNull(degreeAreasIds) || degreeAreasIds.isEmpty()) {
			errors.add("empty-degreeArea");
			return false;
		}
		
		for (long degreeAreaId : degreeAreasIds) {
			if (!isDegreeAreaValid(degreeAreaId, errors)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isDegreeAreaValid(long degreeAreaId, List<String> errors) {
		try {
			if (DegreeAreaLocalServiceUtil.getDegreeArea(degreeAreaId) == null) {
				errors.add("invalid-degreeArea");
				return false;
			}
		} catch (Exception e) {
			errors.add("invalid-degreeArea");
			return false;
		}
		
		return true;
	}
	
	public static boolean isDegreeLinkedToStudent(long degreeId, List<String> errors) {
		List<StudentProfile> studentProfiles = StudentProfileLocalServiceUtil.getStudentProfiles(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		for (StudentProfile studentProfile : studentProfiles) {
			if (DegreeLocalServiceUtil.hasStudentProfileDegree(studentProfile.getStudentProfileId(), degreeId)) {
				errors.add("degree-linked-student");
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isDegreeLinkedToOffer(long degreeId, List<String> errors) {
		List<Offer> offers = OfferLocalServiceUtil.getOffers(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		for (Offer offer : offers) {
			if (DegreeLocalServiceUtil.hasOfferDegree(offer.getOfferId(), degreeId)) {
				errors.add("degree-linked-offer");
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isFileEntryIdValid(long fileEntryId, List<String> errors) {
		
		boolean result = true;
		
		try {
			DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
		} catch (PortalException e) {
			result = false;
			errors.add("invalid-attached-file");
		}
		
		
		return result;
	}
	
	public static boolean isSocialMediaNetworkIdValid(long socialMediaNetworkId, List<String> errors) {
		
		boolean result = true;
		
		try {
			SocialMediaNetworkLocalServiceUtil.getSocialMediaNetwork(socialMediaNetworkId);
		} catch (PortalException e) {
			result = false;
			errors.add("invalid-socialmedianetworkId");
		}
		
		return result;
	}
	
}


