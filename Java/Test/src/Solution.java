import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      BigInteger n = in.nextBigInteger();
      in.close();
      // Write your code here.
      if(n.isProbablePrime(100)==true)
      {
    	  System.out.println("Prime");
      }else
      {
    	  System.out.println("Not Prime");
      }
   }
}
