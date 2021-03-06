/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.repository;

import java.util.List;

import net.lilylnx.springnet.repository.Repository;

import mantech.domain.AssignmentDetail;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: AssignmentDetailRepository.java,v 1.0 2011/09/07 1:54:05 lilylnx Exp $
 */
public interface AssignmentDetailRepository extends Repository<AssignmentDetail> {
 
  List<AssignmentDetail> getByComplaint(int id);
  
  AssignmentDetail getByComplaint(int userId, int complaintId);
  
  int countAllCompletedByComplaint(int id);
  int countAssignDetailNotCompleted(int id);

}
