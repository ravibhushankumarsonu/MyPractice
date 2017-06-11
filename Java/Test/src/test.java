import java.util.Random;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0,b=0,c=0;
		Random r=new Random();
		for(int i=0;i<3200;i++)
		{
			try{
				b=r.nextInt();
				a=r.nextInt();
				c=12345/(b/a);
			}
			catch(ArithmeticException e)
			{
				System.err.println("System error ocurrs "+e);
				System.out.println(i);
			}
			c=0;
		}
	}
}
