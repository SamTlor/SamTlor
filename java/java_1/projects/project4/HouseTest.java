package projects;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

@SuppressWarnings("rawtypes")
public class HouseTest{

    @Test
    public void House_instanceCountTest(){
        House testHouse = new House();
        Class c = testHouse.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables we",
                    4, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void House_instanceVariablesTest(){
        House testHouse = new House();
        instanceVariablePrivate("location",testHouse);
        instanceVariablePrivate("squareFootage",testHouse);
        instanceVariablePrivate("price",testHouse);
        instanceVariablePrivate("disToCenter",testHouse);

        instanceVariableStatic("location",testHouse);
        instanceVariableStatic("squareFootage",testHouse);
        instanceVariableStatic("price",testHouse);
        instanceVariableStatic("disToCenter",testHouse);

        instanceVariableCorrectType("location", String.class,testHouse);
        instanceVariableCorrectType("squareFootage", double.class,testHouse);
        instanceVariableCorrectType("price", double.class,testHouse);
        instanceVariableCorrectType("disToCenter", double.class,testHouse);
    }

    @Test
    public void House_defaultConstructorTest() {
        House testHouse = new House();

        testVariable("location",testHouse,"","When checking the value of location we");
        testVariable("squareFootage",testHouse,0.0,"When checking the value of squareFootage we");
        testVariable("price",testHouse,0.0,"When checking the value of price we");
        testVariable("disToCenter",testHouse,0.0,"When checking the value of disToCenter we");

    }

    @Test
    public void House_parameterizedConstructorTest() {
        House testHouse = new House("Crazy Town",1000,30000,25);

        testVariable("location",testHouse,"Crazy Town","When checking the value of location we");
        testVariable("squareFootage",testHouse,1000.0,"When checking the value of squareFootage we");
        testVariable("price",testHouse,30000.0,"When checking the value of price we");
        testVariable("disToCenter",testHouse,25.0,"When checking the value of disToCenter we");

    }

    @Test
    public void House_getLocationTest() {
        House testHouse = new House("924 Gilman St",16000,1000000,25);
        assertEquals("With an House object who's location instance variable is 924 Gilman St, when calling getLocation we","924 Gilman St",testHouse.getLocation());
    }

    @Test
    public void House_setLocationTest() {
        House testHouse = new House("924 Gilman St",16000,1000000,25);
        testHouse.setLocation("929 W Grace St");
        testVariable("location",testHouse,"929 W Grace St","After calling House's setLocation method with an argument of 929 W Grace St, for the value of location we");
    }

    @Test
    public void House_getSquareFootageTest() {
        House testHouse = new House("924 Gilman St",16000,1000000,25);
        assertEquals("With an House object who's squareFootage instance variable is 16000, when calling getSquareFootage we",16000,testHouse.getSquareFootage(),.001);
    }

    @Test
    public void House_setSquareFootageTest() {
        House testHouse = new House("924 Gilman St",16000,1000000,25);
        testHouse.setSquareFootage(6000);
        testVariable("squareFootage",testHouse,6000.0,"After calling House's setSquareFootage method with an argument of 6000, for the value of squareFootage we");
    }

    @Test
    public void House_getPriceTest() {
        House testHouse = new House("924 Gilman St",16000,1000000,25);
        assertEquals("With an House object who's price instance variable is 1000000, when calling getPrice we",1000000,testHouse.getPrice(),.001);
    }

    @Test
    public void House_setPriceTest() {
        House testHouse = new House("924 Gilman St",16000,1000000,25);
        testHouse.setPrice(538000.0);
        testVariable("price",testHouse,538000.0,"After calling House's setPrice method with an argument of 538000.0, for the value of price we");
    }

    @Test
    public void House_getDisToCenter() {
        House testHouse = new House("924 Gilman St",16000,1000000,25);
        assertEquals("With an House object who's disToCenter instance variable is 25, when calling getDisToCenter we",25,testHouse.getDisToCenter(),.001);
    }

    @Test
    public void House_setDisToCenter() {
        House testHouse = new House("924 Gilman St",16000,1000000,25);
        testHouse.setDisToCenter(4.2);
        testVariable("disToCenter",testHouse,4.2,"After calling House's setDisToCenter method with an argument of 4.2, for the value of disToCenter we");
    }

    @Test
    public void House_toStringTest() {
        House testHouse = createHouse("924 Gilman St",16000,1000000,25);
        assertEquals(  "924 Gilman St 16000.0 1000000.0 25.0", testHouse.toString());

        testHouse = createHouse("929 W Grace St",6000.0,538000.0,4.2);
        assertEquals(  "929 W Grace St 6000.0 538000.0 4.2", testHouse.toString());
    }


    private House createHouse(String aLocation, double aSquareFootage, double aPrice, double aDisToCenter){
        House testHouse = new House();
        Class c = testHouse.getClass();

        try {
            Field location = c.getDeclaredField("location");
            location.setAccessible(true);
            location.set(testHouse, aLocation);

            Field squareFootage = c.getDeclaredField("squareFootage");
            squareFootage.setAccessible(true);
            squareFootage.set(testHouse, aSquareFootage);

            Field price = c.getDeclaredField("price");
            price.setAccessible(true);
            price.set(testHouse, aPrice);

            Field disToCenter = c.getDeclaredField("disToCenter");
            disToCenter.setAccessible(true);
            disToCenter.set(testHouse, aDisToCenter);
            

        } catch (Exception e) {
            fail(e.toString());
        }

        return testHouse;
    }

    private void instanceVariablePrivate(String aField, Object testObject) {
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
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertFalse("Your instance variables must NOT be static.", Modifier.isStatic(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableCorrectType(String aField, Class<?> aClass,  Object testObject) {
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
