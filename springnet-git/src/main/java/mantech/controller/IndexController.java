/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Tien Nguyen
 * @version $Id: IndexController.java,v 1.0 2011/06/07 23:56:07 lilylnx Exp $
 */
@Controller
@RequestMapping("/index")
public class IndexController {

  public IndexController() {}

  @RequestMapping(method = RequestMethod.GET)
  public String list(ModelMap model) {
    model.addAttribute("welcomeMsg", "SpringFramework! & Hello World");
    return "index";
  }

}
