package SFO.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Default_GUI implements ActionListener {
	BackEnd backEnd = new BackEnd();
	
	//List of Panel
	JFrame jfrm = new JFrame("SFO Installation");
	JPanel Server_Panel=new JPanel();
	JPanel DbaConnection_Panel=new JPanel();
	
	JTextField Server_Panel_txtUSN = new JTextField(10);
	JTextField Server_Panel_txtUSU = new JTextField(10);
	JPasswordField Server_Panel_txtUSP = new JPasswordField(10);
	JTextField DbaConnection_Panel_txtSDU = new JTextField(10);
	JPasswordField DbaConnection_Panel_txtSDP = new JPasswordField(10);
	JTextField DbaUser_Panel_txtDef = new JTextField(10);
	JTextField DbaUser_Panel_txttemp = new JTextField(10);
	JTextField DbaUser_Panel_txtPort = new JTextField(10);
	JTextField DbaConnection_Panel_txtSID = new JTextField(10);
	

	public Default_GUI() {
		jfrm.setLayout(null);
		jfrm.setSize(900, 650);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setLocationRelativeTo(null);// To open the frame at the center
		jfrm.setResizable(false);
		jfrm.getContentPane().setBackground(Color.LIGHT_GRAY);
		jfrm.setVisible(true);
		//AddMenu();
		Add_Connection_Panel();// Activating default connection Panel
	}

	// Adding the MenuBar and Items
	void AddMenu()


	{
		JMenuBar jmbar = new JMenuBar();
		jfrm.setJMenuBar(jmbar);// Adding the menu bar to frame

		JMenu Menu_Connection = new JMenu("Connection");
		jmbar.add(Menu_Connection);

		JMenu Menu_EnvClear = new JMenu("Clear");
		jmbar.add(Menu_EnvClear);

		JMenu Menu_Install = new JMenu("Install");
		jmbar.add(Menu_Install);

		JMenu Menu_Validate = new JMenu("Validate");
		jmbar.add(Menu_Validate);

		JMenu Menu_Help = new JMenu("Help");
		jmbar.add(Menu_Help);
	}// End of AddMenu
	
	
void Add_Server_Panel(){
	Server_Panel.setBounds(150,100,400,150);
	Server_Panel.setLayout(null);
	Server_Panel.setOpaque(false);
	Server_Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Server Connection"));
	jfrm.add(Server_Panel);

	

	// *************************************Server
	// Components*************************************************
	// Unix server Creadential
	// label for Unix Server Name
	JLabel Server_Panel_lblUSN = new JLabel("Unix Server Name");
	Dimension Server_Panel_lblUSN_size = Server_Panel_lblUSN.getPreferredSize();
	Server_Panel_lblUSN.setBounds(10, 20, Server_Panel_lblUSN_size.width,
			Server_Panel_lblUSN_size.height);
	Server_Panel.add(Server_Panel_lblUSN);

	// TextField for Unix Server Name
	//JTextField Server_Panel_txtUSN = new JTextField(10);
	Server_Panel_txtUSN.setBounds(210, 20, 150, Server_Panel_lblUSN_size.height);
	Server_Panel.add(Server_Panel_txtUSN);

	// label for Unix Server USER ID
	JLabel Server_Panel_lblUSU = new JLabel("Unix Server UserId");
	Dimension Server_Panel_lblUSU_size = Server_Panel_lblUSU.getPreferredSize();
	Server_Panel_lblUSU.setBounds(10, 50, Server_Panel_lblUSU_size.width,
			Server_Panel_lblUSU_size.height);
	Server_Panel.add(Server_Panel_lblUSU);

	// TextField for Unix Server USER ID
	//JTextField Server_Panel_txtUSU = new JTextField(10);
	Server_Panel_txtUSU.setBounds(210, 50, 150, Server_Panel_lblUSU_size.height);
	Server_Panel.add(Server_Panel_txtUSU);

	// label for Unix Server Password
	JLabel Server_Panel_lblUSP = new JLabel("Unix Server Passowrd");
	Dimension Server_Panel_lblUSP_size = Server_Panel_lblUSP.getPreferredSize();
	Server_Panel_lblUSP.setBounds(10, 80, Server_Panel_lblUSP_size.width,
			Server_Panel_lblUSP_size.height);
	Server_Panel.add(Server_Panel_lblUSP);

	// TextField for Unix Server Password
	//JPasswordField Server_Panel_txtUSP = new JPasswordField(10);
	Server_Panel_txtUSP.setBounds(210, 80, 150, Server_Panel_lblUSP_size.height);
	Server_Panel.add(Server_Panel_txtUSP);

	// button for Unix Server Connection Check
	JButton Server_Panel_btnUSC = new JButton("Test Connection");
	Dimension Server_Panel_btnUSC_size = Server_Panel_btnUSC.getPreferredSize();
	Server_Panel_btnUSC.setBounds(10, 110, Server_Panel_btnUSC_size.width,
			Server_Panel_btnUSC_size.height);
	Server_Panel.add(Server_Panel_btnUSC);

	// Label for Unix Server Connection Status
	JLabel Server_Panel_lblUSC = new JLabel("Connection Status");
	Dimension Server_Panel_lblUSC_size = Server_Panel_lblUSC.getPreferredSize();
	Server_Panel_lblUSC.setBounds(210, 110, Server_Panel_lblUSC_size.width + 50,
			Server_Panel_lblUSC_size.height);
	Server_Panel.add(Server_Panel_lblUSC);

	Server_Panel_btnUSC.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String host = Server_Panel_txtUSN.getText();
			String user = Server_Panel_txtUSU.getText();
			// @SuppressWarnings("deprecation")
			String password = Server_Panel_txtUSP.getText();

			if (backEnd.Test_Server_Connection(host, user, password) == true) {
				Server_Panel_lblUSC.setText("Connection Successed.");
			} else {
				Server_Panel_lblUSC.setText("Connection Error.");
			}

		}
	});
}
	

void Add_DbaConnection_Panel(){

	
	DbaConnection_Panel.setBounds(150,260,400,150);
	DbaConnection_Panel.setLayout(null);
	DbaConnection_Panel.setOpaque(false);
	DbaConnection_Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Database Connection"));
	jfrm.add(DbaConnection_Panel);
	
	// Sql database Creadential
	// label for Sql Database USER ID
	JLabel DbaConnection_Panel_lblSDU = new JLabel("Sql Database UserId");
	Dimension DbaConnection_Panel_lblSDU_size = DbaConnection_Panel_lblSDU.getPreferredSize();
	DbaConnection_Panel_lblSDU.setBounds(10, 20, DbaConnection_Panel_lblSDU_size.width,
			DbaConnection_Panel_lblSDU_size.height);
	DbaConnection_Panel.add(DbaConnection_Panel_lblSDU);

	// TextField for Sql Database USER ID
	//JTextField DbaConnection_Panel_txtSDU = new JTextField(10);
	DbaConnection_Panel_txtSDU.setBounds(210, 20, 150, DbaConnection_Panel_lblSDU_size.height);
	DbaConnection_Panel.add(DbaConnection_Panel_txtSDU);

	// label for Sql Database Password
	JLabel DbaConnection_Panel_lblSDP = new JLabel("Sql Database Passowrd");
	Dimension DbaConnection_Panel_lblSDP_size = DbaConnection_Panel_lblSDP.getPreferredSize();
	DbaConnection_Panel_lblSDP.setBounds(10, 50, DbaConnection_Panel_lblSDP_size.width,
			DbaConnection_Panel_lblSDP_size.height);
	DbaConnection_Panel.add(DbaConnection_Panel_lblSDP);

	// TextField for Sql Database Password
	//JPasswordField DbaConnection_Panel_txtSDP = new JPasswordField(10);
	DbaConnection_Panel_txtSDP.setBounds(210, 50, 150, DbaConnection_Panel_lblSDP_size.height);
	DbaConnection_Panel.add(DbaConnection_Panel_txtSDP);
	
	//Label for Sql Database sid
	JLabel DbaConnection_Panel_lblSID = new JLabel("Sql Database SID");
	Dimension DbaConnection_Panel_lblSID_size = DbaConnection_Panel_lblSDP.getPreferredSize();
	DbaConnection_Panel_lblSID.setBounds(10, 80, DbaConnection_Panel_lblSID_size.width,
			DbaConnection_Panel_lblSID_size.height);
	DbaConnection_Panel.add(DbaConnection_Panel_lblSID);

	// TextField for Sql Database SID
	//JTextField DbaConnection_Panel_txtSID = new JTextField(10);
	DbaConnection_Panel_txtSID.setBounds(210, 80, 150, DbaConnection_Panel_lblSDP_size.height);
	DbaConnection_Panel.add(DbaConnection_Panel_txtSID);

	// button for Sql Database Connection Check
	JButton DbaConnection_Panel_btnSDC = new JButton("Test Connection");
	Dimension DbaConnection_Panel_btnSDC_size = DbaConnection_Panel_btnSDC.getPreferredSize();
	DbaConnection_Panel_btnSDC.setBounds(10, 110, DbaConnection_Panel_btnSDC_size.width,
			DbaConnection_Panel_btnSDC_size.height);
	DbaConnection_Panel.add(DbaConnection_Panel_btnSDC);

	// Label for Sql Database Connection Status
	JLabel DbaConnection_Panel_lblSDC = new JLabel("Connection Status");
	Dimension DbaConnection_Panel_lblSDC_size = DbaConnection_Panel_lblSDC.getPreferredSize();
	DbaConnection_Panel_lblSDC.setBounds(210, 110, DbaConnection_Panel_lblSDC_size.width + 40,
			DbaConnection_Panel_lblSDC_size.height);
	DbaConnection_Panel.add(DbaConnection_Panel_lblSDC);

	DbaConnection_Panel_btnSDC.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String user = DbaConnection_Panel_txtSDU.getText();
			String password = DbaConnection_Panel_txtSDP.getText();
			String SID=DbaConnection_Panel_txtSID.getText();

			if (backEnd.Test_Db_Connection(user, password,SID,"OracleConn.txt") == true) {
				DbaConnection_Panel_lblSDC.setText("Connection Successed.");
			} else {
				DbaConnection_Panel_lblSDC.setText("Connection Error");
			}
		}
	});

}



	void Add_Connection_Panel() {
		Add_Server_Panel();
		Add_DbaConnection_Panel();
		JPanel Connection_Panel = new JPanel();
		Connection_Panel.setBounds(0, 420, 900, 140);
		Connection_Panel.setLayout(null);
		//Connection_Panel.setBackground(Color.LIGHT_GRAY);
		Connection_Panel.setOpaque(false);
		jfrm.add(Connection_Panel);
		/*JLabel Connection_Panel_Header = new JLabel("Check your connection");
		Dimension Connection_Panel_Header_size = Connection_Panel_Header.getPreferredSize();
		Connection_Panel_Header.setBounds(350, 500, Connection_Panel_Header_size.width,
				Connection_Panel_Header_size.height);
		Connection_Panel.add(Connection_Panel_Header);*/
		
		// button for Clear the previous environment
		JButton Connection_Panel_btnCE = new JButton("Clear previous Installation");
		Dimension Connection_Panel_btnCE_size = Connection_Panel_btnCE.getPreferredSize();
		Connection_Panel_btnCE.setBounds(150, 10, Connection_Panel_btnCE_size.width,
				Connection_Panel_btnCE_size.height);
		Connection_Panel.add(Connection_Panel_btnCE);

		// Label for clear the previous environment Status
		JLabel Connection_Panel_lblCE = new JLabel("Status");
		Dimension Connection_Panel_lblCE_size = Connection_Panel_lblCE.getPreferredSize();
		Connection_Panel_lblCE.setBounds(350, 10, Connection_Panel_lblCE_size.width + 50,
				Connection_Panel_lblCE_size.height);
		Connection_Panel.add(Connection_Panel_lblCE);

		// Action when clear previous Installation button clicked
		Connection_Panel_btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backEnd.Server_Command("export DISPLAY=localhost:10.0");
				String command="rm -rf .xpi/ .asp/ .cmd/ storage/ .install/ software/ JEE/ .StorageMetadata/ .rollback/ .com.zerog.registry.xml";
				if(backEnd.Server_Command(command)==true){
					Connection_Panel_lblCE.setText("Uninstalled");
				}else{
					Connection_Panel_lblCE.setText("Error");
				}
			}
		});

		// button for Cancle
		JButton Connection_Panel_btnCancle = new JButton("Cancle");
		Dimension Connection_Panel_btnCancle_size = Connection_Panel_btnCancle.getPreferredSize();
		Connection_Panel_btnCancle.setBounds(800 - 2 * Connection_Panel_btnCancle_size.width,
				140 - Connection_Panel_btnCancle_size.height, Connection_Panel_btnCancle_size.width,
				Connection_Panel_btnCancle_size.height);
		Connection_Panel.add(Connection_Panel_btnCancle);

		// button for Next
		JButton Connection_Panel_btnNext = new JButton("Next");
		Dimension Connection_Panel_btnNext_size = Connection_Panel_btnNext.getPreferredSize();
		Connection_Panel_btnNext.setBounds(800 - Connection_Panel_btnNext_size.width,
				140 - Connection_Panel_btnNext_size.height, Connection_Panel_btnNext_size.width,
				Connection_Panel_btnNext_size.height);
		Connection_Panel.add(Connection_Panel_btnNext);

		// ActionListiner for button Next
		Connection_Panel_btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection_Panel.setVisible(false);
				Server_Panel.setVisible(false);
				DbaConnection_Panel.setVisible(false);
				Add_DbaUser_Panel();
			}
		});

	}// End of Add_Connection_Panel method

	
	
	// GUI for the Creation of the Datbase users and Installation
	void Add_DbaUser_Panel() {
		JPanel DbaUser_Panel = new JPanel();
		DbaUser_Panel.setBounds(0, 0, 900, 650);
		DbaUser_Panel.setLayout(null);
		//DbaUser_Panel.setBackground(Color.lightGray);
		DbaUser_Panel.setOpaque(false);

		System.out.println(DbaUser_Panel.getSize());
		jfrm.add(DbaUser_Panel);

		JLabel DbaUser_Panel_Header = new JLabel("Database user Creation");
		Dimension DbaUser_Panel_Header_size = DbaUser_Panel_Header.getPreferredSize();
		DbaUser_Panel_Header.setBounds(350, 450, DbaUser_Panel_Header_size.width, DbaUser_Panel_Header_size.height);
		DbaUser_Panel.add(DbaUser_Panel_Header);

		// *************************************************************************************
		//Label for Port Number for Installation
		JLabel DbaUser_Panel_lblPort = new JLabel("SFO Installation Port");
		Dimension DbaUser_Panel_lblPort_size = DbaUser_Panel_lblPort.getPreferredSize();
		DbaUser_Panel_lblPort.setBounds(150, 120, DbaUser_Panel_lblPort_size.width, DbaUser_Panel_lblPort_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblPort);

		// TextField for Unix Server Name
		//JTextField DbaUser_Panel_txtPort = new JTextField(10);
		DbaUser_Panel_txtPort.setBounds(350, 120, 150, DbaUser_Panel_lblPort_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txtPort);
		
		
		// Label for Default Tablespace Input
		JLabel DbaUser_Panel_lblDef = new JLabel("Default Tablespace");
		Dimension DbaUser_Panel_lblDef_size = DbaUser_Panel_lblDef.getPreferredSize();
		DbaUser_Panel_lblDef.setBounds(150, 150, DbaUser_Panel_lblDef_size.width, DbaUser_Panel_lblDef_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblDef);

		// TextField for Unix Server Name
		//JTextField DbaUser_Panel_txtDef = new JTextField(10);
		DbaUser_Panel_txtDef.setBounds(350, 150, 150, DbaUser_Panel_lblDef_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txtDef);

		// Label for Temporary tablespace input
		JLabel DbaUser_Panel_lbltemp = new JLabel("Temporary Tablespace");
		Dimension DbaUser_Panel_lbltemp_size = DbaUser_Panel_lbltemp.getPreferredSize();
		DbaUser_Panel_lbltemp.setBounds(150, 180, DbaUser_Panel_lbltemp_size.width, DbaUser_Panel_lbltemp_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lbltemp);

		// TextField for Unix Server Name
		//JTextField DbaUser_Panel_txttemp = new JTextField(10);
		DbaUser_Panel_txttemp.setBounds(350, 180, 150, DbaUser_Panel_lbltemp_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txttemp);
		// *************************************************************************************

		JLabel DbaUser_Panel_lblUSER = new JLabel("Create database Users");
		Dimension DbaUser_Panel_lblUSER_size = DbaUser_Panel_lblUSER.getPreferredSize();
		DbaUser_Panel_lblUSER.setBounds(150, 210, DbaUser_Panel_lblUSER_size.width, DbaUser_Panel_lblUSER_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblUSER);

		JLabel DbaUser_Panel_lblUSERN = new JLabel("User Name");
		Dimension DbaUser_Panel_lblUSERN_size = DbaUser_Panel_lblUSERN.getPreferredSize();
		DbaUser_Panel_lblUSERN.setBounds(350, 210, DbaUser_Panel_lblUSERN_size.width,
				DbaUser_Panel_lblUSERN_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblUSERN);

		JLabel DbaUser_Panel_lblUSERP = new JLabel("Password");
		Dimension DbaUser_Panel_lblUSERP_size = DbaUser_Panel_lblUSERP.getPreferredSize();
		DbaUser_Panel_lblUSERP.setBounds(550, 210, DbaUser_Panel_lblUSERP_size.width,
				DbaUser_Panel_lblUSERP_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblUSERP);

		// ******************************************************************************************
		// label for Unix Server Password
		JLabel DbaUser_Panel_lblUAMS = new JLabel("Create User UAMS");
		Dimension DbaUser_Panel_lblUAMS_size = DbaUser_Panel_lblUAMS.getPreferredSize();
		DbaUser_Panel_lblUAMS.setBounds(150, 240, DbaUser_Panel_lblUAMS_size.width, DbaUser_Panel_lblUAMS_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblUAMS);

		// TextField for Unix Server Name
		JTextField DbaUser_Panel_txtUAMS = new JTextField(10);
		DbaUser_Panel_txtUAMS.setBounds(350, 240, 150, DbaUser_Panel_lblUAMS_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txtUAMS);

		// TextField for Unix Server Password
		JPasswordField DbaUser_Panel_txtpUAMS = new JPasswordField(10);
		DbaUser_Panel_txtpUAMS.setBounds(550, 240, 150, DbaUser_Panel_lblUAMS_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txtpUAMS);

		// Label for Unix Server DbaUser Status
		JLabel DbaUser_Panel_lblUAMS_1 = new JLabel("Status");
		Dimension DbaUser_Panel_lblUAMS_1_size = DbaUser_Panel_lblUAMS_1.getPreferredSize();
		DbaUser_Panel_lblUAMS_1.setBounds(700, 240, 3*DbaUser_Panel_lblUAMS_1_size.width,
				DbaUser_Panel_lblUAMS_1_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblUAMS_1);
		// ******************************************************************************************

		// ******************************************************************************************
		// label for AFFUSER
		JLabel DbaUser_Panel_lblAFFUSER = new JLabel("Create User AFFUSER");
		Dimension DbaUser_Panel_lblAFFUSER_size = DbaUser_Panel_lblAFFUSER.getPreferredSize();
		DbaUser_Panel_lblAFFUSER.setBounds(150, 270, DbaUser_Panel_lblAFFUSER_size.width,
				DbaUser_Panel_lblAFFUSER_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblAFFUSER);
		
		

		// TextField for Unix Server Name
		JTextField DbaUser_Panel_txteAFFUSER = new JTextField(10);
		DbaUser_Panel_txteAFFUSER.setBounds(350, 270, 150, DbaUser_Panel_lblAFFUSER_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txteAFFUSER);

		// TextField for AFFUSER Password
		JPasswordField DbaUser_Panel_txtAFFUSER = new JPasswordField(10);
		DbaUser_Panel_txtAFFUSER.setBounds(550, 270, 150, DbaUser_Panel_lblAFFUSER_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txtAFFUSER);

		// Label for Unix Server DbaUser Status
		JLabel DbaUser_Panel_lblAFFUSER_1 = new JLabel("Status");
		Dimension DbaUser_Panel_lblAFFUSER_1_size = DbaUser_Panel_lblAFFUSER_1.getPreferredSize();
		DbaUser_Panel_lblAFFUSER_1.setBounds(700, 270, 3*DbaUser_Panel_lblAFFUSER_1_size.width,
				DbaUser_Panel_lblAFFUSER_1_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblAFFUSER_1);
		// ******************************************************************************************

		// ******************************************************************************************
		// label for REFUSER
		JLabel DbaUser_Panel_lblREFUSER = new JLabel("Create User REFUSER");
		Dimension DbaUser_Panel_lblREFUSER_size = DbaUser_Panel_lblREFUSER.getPreferredSize();
		DbaUser_Panel_lblREFUSER.setBounds(150, 300, DbaUser_Panel_lblREFUSER_size.width,
				DbaUser_Panel_lblREFUSER_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblREFUSER);

		// TextField for Unix Server Name
		JTextField DbaUser_Panel_txteREFUSER = new JTextField(10);
		DbaUser_Panel_txteREFUSER.setBounds(350, 300, 150, DbaUser_Panel_lblREFUSER_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txteREFUSER);

		// TextField for REFUSER Password
		JPasswordField DbaUser_Panel_txtREFUSER = new JPasswordField(10);
		DbaUser_Panel_txtREFUSER.setBounds(550, 300, 150, DbaUser_Panel_lblREFUSER_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txtREFUSER);

		// Label for Unix Server DbaUser Status
		JLabel DbaUser_Panel_lblREFUSER_1 = new JLabel("Status");
		Dimension DbaUser_Panel_lblREFUSER_1_size = DbaUser_Panel_lblREFUSER_1.getPreferredSize();
		DbaUser_Panel_lblREFUSER_1.setBounds(700, 300, 3*DbaUser_Panel_lblREFUSER_1_size.width,
				DbaUser_Panel_lblREFUSER_1_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblREFUSER_1);
		// ******************************************************************************************

		// ***********************************************************************************************
		// Lebel for ALTREFUSER
		JLabel DbaUser_Panel_lblALTREFUSER = new JLabel("Create User ALTREFUSER");
		Dimension DbaUser_Panel_lblALTREFUSER_size = DbaUser_Panel_lblALTREFUSER.getPreferredSize();
		DbaUser_Panel_lblALTREFUSER.setBounds(150, 330, DbaUser_Panel_lblALTREFUSER_size.width,
				DbaUser_Panel_lblALTREFUSER_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblALTREFUSER);


		// TextField for Unix Server Name
		JTextField DbaUser_Panel_txteALTREFUSER = new JTextField(10);
		DbaUser_Panel_txteALTREFUSER.setBounds(350, 330, 150, DbaUser_Panel_lblALTREFUSER_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txteALTREFUSER);

		// TextField for ALTREFUSER Password
		JPasswordField DbaUser_Panel_txtALTREFUSER = new JPasswordField(10);
		DbaUser_Panel_txtALTREFUSER.setBounds(550, 330, 150, DbaUser_Panel_lblALTREFUSER_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txtALTREFUSER);

		// Label for Unix Server DbaUser Status
		JLabel DbaUser_Panel_lblALTREFUSER_1 = new JLabel("Status");
		Dimension DbaUser_Panel_lblALTREFUSER_1_size = DbaUser_Panel_lblALTREFUSER_1.getPreferredSize();
		DbaUser_Panel_lblALTREFUSER_1.setBounds(700, 330, 3*DbaUser_Panel_lblALTREFUSER_1_size.width,
				DbaUser_Panel_lblALTREFUSER_1_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblALTREFUSER_1);
		// ******************************************************************************************

		// ******************************************************************************************
		// Lebel for OSSUI
		JLabel DbaUser_Panel_lblOSSUI = new JLabel("Create User OSSUI");
		Dimension DbaUser_Panel_lblOSSUI_size = DbaUser_Panel_lblOSSUI.getPreferredSize();
		DbaUser_Panel_lblOSSUI.setBounds(150, 360, DbaUser_Panel_lblOSSUI_size.width,
				DbaUser_Panel_lblOSSUI_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblOSSUI);


		// TextField for Unix Server Name
		JTextField DbaUser_Panel_txteOSSUI = new JTextField(10);
		DbaUser_Panel_txteOSSUI.setBounds(350, 360, 150, DbaUser_Panel_lblOSSUI_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txteOSSUI);

		// TextField for OSSUI Password
		JPasswordField DbaUser_Panel_txtOSSUI = new JPasswordField(10);
		DbaUser_Panel_txtOSSUI.setBounds(550, 360, 150, DbaUser_Panel_lblOSSUI_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txtOSSUI);

		// Label for Unix Server DbaUser Status
		JLabel DbaUser_Panel_lblOSSUI_1 = new JLabel("Status");
		Dimension DbaUser_Panel_lblOSSUI_1_size = DbaUser_Panel_lblOSSUI_1.getPreferredSize();
		DbaUser_Panel_lblOSSUI_1.setBounds(700, 360, 3*DbaUser_Panel_lblOSSUI_1_size.width,
				DbaUser_Panel_lblOSSUI_1_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblOSSUI_1);
		// ******************************************************************************************

		// ***************************************************************************************************
		// Lebel for OSSUI_CLENT
		JLabel DbaUser_Panel_lblOSSUI_CLIENT = new JLabel("Create User OSSUI_CLIENT");
		Dimension DbaUser_Panel_lblOSSUI_CLIENT_size = DbaUser_Panel_lblOSSUI_CLIENT.getPreferredSize();
		DbaUser_Panel_lblOSSUI_CLIENT.setBounds(150, 390, DbaUser_Panel_lblOSSUI_CLIENT_size.width,
				DbaUser_Panel_lblOSSUI_CLIENT_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblOSSUI_CLIENT);


		// TextField for Unix Server Name
		JTextField DbaUser_Panel_txteOSSUI_CLIENT = new JTextField(10);
		DbaUser_Panel_txteOSSUI_CLIENT.setBounds(350, 390, 150, DbaUser_Panel_lblOSSUI_CLIENT_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txteOSSUI_CLIENT);

		// TextField for OSSUI_CLIENT Password
		JPasswordField DbaUser_Panel_txtOSSUI_CLIENT = new JPasswordField(10);
		DbaUser_Panel_txtOSSUI_CLIENT.setBounds(550, 390, 150, DbaUser_Panel_lblOSSUI_CLIENT_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txtOSSUI_CLIENT);

		// Label for Unix Server DbaUser Status
		JLabel DbaUser_Panel_lblOSSUI_CLIENT_1 = new JLabel("Status");
		Dimension DbaUser_Panel_lblOSSUI_CLIENT_1_size = DbaUser_Panel_lblOSSUI_CLIENT_1.getPreferredSize();
		DbaUser_Panel_lblOSSUI_CLIENT_1.setBounds(700, 390, 3*DbaUser_Panel_lblOSSUI_CLIENT_1_size.width,
				DbaUser_Panel_lblOSSUI_CLIENT_1_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblOSSUI_CLIENT_1);
		// ******************************************************************************************
		
		
		//***************************************************************************************
		//Label for tempsys
		JLabel DbaUser_Panel_lblTEMPSYS = new JLabel("Create User TMPSYS");
		Dimension DbaUser_Panel_lblTEMPSYS_size = DbaUser_Panel_lblTEMPSYS.getPreferredSize();
		DbaUser_Panel_lblTEMPSYS.setBounds(150, 420, DbaUser_Panel_lblTEMPSYS_size.width,
				DbaUser_Panel_lblTEMPSYS_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblTEMPSYS);


		// TextField for Unix Server Name
		JTextField DbaUser_Panel_txteTEMPSYS = new JTextField(10);
		DbaUser_Panel_txteTEMPSYS.setBounds(350, 420, 150, DbaUser_Panel_lblTEMPSYS_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txteTEMPSYS);

		// TextField for TEMPSYS Password
		JPasswordField DbaUser_Panel_txtTEMPSYS = new JPasswordField(10);
		DbaUser_Panel_txtTEMPSYS.setBounds(550, 420, 150, DbaUser_Panel_lblTEMPSYS_size.height);
		DbaUser_Panel.add(DbaUser_Panel_txtTEMPSYS);

		// Label for Unix Server DbaUser Status
		JLabel DbaUser_Panel_lblTEMPSYS_1 = new JLabel("Status");
		Dimension DbaUser_Panel_lblTEMPSYS_1_size = DbaUser_Panel_lblTEMPSYS_1.getPreferredSize();
		DbaUser_Panel_lblTEMPSYS_1.setBounds(700, 420, 3*DbaUser_Panel_lblTEMPSYS_1_size.width,
				DbaUser_Panel_lblTEMPSYS_1_size.height);
		DbaUser_Panel.add(DbaUser_Panel_lblTEMPSYS_1);
		
		//*************************************************************************************************

		// button for Cancle
		JButton DbaUser_Panel_btnCancle = new JButton("Cancle");
		Dimension DbaUser_Panel_btnCancle_size = DbaUser_Panel_btnCancle.getPreferredSize();
		DbaUser_Panel_btnCancle.setBounds(800 - 2 * DbaUser_Panel_btnCancle_size.width,
				600 - DbaUser_Panel_btnCancle_size.height, DbaUser_Panel_btnCancle_size.width,
				DbaUser_Panel_btnCancle_size.height);
		DbaUser_Panel.add(DbaUser_Panel_btnCancle);

		// button for Install
		JButton DbaUser_Panel_btnInstall = new JButton("Install");
		Dimension DbaUser_Panel_btnInstall_size = DbaUser_Panel_btnInstall.getPreferredSize();
		DbaUser_Panel_btnInstall.setBounds(800 - DbaUser_Panel_btnInstall_size.width, 600 - DbaUser_Panel_btnInstall_size.height,
				DbaUser_Panel_btnInstall_size.width, DbaUser_Panel_btnInstall_size.height);
		DbaUser_Panel.add(DbaUser_Panel_btnInstall);

		// ActionListiner for button Install
		DbaUser_Panel_btnInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				// DbaUser_Panel.setVisible(false);
				// Add_EnvClear_Panel();
				DbaUser_Panel_Header.setText("Installing..........");
				DbaUser_Panel_Header.setForeground(Color.red);
				String Profile=null;
				//For UAMS
				Profile="create user "+DbaUser_Panel_txtUAMS.getText()+" identified by "
						+DbaUser_Panel_txtpUAMS.getText()+" default tablespace "+DbaUser_Panel_txtDef.getText()
						+" temporary tablespace "+DbaUser_Panel_txttemp.getText()+" profile default account unlock";
				if(backEnd.Create_User(DbaUser_Panel_txtUAMS.getText(), Profile, "UserUams.txt")==true)
				{
					DbaUser_Panel_lblUAMS_1.setText("User Created.");
				}else{
					DbaUser_Panel_lblUAMS_1.setText("Error");
				}//End for UAMS working
				
				
				//For AFFUSER
				Profile="create user "+DbaUser_Panel_txteAFFUSER.getText()+" identified by "
						+DbaUser_Panel_txtAFFUSER.getText()+" default tablespace "+DbaUser_Panel_txtDef.getText()
						+" temporary tablespace "+DbaUser_Panel_txttemp.getText()+" profile default account unlock";
				if(backEnd.Create_User(DbaUser_Panel_txteAFFUSER.getText(), Profile, "AFFUSER.txt")==true)
				{
					DbaUser_Panel_lblAFFUSER_1.setText("User Created.");
				}else{
					DbaUser_Panel_lblAFFUSER_1.setText("Error");
				}//End for AFFUSER working
				
				
				//FOR REFUSERF
				Profile="create user "+DbaUser_Panel_txteREFUSER.getText()+" identified by "
						+DbaUser_Panel_txtREFUSER.getText()+" default tablespace "+DbaUser_Panel_txtDef.getText()
						+" temporary tablespace "+DbaUser_Panel_txttemp.getText()+" profile default quota unlimited on "+DbaUser_Panel_txtDef.getText();
				if(backEnd.Create_User(DbaUser_Panel_txteREFUSER.getText(), Profile, "REFUSER.txt")==true)
				{
					DbaUser_Panel_lblREFUSER_1.setText("User Created.");
				}else{
					DbaUser_Panel_lblREFUSER_1.setText("Error");
				}//End for REFUSER working
				
				
				//For ALTREFUSER
				Profile="create user "+DbaUser_Panel_txteALTREFUSER.getText()+" identified by "
						+DbaUser_Panel_txtALTREFUSER.getText()+" default tablespace "+DbaUser_Panel_txtDef.getText()
						+" temporary tablespace "+DbaUser_Panel_txttemp.getText()+" profile default quota unlimited on "+DbaUser_Panel_txtDef.getText();
				if(backEnd.Create_User(DbaUser_Panel_txteALTREFUSER.getText(), Profile, "ALTREFUSER.txt")==true)
				{
					DbaUser_Panel_lblALTREFUSER_1.setText("User Created.");
				}else{
					DbaUser_Panel_lblALTREFUSER_1.setText("Error");
				}//End of ALTREFUSER working
				
				
				//For OSSUI
				Profile="create user "+DbaUser_Panel_txteOSSUI.getText()+" identified by "
						+DbaUser_Panel_txtOSSUI.getText()+" default tablespace "+DbaUser_Panel_txtDef.getText()
						+" temporary tablespace "+DbaUser_Panel_txttemp.getText()+" quota unlimited on "+DbaUser_Panel_txtDef.getText();
				if(backEnd.Create_User(DbaUser_Panel_txteOSSUI.getText(), Profile, "OSSUI.txt")==true)
				{
					DbaUser_Panel_lblOSSUI_1.setText("User Created.");
				}else{
					DbaUser_Panel_lblOSSUI_1.setText("Error");
				}//End of OSSUI working
				
				
				
				//For OSSUI_CLIENT
				Profile="create user "+DbaUser_Panel_txteOSSUI_CLIENT.getText()+" identified by "
						+DbaUser_Panel_txtOSSUI_CLIENT.getText()+" default tablespace "+DbaUser_Panel_txtDef.getText()
						+" temporary tablespace "+DbaUser_Panel_txttemp.getText()+" quota unlimited on "+DbaUser_Panel_txtDef.getText();
				if(backEnd.Create_User(DbaUser_Panel_txteOSSUI_CLIENT.getText(), Profile, "OSSUI_CLIENT.txt")==true)
				{
					DbaUser_Panel_lblOSSUI_CLIENT_1.setText("User Created.");
				}else{
					DbaUser_Panel_lblOSSUI_CLIENT_1.setText("Error");
				}//End of OSSUI_CLIENT working
				
				//for TEMPSYS
				Profile="create user "+DbaUser_Panel_txteTEMPSYS.getText()+" identified by "
						+DbaUser_Panel_txtTEMPSYS.getText()+" default tablespace "+DbaUser_Panel_txtDef.getText()
						+" temporary tablespace "+DbaUser_Panel_txttemp.getText()+" quota unlimited on "+DbaUser_Panel_txtDef.getText();
				if(backEnd.Create_User(DbaUser_Panel_txteTEMPSYS.getText(), Profile, "TEMPSYS.txt")==true)
				{
					DbaUser_Panel_lblTEMPSYS_1.setText("User Created.");
				}else{
					DbaUser_Panel_lblTEMPSYS_1.setText("Error");
				}//End of TEMPSYS
				
				
				//Updating the properties file
				Properties prop=new Properties();
				
				try {
					FileInputStream input=new FileInputStream("test.properties");
					prop.load(input);
					input.close();
					FileOutputStream output=new FileOutputStream("test.properties");
					prop.setProperty("AFFProduct/aff.global.uams.client.db.user",DbaUser_Panel_txtUAMS.getText());
					prop.setProperty("AFFProduct/aff.global.uams.client.db.pswd", DbaUser_Panel_txtpUAMS.getText());
					prop.setProperty("AFFProduct/aff.global.uams.client.db.host", Server_Panel_txtUSN.getText());
					prop.setProperty("AFFProduct/aff.global.uams.client.db.instance", Server_Panel_txtUSU.getText());
					prop.setProperty("JEE1/activeos.console.username", "testodo1");
					prop.setProperty("JEE1/activeos.console.password", "testodo1@");
					prop.setProperty("JEE1/weblogic.admin.username","weblogic");
					prop.setProperty("JEE1/weblogic.admin.password","weblogic123");
					prop.setProperty("Storage1/xpi.StoragePath","/ossusers1/oss/users/testodo1");
					prop.setProperty("JEE1/container.domain.name","affDomain_testodo1");
					prop.setProperty("JEE1/container.server.name","affServer_testodo1");
					prop.setProperty("JEE1/container.listen.port",DbaUser_Panel_txtPort.getText());
					prop.setProperty("JEE1/aff.global.oracle.conn.host",Server_Panel_txtUSN.getText()+".corp.amdocs.com");
					prop.setProperty("JEE1/aff.global.oracle.conn.sid",Server_Panel_txtUSU.getText());
					prop.setProperty("JEE1/aff.global.oracle.conn.username",DbaUser_Panel_txteAFFUSER.getText());
					prop.setProperty("JEE1/aff.global.oracle.conn.pswd",DbaUser_Panel_txtAFFUSER.getText());
					prop.setProperty("JEE1/aff.global.oracle.ref.conn.pswd",DbaUser_Panel_txtREFUSER.getText());
					prop.setProperty("JEE1/aff.global.oracle.ref.conn.username",DbaUser_Panel_txteREFUSER.getText());
					prop.setProperty("JEE1/aff.global.oracle.ref.conn.sid",Server_Panel_txtUSU.getText());
					prop.setProperty("JEE1/aff.global.oracle.ref.conn.host",Server_Panel_txtUSN.getText()+".corp.amdocs.com");
					prop.setProperty("JEE1/aff.global.oracle.alt.ref.conn.pswd",DbaUser_Panel_txtALTREFUSER.getText());
					prop.setProperty("JEE1/aff.global.oracle.alt.ref.conn.username",DbaUser_Panel_txteALTREFUSER.getText());
					prop.setProperty("JEE1/aff.global.oracle.alt.ref.conn.sid",Server_Panel_txtUSU.getText());
					prop.setProperty("JEE1/aff.global.oracle.alt.ref.conn.host",Server_Panel_txtUSN.getText()+".corp.amdocs.com");
					prop.setProperty("JEE1/aff.global.oracle.ossui.conn.pswd",DbaUser_Panel_txteOSSUI.getText());
					prop.setProperty("JEE1/aff.global.oracle.ossui.conn.sid",Server_Panel_txtUSU.getText());
					prop.setProperty("JEE1/aff.global.oracle.ossui.conn.username",DbaUser_Panel_txtOSSUI.getText());
					prop.setProperty("JEE1/aff.global.oracle.ossui.conn.host",Server_Panel_txtUSN.getText()+".corp.amdocs.com");
					prop.setProperty("JEE1/db.user.ossui.client",DbaUser_Panel_txteOSSUI_CLIENT.getText());
					prop.setProperty("JEE1/db.password.ossui.client",DbaUser_Panel_txtOSSUI_CLIENT.getText());
					prop.setProperty("JEE1/db.tablespace.ossui",DbaUser_Panel_txtDef.getText());
					
					prop.store(output, null);
					output.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//End of Updating Properties file
				
				//Transfering Properties file to server
				backEnd.Upload_To_Server("test.properties");
				
				
				/*String command="./installer/bin/XPI.sh --mem 4 --install --silent -p /ossusers1/oss/users/testodo1/SFOKit2_impl_10.0.1.0.0_Linux_64_27-01-17_08_07_44.jar -t testodo1.topology -pr /ossusers1/oss/users/testodo1/testodo1_copy1.properties";
				if(backEnd.Server_Command(command)==true){
					DbaUser_Panel_Header.setText("Installed");
				}else{
					DbaUser_Panel_Header.setText("eRROR");
				}*/
				
			}
		});

	}// End of Add_DbaUser_Panel

	
	// @Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("Exits")) {
			System.exit(0);
		}
	}
}
