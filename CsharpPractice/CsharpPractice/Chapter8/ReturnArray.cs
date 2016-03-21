using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice.Chapter8
{
    class Factor
    {
        /*
        Return an array that contains the factor of the number given
        */
        public int[] FindFactor(int num,out int numFactor)
        {
            int[] fact = new int[80];
            int i, j;
            //Find the factor and put them into the fact array
            for ( i = 2,j=0; i < num/2; i++)
            {
                if(num%i==0)
                {
                    fact[j] = i;
                    j++;
                }
            }
            numFactor = j;
            return fact;
        }
    }
    class ReturnArray
    {
        static void Main(string[] args)
        {
            int number;
            int[] factor;
            Factor f = new Factor();
            factor = f.FindFactor(1000, out number);
            Console.WriteLine("Factors are :");
            for (int i = 0; i < number; i++)
            {
                Console.Write(factor[i]+",");
            }
            Console.WriteLine();
        }
    }
}
