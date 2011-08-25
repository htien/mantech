/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.exception;

/**
 * @author Tien Nguyen
 * @version $Id: ValidationException.java,v 1.0 2011/06/23 2:29:52 lilylnx Exp $
 */
public class ValidationException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  
  public ValidationException(String message) {
    super(message);
  }

}
