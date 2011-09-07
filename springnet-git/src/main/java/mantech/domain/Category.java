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
 * @author Long Nguyen
 * @version $Id: Category.java,v 1.0 2011/09/06 5:47:32 longnguyen Exp $
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

  private static final long serialVersionUID = 2917356619946307194L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "priority_id", nullable = false)
  private CategoryPriority priority;

  @Column(name = "name", unique = true, nullable = false, length = 30)
  private String name;

  @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
  private List<Equipment> equipments;

  public Category() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public CategoryPriority getPriority() {
    return priority;
  }

  public void setPriority(CategoryPriority priority) {
    this.priority = priority;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Equipment> getEquipments() {
    return equipments;
  }

  public void setEquipments(List<Equipment> equipments) {
    this.equipments = equipments;
  }

}
