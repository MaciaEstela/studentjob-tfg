package edu.uoc.mestemi.studentjob.util.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.exception.OfferValidationException;
import edu.uoc.mestemi.studentjob.exception.StudentProfileValidationException;
import edu.uoc.mestemi.studentjob.validator.StudentProfileValidator;

@Component(
	immediate = true,
	service = StudentProfileValidatorImpl.class
)

public class StudentProfileValidatorImpl implements StudentProfileValidator {

	@Override
	public void validate(long regionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email,
			String preference, List<Long> degreeIds) throws StudentProfileValidationException {
		
		List<String> errors = new ArrayList<>();
		
		if (!isStudentProfileValid(regionId, titleMap, descriptionMap, email, preference, degreeIds, errors)) {
			throw new StudentProfileValidationException(errors);
		}
	}
	
	private boolean isStudentProfileValid(final long regionId, final Map<Locale, String> titleMap, 
			final Map<Locale, String> descriptionMap, final String email, String preference, 
			final List<Long> degreeIds, final List<String> errors) {
		
		boolean result = true;
		
		result &= ValidatorUtilities.isRegionIdValid(regionId, errors);
		result &= ValidatorUtilities.isTitleValid(titleMap, errors);
		result &= ValidatorUtilities.isDescriptionValid(descriptionMap, errors);
		result &= ValidatorUtilities.isPreferenceValid(preference, errors);
		result &= ValidatorUtilities.isDegreeIdsValid(degreeIds, errors);
		result &= ValidatorUtilities.isEmailValid(email, errors);
		
		return result;
	}
	
}
