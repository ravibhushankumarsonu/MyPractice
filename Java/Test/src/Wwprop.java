import java.io.*;
import java.util.Properties;

public class Wwprop {
  public static void main(String[] args) throws IOException {
	//OutputStream output = null;
	//InputStream input=null;

	

	// set the properties value
	/*prop.setProperty("database", "localhost");
	prop.setProperty("dbuser", "ravi");
	prop.setProperty("dbpassword", "password");*/

	// save properties to project root folder
	//prop.store(output, null);
	  Properties prop=new Properties();
	  try {
		FileInputStream input=new FileInputStream("config.properties");
		prop.load(input);
		input.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  FileOutputStream output=new FileOutputStream("config.properties");
	  prop.setProperty("JEE1/container.listen.port", "64001");
	  prop.store(output, null);
	  output.close();
  }
}