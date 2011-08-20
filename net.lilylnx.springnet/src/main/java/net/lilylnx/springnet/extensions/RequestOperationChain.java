/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.extensions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Tien Nguyen
 * @version $Id: RequestOperationChain.java,v 1.0 2011/08/16 17:35:48 lilylnx Exp $
 */
public class RequestOperationChain implements ApplicationContextAware {
  
  private ApplicationContext applicationContext;
  
  private List<String> operations = new ArrayList<String>();

  public void setOperations(List<String> operations) {
    this.operations = operations;
  }

  public void callAllOperations() {
    for (String operationClassName : this.operations) {
      RequestOperation operation = (RequestOperation)this.applicationContext.getBean(operationClassName);
      operation.execute();
    }
  }

  /*
   * (non-Javadoc)
   * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

}
