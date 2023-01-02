package edu.uoc.mestemi.studentjob.register.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
public class RegisterUtil {
	
	private static final Log log = LogFactoryUtil.getLog(RegisterUtil.class);
	
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
	
	public static boolean checkCaptcha(String publicCaptcha) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("https://www.google.com/recaptcha/api/siteverify");
		List<NameValuePair> params = new ArrayList<>(2);
		
		String privateKey = PropsUtil.get("captcha.private.key");
		params.add(new BasicNameValuePair("secret", privateKey));
		params.add(new BasicNameValuePair("response", publicCaptcha));
		httppost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
		
		try {
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				try (InputStream instream = entity.getContent()) {
					BufferedReader streamReader = new BufferedReader(new InputStreamReader(instream, StandardCharsets.UTF_8));
					StringBuilder responseStrBuilder = new StringBuilder();
					String inputStr;
					while ((inputStr = streamReader.readLine()) != null)
						responseStrBuilder.append(inputStr);
					
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(responseStrBuilder.toString());
					if ( jsonObject.has("success"))
						return jsonObject.getBoolean("success");
				}
			}
		} catch (Exception e) {
			log.error("Can't validate google recaptcha");
		} finally {
			try {
				httpclient.close();
			} catch (Exception e) {
				log.error("Can't close httpClient");
			}
		}
		
		return false;
	}
}