import java.util.Arrays;
public class BinarySearch {
	public static int rank(int key,int[] a)
	{
		int l=0;
		int u=a.length-1;
		while(l<=u)
		{
			int mid=l+(u-l)/2;
			if(key<a[mid])
			{
				u=mid-1;
			}
			else if(key>a[mid])
			{
				l=mid+1;
			}
			else
			{
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] arr=new int[10];
         arr[0]=1;
         arr[1]=22;
         arr[2]=32;
         arr[3]=23;
         arr[4]=24;
         arr[5]=34;
         arr[6]=29;
         arr[7]=76;
         arr[8]=43;
         arr[9]=23;
         Arrays.sort(arr);
         int x=rank(23,arr);
         if(x>=0)
        	 System.out.println(arr[x]+" is in the given array.");
         else
        	 System.out.println("Not present in the given array.");
	}
}
