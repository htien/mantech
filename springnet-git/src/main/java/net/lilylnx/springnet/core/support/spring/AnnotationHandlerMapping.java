/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.support.spring;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

import net.lilylnx.springnet.util.SpringConfig;

/**
 * @author Tien Nguyen
 * @version $Id: AnnotationHandlerMapping.java,v 1.0 2011/06/23 21:27:00 lilylnx Exp $
 */
public class AnnotationHandlerMapping extends DefaultAnnotationHandlerMapping {
  
  @Autowired
  private SpringConfig config;

  @Override
  protected void addUrlsForPath(Set<String> urls, String path) {
    if (path.equals("/")) {
      urls.add(path);
    }
    if (path.indexOf(".") == -1 && !path.endsWith("/") ) {
      urls.add(path + config.getServletExt());
    }
  }

}
