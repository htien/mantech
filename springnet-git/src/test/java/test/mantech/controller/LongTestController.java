/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package test.mantech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mantech.domain.Category;
import mantech.repository.CategoryRepository;

/**
 * 
 * @author Long Nguyen
 * @version $Id: LongTestController.java,v 1.0 2011/09/07 3:23:07 nguyenlong Exp $
 */
@Controller
@RequestMapping("/long/test")
public class LongTestController {

  @Autowired
  private CategoryRepository categoryRepo;

  public LongTestController() {}

  @RequestMapping(method = RequestMethod.GET)
  public String list(ModelMap model) {
    Category lastCate = categoryRepo.getLastCategory();
    model.addAttribute("lastCate", lastCate);
    return "test/long_test";
  }

}
