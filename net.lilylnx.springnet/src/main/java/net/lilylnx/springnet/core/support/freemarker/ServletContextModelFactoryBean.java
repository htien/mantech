package net.lilylnx.springnet.core.support.freemarker;

import freemarker.ext.servlet.ServletContextHashModel;
import freemarker.template.ObjectWrapper;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.*;
import java.util.Enumeration;

/**
 * @version $Id: ServletContextModelFactoryBean.java,v 1.1 2005/07/04 15:02:14 turelto Exp $
 */
public class ServletContextModelFactoryBean extends AbstractFactoryBean implements ServletContextAware {

  private ServletContext servletContext;

  public void setServletContext(ServletContext servletContext) {
    this.servletContext = servletContext;
  }

  public Class getObjectType() {
    return ServletContextHashModel.class;
  }

  protected Object createInstance() throws ServletException {
    GenericServlet dummyServlet = new DummyServlet();
    dummyServlet.init(new DummyServletConfig());
    return new ServletContextHashModel(dummyServlet, ObjectWrapper.DEFAULT_WRAPPER);
  }

  public class DummyServlet extends GenericServlet {

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {}
  }

  private class DummyServletConfig implements ServletConfig {

    public String getServletName() {
      return DummyServlet.class.getName();
    }

    public ServletContext getServletContext() {
      return servletContext;
    }

    public String getInitParameter(String distinguishedName) {
      return null;
    }

    public Enumeration getInitParameterNames() {
      return new Enumeration() {

        public boolean hasMoreElements() {
          return false;
        }

        public Object nextElement() {
          return null;
        }
      };
    }
  }
}
