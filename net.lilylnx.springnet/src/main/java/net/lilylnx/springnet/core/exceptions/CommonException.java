/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.exceptions;

/**
 * @author Tien Nguyen
 * @version $Id: CommonException.java,v 1.0 2011/06/23 3:25:46 lilylnx Exp $
 */
public class CommonException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  
  public CommonException(String message) {
    super(message);
  }
  
  public CommonException(String message, Throwable t) {
    super(message, t);
    this.setStackTrace(t.getStackTrace());
  }
  
  public CommonException(Throwable t) {
    this.setStackTrace(t.getStackTrace());
  }

}
