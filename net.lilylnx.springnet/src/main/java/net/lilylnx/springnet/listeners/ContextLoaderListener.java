/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.listeners;

import javax.servlet.ServletContextEvent;

/**
 * Kế thừa từ ContextLoaderListener của SpringFramework.
 * 
 * @author Tien Nguyen
 * @version $Id: ContextLoaderListener.java,v 1.0 2011/06/27 19:35:53 lilylnx Exp $
 */
public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    super.contextInitialized(event);
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    super.contextDestroyed(event);
  }

}
