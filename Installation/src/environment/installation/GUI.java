package environment.installation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUI extends backEnd{
	
	//Variable for 1st Page
	JFrame jfrm=new JFrame("Installation");
	JPanel serverPanel=new JPanel();
	JPanel dbmsPanel=new JPanel();
	JPanel uninstallPanel=new JPanel();
	JPanel dbUsersPanel=new JPanel();
	JPanel SfoPanel = new JPanel();
	
	//Variable of Server Connection
	JTextField serverPanel_txtUSN = new JTextField(10);
	JTextField serverPanel_txtUSU = new JTextField(10);
	JPasswordField serverPanel_txtUSP = new JPasswordField(10);
	JTextField dbmsPanel_txtSDU = new JTextField(10);//username
	JPasswordField dbmsPanel_txtSDP = new JPasswordField(10);//password
	JTextField dbmsPanel_txtSID = new JTextField(10);//SID
	
	//Variable of SFO
	JTextField SfoPanel_txtPort = new JTextField(10);
	
	
	//Variable of USM
	JPanel UsmPanel = new JPanel();
	public GUI(){
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
		//JTextField serverPanel_txtUSN = new JTextField(10);
		serverPanel_txtUSN.setBounds(210, 20, 150, serverPanel_lblUSN_size.height);
		serverPanel.add(serverPanel_txtUSN);

		// label for Unix Server USER ID
		JLabel serverPanel_lblUSU = new JLabel("Unix Server UserId");
		Dimension serverPanel_lblUSU_size = serverPanel_lblUSU.getPreferredSize();
		serverPanel_lblUSU.setBounds(10, 50, serverPanel_lblUSU_size.width,
				serverPanel_lblUSU_size.height);
		serverPanel.add(serverPanel_lblUSU);

		// TextField for Unix Server USER ID
		//JTextField serverPanel_txtUSU = new JTextField(10);
		serverPanel_txtUSU.setBounds(210, 50, 150, serverPanel_lblUSU_size.height);
		serverPanel.add(serverPanel_txtUSU);

		// label for Unix Server Password
		JLabel serverPanel_lblUSP = new JLabel("Unix Server Passowrd");
		Dimension serverPanel_lblUSP_size = serverPanel_lblUSP.getPreferredSize();
		serverPanel_lblUSP.setBounds(10, 80, serverPanel_lblUSP_size.width,
				serverPanel_lblUSP_size.height);
		serverPanel.add(serverPanel_lblUSP);

		// TextField for Unix Server Password
		//JPasswordField serverPanel_txtUSP = new JPasswordField(10);
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

		serverPanel_btnUSC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String host = serverPanel_txtUSN.getText();
				String user = serverPanel_txtUSU.getText();
				// @SuppressWarnings("deprecation")
				String password = serverPanel_txtUSP.getText();

				if (Test_Server_Connection(host, user, password) == true) {
					serverPanel_lblUSC.setText("Connection Successed.");
				} else {
					serverPanel_lblUSC.setText("Connection Error.");
				}

			}
		});
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
		//JTextField dbmsPanel_txtSDU = new JTextField(10);
		dbmsPanel_txtSDU.setBounds(210, 20, 150, dbmsPanel_lblSDU_size.height);
		dbmsPanel.add(dbmsPanel_txtSDU);

		// label for Sql Database Password
		JLabel dbmsPanel_lblSDP = new JLabel("Sql Database Passowrd");
		Dimension dbmsPanel_lblSDP_size = dbmsPanel_lblSDP.getPreferredSize();
		dbmsPanel_lblSDP.setBounds(10, 50, dbmsPanel_lblSDP_size.width,
				dbmsPanel_lblSDP_size.height);
		dbmsPanel.add(dbmsPanel_lblSDP);

		// TextField for Sql Database Password
		//JPasswordField dbmsPanel_txtSDP = new JPasswordField(10);
		dbmsPanel_txtSDP.setBounds(210, 50, 150, dbmsPanel_lblSDP_size.height);
		dbmsPanel.add(dbmsPanel_txtSDP);
		
		//Label for Sql Database sid
		JLabel dbmsPanel_lblSID = new JLabel("Sql Database SID");
		Dimension dbmsPanel_lblSID_size = dbmsPanel_lblSDP.getPreferredSize();
		dbmsPanel_lblSID.setBounds(10, 80, dbmsPanel_lblSID_size.width,
				dbmsPanel_lblSID_size.height);
		dbmsPanel.add(dbmsPanel_lblSID);

		// TextField for Sql Database SID
		//JTextField dbmsPanel_txtSID = new JTextField(10);
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

		dbmsPanel_btnSDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = dbmsPanel_txtSDU.getText();
				String password = dbmsPanel_txtSDP.getText();
				String SID=dbmsPanel_txtSID.getText();

				if (Test_Db_Connection(user, password,SID,"SFO/OracleConn.txt") == true) {
					dbmsPanel_lblSDC.setText("Connection Successed.");
				} else {
					dbmsPanel_lblSDC.setText("Connection Error");
				}
			}
		});
	}



public void uninstallpanel(){
	uninstallPanel.setBounds(0, 420, 900, 140);
	uninstallPanel.setLayout(null);
	//uninstallPanel.setBackground(Color.LIGHT_GRAY);
	uninstallPanel.setOpaque(false);
	jfrm.add(uninstallPanel);
	
	//Choosing the SFO or USM installation
	JLabel rb=new JLabel("Choose Installation Server");
	Dimension rb_size=rb.getPreferredSize();
	rb.setBounds(150, 10, rb_size.width, rb_size.height);
	rb.setOpaque(false);
	uninstallPanel.add(rb);
		
	JRadioButton sfo=new JRadioButton("SFO Installation");
	Dimension sfo_size=sfo.getPreferredSize();
	sfo.setBounds(150, 30, sfo_size.width, sfo_size.height);
	sfo.setOpaque(false);
	uninstallPanel.add(sfo);
		
	JRadioButton usm=new JRadioButton("USM installation");
	Dimension usm_size=sfo.getPreferredSize();
	usm.setBounds(350, 30, usm_size.width+30, usm_size.height);
	usm.setOpaque(false);
	uninstallPanel.add(usm);
		
	ButtonGroup sfo_usm=new ButtonGroup();
	sfo_usm.add(sfo);
	sfo_usm.add(usm);

	
	// button for Clear the previous environment
	JButton uninstallPanel_btnCE = new JButton("Clear previous Installation");
	Dimension uninstallPanel_btnCE_size = uninstallPanel_btnCE.getPreferredSize();
	uninstallPanel_btnCE.setBounds(150, 60, uninstallPanel_btnCE_size.width,
			uninstallPanel_btnCE_size.height);
	uninstallPanel.add(uninstallPanel_btnCE);

	// Label for clear the previous environment Status
	JLabel uninstallPanel_lblCE = new JLabel("Status");
	Dimension uninstallPanel_lblCE_size = uninstallPanel_lblCE.getPreferredSize();
	uninstallPanel_lblCE.setBounds(350, 60, uninstallPanel_lblCE_size.width + 50,
			uninstallPanel_lblCE_size.height);
	uninstallPanel.add(uninstallPanel_lblCE);

	// Action when clear previous Installation button clicked
	uninstallPanel_btnCE.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Server_Command("export DISPLAY=localhost:10.0");
			if(sfo.isSelected()){
				//SFO Installation
				String command="rm -rf .xpi/ .asp/  storage/ .install/ software/ JEE/ .StorageMetadata/ .rollback/ .com.zerog.registry.xml";
				if(Server_Command(command)==true){
					uninstallPanel_lblCE.setText("Uninstalled");
				}else{
					uninstallPanel_lblCE.setText("Error");
				}
			}
			else if(usm.isSelected()){
				//USM Installation
				String command="rm -rf .xpi/ .asp/  storage/ JEE/ .StorageMetadata/ ResourceManagementWebLogic/";
				if(Server_Command(command)==true){
					uninstallPanel_lblCE.setText("Uninstalled");
				}else{
					uninstallPanel_lblCE.setText("Error");
				}
			}else{
				JOptionPane.showMessageDialog(uninstallPanel_btnCE, "Please select valid Installation");
			}
		}
	});
	
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
	
	//ActionListner for Cancle button
	uninstallPanel_btnCancle.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	});

	// ActionListiner for button Next
	uninstallPanel_btnNext.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//toDbUserCreation();
			serverPanel.setVisible(false);;
			dbmsPanel.setVisible(false);
			uninstallPanel.setVisible(false);
			if(sfo.isSelected()){
				addSfoPanel();
			}
			else if(usm.isSelected()){
				addUsmPanel();
			}else{
				JOptionPane.showMessageDialog(uninstallPanel_btnNext, "Please select valid Installation");
				serverPanel.setVisible(true);
				dbmsPanel.setVisible(true);
				uninstallPanel.setVisible(true);
			}
		}
	});
}


//For SFO Installation
public void addSfoPanel()
{
	//JPanel SfoPanel = new JPanel();
	SfoPanel.setBounds(0, 0, 900, 650);
	SfoPanel.setLayout(null);
	//SfoPanel.setBackground(Color.lightGray);
	SfoPanel.setOpaque(false);

	System.out.println(SfoPanel.getSize());
	jfrm.add(SfoPanel);

	JLabel SfoPanel_Header = new JLabel("Database user Creation");
	Dimension SfoPanel_Header_size = SfoPanel_Header.getPreferredSize();
	SfoPanel_Header.setBounds(350, 450, SfoPanel_Header_size.width, SfoPanel_Header_size.height);
	SfoPanel.add(SfoPanel_Header);

	// *************************************************************************************
	//Label for Port Number for Installation
	JLabel SfoPanel_lblPort = new JLabel("SFO Installation Port");
	Dimension SfoPanel_lblPort_size = SfoPanel_lblPort.getPreferredSize();
	SfoPanel_lblPort.setBounds(150, 120, SfoPanel_lblPort_size.width, SfoPanel_lblPort_size.height);
	SfoPanel.add(SfoPanel_lblPort);

	// TextField for Unix Server Installation Port
	//JTextField SfoPanel_txtPort = new JTextField(10);
	SfoPanel_txtPort.setBounds(350, 120, 150, SfoPanel_lblPort_size.height);
	SfoPanel.add(SfoPanel_txtPort);
	
	
	// Label for Default Tablespace Input
	JLabel SfoPanel_lblDef = new JLabel("Default Tablespace");
	Dimension SfoPanel_lblDef_size = SfoPanel_lblDef.getPreferredSize();
	SfoPanel_lblDef.setBounds(150, 150, SfoPanel_lblDef_size.width, SfoPanel_lblDef_size.height);
	SfoPanel.add(SfoPanel_lblDef);

	// TextField for Unix Server Name
	JTextField SfoPanel_txtDef = new JTextField(10);
	SfoPanel_txtDef.setBounds(350, 150, 150, SfoPanel_lblDef_size.height);
	SfoPanel.add(SfoPanel_txtDef);

	// Label for Temporary tablespace input
	JLabel SfoPanel_lbltemp = new JLabel("Temporary Tablespace");
	Dimension SfoPanel_lbltemp_size = SfoPanel_lbltemp.getPreferredSize();
	SfoPanel_lbltemp.setBounds(150, 180, SfoPanel_lbltemp_size.width, SfoPanel_lbltemp_size.height);
	SfoPanel.add(SfoPanel_lbltemp);

	// TextField for Unix Server Name
	JTextField SfoPanel_txttemp = new JTextField(10);
	SfoPanel_txttemp.setBounds(350, 180, 150, SfoPanel_lbltemp_size.height);
	SfoPanel.add(SfoPanel_txttemp);
	// *************************************************************************************

	JLabel SfoPanel_lblUSER = new JLabel("Create database Users");
	Dimension SfoPanel_lblUSER_size = SfoPanel_lblUSER.getPreferredSize();
	SfoPanel_lblUSER.setBounds(150, 210, SfoPanel_lblUSER_size.width, SfoPanel_lblUSER_size.height);
	SfoPanel.add(SfoPanel_lblUSER);

	JLabel SfoPanel_lblUSERN = new JLabel("User Name");
	Dimension SfoPanel_lblUSERN_size = SfoPanel_lblUSERN.getPreferredSize();
	SfoPanel_lblUSERN.setBounds(350, 210, SfoPanel_lblUSERN_size.width,
			SfoPanel_lblUSERN_size.height);
	SfoPanel.add(SfoPanel_lblUSERN);

	JLabel SfoPanel_lblUSERP = new JLabel("Password");
	Dimension SfoPanel_lblUSERP_size = SfoPanel_lblUSERP.getPreferredSize();
	SfoPanel_lblUSERP.setBounds(550, 210, SfoPanel_lblUSERP_size.width,
			SfoPanel_lblUSERP_size.height);
	SfoPanel.add(SfoPanel_lblUSERP);

	// ******************************************************************************************
	// label for Unix Server Password
	JLabel SfoPanel_lblUAMS = new JLabel("Create User UAMS");
	Dimension SfoPanel_lblUAMS_size = SfoPanel_lblUAMS.getPreferredSize();
	SfoPanel_lblUAMS.setBounds(150, 240, SfoPanel_lblUAMS_size.width, SfoPanel_lblUAMS_size.height);
	SfoPanel.add(SfoPanel_lblUAMS);

	// TextField for Unix Server Name
	JTextField SfoPanel_txtUAMS = new JTextField(10);
	SfoPanel_txtUAMS.setBounds(350, 240, 150, SfoPanel_lblUAMS_size.height);
	SfoPanel.add(SfoPanel_txtUAMS);

	// TextField for Unix Server Password
	JPasswordField SfoPanel_txtpUAMS = new JPasswordField(10);
	SfoPanel_txtpUAMS.setBounds(550, 240, 150, SfoPanel_lblUAMS_size.height);
	SfoPanel.add(SfoPanel_txtpUAMS);

	// Label for Unix Server DbaUser Status
	JLabel SfoPanel_lblUAMS_1 = new JLabel("Status");
	Dimension SfoPanel_lblUAMS_1_size = SfoPanel_lblUAMS_1.getPreferredSize();
	SfoPanel_lblUAMS_1.setBounds(700, 240, 3*SfoPanel_lblUAMS_1_size.width,
			SfoPanel_lblUAMS_1_size.height);
	SfoPanel.add(SfoPanel_lblUAMS_1);
	// ******************************************************************************************

	// ******************************************************************************************
	// label for AFFUSER
	JLabel SfoPanel_lblAFFUSER = new JLabel("Create User AFFUSER");
	Dimension SfoPanel_lblAFFUSER_size = SfoPanel_lblAFFUSER.getPreferredSize();
	SfoPanel_lblAFFUSER.setBounds(150, 270, SfoPanel_lblAFFUSER_size.width,
			SfoPanel_lblAFFUSER_size.height);
	SfoPanel.add(SfoPanel_lblAFFUSER);
	
	

	// TextField for Unix Server Name
	JTextField SfoPanel_txteAFFUSER = new JTextField(10);
	SfoPanel_txteAFFUSER.setBounds(350, 270, 150, SfoPanel_lblAFFUSER_size.height);
	SfoPanel.add(SfoPanel_txteAFFUSER);

	// TextField for AFFUSER Password
	JPasswordField SfoPanel_txtAFFUSER = new JPasswordField(10);
	SfoPanel_txtAFFUSER.setBounds(550, 270, 150, SfoPanel_lblAFFUSER_size.height);
	SfoPanel.add(SfoPanel_txtAFFUSER);

	// Label for Unix Server DbaUser Status
	JLabel SfoPanel_lblAFFUSER_1 = new JLabel("Status");
	Dimension SfoPanel_lblAFFUSER_1_size = SfoPanel_lblAFFUSER_1.getPreferredSize();
	SfoPanel_lblAFFUSER_1.setBounds(700, 270, 3*SfoPanel_lblAFFUSER_1_size.width,
			SfoPanel_lblAFFUSER_1_size.height);
	SfoPanel.add(SfoPanel_lblAFFUSER_1);
	// ******************************************************************************************

	// ******************************************************************************************
	// label for REFUSER
	JLabel SfoPanel_lblREFUSER = new JLabel("Create User REFUSER");
	Dimension SfoPanel_lblREFUSER_size = SfoPanel_lblREFUSER.getPreferredSize();
	SfoPanel_lblREFUSER.setBounds(150, 300, SfoPanel_lblREFUSER_size.width,
			SfoPanel_lblREFUSER_size.height);
	SfoPanel.add(SfoPanel_lblREFUSER);

	// TextField for Unix Server Name
	JTextField SfoPanel_txteREFUSER = new JTextField(10);
	SfoPanel_txteREFUSER.setBounds(350, 300, 150, SfoPanel_lblREFUSER_size.height);
	SfoPanel.add(SfoPanel_txteREFUSER);

	// TextField for REFUSER Password
	JPasswordField SfoPanel_txtREFUSER = new JPasswordField(10);
	SfoPanel_txtREFUSER.setBounds(550, 300, 150, SfoPanel_lblREFUSER_size.height);
	SfoPanel.add(SfoPanel_txtREFUSER);

	// Label for Unix Server DbaUser Status
	JLabel SfoPanel_lblREFUSER_1 = new JLabel("Status");
	Dimension SfoPanel_lblREFUSER_1_size = SfoPanel_lblREFUSER_1.getPreferredSize();
	SfoPanel_lblREFUSER_1.setBounds(700, 300, 3*SfoPanel_lblREFUSER_1_size.width,
			SfoPanel_lblREFUSER_1_size.height);
	SfoPanel.add(SfoPanel_lblREFUSER_1);
	// ******************************************************************************************

	// ***********************************************************************************************
	// Lebel for ALTREFUSER
	JLabel SfoPanel_lblALTREFUSER = new JLabel("Create User ALTREFUSER");
	Dimension SfoPanel_lblALTREFUSER_size = SfoPanel_lblALTREFUSER.getPreferredSize();
	SfoPanel_lblALTREFUSER.setBounds(150, 330, SfoPanel_lblALTREFUSER_size.width,
			SfoPanel_lblALTREFUSER_size.height);
	SfoPanel.add(SfoPanel_lblALTREFUSER);


	// TextField for Unix Server Name
	JTextField SfoPanel_txteALTREFUSER = new JTextField(10);
	SfoPanel_txteALTREFUSER.setBounds(350, 330, 150, SfoPanel_lblALTREFUSER_size.height);
	SfoPanel.add(SfoPanel_txteALTREFUSER);

	// TextField for ALTREFUSER Password
	JPasswordField SfoPanel_txtALTREFUSER = new JPasswordField(10);
	SfoPanel_txtALTREFUSER.setBounds(550, 330, 150, SfoPanel_lblALTREFUSER_size.height);
	SfoPanel.add(SfoPanel_txtALTREFUSER);

	// Label for Unix Server DbaUser Status
	JLabel SfoPanel_lblALTREFUSER_1 = new JLabel("Status");
	Dimension SfoPanel_lblALTREFUSER_1_size = SfoPanel_lblALTREFUSER_1.getPreferredSize();
	SfoPanel_lblALTREFUSER_1.setBounds(700, 330, 3*SfoPanel_lblALTREFUSER_1_size.width,
			SfoPanel_lblALTREFUSER_1_size.height);
	SfoPanel.add(SfoPanel_lblALTREFUSER_1);
	// ******************************************************************************************

	// ******************************************************************************************
	// Lebel for OSSUI
	JLabel SfoPanel_lblOSSUI = new JLabel("Create User OSSUI");
	Dimension SfoPanel_lblOSSUI_size = SfoPanel_lblOSSUI.getPreferredSize();
	SfoPanel_lblOSSUI.setBounds(150, 360, SfoPanel_lblOSSUI_size.width,
			SfoPanel_lblOSSUI_size.height);
	SfoPanel.add(SfoPanel_lblOSSUI);


	// TextField for Unix Server Name
	JTextField SfoPanel_txteOSSUI = new JTextField(10);
	SfoPanel_txteOSSUI.setBounds(350, 360, 150, SfoPanel_lblOSSUI_size.height);
	SfoPanel.add(SfoPanel_txteOSSUI);

	// TextField for OSSUI Password
	JPasswordField SfoPanel_txtOSSUI = new JPasswordField(10);
	SfoPanel_txtOSSUI.setBounds(550, 360, 150, SfoPanel_lblOSSUI_size.height);
	SfoPanel.add(SfoPanel_txtOSSUI);

	// Label for Unix Server DbaUser Status
	JLabel SfoPanel_lblOSSUI_1 = new JLabel("Status");
	Dimension SfoPanel_lblOSSUI_1_size = SfoPanel_lblOSSUI_1.getPreferredSize();
	SfoPanel_lblOSSUI_1.setBounds(700, 360, 3*SfoPanel_lblOSSUI_1_size.width,
			SfoPanel_lblOSSUI_1_size.height);
	SfoPanel.add(SfoPanel_lblOSSUI_1);
	// ******************************************************************************************

	// ***************************************************************************************************
	// Lebel for OSSUI_CLENT
	JLabel SfoPanel_lblOSSUI_CLIENT = new JLabel("Create User OSSUI_CLIENT");
	Dimension SfoPanel_lblOSSUI_CLIENT_size = SfoPanel_lblOSSUI_CLIENT.getPreferredSize();
	SfoPanel_lblOSSUI_CLIENT.setBounds(150, 390, SfoPanel_lblOSSUI_CLIENT_size.width,
			SfoPanel_lblOSSUI_CLIENT_size.height);
	SfoPanel.add(SfoPanel_lblOSSUI_CLIENT);


	// TextField for Unix Server Name
	JTextField SfoPanel_txteOSSUI_CLIENT = new JTextField(10);
	SfoPanel_txteOSSUI_CLIENT.setBounds(350, 390, 150, SfoPanel_lblOSSUI_CLIENT_size.height);
	SfoPanel.add(SfoPanel_txteOSSUI_CLIENT);

	// TextField for OSSUI_CLIENT Password
	JPasswordField SfoPanel_txtOSSUI_CLIENT = new JPasswordField(10);
	SfoPanel_txtOSSUI_CLIENT.setBounds(550, 390, 150, SfoPanel_lblOSSUI_CLIENT_size.height);
	SfoPanel.add(SfoPanel_txtOSSUI_CLIENT);

	// Label for Unix Server DbaUser Status
	JLabel SfoPanel_lblOSSUI_CLIENT_1 = new JLabel("Status");
	Dimension SfoPanel_lblOSSUI_CLIENT_1_size = SfoPanel_lblOSSUI_CLIENT_1.getPreferredSize();
	SfoPanel_lblOSSUI_CLIENT_1.setBounds(700, 390, 3*SfoPanel_lblOSSUI_CLIENT_1_size.width,
			SfoPanel_lblOSSUI_CLIENT_1_size.height);
	SfoPanel.add(SfoPanel_lblOSSUI_CLIENT_1);
	// ******************************************************************************************
	
	
	//***************************************************************************************
	//Label for tempsys
	JLabel SfoPanel_lblTEMPSYS = new JLabel("Create User TMPSYS");
	Dimension SfoPanel_lblTEMPSYS_size = SfoPanel_lblTEMPSYS.getPreferredSize();
	SfoPanel_lblTEMPSYS.setBounds(150, 420, SfoPanel_lblTEMPSYS_size.width,
			SfoPanel_lblTEMPSYS_size.height);
	SfoPanel.add(SfoPanel_lblTEMPSYS);


	// TextField for Unix Server Name
	JTextField SfoPanel_txteTEMPSYS = new JTextField(10);
	SfoPanel_txteTEMPSYS.setBounds(350, 420, 150, SfoPanel_lblTEMPSYS_size.height);
	SfoPanel.add(SfoPanel_txteTEMPSYS);

	// TextField for TEMPSYS Password
	JPasswordField SfoPanel_txtTEMPSYS = new JPasswordField(10);
	SfoPanel_txtTEMPSYS.setBounds(550, 420, 150, SfoPanel_lblTEMPSYS_size.height);
	SfoPanel.add(SfoPanel_txtTEMPSYS);

	// Label for Unix Server DbaUser Status
	JLabel SfoPanel_lblTEMPSYS_1 = new JLabel("Status");
	Dimension SfoPanel_lblTEMPSYS_1_size = SfoPanel_lblTEMPSYS_1.getPreferredSize();
	SfoPanel_lblTEMPSYS_1.setBounds(700, 420, 3*SfoPanel_lblTEMPSYS_1_size.width,
			SfoPanel_lblTEMPSYS_1_size.height);
	SfoPanel.add(SfoPanel_lblTEMPSYS_1);
	
	//*************************************************************************************************

	// button for Cancle
	JButton SfoPanel_btnCancle = new JButton("Cancle");
	Dimension SfoPanel_btnCancle_size = SfoPanel_btnCancle.getPreferredSize();
	SfoPanel_btnCancle.setBounds(800 - 2 * SfoPanel_btnCancle_size.width,
			550 - SfoPanel_btnCancle_size.height, SfoPanel_btnCancle_size.width,
			SfoPanel_btnCancle_size.height);
	SfoPanel.add(SfoPanel_btnCancle);
	
	//ActionListiner For Cancle
	SfoPanel_btnCancle.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	});

	// button for Install
	JButton SfoPanel_btnInstall = new JButton("Install");
	Dimension SfoPanel_btnInstall_size = SfoPanel_btnInstall.getPreferredSize();
	SfoPanel_btnInstall.setBounds(800 - SfoPanel_btnInstall_size.width, 550 - SfoPanel_btnInstall_size.height,
			SfoPanel_btnInstall_size.width, SfoPanel_btnInstall_size.height);
	SfoPanel.add(SfoPanel_btnInstall);

	// ActionListiner for button Install
	SfoPanel_btnInstall.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			// SfoPanel.setVisible(false);
			// Add_EnvClear_Panel();
			addSfoPost();
			SfoPanel_Header.setText("Installing..........");
			SfoPanel_Header.setForeground(Color.red);
			String Profile=null;
			//For UAMS
			Profile="create user "+SfoPanel_txtUAMS.getText()+" identified by "
					+SfoPanel_txtpUAMS.getText()+" default tablespace "+SfoPanel_txtDef.getText()
					+" temporary tablespace "+SfoPanel_txttemp.getText()+" profile default account unlock";
			dropUser(SfoPanel_txtUAMS.getText());
			if(Create_User(SfoPanel_txtUAMS.getText(), Profile, "SFO/UserUams.txt")==true)
			{
				SfoPanel_lblUAMS_1.setText("User Created.");
			}else{
				SfoPanel_lblUAMS_1.setText("Error");
			}//End for UAMS working
			
			
			//For AFFUSER
			Profile="create user "+SfoPanel_txteAFFUSER.getText()+" identified by "
					+SfoPanel_txtAFFUSER.getText()+" default tablespace "+SfoPanel_txtDef.getText()
					+" temporary tablespace "+SfoPanel_txttemp.getText()+" profile default account unlock";
			dropUser(SfoPanel_txteAFFUSER.getText());
			if(Create_User(SfoPanel_txteAFFUSER.getText(), Profile, "SFO/AFFUSER.txt")==true)
			{
				SfoPanel_lblAFFUSER_1.setText("User Created.");
			}else{
				SfoPanel_lblAFFUSER_1.setText("Error");
			}//End for AFFUSER working
			
			
			//FOR REFUSERF
			Profile="create user "+SfoPanel_txteREFUSER.getText()+" identified by "
					+SfoPanel_txtREFUSER.getText()+" default tablespace "+SfoPanel_txtDef.getText()
					+" temporary tablespace "+SfoPanel_txttemp.getText()+" profile default quota unlimited on "+SfoPanel_txtDef.getText();
			dropUser(SfoPanel_txteREFUSER.getText());
			if(Create_User(SfoPanel_txteREFUSER.getText(), Profile, "SFO/REFUSER.txt")==true)
			{
				SfoPanel_lblREFUSER_1.setText("User Created.");
			}else{
				SfoPanel_lblREFUSER_1.setText("Error");
			}//End for REFUSER working
			
			
			//For ALTREFUSER
			Profile="create user "+SfoPanel_txteALTREFUSER.getText()+" identified by "
					+SfoPanel_txtALTREFUSER.getText()+" default tablespace "+SfoPanel_txtDef.getText()
					+" temporary tablespace "+SfoPanel_txttemp.getText()+" profile default quota unlimited on "+SfoPanel_txtDef.getText();
			dropUser(SfoPanel_txteALTREFUSER.getText());
			if(Create_User(SfoPanel_txteALTREFUSER.getText(), Profile, "SFO/ALTREFUSER.txt")==true)
			{
				SfoPanel_lblALTREFUSER_1.setText("User Created.");
			}else{
				SfoPanel_lblALTREFUSER_1.setText("Error");
			}//End of ALTREFUSER working
			
			
			//For OSSUI
			Profile="create user "+SfoPanel_txteOSSUI.getText()+" identified by "
					+SfoPanel_txtOSSUI.getText()+" default tablespace "+SfoPanel_txtDef.getText()
					+" temporary tablespace "+SfoPanel_txttemp.getText()+" quota unlimited on "+SfoPanel_txtDef.getText();
			dropUser(SfoPanel_txteOSSUI.getText());
			if(Create_User(SfoPanel_txteOSSUI.getText(), Profile, "SFO/OSSUI.txt")==true)
			{
				SfoPanel_lblOSSUI_1.setText("User Created.");
			}else{
				SfoPanel_lblOSSUI_1.setText("Error");
			}//End of OSSUI working
			
			
			
			//For OSSUI_CLIENT
			Profile="create user "+SfoPanel_txteOSSUI_CLIENT.getText()+" identified by "
					+SfoPanel_txtOSSUI_CLIENT.getText()+" default tablespace "+SfoPanel_txtDef.getText()
					+" temporary tablespace "+SfoPanel_txttemp.getText()+" quota unlimited on "+SfoPanel_txtDef.getText();
			dropUser(SfoPanel_txteOSSUI_CLIENT.getText());
			if(Create_User(SfoPanel_txteOSSUI_CLIENT.getText(), Profile, "SFO/OSSUI_CLIENT.txt")==true)
			{
				SfoPanel_lblOSSUI_CLIENT_1.setText("User Created.");
			}else{
				SfoPanel_lblOSSUI_CLIENT_1.setText("Error");
			}//End of OSSUI_CLIENT working
			
			//for TEMPSYS
			Profile="create user "+SfoPanel_txteTEMPSYS.getText()+" identified by "
					+SfoPanel_txtTEMPSYS.getText()+" default tablespace "+SfoPanel_txtDef.getText()
					+" temporary tablespace "+SfoPanel_txttemp.getText()+" quota unlimited on "+SfoPanel_txtDef.getText();
			dropUser(SfoPanel_txteTEMPSYS.getText());
			if(Create_User(SfoPanel_txteTEMPSYS.getText(), Profile, "SFO/TEMPSYS.txt")==true)
			{
				SfoPanel_lblTEMPSYS_1.setText("User Created.");
			}else{
				SfoPanel_lblTEMPSYS_1.setText("Error");
			}//End of TEMPSYS
			
			
			//Updating the properties file
			Properties prop=new Properties();
			
			try {
				/*FileInputStream input=new FileInputStream("SFO/test.properties");
				prop.load(input);
				input.close();*/
				FileOutputStream output=new FileOutputStream("testsfo.properties");
				prop.setProperty("AFFProduct/aff.global.uams.client.db.host", serverPanel_txtUSN.getText());//illin3351
				prop.setProperty("AFFProduct/aff.global.uams.client.db.instance", serverPanel_txtUSU.getText());//testodo1
				prop.setProperty("AFFProduct/aff.global.uams.client.db.port","1521");
				prop.setProperty("AFFProduct/aff.global.uams.client.db.user",SfoPanel_txtUAMS.getText());//UAMS
				prop.setProperty("AFFProduct/aff.global.uams.client.db.pswd", SfoPanel_txtpUAMS.getText());//UAMS
				prop.setProperty("Storage1/storage.path.param/xpi.StoragePath","/ossusers1/oss/users/"+serverPanel_txtUSU.getText());
				prop.setProperty("Storage1/storage.path.param/xpi.CreateDirectoryIfNeeded","false");
				prop.setProperty("Storage1/storage.path.param/xpi.skipStoragePostInstallationValidation","true");
				prop.setProperty("JEE1/container.server.type","WLS");
				prop.setProperty("JEE1/container.domain.name","affDomain_"+serverPanel_txtUSU.getText());
				prop.setProperty("JEE1/container.server.name","affServer_"+serverPanel_txtUSU.getText());
				prop.setProperty("JEE1/container.is.listen.port.enabled","true");
				prop.setProperty("JEE1/container.listen.port",SfoPanel_txtPort.getText());//64001
				prop.setProperty("JEE1/container.is.ssl.listen.port.enabled","false");
				prop.setProperty("JEE1/container.vendor.home","/opt/weblogic1213/wlserver_12.1.3/installation/wlserver/");
				prop.setProperty("JEE1/weblogic.admin.username","weblogic");//console username
				prop.setProperty("JEE1/weblogic.admin.password","weblogic123");//console password
				prop.setProperty("JEE1/wl.install.params/aff.search.configurations/container.search.mode","false");
				prop.setProperty("JEE1/wl.install.params/aff.mec.server.versioning/is.mec.versioning.enabled","false");
				prop.setProperty("JEE1/wl.install.params/email.configurations/enable.email","false");
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.conn/aff.global.oracle.conn.host", serverPanel_txtUSN.getText());//illin3351
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.conn/aff.global.oracle.conn.sid",serverPanel_txtUSU.getText());//testodo1
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.conn/aff.global.oracle.conn.port","1521");
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.conn/aff.global.oracle.conn.username",SfoPanel_txteAFFUSER.getText());//AFFUSER
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.conn/aff.global.oracle.conn.pswd",SfoPanel_txtAFFUSER.getText());//AFFUSER
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ref.conn/aff.global.oracle.ref.conn.host=illin3351",serverPanel_txtUSN.getText());//illin3351
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ref.conn/aff.global.oracle.ref.conn.sid",serverPanel_txtUSU.getText());//testodo1
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ref.conn/aff.global.oracle.ref.conn.port","1521");
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ref.conn/aff.global.oracle.ref.conn.username",SfoPanel_txteREFUSER.getText());//REFUSER
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ref.conn/aff.global.oracle.ref.conn.pswd",SfoPanel_txtREFUSER.getText());//REFUSER
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.alt.ref.conn/aff.global.oracle.alt.ref.conn.host",serverPanel_txtUSN.getText());//=illin3351
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.alt.ref.conn/aff.global.oracle.alt.ref.conn.sid",serverPanel_txtUSU.getText());//=testodo1
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.alt.ref.conn/aff.global.oracle.alt.ref.conn.port","1521");
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.alt.ref.conn/aff.global.oracle.alt.ref.conn.username",SfoPanel_txteALTREFUSER.getText());//=ALTREFUSER
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.alt.ref.conn/aff.global.oracle.alt.ref.conn.pswd",SfoPanel_txtALTREFUSER.getText());//=ALTREFUSER
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ossui.conn/aff.global.oracle.ossui.conn.host",serverPanel_txtUSN.getText());//=illin3351
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ossui.conn/aff.global.oracle.ossui.conn.sid",serverPanel_txtUSU.getText());//=testodo1
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ossui.conn/aff.global.oracle.ossui.conn.port","1521");
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ossui.conn/aff.global.oracle.ossui.conn.username",SfoPanel_txteOSSUI.getText());//=OSSUI
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ossui.conn/aff.global.oracle.ossui.conn.pswd",SfoPanel_txtOSSUI.getText());//=OSSUI
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ossui.conn/db.user.ossui.client", SfoPanel_txteOSSUI_CLIENT.getText());//=OSSUI_CLIENT
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ossui.conn/db.password.ossui.client",SfoPanel_txtOSSUI_CLIENT.getText());//=OSSUI_CLIENT
				prop.setProperty("JEE1/aff.ora.params/aff.global.oracle.ossui.conn/db.tablespace.ossui",SfoPanel_txtDef.getText());//=USR
				prop.setProperty("CommonPropertiesContainer1/CommonInstallationParameters/DBCommonUserParametersGroup/db.user.installer",dbmsPanel_txtSDU.getText());//=cradba
				prop.setProperty("CommonPropertiesContainer1/CommonInstallationParameters/DBCommonUserParametersGroup/db.password.installer",dbmsPanel_txtSDP.getText());//=cradba
				prop.setProperty("asd.asc.config1/asd.asc.config/ANNIntegeration/enable.ann.integeration","false");
				prop.setProperty("asd.asc.config1/asd.asc.config/Notification/enable.notification.integration","false");
				
				
				prop.store(output, null);
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//End of Updating Properties file
			
			//Transfering Properties file to server
		    Upload_To_Server("testsfo.properties","/ossusers1/oss/users/testodo1/");
			
			
			String command="./installer/bin/XPI.sh --mem 4 --install --silent -p /ossusers1/oss/users/testodo1/SFOKit2_impl_10.0.1.0.0_Linux_64_27-01-17_08_07_44.jar -t testodo1.topology -pr /ossusers1/oss/users/testodo1/testsfo.properties";
			if(Server_Command(command)==true){
				SfoPanel_Header.setText("Installed");
			}else{
				SfoPanel_Header.setText("eRROR");
			}
			
		}
	});
}


public void addUsmPanel(){
	//JPanel UsmPanel = new JPanel();
	UsmPanel.setBounds(0, 0, 900, 650);
	UsmPanel.setLayout(null);
	//UsmPanel.setBackground(Color.lightGray);
	UsmPanel.setOpaque(false);

	System.out.println(UsmPanel.getSize());
	jfrm.add(UsmPanel);

	JLabel UsmPanel_Header = new JLabel("Database user Creation");
	Dimension UsmPanel_Header_size = UsmPanel_Header.getPreferredSize();
	UsmPanel_Header.setBounds(350, 530, UsmPanel_Header_size.width, UsmPanel_Header_size.height);
	UsmPanel.add(UsmPanel_Header);

	// *************************************************************************************
	//Label for port for Admin Port
	JLabel UsmPanel_lblAdminPort = new JLabel("Admin Port");
	Dimension UsmPanel_lblAdminPort_size = UsmPanel_lblAdminPort.getPreferredSize();
	UsmPanel_lblAdminPort.setBounds(150, 110, UsmPanel_lblAdminPort_size.width, UsmPanel_lblAdminPort_size.height);
	UsmPanel.add(UsmPanel_lblAdminPort);

	// TextField for Admin Port
	JTextField UsmPanel_txtAdminPort = new JTextField(10);
	UsmPanel_txtAdminPort.setBounds(350, 110, 150, UsmPanel_lblAdminPort_size.height);
	UsmPanel.add(UsmPanel_txtAdminPort);
	
	//label for Port for Manged Port 
	JLabel UsmPanel_lblManPort = new JLabel("Managed Port");
	Dimension UsmPanel_lblManPort_size = UsmPanel_lblManPort.getPreferredSize();
	UsmPanel_lblManPort.setBounds(150, 140, UsmPanel_lblManPort_size.width, UsmPanel_lblManPort_size.height);
	UsmPanel.add(UsmPanel_lblManPort);

	// TextField for Managed Port
	JTextField UsmPanel_txtManPort = new JTextField(10);
	UsmPanel_txtManPort.setBounds(350, 140, 150, UsmPanel_lblManPort_size.height);
	UsmPanel.add(UsmPanel_txtManPort);
	
	
	//Label for Port Number for NodeManager
	JLabel UsmPanel_lblPort = new JLabel("NodeManager Port");
	Dimension UsmPanel_lblPort_size = UsmPanel_lblPort.getPreferredSize();
	UsmPanel_lblPort.setBounds(150, 170, UsmPanel_lblPort_size.width, UsmPanel_lblPort_size.height);
	UsmPanel.add(UsmPanel_lblPort);

	// TextField for NodeManager Port
	JTextField UsmPanel_txtPort = new JTextField(10);
	UsmPanel_txtPort.setBounds(350, 170, 150, UsmPanel_lblPort_size.height);
	UsmPanel.add(UsmPanel_txtPort);
	
	
	// Label for Default Tablespace Input
	JLabel UsmPanel_lblDef = new JLabel("Default Tablespace");
	Dimension UsmPanel_lblDef_size = UsmPanel_lblDef.getPreferredSize();
	UsmPanel_lblDef.setBounds(150, 200, UsmPanel_lblDef_size.width, UsmPanel_lblDef_size.height);
	UsmPanel.add(UsmPanel_lblDef);

	// TextField for Default tablespace 
	JTextField UsmPanel_txtDef = new JTextField(10);
	UsmPanel_txtDef.setBounds(350, 200, 150, UsmPanel_lblDef_size.height);
	UsmPanel.add(UsmPanel_txtDef);

	// Label for Temporary tablespace input
	JLabel UsmPanel_lbltemp = new JLabel("Temporary Tablespace");
	Dimension UsmPanel_lbltemp_size = UsmPanel_lbltemp.getPreferredSize();
	UsmPanel_lbltemp.setBounds(150, 230, UsmPanel_lbltemp_size.width, UsmPanel_lbltemp_size.height);
	UsmPanel.add(UsmPanel_lbltemp);

	// TextField for temporary tablesapce
	JTextField UsmPanel_txttemp = new JTextField(10);
	UsmPanel_txttemp.setBounds(350, 230, 150, UsmPanel_lbltemp_size.height);
	UsmPanel.add(UsmPanel_txttemp);
	// *************************************************************************************

	JLabel UsmPanel_lblUSER = new JLabel("Create database Users");
	Dimension UsmPanel_lblUSER_size = UsmPanel_lblUSER.getPreferredSize();
	UsmPanel_lblUSER.setBounds(150, 260, UsmPanel_lblUSER_size.width, UsmPanel_lblUSER_size.height);
	UsmPanel.add(UsmPanel_lblUSER);

	JLabel UsmPanel_lblUSERN = new JLabel("User Name");
	Dimension UsmPanel_lblUSERN_size = UsmPanel_lblUSERN.getPreferredSize();
	UsmPanel_lblUSERN.setBounds(350, 260, UsmPanel_lblUSERN_size.width,
			UsmPanel_lblUSERN_size.height);
	UsmPanel.add(UsmPanel_lblUSERN);

	JLabel UsmPanel_lblUSERP = new JLabel("Password");
	Dimension UsmPanel_lblUSERP_size = UsmPanel_lblUSERP.getPreferredSize();
	UsmPanel_lblUSERP.setBounds(550, 260, UsmPanel_lblUSERP_size.width,
			UsmPanel_lblUSERP_size.height);
	UsmPanel.add(UsmPanel_lblUSERP);

	// ******************************************************************************************
	// label for Unix Server Password
	JLabel UsmPanel_lblUAMS = new JLabel("Create User UAMS");
	Dimension UsmPanel_lblUAMS_size = UsmPanel_lblUAMS.getPreferredSize();
	UsmPanel_lblUAMS.setBounds(150, 290, UsmPanel_lblUAMS_size.width, UsmPanel_lblUAMS_size.height);
	UsmPanel.add(UsmPanel_lblUAMS);

	// TextField for UAMS UserName 
	JTextField UsmPanel_txtUAMS = new JTextField(10);
	UsmPanel_txtUAMS.setBounds(350, 290, 150, UsmPanel_lblUAMS_size.height);
	UsmPanel.add(UsmPanel_txtUAMS);

	// TextField for UAMS Password
	JPasswordField UsmPanel_txtpUAMS = new JPasswordField(10);
	UsmPanel_txtpUAMS.setBounds(550, 290, 150, UsmPanel_lblUAMS_size.height);
	UsmPanel.add(UsmPanel_txtpUAMS);

	// Label for UAMS Status
	JLabel UsmPanel_lblUAMS_1 = new JLabel("Status");
	Dimension UsmPanel_lblUAMS_1_size = UsmPanel_lblUAMS_1.getPreferredSize();
	UsmPanel_lblUAMS_1.setBounds(700, 290, 3*UsmPanel_lblUAMS_1_size.width,
			UsmPanel_lblUAMS_1_size.height);
	UsmPanel.add(UsmPanel_lblUAMS_1);
	// ******************************************************************************************

	// ******************************************************************************************
	// label for CRAMER
	JLabel UsmPanel_lblCRAMER = new JLabel("Create User CRAMER");
	Dimension UsmPanel_lblCRAMER_size = UsmPanel_lblCRAMER.getPreferredSize();
	UsmPanel_lblCRAMER.setBounds(150, 320, UsmPanel_lblCRAMER_size.width,
			UsmPanel_lblCRAMER_size.height);
	UsmPanel.add(UsmPanel_lblCRAMER);
	
	

	// TextField for Unix CRAMER Username
	JTextField UsmPanel_txteCRAMER = new JTextField(10);
	UsmPanel_txteCRAMER.setBounds(350, 320, 150, UsmPanel_lblCRAMER_size.height);
	UsmPanel.add(UsmPanel_txteCRAMER);

	// TextField for CRAMER Password
	JPasswordField UsmPanel_txtCRAMER = new JPasswordField(10);
	UsmPanel_txtCRAMER.setBounds(550, 320, 150, UsmPanel_lblCRAMER_size.height);
	UsmPanel.add(UsmPanel_txtCRAMER);

	// Label for CRAMER DbaUser Status
	JLabel UsmPanel_lblCRAMER_1 = new JLabel("Status");
	Dimension UsmPanel_lblCRAMER_1_size = UsmPanel_lblCRAMER_1.getPreferredSize();
	UsmPanel_lblCRAMER_1.setBounds(700, 320, 3*UsmPanel_lblCRAMER_1_size.width,
			UsmPanel_lblCRAMER_1_size.height);
	UsmPanel.add(UsmPanel_lblCRAMER_1);
	// ******************************************************************************************

	// ******************************************************************************************
	// label for CRAMER_INSTALLER
	JLabel UsmPanel_lblCRAMER_INSTALLER = new JLabel("Create User CRAMER_INSTALLER");
	Dimension UsmPanel_lblCRAMER_INSTALLER_size = UsmPanel_lblCRAMER_INSTALLER.getPreferredSize();
	UsmPanel_lblCRAMER_INSTALLER.setBounds(150, 350, UsmPanel_lblCRAMER_INSTALLER_size.width,
			UsmPanel_lblCRAMER_INSTALLER_size.height);
	UsmPanel.add(UsmPanel_lblCRAMER_INSTALLER);

	// TextField for CRAMER_INSTALLER username
	JTextField UsmPanel_txteCRAMER_INSTALLER = new JTextField(10);
	UsmPanel_txteCRAMER_INSTALLER.setBounds(350, 350, 150, UsmPanel_lblCRAMER_INSTALLER_size.height);
	UsmPanel.add(UsmPanel_txteCRAMER_INSTALLER);

	// TextField for CRAMER_INSTALLER Password
	JPasswordField UsmPanel_txtCRAMER_INSTALLER = new JPasswordField(10);
	UsmPanel_txtCRAMER_INSTALLER.setBounds(550, 350, 150, UsmPanel_lblCRAMER_INSTALLER_size.height);
	UsmPanel.add(UsmPanel_txtCRAMER_INSTALLER);

	// Label for CRAMER_INSTALLER DbaUser Status
	JLabel UsmPanel_lblCRAMER_INSTALLER_1 = new JLabel("Status");
	Dimension UsmPanel_lblCRAMER_INSTALLER_1_size = UsmPanel_lblCRAMER_INSTALLER_1.getPreferredSize();
	UsmPanel_lblCRAMER_INSTALLER_1.setBounds(700, 350, 3*UsmPanel_lblCRAMER_INSTALLER_1_size.width,
			UsmPanel_lblCRAMER_INSTALLER_1_size.height);
	UsmPanel.add(UsmPanel_lblCRAMER_INSTALLER_1);
	// ******************************************************************************************

	// ***********************************************************************************************
	// Lebel for CRAMER_SHARED
	JLabel UsmPanel_lblCRAMER_SHARED = new JLabel("Create User CRAMER_SHARED");
	Dimension UsmPanel_lblCRAMER_SHARED_size = UsmPanel_lblCRAMER_SHARED.getPreferredSize();
	UsmPanel_lblCRAMER_SHARED.setBounds(150, 380, UsmPanel_lblCRAMER_SHARED_size.width,
			UsmPanel_lblCRAMER_SHARED_size.height);
	UsmPanel.add(UsmPanel_lblCRAMER_SHARED);


	// TextField for CRAMER_SHARED UserName
	JTextField UsmPanel_txteCRAMER_SHARED = new JTextField(10);
	UsmPanel_txteCRAMER_SHARED.setBounds(350, 380, 150, UsmPanel_lblCRAMER_SHARED_size.height);
	UsmPanel.add(UsmPanel_txteCRAMER_SHARED);

	// TextField for CRAMER_SHARED Password
	JPasswordField UsmPanel_txtCRAMER_SHARED = new JPasswordField(10);
	UsmPanel_txtCRAMER_SHARED.setBounds(550, 380, 150, UsmPanel_lblCRAMER_SHARED_size.height);
	UsmPanel.add(UsmPanel_txtCRAMER_SHARED);

	// Label for CRAMER_SHARED DbaUser Status
	JLabel UsmPanel_lblCRAMER_SHARED_1 = new JLabel("Status");
	Dimension UsmPanel_lblCRAMER_SHARED_1_size = UsmPanel_lblCRAMER_SHARED_1.getPreferredSize();
	UsmPanel_lblCRAMER_SHARED_1.setBounds(700, 380, 3*UsmPanel_lblCRAMER_SHARED_1_size.width,
			UsmPanel_lblCRAMER_SHARED_1_size.height);
	UsmPanel.add(UsmPanel_lblCRAMER_SHARED_1);
	// ******************************************************************************************

	// ******************************************************************************************
	// Lebel for CRAMERSSO
	JLabel UsmPanel_lblCRAMERSSO = new JLabel("Create User CRAMERSSO");
	Dimension UsmPanel_lblCRAMERSSO_size = UsmPanel_lblCRAMERSSO.getPreferredSize();
	UsmPanel_lblCRAMERSSO.setBounds(150, 410, UsmPanel_lblCRAMERSSO_size.width,
			UsmPanel_lblCRAMERSSO_size.height);
	UsmPanel.add(UsmPanel_lblCRAMERSSO);


	// TextField for CRAMERSSO  UserName
	JTextField UsmPanel_txteCRAMERSSO = new JTextField(10);
	UsmPanel_txteCRAMERSSO.setBounds(350, 410, 150, UsmPanel_lblCRAMERSSO_size.height);
	UsmPanel.add(UsmPanel_txteCRAMERSSO);

	// TextField for CRAMERSSO Password
	JPasswordField UsmPanel_txtCRAMERSSO = new JPasswordField(10);
	UsmPanel_txtCRAMERSSO.setBounds(550, 410, 150, UsmPanel_lblCRAMERSSO_size.height);
	UsmPanel.add(UsmPanel_txtCRAMERSSO);

	// Label for CRAMERSSO DbaUser Status
	JLabel UsmPanel_lblCRAMERSSO_1 = new JLabel("Status");
	Dimension UsmPanel_lblCRAMERSSO_1_size = UsmPanel_lblCRAMERSSO_1.getPreferredSize();
	UsmPanel_lblCRAMERSSO_1.setBounds(700, 410, 3*UsmPanel_lblCRAMERSSO_1_size.width,
			UsmPanel_lblCRAMERSSO_1_size.height);
	UsmPanel.add(UsmPanel_lblCRAMERSSO_1);
	// ******************************************************************************************

	// ***************************************************************************************************
	// Lebel for CRAMERDIRECTORY
	JLabel UsmPanel_lblCRAMERDIRECTORY = new JLabel("Create User CRAMERDIRECTORY");
	Dimension UsmPanel_lblCRAMERDIRECTORY_size = UsmPanel_lblCRAMERDIRECTORY.getPreferredSize();
	UsmPanel_lblCRAMERDIRECTORY.setBounds(150, 440, UsmPanel_lblCRAMERDIRECTORY_size.width,
			UsmPanel_lblCRAMERDIRECTORY_size.height);
	UsmPanel.add(UsmPanel_lblCRAMERDIRECTORY);


	// TextField for CRAMERDIRECTORY UserName
	JTextField UsmPanel_txteCRAMERDIRECTORY = new JTextField(10);
	UsmPanel_txteCRAMERDIRECTORY.setBounds(350, 440, 150, UsmPanel_lblCRAMERDIRECTORY_size.height);
	UsmPanel.add(UsmPanel_txteCRAMERDIRECTORY);

	// TextField for CRAMERDIRECTORY Password
	JPasswordField UsmPanel_txtCRAMERDIRECTORY = new JPasswordField(10);
	UsmPanel_txtCRAMERDIRECTORY.setBounds(550, 440, 150, UsmPanel_lblCRAMERDIRECTORY_size.height);
	UsmPanel.add(UsmPanel_txtCRAMERDIRECTORY);

	// Label for CRAMERDIRECTORY DbaUser Status
	JLabel UsmPanel_lblCRAMERDIRECTORY_1 = new JLabel("Status");
	Dimension UsmPanel_lblCRAMERDIRECTORY_1_size = UsmPanel_lblCRAMERDIRECTORY_1.getPreferredSize();
	UsmPanel_lblCRAMERDIRECTORY_1.setBounds(700, 440, 3*UsmPanel_lblCRAMERDIRECTORY_1_size.width,
			UsmPanel_lblCRAMERDIRECTORY_1_size.height);
	UsmPanel.add(UsmPanel_lblCRAMERDIRECTORY_1);
	// ******************************************************************************************
	//Label for CRAMER_COMMAN
	JLabel UsmPanel_lblCRAMER_COMMAN = new JLabel("Create User CRAMER_COMMAN");
	Dimension UsmPanel_lblCRAMER_COMMAN_size = UsmPanel_lblCRAMER_COMMAN.getPreferredSize();
	UsmPanel_lblCRAMER_COMMAN.setBounds(150, 470, UsmPanel_lblCRAMER_COMMAN_size.width,
			UsmPanel_lblCRAMER_COMMAN_size.height);
	UsmPanel.add(UsmPanel_lblCRAMER_COMMAN);


	// TextField for CRAMER_COMMAN UserName
	JTextField UsmPanel_txteCRAMER_COMMAN = new JTextField(10);
	UsmPanel_txteCRAMER_COMMAN.setBounds(350, 470, 150, UsmPanel_lblCRAMER_COMMAN_size.height);
	UsmPanel.add(UsmPanel_txteCRAMER_COMMAN);

	// TextField for CRAMER_COMMAN Password
	JPasswordField UsmPanel_txtCRAMER_COMMAN = new JPasswordField(10);
	UsmPanel_txtCRAMER_COMMAN.setBounds(550, 470, 150, UsmPanel_lblCRAMER_COMMAN_size.height);
	UsmPanel.add(UsmPanel_txtCRAMER_COMMAN);

	// Label for CRAMER_COMMAN DbaUser Status
	JLabel UsmPanel_lblCRAMER_COMMAN_1 = new JLabel("Status");
	Dimension UsmPanel_lblCRAMER_COMMAN_1_size = UsmPanel_lblCRAMER_COMMAN_1.getPreferredSize();
	UsmPanel_lblCRAMER_COMMAN_1.setBounds(700, 470, 3*UsmPanel_lblCRAMER_COMMAN_1_size.width,
			UsmPanel_lblCRAMER_COMMAN_1_size.height);
	UsmPanel.add(UsmPanel_lblCRAMER_COMMAN_1);
	// ******************************************************************************************
	
	//***************************************************************************************
	//Label for REPORTS
	JLabel UsmPanel_lblREPORTS = new JLabel("Create User REPORTS");
	Dimension UsmPanel_lblREPORTS_size = UsmPanel_lblREPORTS.getPreferredSize();
	UsmPanel_lblREPORTS.setBounds(150, 500, UsmPanel_lblREPORTS_size.width,
			UsmPanel_lblREPORTS_size.height);
	UsmPanel.add(UsmPanel_lblREPORTS);


	// TextField for Unix Server Name
	JTextField UsmPanel_txteREPORTS = new JTextField(10);
	UsmPanel_txteREPORTS.setBounds(350, 500, 150, UsmPanel_lblREPORTS_size.height);
	UsmPanel.add(UsmPanel_txteREPORTS);

	// TextField for REPORTS Password
	JPasswordField UsmPanel_txtREPORTS = new JPasswordField(10);
	UsmPanel_txtREPORTS.setBounds(550, 500, 150, UsmPanel_lblREPORTS_size.height);
	UsmPanel.add(UsmPanel_txtREPORTS);

	// Label for Unix Server DbaUser Status
	JLabel UsmPanel_lblREPORTS_1 = new JLabel("Status");
	Dimension UsmPanel_lblREPORTS_1_size = UsmPanel_lblREPORTS_1.getPreferredSize();
	UsmPanel_lblREPORTS_1.setBounds(700, 500, 3*UsmPanel_lblREPORTS_1_size.width,
			UsmPanel_lblREPORTS_1_size.height);
	UsmPanel.add(UsmPanel_lblREPORTS_1);
	
	//*************************************************************************************************

	// button for Cancle
	JButton UsmPanel_btnCancle = new JButton("Cancle");
	Dimension UsmPanel_btnCancle_size = UsmPanel_btnCancle.getPreferredSize();
	UsmPanel_btnCancle.setBounds(800 - 2 * UsmPanel_btnCancle_size.width,
			550 - UsmPanel_btnCancle_size.height, UsmPanel_btnCancle_size.width,
			UsmPanel_btnCancle_size.height);
	UsmPanel.add(UsmPanel_btnCancle);
	
	//ActionListiner for button Cancle
	UsmPanel_btnCancle.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	});

	// button for Install
	JButton UsmPanel_btnInstall = new JButton("Install");
	Dimension UsmPanel_btnInstall_size = UsmPanel_btnInstall.getPreferredSize();
	UsmPanel_btnInstall.setBounds(800 - UsmPanel_btnInstall_size.width, 550 - UsmPanel_btnInstall_size.height,
			UsmPanel_btnInstall_size.width, UsmPanel_btnInstall_size.height);
	UsmPanel.add(UsmPanel_btnInstall);

	// ActionListiner for button Install
	UsmPanel_btnInstall.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			addUsmPost();
			//Dropping previous users
			try{
		    	PrintWriter pr=new PrintWriter("drop_all1.sql","UTF-8");
		    	//pr.println("spool drop_all.sql.log");
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/dropConnectedSessions.sql "+UsmPanel_txteCRAMERDIRECTORY.getText()+";");//CRAMERDIRECTORY
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/dropConnectedSessions.sql "+UsmPanel_txteCRAMER.getText()+";");//CRAMER                     
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/dropConnectedSessions.sql "+UsmPanel_txtUAMS.getText()+";");//UAMS
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/dropConnectedSessions.sql "+UsmPanel_txteCRAMERSSO.getText()+";");//CRAMERSSO
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/dropConnectedSessions.sql "+UsmPanel_txteCRAMER_SHARED.getText()+";");//CRAMER_SHARED
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/dropConnectedSessions.sql "+UsmPanel_txteCRAMER_COMMAN.getText()+";");//CRAMER_COMMON
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/dropConnectedSessions.sql "+UsmPanel_txteCRAMER_INSTALLER.getText()+";");//CRAMER_INSTALLER
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/dropConnectedSessions.sql sfuser;");
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/dropConnectedSessions.sql "+UsmPanel_txteREPORTS.getText()+";");//REPORTS
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/dropConnectedSessions.sql MNGP;");
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/drop_schema_owner.sql "+UsmPanel_txteCRAMERDIRECTORY.getText()+";");//CRAMERDIRECTORY
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/drop_schema_owner.sql "+UsmPanel_txteCRAMER.getText()+";");//CRAMER
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/drop_schema_owner.sql "+UsmPanel_txtUAMS.getText()+";");//UAMS
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/drop_schema_owner.sql "+UsmPanel_txteCRAMERSSO.getText()+";");//CRAMERSSO
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/drop_schema_owner.sql "+UsmPanel_txteCRAMER_SHARED.getText()+";");//CRAMER_SHARED
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/drop_schema_owner.sql "+UsmPanel_txteCRAMER_COMMAN.getText()+";");//CRAMER_COMMAN
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/drop_schema_owner.sql "+UsmPanel_txteCRAMER_INSTALLER.getText()+";");//CRAMER_INSTALLER
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/drop_schema_owner.sql sfuser;");
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/drop_schema_owner.sql "+UsmPanel_txteREPORTS.getText()+";");//Report
		    	pr.println("exit;");
		    	pr.close();
		    }catch(IOException er){
		    	er.printStackTrace();
		    }
		    Upload_To_Server("drop_all1.sql","/ossusers1/oss/users/testusm1/dba/");
			
			
			
			//Crateing Database User
			try{
		    	PrintWriter pr=new PrintWriter("create_all1.sql","UTF-8");
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/create_installer_user.sql "+UsmPanel_txteCRAMER_INSTALLER.getText()+" "+UsmPanel_txtCRAMER_INSTALLER.getText());//CRAMER_INSTALLER
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/create_schema_owner.sql "+UsmPanel_txteCRAMER.getText()+" "+UsmPanel_txtCRAMER.getText()+" "+UsmPanel_txtDef.getText()+" "+UsmPanel_txttemp.getText()+";");//CRAMER
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/create_common_user.sql "+UsmPanel_txteCRAMER_COMMAN.getText()+" "+UsmPanel_txtCRAMER_COMMAN.getText()+" "+UsmPanel_txtDef.getText()+" "+UsmPanel_txttemp.getText()+" "+UsmPanel_txteCRAMER.getText()+";");//CRAMER_COMMAN
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/create_shared_user.sql "+UsmPanel_txteCRAMER_SHARED.getText()+" "+UsmPanel_txtDef.getText()+" "+UsmPanel_txttemp.getText()+";");//CRAMER_SHARED
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/create_cramersso_user.sql "+UsmPanel_txteCRAMERSSO.getText()+" "+UsmPanel_txtCRAMERSSO.getText()+" "+UsmPanel_txtDef.getText()+" "+UsmPanel_txttemp.getText()+";");//CRAMERSSO
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/create-ar-schema.sql "+UsmPanel_txteREPORTS.getText()+" "+UsmPanel_txtREPORTS.getText()+" "+UsmPanel_txtDef.getText()+" "+UsmPanel_txttemp.getText()+";");//REPORTS
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/create_asm_user.sql "+UsmPanel_txtUAMS.getText()+" "+UsmPanel_txtpUAMS.getText()+" "+UsmPanel_txtDef.getText()+" "+UsmPanel_txttemp.getText()+";");//UAMS
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/create_directory_user.sql "+UsmPanel_txteCRAMERDIRECTORY.getText()+" "+UsmPanel_txtCRAMERDIRECTORY.getText()+" "+UsmPanel_txtDef.getText()+" "+UsmPanel_txttemp.getText()+";");//CRAMERDIRECTORY
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/create_sf_user.sql sfuser sfuser "+UsmPanel_txtDef.getText()+" "+UsmPanel_txttemp.getText()+";");
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/grant_MM_privileges_schema_owner.sql "+UsmPanel_txteCRAMER.getText()+";");//CRAMER
		    	pr.println("grant drop any table to "+UsmPanel_txteCRAMER.getText()+";");//CRAMER
		    	pr.println("@/ossusers1/oss/users/testusm1/dba/hf-8830.sql "+UsmPanel_txteCRAMER_INSTALLER.getText()+" "+UsmPanel_txteCRAMER.getText()+";");
		    	pr.println("alter user "+UsmPanel_txteCRAMER.getText()+" quota unlimited on USM_MEF_SVCS_DATA;");
		    	pr.println("alter user "+UsmPanel_txteCRAMER.getText()+" quota unlimited on USM_MEF_SVCS_INDEX;");
		    	pr.println("commit;");
		    	pr.println("exit;");
		    	pr.close();
		    }catch(IOException er){
		    	er.printStackTrace();
		    }
		    Upload_To_Server("create_all1.sql","/ossusers1/oss/users/testusm1/dba/");
		    if(Server_Command("./dba/file.sh")==true){
		    	System.out.println("Database Created");
		    }else{
		    	System.out.println("Error in Creating DataBase");
		    }
		    
			//Updating the properties file
			Properties prop=new Properties();
			
			try {
				/*FileInputStream input=new FileInputStream("test.properties");
				prop.load(input);
				input.close();*/
				FileOutputStream output=new FileOutputStream("test.properties");
				prop.setProperty("any-account-1/password","Unix11!");
				prop.setProperty("any-account-1/name",serverPanel_txtUSU.getText());//testusm1
				prop.setProperty("any-machine-1/unmanaged","false");
				prop.setProperty("any-machine-1/name","illin3351");
				prop.setProperty("Storage1/storage.path.param/xpi.StoragePath","/ossusers1/oss/users/"+serverPanel_txtUSU.getText());
				prop.setProperty("Storage1/storage.path.param/xpi.CreateDirectoryIfNeeded","false");
				prop.setProperty("Storage1/storage.path.param/xpi.skipStoragePostInstallationValidation","true");
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/com.params.screen2/oss.profile.db.name",dbmsPanel_txtSID.getText());//testusm1
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/com.params.screen2/appserver.admin.port",UsmPanel_txtAdminPort.getText());//63000
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/com.params.screen2/appserver.managed.port",UsmPanel_txtManPort.getText());//63001
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/com.params.screen2/appserver.nodemanager.port",UsmPanel_txtPort.getText());//63006
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/com.params.screen2/container.vendor.home","/opt/weblogic1213/wlserver_12.1.3/installation/wlserver");
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/com.params.screen2/appserver.username","weblogic");
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/com.params.screen2/appserver.password","weblogic123");
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/dbServerGroup/db.name",dbmsPanel_txtSID.getText());//testusm1
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/dbServerGroup/db.host",serverPanel_txtUSN.getText());//illin3351
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/dbServerGroup/db.port","1521");
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/dbServerGroup/db.tmp.sys.user",UsmPanel_txteCRAMER_INSTALLER.getText());//CRAMER_INSTALLER
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/dbServerGroup/db.tmp.sys.pswd",UsmPanel_txtCRAMER_INSTALLER.getText());
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/dbServerGroup/db.user",UsmPanel_txteCRAMER.getText());//CRAMER
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/dbServerGroup/db.pwd",UsmPanel_txtCRAMER.getText());
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen2/db.common.user",UsmPanel_txteCRAMER_COMMAN.getText());//"CRAMER_COMMON"
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen2/db.common.password",UsmPanel_txtCRAMER_COMMAN.getText());
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen2/sso.db.user",UsmPanel_txteCRAMERSSO.getText());//"CRAMERSSO"
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen2/sso.db.password",UsmPanel_txtCRAMERSSO.getText());
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen2/db.shareduser",UsmPanel_txteCRAMER_SHARED.getText());//CRAMER_SHARED
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen2/db.sharedpassword","CRAMER_SHARED");
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen2/db.dn","cn="+dbmsPanel_txtSID.getText()+",dc="+dbmsPanel_txtSID.getText()+"");//testusm1
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen13/db.screen3/dir.db.user",UsmPanel_txteCRAMERDIRECTORY.getText());//"CRAMERDIRECTORY"
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen13/db.screen3/dir.db.password",UsmPanel_txtCRAMERDIRECTORY.getText());
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen13/db.screen3/uams.db.user",UsmPanel_txtUAMS.getText());//UAMS
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen13/db.screen3/uams.db.password",UsmPanel_txtpUAMS.getText());
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen13/db.screen3/ldap.description",dbmsPanel_txtSID.getText());//testusm1
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen13/db.screen3/asm.repository","local");
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen5/asm.admin.lookup.username","TESTUSM1");
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/db.screen5/asm.admin.lookup.password","TESTUSM1");
				prop.setProperty("CommonPropertiesCustomContainerDefinition1/Common.db.directory/db.directory.path","/tmp/");
				prop.setProperty("DBCustomContainerDefinitionForDeployDatabase1/oss.studio/mm.java.home","/usr/java/jdk1.8.0_74");
				prop.setProperty("ManagedServer/ClusterInstallationParameters/Managed/container.managed.java.home","/usr/java/jdk1.8.0_74");
				prop.setProperty("ManagedServer/install.owi.local.interface","true");
				
				
				prop.store(output, null);
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//End of Updating Properties file
			
			//Transfering Properties file to server
			Upload_To_Server("test.properties","/ossusers1/oss/users/testusm1/");
			
			
			String command="./installer/bin/XPI.sh  --perm huge --install --silent -p /ossusers1/oss/users/testusm1/resource-management-cust-1000.jar -t /ossusers1/oss/users/testusm1/ResourceManagementWebLogic.topology  -pr /ossusers1/oss/users/testusm1/test.properties";
			if(Server_Command(command)==true){
				UsmPanel_Header.setText("Installed");
			}else{
				UsmPanel_Header.setText("eRROR");
			}
			
		}
	});
}


public void addSfoPost(){
	SfoPanel.setVisible(false);
	JPanel sfoPostPanel = new JPanel();
	sfoPostPanel.setBounds(0, 0, 900, 650);
	sfoPostPanel.setLayout(null);
	//UsmPanel.setBackground(Color.lightGray);
	sfoPostPanel.setOpaque(false);
	jfrm.add(sfoPostPanel);
	
	//Label for connection string
	JLabel wlLabel=new JLabel("Weblogic Console url:");
	Dimension wlLabel_size=wlLabel.getPreferredSize();
	wlLabel.setBounds(150, 150, wlLabel_size.width, wlLabel_size.height);
	wlLabel.setOpaque(false);
	sfoPostPanel.add(wlLabel);
	
	JLabel wlUrl=new JLabel();
	wlUrl.setText("http://"+serverPanel_txtUSN.getText()+":"+SfoPanel_txtPort.getText()+"/console");
	wlUrl.setBounds(300, 150, 350, wlLabel_size.height);
	wlUrl.setOpaque(false);
	Font urlFont=new Font("Serif",Font.ITALIC,14);
	wlUrl.setFont(urlFont);
	wlUrl.setForeground(Color.BLUE);
	sfoPostPanel.add(wlUrl);
	
	//Label For Console Username
	JLabel wlUserName=new JLabel("Weblogic UserName :");
	Dimension wlUserName_size=wlUserName.getPreferredSize();
	wlUserName.setBounds(150, 180, wlUserName_size.width, wlUserName_size.height);
	wlUserName.setOpaque(false);
	sfoPostPanel.add(wlUserName);
	
	JLabel wlName=new JLabel();
	wlName.setText("weblogic");
	wlName.setBounds(300, 180, 350, wlUserName_size.height);
	wlName.setOpaque(false);
	/*Font UserName=new Font("Serif",Font.ITALIC,14);
	wlName.setFont(UserName);*/
	wlName.setForeground(Color.BLUE);
	sfoPostPanel.add(wlName);
	
	//Label for Password
	JLabel wlPassword=new JLabel("Weblogic Password :");
	Dimension wlPassword_size=wlPassword.getPreferredSize();
	wlPassword.setBounds(150, 210, wlPassword_size.width, wlPassword_size.height);
	wlPassword.setOpaque(false);
	sfoPostPanel.add(wlPassword);
	
	JLabel wlPass=new JLabel();
	wlPass.setText("weblogic123");
	wlPass.setBounds(300, 210, 350, wlPassword_size.height);
	wlPass.setOpaque(false);
	/*Font UserPass=new Font("Serif",Font.ITALIC,14);
	wlPass.setFont(UserPass);*/
	wlPass.setForeground(Color.BLUE);
	sfoPostPanel.add(wlPass);
	
	
	//Label For AmdocsOSS
	JLabel ossLabel=new JLabel("AmdocsOss Console url:");
	Dimension ossLabel_size=ossLabel.getPreferredSize();
	ossLabel.setBounds(150, 240, ossLabel_size.width, ossLabel_size.height);
	ossLabel.setOpaque(false);
	sfoPostPanel.add(ossLabel);
	
	JLabel ossUrl=new JLabel();//http://illin3351.corp.amdocs.com:64001/AmdocsOSS/Portal/login.html
	ossUrl.setText("http://"+serverPanel_txtUSN.getText()+".corp.amdocs.com:"+SfoPanel_txtPort.getText()+"/AmdocsOSS/Portal/login.html");
	ossUrl.setBounds(300, 240, 350, ossLabel_size.height);
	ossUrl.setOpaque(false);
	Font urlFont1=new Font("Serif",Font.ITALIC,14);
	ossUrl.setFont(urlFont1);
	ossUrl.setForeground(Color.BLUE);
	sfoPostPanel.add(ossUrl);
	
	//Label For Console Username
	JLabel ossUserName=new JLabel("UserName :");
	Dimension ossUserName_size=ossUserName.getPreferredSize();
	ossUserName.setBounds(150, 270, ossUserName_size.width, ossUserName_size.height);
	ossUserName.setOpaque(false);
	sfoPostPanel.add(ossUserName);
	
	JLabel ossName=new JLabel();
	ossName.setText("AFFSuper");
	ossName.setBounds(300, 270, 350, ossUserName_size.height);
	ossName.setOpaque(false);
	/*Font UserName=new Font("Serif",Font.ITALIC,14);
	ossName.setFont(UserName);*/
	ossName.setForeground(Color.BLUE);
	sfoPostPanel.add(ossName);
	
	//Label for Password
	JLabel ossPassword=new JLabel("Password :");
	Dimension ossPassword_size=ossPassword.getPreferredSize();
	ossPassword.setBounds(150, 300, ossPassword_size.width, ossPassword_size.height);
	ossPassword.setOpaque(false);
	sfoPostPanel.add(ossPassword);
	
	JLabel ossPass=new JLabel();
	ossPass.setText("AFFSuper123");
	ossPass.setBounds(300, 300, 350, ossPassword_size.height);
	ossPass.setOpaque(false);
	/*Font UserPass=new Font("Serif",Font.ITALIC,14);
	ossPass.setFont(UserPass);*/
	ossPass.setForeground(Color.BLUE);
	sfoPostPanel.add(ossPass);
	
	//Button for Final And Exit installation
	JButton sfoPostPanel_btnServerStart = new JButton("Start the Server");
	Dimension sfoPostPanel_btnServerStart_size = sfoPostPanel_btnServerStart.getPreferredSize();
	sfoPostPanel_btnServerStart.setBounds(800 - 2 * sfoPostPanel_btnServerStart_size.width,
			550 - sfoPostPanel_btnServerStart_size.height, sfoPostPanel_btnServerStart_size.width,
			sfoPostPanel_btnServerStart_size.height);
	sfoPostPanel.add(sfoPostPanel_btnServerStart);
	
	//ActionListiner For Cancle
	sfoPostPanel_btnServerStart.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String command="./JEE/affDomain_testodo1/scripts/startaffServer_testodo1.sh";
			//String command="./JEE/affDomain_"+serverPanel_txtUSU.getText()+"/scripts/startaffServer_"+serverPanel_txtUSU.getText()+".sh";
			if(Server_Command(command)==true){
				JOptionPane.showMessageDialog(sfoPostPanel_btnServerStart, "Server is Started.");
			}else{
				JOptionPane.showMessageDialog(sfoPostPanel_btnServerStart, "Re install problem in Installation");
			}
		}
	});

	// button for Install
	JButton sfoPostPanel_btnDone = new JButton("Done");
	Dimension sfoPostPanel_btnDone_size = sfoPostPanel_btnDone.getPreferredSize();
	sfoPostPanel_btnDone.setBounds(800 - sfoPostPanel_btnDone_size.width, 550 - sfoPostPanel_btnDone_size.height,
			sfoPostPanel_btnDone_size.width, sfoPostPanel_btnDone_size.height);
	sfoPostPanel.add(sfoPostPanel_btnDone);
	
	sfoPostPanel_btnDone.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	});
}//End of addSfoPost


public void addUsmPost(){
	UsmPanel.setVisible(false);
	JPanel usmPostPanel = new JPanel();
	usmPostPanel.setBounds(0, 0, 900, 650);
	usmPostPanel.setLayout(null);
	//UsmPanel.setBackground(Color.lightGray);
	usmPostPanel.setOpaque(false);
	jfrm.add(usmPostPanel);
	
	//Label for connection string
	JLabel wlLabel=new JLabel("Weblogic Console url:");
	Dimension wlLabel_size=wlLabel.getPreferredSize();
	wlLabel.setBounds(150, 150, wlLabel_size.width, wlLabel_size.height);
	wlLabel.setOpaque(false);
	usmPostPanel.add(wlLabel);
	
	JLabel wlUrl=new JLabel();
	wlUrl.setText("http://"+serverPanel_txtUSN.getText()+":"+SfoPanel_txtPort.getText()+"/console");
	wlUrl.setBounds(300, 150, 350, wlLabel_size.height);
	wlUrl.setOpaque(false);
	Font urlFont=new Font("Serif",Font.ITALIC,14);
	wlUrl.setFont(urlFont);
	wlUrl.setForeground(Color.BLUE);
	usmPostPanel.add(wlUrl);
	
	//Label For Console Username
	JLabel wlUserName=new JLabel("Weblogic UserName :");
	Dimension wlUserName_size=wlUserName.getPreferredSize();
	wlUserName.setBounds(150, 180, wlUserName_size.width, wlUserName_size.height);
	wlUserName.setOpaque(false);
	usmPostPanel.add(wlUserName);
	
	JLabel wlName=new JLabel();
	wlName.setText("weblogic");
	wlName.setBounds(300, 180, 350, wlUserName_size.height);
	wlName.setOpaque(false);
	/*Font UserName=new Font("Serif",Font.ITALIC,14);
	wlName.setFont(UserName);*/
	wlName.setForeground(Color.BLUE);
	usmPostPanel.add(wlName);
	
	//Label for Password
	JLabel wlPassword=new JLabel("Weblogic Password :");
	Dimension wlPassword_size=wlPassword.getPreferredSize();
	wlPassword.setBounds(150, 210, wlPassword_size.width, wlPassword_size.height);
	wlPassword.setOpaque(false);
	usmPostPanel.add(wlPassword);
	
	JLabel wlPass=new JLabel();
	wlPass.setText("weblogic123");
	wlPass.setBounds(300, 210, 350, wlPassword_size.height);
	wlPass.setOpaque(false);
	/*Font UserPass=new Font("Serif",Font.ITALIC,14);
	wlPass.setFont(UserPass);*/
	wlPass.setForeground(Color.BLUE);
	usmPostPanel.add(wlPass);
	
	
	//Label For AmdocsOSS
	JLabel ossLabel=new JLabel("CRAMEROss Console url:");
	Dimension ossLabel_size=ossLabel.getPreferredSize();
	ossLabel.setBounds(150, 240, ossLabel_size.width, ossLabel_size.height);
	ossLabel.setOpaque(false);
	usmPostPanel.add(ossLabel);
	
	JLabel ossUrl=new JLabel();//http://illin3351.corp.amdocs.com:64001/AmdocsOSS/Portal/login.html
	ossUrl.setText("http://"+serverPanel_txtUSN.getText()+".corp.amdocs.com:"+SfoPanel_txtPort.getText()+"/CRAMEROSS/Portal/login.html");
	ossUrl.setBounds(300, 240, 350, ossLabel_size.height);
	ossUrl.setOpaque(false);
	Font urlFont1=new Font("Serif",Font.ITALIC,14);
	ossUrl.setFont(urlFont1);
	ossUrl.setForeground(Color.BLUE);
	usmPostPanel.add(ossUrl);
	
	//Label For Console Username
	JLabel ossUserName=new JLabel("UserName :");
	Dimension ossUserName_size=ossUserName.getPreferredSize();
	ossUserName.setBounds(150, 270, ossUserName_size.width, ossUserName_size.height);
	ossUserName.setOpaque(false);
	usmPostPanel.add(ossUserName);
	
	JLabel ossName=new JLabel();
	ossName.setText("AFFSuper");
	ossName.setBounds(300, 270, 350, ossUserName_size.height);
	ossName.setOpaque(false);
	/*Font UserName=new Font("Serif",Font.ITALIC,14);
	ossName.setFont(UserName);*/
	ossName.setForeground(Color.BLUE);
	usmPostPanel.add(ossName);
	
	//Label for Password
	JLabel ossPassword=new JLabel("Password :");
	Dimension ossPassword_size=ossPassword.getPreferredSize();
	ossPassword.setBounds(150, 300, ossPassword_size.width, ossPassword_size.height);
	ossPassword.setOpaque(false);
	usmPostPanel.add(ossPassword);
	
	JLabel ossPass=new JLabel();
	ossPass.setText("AFFSuper123");
	ossPass.setBounds(300, 300, 350, ossPassword_size.height);
	ossPass.setOpaque(false);
	/*Font UserPass=new Font("Serif",Font.ITALIC,14);
	ossPass.setFont(UserPass);*/
	ossPass.setForeground(Color.BLUE);
	usmPostPanel.add(ossPass);
	
	//Button for Final And Exit installation
	JButton usmPostPanel_btnServerStart = new JButton("Start the Server");
	Dimension usmPostPanel_btnServerStart_size = usmPostPanel_btnServerStart.getPreferredSize();
	usmPostPanel_btnServerStart.setBounds(800 - 2 * usmPostPanel_btnServerStart_size.width,
			550 - usmPostPanel_btnServerStart_size.height, usmPostPanel_btnServerStart_size.width,
			usmPostPanel_btnServerStart_size.height);
	usmPostPanel.add(usmPostPanel_btnServerStart);
	
	//ActionListiner For Cancle
	usmPostPanel_btnServerStart.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String command="./JEE/affDomain_testodo1/scripts/startaffServer_testodo1.sh";
			//String command="./JEE/affDomain_"+serverPanel_txtUSU.getText()+"/scripts/startaffServer_"+serverPanel_txtUSU.getText()+".sh";
			if(Server_Command(command)==true){
				JOptionPane.showMessageDialog(usmPostPanel_btnServerStart, "Server is Started.");
			}else{
				JOptionPane.showMessageDialog(usmPostPanel_btnServerStart, "Re install problem in Installation");
			}
		}
	});

	// button for Install
	JButton sfoPostPanel_btnDone = new JButton("Done");
	Dimension sfoPostPanel_btnDone_size = sfoPostPanel_btnDone.getPreferredSize();
	sfoPostPanel_btnDone.setBounds(800 - sfoPostPanel_btnDone_size.width, 550 - sfoPostPanel_btnDone_size.height,
			sfoPostPanel_btnDone_size.width, sfoPostPanel_btnDone_size.height);
	usmPostPanel.add(sfoPostPanel_btnDone);
	
	sfoPostPanel_btnDone.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	});
}


}//End of class


