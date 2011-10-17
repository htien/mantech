/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.repository;

import java.util.List;

import mantech.domain.User;

import net.lilylnx.springnet.repository.Repository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: UserRepository.java,v 1.0 2011/06/28 16:34:49 lilylnx Exp $
 */
public interface UserRepository extends Repository<User> {

  String getPasswordByUsername(String username);
  String getPasswordByEmail(String email);
  User getByUsername(String username);
  User getByEmail(String email);
  List<User> getTechnicianFree();
  List<User> getUserByRole(int id);
  List<User> getUserByRole(String name);
  List<User> getUsers(int... ids);
  List<User> search(String username, String departName);
  boolean isExistUser(int id);
  boolean isExistUser(String unameOrEmail);

}
