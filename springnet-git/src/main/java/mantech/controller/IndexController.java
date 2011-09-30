/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String login(HttpServletRequest request, ModelMap model) {
    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");
    System.out.println(id + ' ' + passwd);
    if (id.equals("nvhtien") && passwd.equals("123")) {
      model.addAttribute("loginMsg", "Logged in!");
    }
    else {
      model.addAttribute("loginMsg", "Access Denied!");
    }
    return list(model);
  }

}
