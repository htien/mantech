/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.exception;

/**
 * @author Tien Nguyen
 * @version $Id: SpringException.java,v 1.0 2011/06/22 15:42:11 lilylnx Exp $
 */
public class SpringException extends RuntimeException {

  private static final long serialVersionUID = -9056943938959563869L;
  
  public SpringException(String message) {
    super(message);
  }
  
  public SpringException(String message, Throwable t) {
    super(message, t);
    this.setStackTrace(t.getStackTrace());
  }
  
  public SpringException(Throwable t) {
    super(t);
    this.setStackTrace(t.getStackTrace());
  }

}
