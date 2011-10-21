/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.repository;

import java.util.Date;
import java.util.List;

import net.lilylnx.springnet.repository.Repository;

import mantech.domain.Complaint;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: ComplaintRepository.java,v 1.0 2011/09/07 1:57:39 lilylnx Exp $
 */
public interface ComplaintRepository extends Repository<Complaint> {
  
  List<Complaint> sort(String fieldName, boolean order, int[] range);
  
  int countByStatus(byte status);
  
  List<Complaint> getByWeekly(Date begin, Date end);
  List<Complaint> getByDepartment(byte id);
  List<Complaint> getByPriority(byte id);
  List<Complaint> getByAssignment();
  List<Complaint> getWaitingComplaint();
  List<Complaint> getCurrentMonthByDepartment(byte id);
  List<Complaint> getCurrentYearByDepartment(byte id);

  List<Complaint> searchByFName(String name);
  List<Complaint> searchStartWithFName(String name);
  List<Complaint> searchStartWithLName(String name);
  List<Complaint> searchByDate(Date date);
  List<Complaint> searchByDate(Date from, Date to);
  
  List<Complaint> searchByMonth(int month);
  List<Complaint> searchByCurrentMonth();
  List<Complaint> searchByYear(int year);
  List<Complaint> searchByCurrentYear();
  List<Complaint> search(String username, String equipName, Date dateFrom, Date dateTo, byte status, byte priority);
  
  int countByDate(Date date);
  int countByWeek(int week);
  
  int summaryInMonth(int month);
  int summaryInCurrentMonth();
  int summaryInCurrentMonthByDepart(byte id);
  int summaryInYear(int year);
  int summaryInCurrentYear();
  int summaryInCurrentYearByDepart(byte id);
  
  boolean isExist(int id);
  boolean hasAssignmentId(int id);
  int insert(Complaint complaint);
  
}
