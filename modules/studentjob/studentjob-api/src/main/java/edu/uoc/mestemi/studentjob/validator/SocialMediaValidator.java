package edu.uoc.mestemi.studentjob.validator;

import edu.uoc.mestemi.studentjob.exception.SocialMediaValidationException;

public interface SocialMediaValidator {
	
	/*
	 * Validates an SocialMedia entity
	 * 
	 * @param socialMediaNetworkId
	 * @param socialURL
	 * 
	 * @throws SocialMediaValidationException
	 */
	public void validate(long socialMediaNetworkId, String socialURL) throws SocialMediaValidationException;
}
