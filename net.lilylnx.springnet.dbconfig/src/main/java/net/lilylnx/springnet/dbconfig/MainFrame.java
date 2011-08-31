/*
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.dbconfig;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import net.lilylnx.jcafe.JCafeUtil;
import net.lilylnx.jcafe.JPaneUtil;

/**
 *
 * @author Tien Nguyen
 * @version $Id: MainFrame.java,v 1.0 2011/08/30 2:53:25 lilylnx Exp $
 */
public class MainFrame extends JFrame {

  private static final long serialVersionUID = 4763653296382116181L;
  private Jdbc jdbc;

  /** Creates new form MainFrame */
  public MainFrame() {
    super("SpringNet Database Configuration");
    initComponents();
    setFrameConfig();
    JPaneUtil.addPanel(pCenter, pJdbc);
  }
  
  public void actionAfterTestConn(){
    goSuccessPanel("Test connection... successfully!");
    btnCreate.setEnabled(true);
  }
  
  public void actionAfterTestConn(int i, Exception e) {
    switch (i) {
      case App.ERROR_CLASS_NOT_FOUND:
        JOptionPane.showMessageDialog(this, "Class not found: " + e.getMessage(),
                "Error: Class not found", JOptionPane.ERROR_MESSAGE);
        break;
      
      case App.ERROR_UNKNOWN:
        JOptionPane.showMessageDialog(this, e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        break;
    }
    btnCreate.setEnabled(false);
    goJdbcPanel();
  }
  
  public void goJdbcPanel() {
    JPaneUtil.addPanel(pCenter, pJdbc);
  }
  
  public void goSuccessPanel(String message) {
    lbSuccessMsg.setText(message);
    JPaneUtil.addPanel(pCenter, pSuccess);
  }
  
  private void goImpSettingsPanel() {
    JPaneUtil.addPanel(pCenter, pImpSets);
  }
  
  private void goConnectingPanel() {
    JPaneUtil.addPanel(pCenter, pConnecting);
  }
  
  private void goHelpPanel() {
    JPaneUtil.addPanel(pCenter, pHelp);
  }
  
  private void quit() {
    System.exit(0);
  }
  
  private void setFrameConfig() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 400);
    setLocationRelativeTo(null);
    setResizable(false);
    setFrameIcon(App.PATH + "images/home.png");
  }
  
  private void setFrameIcon(String url) {
    setIconImage(JCafeUtil.loadImageIcon(this, url).getImage());
  }
  
  private void create() {
    try {
      Properties props = new Properties();
      props.put("db.username", String.format("ENC(%s)", App.encrypt(jdbc.getUserName())));
      props.put("db.passwd", String.format("ENC(%s)", App.encrypt(jdbc.getPassword())));
      props.put("db.name", String.format("ENC(%s)", App.encrypt(jdbc.getDatabaseName())));
      props.put("db.url", jdbc.getUrl());
      props.put("db.server.name", jdbc.getServerName());
      props.put("db.server.port", jdbc.getPortNumber());
      props.put("db.default.schema", jdbc.getDefaultSchema());
      props.put("db.dialect", txtDialect.getText().trim());
      props.put("db.driver", jdbc.getDriverClass());
      props.put("db.statistics", ddlAllowStatistics.getSelectedItem().toString());
      props.put("db.cache.enabled", ddlAllowCaching.getSelectedItem().toString());
      props.put("db.debug.show.sql", ddlAllowShowSql.getSelectedItem().toString());
      props.store(new FileOutputStream("database.properties"), "## DATABASE CONFIGURATION ###");
      goSuccessPanel("Created database.properties file.");
    }
    catch (NullPointerException e) {
      JOptionPane.showMessageDialog(this,
              App.PASSWORD_ENC_KEY + " environment variable is not exists.",
              "Exception", JOptionPane.ERROR_MESSAGE);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(this, e.getMessage(),
              "Exception", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  private Jdbc collectJdbcInfo(Jdbc jdbc) {
    if (jdbc == null) {
      jdbc = new Jdbc();
    }
    jdbc.setUserName(txtUname.getText().trim());
    jdbc.setPassword(new String(txtPasswd.getPassword()).trim());
    jdbc.setServerName(txtServer.getText().trim());
    jdbc.setPortNumber(txtPort.getText().trim());
    jdbc.setDatabaseName(txtDatabase.getText().trim());
    jdbc.setDriverClass(txtDriver.getText().trim());
    jdbc.setUrl(txtUrl.getText().trim());
    jdbc.setDefaultSchema(txtDefaultSchema.getText().trim());
    return jdbc;
  }
  
  private boolean validateJdbcInfo(Jdbc jdbc) {
    boolean valid =  StringUtils.isNotBlank(jdbc.getUserName()) &&
            StringUtils.isNotBlank(jdbc.getPassword()) &&
            StringUtils.isNotBlank(jdbc.getServerName()) &&
            StringUtils.isNotBlank(jdbc.getPortNumber()) &&
            StringUtils.isNotBlank(jdbc.getDatabaseName()) &&
            StringUtils.isNotBlank(jdbc.getDriverClass()) &&
            StringUtils.isNotBlank(jdbc.getUrl()) &&
            StringUtils.isNotBlank(txtDefaultSchema.getText());
    
    if (!valid) {
      JOptionPane.showMessageDialog(this, "Please fill completely.",
              "Unavailable", JOptionPane.ERROR_MESSAGE);
    }
    
    return valid;
  }
  
  private void clearForm() {
    txtUname.setText("");
    txtPasswd.setText("");
    txtServer.setText("");
    txtPort.setText("");
    txtDatabase.setText("");
    txtDefaultSchema.setText("dbo");
  }
  
  private String loadHelpDocumentVI(String path) {
    path = App.PATH + path;
    return App.loadTextFile(this, path);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    pJdbc = new javax.swing.JPanel();
    pInputForm = new javax.swing.JPanel();
    lbUname = new javax.swing.JLabel();
    txtUname = new javax.swing.JTextField();
    lbPasswd = new javax.swing.JLabel();
    txtPasswd = new javax.swing.JPasswordField();
    lbUrl = new javax.swing.JLabel();
    txtUrl = new javax.swing.JTextField();
    lbServer = new javax.swing.JLabel();
    txtServer = new javax.swing.JTextField();
    lbPort = new javax.swing.JLabel();
    txtPort = new javax.swing.JTextField();
    lbDatabase = new javax.swing.JLabel();
    txtDatabase = new javax.swing.JTextField();
    pCommand = new javax.swing.JPanel();
    sp2 = new javax.swing.JSeparator();
    btnTestConn = new javax.swing.JButton();
    btnCreate = new javax.swing.JButton();
    btnQuit1 = new javax.swing.JButton();
    btnNext1 = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    pImpSets = new javax.swing.JPanel();
    pImpSettings = new javax.swing.JPanel();
    lbDefaultSchema = new javax.swing.JLabel();
    txtDefaultSchema = new javax.swing.JTextField();
    lbDialect = new javax.swing.JLabel();
    txtDialect = new javax.swing.JTextField();
    lbDriver = new javax.swing.JLabel();
    txtDriver = new javax.swing.JTextField();
    lbAllowStatistics = new javax.swing.JLabel();
    ddlAllowStatistics = new javax.swing.JComboBox();
    lbAllowCaching = new javax.swing.JLabel();
    ddlAllowCaching = new javax.swing.JComboBox();
    lbAllowShowSql = new javax.swing.JLabel();
    ddlAllowShowSql = new javax.swing.JComboBox();
    pSwitchButtons = new javax.swing.JPanel();
    sp3 = new javax.swing.JSeparator();
    btnBack1 = new javax.swing.JButton();
    pConnecting = new javax.swing.JPanel();
    pConnectingContent = new javax.swing.JPanel();
    lbConnecting = new javax.swing.JLabel();
    pConnectingButtons = new javax.swing.JPanel();
    sp4 = new javax.swing.JSeparator();
    btnQuit2 = new javax.swing.JButton();
    lbSmallConnectingImg = new javax.swing.JLabel();
    btnBack2 = new javax.swing.JButton();
    pSuccess = new javax.swing.JPanel();
    pSuccessMsg = new javax.swing.JPanel();
    lbSuccessMsg = new javax.swing.JLabel();
    pSuccessButtons = new javax.swing.JPanel();
    sp5 = new javax.swing.JSeparator();
    btnQuit3 = new javax.swing.JButton();
    btnBack3 = new javax.swing.JButton();
    pHelp = new javax.swing.JPanel();
    pHelpContent = new javax.swing.JPanel();
    tabHelp = new javax.swing.JTabbedPane();
    pVnTab = new javax.swing.JPanel();
    helpScrollPane = new javax.swing.JScrollPane();
    txtHelpContent = new javax.swing.JTextPane();
    pnEnTab = new javax.swing.JPanel();
    pHelpButtons = new javax.swing.JPanel();
    sp6 = new javax.swing.JSeparator();
    btnBack4 = new javax.swing.JButton();
    btnQuit4 = new javax.swing.JButton();
    pFirst = new javax.swing.JPanel();
    pBanner = new javax.swing.JPanel();
    lbTitle = new javax.swing.JLabel();
    lbDesc = new javax.swing.JLabel();
    sp1 = new javax.swing.JSeparator();
    pCenter = new javax.swing.JPanel();

    pJdbc.setLayout(new java.awt.BorderLayout());

    pInputForm.setBackground(new java.awt.Color(255, 255, 255));
    pInputForm.setBorder(javax.swing.BorderFactory.createTitledBorder("JDBC Data Source"));
    pInputForm.setLayout(new java.awt.GridBagLayout());

    lbUname.setText("db.username");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    pInputForm.add(lbUname, gridBagConstraints);

    txtUname.setColumns(8);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pInputForm.add(txtUname, gridBagConstraints);

    lbPasswd.setText("db.passwd");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
    pInputForm.add(lbPasswd, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pInputForm.add(txtPasswd, gridBagConstraints);

    lbUrl.setText("db.url");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    pInputForm.add(lbUrl, gridBagConstraints);

    txtUrl.setBackground(new java.awt.Color(233, 233, 233));
    txtUrl.setEditable(false);
    txtUrl.setText("jdbc:jtds:sqlserver://${db.server.name}:${db.server.port}/${db.name}");
    txtUrl.setCaretPosition(0);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pInputForm.add(txtUrl, gridBagConstraints);

    lbServer.setText("db.server.name");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    pInputForm.add(lbServer, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pInputForm.add(txtServer, gridBagConstraints);

    lbPort.setText("db.server.port");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
    pInputForm.add(lbPort, gridBagConstraints);

    txtPort.setColumns(5);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pInputForm.add(txtPort, gridBagConstraints);

    lbDatabase.setText("db.name");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
    pInputForm.add(lbDatabase, gridBagConstraints);

    txtDatabase.setColumns(10);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 5;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pInputForm.add(txtDatabase, gridBagConstraints);

    pJdbc.add(pInputForm, java.awt.BorderLayout.CENTER);

    pCommand.setPreferredSize(new java.awt.Dimension(0, 50));

    btnTestConn.setText("Test Connection");
    btnTestConn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnTestConnActionPerformed(evt);
      }
    });

    btnCreate.setText("Create");
    btnCreate.setEnabled(false);
    btnCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCreateActionPerformed(evt);
      }
    });

    btnQuit1.setText("Quit");
    btnQuit1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnQuit1ActionPerformed(evt);
      }
    });

    btnNext1.setText("Next >");
    btnNext1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnNext1ActionPerformed(evt);
      }
    });

    jButton1.setText("?");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout pCommandLayout = new javax.swing.GroupLayout(pCommand);
    pCommand.setLayout(pCommandLayout);
    pCommandLayout.setHorizontalGroup(
      pCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(sp2, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
      .addGroup(pCommandLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnTestConn)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButton1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
        .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnQuit1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    pCommandLayout.setVerticalGroup(
      pCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pCommandLayout.createSequentialGroup()
        .addComponent(sp2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
        .addGroup(pCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnTestConn)
          .addComponent(btnQuit1)
          .addComponent(btnCreate)
          .addComponent(btnNext1)
          .addComponent(jButton1))
        .addContainerGap())
    );

    pJdbc.add(pCommand, java.awt.BorderLayout.PAGE_END);

    pImpSets.setLayout(new java.awt.BorderLayout());

    pImpSettings.setBackground(new java.awt.Color(255, 255, 255));
    pImpSettings.setBorder(javax.swing.BorderFactory.createTitledBorder("Important Settings"));
    pImpSettings.setLayout(new java.awt.GridBagLayout());

    lbDefaultSchema.setText("db.default.schema");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    pImpSettings.add(lbDefaultSchema, gridBagConstraints);

    txtDefaultSchema.setColumns(12);
    txtDefaultSchema.setText("dbo");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pImpSettings.add(txtDefaultSchema, gridBagConstraints);

    lbDialect.setText("db.dialect");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    pImpSettings.add(lbDialect, gridBagConstraints);

    txtDialect.setBackground(new java.awt.Color(233, 233, 233));
    txtDialect.setColumns(32);
    txtDialect.setEditable(false);
    txtDialect.setText("org.hibernate.dialect.SQLServerDialect");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pImpSettings.add(txtDialect, gridBagConstraints);

    lbDriver.setText("db.driver");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    pImpSettings.add(lbDriver, gridBagConstraints);

    txtDriver.setBackground(new java.awt.Color(233, 233, 233));
    txtDriver.setEditable(false);
    txtDriver.setText("net.sourceforge.jtds.jdbc.Driver");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pImpSettings.add(txtDriver, gridBagConstraints);

    lbAllowStatistics.setText("db.statistics");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    pImpSettings.add(lbAllowStatistics, gridBagConstraints);

    ddlAllowStatistics.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "true", "false" }));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pImpSettings.add(ddlAllowStatistics, gridBagConstraints);

    lbAllowCaching.setText("db.cache.enabled");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    pImpSettings.add(lbAllowCaching, gridBagConstraints);

    ddlAllowCaching.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "true", "false" }));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pImpSettings.add(ddlAllowCaching, gridBagConstraints);

    lbAllowShowSql.setText("db.debug.show.sql");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
    pImpSettings.add(lbAllowShowSql, gridBagConstraints);

    ddlAllowShowSql.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "true", "false" }));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    pImpSettings.add(ddlAllowShowSql, gridBagConstraints);

    pImpSets.add(pImpSettings, java.awt.BorderLayout.CENTER);

    pSwitchButtons.setPreferredSize(new java.awt.Dimension(0, 50));

    btnBack1.setText("< Back");
    btnBack1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBack1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout pSwitchButtonsLayout = new javax.swing.GroupLayout(pSwitchButtons);
    pSwitchButtons.setLayout(pSwitchButtonsLayout);
    pSwitchButtonsLayout.setHorizontalGroup(
      pSwitchButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(sp3, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
      .addGroup(pSwitchButtonsLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnBack1)
        .addContainerGap(296, Short.MAX_VALUE))
    );
    pSwitchButtonsLayout.setVerticalGroup(
      pSwitchButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pSwitchButtonsLayout.createSequentialGroup()
        .addComponent(sp3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
        .addComponent(btnBack1)
        .addContainerGap())
    );

    pImpSets.add(pSwitchButtons, java.awt.BorderLayout.PAGE_END);

    pConnecting.setLayout(new java.awt.BorderLayout());

    pConnectingContent.setBackground(new java.awt.Color(255, 255, 255));
    pConnectingContent.setLayout(new java.awt.GridBagLayout());

    lbConnecting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/lilylnx/springnet/dbconfig/images/fbAjaxLoading_32.gif"))); // NOI18N
    lbConnecting.setText("Testing connection...");
    lbConnecting.setIconTextGap(15);
    pConnectingContent.add(lbConnecting, new java.awt.GridBagConstraints());

    pConnecting.add(pConnectingContent, java.awt.BorderLayout.CENTER);

    pConnectingButtons.setPreferredSize(new java.awt.Dimension(0, 50));

    btnQuit2.setText("Quit");

    lbSmallConnectingImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/lilylnx/springnet/dbconfig/images/fbAjaxLoading_16x11.gif"))); // NOI18N
    lbSmallConnectingImg.setText(" ");

    btnBack2.setText("< Back");
    btnBack2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBack2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout pConnectingButtonsLayout = new javax.swing.GroupLayout(pConnectingButtons);
    pConnectingButtons.setLayout(pConnectingButtonsLayout);
    pConnectingButtonsLayout.setHorizontalGroup(
      pConnectingButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(sp4, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
      .addGroup(pConnectingButtonsLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnBack2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(lbSmallConnectingImg)
        .addGap(10, 10, 10)
        .addComponent(btnQuit2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    pConnectingButtonsLayout.setVerticalGroup(
      pConnectingButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pConnectingButtonsLayout.createSequentialGroup()
        .addComponent(sp4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
        .addGroup(pConnectingButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pConnectingButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(lbSmallConnectingImg)
            .addComponent(btnQuit2))
          .addComponent(btnBack2))
        .addContainerGap())
    );

    pConnecting.add(pConnectingButtons, java.awt.BorderLayout.PAGE_END);

    pSuccess.setLayout(new java.awt.BorderLayout());

    pSuccessMsg.setBackground(new java.awt.Color(255, 255, 255));
    pSuccessMsg.setLayout(new java.awt.GridBagLayout());

    lbSuccessMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/lilylnx/springnet/dbconfig/images/giggle.png"))); // NOI18N
    lbSuccessMsg.setText("Success.");
    pSuccessMsg.add(lbSuccessMsg, new java.awt.GridBagConstraints());

    pSuccess.add(pSuccessMsg, java.awt.BorderLayout.CENTER);

    pSuccessButtons.setPreferredSize(new java.awt.Dimension(0, 50));

    btnQuit3.setText("Quit");
    btnQuit3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnQuit3ActionPerformed(evt);
      }
    });

    btnBack3.setText("< Back");
    btnBack3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBack3ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout pSuccessButtonsLayout = new javax.swing.GroupLayout(pSuccessButtons);
    pSuccessButtons.setLayout(pSuccessButtonsLayout);
    pSuccessButtonsLayout.setHorizontalGroup(
      pSuccessButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(sp5, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
      .addGroup(pSuccessButtonsLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnBack3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnQuit3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    pSuccessButtonsLayout.setVerticalGroup(
      pSuccessButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pSuccessButtonsLayout.createSequentialGroup()
        .addComponent(sp5, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
        .addGroup(pSuccessButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnBack3)
          .addComponent(btnQuit3))
        .addContainerGap())
    );

    pSuccess.add(pSuccessButtons, java.awt.BorderLayout.PAGE_END);

    pHelp.setLayout(new java.awt.BorderLayout());

    pHelpContent.setLayout(new java.awt.BorderLayout());

    tabHelp.setTabPlacement(javax.swing.JTabbedPane.LEFT);
    tabHelp.setFocusable(false);

    pVnTab.setBackground(new java.awt.Color(255, 255, 255));
    pVnTab.setLayout(new java.awt.BorderLayout());

    helpScrollPane.setBorder(null);

    txtHelpContent.setContentType("text/html");
    txtHelpContent.setEditable(false);
    txtHelpContent.setText(loadHelpDocumentVI("help/content_vi.html"));
    helpScrollPane.setViewportView(txtHelpContent);

    pVnTab.add(helpScrollPane, java.awt.BorderLayout.CENTER);

    tabHelp.addTab("Vietnamese", pVnTab);

    javax.swing.GroupLayout pnEnTabLayout = new javax.swing.GroupLayout(pnEnTab);
    pnEnTab.setLayout(pnEnTabLayout);
    pnEnTabLayout.setHorizontalGroup(
      pnEnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 331, Short.MAX_VALUE)
    );
    pnEnTabLayout.setVerticalGroup(
      pnEnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 205, Short.MAX_VALUE)
    );

    tabHelp.addTab("English", pnEnTab);

    pHelpContent.add(tabHelp, java.awt.BorderLayout.CENTER);

    pHelp.add(pHelpContent, java.awt.BorderLayout.CENTER);

    pHelpButtons.setPreferredSize(new java.awt.Dimension(0, 50));

    btnBack4.setText("< Back");
    btnBack4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBack4ActionPerformed(evt);
      }
    });

    btnQuit4.setText("Quit");
    btnQuit4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnQuit4ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout pHelpButtonsLayout = new javax.swing.GroupLayout(pHelpButtons);
    pHelpButtons.setLayout(pHelpButtonsLayout);
    pHelpButtonsLayout.setHorizontalGroup(
      pHelpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(sp6, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
      .addGroup(pHelpButtonsLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnBack4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
        .addComponent(btnQuit4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    pHelpButtonsLayout.setVerticalGroup(
      pHelpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pHelpButtonsLayout.createSequentialGroup()
        .addComponent(sp6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pHelpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnBack4)
          .addComponent(btnQuit4))
        .addContainerGap())
    );

    pHelp.add(pHelpButtons, java.awt.BorderLayout.PAGE_END);

    pFirst.setPreferredSize(new java.awt.Dimension(0, 60));
    pFirst.setLayout(new java.awt.BorderLayout());

    lbTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
    lbTitle.setText("SpringNet - Database Configuration Creation");

    lbDesc.setText("Please enter completely!");

    javax.swing.GroupLayout pBannerLayout = new javax.swing.GroupLayout(pBanner);
    pBanner.setLayout(pBannerLayout);
    pBannerLayout.setHorizontalGroup(
      pBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pBannerLayout.createSequentialGroup()
        .addGroup(pBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pBannerLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(lbDesc))
          .addGroup(pBannerLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lbTitle)))
        .addContainerGap(200, Short.MAX_VALUE))
    );
    pBannerLayout.setVerticalGroup(
      pBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBannerLayout.createSequentialGroup()
        .addContainerGap(12, Short.MAX_VALUE)
        .addComponent(lbTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lbDesc)
        .addContainerGap())
    );

    pFirst.add(pBanner, java.awt.BorderLayout.CENTER);
    pFirst.add(sp1, java.awt.BorderLayout.PAGE_END);

    getContentPane().add(pFirst, java.awt.BorderLayout.PAGE_START);

    pCenter.setLayout(new java.awt.BorderLayout());
    getContentPane().add(pCenter, java.awt.BorderLayout.CENTER);
  }// </editor-fold>//GEN-END:initComponents

private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
  goImpSettingsPanel();
}//GEN-LAST:event_btnNext1ActionPerformed

private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
  goJdbcPanel();
}//GEN-LAST:event_btnBack1ActionPerformed

private void btnQuit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuit1ActionPerformed
  quit();
}//GEN-LAST:event_btnQuit1ActionPerformed

private void btnTestConnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestConnActionPerformed
  jdbc = collectJdbcInfo(jdbc);
  if (validateJdbcInfo(jdbc)) {
    goConnectingPanel();
    App.testConnection(this, jdbc);
  }
  else {
    btnCreate.setEnabled(false);
  }
}//GEN-LAST:event_btnTestConnActionPerformed

private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
  Jdbc _jdbc = null;
  _jdbc = collectJdbcInfo(_jdbc);
  if (validateJdbcInfo(_jdbc)) {
    if (jdbc.equals(_jdbc)) {
      create();
      clearForm();
    }
    else {
      JOptionPane.showMessageDialog(this, "Please re-test connection again.",
              "Warning", JOptionPane.WARNING_MESSAGE);
    }
  }
  btnCreate.setEnabled(false);
}//GEN-LAST:event_btnCreateActionPerformed

private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
  goJdbcPanel();
}//GEN-LAST:event_btnBack2ActionPerformed

private void btnQuit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuit3ActionPerformed
  quit();
}//GEN-LAST:event_btnQuit3ActionPerformed

private void btnBack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack3ActionPerformed
  goJdbcPanel();
}//GEN-LAST:event_btnBack3ActionPerformed

private void btnBack4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack4ActionPerformed
  goJdbcPanel();
}//GEN-LAST:event_btnBack4ActionPerformed

private void btnQuit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuit4ActionPerformed
  quit();
}//GEN-LAST:event_btnQuit4ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  goHelpPanel();
}//GEN-LAST:event_jButton1ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnBack1;
  private javax.swing.JButton btnBack2;
  private javax.swing.JButton btnBack3;
  private javax.swing.JButton btnBack4;
  private javax.swing.JButton btnCreate;
  private javax.swing.JButton btnNext1;
  private javax.swing.JButton btnQuit1;
  private javax.swing.JButton btnQuit2;
  private javax.swing.JButton btnQuit3;
  private javax.swing.JButton btnQuit4;
  private javax.swing.JButton btnTestConn;
  private javax.swing.JComboBox ddlAllowCaching;
  private javax.swing.JComboBox ddlAllowShowSql;
  private javax.swing.JComboBox ddlAllowStatistics;
  private javax.swing.JScrollPane helpScrollPane;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel lbAllowCaching;
  private javax.swing.JLabel lbAllowShowSql;
  private javax.swing.JLabel lbAllowStatistics;
  private javax.swing.JLabel lbConnecting;
  private javax.swing.JLabel lbDatabase;
  private javax.swing.JLabel lbDefaultSchema;
  private javax.swing.JLabel lbDesc;
  private javax.swing.JLabel lbDialect;
  private javax.swing.JLabel lbDriver;
  private javax.swing.JLabel lbPasswd;
  private javax.swing.JLabel lbPort;
  private javax.swing.JLabel lbServer;
  private javax.swing.JLabel lbSmallConnectingImg;
  private javax.swing.JLabel lbSuccessMsg;
  private javax.swing.JLabel lbTitle;
  private javax.swing.JLabel lbUname;
  private javax.swing.JLabel lbUrl;
  private javax.swing.JPanel pBanner;
  private javax.swing.JPanel pCenter;
  private javax.swing.JPanel pCommand;
  private javax.swing.JPanel pConnecting;
  private javax.swing.JPanel pConnectingButtons;
  private javax.swing.JPanel pConnectingContent;
  private javax.swing.JPanel pFirst;
  private javax.swing.JPanel pHelp;
  private javax.swing.JPanel pHelpButtons;
  private javax.swing.JPanel pHelpContent;
  private javax.swing.JPanel pImpSets;
  private javax.swing.JPanel pImpSettings;
  private javax.swing.JPanel pInputForm;
  private javax.swing.JPanel pJdbc;
  private javax.swing.JPanel pSuccess;
  private javax.swing.JPanel pSuccessButtons;
  private javax.swing.JPanel pSuccessMsg;
  private javax.swing.JPanel pSwitchButtons;
  private javax.swing.JPanel pVnTab;
  private javax.swing.JPanel pnEnTab;
  private javax.swing.JSeparator sp1;
  private javax.swing.JSeparator sp2;
  private javax.swing.JSeparator sp3;
  private javax.swing.JSeparator sp4;
  private javax.swing.JSeparator sp5;
  private javax.swing.JSeparator sp6;
  private javax.swing.JTabbedPane tabHelp;
  private javax.swing.JTextField txtDatabase;
  private javax.swing.JTextField txtDefaultSchema;
  private javax.swing.JTextField txtDialect;
  private javax.swing.JTextField txtDriver;
  private javax.swing.JTextPane txtHelpContent;
  private javax.swing.JPasswordField txtPasswd;
  private javax.swing.JTextField txtPort;
  private javax.swing.JTextField txtServer;
  private javax.swing.JTextField txtUname;
  private javax.swing.JTextField txtUrl;
  // End of variables declaration//GEN-END:variables
}
