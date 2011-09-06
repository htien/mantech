/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.sso;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import mantech.domain.User;
import mantech.repository.UserRepository;

/**
 * @author Tien Nguyen
 * @version $Id: DefaultLoginAuthenticator.java,v 1.0 Sep 3, 2011 4:00:30 AM lilylnx Exp $
 */
public class DefaultLoginAuthenticator implements LoginAuthenticator {
  
  @Autowired
  private UserRepository userRepository;

  /*
   * (non-Javadoc)
   * @see net.lilylnx.springnet.LoginAuthenticator#validateUser(java.lang.String, java.lang.String, java.util.Map)
   */
  @Override
  public User validateUser(String username, String password, Map<String, Object> extraParams) {
//    User user = userRepository.validateUser(username, password);
//    return (user != null && !user.isDeleted()) ? user : null;
    return null;
  }

}
