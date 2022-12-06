package edu.uoc.mestemi.studentjob.register.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import edu.uoc.mestemi.studentjob.register.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterConstants;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + StudentjobRegisterPortletKeys.STUDENTJOB_REGISTER_VALIDATE,
				"mvc.command.name=" + MVCCommandNames.VALIDATE_RESOURCE_COMMAND
		},
		service = MVCResourceCommand.class
	)
	
public class UserValidationMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		String cmd = ParamUtil.getString(resourceRequest, StudentjobRegisterConstants.CMD);
		
		
	}


}
