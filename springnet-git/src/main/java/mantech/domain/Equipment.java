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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: Equipment.java,v 1.0 2011/09/07 00:18:51 lilylnx Exp $
 */
@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

  private static final long serialVersionUID = -600771171039285206L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
  private Category category;

  @Column(name = "name", unique = true, nullable = false, length = 50)
  private String name;

  @OneToMany(mappedBy = "equipment", fetch = FetchType.LAZY)
  private List<Complaint> complaints;

  public Equipment() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
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
