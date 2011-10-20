/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.sso;

import mantech.domain.User;
import mantech.repository.UserRepository;

/**
 * General utilities to use with SSO.
 * 
 * @author Tien Nguyen
 * @version $Id: SSOUtils.java,v 1.0 2011/10/20 13:52:56 lilylnx Exp $
 */
public class SSOUtils {
  
  private String username;
  private boolean exists = true;
  private User user;
  private UserRepository userRepository;
  
  public SSOUtils(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  /**
   * Checks if an user exists in the database.
   * 
   * @param username The username to check
   * @return <code>true</code> if the user exists. If <code>false</code> is
   * returned, the you can insert the user by calling {@link #register(String, String)}
   * 
   * @see #register(String, String)
   * @see #getUser()
   */
  public boolean userExists(String username) {
    this.username = username;
    
    this.user = this.userRepository.getByUsername(username);
    this.exists = this.user != null;
    return this.exists;
  }
  
  /**
   * Registers a new user. This method should be used together with {@link #userExists(String)}.
   * 
   * @param email The user's email
   * @param password The user's password. It <em>should</em> be the real / final password.
   * In other words, the data passed as password is the data that'll be written to the database
   * @see #getUser()
   */
  public void register(String email, String password) {
    if (this.exists) {
      return;
    }
    
    this.user = new User();
    user.setUsername(this.username);
    user.setPassword(password);
    user.setEmail(email);
    
    this.userRepository.save(user);
  }
  
  /**
   * Gets the user associated to this class instance.
   * 
   * @return The user
   */
  public User getUser() {
    return this.user;
  }

}
