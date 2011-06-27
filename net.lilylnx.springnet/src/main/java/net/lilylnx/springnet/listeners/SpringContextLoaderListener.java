/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.listeners;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;

/**
 * Kế thừa từ ContextLoaderListener của SpringFramework.
 * 
 * @author Tien Nguyen
 * @version $Id: SpringContextLoaderListener.java,v 1.0 2011/06/27 19:35:53 lilylnx Exp $
 */
public class SpringContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {

  private static final Logger logger = Logger.getLogger(SpringContextLoaderListener.class);

  @Override
  public void contextInitialized(ServletContextEvent event) {
    super.contextInitialized(event);
    logger.info(String.format("Listening..."));
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    super.contextDestroyed(event);
  }

}
