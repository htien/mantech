package net.lilylnx.springnet.core.support.freemarker;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import freemarker.ext.jsp.TaglibFactory;
import freemarker.ext.servlet.FreemarkerServlet;
import freemarker.ext.servlet.HttpRequestHashModel;
import freemarker.ext.servlet.ServletContextHashModel;
import freemarker.template.ObjectWrapper;

/**
 * @version $Id: TaglibFreeMarkerView.java,v 1.1 2005/07/04 15:02:14 turelto Exp $
 */
public class TaglibFreeMarkerView extends FreeMarkerView {

  private ServletContextHashModel servletContextModel;
  private TaglibFactory taglibFactory;

  public void setServletContextModel(ServletContextHashModel servletContextModel) {
    this.servletContextModel = servletContextModel;
  }

  public void setTaglibFactory(TaglibFactory taglibFactory) {
    this.taglibFactory = taglibFactory;
  }

  protected void doRender(Map model, HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    exposeModelAsRequestAttributes(model, request);
    if (servletContextModel != null) {
      model.put(FreemarkerServlet.KEY_APPLICATION, servletContextModel);
    }
    if (taglibFactory != null) {
      model.put(FreemarkerServlet.KEY_JSP_TAGLIBS, taglibFactory);
    }
    model.put(FreemarkerServlet.KEY_REQUEST,
        new HttpRequestHashModel(request, response, ObjectWrapper.DEFAULT_WRAPPER));
    super.doRender(model, request, response);
  }

  protected void exposeModelAsRequestAttributes(Map model, HttpServletRequest request) throws Exception {
    Iterator it = model.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry)it.next();
      if (!(entry.getKey() instanceof String)) {
        throw new ServletException("Invalid key [" + entry.getKey() + "] in model Map - only Strings allowed as model keys");
      }
      String modelName = (String)entry.getKey();
      Object modelValue = entry.getValue();
      if (modelValue != null) {
        request.setAttribute(modelName, modelValue);
        if (logger.isDebugEnabled()) {
          logger.debug("Added model object '" + modelName + "' of type [" + modelValue.getClass().getName() + "] to request in TaglibFreeMarkerView '" + getBeanName() + "'");
        }
      }
      else {
        request.removeAttribute(modelName);
        if (logger.isDebugEnabled()) {
          logger.debug("Removed model object '" + modelName + "' from request in TaglibFreeMarkerView '" + getBeanName() + "'");
        }
      }
    }
  }
}
