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

import net.lilylnx.springnet.core.SessionManager;
import net.lilylnx.springnet.extensions.RequestOperationChain;
import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

/**
 * Đây là Servlet chính, kế thừa từ {@link DispatcherServlet}
 * của SpringMVC dùng để điều khiển các modules của hệ thống,
 * dễ dàng thiết lập và tùy biến chức năng.
 * 
 * @author Tien Nguyen
 * @version $Id: SpringServlet.java,v 1.0 2011/06/22 15:30:33 lilylnx Exp $
 */
public class SpringServlet extends DispatcherServlet {

  private static final long serialVersionUID = 6672351209776527508L;
  
  private static final Logger LOG = Logger.getLogger(SpringServlet.class);
  private SpringConfig config;
  private SessionManager sessionManager;
  private RequestOperationChain operationChain;

  public SpringServlet() {}

  /**
   * Phương thức init() được thực hiện ngay sau khi servlet này được khởi tạo xong.
   * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
   */
  @Override
  public void init(ServletConfig config) throws ServletException {
    LOG.info(String.format("<< INITIALIZING [%s] >>", SpringServlet.class.getName()));

    super.init(config);

    // Đặt tên attribute cho ApplicationContext (được nạp vào ServletContext attribute)
    this.setContextAttribute(ConfigKeys.SPRING_CONTEXT);

    // Gán ApplicationContext vào ServletContext với SPRING_CONTEXT key
    ApplicationContext beanFactory = (ApplicationContext)this.getServletContext()
        .getAttribute(getServletContextAttributeName());
    this.getServletContext().setAttribute(ConfigKeys.SPRING_CONTEXT, beanFactory);

    this.config = beanFactory.getBean(SpringConfig.class);
    this.config.setProperty(ConfigKeys.APPLICATION_PATH, getServletContext().getRealPath(""));
    
    this.sessionManager = beanFactory.getBean(SessionManager.class);
    this.operationChain = beanFactory.getBean(RequestOperationChain.class);

    showStuff(beanFactory);

    LOG.info("<< COMPLETED! >>");
  }

  /**
   * Được thực thi với mỗi request từ client.
   * @see javax.servlet.Servlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      this.sessionManager.refreshSession(req, resp);
      this.operationChain.callAllOperations();
      super.service(req, resp);
    }
    finally {
      
    }
  }

  public void showStuff(ApplicationContext beanFactory) {
    LOG.info("--- Loaded beans:");
    for (String bean : beanFactory.getBeanDefinitionNames()) {
      LOG.info(bean);
    }
    LOG.info(String.format("Deployed in: %s", this.config.getString(ConfigKeys.APPLICATION_PATH)));
  }

}
