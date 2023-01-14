package edu.uoc.mestemi.studentjob.util.validator;

import java.util.ArrayList;
import java.util.List;
import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.exception.SocialMediaValidationException;
import edu.uoc.mestemi.studentjob.validator.SocialMediaValidator;

@Component(
	immediate = true,
	service = SocialMediaValidatorImpl.class
)

public class SocialMediaValidatorImpl implements SocialMediaValidator {

	@Override
	public void validate(long socialMediaNetworkId, String socialURL) throws SocialMediaValidationException {
		List<String> errors = new ArrayList<>();
		
		if (!isSocialMediaValid(socialMediaNetworkId, socialURL, errors)) {
			throw new SocialMediaValidationException(errors);
		}
	}
	
	private boolean isSocialMediaValid(final long socialMediaNetworkId, final String socialURL, 
			final List<String> errors) {
		
		boolean result = true;
		
		result &= ValidatorUtilities.isSocialMediaNetworkIdValid(socialMediaNetworkId, errors);
		result &= ValidatorUtilities.isWebsiteValid(socialURL, errors);
		
		return result;
	}


	
}
