/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.support.spring;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import net.lilylnx.springnet.util.ConfigKeys;

/**
 * @author Tien Nguyen
 * @version $Id: HttpServletResponseFactoryBean.java,v 1.0 Jun 26, 2011 6:47:05 PM lilylnx Exp $
 */
public class HttpServletResponseFactoryBean implements FactoryBean<Object> {

  @Override
  public Object getObject() throws Exception {
    RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
    return attributes.getAttribute(ConfigKeys.HTTP_SERVLET_RESPONSE, RequestAttributes.SCOPE_REQUEST);
  }

  @Override
  public Class<?> getObjectType() {
    return HttpServletResponse.class;
  }

  @Override
  public boolean isSingleton() {
    return false;
  }

}
