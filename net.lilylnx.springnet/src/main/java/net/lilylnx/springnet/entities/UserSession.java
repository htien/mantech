/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.entities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Lưu trữ thông tin về một session người dùng.
 * 
 * @author Tien Nguyen
 * @version $Id: UserSession.java,v 1.0 2011/06/26 20:22:20 lilylnx Exp $
 */
public class UserSession {

  @SuppressWarnings("unused")
  private static final Logger logger = Logger.getLogger(UserSession.class);

  public UserSession() {
    DOMConfigurator.configure("");
  }

}
