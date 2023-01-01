package edu.uoc.mestemi.studentjob.validator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.exception.OfferValidationException;
import edu.uoc.mestemi.studentjob.exception.StudentProfileValidationException;

public interface StudentProfileValidator {
	
	/*
	 * Validates an StudentProfile entity
	 * 
	 * @param titleMap
	 * @param descriptionMap
	 * @param email
	 * @param regionId
	 * @param regionId
	 * @param preference
	 * 
	 * @throws OfferValidationException
	 */
	public void validate(long regionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email, 
			String preference, List<Long> degreeIds) throws StudentProfileValidationException;
}
