package edu.uoc.mestemi.studentjob.validator;

import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.exception.CompanyProfileValidationException;

public interface CompanyProfileValidator {
	
	/*
	 * Validates an Offer entity
	 * 
	 * @param regionId
	 * @param titleMap
	 * @param descriptionMap
	 * @param email
	 * @param sectorMap
	 * @param website
	 * 
	 * @throws CompanyProfileValidationException
	 */
	
	public void validate(long regionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, 
			Map<Locale, String> sectorMap, String website) throws CompanyProfileValidationException;
}
