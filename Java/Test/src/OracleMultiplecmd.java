import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;


public class OracleMultiplecmd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// step1 load the driver class
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
		    
		    String insert1="insert into data values('Manish','Kumar')";
		    String insert2="insert into data values('Robins','Kumar')";
		    conn1.setAutoCommit(false);
		    
			ResultSet rs = stmt.executeQuery("select * from data");
			rs.last();
			stmt.addBatch(insert1);
		    stmt.addBatch(insert2);
			System.out.println("number of rows in "+rs.getRow());
			stmt.executeBatch();
			conn1.commit();
			System.out.println("Batch is executed.");
			rs = stmt.executeQuery("select * from data");
			rs.last();
			System.out.println("Number of rows in "+rs.getRow());
			conn1.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
