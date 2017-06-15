import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuDemo implements ActionListener {
	JLabel jlab;

	MenuDemo() {
		// Create a new JFrame container.
		JFrame jfrm = new JFrame("Menu Demo");
		// Specify FlowLayout for the layout manager.
		jfrm.setLayout(new FlowLayout());
		// Give the frame an initial size.
		jfrm.setSize(400, 400);
		// Terminate the program when the user closes the application.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create a label that will display the menu selection.
		jfrm.setVisible(true);
		JPanel jpnl=new JPanel();
		jfrm.add(jpnl);
		
		jlab = new JLabel("This is Label");
		jpnl.add(jlab);
		jlab.setFont(new Font("Optima",Font.BOLD,30));
		jlab.setForeground(Color.GRAY);
		
	}

	// Handle menu item action events.
	public void actionPerformed(ActionEvent ae) {
		// Get the action command from the menu selection.
		String comStr = ae.getActionCommand();
		// If user chooses Exit, then exit the program.
		if (comStr.equals("Exit"))
			System.exit(0);
		// Otherwise, display the selection.
		jlab.setText(comStr + " Selected");
	}

	public static void main(String args[]) {
		// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MenuDemo();
			}
		});
	}
}