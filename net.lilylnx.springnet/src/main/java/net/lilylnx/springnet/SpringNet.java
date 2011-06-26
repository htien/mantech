/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Tien Nguyen
 * @version $Id: SpringNet.java,v 1.0 2011/06/26 17:08:02 lilylnx Exp $
 */
public class SpringNet implements ApplicationContextAware {
  
  private static ApplicationContext beanFactory;
  
  public SpringNet() {}

  public Object getComponent(String componentName) {
    return beanFactory.getBean(componentName);
  }

  /* (non-Javadoc)
   * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext)
      throws BeansException {
    beanFactory = applicationContext;
  }

}
