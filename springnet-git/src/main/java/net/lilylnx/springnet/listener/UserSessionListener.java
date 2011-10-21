/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import net.lilylnx.springnet.core.SessionManager;
import net.lilylnx.springnet.util.ConfigKeys;

/**
 * Lớp dùng để nghe ngóng session của người dùng.
 * Cụ thể khi 1 người dùng mở 1 phiên làm việc của họ trên website,
 * hoặc khi session kết thúc thì hệ thống sẽ thực thi phương thức tương ứng
 * cùng với việc tạo/hủy session.
 * 
 * @author Tien Nguyen
 * @version $Id: UserSessionListener.java,v 1.0 2011/08/21 8:07:49 lilylnx Exp $
 */
public class UserSessionListener implements HttpSessionListener {
  
  private static final Logger LOG = Logger.getLogger(UserSessionListener.class);

  /* (non-Javadoc)
   * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
   */
  @Override
  public void sessionCreated(HttpSessionEvent event) {
  }

  /* (non-Javadoc)
   * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
   */
  @Override
  public void sessionDestroyed(HttpSessionEvent event) {
    HttpSession session = event.getSession();
    
    if (session == null) {
      return;
    }
    
    LOG.info("Destroying session " + session.getId());
    
    ApplicationContext beanFactory = (ApplicationContext)session.getServletContext()
        .getAttribute(ConfigKeys.SPRING_CONTEXT);
    
    if (beanFactory == null) {
      LOG.warn("Spring Context was not found. This may cause problems with unregistered user sessions");
    }
    else {
      String sessionId = session.getId();
      
      SessionManager sessionManager = beanFactory.getBean(SessionManager.class);
      
      try {
        sessionManager.storeSession(sessionId);
      }
      catch (Exception e) {}
      
      sessionManager.remove(sessionId);
    }
  }

}
