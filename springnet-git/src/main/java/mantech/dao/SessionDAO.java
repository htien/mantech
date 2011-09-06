/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.Session;
import mantech.repository.SessionRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: SessionDAO.java,v 1.0 2011/09/07 2:14:55 lilylnx Exp $
 */
public class SessionDAO extends HibernateGenericDAO<Session> implements SessionRepository {

  public SessionDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
