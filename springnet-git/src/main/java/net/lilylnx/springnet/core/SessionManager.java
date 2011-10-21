/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;

import net.lilylnx.springnet.core.exception.SpringException;
import net.lilylnx.springnet.sso.SSO;
import net.lilylnx.springnet.sso.SSOUtils;
import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

import mantech.domain.Session;
import mantech.domain.User;
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
  
  /**
   * Register a new {@link UserSession}
   * 
   * @param userSession The user session to add
   */
  public synchronized void add(UserSession userSession) {
    if (StringUtils.isEmpty(userSession.getSessionId())) {
      throw new SpringException("An UserSession instance must have a session ID.");
    }
    
    if (!userSession.isBot()) {
      this.preventDupplicates(userSession);
      
      if (userSession.getUser().getId() == this.config.getInt(ConfigKeys.ANONYMOUS_USER_ID)) {
        this.anonymousSessions.put(userSession.getSessionId(), userSession);
      }
      else {
        UserSession existing = this.isUserInSession(userSession.getUser().getId());
        
        if (existing != null) {
          userSession.setLastVisit(existing.getLastVisit());
          this.remove(existing.getSessionId());
        }
        else {
          Session session = this.sessionRepository.get(userSession.getUser().getId());
          
          if (session != null && session.getLastVisit() != null) {
            userSession.setLastVisit(session.getLastVisit().getTime());
          }
        }
        
        //this.checkIfIsModerator(userSession);
        
        this.loggedSessions.put(userSession.getSessionId(), userSession);
      }
    }
  }
  
  /**
   * Remove an entry for the session map.
   * 
   * @param sessionId The session id to remove
   */
  public synchronized void remove(String sessionId) {
    if (this.loggedSessions.containsKey(sessionId)) {
      this.loggedSessions.remove(sessionId);
    }
    else {
      this.anonymousSessions.remove(sessionId);
    }
  }

  public UserSession refreshSession(HttpServletRequest request, HttpServletResponse response) {
    boolean isSSOAuthention = ConfigKeys.TYPE_SSO.equals(config.getString(ConfigKeys.AUTHENTICATION_TYPE));
    request.setAttribute("sso", isSSOAuthention);
    request.setAttribute("ssoLogout", config.getString(ConfigKeys.SSO_LOGOUT));
    
    UserSession userSession = this.getUserSession(request.getSession().getId());
    int anonymousUserId = this.config.getInt(ConfigKeys.ANONYMOUS_USER_ID);
    
    if (userSession == null) {
      userSession = new UserSession();
      userSession.setSessionId(request.getSession().getId());
      userSession.setCreationTime(System.currentTimeMillis());
      
      //if (SpringExecutionContext.getSpringContext().isBot()) {
      if (true) {
        if (isSSOAuthention) {
          this.checkSSO(userSession, request);
        }
        else {
          boolean autoLoginEnabled = this.config.getBoolean(ConfigKeys.AUTO_LOGIN_ENABLED);
          boolean autoLoginSuccess = autoLoginEnabled && this.checkAutoLogin(userSession);
          
          if (!autoLoginSuccess) {
            userSession.becomeAnonymous(anonymousUserId);
            userSession.setUser(this.userRepository.get(anonymousUserId));
          }
        }
      }
      
      this.add(userSession);
      
      LOG.info("Registered user userSession: " + request.getSession().getId());
    }
    else if (isSSOAuthention) {
      SSO sso;
      
      try {
        sso = (SSO)Class.forName(this.config.getString(ConfigKeys.SSO_IMPLEMENTATION)).newInstance();
      }
      catch (Exception e) {
        throw new SpringException(e);
      }
      
      // Check if the session if valid
      if (!sso.isSessionValid(userSession, request)) {
        User user = userSession.getUser();
        
        LOG.info("sso session is no longer valid. Forcing a refresh. username is " + (user != null ? user.getUsername() : "returned null")
            + ", springUserId is " + (user != null ? user.getId() : "returned null") + ". Session ID: " + request.getSession().getId());
        
        // If the session is not valid, create a new one
        this.remove(userSession.getSessionId());
        return this.refreshSession(request, response);
      }
      else {
        if (userSession.getUser().getId() == 0) {
          LOG.warn("isSSOAuthentication -> get user from repository using user.id equals to zero.");
        }
        
        // FIXME: Force a reload of the user instance, because if it's kept in the usersession,
        // changes made to the group (like permissions) won't be seen.
        User user = this.userRepository.get(userSession.getUser().getId());
        
        if (user == null) {
          // FIXME: now what? we didn't find the user, so something must be wrong
          LOG.warn(String.format("refreshSession did not find an user that should be registered. jforumUserId is %d, session ID is %s",
              userSession.getUser().getId(), request.getSession().getId()));
        }
        else {
          userSession.setUser(user);
        }
      }
    }
    else {
      // FIXME: Force a reload of the user instance, because if it's kept in the usersession,
      // changes made to the group (like permissions) won't be seen.
      userSession.setUser(this.userRepository.get(userSession.getUser().getId()));
    }
    
    userSession.ping();
    
    if (userSession.getUser() == null || userSession.getUser().getId() == 0) {
      LOG.warn("After userSession.ping() -> userSession.getUser returned null or user.id is zero. " +
        "User is null? " + ( userSession.getUser() == null ) + ". user.id is: "
          + (userSession.getUser() == null ? "getUser() returned null" : userSession.getUser().getId())
          + ". As we have a problem, will force the user to become anonymous. Session ID: " + request.getSession().getId());
      userSession.becomeAnonymous(anonymousUserId);

      User anonymousUser = this.userRepository.get(userSession.getUser().getId());

      if (anonymousUser == null) {
        LOG.warn("Could not find the anonymous user in the database. Tried using id " + anonymousUserId);
      }
      else {
        userSession.setUser(anonymousUser);
      }
    }
    
    // TODO: setRoleManager
    
    return userSession;
  }
  
  /**
   * Persist the user session to the database.
   * 
   * @param sessionId The id of the session to persist
   */
  public void storeSession(String sessionId) {
    UserSession userSession = this.getUserSession(sessionId);
    
    if (userSession != null && userSession.getUser().getId() != this.config.getInt(ConfigKeys.ANONYMOUS_USER_ID)) {
      Session session = userSession.asSession();
      session.setLastVisit(session.getLastAccessed());
      this.sessionRepository.add(session);
    }
  }
  
  /**
   * Return the {@link UserSession} associated to the current thread.
   * @return The user session
   */
  public UserSession getUserSession() {
    return this.getUserSession(RequestContextHolder.currentRequestAttributes().getSessionId());
  }
  
  /**
   * Gets an {@link UserSession} by the session id.
   * 
   * @param sessionId The session's id
   * @return The user session
   */
  public UserSession getUserSession(String sessionId) {
    UserSession us = anonymousSessions.get(sessionId);
    return us != null ? us : loggedSessions.get(sessionId);
  }
  
  public User getUser() {
    return this.getUserSession().getUser();
  }
  
  /**
   * Gets the number of session elements.
   * 
   * @return The number of session elements currently online (without bots)
   */
  public int getTotalUsers() {
    return this.anonymousSessions.size() + this.loggedSessions.size();
  }
  
  /**
   * Check if a given user is in the session.
   * 
   * @param userId The user id to check for existance in the session
   * @return The respective {@link UserSession} if the user is already registered, or <code>null</code> otherwise.
   */
  public UserSession isUserInSession(int userId) {
    for (UserSession us : this.loggedSessions.values()) {
      if (us.getUser().getId() == userId) {
        return us;
      }
    }

    return null;
  }

  /**
   * Checks for user authentication using some SSO implementation.
   * 
   * @param userSession UserSession
   * @param request
   */
  private void checkSSO(UserSession userSession, HttpServletRequest request) {
    try {
      SSO sso = (SSO)Class.forName(this.config.getString(ConfigKeys.SSO_IMPLEMENTATION)).newInstance();
      sso.setConfig(this.config);
      String username = sso.authenticateUser(request);
      
      LOG.info(String.format("SSO authenticated an user with username %s. Session ID %s", username, request.getSession().getId()));
      
      if (StringUtils.isEmpty(username)) {
        LOG.warn(String.format("checkSSO found an empty / null username. Going anonymous. Session ID %s", request.getSession().getId()));
        userSession.becomeAnonymous(this.config.getInt(ConfigKeys.ANONYMOUS_USER_ID));
      }
      else {
        SSOUtils utils = new SSOUtils(userRepository);
        boolean userExists = utils.userExists(username);
        
        LOG.info(String.format("SSO user %s exists? %s", username, userExists));
        
        if (!userExists) {
          String email = (String)userSession.getAttribute(this.config.getString(ConfigKeys.SSO_EMAIL_ATTRIBUTE));
          String password = (String)userSession.getAttribute(this.config.getString(ConfigKeys.SSO_PASSWORD_ATTRIBUTE));
          
          if (email == null) {
            email = this.config.getString(ConfigKeys.SSO_DEFAULT_EMAIL);
          }
          
          if (password == null) {
            password = this.config.getString(ConfigKeys.SSO_DEFAULT_PASSWORD);
          }
          
          utils.register(email, password);
        }
        
        User user = utils.getUser();
        
        LOG.info(String.format("g: username=%s, springUserId=%s",
            user != null ? user.getUsername() : "returned null",
            user != null ? user.getId() : "returned null"));
        
        this.configureUserSession(userSession, user);
        
        if (user == null || user.getId() == 0) {
          LOG.warn("checkSSO -> utils.getUser() returned null or user.id is zero");
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      throw new SpringException("Error while executing SSO actions: " + e, e);
    }
  }
  
  /**
   * Checks user credentials / automatic login.
   * 
   * @param userSession The UserSession instance associated to the user's session
   * @return <code>true</code> if auto login was enabled and the user was successfully logged in
   */
  private boolean checkAutoLogin(UserSession userSession) {
    // TODO
    return false;
  }
  
  /**
   * Setup options and values for the user's session if authentication was ok.
   * 
   * @param userSession The UserSession instance of the user
   * @param user The User instance of the authenticated user
   */
  private void configureUserSession(UserSession userSession, User user) {
    userSession.setUser(user);
    userSession.becomeLogged();
  }
  
  /**
   * Make sure we'll not add a session that was already registered.
   * @param us
   */
  private void preventDupplicates(UserSession us) {
    if (this.getUserSession(us.getSessionId()) != null) {
      this.remove(us.getSessionId());
    }
  }

}
