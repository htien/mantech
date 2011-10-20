/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import mantech.controller.helpers.RName;
import mantech.controller.helpers.RStatus;
import mantech.controller.helpers.ResponseMessage;
import mantech.controller.helpers.TemplateKeys;
import mantech.domain.Category;
import mantech.domain.CategoryPriority;
import mantech.repository.CategoryPriorityRepository;
import mantech.repository.CategoryRepository;

import net.lilylnx.springnet.util.ClientUtils;

/**
 * @author Long Nguyen
 * @version $Id: CategoryController.java,v 1.0 2011/09/08 23:07:48 nguyenlong Exp $
 */
@Controller
@SessionAttributes("category")
public class CategoryController {

  @Autowired
  private CategoryRepository categoryRepo;
  
  @Autowired
  private ClientUtils clientUtils;
  
  @Autowired
  private CategoryPriorityRepository priorityRepo;

  @RequestMapping(value = "/category", params = "action=list", method = RequestMethod.GET)
  public String list(ModelMap model){
    model.addAttribute("listCategory", categoryRepo.findAll());
    return TemplateKeys.CATEGORY_LIST;
  }
  
  @RequestMapping(value = "/category", params = "action=add", method = RequestMethod.GET)
  public String insert(ModelMap model) {
    model.addAttribute("priorities", priorityRepo.findAll());
    return "/category/add";
  }
  
  @RequestMapping(value = "/category/addSave", method = RequestMethod.POST)
  public ResponseEntity<String> insertSave(@RequestParam(value="name") String name,
      @RequestParam(value="priorityId") byte id, ModelMap model) {

    ResponseMessage respMessage = new ResponseMessage(RName.ADD, RStatus.FAIL, null);
    try {
      Category category = new Category();
      CategoryPriority priority = priorityRepo.get(id);
      category.setName(name);
      category.setPriority(priority);
      categoryRepo.save(category);
      respMessage.setStatusAndMessage(RStatus.SUCC, String.format("Inserted category: <strong>%s </strong>", name));
    }
    catch(Exception e) {
      respMessage.setStatusAndMessage(RStatus.ERROR, e.getMessage());
    }
    return clientUtils.createJsonResponse(respMessage);
  }
  
  @RequestMapping(value = "/category", params = "action=edit", method = RequestMethod.GET)
  public String update(@RequestParam(value="id", required=false, defaultValue="0") int id,
      ModelMap model) {

      Category category = categoryRepo.get(id);
      model.addAttribute("category", category);
    return TemplateKeys.CATEGORY_EDIT;
  }

  @RequestMapping(value = "/category/editSave", method = RequestMethod.POST)
  public ResponseEntity<String> updateSave(@RequestParam(value="cateId") int id,
      @RequestParam(value="name") String name, ModelMap model) {
    // TODO Validate tai day
    ResponseMessage respMessage = new ResponseMessage(RName.UPDATE, RStatus.FAIL, null);
    
    try {
      Category category = categoryRepo.get(id);
      category.setName(name);
      categoryRepo.update(category);
      respMessage.setStatusAndMessage(RStatus.SUCC, String.format("Updated category: <strong>%s </strong> successfully.",
          category.getName()));
    }
    catch(Exception e) {
      respMessage.setStatusAndMessage(RStatus.ERROR, e.getMessage());
    }

    return clientUtils.createJsonResponse(respMessage);
  }

}
