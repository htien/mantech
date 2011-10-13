/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mantech.controller.helpers.TemplateKeys;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: DashboardController.java,v 1.0 2011/10/13 2:50:25 lilylnx Exp $
 */
@Controller
public class DashboardController {
  
  @RequestMapping(value = "/dashboard", params = "action=overview", method = RequestMethod.GET)
  public String dashboard(ModelMap model) {
    return TemplateKeys.DASHBOARD_PAGE;
  }
  
  @RequestMapping(value = "/dashboard", params = "action=viewcredits", method = RequestMethod.GET)
  public String viewCredits() {
    return TemplateKeys.DASHBOARD_VIEW_CREDITS;
  }

}
