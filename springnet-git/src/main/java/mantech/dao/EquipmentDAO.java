/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.Equipment;
import mantech.repository.EquipmentRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: EquipmentDAO.java,v 1.0 2011/09/07 2:13:20 lilylnx Exp $
 */
public class EquipmentDAO extends HibernateGenericDAO<Equipment> implements EquipmentRepository {

  public EquipmentDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
