package edu.uoc.mestemi.studentjob.register.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.regex.Pattern;

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
	
	public static UserGroup getUserGroup(long companyId, String groupName) throws PortalException {
		return UserGroupLocalServiceUtil.getUserGroup(companyId, groupName);
	}
	
	public static String getEmailDomain(String email){
		String emailDomain = StringPool.BLANK;
		if (email.contains("@"))
			emailDomain = email.substring(email.indexOf("@") + 1);
		
		return emailDomain;
	}

	public static String getScreenNameStudent(ThemeDisplay themeDisplay, String email) {
		String screenName = StringPool.BLANK;
		String emailName = email.split("@")[0];
		long companyId = themeDisplay.getCompanyId();
		emailName = emailName.replaceAll("[^a-zA-Z]", "");
		String baseEmailName = emailName;
		
		System.out.println("emailName es " + emailName);
		int count = 0;
		do {
			try {
				if (UserLocalServiceUtil.getUserByScreenName(companyId, emailName) == null) {
					screenName = emailName;
				} else {
					emailName = baseEmailName + count;
					count++;
				}
			} catch (PortalException pe) {
				screenName = emailName;
			}
		} while (screenName.isEmpty());
		
		return screenName;
	}
	
	public static String getScreenNameCompany(ThemeDisplay themeDisplay, String email) {
		String screenName = StringPool.BLANK;
		String emailDomain = email.substring(email.indexOf("@") + 1);
		String domain = emailDomain.substring(0, emailDomain.indexOf("."));
		
		long companyId = themeDisplay.getCompanyId();
		domain = domain.replaceAll("[^a-zA-Z]", "");
		String baseDomain = domain;
		
		int count = 0;
		
		do {
			try {
				if (UserLocalServiceUtil.getUserByScreenName(companyId, domain) == null) {
					screenName = domain;
				} else {
					domain = baseDomain + count;
					count++;
				}
			} catch (PortalException pe) {
				screenName = domain;
			}
		} while (screenName.isEmpty());
		
		return screenName;
	}
}