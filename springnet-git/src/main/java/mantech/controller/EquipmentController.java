/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import mantech.domain.Category;
import mantech.domain.Equipment;
import mantech.repository.CategoryRepository;
import mantech.repository.EquipmentRepository;
import mantech.service.EquipmentService;

/**
 * @author Long Nguyen
 * @version $Id: Equipment.java,v 1.0 Sep 12, 2011 1:30:35 PM nguyenlong Exp $
 */
@Controller
@SessionAttributes("equipment")
public class EquipmentController {

  @Autowired
  private EquipmentRepository equipmentRepo;

  @Autowired
  private EquipmentService equipmentService;
  
  @Autowired
  private CategoryRepository categoryRepo;
  
  @InitBinder
  protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
    binder.registerCustomEditor(Category.class, "id", new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
        Category category = categoryRepo.find(Integer.parseInt(text));
        setValue(category);
      }
    });
  }

  @RequestMapping(value = "/equipment/list", method = RequestMethod.GET)
  public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int page, ModelMap model) {
    int pageCount = equipmentRepo.count().intValue() / 3;
    model.addAttribute("pageCount", pageCount);

    if (page < 1 || page > pageCount) {
      model.addAttribute("msg", "Nothing to show");
    }
    else {
      List<Equipment> listEquipment = equipmentService.paginate(page);
      model.addAttribute("listEquipment", listEquipment);
    }
    return "/equipment/list";

  }
  
  @RequestMapping(value = "/equipment/update", method = RequestMethod.GET)
  public String update(@RequestParam(value = "id", required = false, defaultValue = "0") int id, ModelMap model){
    Equipment equipment = equipmentRepo.get(id);
    List<Category> listCategory = categoryRepo.findAll();
    model.addAttribute("equipment", equipment);
    model.addAttribute("listCategory", listCategory);
    return "/equipment/update";
  }
  
  @RequestMapping(value = "/equipment/updateSave", method = RequestMethod.POST)
  public String updateSave(@ModelAttribute("equipment") Equipment equipment, ModelMap model, BindingResult result) {
    equipmentRepo.update(equipment);
    return "/equipment/list";
  }

}
