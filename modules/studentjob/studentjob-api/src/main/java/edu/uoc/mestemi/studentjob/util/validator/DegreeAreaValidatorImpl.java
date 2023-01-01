package edu.uoc.mestemi.studentjob.util.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.exception.DegreeAreaValidationException;
import edu.uoc.mestemi.studentjob.validator.DegreeAreaValidator;

@Component(
	immediate = true,
	service = DegreeAreaValidatorImpl.class
)

public class DegreeAreaValidatorImpl implements DegreeAreaValidator {
	
	@Override
	public void validateDelete(long degreeAreaId) throws DegreeAreaValidationException {
		
		List<String> errors = new ArrayList<>();
		
		if (!isDegreeAreaDeleteValid(degreeAreaId, errors)) {
			throw new DegreeAreaValidationException(errors);
		}
		
	}
	
	private boolean isDegreeAreaDeleteValid(final long degreeAreaId, final List<String> errors) {
		
		boolean result = true;
		
		result &= ValidatorUtilities.isDegreeAreaEmpty(degreeAreaId, errors);
		
		return result;
	}

	@Override
	public void validate(Map<Locale, String> nameMap) throws DegreeAreaValidationException {
		
		List<String> errors = new ArrayList<>();
		
		if (!isDegreeAreaValid(nameMap, errors)) {
			throw new DegreeAreaValidationException(errors);
		}
	}
	
	private boolean isDegreeAreaValid(final Map<Locale, String> nameMap, final List<String> errors) {
		
		boolean result = true;
		
		result &= ValidatorUtilities.isTitleValid(nameMap, errors);
		
		return result;
	}
	
}
