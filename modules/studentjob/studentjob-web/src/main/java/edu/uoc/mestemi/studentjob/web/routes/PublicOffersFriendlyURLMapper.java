package edu.uoc.mestemi.studentjob.web.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

@Component(
	property = {
			"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/public-offers-routes.xml",
			"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_USER
	},
	service = FriendlyURLMapper.class
)
public class PublicOffersFriendlyURLMapper extends DefaultFriendlyURLMapper{
	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "offers";
}
