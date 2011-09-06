/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.Assignment;
import mantech.repository.AssignmentRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: AssignmentDAO.java,v 1.0 2011/09/07 2:03:47 lilylnx Exp $
 */
public class AssignmentDAO extends HibernateGenericDAO<Assignment> implements AssignmentRepository {

  public AssignmentDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
