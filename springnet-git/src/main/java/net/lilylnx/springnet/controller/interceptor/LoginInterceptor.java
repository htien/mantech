/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.lilylnx.springnet.util.ConfigKeys;
import net.lilylnx.springnet.util.SpringConfig;

import mantech.domain.UserSession;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: LoginInterceptor.java,v 1.0 2011/10/20 23:17:47 PM lilylnx Exp $
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
  
  /**
   * Chuyển hướng vào trang admin khi người dùng đã đăng nhập. 
   * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    ApplicationContext beanFactory = (ApplicationContext)request.getServletContext().getAttribute(ConfigKeys.SPRING_CONTEXT);
    UserSession userSession = (UserSession)request.getAttribute(ConfigKeys.USER_SESSION);
    SpringConfig config = beanFactory.getBean(SpringConfig.class);

    if (userSession.isLogged()) {
      response.sendRedirect(request.getContextPath() + "/index" + config.getServletExt());
    }

    return super.preHandle(request, response, handler);
  }

}
