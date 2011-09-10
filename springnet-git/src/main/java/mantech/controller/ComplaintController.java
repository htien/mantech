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

import mantech.domain.Complaint;
import mantech.repository.ComplaintRepository;

/**
 * @author Long Nguyen
 * @version $Id: ComplaintController.java,v 1.0 Sep 9, 2011 12:56:51 AM nguyenlong Exp $
 */
@Controller
@RequestMapping("/long/complaint")
public class ComplaintController {

  @Autowired
  private ComplaintRepository complaintRepo;

  @RequestMapping(method = RequestMethod.GET)
  public String showAll(ModelMap model) throws Exception {
    // Date begin = Calendar.getInstance().getTime();
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    Date begin = format.parse("2011/09/05");
    Date end = format.parse("2011/09/10");
    byte id = 1;
    List<Complaint> complaints = complaintRepo.sort("equipment.name", false, new int[] { 0, 3});
    model.addAttribute("listComplaint", complaints);
    model.addAttribute("no", noOfComplaintInPeriod());
    model.addAttribute("list", listComplaintDaily(1));
    model.addAttribute("complaintInWeek", complaintRepo.getByWeekly(begin, end));
    model.addAttribute("complaintByDepartment", complaintRepo.getByDepartment(id));
    model.addAttribute("complaintByPriority",complaintRepo.getByPriority((byte)2));
    model.addAttribute("complaintByFirstName", complaintRepo.searchByFName("n"));
    return "complaint/list";
  }

  public int noOfComplaintInPeriod() {
    return complaintRepo.count().intValue();
  }

  public List<Complaint> listComplaintDaily(int i) {
    return complaintRepo.findRange(new int[] { i - 1, i + 2 }, true, "id");
  }

}
