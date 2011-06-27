/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.listeners;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.xml.DOMConfigurator;

import net.lilylnx.springnet.util.ConfigKeys;

/**
 * @author Tien Nguyen
 * @version $Id: FirstContextListener.java,v 1.0 2011/06/28 1:10:35 lilylnx Exp $
 */
public class FirstContextListener implements ServletContextListener {

  /* (non-Javadoc)
   * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println(String.format("+++ Initialized Servlet Context [%s]", sce.getServletContext()));
    try {
      loadLog4jPath();
    }
    catch (Exception e) {
      System.out.println(String.format("File 'log4j.xml' is not exist! --> [%s]", ConfigKeys.LOG4J_XML_PATH));
    }
  }

  /* (non-Javadoc)
   * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println(String.format("--- Destroyed Servlet Context [%s]", sce.getServletContext()));
  }
  
  /**
   * Nạp cấu hình 'log4j.xml'. Hàm này được thực thi ngay khi ServletContext
   * được khởi tạo.
   */
  private void loadLog4jPath() throws Exception {
    URL log4jXmlPath = this.getClass().getResource(ConfigKeys.LOG4J_XML_PATH);
    DOMConfigurator.configure(log4jXmlPath);
  }

}
