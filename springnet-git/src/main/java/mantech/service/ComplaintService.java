/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.service;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import mantech.domain.CategoryPriority;
import mantech.domain.Complaint;
import mantech.domain.ComplaintStatus;
import mantech.domain.Equipment;
import mantech.domain.User;
import mantech.repository.ComplaintRepository;
import mantech.repository.ComplaintStatusRepository;

import net.lilylnx.springnet.core.exception.ValidationException;

/**
 * 
 * @author Long Nguyen
 * @version $Id: ComplaintService.java,v 1.0 Sep 11, 2011 6:24:44 AM nguyenlong Exp $
 */
public class ComplaintService {
  
  @Autowired
  private ComplaintRepository complaintRepo;
  
  @Autowired
  private ComplaintStatusRepository statusRepo;
  
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

    complaintRepo.insert(complaint);
  }
  
  public void setStatusAccepted(Complaint complaint) {
    ComplaintStatus status = statusRepo.get(ComplaintStatus.ACCEPTED);
    complaint.setStatus(status);
  }
  
  public Serializable add(User user, Equipment equip, String title, String content, CategoryPriority priority) {
    Complaint complaint = new Complaint();
    complaint.setUser(user);
    complaint.setEquipment(equip);
    complaint.setTitle(title);
    complaint.setContent(content);
    complaint.setPriority(priority);
    return complaintRepo.insert(complaint);
  }
  
  public Complaint update(int id, ComplaintStatus status, CategoryPriority priority ) {
    Complaint complaint = complaintRepo.get(id);
    complaint.setStatus(status);
    complaint.setPriority(priority);
    complaintRepo.update(complaint);
    return complaint;
  }

}
