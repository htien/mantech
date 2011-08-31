/*
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.dbconfig;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import it.sauronsoftware.junique.AlreadyLockedException;
import it.sauronsoftware.junique.JUnique;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.jasypt.intf.service.JasyptStatelessService;

/**
 *
 * @author Tien Nguyen
 * @version $Id: App.java,v 1.0 2011/08/30 1:58:43 lilylnx Exp $
 */
public class App {

  public static final byte ERROR_UNKNOWN = 1;
  public static final byte ERROR_CLASS_NOT_FOUND = 2;
  public static final String PATH = "net/lilylnx/springnet/dbconfig/";
  public static final String ALGORITHM = "PBEWithSHA1AndRC2_40";
  public static final String PASSWORD_ENC_KEY = "SPRINGNET_ENCRYPTION_PWD";
  public static final String INTERATIONS = "1024";

  public static void main(String[] args) {
    setLookAndFeel();
    boolean start = preventMultiInstances();

    if (start) {
      java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
          new MainFrame().setVisible(true);
        }
      });
    }
  }
  
  public static void testConnection(MainFrame mainFrame, Jdbc jdbc) {
    Thread testConnection = new Thread(new TestConnection(mainFrame, jdbc));
    testConnection.start();
  }
  
  public static String encrypt(String cleartext) throws NullPointerException {
    final JasyptStatelessService service = new JasyptStatelessService();
    return service.encrypt(cleartext, System.getenv(PASSWORD_ENC_KEY),
            null, null, ALGORITHM, null, null, INTERATIONS, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null);
  }
  
  public static String loadTextFile(Object owner, String path) {
    if (path.charAt(0) != '/') {
      path = "/" + path;
    }
    InputStream is = owner.getClass().getResourceAsStream(path);
    StringBuilder sb = new StringBuilder();
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
    }
    catch (Exception e) {}
    return sb.toString();
  }

  private static boolean preventMultiInstances() {
    String appName = App.class.getName();
    try {
      JUnique.acquireLock(appName);
      return true;
    }
    catch (AlreadyLockedException e) {
      JOptionPane.showMessageDialog(null, "The application have already running.",
              "Warning!", JOptionPane.WARNING_MESSAGE);
      return false;
    }
  }

  private static void setLookAndFeel() {
    try {
      UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
              JOptionPane.ERROR_MESSAGE);
    }
  }

}
