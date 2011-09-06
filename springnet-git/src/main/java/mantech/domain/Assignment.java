/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: Assignment.java,v 1.0 2011/09/06 23:04:06 lilylnx Exp $
 */
@Entity
@Table(name = "assignment")
public class Assignment implements Serializable {

  private static final long serialVersionUID = -6955930714914496180L;

  @Id
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "complaint_id", referencedColumnName = "id")
  private Complaint complaint;

  @Column(name = "begindate", nullable = false)
  private Date beginDate;

  @Column(name = "duration", nullable = false)
  private short duration;

  @Column(name = "deleted", nullable = false, insertable = false)
  private boolean isDeleted;

  @Column(name = "createdate", nullable = false, insertable = false, updatable = false)
  private Date createDate;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "complaint_id")
  private List<AssignmentDetail> assignmentDetails;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "assignment_detail", joinColumns = { @JoinColumn(name = "complaint_id") }, inverseJoinColumns = { @JoinColumn(name = "userid") })
  private List<User> users;

  public Assignment() {}

  public Complaint getComplaint() {
    return complaint;
  }

  public void setComplaint(Complaint complaint) {
    this.complaint = complaint;
  }

  public Date getBeginDate() {
    return beginDate;
  }

  public void setBeginDate(Date beginDate) {
    this.beginDate = beginDate;
  }

  public short getDuration() {
    return duration;
  }

  public void setDuration(short duration) {
    this.duration = duration;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public List<AssignmentDetail> getAssignmentDetails() {
    return assignmentDetails;
  }

  public void setAssignmentDetails(List<AssignmentDetail> assignmentDetails) {
    this.assignmentDetails = assignmentDetails;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

}
