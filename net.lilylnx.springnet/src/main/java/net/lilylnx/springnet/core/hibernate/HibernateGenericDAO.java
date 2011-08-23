/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.hibernate;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.lilylnx.springnet.repository.Repository;

/**
 * @author Tien Nguyen
 * @version $Id: HibernateGenericDAO.java,v 1.0 2011/06/24 1:54:03 lilylnx Exp $
 */
public abstract class HibernateGenericDAO<T> implements Repository<T> {

  protected Class<T> persistClass;
  private SessionFactory sessionFactory;
  
  @SuppressWarnings("unchecked")
  public HibernateGenericDAO(SessionFactory sessionFactory) {
    this.persistClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
    this.sessionFactory = sessionFactory;
  }

  protected Session session() {
    return sessionFactory.getCurrentSession();
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public T get(int id) {
    return (T)this.session().get(persistClass, id);
  }
  
  /* (non-Javadoc)
   * @see net.lilylnx.springnet.repository.Repository#add(java.lang.Object)
   */
  @Override
  public void add(T entity) {
    this.session().save(entity);
  }
  
  /* (non-Javadoc)
   * @see net.lilylnx.springnet.repository.Repository#remove(java.lang.Object)
   */
  @Override
  public void remove(T entity) {
    this.session().delete(entity);
  }
  
  /* (non-Javadoc)
   * @see net.lilylnx.springnet.repository.Repository#update(java.lang.Object)
   */
  @Override
  public void update(T entity) {
    this.session().update(entity);
  }

}
