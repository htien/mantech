package mantech.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Long Nguyen
 * @version $Id: CategoryPriority.java,v 1.0 2011/09/6 6:16:50 longnguyen Exp $
 */
@Entity
@Table(name = "category_priority")
public class CategoryPriority implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  private byte id;

  @Column(name = "name", nullable = false, length = 10)
  private String name;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  private List<Category> categories;
  
  public CategoryPriority() {}

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

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

}
