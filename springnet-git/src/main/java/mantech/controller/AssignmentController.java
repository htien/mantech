/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mantech.controller.helpers.RName;
import mantech.controller.helpers.RStatus;
import mantech.controller.helpers.ResponseMessage;
import mantech.controller.helpers.TemplateKeys;
import mantech.domain.Assignment;
import mantech.domain.AssignmentDetail;
import mantech.domain.Complaint;
import mantech.domain.User;
import mantech.repository.AssignmentDetailRepository;
import mantech.repository.AssignmentRepository;
import mantech.repository.ComplaintRepository;
import mantech.repository.ComplaintStatusRepository;
import mantech.repository.UserRepository;
import mantech.service.AssignmentService;
import mantech.service.ComplaintService;
import mantech.service.UserService;

import net.lilylnx.springnet.core.SessionManager;
import net.lilylnx.springnet.util.ClientUtils;

/**
 * @author Long Nguyen
 * @version $Id: AssignmentController.java,v 1.0 Sep 12, 2011 3:30:28 AM nguyenlong Exp $
 */
@Controller
public class AssignmentController {

  @Autowired
  private SessionManager sessionManager;
  
  @Autowired
  private UserRepository userRepo;
  
  @Autowired
  private ComplaintRepository complaintRepo;
  
  @Autowired
  private AssignmentRepository assignmentRepo;
  
  @Autowired
  private AssignmentDetailRepository detailRepo;
  
  @Autowired
  private ComplaintService complaintService;
  
  @Autowired
  private AssignmentService assignmentService;
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private ClientUtils clientUtils;
  
  @Autowired
  private ComplaintStatusRepository statusRepo;
  
  public AssignmentController() {
    
  }
  
  @RequestMapping(value = {"/assignment"}, params = "action=list", method = RequestMethod.GET)
  public String list(ModelMap model) {
    List<Complaint> listComplaint = complaintRepo.getByAssignment();
    List<Complaint> listAllComplaint = complaintRepo.findAll();
    List<Assignment> listAllAssignment = assignmentRepo.findAll();
        
    model.addAttribute("listComplaint", listComplaint);
    model.addAttribute("listAllComplaint", listAllComplaint);
    model.addAttribute("listAllAssignment", listAllAssignment);
    model.addAttribute("listAssignmentsByTechnician", assignmentRepo.
        getByUserId(sessionManager.getUser().getId()));
    
    for (Complaint c : listAllComplaint) {
      try {
        c.getAssignment().getComplaintId();
      }
      catch (Exception e) {
        c.setAssignment(null);
      }
    }

    return TemplateKeys.ASSIGNMENT_LIST;
  }
  
  @RequestMapping(value = "/assignment", params = "action=detail", method = RequestMethod.GET)
  public String detail(@RequestParam(value="assignmentId") int compId, ModelMap model) {
    Complaint complaint = complaintRepo.get(compId);
    
    if (complaint.getAssignment() == null) {
      return TemplateKeys.FILE_NOT_FOUND;
    }

    model.addAttribute("complaint", complaint);
    return TemplateKeys.ASSIGNMENT_DETAIL;
  }
  
  @RequestMapping(value = "/assignment", params = "action=complete", method = RequestMethod.GET)
  public String completedDetail(@RequestParam(value="compId") int id, ModelMap model) {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR),
        month = cal.get(Calendar.MONTH),
        dateMonth = cal.get(Calendar.DAY_OF_MONTH);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    Date date = null;
    String s = Integer.toString(year) + "/" +
        ((month < 10)? ("0" + Integer.toString(month)): Integer.toString(month))+ "/" +
        ((dateMonth < 10)? ("0" + Integer.toString(dateMonth)): Integer.toString(dateMonth));
    try {
      date = sdf.parse(s);
    }
    catch (ParseException e) {
      e.printStackTrace();
    }

    AssignmentDetail detail = detailRepo.getByComplaint(sessionManager.getUser().getId(), id);
    detail.setCompleteDate(date);
    detailRepo.update(detail);
    
    System.out.println("AAAAAAAAAAAAAAAAAAAA" + detailRepo.countAllCompletedByComplaint(id));
    if (detailRepo.countAllCompletedByComplaint(id) == 0) {
      Assignment assignment = assignmentRepo.get(id);
      assignment.setDeleted(true);
      assignmentRepo.update(assignment);
      Complaint complaint = complaintRepo.get(id);
      complaint.setStatus(statusRepo.get((byte)4));
      complaint.setEndDate(date);
      complaintRepo.update(complaint);
    }
    return this.detail(id, model);
  }
  
  @RequestMapping(value = "/assignment", params = "action=add", method = RequestMethod.GET)
  public String insert(@RequestParam(value="compId") int compId, ModelMap model) {
        List<User> users = userRepo.getTechnicianFree();
        
        Complaint complaint = complaintRepo.get(compId);
        
        model.addAttribute("technicians", users);
        model.addAttribute("complaint", complaint);
        model.addAttribute("compId", compId);
        return TemplateKeys.ASSIGNMENT_ADD;
  }
  
  @RequestMapping(value = "/assignment/addSave", method = RequestMethod.POST)
  public ResponseEntity<String> insertSave(@RequestParam(value="compId") int compId,
      @RequestParam(value="userId") int[] userId,
      @RequestParam(value="beginDate") Date beginDate,
      @RequestParam(value="duration") short duration) {

    ResponseMessage respMessage = new ResponseMessage(RName.ADD, RStatus.FAIL, null);
    
    List<User> users = userRepo.getUsers(userId);
    Complaint complaint = complaintRepo.get(compId);

    complaintService.setStatusAccepted(complaint);
    userService.setUserStatus(users);
    
    try {
      Assignment assignment = new Assignment();
      assignment.setComplaintId(complaint.getId());
      assignment.setUsers(users);
      assignment.setBeginDate(beginDate);
      assignment.setDuration(duration);

      assignmentService.add(assignment);
      respMessage.setStatusAndMessage(RStatus.SUCC, String.format("Inserted assignment successfully"));
    }
    catch(Exception e) {
      respMessage.setStatusAndMessage(RStatus.ERROR, e.getMessage());
    }
    return clientUtils.createJsonResponse(respMessage);
  }
}
