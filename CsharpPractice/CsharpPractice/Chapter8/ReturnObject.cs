using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice.Chapter8
{
    class Rect
    {
        int width;
        int height;

        public Rect(int x,int y)
        {
            width = x;
            height = y;
        }
        public int Area()
        {
            return width * height;
        }
        public void Show()
        {
            Console.WriteLine("Width : {0} and Height : {1}",width,height);
        }
        public Rect Enlagre(int factor)
        {
            return new Rect(width * factor, height * factor);
        }
    }
    class ReturnObject
    {
        static void Main(string[] args)
        {
            Rect r1 = new Rect(3, 4);
            Console.WriteLine("dimension of the Rectangle is :");
            r1.Show();
            Rect r2 = r1.Enlagre(2);
            Console.WriteLine("dimension of the Rectangle is :");
            r2.Show();
        }
    }
}
