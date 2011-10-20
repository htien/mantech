/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.sso;

import javax.servlet.http.HttpServletRequest;

import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

import mantech.domain.UserSession;

/**
 * Simple SSO authenticator. This class will try to validate an user
 * by simple checking <code>request.getRemoteUser()</code> is not null.
 * 
 * @author Tien Nguyen
 * @version $Id: RemoteUserSSO.java,v 1.0 2011/10/20 1:41:15 lilylnx Exp $
 */
public class RemoteUserSSO implements SSO {
  
  private SpringConfig config;

  /* (non-Javadoc)
   * @see net.lilylnx.springnet.sso.SSO#setConfig(net.lilylnx.springnet.util.SpringConfig)
   */
  @Override
  public void setConfig(SpringConfig config) {
    this.config = config;
  }

  /* (non-Javadoc)
   * @see net.lilylnx.springnet.sso.SSO#isSessionValid(mantech.domain.UserSession, javax.servlet.http.HttpServletRequest)
   */
  @Override
  public boolean isSessionValid(UserSession userSession, HttpServletRequest request) {
    String remoteUser = request.getRemoteUser();
    
    // user đã từng logout
    if (remoteUser == null && userSession.getUser().getId() != this.config.getInt(ConfigKeys.ANONYMOUS_USER_ID)) {
      return false;
    }
    // user đã từng login
    else if (remoteUser != null && userSession.getUser().getId() == this.config.getInt(ConfigKeys.ANONYMOUS_USER_ID)) {
      return false;
    }
    // người dùng đã thay đổi user
    else if (remoteUser != null && !remoteUser.equals(userSession.getUser().getUsername())) {
      return false;
    }

    return true;
  }

  /* (non-Javadoc)
   * @see net.lilylnx.springnet.sso.SSO#authenticateUser(javax.servlet.http.HttpServletRequest)
   */
  @Override
  public String authenticateUser(HttpServletRequest request) {
    return request.getRemoteUser();
  }

}
