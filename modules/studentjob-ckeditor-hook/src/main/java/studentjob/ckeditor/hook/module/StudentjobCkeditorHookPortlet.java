package studentjob.ckeditor.hook.module;

import studentjob.ckeditor.hook.constants.StudentjobCkeditorHookPortletKeys;

import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.Map;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author macia
 */
@Component(
	property = {
		"editor.name=ckeditor", 
		"javax.portlet.name=edu_uoc_mestemi_studentjob_web_portlet_StudentjobPortlet_COMPANYPROFILE_USER",
		"javax.portlet.name=edu_uoc_mestemi_studentjob_web_portlet_StudentjobPortlet_OFFER_ADMIN",
		"service.ranking:Integer=100"
	},

	service = EditorConfigContributor.class
)
public class StudentjobCkeditorHookPortlet extends BaseEditorConfigContributor {

	@Override
	public void populateConfigJSONObject(JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
			ThemeDisplay themeDisplay, RequestBackedPortletURLFactory requestBackedPortletURLFactory) {
		
		// https://help.liferay.com/hc/en-us/articles/360029527932-CKEditor-Plugin-Reference-Guide
		// https://help.liferay.com/hc/en-us/articles/360017882652-Modifying-an-Editor-s-Configuration
		System.out.println("into populateConfigJSONObject");
		
		jsonObject.put("allowedContent", false);
		jsonObject.put("extraPlugins","autolink,colordialog,stylescombo,addimages,justify,lfrpopup,media");
		
		String[][] myToolbar = {
				{"Undo", "Redo"},
				{"Styles", "Bold", "Italic", "Underline"},
				{"NumberedList","BulletedList"},
				{"JustifyLeft","JustifyCenter","JustifyRight"},
//				{"Link"},
				{"Image"}
		};

		JSONArray newToolbar = JSONFactoryUtil.createJSONArray(myToolbar);
		jsonObject.put("toolbar_studentsimple", newToolbar);
	}
}