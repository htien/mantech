/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/category")
@SessionAttributes("category")
public class CategoryController {
  
  @Autowired
  private CategoryRepository categoryRepo;
  
  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public String update(@RequestParam(value = "catId", required = false) int id, ModelMap model, BindingResult result) {
    // Xu ly query string
    if (!result.hasErrors() && id > 0) {
      // Lay category len
      Category category = categoryRepo.get(id);
      model.addAttribute("category", category);
    }
    else {
      model.addAttribute("msg", "Khong co category de xu ly");
    }
    return "category/edit";
  }

  @RequestMapping(value = "/editSave", method = RequestMethod.POST)
  public String updateSave(@ModelAttribute("category") Category category) {
    // Validate tai day

    if (category != null) {
      // Update entity xuong database
      categoryRepo.update(category);
    }

    return "redirect:edit.htm.htm";
  }

}
