/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.repository;

import net.lilylnx.springnet.repository.Repository;

import mantech.domain.ComplaintStatus;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: ComplaintStatusRepository.java,v 1.0 2011/09/07 1:58:33 lilylnx Exp $
 */
public interface ComplaintStatusRepository extends Repository<ComplaintStatus> {

  ComplaintStatus get(byte id);
  
}
