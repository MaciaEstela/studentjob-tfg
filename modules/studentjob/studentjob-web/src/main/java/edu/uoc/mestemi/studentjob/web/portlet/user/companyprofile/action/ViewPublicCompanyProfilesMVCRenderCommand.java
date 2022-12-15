package edu.uoc.mestemi.studentjob.web.portlet.user.companyprofile.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.web.dto.CompanyProfileDTO;
import edu.uoc.mestemi.studentjob.web.dto.OfferDTO;
import edu.uoc.mestemi.studentjob.web.util.StudentJobUtil;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.service.CompanyProfileService;
import edu.uoc.mestemi.studentjob.service.DegreeAreaService;
import edu.uoc.mestemi.studentjob.service.DegreeService;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.service.StudentProfileService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobConstants;

/**
 * MVC command for showing the offers list.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_VIEW_COMPANYPROFILE_USER, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.LIST_COMPANYPROFILE_PUBLIC
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
				String name = (String) user.getExpandoBridge().getAttribute("userCompany");
				
				String portletURL = PortletURLBuilder.createRenderURL(
						renderResponse
					).setMVCRenderCommandName(
						MVCCommandNames.VIEW_COMPANYPROFILE_PUBLIC
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
