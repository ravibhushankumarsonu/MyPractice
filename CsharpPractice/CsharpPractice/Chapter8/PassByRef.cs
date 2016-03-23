using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpPractice.Chapter8
{
    class MYClass
    {
        int alpha;
        int beta;
        public MYClass(int x,int y)
        {
            alpha = x;
            beta = y;
        }
        public bool SameAs(MYClass ob)
        {
            if ((ob.alpha == alpha) & (ob.beta == beta))
                return true;
            return false;
        }
        public void Copy(MYClass ob)
        {
            alpha = ob.alpha;
            beta = ob.beta;
        }
        public void Show()
        {
            Console.WriteLine("Alpha : {0} and Beta :{1}",alpha,beta);
        }
    }
    class PassByRef
    {
        static void Main(string[] args)
        {
            MYClass ob1 = new MYClass(4, 7);
            MYClass ob2 = new MYClass(6, 7);
            Console.WriteLine("Ob1 is :");
            ob1.Show();
            Console.WriteLine("Ob2 is :");
            ob2.Show();
            //Make ob1 as copy of ob2
            ob1.Copy(ob2);
            Console.WriteLine("Now Ob1 is :");
            ob1.Show();
            //Check whether ob1 and ob2 are same or not
            if(ob1.SameAs(ob2))
            {
                Console.WriteLine("After copy ob1 is same as ob2");
            }
            else
            {
                Console.WriteLine("After copy ob1 is not same as ob2");
            }
        }
    }
}
