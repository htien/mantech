/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.CategoryPriority;
import mantech.repository.CategoryPriorityRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: CategoryPriorityDAO.java,v 1.0 2011/09/07 2:06:28 lilylnx Exp $
 */
public class CategoryPriorityDAO extends HibernateGenericDAO<CategoryPriority> implements CategoryPriorityRepository {

  public CategoryPriorityDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
