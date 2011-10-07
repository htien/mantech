/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.util;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: Pagination.java,v 1.0 2011/10/06 19:58:32 lilylnx Exp $
 */
public class Pagination {
  
  private int totalPages;
  private long totalRecords;
  private int recordsPerPage;
  private int thisPage;
  private int id;
  private int start;
  private String baseUrl;
  
  private SpringConfig config;
  
  public Pagination() {}
  
  public Pagination(SpringConfig config, int page) {
    this.config = config;
    this.start = page;
  }
  
  public Pagination(long totalRecords, int recordsPerPage, int page, String baseUrl, int id) {
    this.totalRecords = totalRecords;
    this.recordsPerPage = recordsPerPage;
    this.baseUrl = baseUrl;
    this.id = id;
    this.totalPages = this.calculateTotalPages();
    this.start = this.calculateStartFromCount(page, this.recordsPerPage);
    this.thisPage = this.calculateThisPage(page);
  }
  
  private int calculateThisPage(int page) {
    return Math.min(this.totalPages, Math.max(1, page));
  }
  
  private int calculateStart(int page, int recordsPerPage) {
    return page <= 1 ? 0 : (page - 1) * recordsPerPage;
  }
  
  private int calculateStartFromCount(int count, int recordsPerPage) {
    return count / recordsPerPage + (count % recordsPerPage > 0 ? 0 : 1);
  }
  
  private int calculateTotalPages() {
    return (int)Math.ceil((double)this.totalRecords / (double)this.recordsPerPage);
  }

}
