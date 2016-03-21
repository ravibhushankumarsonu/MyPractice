using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice.Chapter7
{
    class String1
    {
        static void Main(string[] args)
        {
            char[] charArray = { 'A', ' ', 'S', 't', 'r', 'i', 'n', 'g' };
            string str1 = new string(charArray);
            string str2 =  "This is Ravibhushan Kumar";
            Console.WriteLine(str1);
            Console.WriteLine(str2);
        }
    }
}
