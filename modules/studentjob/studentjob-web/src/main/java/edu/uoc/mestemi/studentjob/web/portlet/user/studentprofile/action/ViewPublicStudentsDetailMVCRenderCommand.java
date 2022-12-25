package edu.uoc.mestemi.studentjob.web.portlet.user.studentprofile.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.dto.StudentProfileDTO;
import edu.uoc.mestemi.studentjob.exception.NoSuchStudentProfileException;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.service.StudentProfileService;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferLocalServiceUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.portlet.util.DTOUtil;

/**
 * MVC Command for viewing studentProfile details
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_STUDENTPROFILE_USER,
		"mvc.command.name=" + MVCCommandNames.VIEW_STUDENTPROFILE_USER
	}, 
	service = MVCRenderCommand.class
)
public class ViewPublicStudentsDetailMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewPublicStudentsDetailMVCRenderCommand.class);
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		StudentProfile studentProfile = null;

		long studentProfileId = ParamUtil.getLong(renderRequest, "studentProfileId", 0);

		if (studentProfileId > 0) {
			try {
				// Call the service to get the studentProfile for show
				studentProfile = _studentProfileService.getStudentProfile(studentProfileId);
			}
			catch (NoSuchStudentProfileException nsoe) {
				log.error("Can't find data for StudentProfile with studentProfileId " + studentProfileId, nsoe);
			}
			catch (PortalException pe) {
				log.error("Error on rendering data for StudentProfile with studentProfileId " + studentProfileId, pe);
			}
		}
		
		if (studentProfile == null) {
			return ""; // TODO: Return 404
		}
		
		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		StudentProfileDTO studentProfileDTO = null;
		String province = StringPool.BLANK;
		
		try {
			province = RegionLocalServiceUtil.getRegion(studentProfile.getRegionId()).getName();	
		} catch (PortalException e) {
			log.error("Error on get Region for regionID " + studentProfile.getRegionId(), e);
		}
		
		try {
			studentProfileDTO = DTOUtil.getStudentProfileDTOByStudentProfile(studentProfile, themeDisplay, StringPool.BLANK);
		} catch (PortalException e) {
			log.error("Error on get StudentProfileDTO for studentProfileID " + studentProfile.getStudentProfileId(), e);
		}
		
		// Set studentProfile to the request attributes.
		renderRequest.setAttribute("studentProfile", studentProfile);
		renderRequest.setAttribute("studentProfileDTO", studentProfileDTO);
		renderRequest.setAttribute("province", province);
		
		return "/studentProfile/user/detail.jsp";
	}

	@Reference
	private StudentProfileService _studentProfileService;
}