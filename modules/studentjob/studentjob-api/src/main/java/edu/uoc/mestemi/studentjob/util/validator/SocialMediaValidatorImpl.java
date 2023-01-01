package edu.uoc.mestemi.studentjob.util.validator;

import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.exception.OfferValidationException;
import edu.uoc.mestemi.studentjob.exception.SocialMediaNetworkValidationException;
import edu.uoc.mestemi.studentjob.exception.SocialMediaValidationException;
import edu.uoc.mestemi.studentjob.exception.StudentProfileValidationException;
import edu.uoc.mestemi.studentjob.validator.SocialMediaNetworkValidator;
import edu.uoc.mestemi.studentjob.validator.SocialMediaValidator;
import edu.uoc.mestemi.studentjob.validator.StudentProfileValidator;

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
