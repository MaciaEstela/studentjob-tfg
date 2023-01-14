package edu.uoc.mestemi.studentjob.register.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.register.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;
import edu.uoc.mestemi.studentjob.util.UserManagementUtil;

/**
 * MVC Render for Student and Company User Edit account
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + StudentjobRegisterPortletKeys.STUDENTJOB_MY_ACCOUNT,
			"mvc.command.name=" + MVCCommandNames.EDIT_MY_ACCOUNT_ACTION
		},
		service = MVCActionCommand.class
	)
public class MyAccountMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(MyAccountMVCActionCommand.class);
	private static final String[] acceptedImages = {"image/jpeg", "image/jpg", "image/png"};
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long userId = ParamUtil.getLong(actionRequest, "userId", 0);
		String phone = ParamUtil.getString(actionRequest, "phone", StringPool.BLANK);
		String email = ParamUtil.getString(actionRequest, "email", StringPool.BLANK);
		String name = ParamUtil.getString(actionRequest, "name", StringPool.BLANK);
		String lastName = ParamUtil.getString(actionRequest, "lastName", StringPool.BLANK);
		boolean mailOffers = ParamUtil.getBoolean(actionRequest, "mailOffers", false);
		
		PortletResponse portletResponse = (PortletResponse) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);
		LiferayPortletResponse liferayPortletResponse = PortalUtil.getLiferayPortletResponse(portletResponse);
		LiferayPortletURL renderUrl = liferayPortletResponse.createLiferayPortletURL(themeDisplay.getPlid(), StudentjobRegisterPortletKeys.STUDENTJOB_MY_ACCOUNT, PortletRequest.RENDER_PHASE);
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("image");
		try (FileInputStream fis = new FileInputStream(file); 
				DataInputStream dis = new DataInputStream(fis)){
			String contentType = MimeTypesUtil.getContentType(file);

			if (Arrays.asList(acceptedImages).contains(contentType)) {
				byte[] bytes = new byte[(int) file.length()];
				
				dis.readFully(bytes);
				
				userLocalService.updatePortrait(userId, bytes);
			}
			
			User user = userLocalService.getUser(userId);
			Role studentRole = UserManagementUtil.getRoleById(themeDisplay.getCompanyId(), StudentjobConstants.STUDENT_ROLE);
			if (!UserLocalServiceUtil.hasRoleUser(studentRole.getRoleId(), user.getUserId())) {
				user.setEmailAddress(email);
			}
			user.setFirstName(name);
			user.setLastName(lastName);
			user.getExpandoBridge().setAttribute(StudentjobConstants.USER_PHONE, phone);
			user.getExpandoBridge().setAttribute(StudentjobConstants.USER_EMAIL_OFFERS, mailOffers);
			userLocalService.updateUser(user);
		} catch (Exception e) {
			log.error(e);
		}
		
		sendRedirect(actionRequest, actionResponse, renderUrl.toString());
	}
	
	@Reference
	UserLocalService userLocalService;
}
