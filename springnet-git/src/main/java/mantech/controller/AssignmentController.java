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

import mantech.domain.Assignment;
import mantech.repository.AssignmentRepository;

/**
 * @author Long Nguyen
 * @version $Id: AssignmentController.java,v 1.0 Sep 12, 2011 3:30:28 AM nguyenlong Exp $
 */
@Controller
@RequestMapping("/long/assignment")
public class AssignmentController {
  
  @Autowired
  private AssignmentRepository assignmentRepo;
  
  @RequestMapping (method = RequestMethod.GET)
  public String list(ModelMap model){
    List<Assignment> list = assignmentRepo.findAll();
    model.addAttribute("list",list);
    List<Assignment> listExist = assignmentRepo.getExist(false);
    model.addAttribute("listExist",listExist);
    List<Assignment> listByUserId = assignmentRepo.getByUserId(9);
    model.addAttribute("listByUserId",listByUserId);
    List<Assignment> listByCompleted = assignmentRepo.getCompleted((byte)4);
    model.addAttribute("listByCompleted", listByCompleted);
    return "assignment/list";
  }
  
}
