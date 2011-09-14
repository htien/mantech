/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.User;
import mantech.repository.UserRepository;

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

  /*
   * (non-Javadoc)
   * @see mantech.repository.UserRepository#getUserByRole(int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<User> getUserByRole(int id) {
    return session().createQuery("from User u inner join u.role r where r.id = :id")
        .setInteger("id", id).list();
  }

  /*s
   * (non-Javadoc)
   * @see mantech.repository.UserRepository#getUserByRole(java.lang.String)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<User> getUserByRole(String name) {
    return session().createQuery("from User u inner join u.role r where r.name = :name")
        .setString("name", name).list();
  }

}
