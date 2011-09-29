/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mantech.domain.Assignment;
import mantech.domain.Complaint;
import mantech.domain.ComplaintStatus;
import mantech.domain.User;
import mantech.repository.AssignmentRepository;
import mantech.repository.ComplaintRepository;
import mantech.repository.ComplaintStatusRepository;
import mantech.repository.UserRepository;

/**
 * @author Long Nguyen
 * @version $Id: AssignmentController.java,v 1.0 Sep 12, 2011 3:30:28 AM nguyenlong Exp $
 */
@Controller
public class AssignmentController {
  
  @Autowired
  private AssignmentRepository assignmentRepo;
  
  @Autowired
  private UserRepository userRepo;
  
  @Autowired
  private ComplaintRepository complaintRepo;
  
  @Autowired
  private ComplaintStatusRepository statusRepo; 
  
  @RequestMapping (value = {"/assignment", "/assignment/list"}, method = RequestMethod.GET)
  public String list(ModelMap model) {
    List<Complaint> listComplaint = complaintRepo.getByAssignment();
    List<Complaint> listAllComplaint = complaintRepo.findAll();
    
    model.addAttribute("listComplaint", listComplaint);
    model.addAttribute("listAllComplaint", listAllComplaint);
    
    for (Complaint c : listAllComplaint) {
      try {
        c.getAssignment().getComplaintId();
      }
      catch (Exception e) {
        c.setAssignment(null);
      }
    }
    
    return "assignment/list";
  }
  
  @RequestMapping (value = "/assignment/add", method = RequestMethod.GET)
  public String insert(@RequestParam(value = "compId") int compId, ModelMap model) {
    if (complaintRepo.isExist(compId)) {
      if (!complaintRepo.hasAssignmentId(compId)) {
        List<Complaint> complaints = complaintRepo.findAll();
        Complaint complaint = complaintRepo.get(compId);
        
        model.addAttribute("complaint", complaint);
        model.addAttribute("compId", compId);
        model.addAttribute("listComplaint", complaints);
        return "/assignment/add";
      }
    }
    return "redirect:/complaint/list";
  }
  
  @RequestMapping (value = "/assignment/addSave", method = RequestMethod.POST)
  public String insertSave(@RequestParam(value = "compId") int compId, @RequestParam(value="userId") int[] userId, @RequestParam(value="beginDate") Date beginDate,
      @RequestParam(value="duration") short duration)
  {
    List<User> users = userRepo.getUsers(userId);
    Complaint complaint = complaintRepo.get(compId);
    ComplaintStatus status = statusRepo.get(ComplaintStatus.ACCEPTED);
    complaint.setStatus(status);
    
    Assignment assignment = new Assignment();
    assignment.setComplaintId(complaint.getId());
    assignment.setUsers(users);
    assignment.setBeginDate(beginDate);
    assignment.setDuration(duration);

    assignmentRepo.add(assignment);
    return "redirect:/assignment/list";
  }
}
