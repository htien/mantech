/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.UserRole;
import mantech.repository.UserRoleRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: UserRoleDAO.java,v 1.0 2011/09/07 2:16:45 lilylnx Exp $
 */
public class UserRoleDAO extends HibernateGenericDAO<UserRole> implements UserRoleRepository {

  public UserRoleDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
