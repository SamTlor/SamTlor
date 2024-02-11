using System;

namespace NamedArguments {
    class Program {
        static void Main(string[] args) {
            //default
            VisitPlanets();

            //things are changed from their defaults with a :
            VisitPlanets(numberOfPlanets : 2);
            VisitPlanets(numberOfPlanets : 2, name : "Sam");



            //out can be used to save another piece of info from a method
            string ageAsString = "102";
            int ageAsInt;
            bool outcome;

            outcome = Int32.TryParse(ageAsString, out ageAsInt);

            Console.WriteLine(outcome);     //outcome is if it was successful or not
            Console.WriteLine(ageAsInt);    //ageAsInt is the actual value



            //out can be used by your own methods
            string statement = "GARRRR";
            bool marker;
			string murmur = Whisper(statement, out marker);
            if (marker){
                Console.WriteLine(murmur);  //prints 'garrrr'
            }
        }

        
        //defaults are set in the function definition
        static void VisitPlanets(   string adjective = "brave",
                                    string name = "Cosmonaut", 
                                    int numberOfPlanets = 0,
                                    double gForce = 4.2
                                ) {
            Console.WriteLine($"Welcome back, {adjective} {name}.");
            Console.WriteLine($"You visited {numberOfPlanets} new planets...");
            Console.WriteLine($"...while experiencing a g-force of {gForce} g!");
        }

        static string Whisper(string phrase, out bool wasWhisperCalled) {
            wasWhisperCalled = true;
            return phrase.ToLower();
        }
    }
}