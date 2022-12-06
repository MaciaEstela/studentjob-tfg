package edu.uoc.mestemi.studentjob.register.action;

import com.liferay.headless.admin.user.dto.v1_0.UserAccount;
import com.liferay.mail.reader.service.AccountLocalService;
import com.liferay.mail.reader.service.AccountLocalServiceUtil;
import com.liferay.mail.reader.service.persistence.AccountUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.TicketConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.TicketLocalService;
import com.liferay.portal.kernel.service.TicketLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.register.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterConstants;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;
import edu.uoc.mestemi.studentjob.register.portlet.StudentjobRegisterPortlet;
import edu.uoc.mestemi.studentjob.register.util.RegisterUtil;
import edu.uoc.mestemi.studentjob.service.CompanyProfileLocalService;
import edu.uoc.mestemi.studentjob.service.StudentProfileLocalService;

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
	private static final String viewJSP = "/view.jsp";
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.RENDER_REGISTER);
		
		if (false) {
			SessionErrors.add(actionRequest, "error.form-validation");
		}
		
		String registerType = ParamUtil.getString(actionRequest,  "registerType", StringPool.BLANK);
		
		try {
			if (registerType.equals(StudentjobRegisterConstants.USER_STUDENT)) {
				registerStudentUser(actionRequest, themeDisplay);
			} else if (registerType.equals(StudentjobRegisterConstants.USER_COMPANY)) {
				registerCompanyUser(actionRequest, themeDisplay);
			} else {
				SessionErrors.add(actionRequest, "error.user.invalid-type");
			}
		} catch (UserEmailAddressException uea) {
			String studentEmail = ParamUtil.getString(actionRequest, registerType + "Email", StringPool.BLANK);
			log.error("Error on registering duplicated user email " + studentEmail);
			SessionErrors.add(actionRequest, "error.user.email-duplicated");
		} catch (Exception e) {
//			SessionErrors.add(, clazz);
			e.printStackTrace();
		}
		
		
		HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		
		httpServletRequest.getParameter("userName");
		
//		actionResponse.getRenderParameters().setValue("redirectURL", "");
		sendRedirect(actionRequest, actionResponse);
	}

	/**
	 * Registers a Company User
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 */
	private void registerCompanyUser(ActionRequest actionRequest, ThemeDisplay themeDisplay) throws PortalException {
		
		String userTypePrefix = StudentjobRegisterConstants.USER_COMPANY;
		boolean userReceiveOffers = ParamUtil.getBoolean(actionRequest, userTypePrefix + "OfferAlerts", false);
		String userNif= ParamUtil.getString(actionRequest, userTypePrefix + "Nif", StringPool.BLANK);
		String userPhone = ParamUtil.getString(actionRequest, userTypePrefix + "Phone", StringPool.BLANK);

		User user = createUser(actionRequest, themeDisplay, userTypePrefix);
		long groupId = themeDisplay.getScopeGroupId();
		
		if (user != null) {
			log.info("Company User created with ID " + user.getUserId());

			user.getExpandoBridge().setAttribute(
					StudentjobRegisterConstants.USER_EMAIL_OFFERS, userReceiveOffers, false);
			
			user.getExpandoBridge().setAttribute(
					StudentjobRegisterConstants.USER_NIF, userNif, false);
			
			user.getExpandoBridge().setAttribute(
					StudentjobRegisterConstants.USER_PHONE, userPhone, false);
			
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
		
		String userTypePrefix = StudentjobRegisterConstants.USER_STUDENT;
		boolean userReceiveOffers = ParamUtil.getBoolean(actionRequest, userTypePrefix + "OfferAlerts", false);

		User user = createUser(actionRequest, themeDisplay, userTypePrefix);
		long groupId = themeDisplay.getScopeGroupId();
		
		if (user != null) {
			log.info("Student User created with ID " + user.getUserId());
			
			user.getExpandoBridge().setAttribute(
					StudentjobRegisterConstants.USER_EMAIL_OFFERS, userReceiveOffers, false);
			
			user.setAgreedToTermsOfUse(true);
			
			_userLocalService.updateUser(user);
			
			Map<Locale, String> emptyLocale = new HashMap<>();
			
			_studentProfileLocalService.addStudentProfile(
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
		String email = ParamUtil.getString(actionRequest, userTypePrefix + "Email", StringPool.BLANK);
		String password = ParamUtil.getString(actionRequest, userTypePrefix + "Password", StringPool.BLANK);
		String repeatPassword = ParamUtil.getString(actionRequest, userTypePrefix + "RepeatPassword", StringPool.BLANK);
		
		User adminUser = getAdminUser();
		User user = null;
		if (adminUser != null) {
			
			user =  _userLocalService.addUserWithWorkflow(
				adminUser.getUserId(),
				companyId,
				false,
				password,
				repeatPassword,
				true,
				StringPool.BLANK,
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
			
			_ticketLocalService.addTicket(
					companyId,
					User.class.getName(),
					user.getPrimaryKey(),
					TicketConstants.TYPE_EMAIL_ADDRESS,
					StringPool.BLANK,
					new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(72)), 
					new ServiceContext()
				);
			
//			user.setStatus(WorkflowConstants.STATUS_INACTIVE);
		}
			
		return user;
	}
	
	/**
	 * Get an User with Administrator role
	 *
	 * @return User
	 */
	private  User getAdminUser() {
		final long companyId = PortalUtil.getDefaultCompanyId();
		
		try {
			Role role = RegisterUtil.getRoleById(companyId, RoleConstants.ADMINISTRATOR);
			List<User> adminUsers = _userLocalService.getRoleUsers(role.getRoleId());
			if (!adminUsers.isEmpty()) {
				return adminUsers.get(0);
			}
		} catch (final Exception e) {
			log.error("Error obtaining admin user", e);
		}
		return null;
	}
	
	private void sendRegisterEmail(ActionRequest actionRequest, String userType) {
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
