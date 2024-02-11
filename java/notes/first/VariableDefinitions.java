public class VariableDefinitions {
    public static void main(String[] args) {
        /**
        * initial declaration of numPeople variable
        **/
        byte numPeople = 3;
        /**
        * initial declaration of Price variable
        **/
        double Price = 32.32;
        /**
        * initial declaration of dinner variable
        **/
        float dinner = 30.0F;
        /**
        * initial declaration of ratherLong variable
        **/
        long ratherLong = 990123456789L;


        System.out.println("The numPeople variable has a value of " + numPeople);
        System.out.println("The Price variable has a value of " + Price);
        System.out.println("The dinner variable has a value of " + dinner);
        System.out.println("The ratherLong variable has a value of " + ratherLong);

        

        /** 
        * modified value of the numPeople variable 
        **/
        numPeople = 6;
        /** 
        * modified value of the Price variable 
        **/
        Price = 31.99;
        /** 
        * modified value of the dinner variable 
        **/
        dinner = 60.0F;
        /** 
        * modified value of the ratherLong variable 
        **/
        ratherLong = 173957295728L;



        System.out.println("\n\n\nThe numPeople variable now has a value of " + numPeople);
        System.out.println("The Price variable now has a value of " + Price);
        System.out.println("The dinner variable now has a value of " + dinner);
        System.out.println("The ratherLong variable now has a value of " + ratherLong);



        final int jeremy = 12;
        final float daniel = 58.9f;
        final long ana = 1884800069693L;
        final short diana = 12582;

        System.out.println("\n\n\nThe jeremy variable has a value of " + jeremy);
        System.out.println("The daniel variable has a value of " + daniel);
        System.out.println("The ana variable has a value of " + ana);
        System.out.println("The diana variable now has a value of " + diana);


        //jeremy = 13;

        }

}