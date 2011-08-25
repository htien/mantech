/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
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
 * @version $Id: Address.java,v 1.0 Aug 24, 2011 3:32:14 PM lilylnx Exp $
 */
@Entity
@Table(name = "Address")
public class Address implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "city", nullable = false, length = 20)
  private String city;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  private List<Student> students;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public List<Student> getStudents() {
    return students;
  }
  
  public void setStudents(List<Student> students) {
    this.students = students;
  }

}
