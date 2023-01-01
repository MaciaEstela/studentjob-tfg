package edu.uoc.mestemi.studentjob.validator;

import edu.uoc.mestemi.studentjob.exception.SocialMediaNetworkValidationException;

public interface SocialMediaNetworkValidator {
	
	/*
	 * Validates an SocialMediaNetwork entity
	 * 
	 * @param name
	 * @param baseURL
	 * @param logoId
	 * 
	 * @throws SocialMediaNetworkValidationException
	 */
	public void validate(String name, String baseURL, long logoId) throws SocialMediaNetworkValidationException;
}
