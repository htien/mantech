/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import org.hibernate.SessionFactory;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

import mantech.domain.RequestPassword;
import mantech.repository.RequestPasswordRepository;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: RequestPasswordDAO.java,v 1.0 2011/09/07 2:14:10 lilylnx Exp $
 */
public class RequestPasswordDAO extends HibernateGenericDAO<RequestPassword> implements RequestPasswordRepository {

  public RequestPasswordDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
