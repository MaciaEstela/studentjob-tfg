package edu.uoc.mestemi.studentjob.web.portlet.user.companyprofile.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.dto.CompanyProfileDTO;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.service.CompanyProfileService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

/**
 * MVC command for showing the companyProfiles list.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_COMPANYPROFILE_USER, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.LIST_COMPANYPROFILE_USER
	}, 
	service = MVCRenderCommand.class
)
public class ViewPublicCompanyProfilesMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewPublicCompanyProfilesMVCRenderCommand.class);

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		
		List<CompanyProfile> companyProfiles = _companyProfileService.getCompanyProfilesByGroupId(groupId);
		List<CompanyProfileDTO> companyProfilesDTO = new ArrayList<>();
		
		Locale locale = themeDisplay.getLocale();
		
		for (CompanyProfile companyProfile : companyProfiles) {
			try {
				User user = UserLocalServiceUtil.getUser(companyProfile.getUserId());
				String name = (String) user.getExpandoBridge().getAttribute(StudentjobConstants.USER_COMPANY);
				
				String portletURL = PortletURLBuilder.createRenderURL(
						renderResponse
					).setMVCRenderCommandName(
						MVCCommandNames.VIEW_COMPANYPROFILE_USER
					).setParameter(
						"companyProfileId", companyProfile.getCompanyProfileId()
					).buildString();
				
				companyProfilesDTO.add(
						new CompanyProfileDTO(
								name, 
								companyProfile.getSector(locale),
								portletURL,
								user.getPortraitURL(themeDisplay)
							)
						);
			} catch (PortalException e) {
				log.error("Error obtaining user", e);
			}
		}
		
		renderRequest.setAttribute("companyProfilesDTO", companyProfilesDTO);
		
		return "/companyProfile/public/list.jsp";
	}

	@Reference
	protected CompanyProfileService _companyProfileService;
}
