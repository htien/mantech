/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.listener;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

/**
 * Kế thừa từ ContextLoaderListener của SpringFramework.
 * 
 * @author Tien Nguyen
 * @version $Id: SpringContextLoaderListener.java,v 1.0 2011/06/27 19:35:53 lilylnx Exp $
 */
public class SpringListener extends ContextLoaderListener {

  private static final Logger LOG = Logger.getLogger(SpringListener.class);

  @Override
  public void contextInitialized(ServletContextEvent event) {
    super.contextInitialized(event);
    LOG.info("Starting");
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    super.contextDestroyed(event);
    LOG.info("End");
  }

}
