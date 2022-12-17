package edu.uoc.mestemi.studentjob.web.portlet.user.studentprofile.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.portlet.util.DTOUtil;
import edu.uoc.mestemi.studentjob.web.portlet.util.TemplateProcessor;
import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.dto.StudentProfileDTO;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
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
		"mvc.command.name=" + MVCCommandNames.STUDENTPROFILE_PUBLIC_RESOURCE_COMMAND
	}, 
	service = MVCResourceCommand.class
)
public class ViewPublicStudentsMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewPublicStudentsMVCRenderCommand.class);
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		
		String cmd = ParamUtil.getString(resourceRequest, StudentjobConstants.CMD);

		String degree = ParamUtil.getString(resourceRequest, "degree", StringPool.BLANK);
		String preference = ParamUtil.getString(resourceRequest, "preference", StringPool.BLANK);
		String region = ParamUtil.getString(resourceRequest, "region", StringPool.BLANK);
		String keywords = ParamUtil.getString(resourceRequest, "keywords", StringPool.BLANK);
		long newestStudentProfileId = ParamUtil.getLong(resourceRequest, "newestStudentProfileId", 0);
		
		long regionId = 0;
		long degreeId = 0;
		
		if (!region.trim().isEmpty()) {
			regionId = ProvinceUtil.getRegionId(
					ProvinceUtil.getCountryIdByCode(companyId, CountryA3Constants.SPAIN), region);
		}
		
		if (!degree.trim().isEmpty()) {
			degreeId = Long.valueOf(degree);
		}
		
		String orderByCol = StudentjobConstants.ORDER_MODIFIED_DATE;
		String orderByType = StudentjobConstants.ORDER_ASC;
		
		if (cmd.equals(MVCCommandNames.STUDENTPROFILE_PUBLIC_RESOURCE_COMMAND_GET_STUDENTS)) {
			
			OrderByComparator<StudentProfile> comparator =
					OrderByComparatorFactoryUtil.create(
						"StudentProfile", orderByCol, !(StudentjobConstants.ORDER_ASC).equals(orderByType));
			
			int start = ParamUtil.getInteger(resourceRequest, "start", 0);
			
			List<StudentProfile> studentProfiles =_studentProfileService.getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(
					themeDisplay.getScopeGroupId(), keywords, preference, regionId, degreeId, newestStudentProfileId, start, 
					start + StudentjobConstants.STUDENTS_OFFSET, comparator);
			
			PortletContext portletContext = resourceRequest.getPortletContext();
			
			String studentProfilesHTML = getProcessedHTMLStudentProfiles(studentProfiles, 
					themeDisplay, portletContext, resourceResponse);
			
			resourceResponse.setContentType("text/html");
			resourceResponse.setCharacterEncoding("UTF-8"); 
			resourceResponse.getWriter().write(studentProfilesHTML);
			
		} else if (cmd.equals(MVCCommandNames.STUDENTPROFILE_PUBLIC_RESOURCE_COMMAND_AUX_DATA)) {
			
			orderByCol = StudentjobConstants.ORDER_CREATE_DATE;
			
			OrderByComparator<StudentProfile> comparatorCreate =
					OrderByComparatorFactoryUtil.create(
						"StudentProfile", orderByCol, !(StudentjobConstants.ORDER_ASC).equals(orderByType));
			
			List<StudentProfile> studentProfiles =_studentProfileService.getStudentProfilesByKeywordsAndPreferenceAndRegionIdAndDegreeId(
					themeDisplay.getScopeGroupId(), keywords, preference, regionId, degreeId, 0, 0, 1,
					comparatorCreate);
			
			JSONObject dataJson = JSONFactoryUtil.createJSONObject();
			long studentProfileCount = _studentProfileService.getStudentProfilesCountByKeywordsAndPreferenceAndRegionIdAndDegreeId(
					themeDisplay.getScopeGroupId(), keywords, preference, regionId, degreeId, 0);
			
			if (!studentProfiles.isEmpty()) {
				dataJson.put("newestStudentProfileId", String.valueOf(studentProfiles.get(0).getStudentProfileId()));
				dataJson.put("studentProfileCount", String.valueOf(studentProfileCount));
				
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("UTF-8");
				resourceResponse.getWriter().write(dataJson.toString());
			}
			
		}
	}
	
	private String getProcessedHTMLStudentProfiles(List<StudentProfile> studentProfiles, ThemeDisplay themeDisplay, 
			PortletContext portletContext, ResourceResponse resourceResponse) {
		
		StringBuilder studentProfilesHTML = new StringBuilder(StringPool.BLANK);
		
		for (StudentProfile studentProfile : studentProfiles) {
			studentProfilesHTML.append(getProcessedStudentProfileDTOTemplate(studentProfile, 
					themeDisplay, portletContext, resourceResponse));
		}
		
		return studentProfilesHTML.toString();
	}
	
	private String getProcessedStudentProfileDTOTemplate(StudentProfile studentProfile, ThemeDisplay themeDisplay, 
			PortletContext portletContext, ResourceResponse resourceResponse) {
		String studentProfileDTOHtml = StringPool.BLANK;
		try {
			Map<String,Object> params = new HashMap<>();
			
			String portletURL = PortletURLBuilder.createRenderURL(
					resourceResponse
				).setMVCRenderCommandName(
					MVCCommandNames.VIEW_STUDENTPROFILE_USER
				).setParameter(
					"studentProfileId", studentProfile.getStudentProfileId()
				).buildString();
			
			StudentProfileDTO studentProfileDTO = DTOUtil.getStudentProfileDTOByStudentProfile(studentProfile, themeDisplay, portletURL); 
			
			TemplateProcessor templateProcessor = new TemplateProcessor(
					portletContext.getResource("/studentProfile/user/card_aux_3.ftl").getPath()
				);
			params.put("student", studentProfileDTO);
			studentProfileDTOHtml = templateProcessor.process(params, TemplateConstants.LANG_TYPE_FTL);
			
		} catch (PortalException | MalformedURLException e) {
			log.error("Cant transform StudentProfile with id " + studentProfile.getStudentProfileId() + " to a StudentProfileDTO Object", e);
		}
		
		return studentProfileDTOHtml;
	}
	
	@Reference
	protected StudentProfileService _studentProfileService;
}
