using System;

namespace conversion{
    class Program {
        static void Main(string[] args) {
            //convertying types implicitly
            int firstInt = 5;
            double firstDouble = firstInt;
            Console.WriteLine(firstDouble);


            //converting types explicitly
            double myDouble = 3.2;
            
            // Round myDouble to the nearest whole number
            int myInt = (int)myDouble;
            
            Console.WriteLine(myInt);


            //converting types with built in functions
            Console.Write("Enter your favorite number: ");
            string response = Console.ReadLine();
            int faveNumber = Convert.ToInt32(response);
            Console.WriteLine(faveNumber);
        }
    }
}

/*
Convert.ToX() method, like Convert.ToString() and Convert.ToDouble(). 
For a full list of Convert class built-in methods, check out the 
Microsoft Documentation. 
*/