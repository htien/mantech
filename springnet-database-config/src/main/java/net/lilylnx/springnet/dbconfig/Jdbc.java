/*
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.dbconfig;

/**
 *
 * @author Tien Nguyen
 * @version $Id: Jdbc.java,v 1.0 2011/08/30 23:56:33 lilylnx Exp $
 */
public class Jdbc {

  private String serverName;
  private String portNumber;
  private String databaseName;
  private String userName;
  private String password;
  private String driverClass;
  private String url;
  private String defaultSchema;
  
  public Jdbc() {}

  public String getServerName() {
    return serverName;
  }
  
  public void setServerName(String serverName) {
    this.serverName = serverName;
  }

  public String getPortNumber() {
    return portNumber;
  }
  
  public void setPortNumber(String portNumber) {
    this.portNumber = portNumber;
  }

  public String getDatabaseName() {
    return databaseName;
  }
  
  public void setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
  }

  public String getUserName() {
    return userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }

  public String getDriverClass() {
    return driverClass;
  }
  
  public void setDriverClass(String driverClass) {
    this.driverClass = driverClass;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDefaultSchema() {
    return defaultSchema;
  }

  public void setDefaultSchema(String defaultSchema) {
    this.defaultSchema = defaultSchema;
  }

  public String getTestUrl() {
    return new StringBuilder("jdbc:jtds:sqlserver://")
            .append(serverName).append(":").append(portNumber)
            .append("/").append(databaseName)
            .append(";user=").append(userName)
            .append(";password=").append(password)
            .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj instanceof Jdbc) {
      Jdbc jdbc  = (Jdbc)obj;
      return this.serverName.equals(jdbc.getServerName()) &&
             this.portNumber.equals(jdbc.getPortNumber()) &&
             this.databaseName.equals(jdbc.getDatabaseName()) &&
             this.userName.equals(jdbc.getUserName()) &&
             this.password.equals(jdbc.getPassword()) &&
             this.driverClass.equals(jdbc.getDriverClass()) &&
             this.defaultSchema.equals(jdbc.getDefaultSchema());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + (this.serverName != null ? this.serverName.hashCode() : 0);
    hash = 83 * hash + (this.portNumber != null ? this.portNumber.hashCode() : 0);
    hash = 83 * hash + (this.databaseName != null ? this.databaseName.hashCode() : 0);
    hash = 83 * hash + (this.userName != null ? this.userName.hashCode() : 0);
    hash = 83 * hash + (this.password != null ? this.password.hashCode() : 0);
    hash = 83 * hash + (this.driverClass != null ? this.driverClass.hashCode() : 0);
    hash = 83 * hash + (this.defaultSchema != null ? this.defaultSchema.hashCode() : 0);
    return hash;
  }

}
