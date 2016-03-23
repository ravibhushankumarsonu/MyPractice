using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice.Chapter7
{
    class String2
    {
        static void Main(string[] args)
        {
            string[] str1 = { "one", "two", "three", "two", "one" };
            foreach (var item in str1)
            {
                switch (item)
                {
                    case "one":
                        Console.Write(1);
                        break;
                    case "two":
                        Console.Write(2);
                        break;
                    case "three":
                        Console.Write(3);
                        break;
                }
            }
            Console.WriteLine();
        }
    }
}
