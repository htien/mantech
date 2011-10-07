/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: TemplateResourceTag.java,v 1.0 2011/10/06 21:03:22 lilylnx Exp $
 */
public class TemplateResourceTag extends JTienTag {
  
  private String item;

  /* (non-Javadoc)
   * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
   */
  @Override
  public void doTag() throws JspException, IOException {
    String path = new StringBuilder(255)
        .append(this.request().getContextPath())
        .append("/_")
        .append(this.item)
        .toString();

    this.write(path);
  }
  
  public void setItem(String item) {
    this.item = item;
  }

}
