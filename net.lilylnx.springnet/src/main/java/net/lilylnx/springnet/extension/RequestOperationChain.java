/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.extension;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Lớp này được khai báo trong cấu hình SpringNet. Phương thức <code>callAllOperations()</code>
 * được đặt trong hàm <code>service()</code> có tác dụng xử lý các hành động phụ trước khi
 * servlet nhận xử lý request. Tác dụng của lớp này cũng khá giống Filter về mô hình,
 * nhưng khác ở chỗ Filter xử lý có thể trực tiếp xử lý request, chuyển hướng request
 * và response về client; còn lớp này chủ yếu thực thi những class có implements
 * <code>RequestOperation</code>.
 * 
 * Lưu ý: Class có implement <code>RequestOperation</code> được khai báo trong cấu hình
 * SpringNet mới có thể được thực thi.
 * 
 * @author Tien Nguyen
 * @version $Id: RequestOperationChain.java,v 1.0 2011/08/16 17:35:48 lilylnx Exp $
 */
public class RequestOperationChain implements ApplicationContextAware {
  
  private ApplicationContext applicationContext;
  private List<String> operations = new ArrayList<String>();

  public void setOperations(List<String> operations) {
    this.operations = operations;
  }

  /**
   * Thực thi tất cả các class có implements <code>RequestOperation</code>.
   */
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
