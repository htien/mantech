/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import mantech.domain.AssignmentDetail;
import mantech.repository.AssignmentDetailRepository;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: AssignmentDetailDAO.java,v 1.0 2011/09/07 2:05:06 lilylnx Exp $
 */
public class AssignmentDetailDAO extends HibernateGenericDAO<AssignmentDetail> implements AssignmentDetailRepository {

  public AssignmentDetailDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<AssignmentDetail> getByComplaint(int id) {
    return session().createQuery("select d from AssignmentDetail d" +
    		" where d.assignment.complaintId = :id")
    		.setInteger("id", id)
    		.list();
  }

  @Override
  public int countAssignDetailNotCompleted(int id) {
    return ((Long)session().createQuery("select count(s.id) from AssignmentDetail s" +
    		" where s.assignment.complaintId = :id" +
    		" and s.completeDate is null").setInteger("id", id).uniqueResult()).intValue();
  }

}
