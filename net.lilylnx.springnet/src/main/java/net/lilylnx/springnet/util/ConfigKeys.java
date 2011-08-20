/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.util;

/**
 * @author Tien Nguyen
 * @version $Id: ConfigKeys.java,v 1.0 2011/06/22 16:34:43 lilylnx Exp $
 */
public class ConfigKeys {

  public static final String EXT = ".htm";
  public static final String SERVLET_EXTENSION = "servlet.extension";
  
  public static final String LOG4J_XML_PATH = "/META-INF/log4j.xml";
  public static final String SYSTEMGLOBALS_PROPS_PATH = "/META-INF/SystemGlobals.properties";
  public static final String SPRING_CUSTOM_PROPS_PATH = "/META-INF/spring-custom.properties";
  public static final String APPLICATION_PATH = "application.path";
  public static final String CONFIG = "config";
  
  public static final String SPRING_CONTEXT = "springnetContext";
  public static final String VRAPTOR_CONTEXT = "webApplication";
  public static final String VRAPTOR_VIEW_PATTERN = "vraptor.view.pattern";
  
  public static final String VERSION = "version";
  
  public static final String ANONYMOUS_USER_ID = "anonymous.userId";
  public static final String ROLE_MANAGER = "roleManager";
  public static final String USER_SESSION = "userSession";

  public static final String HTTP_SERVLET_RESPONSE = "springnet.http.servlet.response";
  public static final String IGNORE_VIEW_MANAGER_REDIRECT = "ignore.viewmanager.redirect";
  public static final String RENDER_CUSTOM_LOGIC = "render.custom.logic";
  public static final String RENDER_CUSTOM_COMPONENT = "render.custom.component";
  
  private ConfigKeys() {}
  
}
