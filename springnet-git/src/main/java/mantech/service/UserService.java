/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mantech.domain.Department;
import mantech.domain.User;
import mantech.domain.UserRole;
import mantech.repository.UserRepository;

/**
 * @author Tien Nguyen
 * @version $Id: UserService.java,v 1.0 2011/06/28 16:56:10 lilylnx Exp $
 */
public class UserService {
  
  @Autowired
  private UserRepository userRepo;
  
  public Serializable add(String username, String password, String email, String firstName, String lastName,
        String gender, String address, Department department, UserRole userRole)
  {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email); 
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setGender(gender);
    user.setHomeAddress(address);
    user.setDepartment(department);
    user.setRole(userRole);

    return userRepo.save(user);
  }
  
  public User update(int id, String email, String address, Department department, UserRole userRole) {
    User user = userRepo.get(id);
    user.setEmail(email);
    user.setHomeAddress(address);
    user.setDepartment(department);
    user.setRole(userRole);
    
    userRepo.update(user);
    return user;
  }

  public List<User> searchByUsername(String username) {
    return userRepo.search(username, null);
  }
  
  public List<User> searchByDepartmentName(String name) {
    return userRepo.search(null, name);
  }
  
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
