/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.util;

import net.lilylnx.jcafe.crypto.Algorithms;

/**
 * @author Tien Nguyen
 * @version $Id: ConfigKeys.java,v 1.0 2011/06/22 16:34:43 lilylnx Exp $
 */
public class ConfigKeys {

  public static final String EXT = ".htm";
  public static final String SERVLET_EXTENSION = "servlet.extension";
  
  public static final String LOG4J_XML_PATH = "/META-INF/log4j.xml";
  public static final String SPRING_PROPS_PATH = "/META-INF/springnet.properties";
  public static final String SPRING_CUSTOM_PROPS_PATH = "/META-INF/springnet-custom.properties";
  public static final String APPLICATION_PATH = "application.path";
  public static final String CONFIG = "config";
  public static final String DB_PASSWD = "db.passwd";
  public static final String DB_ENCRYPTED_PASSWD = "db.passwd.enc";
  
  public static final String SPRING_CONTEXT = "springnetContext";
  public static final String CODENAME = "name";
  public static final String VERSION = "version";
  public static final String CONTEXT_PATH = "context.path";
  public static final String ENCODING = "encoding";
  
  public static final String AUTHENTICATION_TYPE = "authentication.type";
  public static final String LOGIN_AUTHENTICATOR = "login.authenticator";
  public static final String TYPE_SSO = "sso";
  public static final String USERPWD_ALGOR = Algorithms.WHIRLPOOL_HASH;
  
  public static final String SSO_LOGOUT_REDIRECT = "sso.logout.redirect";
  
  public static final String ANONYMOUS_USER_ID = "anonymous.userId";
  public static final String ROLE_MANAGER = "roleManager";
  public static final String USER_SESSION = "userSession";

  public static final String HTTP_SERVLET_RESPONSE = "springnet.http.servlet.response";
  
  private ConfigKeys() {}
  
}
