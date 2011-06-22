/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package test.lilylnx.springnet.domains;

/**
 * @author Tien Nguyen
 * @version $Id: User.java,v 1.0 2011/06/16 16:18:26 lilylnx Exp $
 */
public class User {
  
  private String name;
  private String password;
  private String gender;
  private String country;
  private String aboutYou;
  private String[] community;
  private Boolean mailingList;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getGender() {
    return gender;
  }
  
  public void setGender(String gender) {
    this.gender = gender;
  }
  
  public String getCountry() {
    return country;
  }
  
  public void setCountry(String country) {
    this.country = country;
  }
  
  public String getAboutYou() {
    return aboutYou;
  }
  
  public void setAboutYou(String aboutYou) {
    this.aboutYou = aboutYou;
  }
  
  public String[] getCommunity() {
    return community;
  }
  
  public void setCommunity(String[] community) {
    this.community = community;
  }
  
  public Boolean getMailingList() {
    return mailingList;
  }
  
  public void setMailingList(Boolean mailingList) {
    this.mailingList = mailingList;
  }

}
