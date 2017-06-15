
import java.util.*;
public class arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> al=new ArrayList<String>();
		System.out.println("initial Size of the arrayList is "+al.size());
		
		al.add("A");
		al.add("ML");
		al.add("B");
		al.add("cf");
		System.out.println("Contains of Array list are : "+ al);
		
		al.remove("A");
		System.out.println("Contains of Array list are : "+ al);
		
		Comparator<String> r=Collections.reverseOrder();
		Collections.sort(al,r);
		System.out.println("Contains of Array list are : "+ al);
		
		

	}

}
