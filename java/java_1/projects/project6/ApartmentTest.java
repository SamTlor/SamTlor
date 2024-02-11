package projects.project6;

import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ApartmentTest {

    @Test
    public void Apartment_instanceCountTest(){
        Apartment testApartment = new Apartment();
        @SuppressWarnings("rawtypes")
        Class c = testApartment.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables we",
                    6, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void Apartment_instanceVariablesTest(){
        Apartment testApartment = new Apartment();
        instanceVariablePrivate("locationNumber",testApartment);
        instanceVariablePrivate("squareFootage",testApartment);
        instanceVariablePrivate("price",testApartment);
        instanceVariablePrivate("bedrooms",testApartment);
        instanceVariablePrivate("baths",testApartment);
        instanceVariablePrivate("status",testApartment);

        instanceVariableStatic("locationNumber",testApartment);
        instanceVariableStatic("squareFootage",testApartment);
        instanceVariableStatic("price",testApartment);
        instanceVariableStatic("bedrooms",testApartment);
        instanceVariableStatic("baths",testApartment);
        instanceVariableStatic("status",testApartment);

        instanceVariableCorrectType("locationNumber", int.class,testApartment);
        instanceVariableCorrectType("squareFootage", double.class,testApartment);
        instanceVariableCorrectType("price", double.class,testApartment);
        instanceVariableCorrectType("bedrooms",Bedrooms.class,testApartment);
        instanceVariableCorrectType("baths", Baths.class,testApartment);
        instanceVariableCorrectType("status",Status.class,testApartment);
    }

    @Test
    public void Apartment_defaultConstructorTest() {
        Apartment testApartment = new Apartment();

        testVariable("locationNumber",testApartment,1,"When checking the value of locationNumber we");
        testVariable("squareFootage",testApartment,500.00,"When checking the value of squareFootage we");
        testVariable("price",testApartment,400.00,"When checking the value of price we");
        testVariable("bedrooms",testApartment,Bedrooms.ONE_BEDROOM,"When checking the value of bedrooms we");
        testVariable("baths",testApartment,Baths.ONE,"When checking the value of baths we");
        testVariable("status",testApartment,Status.VACANT,"When checking the value of status we");

    }

    @Test
    public void Apartment_parameterizedConstructorTest() {
        Apartment testApartment = new Apartment(20,850.50,750,Bedrooms.TWO_BEDROOM,Baths.ONE,Status.OCCUPIED);

        testVariable("locationNumber",testApartment,20,"When checking the value of locationNumber we");
        testVariable("squareFootage",testApartment,850.50,"When checking the value of squareFootage we");
        testVariable("price",testApartment,750.0,"When checking the value of price we");
        testVariable("bedrooms",testApartment,Bedrooms.TWO_BEDROOM,"When checking the value of bedrooms we");
        testVariable("baths",testApartment,Baths.ONE,"When checking the value of baths we");
        testVariable("status",testApartment,Status.OCCUPIED,"When checking the value of status we");

    }


    @Test
    public void Apartment_getLocationNumberTest() {
        Apartment testApartment = createApartment(10,900.05,1000.50,Bedrooms.ONE_BEDROOM,Baths.THREE,Status.VACANT);
        assertEquals("With an Apartment object who's locationNumber instance variable is 10, when calling getLocationNumber we",10,testApartment.getLocationNumber());
    }

    @Test
    public void Apartment_setLocationNumberTest() {
        Apartment testApartment = createApartment(10,900.05,1000.50,Bedrooms.ONE_BEDROOM,Baths.THREE,Status.VACANT);
        testApartment.setLocationNumber(50);
        testVariable("locationNumber",testApartment,50,"After calling Apartment's setLocationNumber method with an argument of 50, for the value of locationNumber we");
    }

    @Test
    public void Apartment_getSquareFootageTest() {
        Apartment testApartment = createApartment(21,340.05,300.50,Bedrooms.ONE_BEDROOM,Baths.ONE,Status.VACANT);
        assertEquals("With an Apartment object who's squareFootage instance variable is 340.05, when calling getLocationNumber we",340.05,testApartment.getSquareFootage(),.001);
    }

    @Test
    public void Apartment_setSquareFootageTest() {
        Apartment testApartment = createApartment(21,340.05,300.50,Bedrooms.ONE_BEDROOM,Baths.ONE,Status.VACANT);
        testApartment.setSquareFootage(550.75);
        testVariable("squareFootage",testApartment,550.75,"After calling Apartment's setSquareFootage method with an argument of 550.75, for the value of locationNumber we");
    }

    @Test
    public void Apartment_getPriceTest() {
        Apartment testApartment = createApartment(42,1340.05,3000.50,Bedrooms.THREE_BEDROOM,Baths.TWO,Status.OCCUPIED);
        assertEquals("With an Apartment object who's price instance variable is 340.05, when calling getLocationNumber we",3000.50,testApartment.getPrice(),.001);
    }

    @Test
    public void Apartment_setPriceTest() {
        Apartment testApartment = createApartment(42,1340.05,3000.50,Bedrooms.THREE_BEDROOM,Baths.TWO,Status.OCCUPIED);
        testApartment.setPrice(2750.25);
        testVariable("price",testApartment,2750.25,"After calling Apartment's setPrice method with an argument of 2750.25, for the value of price we");
    }

    @Test
    public void Apartment_getBedroomsTest() {
        Apartment testApartment = createApartment(72,130.05,300.50,Bedrooms.ONE_BEDROOM,Baths.ONE,Status.OCCUPIED);
        assertEquals("With an Apartment object who's bedrooms instance variable is ONE_BEDROOM, when calling getBedrooms we",Bedrooms.ONE_BEDROOM,testApartment.getBedrooms());
    }

    @Test
    public void Apartment_setBedroomsTest() {
        Apartment testApartment = createApartment(72,130.05,300.50,Bedrooms.ONE_BEDROOM,Baths.ONE,Status.OCCUPIED);
        testApartment.setBedrooms(Bedrooms.STUDIO);
        testVariable("bedrooms",testApartment,Bedrooms.STUDIO,"After calling Apartment's setBedrooms method with an argument of Bedrooms.STUDIO, for the value of bedrooms we");
    }

    @Test
    public void Apartment_getBathsTest() {
        Apartment testApartment = createApartment(72,130.05,300.50,Bedrooms.ONE_BEDROOM,Baths.ONE,Status.OCCUPIED);
        assertEquals("With an Apartment object who's baths instance variable is Baths.ONE, when calling getBaths we",Baths.ONE,testApartment.getBaths());
    }

    @Test
    public void Apartment_setBathsTest() {
        Apartment testApartment = createApartment(72,130.05,300.50,Bedrooms.ONE_BEDROOM,Baths.ONE,Status.OCCUPIED);
        testApartment.setBaths(Baths.TWO);
        testVariable("baths",testApartment,Baths.TWO,"After calling Apartment's setBaths method with an argument of Bedrooms.STUDIO, for the value of baths we");
    }

    @Test
    public void Apartment_getStatusTest() {
        Apartment testApartment = createApartment(72,130.05,300.50,Bedrooms.ONE_BEDROOM,Baths.ONE,Status.OCCUPIED);
        assertEquals("With an Apartment object who's status instance variable is Status.OCCUPIED, when calling getBaths we",Status.OCCUPIED,testApartment.getStatus());
    }

    @Test
    public void Apartment_setStatusTest() {
        Apartment testApartment = createApartment(72,130.05,300.50,Bedrooms.ONE_BEDROOM,Baths.ONE,Status.OCCUPIED);
        testApartment.setStatus(Status.VACANT);
        testVariable("status",testApartment,Status.VACANT,"After calling Apartment's setStatus method with an argument of Status.VACANT, for the value of status we");
    }

    @Test
    public void Apartment_toStringTest() {
        Apartment testApartment = createApartment(151,1340.05,3000.50,Bedrooms.STUDIO,Baths.ONE,Status.OCCUPIED);
        assertEquals(  "\n\t151\n" +
                "\t1340.05\n" +
                "\t3000.5\n" +
                "\tSTUDIO\n" +
                "\tONE\n" +
                "\tOCCUPIED\n", testApartment.toString());

        testApartment = createApartment(11,444.44,404.40,Bedrooms.ONE_BEDROOM,Baths.ONE,Status.VACANT);
        assertEquals(  "\n" +
                "\t11\n" +
                "\t444.44\n" +
                "\t404.4\n" +
                "\tONE_BEDROOM\n" +
                "\tONE\n" +
                "\tVACANT\n", testApartment.toString());
    }


    private Apartment createApartment(int aLocationNumber, double aSquareFootage, double aPrice, Bedrooms aBedrooms, Baths aBaths, Status aStatus){
        Apartment testApartment = new Apartment();
        @SuppressWarnings("rawtypes")
        Class c = testApartment.getClass();

        try {
            Field locationNumber = c.getDeclaredField("locationNumber");
            locationNumber.setAccessible(true);
            locationNumber.set(testApartment, aLocationNumber);

            Field squareFootage = c.getDeclaredField("squareFootage");
            squareFootage.setAccessible(true);
            squareFootage.set(testApartment, aSquareFootage);

            Field price = c.getDeclaredField("price");
            price.setAccessible(true);
            price.set(testApartment, aPrice);

            Field bedrooms = c.getDeclaredField("bedrooms");
            bedrooms.setAccessible(true);
            bedrooms.set(testApartment, aBedrooms);

            Field baths = c.getDeclaredField("baths");
            baths.setAccessible(true);
            baths.set(testApartment, aBaths);

            Field status = c.getDeclaredField("status");
            status.setAccessible(true);
            status.set(testApartment, aStatus);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testApartment;
    }

    private void instanceVariablePrivate(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertTrue("You must make your instance variables private.", Modifier.isPrivate(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableStatic(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("Your instance variables must NOT be static.", false,
                    Modifier.isStatic(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableCorrectType(String aField, Class<?> aClass,  Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("You must make the speed instance variable of type"+ aClass.toString() +".", aClass, c.getDeclaredField(aField).getType());

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void testVariable(String aField, Object testObject, Object expected, String message){
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            Field field = c.getDeclaredField(aField);
            field.setAccessible(true);
            Object fieldValue = field.get(testObject);

            if(expected == null){
                assertNull(message,fieldValue);
            }
            //If class is a double we have a special Junit assert to run
            else if(expected.getClass().equals(Double.class)){
                double doubleFieldValue = (double) fieldValue;
                double doubleExpected = (double) expected;
                assertEquals(message, doubleExpected, doubleFieldValue, .01);
            }
            //Array of some kind yay
            else if(expected.getClass().isArray()){

            }
            else if(expected.getClass().equals(ArrayList.class)){

            }
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }
}
