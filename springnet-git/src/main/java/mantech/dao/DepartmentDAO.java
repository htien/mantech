/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.Department;
import mantech.repository.DepartmentRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: DepartmentDAO.java,v 1.0 2011/09/07 2:12:28 lilylnx Exp $
 */
public class DepartmentDAO extends HibernateGenericDAO<Department> implements DepartmentRepository {

  public DepartmentDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
