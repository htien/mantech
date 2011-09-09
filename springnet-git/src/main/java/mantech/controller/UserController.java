/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import mantech.domain.User;
import mantech.repository.UserRepository;

/**
 * @author Long Nguyen
 * @version $Id: UserController.java,v 1.0 Sep 9, 2011 3:59:57 AM nguyenlong Exp $
 */
@Controller
@RequestMapping("/long/user")
public class UserController {

  @Autowired
  private UserRepository userRepo;
  
  @RequestMapping(method = RequestMethod.GET)
  public String showUser(ModelMap model){
    List<User> users = userRepo.findAll();
    model.addAttribute("listUser", users);
    
    return "user/user";
  }
}
