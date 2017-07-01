package mypackage.account;

import java.sql.*;
import java.util.*;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class oracleConnection {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
		String DB_URL="jdbc:oracle:oci:@localhost:1521:orcl";
                 //OracleDataSource ds1 = new OracleDataSource();
		OracleDataSource ds1=new OracleDataSource();
                Properties prop1 = new Properties();
		prop1.setProperty("user","ravi");
		prop1.setProperty("password","ravi");
		prop1.setProperty("internal_logon","sysdba");
		ds1.setConnectionProperties(prop1);
		ds1.setURL(DB_URL);
		OracleConnection conn1 = (OracleConnection)ds1.getConnection();
		Statement stmt = conn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//System.out.println(conn1.toString());
		    
		ResultSet rs = stmt.executeQuery("select * from data");
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2));
                    }
		conn1.close();
		}catch (Exception e){
			System.err.println(e);
		}

	}

}
