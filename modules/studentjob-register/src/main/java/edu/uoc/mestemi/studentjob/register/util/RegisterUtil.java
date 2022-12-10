package edu.uoc.mestemi.studentjob.register.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class RegisterUtil {

	private RegisterUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Get a Role based on her name
	 *
	 * @param companyId		companyId
	 * @param name			role name to search
	 *
	 * @return Role
	 */
	public static Role getRoleById(final long companyId, final String name) throws Exception{
		return RoleLocalServiceUtil.getRole(companyId, name);
	}
	
	
	/**
	 * Send a mail using Liferay service MailServiceUtil
	 *
	 * @param fromEmail		Email address that sends the message
	 * @param toEmail		Email(s) address(es) that receives the message (separated by commas ",")
	 * @param subject		Email subject
	 * @param htmlText		Email HTML content
	 *
	 */
	public static void sendMailMessage(String fromEmail, String toEmail, String subject, String htmlText) throws AddressException {
		InternetAddress from = new InternetAddress(fromEmail);
		
		MailMessage mailMessage = new MailMessage(from, subject, htmlText, true);
		
		String [] emailsArray = toEmail.split(",");
		InternetAddress[] to = new InternetAddress [emailsArray.length];
		
		for (int i = 0 ; i < emailsArray.length ; i++) {
			to[i] = new InternetAddress(emailsArray[i]);
		}
		
		mailMessage.setTo(to);
		
		MailServiceUtil.sendEmail(mailMessage);
	}
	
	public static String capitalize(String s) {
		if (s.length() == 0) return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
}