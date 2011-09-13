/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import mantech.domain.Complaint;
import mantech.repository.ComplaintRepository;

import net.lilylnx.springnet.core.exception.ValidationException;

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
  
  public void insert(Complaint complaint) throws ValidationException {
    if (complaint == null) {
      throw new NullPointerException("Cannot insert null complaint.");
    }

    if (StringUtils.isBlank(complaint.getTitle())) {
      throw new ValidationException("A complaint must be a title.");
    }

    if (StringUtils.isBlank(complaint.getContent())) {
      throw new ValidationException("A complaint must be content");
    }

    complaintRepo.add(complaint);
  }

}
