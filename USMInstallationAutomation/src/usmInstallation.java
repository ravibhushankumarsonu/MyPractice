
import javax.swing.*;

import usm.installation.usmGui;

public class usmInstallation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new usmGui();
			}
		});
	}

}
