/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package test.mantech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mantech.domain.Complaint;
import mantech.repository.ComplaintRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: TienTestController.java,v 1.0 2011/09/07 4:35:11 lilylnx Exp $
 */
@Controller
public class TienTestController {

  @Autowired
  private ComplaintRepository complaintRepo;

  public TienTestController() {}

  @RequestMapping(value = "/tien/test", method = RequestMethod.GET)
  public String list(ModelMap model) {
    List<Complaint> listComplaint = complaintRepo.findAll();
    for (Complaint c : listComplaint) {
      try {
        c.getAssignment().getComplaintId();
      }
      catch (Exception e) {
        c.setAssignment(null);
      }
    }
    return "test/tien_test";
  }

}