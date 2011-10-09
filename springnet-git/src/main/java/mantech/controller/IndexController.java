/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mantech.controller.helpers.TemplateKeys;

/**
 * @author Tien Nguyen
 * @version $Id: IndexController.java,v 1.0 2011/06/07 23:56:07 lilylnx Exp $
 */
@Controller
public class IndexController {

  public IndexController() {}

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String list() {
    return TemplateKeys.LOGIN_PAGE;
  }
  
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String dashboard() {
    return TemplateKeys.MAIN_PAGE;
  }
  
  @RequestMapping(value = "/load", method = RequestMethod.GET)
  public String loader(@RequestParam("page") String page, ModelMap model) {
    String module = null;
    String action = null;

    if (page.equals("listuser")) {
      module = "user";
      action = "list";
    }
    
    if (page.equals("adduser")) {
      module = "user";
      action = "add";
    }
    
    if (page.equals("listcomplaint")) {
      module = "complaint";
      action = "list";
    }
    
    if (page.equals("listassignment")) {
      module = "assignment";
      action = "list";
    }

    model.addAttribute("p", action);
    return "redirect:" + module;
  }

}
