/*
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.dbconfig;

import java.sql.DriverManager;

/**
 *
 * @author Tien Nguyen
 * @version $Id: TestConnection.java,v 1.0 2011/08/30 21:39:50 lilylnx Exp $
 */
public class TestConnection implements Runnable {

  private MainFrame mainFrame;
  private Jdbc jdbc;
  
  public TestConnection(MainFrame mainFrame, Jdbc jdbc) {
    this.mainFrame = mainFrame;
    this.jdbc = jdbc;
  }

  @Override
  public void run() {
    try {
      Class.forName(jdbc.getDriverClass());
      DriverManager.getConnection(jdbc.getTestUrl());
      mainFrame.actionAfterTestConn();
    }
    catch (ClassNotFoundException e) {
      mainFrame.actionAfterTestConn(App.ERROR_CLASS_NOT_FOUND, e);
    }
    catch (Exception e) {
      mainFrame.actionAfterTestConn(App.ERROR_UNKNOWN, e);
    }
  }

}
