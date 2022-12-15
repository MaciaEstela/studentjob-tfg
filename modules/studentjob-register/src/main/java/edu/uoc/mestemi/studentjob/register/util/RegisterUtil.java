package edu.uoc.mestemi.studentjob.register.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
public class RegisterUtil {

	private RegisterUtil() {
		throw new IllegalStateException("Utility class");
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
	public static void sendMailMessage(String fromEmail, String toEmail, 
			String subject, String htmlText) throws AddressException {
		
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

}