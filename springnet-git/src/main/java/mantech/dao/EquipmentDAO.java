/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import java.util.List;

import org.hibernate.Criteria;
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

  @SuppressWarnings("unchecked")
  @Override
  public List<Equipment> paginate(int[] range) {
    Criteria c = session().createCriteria(persistClass);
    c.setMaxResults(range[0]).setFirstResult((range[1]-1)*range[0]);
    return c.list();
  }
  
}
