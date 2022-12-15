package edu.uoc.mestemi.studentjob.web.portlet.user.studentprofile.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.NoSuchStudentProfileException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.StudentProfileService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.util.DocumentLibraryUtil;
import edu.uoc.mestemi.studentjob.web.util.StudentJobUtil;

/**
 * MVC Command for viewing studentProfile details
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_USER,
		"mvc.command.name=" + MVCCommandNames.VIEW_STUDENTPROFILE_PUBLIC
	}, 
	service = MVCRenderCommand.class
)
public class ViewPublicStudentProfileDetailMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewPublicStudentProfileDetailMVCRenderCommand.class);
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		StudentProfile studentProfile = null;
		long userId = ParamUtil.getLong(renderRequest, "userId", 0);
		
		long studentProfileId = ParamUtil.getLong(renderRequest, "studentProfileId", 0);
		
		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = themeDisplay.getScopeGroupId();
		
		try {
			if (userId > 0) {
				User user = UserLocalServiceUtil.getUserById(userId);
				String companyName = (String) user.getExpandoBridge().getAttribute("userCompany");
				renderRequest.setAttribute("companyName", companyName);
				studentProfile =_studentProfileService.getStudentProfileByGroupIdAndUserId(groupId, userId);
				renderRequest.setAttribute("logo", user.getPortraitURL(themeDisplay));
				renderRequest.setAttribute(
						"downloadCV", 
						DocumentLibraryUtil.getFileDownloadURL(
								themeDisplay, studentProfile.getCurriculumId()));
			}
		} catch (PortalException e) {
			log.error("Can't get studentProfile", e);
		}

		String province = StringPool.BLANK;

		List<Degree> degrees = _studentProfileService.getDegreesByOfferId(studentProfileId);
		
		try {
			province = RegionLocalServiceUtil.getRegion(studentProfile.getRegionId()).getName();
		} catch (PortalException e) {
			log.error("Error on get Region for regionID " + studentProfile.getRegionId(), e);
		}
		
		// Set studentProfile to the request attributes.
		renderRequest.setAttribute("degrees", degrees);
		renderRequest.setAttribute("studentProfile", studentProfile);
		renderRequest.setAttribute("province", province);
		
		return "/studentProfile/public/detail.jsp";
	}

	@Reference
	private StudentProfileService _studentProfileService;
	
	@Reference
	private RegionService _regionService;
	
	@Reference
	private UserService _userService;
	
	@Reference
	private CountryService _countryService;
	
	@Reference
	private DegreeService _degreeService;
}