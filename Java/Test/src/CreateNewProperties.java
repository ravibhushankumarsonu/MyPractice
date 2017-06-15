
import java.io.*;
import java.util.Properties;


public class CreateNewProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream output=new FileOutputStream("testo.properties");
		Properties prop=new Properties();
		prop.setProperty("Date", "64001");
		prop.setProperty("Ravi", "dfdgfdg");
		prop.store(output, null);
		output.close();
	}

}
