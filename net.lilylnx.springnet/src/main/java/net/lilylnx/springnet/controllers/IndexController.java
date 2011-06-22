/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 * @author Tien Nguyen
 * @version $Id: IndexController.java,v 1.0 2011/06/07 23:56:07 lilylnx Exp $
 */
public class IndexController extends ParameterizableViewController {

  private String message;

  public IndexController() {}

  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView(getViewName(), "welcomeMsg", message);
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
