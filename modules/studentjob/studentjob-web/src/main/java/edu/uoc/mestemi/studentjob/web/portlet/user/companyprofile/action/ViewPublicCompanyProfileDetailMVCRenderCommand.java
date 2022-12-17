package edu.uoc.mestemi.studentjob.web.portlet.user.companyprofile.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.service.CompanyProfileService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Command for viewing companyProfile details
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_COMPANYPROFILE_USER,
		"mvc.command.name=" + MVCCommandNames.VIEW_COMPANYPROFILE_USER
	}, 
	service = MVCRenderCommand.class
)
public class ViewPublicCompanyProfileDetailMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewPublicCompanyProfileDetailMVCRenderCommand.class);
	
	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		CompanyProfile companyProfile = null;
		long userId = ParamUtil.getLong(renderRequest, "userId", 0);
		
		long companyProfileId = ParamUtil.getLong(renderRequest, "companyProfileId", 0);
		
		if (companyProfileId != 0) {
			try {
				companyProfile = _companyProfileService.getCompanyProfile(companyProfileId);
				userId = companyProfile.getUserId();
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = themeDisplay.getScopeGroupId();
		
		try {
			if (userId > 0) {
				//TODO: ARREGLAR EL CODI
				User user = UserLocalServiceUtil.getUserById(userId);
				String companyName = (String) user.getExpandoBridge().getAttribute(
						StudentjobConstants.USER_COMPANY);
				
				renderRequest.setAttribute("companyName", companyName);
				companyProfile =_companyProfileService.getCompanyProfileByGroupIdAndUserId(groupId, userId);
				renderRequest.setAttribute("logo", user.getPortraitURL(themeDisplay));
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

		String province = StringPool.BLANK;
		
		try {
			province = RegionLocalServiceUtil.getRegion(companyProfile.getRegionId()).getName();
		} catch (PortalException e) {
			log.error("Error on get Region for regionID " + companyProfile.getRegionId(), e);
		}
		
		// Set companyProfile to the request attributes.
		renderRequest.setAttribute("companyProfile", companyProfile);
		renderRequest.setAttribute("province", province);
		
		return "/companyProfile/public/detail.jsp";
	}

	@Reference
	private CompanyProfileService _companyProfileService;
}