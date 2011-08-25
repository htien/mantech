/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.util;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import net.lilylnx.springnet.core.exception.CommonException;

/**
 * @author Tien Nguyen
 * @version $Id: SpringConfig.java,v 1.0 2011/06/22 23:06:30 lilylnx Exp $
 */
public class SpringConfig extends PropertiesConfiguration {

  public SpringConfig() {
    try {
      loadProps();
    }
    catch (Exception e) {
      throw new CommonException(e.getMessage());
    }
  }
  
  public String getApplicationPath() {
    return this.getString(ConfigKeys.APPLICATION_PATH);
  }

  private void loadProps() throws ConfigurationException, Exception {
    this.load(this.getClass().getResourceAsStream(ConfigKeys.SYSTEMGLOBALS_PROPS_PATH));
    this.loadCustomProperties();
  }

  private void loadCustomProperties() throws Exception {
    InputStream is = this.getClass().getResourceAsStream(ConfigKeys.SPRING_CUSTOM_PROPS_PATH);

    if (is != null) {
      Properties custom = new Properties();
      custom.load(is);

      for (Enumeration<?> e = custom.keys(); e.hasMoreElements();) {
        String key = (String)e.nextElement();
        this.clearProperty(key);
        this.addProperty(key, custom.getProperty(key));
      }
    }
  }
}
