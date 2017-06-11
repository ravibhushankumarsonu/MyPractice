
import java.awt.*;
import java.applet.*;
public class AppletSke extends Applet implements Runnable{
	String msg="A moving Banner ";
	Thread t=null;
	int state;
	volatile boolean stopFlag;
	public void init()
	{
		setBackground(Color.cyan);
		setBackground(Color.pink);
	}
	public void start()
	{
	t=new Thread(this);
	stopFlag=false;
	t.start();
	}
	
	public void run()
	{
		for(;;)
		{
			try{
				repaint();
				Thread.sleep(250);
				if(stopFlag)
				{
					break;
				}
			}
			catch(InterruptedException e){
				
			}
		}
	}
	public void stop()
	{
		stopFlag=true;
		t=null;
	}
	public void destroy()
	{
		
	}
	public void paint(Graphics g)
	{
		//setBackground(Color.cyan);
		char ch;
		ch=msg.charAt(0);
		msg=msg.substring(1,msg.length());
		msg+=ch;
		g.drawString(msg, 50, 30);
	}

}
