/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.repository;

import java.util.Date;
import java.util.List;

import net.lilylnx.springnet.repository.Repository;

import mantech.domain.Complaint;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: ComplaintRepository.java,v 1.0 2011/09/07 1:57:39 lilylnx Exp $
 */
public interface ComplaintRepository extends Repository<Complaint> {
  
  List<Complaint> getComplaintsOrderByCategoryId();
  List<Complaint> getComplaintWeekly(Date begin, Date end);
  List<Complaint> getComplaintByDepartment(Byte id);
  
}
