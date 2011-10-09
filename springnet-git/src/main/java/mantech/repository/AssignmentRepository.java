/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.repository;

import java.util.List;

import net.lilylnx.springnet.repository.Repository;

import mantech.domain.Assignment;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: AssignmentRepository.java,v 1.0 2011/09/07 1:52:43 lilylnx Exp $
 */
public interface AssignmentRepository extends Repository<Assignment> {

  List<Assignment> getExist(boolean deleted);
  List<Assignment> getByUserId(int id);
  List<Assignment> getCompleted(byte id);
  List<Assignment> showAllAssignmentWithTechnician();
  
}
