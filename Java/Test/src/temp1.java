import java.io.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class temp1 implements Runnable
{
    JTextArea displayPane;
    BufferedReader reader;

    private temp1(JTextArea displayPane, PipedOutputStream pos)
    {
        this.displayPane = displayPane;

        try
        {
            PipedInputStream pis = new PipedInputStream( pos );
            reader = new BufferedReader( new InputStreamReader(pis) );
        }
        catch(IOException e) {}
    }

    public void run()
    {
        String line = null;

        try
        {
            while ((line = reader.readLine()) != null)
            {
//              displayPane.replaceSelection( line + "\n" );
                displayPane.append( line + "\n" );
                displayPane.setCaretPosition( displayPane.getDocument().getLength() );
            }

            System.err.println("I'm here");
        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(null,
                "Error redirecting output : "+ioe.getMessage());
        }
    }

    public static void redirectOutput(JTextArea displayPane)
    {
        temp1.redirectOut(displayPane);
        temp1.redirectErr(displayPane);
    }

    public static void redirectOut(JTextArea displayPane)
    {
        PipedOutputStream pos = new PipedOutputStream();
        System.setOut( new PrintStream(pos, true) );

        temp1 console = new temp1(displayPane, pos);
        new Thread(console).start();
    }

    public static void redirectErr(JTextArea displayPane)
    {
        PipedOutputStream pos = new PipedOutputStream();
        System.setErr( new PrintStream(pos, true) );

        temp1 console = new temp1(displayPane, pos);
        new Thread(console).start();
    }

    public static void main(String[] args)
    {
    	
    	JFrame jfrm = new JFrame("SFO Installation");
		jfrm.setLayout(null);
		jfrm.setSize(900, 650);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setLocationRelativeTo(null);// To open the frame at the center
		//jfrm.setBackground(Color.red);
		jfrm.getContentPane().setBackground(Color.LIGHT_GRAY);
		jfrm.setResizable(false);
		jfrm.setVisible(true);
		
		JPanel Server_Panel=new JPanel();
		Server_Panel.setBounds(150,150,600,400);
		//Server_Panel.setLayout(new BoxLayout(Server_Panel, BoxLayout.Y_AXIS));
		Server_Panel.setLayout(null);
		Server_Panel.setOpaque(false);
		Server_Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Server Connection"));
		jfrm.add(Server_Panel);
		JTextArea textArea=new JTextArea();
		textArea.setOpaque(false);
		JScrollPane scrollPane=new JScrollPane(textArea);
		Server_Panel.add(scrollPane);
		scrollPane.setOpaque(false);
		scrollPane.setBounds(10, 20, 500, 300);
		
       /* JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane( textArea );

        JFrame frame = new JFrame("Redirect Output");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( scrollPane );
        frame.setSize(200, 100);
        frame.setVisible(true);*/
		JButton btnCancle = new JButton("Cancle");
		Dimension btnCancle_size = btnCancle.getPreferredSize();
		btnCancle.setBounds(800 - 2 *btnCancle_size.width,
				600 - btnCancle_size.height, btnCancle_size.width,btnCancle_size.height);
		jfrm.add(btnCancle);

        temp1.redirectOutput( textArea );
        final int i = 0;

        Timer timer = new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	
            	String str="";
            	int i=0;
            	while(i<3000){
            		str="aaaa";
            		System.out.println(str);
            		i++;
            	}
            	System.out.println( new java.util.Date().toString() );
                System.err.println( System.currentTimeMillis() );
            }
        });
        timer.start();
        
        btnCancle.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		System.exit(0);
        	}
        });
    }
}