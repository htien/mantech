/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: SpringUtils.java,v 1.0 2011/09/12 01:16:51 lilylnx Exp $
 */
public class SpringUtils {

  public static Date increaseDay(final Date date) {
    return increaseDay(date, 1);
  }

  public static Date increaseDay(final Date date, int numOfDays) {
    return increateDate(Calendar.DATE, date, numOfDays);
  }
  
  public static Date increaseMonth(final Date date) {
    return increaseMonth(date, 1);
  }
  
  public static Date increaseMonth(final Date date, int numOfMonths) {
    return increateDate(Calendar.MONTH, date, numOfMonths);
  }
  
  public static Date increaseYear(final Date date) {
    return increaseYear(date, 1);
  }
  
  public static Date increaseYear(final Date date, int numOfYear) {
    return increateDate(Calendar.YEAR, date, numOfYear);
  }
  
  private static Date increateDate(int dateType, final Date date, int num) {
    num = num < 0 ? 0 : num;

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(dateType, num);
    return calendar.getTime();
  }

}
