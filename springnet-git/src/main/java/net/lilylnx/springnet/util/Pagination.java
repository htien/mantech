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
  
  public Pagination forUsers(int totalUsers) {
    this.totalRecords = totalUsers;
    this.recordsPerPage = config.getInt(ConfigKeys.USERS_PER_PAGE, 25);
    this.totalPages = this.calculateTotalPages();
    this.thisPage = this.calculateThisPage(this.start);
    this.start = this.calculateStart(this.start, this.recordsPerPage);
    this.baseUrl = String.format("#%s", "listuser");
    this.id = 0;
    
    return this;
  }
  
  public int getTotalPages() {
    return this.totalPages;
  }
  
  public long getTotalRecords() {
    return this.totalRecords;
  }
  
  public int getRecordsPerPage() {
    return this.recordsPerPage;
  }
  
  public int getThisPage() {
    return this.thisPage;
  }
  
  public int getId() {
    return this.id;
  }
  
  public int getStart() {
    return this.start;
  }
  
  public String getBaseUrl() {
    return this.baseUrl;
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
