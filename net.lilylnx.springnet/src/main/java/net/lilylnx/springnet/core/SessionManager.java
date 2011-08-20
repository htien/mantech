/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cncaptech.domains.UserSession;

/**
 * @author Tien Nguyen
 * @version $Id: SessionManager.java,v 1.0 2011/06/26 19:54:07 lilylnx Exp $
 */
public class SessionManager {

  @SuppressWarnings("unused")
  private static final Logger LOG = Logger.getLogger(SessionManager.class);

  public UserSession refreshSession(HttpServletRequest request, HttpServletResponse response) {
    return null;
  }

}
