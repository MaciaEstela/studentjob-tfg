package edu.uoc.mestemi.studentjob.web.portlet.util;

import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.URLTemplateResource;

import java.util.Iterator;
import java.util.Map;

public class TemplateProcessor {
	
	private final URLTemplateResource urlTemplateResource;
	
	public TemplateProcessor(final String path) {
		urlTemplateResource = new URLTemplateResource(path, this.getClass().getResource(path));
	}
	
	/**
	 * Process a template and returns HTML code
	 *
	 * @param params			params to include in template
	 * @param templateType		template type defined by TemplateConstants
	 *
	 * @return String processed template in HTML code
	 */
	public String process(final Map<String, Object> params, String templateType) throws TemplateException {
		final Template template = TemplateManagerUtil.getTemplate(
				templateType, 
				urlTemplateResource, 
				false
			);
		
		if (params != null) {
			Iterator<String> it = params.keySet().iterator();
			
			while (it.hasNext()) {
				String key = it.next();
				template.put(key, params.get(key));
			}
		}
		
		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();
		template.processTemplate(unsyncStringWriter);
		
		return unsyncStringWriter.toString();
	}
	
	
}
