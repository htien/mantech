/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.lilylnx.springnet.core.exception.ValidationException;



import mantech.domain.CategoryPriority;
import mantech.domain.Complaint;
import mantech.domain.Equipment;
import mantech.domain.User;
import mantech.repository.ComplaintRepository;
import mantech.repository.EquipmentRepository;
import mantech.repository.UserRepository;
import mantech.service.ComplaintService;

/**
 * @author Long Nguyen
 * @version $Id: ComplaintController.java,v 1.0 Sep 9, 2011 12:56:51 AM nguyenlong Exp $
 */
@Controller
public class ComplaintController {
  
  @Autowired
  private ComplaintService complaintService;

  @Autowired
  private ComplaintRepository complaintRepo;
  
  @Autowired
  private EquipmentRepository equipmentRepo;
  
  @Autowired
  private UserRepository userRepo;

  @RequestMapping(value = "/complaint/list", method = RequestMethod.GET)
  public String showAll(ModelMap model) throws Exception {
    // Date begin = Calendar.getInstance().getTime();
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    Date begin = format.parse("2011/09/05");
    Date end = format.parse("2011/09/10");
    Date createDate = format.parse("2011/09/09");
    List<Complaint> complaints = complaintService.sort("id", false, 2); // trang 1, lay 3 kq, se lay ra id 1, 2, 3
    model.addAttribute("listComplaint", complaints);
    model.addAttribute("no", noOfComplaintInPeriod());
    model.addAttribute("list", listComplaintDaily(1));
    model.addAttribute("complaintInWeek", complaintRepo.getByWeekly(begin, end));
    model.addAttribute("complaintByDepartment", complaintRepo.getByDepartment((byte)1));
    model.addAttribute("complaintByPriority",complaintRepo.getByPriority((byte)2));
    model.addAttribute("complaintByFirstName", complaintRepo.searchByFName("n"));
    List<Complaint> complaintsByDate = complaintRepo.searchByDate(createDate);
    model.addAttribute("complaintByDate", complaintsByDate);
    List<Complaint> complaintsFromDateToDate = complaintRepo.searchByDate(format.parse("2011/09/09"), 
                                               format.parse("2011/10/02"));
    model.addAttribute("complaintsFromDateToDate", complaintsFromDateToDate);
    List<Complaint> complaintsByYear = complaintRepo.searchByYear(2011);
    model.addAttribute("complaintYear", complaintsByYear);
    return "complaint/list";
  }

  public int noOfComplaintInPeriod() {
    return complaintRepo.count().intValue();
  }

  public List<Complaint> listComplaintDaily(int i) {
    return complaintRepo.findRange(new int[] { i - 1, i + 2 }, true, "id");
  }

  @RequestMapping(value = "/complaint/insert", method = RequestMethod.GET)
  public String insert (@RequestParam(value = "userId") int id, ModelMap model){
    model.addAttribute("userId", id);
    List<Equipment> equip = equipmentRepo.findAll();
    model.addAttribute("list", equip);
    return "/complaint/insert";
  }
  
  @RequestMapping(value = "/complaint/insertSave", method = RequestMethod.POST)
  public String insertSave(@RequestParam(value = "equipId") int equipId,
      @RequestParam(value = "title") String title,
      @RequestParam(value = "content") String content, ModelMap model)
  {
    Complaint complaint = new Complaint();
    User user = userRepo.get(2);
    Equipment equipment = equipmentRepo.get(equipId);
    CategoryPriority priority = equipment.getCategory().getPriority();
    complaint.setUser(user);
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
    return "redirect:/complaint/list";
  }
}
