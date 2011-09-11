/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mantech.domain.Complaint;
import mantech.repository.ComplaintRepository;

/**
 * 
 * @author Long Nguyen
 * @version $Id: ComplaintService.java,v 1.0 Sep 11, 2011 6:24:44 AM nguyenlong Exp $
 */
public class ComplaintService {
  
  @Autowired
  private ComplaintRepository complaintRepo;
  
  public List<Complaint> sort(String fieldName, boolean order, int page) {
    return complaintRepo.sort(fieldName, order, new int[] { 3, page });
  }

}
