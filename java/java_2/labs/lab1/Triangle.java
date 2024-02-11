package cmsc256;

/** 
  Determines if three doubles can be sides of triangle. 
*/
public class Triangle  {

   private double sideA;            /** Length of side 1. */
   private double sideB;            /** Length of side 2. */
   private double sideC;            /** Length of side 3. */

   /**
    * Creates a Triangle.
    *
    * @param aIn length of side 1.
    * @param bIn length of side 2.
    * @param cIn length of side 3.
    */
   public Triangle(double aIn, double bIn, double cIn) {
      
      if (aIn <= 0 || bIn <= 0 || cIn <= 0) {
         throw new IllegalArgumentException("Sides: " + aIn + " " + bIn + " " + cIn
            + " cannot form a triangle because sides cannot be negative");       // add an explanation why this exception is being thrown.
      }
     
      if ((aIn >= bIn + cIn) || (bIn >= aIn + cIn) || (cIn >= aIn + bIn)) {
         throw new IllegalArgumentException("Sides: "
            + aIn + " " + bIn + " " + cIn
            + " cannot form a triangle because the sides would not connect");      // add an explanation why this exception is being thrown.
      }
     
      sideA = aIn;
      sideB = bIn;
      sideC = cIn;
   }

   /**
    *  Classifies a triangle based on the lengths of the three sides.
    *  The classifications are either: "equilateral", "scalene", "isosceles", 
    *  or "not a triangle". The returned string must match one of these.Tri
    * 
    * @return the triangle classification.
    */
   public String classify() {
      String result = "";
      //TODO:  implement this method according to the specification in the comment block

      if (sideA == sideB && sideA == sideC){
         result += "equilateral";
      }
      else if(sideA == sideB || sideA == sideC || sideB == sideC){
         result += "isosceles";
      } else{
         result += "scalene";
      }
      return result;
   }

}
