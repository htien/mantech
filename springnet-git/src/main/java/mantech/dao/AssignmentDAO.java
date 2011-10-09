/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import mantech.domain.Assignment;
import mantech.repository.AssignmentRepository;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: AssignmentDAO.java,v 1.0 2011/09/07 2:03:47 lilylnx Exp $
 */
public class AssignmentDAO extends HibernateGenericDAO<Assignment> implements AssignmentRepository {

  public AssignmentDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Assignment> getExist(boolean deleted) {
    return session().createCriteria(persistClass)
        .add(Restrictions.eq("isDeleted", deleted)).list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Assignment> getByUserId(int id) {
    return session().createCriteria(persistClass).createCriteria("users", "u")
        .add(Restrictions.eq("u.id",id)).list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Assignment> getCompleted(byte id) {
    return session().createQuery("select distinct a from Assignment a, Complaint c inner join c.status s" +
    		" where s.id = :id").setInteger("id", id).list();
  }

}
