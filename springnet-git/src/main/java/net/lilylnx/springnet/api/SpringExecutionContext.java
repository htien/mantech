/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;

import net.lilylnx.springnet.util.ConfigKeys;

/**
 * Class cơ bản được dùng để thực thi Spring code trong môi trường khác.
 * 
 * @author Tien Nguyen
 * @version $Id: SpringExecutionContext.java,v 1.0 2011/06/24 1:14:36 lilylnx Exp $
 */
public abstract class SpringExecutionContext {

  private ApplicationContext context;
  private HttpServletRequest request;
  private boolean initialized;

  public SpringExecutionContext(HttpServletRequest request) {
    this.request = request;
    this.context = (ApplicationContext)request.getSession().getServletContext()
      .getAttribute(ConfigKeys.SPRING_CONTEXT);

    this.initialized = this.context != null;
  }
  
  public abstract void execute();
  
  protected HttpServletRequest getRequest() {
    return this.request;
  }
  
  /**
   * Kiểm tra ApplicationContext của SpringNet được khởi tạo và sẵn sàng sử dụng.
   * @return true Nếu SpringNet đã sẵn sàng để dùng
   */
  protected boolean isInitialized() {
    return this.initialized;
  }

  @SuppressWarnings("unchecked")
  protected <T> T getComponent(Class<T> k) {
    return (T)this.context.getBean(k.getClass());
  }

}
