/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.service;

import java.util.List;

import mantech.domain.User;

/**
 * @author Tien Nguyen
 * @version $Id: UserService.java,v 1.0 2011/06/28 16:56:10 lilylnx Exp $
 */
public class UserService {
  
  /**
   * Set status 'Busy' cho danh sach cac User.
   * @param users Danh sach user
   */
  public void setUserStatus(List<User> users) {
    for (User u : users) {
      u.setStatus("B");
    }
  }

}
