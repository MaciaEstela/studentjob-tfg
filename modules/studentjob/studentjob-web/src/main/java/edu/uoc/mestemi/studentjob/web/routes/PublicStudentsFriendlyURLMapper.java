package edu.uoc.mestemi.studentjob.web.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

@Component(
	property = {
			"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/public-students-routes.xml",
			"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_STUDENTPROFILE_USER
	},
	service = FriendlyURLMapper.class
)
public class PublicStudentsFriendlyURLMapper extends DefaultFriendlyURLMapper{
	@Override
	public String getMapping() {
		return MAPPING;
	}
	
	private static final String MAPPING = "view-student";
}
