/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.lilylnx.springnet.core.exception.SpringException;

/**
 * 
 * @author Rafael Steil
 * @author James Yong
 * @author Tien Nguyen
 * @version $Id: I18n.java,v 1.0 2011/10/06 21:23:17 lilylnx Exp $
 */
public class I18n {
  
  private Map<String, Properties> messages = new HashMap<String, Properties>();
  private Properties localeNames = new Properties();
  private String defaultLocaleName;
  private SpringConfig config;
  
  public I18n(SpringConfig config) {
    this.config = config;
    this.loadConfiguration();
  }
  
  /**
   * Loads a new Language. If <code>language</code> is either null or empty,
   * or if it is already loaded, the method will return without executing any code.
   * The language file will be merged with the default board language.
   * @param language The language to load
   */
  public void load(String language) {
    this.loadLanguage(language, defaultLocaleName);
  }
  
  /**
   * Gets an I18n message from the default board locale.
   * 
   * @param key The message key
   * @return String with the localized message
   */
  public String getMessage(String key) {
    return this.getMessage(key, defaultLocaleName);
  }
  
  /**
   * Gets an I18n message.
   * 
   * @param key  The message name to retrieve. Must be a valid entry into the file
   * specified by <code>i18n.file</code> property.
   * @param language language The locale name to load the message from. If it is not loaded yet,
   * a load operation will be automatically called. In case of failure to find the
   * requested message in such locale, the default board locale will be used.
   * 
   * @return String With the localized message
   */
  public String getMessage(String key, String language) {
    Properties p = this.messages.get(language);
    
    if (p == null) {
      this.load(language);
      p = this.messages.get(language);
    }
    
    return p.getProperty(key);
  }

  /**
   * @see #getMessage(String, String, Object[])
   * @param key String
   * @param args Object
   * @return String
   */
  public String getFormattedMessage(String key, Object[] args) {
    return this.getFormattedMessage(key, defaultLocaleName, args);
  }
  
  /**
   * Gets a I18N message.
   * 
   * @param key The message name to retrieve. Must be a valid entry into the file specified by
   * <code>i18n.file</code> property.
   * @param language The locale name to retrieve the messages from
   * @param args Parameters needed by some messages. The messages with extra parameters are formated according to
   * {@link java.text.MessageFormat}specification
   *
   * @return String With the message
   */
  public String getFormattedMessage(String key, String language, Object[] args) {
    return MessageFormat.format(this.messages.get(language).getProperty(key), args);
  }
  
  public Object[] params(Object... args) {
    return args;
  }
  
  /**
   * Check whether the language file is loaded.
   * 
   * @param language
   * @return boolean
   */
  public boolean isLanguageLoaded(String language) {
    return this.messages.containsKey(language);
  }
  
  /**
   * Check if the given language exist.
   * 
   * @param language The language to check
   * @return <code>true</code> if the language is a valid and registered translation.
   */
  public boolean languageExists(String language) {
    return this.localeNames.getProperty(language) != null;
  }
  
  /**
   * Load all configured locale names.
   * @throws IOException 
   */
  private void loadLocales() {
    try {
      this.localeNames.load(this.getClass().getResourceAsStream(ConfigKeys.SPRING_LOCALE_PROPS_PATH));
    }
    catch (IOException e) {
      throw new SpringException(e);
    }
  }
  
  public void changeDefaultLanguage(String newDefaultLanguage) {
    if (!isLanguageLoaded(newDefaultLanguage)) {
      this.loadLanguage(newDefaultLanguage, this.config.getString(ConfigKeys.I18N_DEFAULT_ADMIN));
    }
    
    this.defaultLocaleName = newDefaultLanguage;
  }
  
  /**
   * Load a language file.
   * 
   * @param language the language name to load
   * @param mergeWith if not null, merge the language file with the language
   * specified in this parameter
   */
  private void loadLanguage(String language, String mergeWith) {
    Properties languageProps = new Properties();
    
    if (mergeWith != null) {
      if (!this.isLanguageLoaded(mergeWith)) {
        this.loadLanguage(mergeWith, null);
      }
      
      languageProps.putAll(this.messages.get(mergeWith));
    }
    
    try {
      InputStream resource = this.getClass().getResourceAsStream(ConfigKeys.SPRING_LANGUAGES_PATH + this.localeNames.getProperty(language));
      languageProps.load(new InputStreamReader(resource, this.config.getString(ConfigKeys.ENCODING)));
    }
    catch (IOException e) {
      throw new SpringException(e);
    }
    
    this.messages.put(language, languageProps);
  }
  
  /**
   * Start I18n, loading the locales list and default language boards.
   */
  private void loadConfiguration() {
    this.loadLocales();
    
    this.defaultLocaleName = this.config.getString(ConfigKeys.I18N_DEFAULT_ADMIN);
    this.loadLanguage(defaultLocaleName, null);
    
    String custom = this.config.getString(ConfigKeys.I18N_DEFAULT);
    
    if (!custom.equals(defaultLocaleName)) {
      this.load(custom);
      this.defaultLocaleName = custom;
    }
  }

}
