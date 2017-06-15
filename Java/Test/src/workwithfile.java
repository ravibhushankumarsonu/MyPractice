import java.util.*;
import java.io.*;

public class workwithfile {
	
	public static void main(String[] args)
	{
		//System.out.print("This is file");
		ArrayList<String> str=new ArrayList<String>();
		try(BufferedReader br=new BufferedReader(new FileReader("oracle.txt"))){
			String temp;
			while((temp=br.readLine())!=null)
			{
				str.add(temp);
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		Iterator itr=str.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
