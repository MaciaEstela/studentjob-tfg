package edu.uoc.mestemi.studentjob.web.portlet.user.studentprofile.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.portlet.util.DTOUtil;
import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.dto.OfferDTO;
import edu.uoc.mestemi.studentjob.dto.StudentProfileDTO;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.service.StudentProfileService;
import edu.uoc.mestemi.studentjob.util.CountryA3Constants;
import edu.uoc.mestemi.studentjob.util.ProvinceUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

/**
 * MVC command for showing the studentProfiles list.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_STUDENTPROFILE_USER, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.LIST_STUDENTPROFILE_USER
	}, 
	service = MVCRenderCommand.class
)
public class ViewPublicStudentsMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewPublicStudentsMVCRenderCommand.class);

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		// Add studentProfile list related attributes.
		addStudentListAttributes(renderRequest, renderResponse);

		List<Region> regions = ProvinceUtil.getRegionsByCountryA3(companyId, CountryA3Constants.SPAIN, true);
		List<Degree> degrees = _degreeService.getDegreesByGroupId(groupId);
		
		renderRequest.setAttribute("regions", regions);
		renderRequest.setAttribute("preferences", StudentjobConstants.JOB_PREFERENCE);
		renderRequest.setAttribute("degrees", degrees);
		
		return "/studentProfile/user/list.jsp";
	}

	/**
	 * Adds assigment list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addStudentListAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = themeDisplay.getScopeGroupId();
		
		String orderByColModified =
			ParamUtil.getString(renderRequest, StudentjobConstants.ORDER_BY_COL, 
					StudentjobConstants.ORDER_MODIFIED_DATE);
		
		String orderByColCreated =
				ParamUtil.getString(renderRequest, StudentjobConstants.ORDER_BY_COL, 
						StudentjobConstants.ORDER_CREATE_DATE);
		
		String orderByType =
			ParamUtil.getString(renderRequest, StudentjobConstants.ORDER_BY_TYPE, StudentjobConstants.ORDER_ASC);

		// Create comparator

		OrderByComparator<StudentProfile> comparator =
			OrderByComparatorFactoryUtil.create(
				"StudentProfile", orderByColModified, !(StudentjobConstants.ORDER_ASC).equals(orderByType));

		String keywords = ParamUtil.getString(renderRequest, "keywords");

		
		List<StudentProfile> students =_studentProfileService.getStudentProfilesByKeywords(
				groupId, keywords, 0, StudentjobConstants.STUDENTS_OFFSET, comparator);
		
		List<StudentProfileDTO> studentProfilesDTO = new ArrayList<>();
		
		for (StudentProfile studentProfile : students) {
			try {
				String portletURL = PortletURLBuilder.createRenderURL(
						renderResponse
					).setMVCRenderCommandName(
						MVCCommandNames.VIEW_STUDENTPROFILE_USER
					).setParameter(
						"studentProfileId", studentProfile.getStudentProfileId()
					).buildString();
				
				studentProfilesDTO.add(DTOUtil.getStudentProfileDTOByStudentProfile(
						studentProfile, themeDisplay, portletURL));
				
			} catch (PortalException e) {
				log.error("Cant transform StudentProfile with id " + studentProfile.getStudentProfileId() + 
						" to a StudentProfileDTO Object", e);
			}
		}
		renderRequest.setAttribute("studentProfilesDTO", studentProfilesDTO);
		
		// Get newest studentProfileId to avoid duplicated results on pagination
		long newestStudentProfileId = 0;
		OrderByComparator<StudentProfile> comparatorCreated =
				OrderByComparatorFactoryUtil.create(
					"StudentProfile", orderByColCreated, !(StudentjobConstants.ORDER_ASC).equals(orderByType));
		
		List<StudentProfile> studentProfilesCreated = _studentProfileService.getStudentProfilesByKeywords(
				groupId, keywords, 0, 1,
				comparatorCreated);
		
		if (!studentProfilesCreated.isEmpty()) {
			newestStudentProfileId = studentProfilesCreated.get(0).getStudentProfileId();
		}
		
		renderRequest.setAttribute("newestStudentProfileId", newestStudentProfileId);
		
		renderRequest.setAttribute(
			"studentProfileCount", _studentProfileService.getStudentProfilesCountByKeywords(groupId, keywords));
	}

	@Reference
	protected StudentProfileService _studentProfileService;

	@Reference
	protected DegreeService _degreeService;
}
