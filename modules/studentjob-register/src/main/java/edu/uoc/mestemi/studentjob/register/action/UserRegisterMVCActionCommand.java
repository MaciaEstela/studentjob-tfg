package edu.uoc.mestemi.studentjob.register.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Ticket;
import com.liferay.portal.kernel.model.TicketConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.TicketLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.register.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;
import edu.uoc.mestemi.studentjob.register.portlet.StudentjobRegisterPortlet;
import edu.uoc.mestemi.studentjob.register.util.RegisterUtil;
import edu.uoc.mestemi.studentjob.register.util.TemplateProcessor;
import edu.uoc.mestemi.studentjob.service.CompanyProfileLocalService;
import edu.uoc.mestemi.studentjob.service.StudentProfileLocalService;
import edu.uoc.mestemi.studentjob.service.StudentProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.util.UserManagementUtil;

/**
 * MVC Render for Student and Company User Register
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + StudentjobRegisterPortletKeys.STUDENTJOB_REGISTER,
			"mvc.command.name=" + MVCCommandNames.ACTION_REGISTER
		},
		service = MVCActionCommand.class
	)
public class UserRegisterMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(StudentjobRegisterPortlet.class);
	private static final String EMAIL = "Email";
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.RENDER_REGISTER);
		
		String registerType = ParamUtil.getString(actionRequest,  "registerType", StringPool.BLANK);
		
		try {
			if (registerType.equals(StudentjobConstants.USER_STUDENT)) {
				registerStudentUser(actionRequest, themeDisplay);
			} else if (registerType.equals(StudentjobConstants.USER_COMPANY)) {
				registerCompanyUser(actionRequest, themeDisplay);
			} else {
				SessionErrors.add(actionRequest, "error.user.invalid-type");
			}
		} catch (UserEmailAddressException uea) {
			String studentEmail = ParamUtil.getString(actionRequest, registerType + EMAIL, StringPool.BLANK);
			log.error("Error on registering duplicated user email " + studentEmail, uea);
			SessionErrors.add(actionRequest, "error.user.email-duplicated");
		} catch (Exception e) {
			log.error("Error on register user", e);
		}
	}

	/**
	 * Registers a Company User
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 */
	private void registerCompanyUser(ActionRequest actionRequest, ThemeDisplay themeDisplay) throws PortalException {
		
		String userTypePrefix = StudentjobConstants.USER_COMPANY;
		boolean userReceiveOffers = ParamUtil.getBoolean(actionRequest, userTypePrefix + "OfferAlerts", false);
		String userNif= ParamUtil.getString(actionRequest, userTypePrefix + "Nif", StringPool.BLANK);
		String userPhone = ParamUtil.getString(actionRequest, userTypePrefix + "Phone", StringPool.BLANK);
		String userCompany = ParamUtil.getString(actionRequest, userTypePrefix + "Company", StringPool.BLANK);
		String userCaptcha = ParamUtil.getString(actionRequest, userTypePrefix + "Captcha", StringPool.BLANK);
		
		if (userNif.isEmpty() || userPhone.isEmpty() || userCompany.isEmpty()) {
			SessionErrors.add(actionRequest, "register-invalid-inputs");
		}
		
		if (!userNif.matches(StudentjobConstants.REGEX_NIF)) {
			SessionErrors.add(actionRequest, "register-invalid-nif");
		}
		
		if (!userPhone.matches(StudentjobConstants.REGEX_PHONE)) {
			SessionErrors.add(actionRequest, "register-invalid-phone");
		}
		
		if (!RegisterUtil.checkCaptcha(userCaptcha)) {
			SessionErrors.add(actionRequest, "register-invalid-captcha");
		}
		
		User user = createUser(actionRequest, themeDisplay, userTypePrefix);
		long groupId = themeDisplay.getScopeGroupId();
		
		if (user != null) {
			log.info("Company User created with ID " + user.getUserId());

			user.getExpandoBridge().setAttribute(
					StudentjobConstants.USER_EMAIL_OFFERS, userReceiveOffers, false);
			
			user.getExpandoBridge().setAttribute(
					StudentjobConstants.USER_NIF, userNif, false);
			
			user.getExpandoBridge().setAttribute(
					StudentjobConstants.USER_PHONE, userPhone, false);
			
			user.getExpandoBridge().setAttribute(
					StudentjobConstants.USER_COMPANY_EXPANDO, userCompany, false);
			
			user.setAgreedToTermsOfUse(true);
			
			_userLocalService.updateUser(user);
			
			Map<Locale, String> emptyLocale = new HashMap<>();
			_companyProfileLocalService.addCompanyProfile(
					groupId,
					user.getUserId(),
					0,
					false,
					emptyLocale,
					emptyLocale,
					user.getEmailAddress(),
					emptyLocale,
					StringPool.BLANK,
					new ArrayList<>(),
					new ServiceContext()
				);
		} else {
			SessionErrors.add(actionRequest, "error.user.create");
		}
	}
	
	/**
	 * Registers a Student User
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 */
	private void registerStudentUser(ActionRequest actionRequest, ThemeDisplay themeDisplay) throws PortalException {
		
		String userTypePrefix = StudentjobConstants.USER_STUDENT;
		boolean userReceiveOffers = ParamUtil.getBoolean(actionRequest, userTypePrefix + "OfferAlerts", false);

		User user = createUser(actionRequest, themeDisplay, userTypePrefix);
		long groupId = themeDisplay.getScopeGroupId();
		
		if (user != null) {
			log.info("Student User created with ID " + user.getUserId());
			
			user.getExpandoBridge().setAttribute(
					StudentjobConstants.USER_EMAIL_OFFERS, userReceiveOffers, false);
			
			user.setAgreedToTermsOfUse(true);
			
			_userLocalService.updateUser(user);
			
			Map<Locale, String> emptyLocale = new HashMap<>();
			
			StudentProfileLocalServiceUtil.getStudentProfiles(0, 10);
			
			StudentProfileLocalServiceUtil.addStudentProfile(
					groupId,
					user.getUserId(),
					0,
					false,
					emptyLocale,
					emptyLocale,
					user.getEmailAddress(),
					StringPool.BLANK,
					0,
					new ArrayList<>(),
					new ServiceContext()
				);
		} else {
			SessionErrors.add(actionRequest, "error.user.create");
		}
	}
	
	/**
	 * Create a generic user
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 *
	 * @return User
	 */
	private User createUser(ActionRequest actionRequest, ThemeDisplay themeDisplay, String userTypePrefix) throws PortalException {
		long companyId = themeDisplay.getCompanyId();
		
		String name = ParamUtil.getString(actionRequest, userTypePrefix + "Name", StringPool.BLANK);
		String surname = ParamUtil.getString(actionRequest, userTypePrefix + "Surname", StringPool.BLANK);
		String email = ParamUtil.getString(actionRequest, userTypePrefix + EMAIL, StringPool.BLANK);
		String password = ParamUtil.getString(actionRequest, userTypePrefix + "Password", StringPool.BLANK);
		String repeatPassword = ParamUtil.getString(actionRequest, userTypePrefix + "RepeatPassword", StringPool.BLANK);
		
		createUserValidation(actionRequest, userTypePrefix);
		
		User adminUser = UserManagementUtil.getAdminUser(companyId);
		User user = null;
		
		if (adminUser != null && SessionErrors.isEmpty(actionRequest)) {
			String customScreenName = StringPool.BLANK;
			boolean autoScreenName = false;
			
			try {
				if (userTypePrefix.equals(StudentjobConstants.USER_COMPANY)) {
					customScreenName = RegisterUtil.getScreenNameCompany(themeDisplay, email);
				} else {
					customScreenName = RegisterUtil.getScreenNameStudent(themeDisplay, email);
				}
			} catch (Exception e) {
				autoScreenName = true;
			}
			
			user =  _userLocalService.addUserWithWorkflow(
				adminUser.getUserId(),
				companyId,
				false,
				password,
				repeatPassword,
				autoScreenName,
				customScreenName,
				email,
				themeDisplay.getLocale(),
				name,
				StringPool.BLANK,
				surname,
				-1,
				-1,
				true,
				1,
				1,
				1985,
				StringPool.BLANK,
				new long[]{themeDisplay.getScopeGroupId()},
				new long[]{},
				new long[]{},
				new long[]{},
				false,
				new ServiceContext()
			);
			
			if (userTypePrefix.equals(StudentjobConstants.USER_COMPANY)) {
				UserLocalServiceUtil.addRoleUser(
						RoleLocalServiceUtil.getRole(companyId, StudentjobConstants.COMPANY_ROLE).getRoleId(), 
						user.getUserId());
				SessionMessages.add(actionRequest, "company-registered");
			} else {
				UserLocalServiceUtil.addRoleUser(
						RoleLocalServiceUtil.getRole(companyId, StudentjobConstants.STUDENT_ROLE).getRoleId(), 
						user.getUserId());
				SessionMessages.add(actionRequest, "student-registered");
			}
			
			Ticket ticket = _ticketLocalService.addTicket(
					companyId,
					User.class.getName(),
					user.getPrimaryKey(),
					TicketConstants.TYPE_EMAIL_ADDRESS,
					StringPool.BLANK,
					new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(72)), 
					new ServiceContext()
				);
			
			try {
				sendRegisterEmail(actionRequest, userTypePrefix, email, themeDisplay.getLocale(), ticket.getKey(), user.getScreenName(), user.getFirstName());
			} catch (Exception e) {
				log.error("Cant send user mail register", e);
			} 
			
			if (StudentjobConstants.USERS_INACTIVE_BY_DEFAULT)
				user.setStatus(WorkflowConstants.STATUS_INACTIVE);
		}
			
		return user;
	}
	
	private void sendRegisterEmail(ActionRequest actionRequest, String userTypePrefix, String email, Locale locale, String token, String screenName, String userName) throws TemplateException, MalformedURLException {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("content.Language", locale, UTF8Control.INSTANCE);
		PortletContext portletContext = actionRequest.getPortletContext();
				
		Map<String,Object> params = new HashMap<>();
		TemplateProcessor templateProcessor = null;
		String subject = LanguageUtil.get(resourceBundle, "mail.subject." + userTypePrefix);
		
		params.put("title", LanguageUtil.get(resourceBundle, "mail.title"));
		params.put("preview", LanguageUtil.get(resourceBundle, "mail.text.preview"));
		params.put("text1", LanguageUtil.get(resourceBundle, "mail.text.1"));
		params.put("text2", LanguageUtil.get(resourceBundle, "mail.text.2" + userTypePrefix));
		params.put("confirm", LanguageUtil.get(resourceBundle, "mail.text.confirm"));
		params.put("contactus", LanguageUtil.get(resourceBundle, "mail.text.contactus"));
		params.put("footer1", LanguageUtil.get(resourceBundle, "mail.text.footer1"));
		params.put("footer2", LanguageUtil.get(resourceBundle, "mail.text.footer2"));
		params.put("footer3", LanguageUtil.get(resourceBundle, "mail.text.footer3"));
		params.put("gotoportal", LanguageUtil.get(resourceBundle, "mail.text.gotoportal"));
		params.put("visualizeurl", LanguageUtil.get(resourceBundle, "mail.text.visualizeurl"));
		params.put("username", userName);
		
		params.put("contactmail", "contact@mestemiuoc.com");
		params.put("siteurl", "https://mestemiuoc.com");
		params.put("preferencesUrl", "https://mestemiuoc.com/sjobadmin/settings");
		params.put("confirmUrl", "http://mestemiuoc.com/validate?token=" + token + "&user=" + screenName);
		
		templateProcessor = new TemplateProcessor(
				portletContext.getResource("/mails/registerUserMail.ftl").getPath());
		try {
			RegisterUtil.sendMailMessage(
					StudentjobConstants.EMAIL_SENDER, 
					email, 
					subject,
					templateProcessor.process(params, TemplateConstants.LANG_TYPE_FTL)
				);
		} catch (AddressException e) {
			log.error("Wrong format mail adress", e);
		}
	}
	
	private void createUserValidation(ActionRequest actionRequest, String userTypePrefix) {
		
		String name = ParamUtil.getString(actionRequest, userTypePrefix + "Name", StringPool.BLANK);
		String surname = ParamUtil.getString(actionRequest, userTypePrefix + "Surname", StringPool.BLANK);
		String email = ParamUtil.getString(actionRequest, userTypePrefix + EMAIL, StringPool.BLANK);
		String password = ParamUtil.getString(actionRequest, userTypePrefix + "Password", StringPool.BLANK);
		String repeatPassword = ParamUtil.getString(actionRequest, userTypePrefix + "RepeatPassword", StringPool.BLANK);
		
		if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
			SessionErrors.add(actionRequest, "email-invalid-inputs");
		}
		
		if (userTypePrefix.equals(StudentjobConstants.USER_STUDENT) && StudentjobConstants.STUDENTS_ONLY_UOC && !RegisterUtil.getEmailDomain(email).equals("uoc.edu")) {
			SessionErrors.add(actionRequest, "email-not-valid-uoc");
		}
	}
	
	@Reference
	UserLocalService _userLocalService;
	
	@Reference
	CompanyProfileLocalService _companyProfileLocalService;
	
	@Reference
	StudentProfileLocalService _studentProfileLocalService;
	
	@Reference
	TicketLocalService _ticketLocalService;
}
