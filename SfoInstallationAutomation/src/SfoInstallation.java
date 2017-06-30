import SFO.GUI.*;

import javax.swing.*;

class SfoInstallation{	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Default_GUI();
			}
		});
	}
}
