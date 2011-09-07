package mantech.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Long Nguyen
 * @version $Id: B.java,v 1.0 2011/09/06 19:11:18 longnguyen Exp $
 */
@Entity
@Table(name = "department")
public class Department implements Serializable {

  private static final long serialVersionUID = 2338433186378287102L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private byte id;

  @Column(name = "name", unique = true, nullable = false, length = 20)
  private String name;

  @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
  private List<User> users;

  public Department() {}

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
