package edu.uoc.mestemi.studentjob.web.portlet.admin;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.model.Portlet;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author macia
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=1",
		"panel.category.key=studentjob-adminpanel"
	},
	service = PanelApp.class
)
public class StudentjobPortletDegreeAreaPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return StudentjobPortletKeys.STUDENTJOB_DEGREEAREA_ADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_DEGREEAREA_ADMIN+ ")", unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("content.Language", locale, UTF8Control.INSTANCE);
		return LanguageUtil.get(resourceBundle, "javax.portlet.title." + StudentjobPortletKeys.STUDENTJOB_DEGREEAREA_ADMIN);
	}
}