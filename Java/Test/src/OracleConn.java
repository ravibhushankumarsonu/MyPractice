import java.sql.*;
import java.sql.Statement;
import java.util.Properties;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

class OracleConn {
	public static void main(String args[]) {
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sys as sysdba", "ravi");

			// step3 create the statement object
			//Statement stmt = con.createStatement();

			// step4 execute query
			String DB_URL="jdbc:oracle:oci:@localhost:1521:orcl";
         // OracleDataSource ds1 = new OracleDataSource();
			OracleDataSource ds1=new OracleDataSource();
		    Properties prop1 = new Properties();
		    prop1.setProperty("user","ravi");
		    prop1.setProperty("password","ravi");
		    prop1.setProperty("internal_logon","sysdba");
		    ds1.setConnectionProperties(prop1);
		    ds1.setURL(DB_URL);
		    OracleConnection conn1 = (OracleConnection)ds1.getConnection();
		    Statement stmt = conn1.createStatement();
		    //System.out.println(conn1.toString());
			ResultSet rs = stmt.executeQuery("select * from dba_users");
			while (rs.next())
				System.out.println(rs.getString(1));
			// step5 close the connection object
			conn1.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}