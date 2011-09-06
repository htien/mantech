/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.AssignmentDetail;
import mantech.repository.AssignmentDetailRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: AssignmentDetailDAO.java,v 1.0 2011/09/07 2:05:06 lilylnx Exp $
 */
public class AssignmentDetailDAO extends HibernateGenericDAO<AssignmentDetail> implements AssignmentDetailRepository {

  public AssignmentDetailDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
