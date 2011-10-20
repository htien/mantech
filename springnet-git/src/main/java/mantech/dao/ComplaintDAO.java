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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import mantech.domain.Complaint;
import mantech.repository.ComplaintRepository;

import net.lilylnx.springnet.core.hibernate.HibernateGenericDAO;
import net.lilylnx.springnet.util.SpringUtils;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: ComplaintDAO.java,v 1.0 2011/09/07 2:07:59 lilylnx Exp $
 */
public class ComplaintDAO extends HibernateGenericDAO<Complaint> implements ComplaintRepository {

  public ComplaintDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Override
  public int countByStatus(byte status) {
    return session().createQuery("select count(c.status.id) from Complaint as c" +
        " where c.status.id = :id").setByte("id", status).uniqueResult().hashCode();
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> getByWeekly(Date begin, Date end) {
    return session().createQuery("from Complaint as u where" +
    		" datediff(day, u.createDate, :end) >= 0 and datediff(day, u.createDate, :end) <= 7")
    		.setDate("end", end).list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> getByDepartment(byte id) {
    return session().createCriteria(persistClass).createCriteria("user").createCriteria("department", "depart")
        .add(Restrictions.eq("depart.id", id)).list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> getByPriority(byte id) {
    return session().createCriteria(persistClass)
        .add(Restrictions.eq("priority.id", id)).list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> getCurrentMonthByDepartment(byte id) {
    return session().createQuery("select c from" +
        " Complaint c inner join c.user u inner join u.department d where" +
        " datepart(month, c.createDate) = datepart(month, getdate())" +
        " and d.id = :id").setByte("id", id).list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> getCurrentYearByDepartment(byte id) {
    return session().createQuery("select c from" +
        " Complaint c inner join c.user u inner join u.department d where" +
        " datepart(year, c.createDate) = datepart(year, getdate())" +
        " and d.id = :id").setByte("id", id).list();
  }


  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchByFName(String name) {
    return session().createCriteria(persistClass).createCriteria("user", "u")
        .add(Restrictions.ilike("u.firstName", "%" + name + "%"))
        .list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchStartWithFName(String name) {
    return session().createCriteria(persistClass).createCriteria("user", "u")
        .add(Restrictions.ilike("u.firstName", name + "%"))
        .list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchStartWithLName(String name) {
    return session().createCriteria(persistClass).createCriteria("user", "u")
        .add(Restrictions.ilike("u.lastName", name + "%"))
        .list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> sort(String fieldName, boolean order, int[] range) {
    List<Complaint> listComplaint = null;
    
    if (fieldName.contains(".")) {
      String[] entity = fieldName.split("\\.");
      String _order = !order ? "asc" : "desc";
      Query q = session().createQuery("select c from Complaint c left join "
                + "c." + entity[0].trim() + " e order by e." + entity[1].trim() + " " + _order);
      if (range != null) {
        q.setMaxResults(range[0]).setFirstResult((range[1]-1)*range[0]);
      }
      listComplaint = q.list();
    }
    else {
      Criteria c = session().createCriteria(persistClass);
      c.setMaxResults(range[0]).setFirstResult((range[1]-1)*range[0]);
      if (range != null) {
        c.addOrder(!order ? Order.asc(fieldName) : Order.asc(fieldName));
      }
      listComplaint = c.list();
    }

    return listComplaint;
  }

  @Override
  public List<Complaint> searchByDate(Date date) {
    return searchByDate(date, date);
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchByDate(Date from, Date to) {
    return session().createQuery("from Complaint c where c.createDate >= :from and c.createDate < :to")
        .setDate("from", from).setDate("to", SpringUtils.increaseDay(to))
        .list();
  }
  

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchByMonth(int month) {
    return session().createQuery("from Complaint c where datepart(month, c.createDate) = :month")
        .setInteger("month", month).list();
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchByCurrentMonth() {
    return session().createQuery("from Complaint c where datepart(month, c.createDate) =" +
    		" datepart(month, getdate())").list();
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchByYear(int year) {
    return session().createQuery("from Complaint c where datepart(year, c.createDate) = :year")
        .setInteger("year", year).list();
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> searchByCurrentYear() {
    return session().createQuery("from Complaint c where datepart(year, c.createDate) =" +
    		" datepart(year, getdate())").list();
  }

  @Override
  public int countByDate(Date date) {
    return ((Long)session().createQuery("select count(c.id) from Complaint c" +
    		" where c.createDate >= :date1 and c.createDate <= :date2)")
        .setDate("date1", date)
        .setDate("date2", SpringUtils.increaseDay(date))
        .uniqueResult()).intValue();
  }
  
  @Override
  public int countByWeek(int week) {
    return ((Integer)session().createSQLQuery("select count(c.id) from Complaint c" +
    		" where datepart(week, c.createDate) = :week")
    		.setInteger("week", week).uniqueResult()).intValue();
  }
  
  @Override
  public int getCurrentWeek() {
    return ((Integer)session().createSQLQuery("select DISTINCT DATEPART(week, c.createdate) from complaint c" +
        " where DATEPART(week, c.createdate) = DATEPART(week, GETDATE())")
        .uniqueResult()).intValue();
  }
 
  @Override
  public int summaryInMonth(int month) {
    return ((Long)session().createQuery("select count(c.id) from Complaint c" +
    		" where datepart(month, c.createDate) = :month").setInteger("month", month)
    		.uniqueResult()).intValue();
  }

  @Override
  public int summaryInCurrentMonth() {
    return ((Long)session().createQuery("select count(c.id) from Complaint c" +
        " where datepart(month, c.createDate) = datepart(month, getdate())")
        .uniqueResult()).intValue();
  }

  @Override
  public int summaryInCurrentMonthByDepart(byte id) {
    return ((Integer)session().createSQLQuery("select count(c.id) from" +
        " complaint c, [user] u, department d where" +
        " c.userid = u.id and u.department_id = d.id" +
        " and datepart(month, c.createdate) = datepart(month, getdate())" +
        " and d.id = :id").setByte("id", id).uniqueResult()).intValue();
  }

  @Override
  public int summaryInYear(int year) {
    return ((Long)session().createQuery("select count(c.id) from Complaint c" +
        " where datepart(year, c.createDate) = :year").setInteger("year", year)
        .uniqueResult()).intValue();
  }

  @Override
  public int summaryInCurrentYear() {
    return ((Long)session().createQuery("select count(c.id) from Complaint c" +
        " where datepart(year, c.createDate) = datepart(year, getdate())")
        .uniqueResult()).intValue();
  }
  

  @Override
  public int summaryInCurrentYearByDepart(byte id) {
    return ((Integer)session().createSQLQuery("select count(c.id) from" +
        " complaint c, [user] u, department d where" +
        " c.userid = u.id and u.department_id = d.id" +
        " and datepart(year, c.createdate) = datepart(year, getdate())" +
        " and d.id = :id").setByte("id", id).uniqueResult()).intValue();
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> getByAssignment() {
    Query q = session().createQuery("select c from Complaint c inner join c.assignment");
    return q.list();
  }

  @Override
  public int insert(Complaint complaint) {
    return session().createSQLQuery("insert into complaint(userid, equipment_id, title, [content], priority_id)" +
    		" values (:userid, :equipment_id, :title, :content, :priority_id)")
    		.setInteger("userid", complaint.getUser().getId())
    		.setInteger("equipment_id", complaint.getEquipment().getId())
    		.setString("title", complaint.getTitle())
    		.setString("content", complaint.getContent())
    		.setInteger("priority_id", complaint.getPriority().getId())
    		.executeUpdate();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> getWaitingComplaint() {
    return session().createQuery("select c from Complaint c where c.id not in (select complaintId from Assignment)")
        .list();
  }

  @Override
  public boolean isExist(int id) {
    return ((Long)session().createQuery("select count(id) from Complaint where id = :id")
        .setInteger("id", id).uniqueResult()).longValue() > 0;
  }
  
  @Override
  public boolean hasAssignmentId(int id) {    
    return ((Long)session().createQuery("select count(complaintId) from Assignment where complaintId = :id")
        .setInteger("id", id).uniqueResult()).longValue() > 0;
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Complaint> search(String username, String equipName, Date dateFrom, Date dateTo, byte status, byte priority) {
    Criteria crit = session().createCriteria(persistClass, "c");
    Criterion critDateFrom = dateFrom != null ? Restrictions.ge("c.createDate", dateFrom) : null,
              critDateTo = dateTo != null ? Restrictions.lt("c.createDate", SpringUtils.increaseDay(dateTo)) : null;

    if (username != null) {
      crit.createCriteria("c.user", "u").add(Restrictions.ilike("u.username", "%" + username + "%"));
    }
    if (equipName != null) {
      crit.createCriteria("c.equipment", "e").add(Restrictions.ilike("e.name", "%" + equipName + "%"));
    }
    if (status >= 1 && status <= 4) {
      crit.createCriteria("c.status", "s").add(Restrictions.eq("s.id", status));
    }
    if (priority >= 1 && priority <= 5) {
      crit.createCriteria("c.priority", "p").add(Restrictions.eq("p.id", priority));
    }
    crit = critDateFrom != null ? crit.add(critDateFrom) : crit;
    crit = critDateTo != null ? crit.add(critDateTo) : crit;
    
    return crit.list();
  }





}
