package edu.uoc.mestemi.studentjob.web.portlet.admin.studentprofile.action;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.StudentProfileValidationException;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.service.StudentProfileService;
import edu.uoc.mestemi.studentjob.util.CountryA3Constants;
import edu.uoc.mestemi.studentjob.util.DocumentLibraryUtil;
import edu.uoc.mestemi.studentjob.util.ProvinceUtil;
import edu.uoc.mestemi.studentjob.service.SocialMediaNetworkService;
import edu.uoc.mestemi.studentjob.service.SocialMediaService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.util.StudentjobUtilities;

/**
 * MVC Action Command for editing studentProfiles.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 *
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_STUDENTPROFILE_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EDIT_STUDENTPROFILE_ADMIN_ACTION
	},
	service = MVCActionCommand.class
)
public class EditStudentProfileMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(EditStudentProfileMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(StudentProfile.class.getName(), actionRequest);
		// Get parameters from the request.

		long studentProfileId = ParamUtil.getLong(actionRequest, "studentProfileId");

		StudentProfile studentProfile = _studentProfileService.getStudentProfile(studentProfileId);
		Map<Locale, String> titleMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "title");
		
		Map<Locale, String> descriptionMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "description");
		boolean active = ParamUtil.getBoolean(actionRequest, "active", false);
		String email = ParamUtil.getString(actionRequest, "email");
		String regionCode = ParamUtil.getString(actionRequest, "region");
		String preference = ParamUtil.getString(actionRequest, "preference");
		
		long[] degreeIds = ParamUtil.getLongValues(actionRequest, "degree");
		List<Long> degreesList = Arrays.stream(degreeIds).boxed().collect(Collectors.toList());
		long regionId = ProvinceUtil.getRegionId(
				ProvinceUtil.getCountryIdByCode(companyId, CountryA3Constants.SPAIN), 
				regionCode);
		
		long curriculumId = 0;
		
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			File file = uploadRequest.getFile("curriculum");
			String fileName = uploadRequest.getFileName("curriculum");
			
			System.out.println("file es " + fileName);
			FileEntry curriculum = DocumentLibraryUtil.addFile(actionRequest, "curriculums", file, fileName);
			curriculumId = curriculum.getFileEntryId();
			System.out.println("On process Action7");	
			DLAppLocalServiceUtil.deleteFileEntry(studentProfile.getCurriculumId());	
		} catch (Exception e) {
			log.error(e);
		}
		
		try {
			// Call the service to update the studentProfile
			
			_studentProfileService.updateStudentProfile(
					studentProfileId, 
					regionId, 
					active, 
					titleMap, 
					descriptionMap, 
					email, 
					preference, 
					curriculumId,
					degreesList, 
					serviceContext
				);
			
			StudentjobUtilities.updateSocialMedia(groupId, actionRequest, 
					StudentProfile.class.getName(), studentProfileId, serviceContext);
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (StudentProfileValidationException ove) {
			log.error("Error validating StudentProfile edit with studentProfileId " + studentProfileId, ove);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_STUDENTPROFILE_ADMIN_ACTION);
		}
		catch (PortalException pe) {
			log.error("Error editing StudentProfile with studentProfileId " + studentProfileId, pe);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_STUDENTPROFILE_ADMIN_ACTION);
		}
	}

	@Reference
	protected StudentProfileService _studentProfileService;
	
	@Reference
	private SocialMediaService _socialMediaService;
	
	@Reference
	private SocialMediaNetworkService _socialMediaNetworkService;
}