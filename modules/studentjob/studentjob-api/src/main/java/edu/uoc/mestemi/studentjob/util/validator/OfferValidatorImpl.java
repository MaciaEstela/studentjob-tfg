package edu.uoc.mestemi.studentjob.util.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.exception.OfferValidationException;
import edu.uoc.mestemi.studentjob.validator.OfferValidator;

@Component(
	immediate = true,
	service = OfferValidatorImpl.class
)

public class OfferValidatorImpl implements OfferValidator {

	@Override
	public void validate(long regionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			String preference, List<Long> degreeIds) throws OfferValidationException {
		
		List<String> errors = new ArrayList<>();
		
		if (!isOfferValid(regionId, titleMap, descriptionMap, preference, degreeIds, errors)) {
			throw new OfferValidationException(errors);
		}
		
	}
	
	private boolean isOfferValid(final long regionId, final Map<Locale, String> titleMap, final Map<Locale, String> descriptionMap,
			final String preference, final List<Long> degreeIds, final List<String> errors) {
		
		boolean result = true;
		
		result &= ValidatorUtilities.isRegionIdValid(regionId, errors);
		result &= ValidatorUtilities.isTitleValid(titleMap, errors);
		result &= ValidatorUtilities.isDescriptionValid(descriptionMap, errors);
		result &= ValidatorUtilities.isPreferenceValid(preference, errors);
		result &= ValidatorUtilities.isDegreeIdsValid(degreeIds, errors);
		
		return result;
	}
	
}
