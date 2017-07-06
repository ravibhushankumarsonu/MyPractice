package environment.installation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;


public class backEnd {
	//Default_GUI Gui=new Default_GUI();

	// test the server ssh connection
	String host = null;
	String user = null;
	String password = null;
	String DbUser=null;
	String DbPassword=null;
	String DbSID=null;
	int nLocalPort=3332;

	public boolean Test_Server_Connection(String host, String user, String password) {
		// String command1 = "ps -fu testodo1";
		// System.out.println(password);
		this.host = host;
		this.user = user;
		this.password = password;
		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 22);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();
			System.out.println("Connected");
			Channel channel = session.openChannel("exec");
			channel.connect();
			channel.disconnect();
			session.disconnect();
			System.out.println("DONE");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}// end of Test_Server_Connection

	private static void doSshTunnel(String strSshUser, String strSshPassword, String strSshHost, int nSshPort,
			String strRemoteHost, int nLocalPort, int nRemotePort) throws JSchException {
		final JSch jsch = new JSch();
		Session session = jsch.getSession(strSshUser, strSshHost, 22);
		session.setPassword(strSshPassword);

		final Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);

		session.connect();
		System.out.println("Connected");
		session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
		System.out.println("This is working.");
	}// End of doSshTunnel

	public boolean Test_Db_Connection(String strDbUser, String strDbPassword,String SID,String Filename) {
		try{
			int nSshPort = 22;
			//int nLocalPort = 3332; // local port number use to bind SSH tunnel
			int nRemotePort = 1521; // remote port number of your database
			backEnd.doSshTunnel(user, password, host, nSshPort, host, nLocalPort, nRemotePort);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connection con =
			// DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:orcl" +
			// nLocalPort, strDbUser,strDbPassword);
			
			//To login as sysdba
			strDbUser=strDbUser+" as sysdba";
			DbUser=strDbUser;
			DbPassword=strDbPassword;
			DbSID=SID;

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:"+DbSID, strDbUser,
					strDbPassword);
			System.out.println("Sql connection is done :)");
			Statement stmt = con.createStatement();
			ArrayList<String> str=new ArrayList<String>();
            try(BufferedReader br=new BufferedReader(new FileReader(Filename))){
            	String line;
            	while((line=br.readLine())!=null){
            		str.add(line);
            	}
            }catch(Exception e){
            	System.out.println(e);
            }
            Iterator itr=str.iterator();
            System.out.println(str.size());
            while(itr.hasNext())
            {
            	ResultSet rs=stmt.executeQuery(itr.next().toString());
            	//rs.last();
                System.out.println(itr.next().toString());
                while(rs.next())
                {
                	System.out.println(rs.getString(1));
                }
            }
			con.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}// End of Test_Server_Connection
	public void dropUser(String UserName){
		try{
			int nSshPort = 22;
			nLocalPort++; // local port number use to bind SSH tunnel
			int nRemotePort = 1521; // remote port number of your database
			backEnd.doSshTunnel(user, password, host, nSshPort, host, nLocalPort, nRemotePort);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connection con =
			// DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:orcl" +
			// nLocalPort, strDbUser,strDbPassword);
			
			//To login as sysdba

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:"+DbSID, DbUser,
					DbPassword);
			System.out.println("Sql connection is done :)");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("drop user "+UserName+" cascade");
            //System.out.println(rs.toString());
            
            con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean Create_User(String UserName,String Profile,String Filename)
	{
		try{
			int nSshPort = 22;
			nLocalPort++; // local port number use to bind SSH tunnel
			int nRemotePort = 1521; // remote port number of your database
			backEnd.doSshTunnel(user, password, host, nSshPort, host, nLocalPort, nRemotePort);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connection con =
			// DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:orcl" +
			// nLocalPort, strDbUser,strDbPassword);
			
			//To login as sysdba

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:"+DbSID, DbUser,
					DbPassword);
			System.out.println("Sql connection is done :)");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			con.setAutoCommit(false);
			//stmt.addBatch("drop user "+UserName+" cascade");
			stmt.addBatch(Profile);
			try(BufferedReader br=new BufferedReader(new FileReader(Filename))){
            	String line;
            	while((line=br.readLine())!=null){
            		if(line.contains("OSSUI_CLIENT")==true){
            			line=line.replace("OSSUI_CLIENT",UserName);
            			System.out.println(line);
            			stmt.addBatch(line);
            		}else if(line.contains("OSSUI")==true){
            			line=line.replace("OSSUI",UserName);
            			stmt.addBatch(line);
            		}else if(line.contains("tempsys")==true){
            			line=line.replace("tempsys",UserName);
            			stmt.addBatch(line);
            		}
            		else
            		{
            			stmt.addBatch(line+" "+UserName);
            			System.out.println(line);
            		}
            		
            	}
            }catch(Exception e){
            	System.out.println(e);
            }
            try{
            	stmt.executeBatch();
            }catch(Exception e){
            	System.err.println(e);
            }
            con.commit();
            System.out.println(UserName+" created.");
			con.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}//End of Create server
	public boolean Execute_sql(String UserName,String FileName){
		try {
            int nSshPort = 22; // remote SSH host port number
            nLocalPort++;
            int nRemotePort = 1521; // remote port number of your database
            //File Creations
            ArrayList<String> str=new ArrayList<String>();
    		try(BufferedReader br=new BufferedReader(new FileReader(FileName))){
    			String temp;
    			while((temp=br.readLine())!=null)
    			{
    				if(temp.contains("RAVI")){
    					temp=temp.replace("RAVI", UserName);
    				}
    				str.add(temp);
    			}
    		}catch(Exception e)
    		{
    			System.out.println(e);
    		}
    		Iterator itr=str.iterator();
    		try{
    			PrintWriter pr=new PrintWriter("temp.sql","UTF-8");
    			while(itr.hasNext()){
    				//System.out.println(itr.next());
    				pr.println(itr.next());
    			}
    			pr.close();
    		}catch(IOException e){
    			System.out.println(e);
    			return false;
    		}
    		//End of file Creations
    		backEnd.doSshTunnel(user, password, host, nSshPort, host, nLocalPort, nRemotePort);

            Class.forName("oracle.jdbc.driver.OracleDriver");
           // Connection con = DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:orcl" + nLocalPort, strDbUser,strDbPassword);
            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:"+DbSID, DbUser,
					DbPassword);
            System.out.println("Sql connection is done :)");
            ScriptRunner runner=new ScriptRunner(con,false,false);
            runner.runScript(new BufferedReader(new FileReader("temp.sql")));
            con.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
	}
	public boolean Server_Command(String command){
	    try{
	    	
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, host, 22);
	    	session.setPassword(password);
	    	session.setConfig(config);
	    	session.connect();
	    	System.out.println("Connected");
	    	
	    	Channel channel=session.openChannel("exec");
	        ((ChannelExec)channel).setCommand(command);
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        InputStream in=channel.getInputStream();
	        channel.connect();
	        byte[] tmp=new byte[1024];
	        while(true){
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            System.out.print(new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            System.out.println("exit-status: "+channel.getExitStatus());
	            break;
	          }
	          try{Thread.sleep(1000);}catch(Exception ee){}
	        }
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	        return true;      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return false;
	    }
	}
	
	public void Upload_To_Server(String filename,String Path){
		FileInputStream fis=null;
	    try{
	    	String lfile=filename;
	    	//String user="testodo1";
	    	//String host="illin3351";
	    	String rfile=Path+filename;

	      JSch jsch=new JSch();
	      Session session=jsch.getSession(user, host, 22);

	      java.util.Properties config = new java.util.Properties(); 
	      config.put("StrictHostKeyChecking", "no");
	      session.setPassword(password);
	  	  session.setConfig(config);
	      session.connect();

	      boolean ptimestamp = false;
	      // exec 'scp -t rfile' remotely
	      String command="scp " + (ptimestamp ? "-p" :"") +" -t "+rfile;
	      Channel channel=session.openChannel("exec");
	      ((ChannelExec)channel).setCommand(command);

	      // get I/O streams for remote scp
	      OutputStream out=channel.getOutputStream();
	      InputStream in=channel.getInputStream();

	      channel.connect();

	      if(checkAck(in)!=0){
		//System.exit(0);
	    	  System.out.println("Error in File Transfer");
	    	  return;
	      }

	      File _lfile = new File(lfile);

	      if(ptimestamp){
	        command="T "+(_lfile.lastModified()/1000)+" 0";
	        // The access time should be sent here,
	        // but it is not accessible with JavaAPI ;-<
	        command+=(" "+(_lfile.lastModified()/1000)+" 0\n"); 
	        out.write(command.getBytes()); out.flush();
	        if(checkAck(in)!=0){
	  	  //System.exit(0);
	        	 System.out.println("Error in File Transfer");
		    	  return;
	        }
	      }

	      // send "C0644 filesize filename", where filename should not include '/'
	      long filesize=_lfile.length();
	      command="C0644 "+filesize+" ";
	      if(lfile.lastIndexOf('/')>0){
	        command+=lfile.substring(lfile.lastIndexOf('/')+1);
	      }
	      else{
	        command+=lfile;
	      }
	      command+="\n";
	      out.write(command.getBytes()); out.flush();
	      if(checkAck(in)!=0){
		//System.exit(0);
	    	  System.out.println("Error in File Transfer");
	    	  return;
	      }

	      // send a content of lfile
	      fis=new FileInputStream(lfile);
	      byte[] buf=new byte[1024];
	      while(true){
	        int len=fis.read(buf, 0, buf.length);
		if(len<=0) break;
	        out.write(buf, 0, len); //out.flush();
	      }
	      fis.close();
	      fis=null;
	      // send '\0'
	      buf[0]=0; out.write(buf, 0, 1); out.flush();
	      if(checkAck(in)!=0){
		//System.exit(0);
	    	  System.out.println("Error in File Transfer");
	    	  return;
	      }
	      out.close();
	      System.out.print("Transfer done.");

	      channel.disconnect();
	      session.disconnect();

	      //System.exit(0);
	      return;
	    }
	    catch(Exception e){
	      System.out.println(e);
	      try{if(fis!=null)fis.close();}catch(Exception ee){}
	    }
	  }

	  static int checkAck(InputStream in) throws IOException{
	    int b=in.read();
	    // b may be 0 for success,
	    //          1 for error,
	    //          2 for fatal error,
	    //          -1
	    if(b==0) return b;
	    if(b==-1) return b;

	    if(b==1 || b==2){
	      StringBuffer sb=new StringBuffer();
	      int c;
	      do {
		c=in.read();
		sb.append((char)c);
	      }
	      while(c!='\n');
	      if(b==1){ // error
		System.out.print(sb.toString());
	      }
	      if(b==2){ // fatal error
		System.out.print(sb.toString());
	      }
	    }
	    return b;
	  }


}

