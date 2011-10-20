/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

import mantech.domain.UserSession;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: SecurityInterceptor.java,v 1.0 2011/10/20, 2011 20:38:36 lilylnx Exp $
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

  /* (non-Javadoc)
   * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    ApplicationContext beanFactory = (ApplicationContext)request.getServletContext().getAttribute(ConfigKeys.SPRING_CONTEXT);
    UserSession userSession = (UserSession)request.getAttribute(ConfigKeys.USER_SESSION);
    SpringConfig config = beanFactory.getBean(SpringConfig.class);

    if (!userSession.isLogged()) {
      response.sendRedirect(config.getContextPath());
      return false;
    }

    return super.preHandle(request, response, handler);
  }

  /* (non-Javadoc)
   * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
   */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {   
    super.postHandle(request, response, handler, modelAndView);
  }

}
