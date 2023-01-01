package edu.uoc.mestemi.studentjob.validator;

import java.util.Locale;
import java.util.Map;

import edu.uoc.mestemi.studentjob.exception.DegreeAreaValidationException;

public interface DegreeAreaValidator {
	
	/*
	 * Validates a DegreeArea entity
	 * 
	 * @param nameMap
	 * 
	 * @throws DegreeAreaValidationException
	 */
	public void validate(Map<Locale, String> nameMap) throws DegreeAreaValidationException;
	
	/*
	 * Validates a DegreeArea delete
	 * 
	 * @param degreeAreaId
	 * 
	 * @throws DegreeAreaValidationException
	 */
	public void validateDelete(long degreeAreaId) throws DegreeAreaValidationException;
}
