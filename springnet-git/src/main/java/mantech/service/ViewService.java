/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.service;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: ViewService.java,v 1.0 Oct 3, 2011 3:27:58 PM lilylnx Exp $
 */
public class ViewService {

  private String name;
  
  protected ViewService() {}

  protected String getViewName() {
    return name;
  }
  
  protected void setViewName(String name) {
    this.name = name;
  }

}