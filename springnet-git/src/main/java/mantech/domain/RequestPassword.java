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
 * @author Long Nguyen
 * @version $Id: RequestPassword.java,v 1.0 2011/09/06 19:15:36 longnguyen Exp $
 */
@Entity
@Table(name = "request_password")
public class RequestPassword implements Serializable {

  private static final long serialVersionUID = 6122546410636047300L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
  private User user;

  @Column(name = "requestdate")
  private Date requestDate;

  public RequestPassword() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getRequestDate() {
    return requestDate;
  }

  public void setRequestDate(Date requestDate) {
    this.requestDate = requestDate;
  }

}
