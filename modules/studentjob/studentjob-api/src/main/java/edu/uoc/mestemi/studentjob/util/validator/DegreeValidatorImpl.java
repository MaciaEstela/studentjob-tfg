package edu.uoc.mestemi.studentjob.util.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.exception.DegreeValidationException;
import edu.uoc.mestemi.studentjob.exception.OfferValidationException;
import edu.uoc.mestemi.studentjob.validator.DegreeValidator;

@Component(
	immediate = true,
	service = DegreeValidatorImpl.class
)

public class DegreeValidatorImpl implements DegreeValidator {
	
	@Override
	public void validateDelete(long degreeId) throws DegreeValidationException {
		
		List<String> errors = new ArrayList<>();
		
		if (!isDegreeDeleteValid(degreeId, errors)) {
			throw new DegreeValidationException(errors);
		}
		
	}
	
	private boolean isDegreeDeleteValid(final long degreeId, final List<String> errors) {
		
		boolean result = true;
		
		result &= ValidatorUtilities.isDegreeLinkedToStudent(degreeId, errors);
		result &= ValidatorUtilities.isDegreeLinkedToOffer(degreeId, errors);
		
		return result;
	}

	@Override
	public void validate(Map<Locale, String> nameMap, List<Long> degreeAreasIds) throws DegreeValidationException {
		
		List<String> errors = new ArrayList<>();
		
		if (!isDegreeValid(nameMap, degreeAreasIds, errors)) {
			throw new DegreeValidationException(errors);
		}
	}
	
	private boolean isDegreeValid(final Map<Locale, String> nameMap, final List<Long> degreeAreasIds, final List<String> errors) {
		
		boolean result = true;
		
		result &= ValidatorUtilities.isTitleValid(nameMap, errors);
		result &= ValidatorUtilities.areDegreeAreasValid(degreeAreasIds, errors);
		
		return result;
	}
	
}
