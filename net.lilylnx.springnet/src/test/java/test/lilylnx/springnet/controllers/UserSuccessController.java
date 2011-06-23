/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package test.lilylnx.springnet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.lilylnx.springnet.util.ConfigKeys;

/**
 * @author Tien Nguyen
 * @version $Id: UserSuccessController.java,v 1.0 2011/06/17 18:47:53 lilylnx Exp $
 */
@Controller
public class UserSuccessController {

  @RequestMapping("/test/userSuccess" + ConfigKeys.EXT)
  public String redirect() {
    return "/test/userSuccess";
  }

}
