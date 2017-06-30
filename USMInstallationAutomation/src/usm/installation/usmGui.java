package usm.installation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.*;


public class usmGui {
	
	//Variable for the frames and panel
	JFrame jfrm=new JFrame("USM Installation");
	JPanel serverPanel=new JPanel();
	JPanel dbmsPanel=new JPanel();
	JPanel uninstallPanel=new JPanel();
	JPanel dbUsersPanel=new JPanel();
	
	
	public usmGui(){
		jfrm.setLayout(null);
		jfrm.setSize(900, 650);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setLocationRelativeTo(null);// To open the frame at the center
		jfrm.setResizable(false);
		jfrm.getContentPane().setBackground(Color.LIGHT_GRAY);
		jfrm.setVisible(true);
		addServerPanel();
		addDbmsPanel();
		uninstallpanel();
		
	}
	
	
	
	//Adding method for database connection
	public void addServerPanel(){
		serverPanel.setBounds(150,100,400,150);
		serverPanel.setLayout(null);
		serverPanel.setOpaque(false);
		serverPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Server Connection"));
		jfrm.add(serverPanel);

		
		// label for Unix Server Name
		JLabel serverPanel_lblUSN = new JLabel("Unix Server Name");
		Dimension serverPanel_lblUSN_size = serverPanel_lblUSN.getPreferredSize();
		serverPanel_lblUSN.setBounds(10, 20, serverPanel_lblUSN_size.width,
				serverPanel_lblUSN_size.height);
		serverPanel.add(serverPanel_lblUSN);

		// TextField for Unix Server Name
		JTextField serverPanel_txtUSN = new JTextField(10);
		serverPanel_txtUSN.setBounds(210, 20, 150, serverPanel_lblUSN_size.height);
		serverPanel.add(serverPanel_txtUSN);

		// label for Unix Server USER ID
		JLabel serverPanel_lblUSU = new JLabel("Unix Server UserId");
		Dimension serverPanel_lblUSU_size = serverPanel_lblUSU.getPreferredSize();
		serverPanel_lblUSU.setBounds(10, 50, serverPanel_lblUSU_size.width,
				serverPanel_lblUSU_size.height);
		serverPanel.add(serverPanel_lblUSU);

		// TextField for Unix Server USER ID
		JTextField serverPanel_txtUSU = new JTextField(10);
		serverPanel_txtUSU.setBounds(210, 50, 150, serverPanel_lblUSU_size.height);
		serverPanel.add(serverPanel_txtUSU);

		// label for Unix Server Password
		JLabel serverPanel_lblUSP = new JLabel("Unix Server Passowrd");
		Dimension serverPanel_lblUSP_size = serverPanel_lblUSP.getPreferredSize();
		serverPanel_lblUSP.setBounds(10, 80, serverPanel_lblUSP_size.width,
				serverPanel_lblUSP_size.height);
		serverPanel.add(serverPanel_lblUSP);

		// TextField for Unix Server Password
		JPasswordField serverPanel_txtUSP = new JPasswordField(10);
		serverPanel_txtUSP.setBounds(210, 80, 150, serverPanel_lblUSP_size.height);
		serverPanel.add(serverPanel_txtUSP);

		// button for Unix Server Connection Check
		JButton serverPanel_btnUSC = new JButton("Test Connection");
		Dimension serverPanel_btnUSC_size = serverPanel_btnUSC.getPreferredSize();
		serverPanel_btnUSC.setBounds(10, 110, serverPanel_btnUSC_size.width,
				serverPanel_btnUSC_size.height);
		serverPanel.add(serverPanel_btnUSC);

		// Label for Unix Server Connection Status
		JLabel serverPanel_lblUSC = new JLabel("Connection Status");
		Dimension serverPanel_lblUSC_size = serverPanel_lblUSC.getPreferredSize();
		serverPanel_lblUSC.setBounds(210, 110, serverPanel_lblUSC_size.width + 50,
				serverPanel_lblUSC_size.height);
		serverPanel.add(serverPanel_lblUSC);

		/*serverPanel_btnUSC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String host = serverPanel_txtUSN.getText();
				String user = serverPanel_txtUSU.getText();
				// @SuppressWarnings("deprecation")
				String password = serverPanel_txtUSP.getText();

				if (backEnd.Test_Server_Connection(host, user, password) == true) {
					serverPanel_lblUSC.setText("Connection Successed.");
				} else {
					serverPanel_lblUSC.setText("Connection Error.");
				}

			}
		});*/
	}


	public void addDbmsPanel(){
		
		dbmsPanel.setBounds(150,260,400,150);
		dbmsPanel.setLayout(null);
		dbmsPanel.setOpaque(false);
		dbmsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Database Connection"));
		jfrm.add(dbmsPanel);
		
		// Sql database Creadential
		// label for Sql Database USER ID
		JLabel dbmsPanel_lblSDU = new JLabel("Sql Database UserId");
		Dimension dbmsPanel_lblSDU_size = dbmsPanel_lblSDU.getPreferredSize();
		dbmsPanel_lblSDU.setBounds(10, 20, dbmsPanel_lblSDU_size.width,
				dbmsPanel_lblSDU_size.height);
		dbmsPanel.add(dbmsPanel_lblSDU);

		// TextField for Sql Database USER ID
		JTextField dbmsPanel_txtSDU = new JTextField(10);
		dbmsPanel_txtSDU.setBounds(210, 20, 150, dbmsPanel_lblSDU_size.height);
		dbmsPanel.add(dbmsPanel_txtSDU);

		// label for Sql Database Password
		JLabel dbmsPanel_lblSDP = new JLabel("Sql Database Passowrd");
		Dimension dbmsPanel_lblSDP_size = dbmsPanel_lblSDP.getPreferredSize();
		dbmsPanel_lblSDP.setBounds(10, 50, dbmsPanel_lblSDP_size.width,
				dbmsPanel_lblSDP_size.height);
		dbmsPanel.add(dbmsPanel_lblSDP);

		// TextField for Sql Database Password
		JPasswordField dbmsPanel_txtSDP = new JPasswordField(10);
		dbmsPanel_txtSDP.setBounds(210, 50, 150, dbmsPanel_lblSDP_size.height);
		dbmsPanel.add(dbmsPanel_txtSDP);
		
		//Label for Sql Database sid
		JLabel dbmsPanel_lblSID = new JLabel("Sql Database SID");
		Dimension dbmsPanel_lblSID_size = dbmsPanel_lblSDP.getPreferredSize();
		dbmsPanel_lblSID.setBounds(10, 80, dbmsPanel_lblSID_size.width,
				dbmsPanel_lblSID_size.height);
		dbmsPanel.add(dbmsPanel_lblSID);

		// TextField for Sql Database SID
		JTextField dbmsPanel_txtSID = new JTextField(10);
		dbmsPanel_txtSID.setBounds(210, 80, 150, dbmsPanel_lblSDP_size.height);
		dbmsPanel.add(dbmsPanel_txtSID);

		// button for Sql Database Connection Check
		JButton dbmsPanel_btnSDC = new JButton("Test Connection");
		Dimension dbmsPanel_btnSDC_size = dbmsPanel_btnSDC.getPreferredSize();
		dbmsPanel_btnSDC.setBounds(10, 110, dbmsPanel_btnSDC_size.width,
				dbmsPanel_btnSDC_size.height);
		dbmsPanel.add(dbmsPanel_btnSDC);

		// Label for Sql Database Connection Status
		JLabel dbmsPanel_lblSDC = new JLabel("Connection Status");
		Dimension dbmsPanel_lblSDC_size = dbmsPanel_lblSDC.getPreferredSize();
		dbmsPanel_lblSDC.setBounds(210, 110, dbmsPanel_lblSDC_size.width + 40,
				dbmsPanel_lblSDC_size.height);
		dbmsPanel.add(dbmsPanel_lblSDC);

		/*dbmsPanel_btnSDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = dbmsPanel_txtSDU.getText();
				String password = dbmsPanel_txtSDP.getText();
				String SID=dbmsPanel_txtSID.getText();

				if (backEnd.Test_Db_Connection(user, password,SID,"OracleConn.txt") == true) {
					dbmsPanel_lblSDC.setText("Connection Successed.");
				} else {
					dbmsPanel_lblSDC.setText("Connection Error");
				}
			}
		});*/
	}


	public void uninstallpanel(){
		uninstallPanel.setBounds(0, 420, 900, 140);
		uninstallPanel.setLayout(null);
		//uninstallPanel.setBackground(Color.LIGHT_GRAY);
		uninstallPanel.setOpaque(false);
		jfrm.add(uninstallPanel);
		
		// button for Clear the previous environment
		JButton uninstallPanel_btnCE = new JButton("Clear previous Installation");
		Dimension uninstallPanel_btnCE_size = uninstallPanel_btnCE.getPreferredSize();
		uninstallPanel_btnCE.setBounds(150, 10, uninstallPanel_btnCE_size.width,
				uninstallPanel_btnCE_size.height);
		uninstallPanel.add(uninstallPanel_btnCE);

		// Label for clear the previous environment Status
		JLabel uninstallPanel_lblCE = new JLabel("Status");
		Dimension uninstallPanel_lblCE_size = uninstallPanel_lblCE.getPreferredSize();
		uninstallPanel_lblCE.setBounds(350, 10, uninstallPanel_lblCE_size.width + 50,
				uninstallPanel_lblCE_size.height);
		uninstallPanel.add(uninstallPanel_lblCE);

		// Action when clear previous Installation button clicked
		/*uninstallPanel_btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backEnd.Server_Command("export DISPLAY=localhost:10.0");
				String command="rm -rf .xpi/ .asp/  storage/ .install/ software/ JEE/ .StorageMetadata/ .rollback/ .com.zerog.registry.xml";
				if(backEnd.Server_Command(command)==true){
					uninstallPanel_lblCE.setText("Uninstalled");
				}else{
					uninstallPanel_lblCE.setText("Error");
				}
			}
		});*/

		// button for Cancle
		JButton uninstallPanel_btnCancle = new JButton("Cancle");
		Dimension uninstallPanel_btnCancle_size = uninstallPanel_btnCancle.getPreferredSize();
		uninstallPanel_btnCancle.setBounds(800 - 2 * uninstallPanel_btnCancle_size.width,
				140 - uninstallPanel_btnCancle_size.height, uninstallPanel_btnCancle_size.width,
				uninstallPanel_btnCancle_size.height);
		uninstallPanel.add(uninstallPanel_btnCancle);

		// button for Next
		JButton uninstallPanel_btnNext = new JButton("Next");
		Dimension uninstallPanel_btnNext_size = uninstallPanel_btnNext.getPreferredSize();
		uninstallPanel_btnNext.setBounds(800 - uninstallPanel_btnNext_size.width,
				140 - uninstallPanel_btnNext_size.height, uninstallPanel_btnNext_size.width,
				uninstallPanel_btnNext_size.height);
		uninstallPanel.add(uninstallPanel_btnNext);

		// ActionListiner for button Next
		uninstallPanel_btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toDbUserCreation();
				
			}
		});
	}

	
	
	public void toDbUserCreation(){
		serverPanel.setVisible(false);
		dbmsPanel.setVisible(false);
		uninstallPanel.setVisible(false);
		dbUserCreation();
	}
	
	
	
	public void dbUserCreation(){
		dbUsersPanel.setBounds(0, 0, 900, 650);
		dbUsersPanel.setLayout(null);
		//dbUsersPanel.setBackground(Color.lightGray);
		dbUsersPanel.setOpaque(false);

		jfrm.add(dbUsersPanel);

		JLabel dbUsersPanel_Header = new JLabel("Database user Creation");
		Dimension dbUsersPanel_Header_size = dbUsersPanel_Header.getPreferredSize();
		dbUsersPanel_Header.setBounds(350, 450, dbUsersPanel_Header_size.width, dbUsersPanel_Header_size.height);
		dbUsersPanel.add(dbUsersPanel_Header);

		// *************************************************************************************
		//Label for Port Number for Installation
		JLabel dbUsersPanel_lblPort = new JLabel("USM Installation Port");
		Dimension dbUsersPanel_lblPort_size = dbUsersPanel_lblPort.getPreferredSize();
		dbUsersPanel_lblPort.setBounds(150, 120, dbUsersPanel_lblPort_size.width, dbUsersPanel_lblPort_size.height);
		dbUsersPanel.add(dbUsersPanel_lblPort);

		// TextField for Unix Server Name
		JTextField dbUsersPanel_txtPort = new JTextField(10);
		dbUsersPanel_txtPort.setBounds(350, 120, 150, dbUsersPanel_lblPort_size.height);
		dbUsersPanel.add(dbUsersPanel_txtPort);
		
		
		// Label for Default Tablespace Input
		JLabel dbUsersPanel_lblDef = new JLabel("Default Tablespace");
		Dimension dbUsersPanel_lblDef_size = dbUsersPanel_lblDef.getPreferredSize();
		dbUsersPanel_lblDef.setBounds(150, 150, dbUsersPanel_lblDef_size.width, dbUsersPanel_lblDef_size.height);
		dbUsersPanel.add(dbUsersPanel_lblDef);

		// TextField for Unix Server Name
		JTextField dbUsersPanel_txtDef = new JTextField(10);
		dbUsersPanel_txtDef.setBounds(350, 150, 150, dbUsersPanel_lblDef_size.height);
		dbUsersPanel.add(dbUsersPanel_txtDef);

		// Label for Temporary tablespace input
		JLabel dbUsersPanel_lbltemp = new JLabel("Temporary Tablespace");
		Dimension dbUsersPanel_lbltemp_size = dbUsersPanel_lbltemp.getPreferredSize();
		dbUsersPanel_lbltemp.setBounds(150, 180, dbUsersPanel_lbltemp_size.width, dbUsersPanel_lbltemp_size.height);
		dbUsersPanel.add(dbUsersPanel_lbltemp);

		// TextField for Unix Server Name
		JTextField dbUsersPanel_txttemp = new JTextField(10);
		dbUsersPanel_txttemp.setBounds(350, 180, 150, dbUsersPanel_lbltemp_size.height);
		dbUsersPanel.add(dbUsersPanel_txttemp);
		// *************************************************************************************

		JLabel dbUsersPanel_lblUSER = new JLabel("Create database Users");
		Dimension dbUsersPanel_lblUSER_size = dbUsersPanel_lblUSER.getPreferredSize();
		dbUsersPanel_lblUSER.setBounds(150, 210, dbUsersPanel_lblUSER_size.width, dbUsersPanel_lblUSER_size.height);
		dbUsersPanel.add(dbUsersPanel_lblUSER);

		JLabel dbUsersPanel_lblUSERN = new JLabel("User Name");
		Dimension dbUsersPanel_lblUSERN_size = dbUsersPanel_lblUSERN.getPreferredSize();
		dbUsersPanel_lblUSERN.setBounds(350, 210, dbUsersPanel_lblUSERN_size.width,
				dbUsersPanel_lblUSERN_size.height);
		dbUsersPanel.add(dbUsersPanel_lblUSERN);

		JLabel dbUsersPanel_lblUSERP = new JLabel("Password");
		Dimension dbUsersPanel_lblUSERP_size = dbUsersPanel_lblUSERP.getPreferredSize();
		dbUsersPanel_lblUSERP.setBounds(550, 210, dbUsersPanel_lblUSERP_size.width,
				dbUsersPanel_lblUSERP_size.height);
		dbUsersPanel.add(dbUsersPanel_lblUSERP);

		// ******************************************************************************************
		// label for Unix Server Password
		JLabel dbUsersPanel_lblUAMS = new JLabel("Create User UAMS");
		Dimension dbUsersPanel_lblUAMS_size = dbUsersPanel_lblUAMS.getPreferredSize();
		dbUsersPanel_lblUAMS.setBounds(150, 240, dbUsersPanel_lblUAMS_size.width, dbUsersPanel_lblUAMS_size.height);
		dbUsersPanel.add(dbUsersPanel_lblUAMS);

		// TextField for Unix Server Name
		JTextField dbUsersPanel_txtUAMS = new JTextField(10);
		dbUsersPanel_txtUAMS.setBounds(350, 240, 150, dbUsersPanel_lblUAMS_size.height);
		dbUsersPanel.add(dbUsersPanel_txtUAMS);

		// TextField for Unix Server Password
		JPasswordField dbUsersPanel_txtpUAMS = new JPasswordField(10);
		dbUsersPanel_txtpUAMS.setBounds(550, 240, 150, dbUsersPanel_lblUAMS_size.height);
		dbUsersPanel.add(dbUsersPanel_txtpUAMS);

		// Label for Unix Server DbaUser Status
		JLabel dbUsersPanel_lblUAMS_1 = new JLabel("Status");
		Dimension dbUsersPanel_lblUAMS_1_size = dbUsersPanel_lblUAMS_1.getPreferredSize();
		dbUsersPanel_lblUAMS_1.setBounds(700, 240, 3*dbUsersPanel_lblUAMS_1_size.width,
				dbUsersPanel_lblUAMS_1_size.height);
		dbUsersPanel.add(dbUsersPanel_lblUAMS_1);
		// ******************************************************************************************

		// ******************************************************************************************
		// label for AFFUSER
		JLabel dbUsersPanel_lblAFFUSER = new JLabel("Create User CRAMER");
		Dimension dbUsersPanel_lblAFFUSER_size = dbUsersPanel_lblAFFUSER.getPreferredSize();
		dbUsersPanel_lblAFFUSER.setBounds(150, 270, dbUsersPanel_lblAFFUSER_size.width,
				dbUsersPanel_lblAFFUSER_size.height);
		dbUsersPanel.add(dbUsersPanel_lblAFFUSER);
		
		

		// TextField for Unix Server Name
		JTextField dbUsersPanel_txteAFFUSER = new JTextField(10);
		dbUsersPanel_txteAFFUSER.setBounds(350, 270, 150, dbUsersPanel_lblAFFUSER_size.height);
		dbUsersPanel.add(dbUsersPanel_txteAFFUSER);

		// TextField for AFFUSER Password
		JPasswordField dbUsersPanel_txtAFFUSER = new JPasswordField(10);
		dbUsersPanel_txtAFFUSER.setBounds(550, 270, 150, dbUsersPanel_lblAFFUSER_size.height);
		dbUsersPanel.add(dbUsersPanel_txtAFFUSER);

		// Label for Unix Server DbaUser Status
		JLabel dbUsersPanel_lblAFFUSER_1 = new JLabel("Status");
		Dimension dbUsersPanel_lblAFFUSER_1_size = dbUsersPanel_lblAFFUSER_1.getPreferredSize();
		dbUsersPanel_lblAFFUSER_1.setBounds(700, 270, 3*dbUsersPanel_lblAFFUSER_1_size.width,
				dbUsersPanel_lblAFFUSER_1_size.height);
		dbUsersPanel.add(dbUsersPanel_lblAFFUSER_1);
		// ******************************************************************************************

		// ******************************************************************************************
		// label for REFUSER
		JLabel dbUsersPanel_lblREFUSER = new JLabel("Create User CRAMER_INSTALLER");
		Dimension dbUsersPanel_lblREFUSER_size = dbUsersPanel_lblREFUSER.getPreferredSize();
		dbUsersPanel_lblREFUSER.setBounds(150, 300, dbUsersPanel_lblREFUSER_size.width,
				dbUsersPanel_lblREFUSER_size.height);
		dbUsersPanel.add(dbUsersPanel_lblREFUSER);

		// TextField for Unix Server Name
		JTextField dbUsersPanel_txteREFUSER = new JTextField(10);
		dbUsersPanel_txteREFUSER.setBounds(350, 300, 150, dbUsersPanel_lblREFUSER_size.height);
		dbUsersPanel.add(dbUsersPanel_txteREFUSER);

		// TextField for REFUSER Password
		JPasswordField dbUsersPanel_txtREFUSER = new JPasswordField(10);
		dbUsersPanel_txtREFUSER.setBounds(550, 300, 150, dbUsersPanel_lblREFUSER_size.height);
		dbUsersPanel.add(dbUsersPanel_txtREFUSER);

		// Label for Unix Server DbaUser Status
		JLabel dbUsersPanel_lblREFUSER_1 = new JLabel("Status");
		Dimension dbUsersPanel_lblREFUSER_1_size = dbUsersPanel_lblREFUSER_1.getPreferredSize();
		dbUsersPanel_lblREFUSER_1.setBounds(700, 300, 3*dbUsersPanel_lblREFUSER_1_size.width,
				dbUsersPanel_lblREFUSER_1_size.height);
		dbUsersPanel.add(dbUsersPanel_lblREFUSER_1);
		// ******************************************************************************************

		// ***********************************************************************************************
		// Lebel for ALTREFUSER
		JLabel dbUsersPanel_lblALTREFUSER = new JLabel("Create User CRAMER_COMMON");
		Dimension dbUsersPanel_lblALTREFUSER_size = dbUsersPanel_lblALTREFUSER.getPreferredSize();
		dbUsersPanel_lblALTREFUSER.setBounds(150, 330, dbUsersPanel_lblALTREFUSER_size.width,
				dbUsersPanel_lblALTREFUSER_size.height);
		dbUsersPanel.add(dbUsersPanel_lblALTREFUSER);


		// TextField for Unix Server Name
		JTextField dbUsersPanel_txteALTREFUSER = new JTextField(10);
		dbUsersPanel_txteALTREFUSER.setBounds(350, 330, 150, dbUsersPanel_lblALTREFUSER_size.height);
		dbUsersPanel.add(dbUsersPanel_txteALTREFUSER);

		// TextField for ALTREFUSER Password
		JPasswordField dbUsersPanel_txtALTREFUSER = new JPasswordField(10);
		dbUsersPanel_txtALTREFUSER.setBounds(550, 330, 150, dbUsersPanel_lblALTREFUSER_size.height);
		dbUsersPanel.add(dbUsersPanel_txtALTREFUSER);

		// Label for Unix Server DbaUser Status
		JLabel dbUsersPanel_lblALTREFUSER_1 = new JLabel("Status");
		Dimension dbUsersPanel_lblALTREFUSER_1_size = dbUsersPanel_lblALTREFUSER_1.getPreferredSize();
		dbUsersPanel_lblALTREFUSER_1.setBounds(700, 330, 3*dbUsersPanel_lblALTREFUSER_1_size.width,
				dbUsersPanel_lblALTREFUSER_1_size.height);
		dbUsersPanel.add(dbUsersPanel_lblALTREFUSER_1);
		// ******************************************************************************************

		// ******************************************************************************************
		// Lebel for OSSUI
		JLabel dbUsersPanel_lblOSSUI = new JLabel("Create User CRAMERSSO");
		Dimension dbUsersPanel_lblOSSUI_size = dbUsersPanel_lblOSSUI.getPreferredSize();
		dbUsersPanel_lblOSSUI.setBounds(150, 360, dbUsersPanel_lblOSSUI_size.width,
				dbUsersPanel_lblOSSUI_size.height);
		dbUsersPanel.add(dbUsersPanel_lblOSSUI);


		// TextField for Unix Server Name
		JTextField dbUsersPanel_txteOSSUI = new JTextField(10);
		dbUsersPanel_txteOSSUI.setBounds(350, 360, 150, dbUsersPanel_lblOSSUI_size.height);
		dbUsersPanel.add(dbUsersPanel_txteOSSUI);

		// TextField for OSSUI Password
		JPasswordField dbUsersPanel_txtOSSUI = new JPasswordField(10);
		dbUsersPanel_txtOSSUI.setBounds(550, 360, 150, dbUsersPanel_lblOSSUI_size.height);
		dbUsersPanel.add(dbUsersPanel_txtOSSUI);

		// Label for Unix Server DbaUser Status
		JLabel dbUsersPanel_lblOSSUI_1 = new JLabel("Status");
		Dimension dbUsersPanel_lblOSSUI_1_size = dbUsersPanel_lblOSSUI_1.getPreferredSize();
		dbUsersPanel_lblOSSUI_1.setBounds(700, 360, 3*dbUsersPanel_lblOSSUI_1_size.width,
				dbUsersPanel_lblOSSUI_1_size.height);
		dbUsersPanel.add(dbUsersPanel_lblOSSUI_1);
		// ******************************************************************************************

		// ***************************************************************************************************
		// Lebel for OSSUI_CLENT
		JLabel dbUsersPanel_lblOSSUI_CLIENT = new JLabel("Create User REPORTS");
		Dimension dbUsersPanel_lblOSSUI_CLIENT_size = dbUsersPanel_lblOSSUI_CLIENT.getPreferredSize();
		dbUsersPanel_lblOSSUI_CLIENT.setBounds(150, 390, dbUsersPanel_lblOSSUI_CLIENT_size.width,
				dbUsersPanel_lblOSSUI_CLIENT_size.height);
		dbUsersPanel.add(dbUsersPanel_lblOSSUI_CLIENT);


		// TextField for Unix Server Name
		JTextField dbUsersPanel_txteOSSUI_CLIENT = new JTextField(10);
		dbUsersPanel_txteOSSUI_CLIENT.setBounds(350, 390, 150, dbUsersPanel_lblOSSUI_CLIENT_size.height);
		dbUsersPanel.add(dbUsersPanel_txteOSSUI_CLIENT);

		// TextField for OSSUI_CLIENT Password
		JPasswordField dbUsersPanel_txtOSSUI_CLIENT = new JPasswordField(10);
		dbUsersPanel_txtOSSUI_CLIENT.setBounds(550, 390, 150, dbUsersPanel_lblOSSUI_CLIENT_size.height);
		dbUsersPanel.add(dbUsersPanel_txtOSSUI_CLIENT);

		// Label for Unix Server DbaUser Status
		JLabel dbUsersPanel_lblOSSUI_CLIENT_1 = new JLabel("Status");
		Dimension dbUsersPanel_lblOSSUI_CLIENT_1_size = dbUsersPanel_lblOSSUI_CLIENT_1.getPreferredSize();
		dbUsersPanel_lblOSSUI_CLIENT_1.setBounds(700, 390, 3*dbUsersPanel_lblOSSUI_CLIENT_1_size.width,
				dbUsersPanel_lblOSSUI_CLIENT_1_size.height);
		dbUsersPanel.add(dbUsersPanel_lblOSSUI_CLIENT_1);
		// ******************************************************************************************
		
		
		//***************************************************************************************
		//Label for tempsys
		JLabel dbUsersPanel_lblTEMPSYS = new JLabel("Create User sfuser");
		Dimension dbUsersPanel_lblTEMPSYS_size = dbUsersPanel_lblTEMPSYS.getPreferredSize();
		dbUsersPanel_lblTEMPSYS.setBounds(150, 420, dbUsersPanel_lblTEMPSYS_size.width,
				dbUsersPanel_lblTEMPSYS_size.height);
		dbUsersPanel.add(dbUsersPanel_lblTEMPSYS);


		// TextField for Unix Server Name
		JTextField dbUsersPanel_txteTEMPSYS = new JTextField(10);
		dbUsersPanel_txteTEMPSYS.setBounds(350, 420, 150, dbUsersPanel_lblTEMPSYS_size.height);
		dbUsersPanel.add(dbUsersPanel_txteTEMPSYS);

		// TextField for TEMPSYS Password
		JPasswordField dbUsersPanel_txtTEMPSYS = new JPasswordField(10);
		dbUsersPanel_txtTEMPSYS.setBounds(550, 420, 150, dbUsersPanel_lblTEMPSYS_size.height);
		dbUsersPanel.add(dbUsersPanel_txtTEMPSYS);

		// Label for Unix Server DbaUser Status
		JLabel dbUsersPanel_lblTEMPSYS_1 = new JLabel("Status");
		Dimension dbUsersPanel_lblTEMPSYS_1_size = dbUsersPanel_lblTEMPSYS_1.getPreferredSize();
		dbUsersPanel_lblTEMPSYS_1.setBounds(700, 420, 3*dbUsersPanel_lblTEMPSYS_1_size.width,
				dbUsersPanel_lblTEMPSYS_1_size.height);
		dbUsersPanel.add(dbUsersPanel_lblTEMPSYS_1);
		
		//*************************************************************************************************

		// button for Cancle
		JButton dbUsersPanel_btnCancle = new JButton("Cancle");
		Dimension dbUsersPanel_btnCancle_size = dbUsersPanel_btnCancle.getPreferredSize();
		dbUsersPanel_btnCancle.setBounds(800 - 2 * dbUsersPanel_btnCancle_size.width,
				600 - dbUsersPanel_btnCancle_size.height, dbUsersPanel_btnCancle_size.width,
				dbUsersPanel_btnCancle_size.height);
		dbUsersPanel.add(dbUsersPanel_btnCancle);

		// button for Install
		JButton dbUsersPanel_btnInstall = new JButton("Install");
		Dimension dbUsersPanel_btnInstall_size = dbUsersPanel_btnInstall.getPreferredSize();
		dbUsersPanel_btnInstall.setBounds(800 - dbUsersPanel_btnInstall_size.width, 600 - dbUsersPanel_btnInstall_size.height,
				dbUsersPanel_btnInstall_size.width, dbUsersPanel_btnInstall_size.height);
		dbUsersPanel.add(dbUsersPanel_btnInstall);

		// ActionListiner for button Install
		dbUsersPanel_btnInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
}
