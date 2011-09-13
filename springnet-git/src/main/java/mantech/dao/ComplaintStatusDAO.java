/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import mantech.domain.ComplaintStatus;
import mantech.repository.ComplaintStatusRepository;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

/**
 * @author Long Nguyen
 * @version $Id: ComplaintStatusDAO.java,v 1.0 2011/09/14 2:19:28 nguyenlong Exp $
 */
public class ComplaintStatusDAO extends HibernateGenericDAO<ComplaintStatus> implements ComplaintStatusRepository {

  public ComplaintStatusDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
