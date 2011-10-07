/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;

import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: JTienTag.java,v 1.0 2011/10/06 20:35:24 lilylnx Exp $
 */
@Configurable
public abstract class JTienTag extends SimpleTagSupport {

  @Autowired
  private static ApplicationContext springnetContext;
  
  protected SpringConfig config() {
    return this.getBean(SpringConfig.class);
  }
  
  protected PageContext pageContext() {
    return (PageContext)this.getJspContext();
  }
  
  protected HttpServletRequest request() {
    return (HttpServletRequest)this.pageContext().getRequest();
  }
  
  protected HttpServletResponse response() {
    return (HttpServletResponse)this.pageContext().getResponse();
  }
  
  protected void setAttribute(String key, String value) {
    this.request().setAttribute(key, value);
  }
  
  protected void write(String content) throws IOException {
    this.pageContext().getOut().write(content);
  }
  
  protected void invokeJspBody() throws JspException, IOException {
    this.getJspBody().invoke(this.pageContext().getOut());
  }
  
  protected Object getBean(String beanId) {
    if (springnetContext == null) {
      springnetContext = (ApplicationContext)this.pageContext().getServletContext()
          .getAttribute(ConfigKeys.SPRING_CONTEXT);
    }
    return springnetContext != null ? springnetContext.getBean(beanId) : null;
  }
  
  @SuppressWarnings("unchecked")
  protected <T> T getBean(Class<T> c) {
    return (T)this.getBean(c.getName());
  }

}
