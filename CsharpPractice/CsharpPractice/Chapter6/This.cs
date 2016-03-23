using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice.Chapter6
{
    class Rect
    {
        public int width;
        public int height;
        public Rect(int w,int h)
        {
            this.width = w;
            this.height = h;
        }
        public int Area()
        {
            return this.width * this.height;
        }
    }
    class This
    {
        static void Main(string[] args)
        {
            Rect squre = new Rect(2, 2);
            Console.WriteLine("Area of the Square is "+squre.Area());
        }
    }
}
