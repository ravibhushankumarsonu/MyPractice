import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.*;
import java.io.*;

public class OracleConn1 {
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
            String strDbUser = "cradba"; // database loging username
            String strDbPassword = "cradba"; // database login password

            OracleConn1.doSshTunnel(strSshUser, strSshPassword, strSshHost, nSshPort, strRemoteHost, nLocalPort,
                    nRemotePort);

            Class.forName("oracle.jdbc.driver.OracleDriver");
           // Connection con = DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:orcl" + nLocalPort, strDbUser,strDbPassword);
            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@illin3351:1521:TESTODO1", strDbUser,strDbPassword);
            System.out.println("Sql connection is done :)");
            Statement stmt=con.createStatement();
            
            ArrayList<String> str=new ArrayList<String>();
            try(BufferedReader br=new BufferedReader(new FileReader("oracle.txt"))){
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
                	System.out.println(rs.getString(1)+" "+rs.getString(2));
                }
            }
            
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}


