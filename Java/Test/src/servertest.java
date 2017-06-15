import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
/*
 This is the example to execute the sequential command 
 executation. With command stroed in the file
 or consuatative sturcture. */

public class servertest {

	public static void main(String[] args) {
	    String host="illin3351";
	    String user="testodo1";
	    String password="Unix11!";
	   // String command1="export DISPLAY=localhost:11.0;echo $DISPLAY";
	   // String command2="./installer/bin/XPI.sh --mem 4 --install  -p /ossusers1/oss/users/testodo1/SFOKit2_impl_10.0.1.0.0_Linux_64_27-01-17_08_07_44.jar -t testodo1.topology -pr /ossusers1/oss/users/testodo1/testodo1_copy.properties";
	    try{
	    	
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, host, 22);
	    	session.setPassword(password);
	    	session.setConfig(config);
	    	session.connect();
	    	System.out.println("Connected");
	    	
	    	Channel channel=session.openChannel("shell");
	    	
	    	OutputStream inputstream_for_the_channel=channel.getOutputStream();
	    	PrintStream commander=new PrintStream(inputstream_for_the_channel,true);
	    	channel.setOutputStream(System.out,true);
	    	channel.connect();
	    	//commander.println("ls -la");
	    	//commander.println("ps -fu testodo1");
	    	
	    	//code for file processing
	    	ArrayList<String> str=new ArrayList<String>();
			try(BufferedReader br=new BufferedReader(new FileReader("file.txt"))){
				String temp;
				while((temp=br.readLine())!=null)
				{
					str.add(temp);
				}
			}catch(Exception e)
			{
				System.out.println(e);
			}//end of file processing
			
			Iterator itr=str.iterator();
			while(itr.hasNext()){
				commander.println(itr.next());
			}
	    	commander.close();
	    	do{
	    		Thread.sleep(1000);
	    	}while(!channel.isEOF());
	        session.disconnect();
	        System.out.println("DONE");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }

	}

}