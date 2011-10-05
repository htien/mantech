/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.lilylnx.springnet.util.ConfigKeys;

import mantech.domain.User;
import mantech.domain.UserSession;
import mantech.service.LoginService;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: LoginController.java,v 1.0 2011/10/05 12:35:47 lilylnx Exp $
 */
@Controller
public class LoginController {

  @Autowired
  private LoginService loginService;

  @RequestMapping(value = "/ssoAuthenticate", method = RequestMethod.POST)
  public String authenticateUser(@RequestParam("id") String id, @RequestParam("passwd") String passwd,
      HttpServletRequest request, HttpSession session, ModelMap model) {

    try {
      User user = loginService.authenticate(id, passwd, session);
      if (user != null) {
        model.addAttribute("msg", "Authenticated!");
      }
      else {
        model.addAttribute("msg", "Wrong username/password. Access denied.");
      }
    }
    catch (Exception e) {
      model.addAttribute("msg", e.getMessage());
    }
    System.out.println((UserSession)request.getAttribute(ConfigKeys.USER_SESSION));
    return "message";
  }

  @RequestMapping(value = "/ssoLogout")
  public String logout(ModelMap model) {
    return null;
  }
}
