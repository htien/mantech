package mantech.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Long Nguyen
 * @version $Id: ComplaintStatus.java,v 1.0 2011/09/07 00:44:49 longnguyen Exp $
 */
@Entity
@Table(name = "complaint_status")
public class ComplaintStatus implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private byte id;

  @Column(name = "name", unique = true, nullable = false, length = 15)
  private String name;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "status_id")
  private List<Complaint> complaints;

  public ComplaintStatus() {}

  public byte getId() {
    return id;
  }

  public void setId(byte id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Complaint> getComplaints() {
    return complaints;
  }

  public void setComplaints(List<Complaint> complaints) {
    this.complaints = complaints;
  }

}
