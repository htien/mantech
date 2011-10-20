/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.sso;

import javax.servlet.http.HttpServletRequest;

import net.lilylnx.springnet.util.SpringConfig;

import mantech.domain.UserSession;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: SSO.java,v 1.0 2011/10/20 1:41:58 lilylnx Exp $
 */
public interface SSO {

  void setConfig(SpringConfig config);
  boolean isSessionValid(UserSession userSession, HttpServletRequest request);
  String authenticateUser(HttpServletRequest request);

}
