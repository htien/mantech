/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import mantech.controller.helpers.TemplateKeys;
import mantech.domain.CategoryPriority;
import mantech.domain.Complaint;
import mantech.domain.ComplaintStatus;
import mantech.domain.Equipment;
import mantech.domain.User;
import mantech.repository.CategoryPriorityRepository;
import mantech.repository.ComplaintRepository;
import mantech.repository.ComplaintStatusRepository;
import mantech.repository.EquipmentRepository;
import mantech.repository.UserRepository;
import mantech.service.ComplaintService;

import net.lilylnx.springnet.util.ClientUtils;

/**
 * @author Long Nguyen
 * @version $Id: ComplaintController.java,v 1.0 Sep 9, 2011 12:56:51 AM nguyenlong Exp $
 */
@Controller
@SessionAttributes("complaint")
public class ComplaintController {
  
  @Autowired
  private ComplaintService complaintService;

  @Autowired
  private ComplaintRepository complaintRepo;
  
  @Autowired
  private EquipmentRepository equipmentRepo;
  
  @Autowired
  private UserRepository userRepo;
  
  @Autowired
  private ComplaintStatusRepository statusRepo;
  
  @Autowired
  private CategoryPriorityRepository priorityRepo;
  
  @Autowired
  private ClientUtils clientUtils;

  @RequestMapping(value = "/complaint", params = "!p", method = RequestMethod.GET)
  public String list(ModelMap model) throws Exception {
    
    model.addAttribute("listAll", complaintRepo.findAll());
    model.addAttribute("listStatus", statusRepo.findAll());
    model.addAttribute("listPriority", priorityRepo.findAll());
    return TemplateKeys.COMPLAINT_ADMIN;
  }

  public int noOfComplaintInPeriod() {
    return complaintRepo.count().intValue();
  }

  public List<Complaint> listComplaintDaily(int i) {
    return complaintRepo.findRange(new int[] { i - 1, i + 2 }, true, "id");
  }

  @RequestMapping(value = "/complaint", params = "p=add", method = RequestMethod.GET)
  public String insert(@RequestParam(value="uid") int id, ModelMap model){
    
    model.addAttribute("user", userRepo.get(id));
    model.addAttribute("list", equipmentRepo.findAll());
    return TemplateKeys.COMPLAINT_ADMIN;
  }
  
  @RequestMapping(value = "/complaint/addSave", method = RequestMethod.POST)
  public ResponseEntity<String> insertSave(@RequestParam(value="uid") int id,
      @RequestParam(value="equipId") int equipId,
      @RequestParam(value="title") String title,
      @RequestParam(value="content") String content, ModelMap model)
  {
/*    Complaint complaint = new Complaint();*/
    User user = userRepo.get(id);
    Equipment equipment = equipmentRepo.get(equipId);
    CategoryPriority priority = equipment.getCategory().getPriority();
    int newComplaintId = ((Integer)complaintService.add(user, equipment, title, content, priority)).intValue();
   /* complaint.setUser(user);
    complaint.setEquipment(equipment);
    complaint.setPriority(priority);
    complaint.setTitle(title);
    complaint.setContent(content);
    try {
      complaintService.insert(complaint);
    }
    catch (ValidationException e) {
      model.addAttribute("complaint", complaint);
      model.addAttribute("errorMsg", e.getMessage());
      return insert(user.getId(), model);
    }
    catch (Exception e) {
      model.addAttribute("errorMsg", e.getMessage());
      e.printStackTrace();
    }*/
    return clientUtils.createJsonResponse(
        new ResponseMessage("insert", 1, String.format("Insert Complaint : <strong>%s (ID: %d)</strong>", title, newComplaintId)));
  }
  
  @RequestMapping(value = "/complaint", params = "p=edit", method = RequestMethod.GET)
  public String update(@RequestParam(value="id") int id, ModelMap model) {
    Complaint complaint = complaintRepo.get(id);
    
    List<CategoryPriority> priority = priorityRepo.findAll(false, "id");
    List<ComplaintStatus> status = statusRepo.findAll(false, "id");
    
    model.addAttribute("complaint", complaint);
    model.addAttribute("listStatus", status);
    model.addAttribute("listPriority", priority);
    return TemplateKeys.COMPLAINT_ADMIN;
  }
  
  @RequestMapping(value = "/complaint/editSave", method = RequestMethod.POST)
  public ResponseEntity<String> updateSave(@RequestParam("id") int id,
      @RequestParam("status") byte statusId, 
      @RequestParam("priority") byte priorityId, ModelMap model)
  {
    /*Complaint complaint = (Complaint)model.get("complaint");*/
    ComplaintStatus status = statusRepo.get(statusId);
    CategoryPriority priority = priorityRepo.get(priorityId);

    Complaint complaint = complaintService.update(id, status, priority);
    return clientUtils.createJsonResponse(
        new ResponseMessage("update", 1, String.format("Updated complaint: <strong>%s (ID: %d)</strong>",
            complaint.getStatus().getName().concat(" - ").concat(complaint.getPriority().getName()), complaint.getId())));
  }
  
  @RequestMapping(value = "/complaint/search", method = RequestMethod.POST)
  public String search(@RequestParam("q") String searchText,
      @RequestParam("f") byte selectedField,
      @RequestParam(value="dateFrom", required=false) Date dateFrom,
      @RequestParam(value="dateTo", required=false) Date dateTo,
      @RequestParam(value="status") byte status,
      @RequestParam(value="priority") byte priority,
      ModelMap model)
  {
    List<Complaint> complaints = null;
    searchText = StringUtils.isBlank(searchText) ? null : searchText.trim();
    
    switch (selectedField) {
      case 1: complaints = complaintRepo.search(searchText, null, dateFrom, dateTo, status, priority); break;
      case 2: complaints = complaintRepo.search(null, searchText, dateFrom, dateTo, status, priority); break;
      default: complaints = complaintRepo.search(null, null, dateFrom, dateTo, status, priority); break;
    }
   
    if (complaints.size() != 0) {
      model.addAttribute("listComplaint", complaints);
      return TemplateKeys.COMPLAINT_SEARCH_ADMIN;
    }
    else {
      return TemplateKeys.NULL;
    }
  }
}
