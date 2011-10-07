/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.core.tags;

import java.util.List;

/**
 * Misc functions.
 * 
 * @author Tien Nguyen
 * @version $Id: Functions.java,v 1.0 Oct 6, 2011 11:11:21 PM lilylnx Exp $
 */
public class Functions {
  
  public static boolean contains(@SuppressWarnings("rawtypes") List list, Object element) {
    return list.contains(element);
  }
  
  /**
   * Calculate the last page of something.
   * 
   * @param totalPosts the total of records
   * @param postsPerPage the number of records per page
   * @return the max possible page
   */
  public static int lastPage(int totalRecords, int recordsPerPage) {
    return (int)Math.ceil((double)totalRecords / (double)recordsPerPage);
  }

}
