using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice
{
    class Building
    {
        public int Floor;
        public int Area;
        public int Occupants;
        public double AreaPerPerson()
        {
            return (double)Area / Occupants;
        }
        //public Building(int x)
        //{
        //    Floor = x;
        //}
        ~Building()
        {
            Console.WriteLine("Destructing");
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Building house = new Building();
            double areaPP;
            house.Occupants = 4;
            house.Area = 2500;
            house.Floor = 2;
            areaPP =house.AreaPerPerson();

            Console.WriteLine("House has \n"+house.Floor+" Floors\n"+house.Area+" Area\n"+house.Occupants+" Occupants\n"+areaPP+" Area Per Person Available");
        }
    }
}
