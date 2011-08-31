/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.support.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Tien Nguyen
 * @version $Id: HttpServletRequestFactoryBean.java,v 1.0 Jun 26, 2011 6:06:59 PM lilylnx Exp $
 */
public class HttpServletRequestFactoryBean implements FactoryBean<Object> {

  @Override
  public Object getObject() throws Exception {
    RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
    return ((ServletRequestAttributes)attributes).getRequest();
  }

  @Override
  public Class<?> getObjectType() {
    return HttpServletRequest.class;
  }

  @Override
  public boolean isSingleton() {
    return false;
  }

}
