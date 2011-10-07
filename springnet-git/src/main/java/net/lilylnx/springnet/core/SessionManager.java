/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

import mantech.domain.UserSession;
import mantech.repository.SessionRepository;
import mantech.repository.UserRepository;

/**
 * Lớp quản lý session. Truy vấn mọi thông tin từ session người dùng.
 * 
 * @author Tien Nguyen
 * @version $Id: SessionManager.java,v 1.0 2011/06/26 19:54:07 lilylnx Exp $
 */
public class SessionManager {

  private static final Logger LOG = Logger.getLogger(SessionManager.class);
  private Map<String, UserSession> loggedSessions = new HashMap<String, UserSession>();
  private Map<String, UserSession> anonymousSessions = new HashMap<String, UserSession>();
  
  @Autowired
  private SpringConfig config;
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private SessionRepository sessionRepository;

  public UserSession refreshSession(HttpServletRequest request, HttpServletResponse response) {
    boolean isSSOAuthention = ConfigKeys.TYPE_SSO.equals(config.getString(ConfigKeys.AUTHENTICATION_TYPE));
    request.setAttribute("sso", isSSOAuthention);
    request.setAttribute("ssoLogout", config.getString(ConfigKeys.SSO_LOGOUT));
    return null;
  }
  
  public UserSession getUserSession(int sessionId) {
    UserSession us = anonymousSessions.get(sessionId);
    return us != null ? us : loggedSessions.get(sessionId);
  }

}
