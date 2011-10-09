/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.sso;

import java.util.Map;

import org.apache.commons.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;

import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.crypto.HashCryptorV1;

import mantech.domain.User;
import mantech.repository.UserRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: DefaultLoginAuthenticator.java,v 1.0 2011/09/03 4:00:30 lilylnx Exp $
 */
public class DefaultLoginAuthenticator implements LoginAuthenticator {
  
  @Autowired
  private UserRepository userRepo;

  /* (non-Javadoc)
   * @see net.lilylnx.springnet.LoginAuthenticator#validateLogin(java.lang.String, java.lang.String, java.util.Map)
   */
  @Override
  public User validateLogin(String unameOrEmail, String password, Map<String, Object> extraParams)
      throws Exception {

    boolean isEmail = EmailValidator.getInstance().isValid(unameOrEmail);
    String hashedPasswd = isEmail
        ? userRepo.getPasswordByEmail(unameOrEmail)
        : userRepo.getPasswordByUsername(unameOrEmail);

    if (hashedPasswd != null) {
      User user = (HashCryptorV1.verify(password, hashedPasswd, ConfigKeys.USERPWD_ALGOR)
          ? isEmail ? userRepo.getByEmail(unameOrEmail) : userRepo.getByUsername(unameOrEmail)
          : null);
      return (user != null && !user.isDeleted()) ? user : null;
    }

    return null;
  }

}