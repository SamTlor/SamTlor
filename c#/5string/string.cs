using System;

namespace StoryTime{
    class Program{
        static void Main(string[] args){
            // Declare the variables
            string beginning = "Once upon a time,";
            string middle = "The kid climbed a tree";
            string end = "Everyone lived happily ever after.";

            // Interpolate the string and the variables
            string story = $"{beginning} {middle} {end}";
            Console.WriteLine(story);

            //length
            Console.WriteLine(story.Length);

            //IndexOf
            Console.WriteLine(story.IndexOf(","));

            //Substring
            int startPoint = story.IndexOf(",");
            int length = 5;
            Console.WriteLine(story.Substring(startPoint, length));

            //Bracket notation
            Console.WriteLine(story[3]);

            //ToUpper() and ToLower()
            Console.WriteLine(story.ToUpper());
            Console.WriteLine(story.ToLower());
        }
    }
}
