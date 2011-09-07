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
 * @author Tien Nguyen
 * @version $Id: A.java,v 1.0 Sep 7, 2011 1:17:32 AM lilylnx Exp $
 */
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private byte id;

  @Column(name = "name", unique = true, nullable = false, length = 20)
  private String name;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "userid")
  private List<User> users;

  public UserRole() {}

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

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

}
