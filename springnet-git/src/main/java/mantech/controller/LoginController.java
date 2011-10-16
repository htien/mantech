/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.lilylnx.springnet.util.ClientUtils;

import mantech.controller.helpers.ResponseMessage;
import mantech.domain.User;
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
  
  @Autowired
  private ClientUtils clientUtils;

  @RequestMapping(value = "/ssoAuthenticate", method = RequestMethod.POST)
  public ResponseEntity<String> authenticateUser(@RequestParam("id") String id, @RequestParam("passwd") String passwd,
      HttpServletRequest request, HttpSession session, ModelMap model) {

    ResponseMessage message = new ResponseMessage("isAuthenticated", 0, "Wrong ID/password. Access denied.");

    try {
      User user = loginService.authenticate(id, passwd, session);
      if (user != null) {
        message.setStatusAndMessage(1, "Authenticated.");
      }
    }
    catch (Exception e) {
      message.setMessage(e.getMessage());
    }

    return clientUtils.createJsonResponse(message);
  }

  @RequestMapping(value = "/ssoLogout", method = RequestMethod.GET)
  public String logout(ModelMap model) {
    return "redirect:/";
  }
}
