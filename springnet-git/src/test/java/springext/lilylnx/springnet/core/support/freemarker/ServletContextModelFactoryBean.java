package springext.lilylnx.springnet.core.support.freemarker;

import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.web.context.ServletContextAware;

import freemarker.ext.servlet.ServletContextHashModel;
import freemarker.template.ObjectWrapper;

/**
 * @version $Id: ServletContextModelFactoryBean.java,v 1.1 2005/07/04 15:02:14 turelto Exp $
 */
public class ServletContextModelFactoryBean extends AbstractFactoryBean<ServletContextHashModel>
    implements ServletContextAware {

  private ServletContext servletContext;

  public void setServletContext(ServletContext servletContext) {
    this.servletContext = servletContext;
  }

  public Class<ServletContextHashModel> getObjectType() {
	  return ServletContextHashModel.class;
  }

  protected ServletContextHashModel createInstance() throws ServletException {
    GenericServlet dummyServlet = new DummyServlet();
    dummyServlet.init(new DummyServletConfig());
    return new ServletContextHashModel(dummyServlet, ObjectWrapper.DEFAULT_WRAPPER);
  }

  public class DummyServlet extends GenericServlet {
    private static final long serialVersionUID = 1L;
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

    @SuppressWarnings({ "rawtypes", "unchecked" })
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
