/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package test.lilylnx.springnet.services;

import test.lilylnx.springnet.domains.User;

/**
 * @author Tien Nguyen
 * @version $Id: UserServiceImpl.java,v 1.0 Jun 16, 2011 4:38:05 PM lilylnx Exp $
 */
public class UserServiceImpl implements UserService {

  @Override
  public void add(User user) {
    System.out.println(String.format("User '%s' added successfully", user.getName()));
  }

}
