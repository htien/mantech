/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import mantech.domain.Student;
import mantech.repository.StudentRepository;









import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

/**
 * @author Tien Nguyen
 * @version $Id: StudentDAO.java,v 1.0 2011/08/24 15:54:25 lilylnx Exp $
 */
public class StudentDAO extends HibernateGenericDAO<Student> implements StudentRepository {

  public StudentDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
