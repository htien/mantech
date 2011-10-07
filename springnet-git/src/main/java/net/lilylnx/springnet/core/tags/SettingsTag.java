/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: SettingsTag.java,v 1.0 2011/10/06 20:58:16 lilylnx Exp $
 */
@Configurable
public class SettingsTag extends JTienTag {
  
  private String key;
  
  /* (non-Javadoc)
   * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
   */
  @Override
  public void doTag() throws JspException, IOException {
    this.write(this.config().getString(this.key));
  }
  
  public void setKey(String key) {
    this.key = key;
  }

}
