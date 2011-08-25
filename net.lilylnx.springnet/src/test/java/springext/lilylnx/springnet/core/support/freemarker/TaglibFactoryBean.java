package springext.lilylnx.springnet.core.support.freemarker;

import freemarker.ext.jsp.TaglibFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * @version $Id: TaglibFactoryBean.java,v 1.1 2005/07/04 15:02:14 turelto Exp $
 */
public class TaglibFactoryBean extends AbstractFactoryBean<TaglibFactory>
    implements ServletContextAware {

  private ServletContext servletContext;

  public void setServletContext(ServletContext servletContext) {
    this.servletContext = servletContext;
  }

  public Class<TaglibFactory> getObjectType() {
    return TaglibFactory.class;
  }

  protected TaglibFactory createInstance() {
    return new TaglibFactory(servletContext);
  }
}
