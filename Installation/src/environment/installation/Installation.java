package environment.installation;


import javax.swing.*;

public class Installation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new GUI();
			}
		});
	}

}

