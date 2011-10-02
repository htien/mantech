/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.service;

import org.springframework.beans.factory.annotation.Autowired;

import mantech.domain.Assignment;
import mantech.repository.AssignmentRepository;

/**
 * 
 * @author Long Nguyen
 * @version $Id: AssignmentService.java,v 1.0 2011/10/03 1:10:22 nguyenlong Exp $
 */
public class AssignmentService {
  
  @Autowired
  private AssignmentRepository assignmentRepo;
  
  public void add(Assignment assignment) {
    // khu vuc validate assignment
    // update xuong database
    assignmentRepo.save(assignment);
  }

}
