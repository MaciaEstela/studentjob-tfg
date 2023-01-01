package edu.uoc.mestemi.studentjob.validator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.exception.DegreeValidationException;

public interface DegreeValidator {
	
	/*
	 * Validates a Degree entity
	 * 
	 * @param nameMap
	 * @param degreeAreasIds
	 * 
	 * @throws DegreeValidationException
	 */
	public void validate(Map<Locale, String> nameMap, List<Long> degreeAreasIds) throws DegreeValidationException;
	
	/*
	 * Validates a Degree delete
	 * 
	 * @param degreeId
	 * 
	 * @throws DegreeValidationException
	 */
	public void validateDelete(long degreeId) throws DegreeValidationException;
}
