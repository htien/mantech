/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.api;

/**
 * Được dùng để thực thi mã bên trong môi trường SpringNet.
 * 
 * @author Tien Nguyen
 * @version $Id: SpringNet.java,v 1.0 2011/06/24 1:29:45 lilylnx Exp $
 */
public class SpringNet {
  
  public static void execute(SpringExecutionContext executionContext) {
    try {
      executionContext.execute();
    }
    catch (Exception e) {
    }
    finally {
    }
  }

}
