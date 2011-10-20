/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: Session.java,v 1.0 2011/09/03 3:44:49 lilylnx Exp $
 */
@Entity
@Table(name = "sessions")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Session implements Serializable {

  private static final long serialVersionUID = -1966837774183429166L;

  @Id
  @Column(name = "userid")
  private int userId;
  
  @Column(name = "start")
  private Date start;
  
  @Column(name = "lastaccess")
  private Date lastAccessed;
  
  @Column(name = "lastvisit")
  private Date lastVisit;
  
  @Column(name = "ip")
  private String ip;

  public Session() {}

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getLastAccessed() {
    return lastAccessed;
  }

  public void setLastAccessed(Date lastAccessed) {
    this.lastAccessed = lastAccessed;
  }

  public Date getLastVisit() {
    return lastVisit;
  }

  public void setLastVisit(Date lastVisit) {
    this.lastVisit = lastVisit;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

}
