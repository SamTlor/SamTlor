package projects.project7;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ArtTest {

    @Test
    public void Art_instanceCountTest(){
        Art testArt = new Art();
        Class c = testArt.getClass();
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
    public void Art_instanceVariablesTest(){
        Art testArt = new Art();
        instanceVariablePrivate("name",testArt);
        instanceVariablePrivate("creator",testArt);
        instanceVariablePrivate("value",testArt);
        instanceVariablePrivate("location",testArt);

        instanceVariableStatic("name",testArt);
        instanceVariableStatic("creator",testArt);
        instanceVariableStatic("value",testArt);
        instanceVariableStatic("location",testArt);

        instanceVariableCorrectType("name", String.class,testArt);
        instanceVariableCorrectType("creator", String.class,testArt);
        instanceVariableCorrectType("value", double.class,testArt);
        instanceVariableCorrectType("location", String.class,testArt);
    }

    @Test
    public void Art_defaultConstructorTest() {
        Art testArt = new Art();

        testVariable("name",testArt,"","When checking the value of name we",0);
        testVariable("creator",testArt,"","When checking the value of creator we",0);
        testVariable("value",testArt,0.0,"When checking the value of value we",0);
        testVariable("location",testArt,"","When checking the value of location we",0);
    }

    @Test
    public void Art_parameterizedConstructorTest() {
        Art testArt = new Art("Campbell’s Soup Cans","Andy Warhol",1204214.0,"1962 W 53rd St");

        testVariable("name",testArt,"Campbell’s Soup Cans","When checking the value of name we",0);
        testVariable("creator",testArt,"Andy Warhol","When checking the value of creator we",0);
        testVariable("value",testArt,1204214.0,"When checking the value of value we",0);
        testVariable("location",testArt,"1962 W 53rd St","When checking the value of location we",0);

    }

    @Test
    public void Art_toStringTest() {
        Art testArt = new Art("Campbell’s Soup Cans","Andy Warhol",1204214.0,"1962 W 53rd St");
        assertEquals(  "Campbell’s Soup Cans Andy Warhol 1204214.0 1962 W 53rd St", testArt.toString());

        testArt = new Art("Autumn Rhythm","Jackson Pollock",2343454.0,"1950 W 53rd St");
        assertEquals(  "Autumn Rhythm Jackson Pollock 2343454.0 1950 W 53rd St", testArt.toString());
    }

    @Test
    public void Art_equalsTest() {
        //new String() is not redundant, it is used to get around String interning.
        Art testArt = createArt(new String("Campbell’s Soup Cans"),new String("Andy Warhol"),1204214.0,new String("1962 W 53rd St"));
        Art testArtClone = createArt(new String("Campbell’s Soup Cans"),new String("Andy Warhol"),1204214.0,new String("1962 W 53rd St"));
        Art testArtOtherClone = createArt(new String("Campbell’s Soup Cans"),new String("Andy Warhol"),1204214.0,new String("1962 W 53rd St"));
        Art otherArt = createArt(new String("Autumn Rhythm"),new String("Jackson Pollock"),2343454.0,new String("1950 W 53rd St"));
        Art thirdArt = createArt(new String("Infinity Mirror Room"),new String("Yayoi Kusama"),1204214.0,new String("1965 W 53rd St"));


        Class c = testArt.getClass();
        //Test if equals takes a parameter of type City and fail them if it does
        try {
            c.getMethod("equals",Art.class);
            fail("Art's equals method should have a single parameter of type Object");
        } catch (NoSuchMethodException ignored) {}

        try {
            Method f = c.getMethod("equals",Object.class);

            //Test given null
            Object nullReference = null;
            assertFalse("When calling Art's equals method with an argument of null, we", (boolean) f.invoke(testArt,nullReference) );

            //Test given a non state object
            assertFalse("When calling Art's equals method with a non Art argument, we", (boolean) f.invoke(testArt,"NotAnArt") );

            //Test given itself //reflexive
            assertTrue("When calling Art's equals method with an argument of itself, we",(boolean) f.invoke(testArt,testArt));

            //Test symmetric (x.equals(y) == y.equals(x)
            assertTrue("Symmetric test. Expected x.equals(y) == y.equals(x), was",(boolean) f.invoke(testArt,testArtClone) && (boolean) f.invoke(testArtClone,testArt));

            //Test transitive (x.equals(y) == y.equals(z) == x.equals(z))
            assertTrue("Transitive test. Expected x.equals(y) == y.equals(z) == x.equals(z), was",
                    (boolean) f.invoke(testArt,testArtClone) ==
                            (boolean) f.invoke(testArtClone,testArtOtherClone) ==
                            (boolean) f.invoke(testArt,testArtOtherClone)
            );

            //Test non equivalent objects
            assertFalse("When calling Art's equals method with an argument a logically different Art, we",(boolean) f.invoke(testArt,otherArt) && (boolean) f.invoke(testArt,thirdArt));

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Art_getNameTest() {
        Art testArt = createArt("Infinity Mirror Room","Yayoi Kusama",1204214.0,"1965 W 53rd St");
        assertEquals("With an Art object who's name instance variable is Infinity Mirror Room, when calling getName we","Infinity Mirror Room",testArt.getName());
    }

    @Test
    public void Art_setNameTest() {
        Art testArt = createArt("Infinity Mirror Room","Yayoi Kusama",1204214.0,"1965 W 53rd St");
        testArt.setName("Keith Haring");
        testVariable("name",testArt,"Keith Haring","After calling Art's setName method with an argument of Keith Haring, for the value of name we",0);
    }

    @Test
    public void Art_getCreatorTest() {
        Art testArt = createArt("Infinity Mirror Room","Yayoi Kusama",1204214.0,"1965 W 53rd St");
        assertEquals("With an Art object who's creator instance variable is Yayoi Kusama, when calling getCreator we","Yayoi Kusama",testArt.getCreator());
    }

    @Test
    public void Art_setCreatorTest() {
        Art testArt = createArt("Infinity Mirror Room","Yayoi Kusama",1204214.0,"1965 W 53rd St");
        testArt.setCreator("Keith Haring");
        testVariable("creator",testArt,"Keith Haring","After calling Art's setCreator method with an argument of Keith Haring, for the value of creator we",0);
    }

    @Test
    public void Art_getValueTest() {
        Art testArt = createArt("Infinity Mirror Room","Yayoi Kusama",1204214.0,"1965 W 53rd St");
        assertEquals("With an Art object who's value instance variable is 1204214.0, when calling getValue we",1204214.0,testArt.getValue(),.001);
    }

    @Test
    public void Art_setValueTest() {
        Art testArt = createArt("Infinity Mirror Room","Yayoi Kusama",1204214.0,"1965 W 53rd St");
        testArt.setValue(1500245.45);
        testVariable("value",testArt,1500245.45,"After calling Art's setValue method with an argument of 1500245.45, for the value of value we",0);
    }

    @Test
    public void Art_getLocationTest() {
        Art testArt = createArt("Infinity Mirror Room","Yayoi Kusama",1204214.0,"1965 W 53rd St");
        assertEquals("With an Art object who's location instance variable is 1965 W 53rd St, when calling getLocation we","1965 W 53rd St",testArt.getLocation());
    }

    @Test
    public void Art_setLocationTest() {
        Art testArt = createArt("Infinity Mirror Room","Yayoi Kusama",1204214.0,"1965 W 53rd St");
        testArt.setLocation("1982 W 53rd St");
        testVariable("location",testArt,"1982 W 53rd St","After calling Art's setLocation method with an argument of 1982 W 53rd St, for the value of location we",0);
    }



    private Art createArt(String aName, String aCreator, double aValue, String aLocation){
        Art testArt = new Art();
        Class c = testArt.getClass();

        try {
            Field name = c.getDeclaredField("name");
            name.setAccessible(true);
            name.set(testArt, aName);

            Field creator = c.getDeclaredField("creator");
            creator.setAccessible(true);
            creator.set(testArt, aCreator);

            Field value = c.getDeclaredField("value");
            value.setAccessible(true);
            value.set(testArt, aValue);

            Field location = c.getDeclaredField("location");
            location.setAccessible(true);
            location.set(testArt, aLocation);


        } catch (Exception e) {
            fail(e.toString());
        }

        return testArt;
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

            assertEquals("Your instance variables must NOT be static.", false,
                    Modifier.isStatic(c.getDeclaredField(aField).getModifiers()));

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

    private void testVariable(String aField, Object testObject, Object expected, String message, int descendantLevel){
        Class c = testObject.getClass();

        for(int i = 0; i < descendantLevel; i++){
            c = c.getSuperclass();
        }

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
                assertEquals(message, doubleExpected, doubleFieldValue, .001);
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
