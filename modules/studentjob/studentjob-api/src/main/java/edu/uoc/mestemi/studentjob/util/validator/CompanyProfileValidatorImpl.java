package edu.uoc.mestemi.studentjob.util.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.exception.CompanyProfileValidationException;
import edu.uoc.mestemi.studentjob.exception.OfferValidationException;
import edu.uoc.mestemi.studentjob.exception.StudentProfileValidationException;
import edu.uoc.mestemi.studentjob.validator.CompanyProfileValidator;
import edu.uoc.mestemi.studentjob.validator.StudentProfileValidator;

@Component(
	immediate = true,
	service = CompanyProfileValidatorImpl.class
)

public class CompanyProfileValidatorImpl implements CompanyProfileValidator {
	
	
	@Override
	public void validate(long regionId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String email,
			Map<Locale, String> sectorMap, String website) throws CompanyProfileValidationException {
		
		List<String> errors = new ArrayList<>();
		
		if (!isCompanyProfileValid(regionId, titleMap, descriptionMap, email, sectorMap, website, errors)) {
			throw new CompanyProfileValidationException(errors);
		}
		
	}
	
	private boolean isCompanyProfileValid(final long regionId, final Map<Locale, String> titleMap, 
			final Map<Locale, String> descriptionMap, final String email, final Map<Locale, String> sectorMap, 
			final String website, final List<String> errors) {
		
		boolean result = true;
		
		result &= ValidatorUtilities.isRegionIdValid(regionId, errors);
		result &= ValidatorUtilities.isTitleValid(titleMap, errors);
		result &= ValidatorUtilities.isDescriptionValid(descriptionMap, errors);
		result &= ValidatorUtilities.isEmailValid(email, errors);
		result &= ValidatorUtilities.isSectorValid(sectorMap, errors);
		result &= ValidatorUtilities.isEmailValid(email, errors);
		result &= ValidatorUtilities.isWebsiteValid(website, errors);
		
		return result;
	}
	
}
