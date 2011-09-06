/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package test.mantech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: TienTestController.java,v 1.0 2011/09/07 4:35:11 lilylnx Exp $
 */
@Controller
@RequestMapping("/tien/test")
public class TienTestController {
  
  public TienTestController() {}
  
  @RequestMapping(method = RequestMethod.GET)
  public String list(ModelMap model) {
    return "test/tien_test";
  }

}
