package edu.uoc.mestemi.studentjob.web.portlet.admin.companyprofile.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.exception.CompanyProfileValidationException;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.service.CompanyProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.CompanyProfileService;
import edu.uoc.mestemi.studentjob.util.ProvinceUtil;
import edu.uoc.mestemi.studentjob.util.StudentjobUtilities;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for editing companyProfiles.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 *
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_COMPANYPROFILE_ADMIN,
		"mvc.command.name=" + MVCCommandNames.EDIT_COMPANYPROFILE_ADMIN_ACTION
	},
	service = MVCActionCommand.class
)
public class EditCompanyProfileMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(EditCompanyProfileMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(CompanyProfile.class.getName(), actionRequest);

		// Get parameters from the request.

		long companyProfileId = ParamUtil.getLong(actionRequest, "companyProfileId");
		CompanyProfile companyProfile = CompanyProfileLocalServiceUtil.getCompanyProfile(companyProfileId);
		long companyUserId = companyProfile.getUserId();

		Map<Locale, String> titleMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "title");
		
		Map<Locale, String> descriptionMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "description");
		
		Map<Locale, String> sectorMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "sector");
		
		boolean active = ParamUtil.getBoolean(actionRequest, "active", false);
		String email = ParamUtil.getString(actionRequest, "email");
		String website = ParamUtil.getString(actionRequest, "website");
		String regionCode = ParamUtil.getString(actionRequest, "region");
		long regionId = ProvinceUtil.getRegionId(
				ProvinceUtil.getCountryIdByCode(companyId, "ESP"), 
				regionCode);
		
		try {
			// Call the service to update the companyProfile
			_companyProfileService.updateCompanyProfile(
					companyProfileId,
					regionId,
					active,
					titleMap,
					descriptionMap,
					email,
					sectorMap,
					website,
					serviceContext);
			
			StudentjobUtilities.updateSocialMedia(groupId, actionRequest, 
					CompanyProfile.class.getName(), companyProfileId, serviceContext);
			
			if (!active)
				StudentjobUtilities.removeCompanyOffers(groupId, companyUserId);
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (CompanyProfileValidationException ove) {
			log.error("Error validating CompanyProfile edit with companyProfileId " + companyProfileId, ove);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_COMPANYPROFILE_ADMIN_ACTION);
		}
		catch (PortalException pe) {
			log.error("Error editing CompanyProfile with companyProfileId " + companyProfileId, pe);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.EDIT_COMPANYPROFILE_ADMIN_ACTION);
		}
	}

	@Reference
	protected CompanyProfileService _companyProfileService;
}