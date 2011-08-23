/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package test.lilylnx.springnet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import test.lilylnx.springnet.domains.User;
import test.lilylnx.springnet.services.UserService;

/**
 * @author Tien Nguyen
 * @version $Id: UserController.java,v 1.0 2011/06/16 16:17:20 lilylnx Exp $
 */
@Controller
@RequestMapping("/test/userRegister")
@SessionAttributes("userInfo")
public class UserController {

  private UserService userService;

  public UserController() {}

  @RequestMapping(method = RequestMethod.GET)
  public String showUserForm(ModelMap model) {
    User user = new User();
    model.addAttribute("userInfo", user);
    return "/test/userForm";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String onSubmit(@ModelAttribute("userInfo") User user) {
    userService.add(user);
    return "redirect:/test/userSuccess.htm";
  }

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

}
