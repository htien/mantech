/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package mantech.domain;

import java.io.Serializable;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: UserStats.java,v 1.0 Sep 9, 2011 1:11:44 PM lilylnx Exp $
 */
public class UserStats implements Serializable {

  private static final long serialVersionUID = -2416550068234304906L;

  private String username;

  private int count;

  public UserStats(String username) {
    this.username = username;
    //this.count = count;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

}
