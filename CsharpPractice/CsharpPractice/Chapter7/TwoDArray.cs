using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice.Chapter7
{
    class TwoDArray
    {
        static void Main(string[] args)
        {
            int[,] table = new int[4, 5];
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    table[i, j] = (i * 5) + j + 1;
                }
            }
            Console.WriteLine("Table contains these .....");
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    Console.Write(table[i,j]+" ");
                }
                Console.WriteLine();
            }
        }
    }
}
