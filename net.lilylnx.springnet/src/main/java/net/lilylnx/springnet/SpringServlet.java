/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

/**
 * Đây là Servlet chính, kế thừa từ DispatcherServlet của SpringMVC dùng để
 * điều khiển các modules của hệ thống, dễ dàng thiết lập và tùy biến.
 * 
 * @author Tien Nguyen
 * @version $Id: SpringServlet.java,v 1.0 2011/06/22 15:30:33 lilylnx Exp $
 */
public class SpringServlet extends DispatcherServlet {

  private static final long serialVersionUID = -6852520526268983459L;

  private static final Logger logger = Logger.getLogger(SpringServlet.class);

  private SpringConfig config;

  public SpringServlet() {}

  /**
   * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
   */
  @Override
  public void init(ServletConfig config) throws ServletException {
    logger.info("<<< INITIALIZING THE MODULES >>>");

    super.init(config);

    // ContextAttribute name lúc đầu là null, nên gán ConfigKeys để thông qua đó
    // lấy được ApplicationContext dễ dàng
    this.setContextAttribute(ConfigKeys.SPRING_CONTEXT);

    // Gắn ApplicationContext vào ServletContext với ConfigKeys
    ApplicationContext beanFactory = (ApplicationContext)this.getServletContext()
      .getAttribute(this.getServletContextAttributeName());
    this.getServletContext().setAttribute(ConfigKeys.SPRING_CONTEXT, beanFactory);

    // Lấy SpringConfig từ tập tin cấu hình và gán đường dẫn thực của website vào đó
    this.config = (SpringConfig)beanFactory.getBean(SpringConfig.class.getName());
    
    String appPath = this.getServletContext().getRealPath("");
    logger.info(String.format("Deploy in [%s]", appPath));
    this.config.setProperty(ConfigKeys.APPLICATION_PATH, appPath);
    
    logger.info("<<< FINISHED >>>");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.service(req, resp);
  }

}
