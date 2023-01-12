package studentjob.language.portlet;

import com.liferay.portal.kernel.language.UTF8Control;
import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author macia
 */
@Component(
		property = {
				"language.id=ca_ES"
		},
		service = ResourceBundle.class
	)
public class StudentjobLanguageCaPortlet extends ResourceBundle {
	private final ResourceBundle resource = ResourceBundle.getBundle("content.Language_ca_ES", UTF8Control.INSTANCE);
	
	@Override
	public Enumeration<String> getKeys() {
		return resource.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		return resource.getObject(key);
	}
}
