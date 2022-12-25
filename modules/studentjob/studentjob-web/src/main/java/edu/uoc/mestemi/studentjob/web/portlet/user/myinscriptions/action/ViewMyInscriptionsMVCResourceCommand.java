package edu.uoc.mestemi.studentjob.web.portlet.user.myinscriptions.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

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
import edu.uoc.mestemi.studentjob.dto.OfferDTO;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferService;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferServiceUtil;
import edu.uoc.mestemi.studentjob.util.CountryA3Constants;
import edu.uoc.mestemi.studentjob.util.ProvinceUtil;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

/** 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_MYINSCRIPTIONS_USER, 
		"mvc.command.name=" + MVCCommandNames.MYINSCRIPTIONS_RESOURCE_COMMAND
	}, 
	service = MVCResourceCommand.class
)
public class ViewMyInscriptionsMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewMyInscriptionsMVCResourceCommand.class);
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		long userId = themeDisplay.getUserId();
		
		String cmd = ParamUtil.getString(resourceRequest, StudentjobConstants.CMD);
		
		log.info("ME LLAMAN");
		
		if (cmd.equals(MVCCommandNames.MYINSCRIPTIONS_CANCEL_INSCRIPTION_USER)) {
			long offerId = ParamUtil.getLong(resourceRequest, "offerId", 0);
			UserEnrollOfferServiceUtil.deleteEnrollOffer(offerId, userId);
			
			resourceResponse.setContentType("text/plain");
			resourceResponse.setCharacterEncoding("UTF-8");
			resourceResponse.getWriter().write("ok");
		}
	}
	
}
