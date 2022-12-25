package edu.uoc.mestemi.studentjob.web.portlet.admin;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.language.UTF8Control;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

@Component(
immediate = true,
property = {
	"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION,
	"panel.category.order:Integer=300"
},
service = PanelCategory.class)

public class StudentJobPanelCategory extends BasePanelCategory {

	@Override
	public String getKey() {
		return "studentjob-adminpanel";
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("content.Language", locale, UTF8Control.INSTANCE);
		return LanguageUtil.get(resourceBundle, "studentjob-adminpanel");
	}
} 