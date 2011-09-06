/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.ComplaintStatus;
import mantech.repository.ComplaintStatusRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: ComplaintPriorityDAO.java,v 1.0 2011/09/07 2:11:46 lilylnx Exp $
 */
public class ComplaintPriorityDAO extends HibernateGenericDAO<ComplaintStatus> implements ComplaintStatusRepository {

  public ComplaintPriorityDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
