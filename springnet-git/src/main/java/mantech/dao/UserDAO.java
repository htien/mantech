/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import mantech.domain.User;
import mantech.repository.UserRepository;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: UserDAO.java,v 1.0 2011/09/07 2:15:44 lilylnx Exp $
 */
public class UserDAO extends HibernateGenericDAO<User> implements UserRepository {

  public UserDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  /*
   * (non-Javadoc)
   * @see mantech.repository.UserRepository#getByUsername(java.lang.String)
   */
  @Override
  public User getByUsername(String username) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * @see mantech.repository.UserRepository#validateUser(java.lang.String, java.lang.String)
   */
  @Override
  public User validateUser(String username, String password) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * L^ấy 2 người d`ung từ sau vị trí cụ th^ể trong database.
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<User> getUserByRole() {
    Criteria crit = session().createCriteria(persistClass, "u").createCriteria("role", "r");
    crit.add(Restrictions.eq("r.name", "employee"));
    return crit.list();
  }

  @Override
  public List<User> getUsersSumComplaint() {
    Query q = session().createQuery("select count(, u.* from User u");
    return null;
  }

}
