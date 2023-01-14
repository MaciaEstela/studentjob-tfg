package edu.uoc.mestemi.studentjob.util.validator;

import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.exception.SocialMediaNetworkValidationException;
import edu.uoc.mestemi.studentjob.validator.SocialMediaNetworkValidator;

@Component(
	immediate = true,
	service = SocialMediaNetworkValidatorImpl.class
)

public class SocialMediaNetworkValidatorImpl implements SocialMediaNetworkValidator {

	@Override
	public void validate(String name, String baseURL, long logoId) throws SocialMediaNetworkValidationException {
		
		List<String> errors = new ArrayList<>();
		
		if (!isSocialMediaNetworkValid(name, baseURL, logoId, errors)) {
			throw new SocialMediaNetworkValidationException(errors);
		}
	}
	
	private boolean isSocialMediaNetworkValid(final String name, final String baseURL, 
			final long logoId, final List<String> errors) {
		
		boolean result = true;
		
		result &= Validator.isNotNull(name);
		result &= ValidatorUtilities.isWebsiteValid(baseURL, errors);
		result &= ValidatorUtilities.isFileEntryIdValid(logoId, errors);
		
		return result;
	}
	
}
