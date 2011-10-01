/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Tien Nguyen
 * @version $Id: IndexController.java,v 1.0 2011/06/07 23:56:07 lilylnx Exp $
 */
@Controller
public class IndexController {

  public IndexController() {}

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String list(ModelMap model) {    
    model.addAttribute("welcomeMsg", "SpringFramework! & Hello World");
    return "__index";
  }
  
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@RequestParam("id") String id, @RequestParam("passwd") String passwd,
      HttpServletRequest request, HttpServletResponse response, ModelMap model) {

    if (id.equals("nvhtien") && passwd.equals("123")) {
      model.addAttribute("msg", "Logged in.");
    }
    else {
      model.addAttribute("msg", "Access Denied.");
    }
    return "msg";
  }

}
