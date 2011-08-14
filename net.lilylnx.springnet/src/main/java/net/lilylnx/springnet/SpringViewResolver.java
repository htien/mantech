/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet;

import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * @author Tien Nguyen
 * @version $Id: SpringViewResolver.java,v 1.0 Aug 14, 2011 5:12:30 PM lilylnx Exp $
 */
public class SpringViewResolver extends FreeMarkerViewResolver {
	
	/**
	 * Requires {@link SpringView}.
	 */
	@Override
	protected Class<SpringView> requiredViewClass() {
		return SpringView.class;
	}

}
