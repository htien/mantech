/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import mantech.domain.Complaint;
import mantech.repository.ComplaintRepository;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: ComplaintDAO.java,v 1.0 2011/09/07 2:07:59 lilylnx Exp $
 */
public class ComplaintDAO extends HibernateGenericDAO<Complaint> implements ComplaintRepository {

  public ComplaintDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @SuppressWarnings("unchecked")
  public List<Complaint> getOrderByCategoryId() {
    Criteria c = session().createCriteria(persistClass, "a").createCriteria("user").createCriteria("department", "depart").createCriteria("a.priority", "p");
    // c.addOrder(Order.asc("depart.id"));
    c.addOrder(Order.asc("p.id"));
    return c.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> getByWeekly(Date begin, Date end) {
    // Criteria c = session().createCriteria(persistClass);
    // c.add(Restrictions.between("createDate", begin, end));
    Query q = session().createQuery("from Complaint as u where datediff(day, u.createDate, :end) >= 0 and datediff(day, u.createDate, :end) <= 7").setDate("end", end);
    return (List<Complaint>)q.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> getByDepartment(byte id) {
    Criteria c = session().createCriteria(persistClass).createCriteria("user").createCriteria("department", "depart");
    c.add(Restrictions.eq("depart.id", id));
    return c.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> getByPriority(byte id) {
    Criteria c = session().createCriteria(persistClass).createCriteria("priority", "p");
    c.add(Restrictions.eq("p.id", id));
    return c.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchByFName(String name) {
    Criteria c = session().createCriteria(persistClass).createCriteria("user", "u");
    c.add(Restrictions.ilike("u.firstName", "%" + name + "%"));
    return c.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchStartWithFName(String name) {
    Criteria c = session().createCriteria(persistClass).createCriteria("user", "u");
    c.add(Restrictions.ilike("u.firstName", name + "%"));
    return c.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchStartWithLName(String name) {
    Criteria c = session().createCriteria(persistClass).createCriteria("user", "u");
    c.add(Restrictions.ilike("u.lastName", name + "%"));
    return c.list();
  }

}
