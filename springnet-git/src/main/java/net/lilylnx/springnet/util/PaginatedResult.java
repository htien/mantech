/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.util;

import java.util.List;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: PaginatedResult.java,v 1.0 2011/10/14 00:11:39 lilylnx Exp $
 */
public class PaginatedResult<T> {
  
  protected List<T> results;
  protected int totalRecords;
  
  public PaginatedResult(List<T> results, int totalRecords) {
    this.results = results;
    this.totalRecords = totalRecords;
  }

  public List<T> getResults() {
    return this.results;
  }

  public int getTotalRecords() {
    return this.totalRecords;
  }

}
