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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: User.java,v 1.0 2011/06/27 16:05:18 lilylnx Exp $
 */
@Entity
@Table(name = "[user]")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User implements Serializable {

  private static final long serialVersionUID = -5466464499894166834L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
  private UserRole role;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
  private Department department;

  @Column(name = "email", unique = true, nullable = false, length = 127)
  private String email;

  @Column(name = "username", unique = true, nullable = false, length = 63)
  private String username;

  @Column(name = "passwd", nullable = false, length = 255)
  private String password;

  @Column(name = "regdate", nullable = false, insertable = false, updatable = false)
  private Date regDate;

  @Column(name = "lastvisit", insertable = false)
  private Date lastVisit;

  @Column(name = "deleted", nullable = false, insertable = false)
  private boolean deleted;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "gender", nullable = false, length = 1)
  private String gender;

  @Column(name = "homeaddr", length = 70)
  private String homeAddress;

  @Column(name = "status", length = 1, insertable = false)
  private String status;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<Complaint> complaints;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<RequestPassword> reqPasswds;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "assignment_detail", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = { @JoinColumn(name = "complaint_id") })
  private List<Assignment> assignments;

  public User() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  public Date getLastVisit() {
    return lastVisit;
  }

  public void setLastVisit(Date lastVisit) {
    this.lastVisit = lastVisit;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.deleted = isDeleted;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<Complaint> getComplaints() {
    return complaints;
  }

  public void setComplaints(List<Complaint> complaints) {
    this.complaints = complaints;
  }

  public List<RequestPassword> getReqPasswds() {
    return reqPasswds;
  }

  public void setReqPasswds(List<RequestPassword> reqPasswds) {
    this.reqPasswds = reqPasswds;
  }

  public List<Assignment> getAssignments() {
    return assignments;
  }

  public void setAssignments(List<Assignment> assignments) {
    this.assignments = assignments;
  }

}
