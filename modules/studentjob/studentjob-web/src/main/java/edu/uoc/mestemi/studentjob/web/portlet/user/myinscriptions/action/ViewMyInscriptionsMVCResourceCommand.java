package edu.uoc.mestemi.studentjob.web.portlet.user.myinscriptions.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;
import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferServiceUtil;
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
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		
		String cmd = ParamUtil.getString(resourceRequest, StudentjobConstants.CMD);
		
		if (cmd.equals(MVCCommandNames.MYINSCRIPTIONS_CANCEL_INSCRIPTION_USER)) {
			long offerId = ParamUtil.getLong(resourceRequest, "offerId", 0);
			UserEnrollOfferServiceUtil.deleteEnrollOffer(offerId, userId);
			
			resourceResponse.setContentType("text/plain");
			resourceResponse.setCharacterEncoding("UTF-8");
			resourceResponse.getWriter().write("ok");
		}
	}
	
}
