/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.domain;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.log4j.Logger;

/**
 * Lưu trữ thông tin về session của người dùng.
 * 
 * @author Tien Nguyen
 * @version $Id: UserSession.java,v 1.0 2011/08/17 1:13:19 lilylnx Exp $
 */
public class UserSession {

  private static final Logger LOG = Logger.getLogger(UserSession.class);

  private User user;
  private String sessionId;

  public UserSession() {}

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;

    if (user == null) {
      try {
        throw new RuntimeException("userSession.setUser with null value. See the stack trace for more information about the call stack. Session ID: "
            + this.sessionId);
      }
      catch (RuntimeException e) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        e.printStackTrace(printWriter);
        LOG.warn(writer.toString());
      }
    }
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

}
