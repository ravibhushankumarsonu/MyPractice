import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.*;
import java.io.*;

public class CreateUser {
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
    }

    public static void main(String[] args) {
        try {
            String strSshUser = "testodo1"; // SSH loging username
            String strSshPassword = "Unix11!"; // SSH login password
            String strSshHost = "illin3351"; // hostname or ip or
                                                            // SSH server
            int nSshPort = 22; // remote SSH host port number
            String strRemoteHost = "illin3351"; // hostname or
                                                                    // ip of
                                                                    // your
                                                                    // database
                                                                    // server
            int nLocalPort = 3332; // local port number use to bind SSH tunnel
            int nRemotePort = 1521; // remote port number of your database
            String strDbUser = "cradba as sysdba"; // database loging username
            String strDbPassword = "cradba"; // database login password

            CreateUser.doSshTunnel(strSshUser, strSshPassword, strSshHost, nSshPort, strRemoteHost, nLocalPort,
                    nRemotePort);

            Class.forName("oracle.jdbc.driver.OracleDriver");
           // Connection con = DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:orcl" + nLocalPort, strDbUser,strDbPassword);
            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:TESTODO1", strDbUser,strDbPassword);
            System.out.println("Sql connection is done :)");
            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            con.setAutoCommit(false);
            stmt.addBatch(" declare userexit integer;"
            		+ " begin select count(*) into userexit from dba_users where username='ravi';  "
            		+ "if(userexit=1) then execute immediate 'drop user ravi cascade'; end if; end;");
            stmt.addBatch("Create user ravi identified by ravi default tablespace USR temporary"
            		+ " tablespace TEMP profile default account unlock");
            //ArrayList<String> str=new ArrayList<String>();
            try(BufferedReader br=new BufferedReader(new FileReader("createUser.txt"))){
            	String line;
            	while((line=br.readLine())!=null){
            		stmt.addBatch(line+" ravi");
            	}
            }catch(Exception e){
            	System.out.println(e);
            }
            stmt.executeLargeBatch();
            con.commit();
            System.out.println("User created");
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}


