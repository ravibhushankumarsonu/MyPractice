using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice.Chapter9
{
    class ThreeD
    {
        int x, y, z;
        public ThreeD()
        {
            x = y = z = 0;
        }
        public ThreeD(int i,int j,int k)
        {
            x = i;
            y = j;
            z = k;
        }
        //Overload + in Binary operation
        public static ThreeD operator +(ThreeD ob1,ThreeD ob2)
        {
            ThreeD temp = new ThreeD();
            temp.x = ob1.x + ob2.x;
            temp.y = ob1.y + ob2.y;
            temp.z = ob1.z + ob2.z;
            return temp;
        }
        //Operator overloading binary -
        public static ThreeD operator -(ThreeD ob1,ThreeD ob2)
        {
            ThreeD temp = new ThreeD();
            temp.x = ob1.x - ob2.x;
            temp.y = ob1.y - ob2.y;
            temp.z = ob1.z - ob2.z;
            return temp;
        }
        //Operator overloading unary -
        public static ThreeD operator -(ThreeD ob1)
        {
            ThreeD temp = new ThreeD();
            temp.x = -ob1.x;
            temp.y = -ob1.y;
            temp.z = -ob1.z;
            return temp;
        }
        //Operator Overloading unary ++
        public static ThreeD operator ++(ThreeD ob1)
        {
            ThreeD temp = new ThreeD();
            temp.x = ob1.x+1;
            temp.y = ob1.y+1;
            temp.z = ob1.z+1;
            return temp;
        }
        //Operator Overloading unary --
        public static ThreeD operator --(ThreeD ob1)
        {
            ThreeD temp = new ThreeD();
            temp.x = ob1.x - 1;
            temp.y = ob1.y - 1;
            temp.z = ob1.z - 1;
            return temp;
        }
        //Operator overloading for ThreeD+int 
        public static ThreeD operator +(ThreeD ob1,int i)
        {
            ThreeD temp = new ThreeD();
            temp.x = ob1.x + i;
            temp.y = ob1.y + i;
            temp.z = ob1.z + i;
            return temp;
        }
        //Operator overloading for ThreeD-int 
        public static ThreeD operator -(ThreeD ob1, int i)
        {
            ThreeD temp = new ThreeD();
            temp.x = ob1.x - i;
            temp.y = ob1.y - i;
            temp.z = ob1.z - i;
            return temp;
        }
        //Operator overloading for int+ThreeD 
        public static ThreeD operator +( int i, ThreeD ob1)
        {
            ThreeD temp = new ThreeD();
            temp.x = ob1.x + i;
            temp.y = ob1.y + i;
            temp.z = ob1.z + i;
            return temp;
        }
        //Operator overloading for int-ThreeD 
        public static ThreeD operator -( int i, ThreeD ob1)
        {
            ThreeD temp = new ThreeD();
            temp.x = ob1.x - i;
            temp.y = ob1.y - i;
            temp.z = ob1.z - i;
            return temp;
        }
        //Operator overloading for < 
        // between two ThreeD objects define on their distance from the origin
        public static bool operator <(ThreeD ob1,ThreeD ob2)
        {
            if (Math.Sqrt(ob1.x * ob1.x + ob1.y * ob1.y + ob1.z * ob1.z) <
                Math.Sqrt(ob2.x * ob2.x + ob2.y * ob2.y + ob2.z * ob2.z))
                return true;
            else
                return false;
        }
        //Operator overloading for > 
        // between two ThreeD objects define on their distance from the origin
        public static bool operator >(ThreeD ob1, ThreeD ob2)
        {
            if (Math.Sqrt(ob1.x * ob1.x + ob1.y * ob1.y + ob1.z * ob1.z) >
                Math.Sqrt(ob2.x * ob2.x + ob2.y * ob2.y + ob2.z * ob2.z))
                return true;
            else
                return false;
        }
        //Overloading for conversion
        public static implicit operator int(ThreeD ob)
        {
            return ob.x * ob.y * ob.z;
        }
        public void Show()
        {
            Console.WriteLine("x :{0},y :{1},z :{2}",x,y,z);
        }
    }
    class OperatorOverloading
    {
        static void Main(string[] args)
        {
            ThreeD ob1 = new ThreeD(2, 4, 6);
            ThreeD ob2 = new ThreeD(10, 12, 14);
            ThreeD ob3 = new ThreeD();
            //Print the both objects data
            Console.WriteLine("Object 1 contains :");
            ob1.Show();

            Console.WriteLine("Object 2 contains :");
            ob2.Show();

            //Check the operator overloading +
            ob3 = ob1 + ob2;
            Console.WriteLine("Now object 3 contains :");
            ob3.Show();

            //Check for operator overloading -
            ob3 = ob2 - ob1;
            Console.WriteLine("Now object 3 contains :");
            ob3.Show();

            ob3 = ob1 + ob2 + ob3;
            Console.WriteLine("Now object 3 contains :");
            ob3.Show();

            //Check for unary operator overloading -
            ob3 = -ob1;
            Console.WriteLine("Now object 3 contains :");
            ob3.Show();

            //Check for unary operator ++
            ob3++;
            Console.WriteLine("Now object 3 contains :");
            ob3.Show();

            //Check for unary operator --
            ob3--;
            Console.WriteLine("Now object 3 contains :");
            ob3.Show();

            //Check for ThreeD + int
            ob3 = ob1 + 10;
            Console.WriteLine("Now object 3 contains :");
            ob3.Show();

            //Check for ThreeD - int
            ob3 = ob1 - 10;
            Console.WriteLine("Now object 3 contains :");
            ob3.Show();

            //Check for int+ThreeD
            ob3 = 10 + ob1;
            Console.WriteLine("Now object 3 contains :");
            ob3.Show();

            //Check for < overload
            if(ob1<ob2)
                Console.WriteLine("Object 1 is less than object 2.");
            else
                Console.WriteLine("Object 2 is less or equal to object 1.");

            Console.WriteLine("int equivalent of ob1 is {0}",(int)ob1);
        }
    }
}
