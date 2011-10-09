/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.controller;

import java.io.Serializable;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: ResponseMessage.java,v 1.0 2011/10/06 18:16:09 lilylnx Exp $
 */
public class ResponseMessage implements Serializable {

  private static final long serialVersionUID = 2842002646786043775L;

  private String name;
  private int status;
  private String message;
  
  public ResponseMessage(String name, int status, String message) {
    this.name = name;
    this.status = status;
    this.message = message;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getStatus() {
    return status;
  }
  
  public void setStatus(int status) {
    this.status = status;
  }
  
  public String getMessage() {
    return message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
  
  public void setStatusAndMessage(int status, String message) {
    this.status = status;
    this.message = message;
  }

}

class RName {
  public static final String ADD = "add";
  public static final String UPDATE = "update";
}

class RStatus {
  public static final int FAIL = 0;
  public static final int SUCC = 1;
  public static final int ERROR = 4;
}
