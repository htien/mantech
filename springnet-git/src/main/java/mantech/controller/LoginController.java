/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.lilylnx.springnet.core.SessionManager;
import net.lilylnx.springnet.util.ClientUtils;
import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

import mantech.controller.helpers.ResponseMessage;
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
  
  private UserSession userSession;
  
  @Autowired
  private SessionManager sessionManager;
  
  @Autowired
  private SpringConfig config;

  @Autowired
  private LoginService loginService;
  
  @Autowired
  private ClientUtils clientUtils;

  /**
   * Validate the user credentials.
   * 
   * @param id The username or email
   * @param passwd The password
   * @param model
   * @return
   */
  @RequestMapping(value = "/ssoAuthenticate", method = RequestMethod.POST)
  public ResponseEntity<String> authenticateUser(@RequestParam("id") String id, @RequestParam("passwd") String passwd,
      ModelMap model) {

    ResponseMessage message = new ResponseMessage("isAuthenticated", 0, "Wrong ID/password. Access denied.");

    try {
      User user = loginService.authenticate(id, passwd);
      if (user == null) {
        model.addAttribute("invalidLogin", true);
      }
      else {
        //if (userSession == null) {
          userSession = sessionManager.getUserSession();
        //}
        this.userSession.setUser(user);
        this.userSession.becomeLogged();
        
        // TODO: Check autologin
        
        this.sessionManager.add(this.userSession);
        message.setStatusAndMessage(1, "Authenticated.");
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      message.setMessage(e.getMessage());
    }

    return clientUtils.createJsonResponse(message);
  }

  @RequestMapping(value = "/ssoLogout", method = RequestMethod.GET)
  public String logout(ModelMap model) {
    UserSession us = this.sessionManager.getUserSession();
    this.sessionManager.storeSession(us.getSessionId());
    
    us.becomeAnonymous(this.config.getInt(ConfigKeys.ANONYMOUS_USER_ID));
    
    this.sessionManager.remove(us.getSessionId());
    this.sessionManager.add(us);
    //this.removeAutoLoginCookies(us);

    return "redirect:/";
  }
}
