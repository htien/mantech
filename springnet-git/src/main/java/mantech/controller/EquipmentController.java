/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
  
//  @InitBinder
//  protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
//    binder.registerCustomEditor(Category.class, "id", new PropertyEditorSupport() {
//      @Override
//      public void setAsText(String text) throws IllegalArgumentException {
//        Category category = categoryRepo.find(Integer.parseInt(text));
//        setValue(category);
//      }
//    });
//  }

  @RequestMapping(value = "/equipment/list", method = RequestMethod.GET)
  public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int page, ModelMap model) {
    int pageCount;
    if (equipmentRepo.count().intValue() % 3 == 0)
      pageCount = equipmentRepo.count().intValue() / 3;
    else
      pageCount = (equipmentRepo.count().intValue() / 3) + 1;
    System.out.println(equipmentRepo.count().intValue());
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
  
  @RequestMapping(value = "/equipment/edit", method = RequestMethod.GET)
  public String update(@RequestParam(value = "id", required = false, defaultValue = "0") int id, ModelMap model){
    Equipment equipment = equipmentRepo.get(id);
    List<Category> listCategory = categoryRepo.findAll();
    model.addAttribute("equipment", equipment);
    model.addAttribute("listCategory", listCategory);
    return "/equipment/edit";
  }
  
  @RequestMapping(value = "/equipment/editSave", method = RequestMethod.POST)
  public String updateSave(@RequestParam(value = "id") int id, @RequestParam(value = "catId") int catId,@RequestParam(value = "name") String name, ModelMap model) {
    //update equipment set  category_id = 3, name = 'Fan' where id = 1
    
    Equipment equipment = equipmentRepo.get(id);
    Category newCate = categoryRepo.get(catId);
    if (newCate != null) {
      equipment.setName(name);
      equipment.setCategory(newCate);
      equipmentRepo.update(equipment);
      model.addAttribute("msg", "Update successfully");
    }
    else {
      model.addAttribute("msg", "Update fail");
    }
    return update(id, model);
  }
  
  @RequestMapping(value = "/equipment/add", method = RequestMethod.GET)
  public String insert(ModelMap model) {
    List<Category> category = categoryRepo.findAll();
    model.addAttribute("category", category);
    return "/equipment/add";
  }
  
  @RequestMapping(value = "/equipment/addSave", method = RequestMethod.POST)
  public String insertSave(@RequestParam(value = "name") String name, @RequestParam(value = "catId") int id, ModelMap model){
    Category category = categoryRepo.get(id);
    Equipment equipment = new Equipment();
    equipment.setName(name);
    equipment.setCategory(category);
    equipmentRepo.add(equipment);
    return "redirect:/equipment/list";
  }

}
