/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.tags;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang.StringUtils;

import net.lilylnx.springnet.util.ConfigKeys;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: URLTag.java,v 1.0 2011/10/06 21:07:58 lilylnx Exp $
 */
public class URLTag extends JTienTag {
  
  public static final String URL_ENCODE = "UTF-8";
  
  private String address;
  private boolean encode;
  
  /* (non-Javadoc)
   * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
   */
  @Override
  public void doTag() throws JspException, IOException {
    StringBuilder urlBuilder = new StringBuilder(255)
        .append(this.request().getContextPath());
    
    if (encode) {
      if (this.address == null) {
        this.address = "";
      }
      
      String[] addresses = this.address.split("/");
      for (String _address : addresses) {
        if (StringUtils.isNotEmpty(_address)) {
          urlBuilder.append("/").append(URLEncoder.encode(_address, URL_ENCODE));
        }
      }
    }
    else {
      urlBuilder.append(this.address);
    }
    
    if (!address.equals("/")) {
      urlBuilder.append(this.config().getString(ConfigKeys.SERVLET_EXTENSION));
    }

    this.write(this.response().encodeURL(urlBuilder.toString()));
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public void setEncode(boolean encode) {
    this.encode = encode;
  }

}
