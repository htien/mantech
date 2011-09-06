/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

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

  /* (non-Javadoc)
   * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
   */
  @Override
  public void sessionCreated(HttpSessionEvent se) {
  }

  /* (non-Javadoc)
   * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
   */
  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
  }

}
