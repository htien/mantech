/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package springext.lilylnx.springnet.core;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import freemarker.ext.jsp.TaglibFactory;
import freemarker.ext.servlet.ServletContextHashModel;

/**
 * @author Tien Nguyen
 * @version $Id: SpringViewResolver.java,v 1.0 2011/08/14 17:12:30 lilylnx Exp $
 */
public class SpringViewResolver extends AbstractTemplateViewResolver {

  private ServletContextHashModel servletContextModel;
  private TaglibFactory taglibFactory;

  public SpringViewResolver() {
    setViewClass(SpringView.class);
  }

  @Override
  protected Class<SpringView> requiredViewClass() {
    return SpringView.class;
  }

  public void setServletContextModel(ServletContextHashModel servletContextModel) {
    this.servletContextModel = servletContextModel;
  }

  public void setTaglibFactory(TaglibFactory taglibFactory) {
    this.taglibFactory = taglibFactory;
  }

  @Override
  protected AbstractUrlBasedView buildView(String viewName) throws Exception {
    SpringView view = (SpringView)super.buildView(viewName);
    view.setServletContextModel(servletContextModel);
    view.setTaglibFactory(taglibFactory);
    return view;
  }
}
