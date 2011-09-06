/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.Category;
import mantech.repository.CategoryRepository;

/**
 * @author Long Nguyen
 * @version $Id: CategoryDAO.java,v 1.0 2011/09/06 1:57:05 longnguyen Exp $
 */
public class CategoryDAO extends HibernateGenericDAO<Category> implements CategoryRepository {

  public CategoryDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
