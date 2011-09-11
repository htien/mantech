/**
 * Written by Long Nguyen <chautinhlong@gmail.com>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Long Nguyen
 * @version $Id: SpringUtils.java,v 1.0 2011/09/12 01:16:51 nguyenlong Exp $
 */
public class SpringUtils {
  
  /**
   * Increase 1 day by default.
   */
  public static Date increaseDay(Date date) {
    return increaseDay(date, 1);
  }
  
  /**
   * Increase n days.
   * 
   * @param date
   * @param numOfDays
   * @return
   */
  public static Date increaseDay(Date date, int numOfDays) {
    if (numOfDays < 0) {
      numOfDays = 0;
    }
    
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, numOfDays);
    return calendar.getTime();
  }

}
