/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package springext.lilylnx.springnet.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import springext.lilylnx.springnet.core.support.freemarker.TaglibFreeMarkerView;

import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;
import freemarker.template.utility.StandardCompress;

/**
 * @author Tien Nguyen
 * @version $Id: SpringView.java,v 1.0 Aug 14, 2011 5:19:35 PM lilylnx Exp $
 */
public class SpringView extends TaglibFreeMarkerView {

	private static final StandardCompress compress = StandardCompress.INSTANCE;

	@Override
	protected void processTemplate(Template template, SimpleHash model,
			HttpServletResponse response) throws IOException, TemplateException {

		Map<String, TemplateBooleanModel> keys = new HashMap<String, TemplateBooleanModel>();
		keys.put("single_line", new TemplateBooleanModel() {

			@Override
			public boolean getAsBoolean() throws TemplateModelException {
				return true;
			}
		});

		template.process(model, compress.getWriter(response.getWriter(), keys));
	}

}
