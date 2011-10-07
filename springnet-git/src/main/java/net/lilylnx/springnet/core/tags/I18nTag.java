/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;

import net.lilylnx.springnet.util.I18n;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: I18nTag.java,v 1.0 2011/10/06 22:50:01 lilylnx Exp $
 */
public class I18nTag extends JTienTag implements DynamicAttributes {
  
  private static I18n i18n;
  private String key;
  private List<Object> params = new ArrayList<Object>();
  
  public I18nTag() {
    if (i18n == null) {
      i18n = this.getBean(I18n.class);
    }
  }
  
  /* (non-Javadoc)
   * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
   */
  @Override
  public void doTag() throws JspException, IOException {
    if (this.params.size() == 0) {
      String message = i18n.getMessage(this.key);
      
      if (message == null) {
        throw new IllegalArgumentException(this.key + " was not found.");
      }
      
      this.write(message);
    }
    else {
      String message = i18n.getFormattedMessage(key, this.params.toArray());
      
      if (message == null) {
        throw new IllegalArgumentException(this.key + " was not found.");
      }
      
      this.write(message);
    }
  }
  
  public void setKey(String key) {
    this.key = key;
  }

  /* (non-Javadoc)
   * @see javax.servlet.jsp.tagext.DynamicAttributes#setDynamicAttribute(java.lang.String, java.lang.String, java.lang.Object)
   */
  @Override
  public void setDynamicAttribute(String url, String localeName, Object value) throws JspException {
    params.add(value);
  }

}
