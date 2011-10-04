/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mantech.domain.User;
import mantech.service.LoginService;

/**
 * @author Tien Nguyen
 * @version $Id: IndexController.java,v 1.0 2011/06/07 23:56:07 lilylnx Exp $
 */
@Controller
public class IndexController {
  
  @Autowired
  private LoginService loginService;

  public IndexController() {}

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String list(ModelMap model) {    
    model.addAttribute("welcomeMsg", "SpringFramework. Admin Control Panel");
    return "__index";
  }
  
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String authenticateUser(@RequestParam("id") String id, @RequestParam("passwd") String passwd,
      HttpSession session, ModelMap model) {

    try {
      User user = loginService.authenticate(id, passwd, session);
      if (user != null) {
        session.setAttribute("userProfile", user);
        model.addAttribute("msg", "Authenticated!");
      }
      else {
        session.removeAttribute("userProfile");
        model.addAttribute("msg", "Wrong username/password. Access denied.");
      }
    }
    catch (Exception e) {
      model.addAttribute("msg", e.getMessage());
    }

    return "message";
  }

}
