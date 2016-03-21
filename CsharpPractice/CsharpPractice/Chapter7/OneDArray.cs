using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice.Chapter7
{
    class OneDArray
    {
        static void Main(string[] args)
        {
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++)
            {
                arr[i] = i + 1;
            }
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Array ["+i+"] contains "+arr[i]+"\n");
            }
        }
    }
}
