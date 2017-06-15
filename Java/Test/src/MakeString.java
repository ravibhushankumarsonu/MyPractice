import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

//import java.lang.*;
public class MakeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String>arr=new ArrayList<String>();
		try(BufferedReader br=new BufferedReader(new FileReader("createUser.txt"))){
			String line;
			while((line=br.readLine())!=null){
				if(line.contains("OSSUI")==true)
					line=line.replace("OSSUI", "OSSUIhg");
				arr.add(line);
			}
			
		}catch(Exception e){
			System.out.print(e);
		}
		Iterator irt=arr.iterator();
		while(irt.hasNext()){
			System.out.println(irt.next());
		}

	}

}
