/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: AssignmentDetail.java,v 1.0 2011/09/06 23:40:48 lilylnx Exp $
 */
@Entity
@Table(name = "assignment_detail")
public class AssignmentDetail implements Serializable {

  private static final long serialVersionUID = -3614966497036810182L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "complaint_id", nullable = false)
  private Assignment assignment;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "userid", nullable = false)
  private User user;

  @Column(name = "completedate")
  private Date completeDate;

  public AssignmentDetail() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Assignment getAssignment() {
    return assignment;
  }

  public void setAssignment(Assignment assignment) {
    this.assignment = assignment;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getCompleteDate() {
    return completeDate;
  }

  public void setCompleteDate(Date completeDate) {
    this.completeDate = completeDate;
  }

}
