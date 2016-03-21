using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice.Chapter8
{
    class Decompose
    {
        /*Decompose floating point value into its integer and 
        fractional part. 
        */
        public int Getparts(double n,out double frac)
        {
            int whole;
            whole = (int)n;
            frac = n - whole;
            return whole;
        }
    }
    class UseOut
    {
        static void Main(string[] args)
        {
            Decompose ob = new Decompose();
            int i;
            double f;
            i = ob.Getparts(10.50,out f);
            Console.WriteLine("Integer portion is :"+i);
            Console.WriteLine("Fractional portion is :"+f);
        }
    }
}
