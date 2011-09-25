/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.support.spring;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.lilylnx.springnet.util.SpringConfig;

/**
 * Lớp ViewResolver, chủ yếu tùy biến lại viewName.
 * 
 * @author Tien Nguyen
 * @version $Id: ViewResolver.java,v 1.0 2011/09/09 6:20:43 lilylnx Exp $
 */
public class ViewResolver extends InternalResourceViewResolver {

  @Autowired
  private SpringConfig config;

  /*
   * (non-Javadoc)
   * @see org.springframework.web.servlet.view.AbstractCachingViewResolver#resolveViewName(java.lang.String, java.util.Locale)
   */
  @Override
  public View resolveViewName(String viewName, Locale locale) throws Exception {
    boolean isView = viewName.startsWith(REDIRECT_URL_PREFIX) || viewName.startsWith(FORWARD_URL_PREFIX);
    if (isView && !viewName.endsWith("/")) {
      viewName += config.getServletExt();
    }
    return super.resolveViewName(viewName, locale);
  }

}
