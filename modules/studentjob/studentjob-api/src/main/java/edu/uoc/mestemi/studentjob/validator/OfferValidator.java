package edu.uoc.mestemi.studentjob.validator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.exception.OfferValidationException;

public interface OfferValidator {
	
	/*
	 * Validates an Offer entity
	 * 
	 * @param regionId
	 * @param titleMap
	 * @param descriptionMap
	 * @param preference
	 * @param degreeIds
	 * 
	 * @throws OfferValidationException
	 */
	public void validate(long regionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String preference, 
			List<Long> degreeIds) throws OfferValidationException;
}
