/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.support.spring;

import java.util.Set;

import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

/**
 * @author Tien Nguyen
 * @version $Id: MyAnnotationHandlerMapping.java,v 1.0 2011/06/23 21:27:00 lilylnx Exp $
 */
public class AnnotationHandlerMapping extends DefaultAnnotationHandlerMapping {

  @Override
  protected void addUrlsForPath(Set<String> urls, String path) {
    urls.add(path + ".htm");
  }

}
