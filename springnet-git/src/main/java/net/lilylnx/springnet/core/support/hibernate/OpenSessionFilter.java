/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.support.hibernate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import net.lilylnx.springnet.util.ConfigKeys;

/**
 * @author Tien Nguyen
 * @version $Id: OpenSessionFilter.java,v 1.0 2011/08/21 7:49:25 lilylnx Exp $
 */
public class OpenSessionFilter implements Filter {
  
  private ServletContext servletContext;
  private SessionFactory sessionFactory;

  /* (non-Javadoc)
   * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
   */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    servletContext = filterConfig.getServletContext();
  }

  /* (non-Javadoc)
   * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {      
    ensureSessionFactoryIsInitialized();

    try {
      openAndBindSession();
      chain.doFilter(request, response);
      commitAndCloseSession();
    }
    catch (Exception e) {
      try {
        if (sessionFactory.getCurrentSession().getTransaction().isActive()) {
          sessionFactory.getCurrentSession().getTransaction().rollback();
        }
        closeSession();
      }
      catch (Exception e2) {}
      
      throw new ServletException(e);
    }
    finally {
      try {
        TransactionSynchronizationManager.unbindResource(sessionFactory);
      }
      catch (IllegalStateException e) {}
    }
  }

  /* (non-Javadoc)
   * @see javax.servlet.Filter#destroy()
   */
  @Override
  public void destroy() {
    if (sessionFactory != null && !sessionFactory.isClosed()) {
      sessionFactory.close();
    }
  }

  private void ensureSessionFactoryIsInitialized() {
    if (sessionFactory == null) {
      ApplicationContext beanFactory = (ApplicationContext)servletContext.getAttribute(ConfigKeys.SPRING_CONTEXT);
      sessionFactory = (SessionFactory)beanFactory.getBean(SessionFactory.class);
    }
  }

  private void openAndBindSession() throws HibernateException {
    TransactionSynchronizationManager.bindResource(sessionFactory,
        new SessionHolder(sessionFactory.openSession()));
    sessionFactory.getCurrentSession().beginTransaction();
  }

  private void commitAndCloseSession() {
    sessionFactory.getCurrentSession().getTransaction().commit();
    closeSession();
  }

  private void closeSession() {
    if (sessionFactory.getCurrentSession().isOpen()
        && sessionFactory.getCurrentSession().isConnected())
    {
      sessionFactory.getCurrentSession().close();
    }
  }

}
