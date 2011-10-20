/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.service;

import org.springframework.beans.factory.annotation.Autowired;

import net.lilylnx.springnet.sso.LoginAuthenticator;

import mantech.domain.User;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: LoginService.java,v 1.0 2011/10/02 23:05:34 lilylnx Exp $
 */
public class LoginService {
  
  @Autowired
  private LoginAuthenticator loginAuthenticator;
  
  public User authenticate(String username, String passwd) throws Exception {
    return loginAuthenticator.validateLogin(username, passwd, null);
  }

}
