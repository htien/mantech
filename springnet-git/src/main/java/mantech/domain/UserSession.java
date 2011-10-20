/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.domain;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

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
  private long creationTime;
  private long lastAccessedTime;
  private long lastVisit;

  public UserSession() {}
  
  public void becomeAnonymous(int anonymountUserId) {
    this.clearAllAttributes();
    
    User user = new User();
    user.setId(anonymountUserId);
    this.setUser(user);
  }
  
  public void becomeLogged() {
    this.setAttribute(ConfigKeys.LOGGED, "1");
  }
  
  public boolean isLogged() {
    return "1".equals(this.getAttribute(ConfigKeys.LOGGED));
  }
  
  public void clearAllAttributes() {
    HttpSession session = this.getRequest().getSession();
    
    for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements();) {
      String key = e.nextElement();
      session.removeAttribute(key);
    }
  }
  
  /**
   * Convert this instance to a {@link Session}
   * @return
   */
  public Session asSession() {
    Session session = new Session();
    
    session.setUserId(this.user.getId());
    session.setIp(this.getIp());
    session.setStart(new Date(this.getCreationTime()));
    session.setLastAccessed(new Date(this.getLastAccessedTime()));
    session.setLastVisit(new Date(this.getLastVisit()));
    
    return session;
  }

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

  /**
   * Gets the session id related to this session.
   * 
   * @return A string with session id
   */
  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }
  
  /**
   * Gets user's session start time.
   * 
   * @return Start time in miliseconds
   */
  public long getCreationTime() {
    return this.creationTime;
  }
  
  public void setCreationTime(long start) {
    this.creationTime = start;
    this.lastAccessedTime = start;
    this.lastVisit = start;
  }
  
  /**
   * Gets user's last visit time.
   * 
   * @return Time in miliseconds
   */
  public long getLastAccessedTime() {
    return this.lastAccessedTime;
  }
  
  public Date getLastAccessedDate() {
    return new Date(this.getLastAccessedTime());
  }
  
  /**
   * @return The lastVisit as a date
   */
  public Date getLastVisitDate() {
    return new Date(this.lastVisit);
  }
  
  /**
   * @return the lastVisit
   */
  public long getLastVisit() {
    return this.lastVisit;
  }
  
  public void setLastVisit(long lastVisit) {
    this.lastVisit = lastVisit;
  }
  
  public String getIp() {
    if (new SpringConfig().getBoolean(ConfigKeys.BLOCK_IP)) {
      return null;
    }
    
    HttpServletRequest request = this.getRequest();
    
    String ip = request.getHeader("X-Pounded-For");
    
    if (ip != null) {
      return ip;
    }
    
    ip = request.getHeader("X-Forwarded-For");
    
    if (ip == null) {
      return request.getRemoteAddr();
    }
    else {
      // Process the IP to keep the last IP (real ip of the computer on the net)
      StringTokenizer tokenizer = new StringTokenizer(ip, ",");
      
      // Ignore all tokens, except the last one
      for (int i = 0; i < tokenizer.countTokens() - 1; i++) {
        tokenizer.nextElement();
      }
      
      ip = tokenizer.nextToken().trim();
      
      if (ip.equals("")) {
        ip = null;
      }
    }
    
    // If the ip is still null, we put 0.0.0.0 to void null values
    if (ip == null) {
      ip = "0.0.0.0";
    }
    
    return ip;
  }
  
  public boolean isBot() {
    return false;
  }
  
  public void ping() {
    this.lastAccessedTime = System.currentTimeMillis();
  }
  
  public Object getAttribute(String name) {
    return this.getRequest().getSession().getAttribute(name);
  }
  
  public void setAttribute(String name, Object value) {
    this.getRequest().getSession().setAttribute(name, value);
  }
  
  private HttpServletRequest getRequest() {
    RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
    return ((ServletRequestAttributes)attributes).getRequest();
  }
  
  @SuppressWarnings("unused")
  private HttpServletResponse getResponse() {
    RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
    return (HttpServletResponse)attributes.getAttribute(ConfigKeys.HTTP_SERVLET_RESPONSE, RequestAttributes.SCOPE_REQUEST);
  }

}
