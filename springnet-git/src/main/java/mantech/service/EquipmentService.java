/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mantech.domain.Equipment;
import mantech.repository.EquipmentRepository;

/**
 * @author Long Nguyen
 * @version $Id: EquipmentService.java,v 1.0 Sep 12, 2011 3:01:46 PM nguyenlong Exp $
 */
public class EquipmentService {
  
  @Autowired
  private EquipmentRepository equipmentRepo;
  
  public List<Equipment> paginate(int page){
    return equipmentRepo.paginate(new int[] {5, page});
  }
  
}
