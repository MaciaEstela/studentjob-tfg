package edu.uoc.mestemi.studentjob.web.util;

import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
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
	 * Return and add an ExpandoTable if not exists
	 *
	 * @param params		params to include in template
	 *
	 * @return String processed template in HTML code
	 */
	public String process(final Map<String, Object> params) throws TemplateException {
		final Template template = TemplateManagerUtil.getTemplate(
				TemplateConstants.LANG_TYPE_FTL, 
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
