/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

import mantech.controller.helpers.TemplateKeys;

/**
 * @author Tien Nguyen
 * @version $Id: IndexController.java,v 1.0 2011/06/07 23:56:07 lilylnx Exp $
 */
@Controller
public class IndexController {
  
  @Autowired
  private SpringConfig config;  

  public IndexController() {}

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String login() {
    return TemplateKeys.LOGIN_PAGE;
  }
  
  @RequestMapping(value = "/", params = "p=info", method = RequestMethod.GET)
  public String info() {
    return TemplateKeys.SPRINGNET_INFO_PAGE;
  }
  
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String dashboard() {
    return TemplateKeys.MAIN_PAGE;
  }
  
  @RequestMapping(value = "/loader", method = RequestMethod.GET)
  public String loader(@RequestParam("q") String query, ModelMap model) {
    try {
      // Processing module/param1=value1;param2=value2
      String[] components = query.split("/");
      String[] ajaxKey = this.getAjaxKey(components[0]);
      String[] params = components.length > 1
          ? components[components.length - 1].split(";") : null;
      
      if (params != null) {
        for (String param : params) {
          String[] _p = param.split("=");
          model.addAttribute(_p[0], _p[1]);
        }
      }
  
      model.addAttribute("action", ajaxKey[1].trim());
      return "redirect:".concat(ajaxKey[0].trim());
    }
    catch (Exception e) {
      return TemplateKeys.FILE_NOT_FOUND;
    }
  }
  
  @RequestMapping(value = "/loadaction", method = RequestMethod.GET)
  public String actionloader(@RequestParam("page") String page, ModelMap model) throws Exception {
    String[] hashs = page.split("-");
    String[] _keys = this.getAjaxKey(hashs[0]);
    String module = _keys[0].trim();
    String action = _keys[1].trim();
    
    model.addAttribute("action", action)
        .addAttribute("id", hashs[1].trim());
    return "redirect:".concat(module);
  }
  
  private String[] getAjaxKey(String name) throws Exception {
    Properties ajaxHashUrls = (Properties)config.getProperty(ConfigKeys.AJAX_HASH_URLS);
    return ajaxHashUrls.getProperty(name.trim()).split(",");
  }

}
