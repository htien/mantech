/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import mantech.domain.Category;
import mantech.repository.CategoryRepository;

/**
 * @author Long Nguyen
 * @version $Id: CategoryController.java,v 1.0 2011/09/08 23:07:48 nguyenlong Exp $
 */
@Controller
@SessionAttributes("category")
public class CategoryController {

  @Autowired
  private CategoryRepository categoryRepo;

  @RequestMapping(value="/category/list", method = RequestMethod.GET)
  public String list(ModelMap model){
    List<Category> list = categoryRepo.findAll();
    model.addAttribute("list",list);
    return "/category/list";
  }
  
  @RequestMapping(value = "/category/edit", method = RequestMethod.GET)
  public String update(@RequestParam(value = "catId", required = false, defaultValue = "0") int id, ModelMap model) {
    // Xu ly query string
    if (id > 0) {
      // Lay category len
      Category category = categoryRepo.get(id);
      model.addAttribute("category", category);
    }
    else { 
      model.addAttribute("msg", "Khong co category de xu ly");
    }
    return "/category/edit";
  }
  
  @RequestMapping(value = "/category/editSave", method = RequestMethod.GET)
  public String againstUpdateSave(ModelMap model) {
    return "redirect:" + list(model);
  }

  @RequestMapping(value = "/category/editSave", method = RequestMethod.POST)
  public String updateSave(@ModelAttribute("category") Category category, ModelMap model) {
    // Validate tai day

    if (category != null) {
      // Update entity xuong database
      categoryRepo.update(category);
      model.addAttribute("msg", "Successfully!");
      model.addAttribute("ok", true);
    }
    return update(category.getId(), model);
  }

}
