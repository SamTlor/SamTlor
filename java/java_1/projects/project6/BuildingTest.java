package projects.project6;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

@SuppressWarnings("rawtypes")
public class BuildingTest {

    @Test
    public void Building_instanceCountTest(){
        Building testBuilding = new Building();
        Class c = testBuilding.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables we",
                    5, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void Building_instanceVariablesTest(){
        Building testBuilding = new Building();
        instanceVariablePrivate("location",testBuilding);
        instanceVariablePrivate("owner",testBuilding);
        instanceVariablePrivate("contactPhone",testBuilding);
        instanceVariablePrivate("maxNumberOfUnits",testBuilding);
        instanceVariablePrivate("apartments",testBuilding);

        instanceVariableStatic("location",testBuilding);
        instanceVariableStatic("owner",testBuilding);
        instanceVariableStatic("contactPhone",testBuilding);
        instanceVariableStatic("maxNumberOfUnits",testBuilding);
        instanceVariableStatic("apartments",testBuilding);

        instanceVariableCorrectType("location",String.class,testBuilding);
        instanceVariableCorrectType("owner",String.class,testBuilding);
        instanceVariableCorrectType("contactPhone",String.class,testBuilding);
        instanceVariableCorrectType("maxNumberOfUnits",int.class,testBuilding);
        instanceVariableCorrectType("apartments",ArrayList.class,testBuilding);
    }

    @Test
    public void Building_defaultConstructorTest() {
        Building testBuilding = new Building();

        testVariable("location",testBuilding,"","When checking the value of location we");
        testVariable("owner",testBuilding,"","When checking the value of owner we");
        testVariable("contactPhone",testBuilding,"","When checking the value of contactPhone we");
        testVariable("maxNumberOfUnits",testBuilding,0,"When checking the value of maxNumberOfUnits we");
        testVariable("apartments",testBuilding,new ArrayList<>(),"When checking the value of apartments we");

    }

    @Test
    public void Building_parameterizedConstructorTest() {
        Building testBuilding = new Building("25 Pallet Dr","Red's Mom","81-151-555-3043",2);

        testVariable("location",testBuilding,"25 Pallet Dr","When checking the value of location we");
        testVariable("owner",testBuilding,"Red's Mom","When checking the value of owner we");
        testVariable("contactPhone",testBuilding,"81-151-555-3043","When checking the value of contactPhone we");
        testVariable("maxNumberOfUnits",testBuilding,2,"When checking the value of maxNumberOfUnits we");
        testVariable("apartments",testBuilding,new ArrayList<>(),"When checking the value of apartments we");

    }

    @Test
    public void Building_getLocationTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);
        assertEquals("With a Building object who's location instance variable is Richmond, VA, when calling getLocation we","Richmond, VA",testBuilding.getLocation());
    }

    @Test
    public void Building_setLocationTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);

        testBuilding.setLocation("Boston, MA");
        testVariable("location",testBuilding,"Boston, MA","After calling Building's setLocation method with an argument of Boston, MA, for the value of location we");
    }

    @Test
    public void Building_getOwnerTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);
        assertEquals("With a Building object who's owner instance variable is Zach Sparks, when calling getLocation we","Zach Sparks",testBuilding.getOwner());
    }

    @Test
    public void Building_setOwnerTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);

        testBuilding.setOwner("Samus Aran");
        testVariable("owner",testBuilding,"Samus Aran","After calling Building's setOwner method with an argument of Samus Aran, for the value of owner we");
    }

    @Test
    public void Building_getContactPhoneTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);
        assertEquals("With a Building object who's contactPhone instance variable is 804-555-2112, when calling getContactPhone we","804-555-2112",testBuilding.getContactPhone());
    }

    @Test
    public void Building_setContactPhoneTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);

        testBuilding.setContactPhone("703-555-2003");
        testVariable("contactPhone",testBuilding,"703-555-2003","After calling Building's setContactPhone method with an argument of 703-555-2003, for the value of contactPhone we");
    }

    @Test
    public void Building_getMaxNumberOfUnitsTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);
        assertEquals("With a Building object who's maxNumberOfUnits instance variable is 15, when calling getMaxNumberOfUnits we",15,testBuilding.getMaxNumberOfUnits());
    }

    @Test
    public void Building_setMaxNumberOfUnitsTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);

        testBuilding.setMaxNumberOfUnits(30);
        testVariable("maxNumberOfUnits",testBuilding,30,"After calling Building's setMaxNumberOfUnits method with an argument of 30, for the value of maxNumberOfUnits we");
    }

    @Test
    public void Building_getApartmentsTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        someApartments.add(createApartment(42,1340.05,3000.50,Bedrooms.THREE_BEDROOM,Baths.TWO,Status.OCCUPIED));
        someApartments.add(createApartment(24,440.05,330.50,Bedrooms.STUDIO,Baths.ONE,Status.VACANT));

        ArrayList<Apartment> expectedApartments = new ArrayList<>();
        expectedApartments.add(createApartment(42,1340.05,3000.50,Bedrooms.THREE_BEDROOM,Baths.TWO,Status.OCCUPIED));
        expectedApartments.add(createApartment(24,440.05,330.50,Bedrooms.STUDIO,Baths.ONE,Status.VACANT));

        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);
        testTicketArray("With a Building object who's apartments instance variable is has two elements, when calling getApartments we",expectedApartments,testBuilding.getApartments());
    }

    @Test
    public void Building_getNumApartmentsTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        someApartments.add(createApartment(42,1340.05,3000.50,Bedrooms.THREE_BEDROOM,Baths.TWO,Status.OCCUPIED));
        someApartments.add(createApartment(24,440.05,330.50,Bedrooms.STUDIO,Baths.ONE,Status.VACANT));
        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);
        assertEquals("With a Building object who's apartments instance variable is has two elements, when calling getNumApartments we",2,testBuilding.getNumApartments());
    }

    @Test
    public void Building_addApartmentOneApartmentTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        ArrayList<Apartment> expectedApartment = new ArrayList<>();
        expectedApartment.add(createApartment(75,704.05,900.50,Bedrooms.ONE_BEDROOM,Baths.TWO,Status.OCCUPIED));
        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);
        testBuilding.addApartment(createApartment(75,704.05,900.50,Bedrooms.ONE_BEDROOM,Baths.TWO,Status.OCCUPIED));

        testVariable("apartments",testBuilding,expectedApartment,"With a Building object who's apartments instance variable had zero elements, then calling addApartment once, when checking the apartments instance variable we");
    }

    @Test
    public void Building_addApartmentFourApartmentsTest() {
        ArrayList<Apartment> someApartments = new ArrayList<>();
        ArrayList<Apartment> expectedApartment = new ArrayList<>();
        expectedApartment.add(createApartment(75,704.05,900.50,Bedrooms.ONE_BEDROOM,Baths.TWO,Status.OCCUPIED));
        expectedApartment.add(createApartment(5,1740,540.50,Bedrooms.THREE_BEDROOM,Baths.THREE,Status.OCCUPIED));
        expectedApartment.add(createApartment(6,405,600.50,Bedrooms.STUDIO,Baths.TWO,Status.VACANT));
        expectedApartment.add(createApartment(7,515,700.50,Bedrooms.ONE_BEDROOM,Baths.TWO,Status.VACANT));


        Building testBuilding = createBuilding("Richmond, VA","Zach Sparks","804-555-2112",15,someApartments);
        testBuilding.addApartment(createApartment(75,704.05,900.50,Bedrooms.ONE_BEDROOM,Baths.TWO,Status.OCCUPIED));
        testBuilding.addApartment(createApartment(5,1740,540.50,Bedrooms.THREE_BEDROOM,Baths.THREE,Status.OCCUPIED));
        testBuilding.addApartment(createApartment(6,405,600.50,Bedrooms.STUDIO,Baths.TWO,Status.VACANT));
        testBuilding.addApartment(createApartment(7,515,700.50,Bedrooms.ONE_BEDROOM,Baths.TWO,Status.VACANT));


        testVariable("apartments",testBuilding,expectedApartment,"With a Building object who's apartments instance variable had zero elements, then calling addApartment four times, when checking the apartments instance variable we");
    }

    @Test
    public void Customer_toStringTest() {
        ArrayList<Apartment> someApartment = new ArrayList<>();
        someApartment.add(createApartment(5,1740,540.50,Bedrooms.THREE_BEDROOM,Baths.THREE,Status.OCCUPIED));
        Building testBuilding = createBuilding("Richmond, VA","Zach Whitten","804-555-2112",15,someApartment);


        assertEquals(  "Richmond, VA\n" +
                "Zach Whitten\n" +
                "804-555-2112\n" +
                "15\n" +
                "Apartments:\n" +
                "\n" +
                "\t5\n" +
                "\t1740.0\n" +
                "\t540.5\n" +
                "\tTHREE_BEDROOM\n" +
                "\tTHREE\n" +
                "\tOCCUPIED\n", testBuilding.toString());


        someApartment = new ArrayList<>();

        someApartment.add(createApartment(75,704.05,900.50,Bedrooms.ONE_BEDROOM,Baths.TWO,Status.OCCUPIED));
        someApartment.add(createApartment(5,1740,540.50,Bedrooms.THREE_BEDROOM,Baths.THREE,Status.OCCUPIED));
        someApartment.add(createApartment(6,405,600.50,Bedrooms.STUDIO,Baths.TWO,Status.VACANT));
        someApartment.add(createApartment(7,515,700.50,Bedrooms.ONE_BEDROOM,Baths.TWO,Status.VACANT));

        testBuilding = createBuilding("Albuquerque, NM","Clare Sparks","505-555-2112",45,someApartment);

        assertEquals(  "Albuquerque, NM\n" +
                "Clare Sparks\n" +
                "505-555-2112\n" +
                "45\n" +
                "Apartments:\n" +
                "\n" +
                "\t75\n" +
                "\t704.05\n" +
                "\t900.5\n" +
                "\tONE_BEDROOM\n" +
                "\tTWO\n" +
                "\tOCCUPIED\n" +
                "\n" +
                "\t5\n" +
                "\t1740.0\n" +
                "\t540.5\n" +
                "\tTHREE_BEDROOM\n" +
                "\tTHREE\n" +
                "\tOCCUPIED\n" +
                "\n" +
                "\t6\n" +
                "\t405.0\n" +
                "\t600.5\n" +
                "\tSTUDIO\n" +
                "\tTWO\n" +
                "\tVACANT\n" +
                "\n" +
                "\t7\n" +
                "\t515.0\n" +
                "\t700.5\n" +
                "\tONE_BEDROOM\n" +
                "\tTWO\n" +
                "\tVACANT\n", testBuilding.toString());
    }

    private Building createBuilding(String aLocation, String anOwner, String aContactPhone, int aMaxNumberOfUnits, ArrayList anApartments){
        Building testBuilding = new Building();
        Class c = testBuilding.getClass();

        try {
            Field location = c.getDeclaredField("location");
            location.setAccessible(true);
            location.set(testBuilding, aLocation);

            Field owner = c.getDeclaredField("owner");
            owner.setAccessible(true);
            owner.set(testBuilding, anOwner);

            Field contactPhone = c.getDeclaredField("contactPhone");
            contactPhone.setAccessible(true);
            contactPhone.set(testBuilding, aContactPhone);

            Field maxNumberOfUnits = c.getDeclaredField("maxNumberOfUnits");
            maxNumberOfUnits.setAccessible(true);
            maxNumberOfUnits.set(testBuilding, aMaxNumberOfUnits);

            Field apartments = c.getDeclaredField("apartments");
            apartments.setAccessible(true);
            apartments.set(testBuilding, anApartments);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testBuilding;
    }

    private Apartment createApartment(int aLocationNumber, double aSquareFootage, double aPrice, Bedrooms aBedrooms, Baths aBaths, Status aStatus){
        Apartment testApartment = new Apartment();
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
                //CUSTOM FOR PROJECT6TESTS!!!
                testTicketArray(message,(ArrayList) expected, (ArrayList) fieldValue);
            }
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }

    private void testTicketArray(String message, ArrayList expected, ArrayList actual){
        assertEquals(message + " looked at the size and ",expected.size(),actual.size());

        for(int i = 0; i < expected.size(); i++) {
            if (!ApartmentIsEqual(expected.get(i), actual.get(i))) {
                assertEquals(message, expected, actual);
            }
        }
    }

    private boolean ApartmentIsEqual(Object o1, Object o2){
        Class c = o1.getClass();
        try {
            Field o1FieldLocationNumber = c.getDeclaredField("locationNumber");
            o1FieldLocationNumber.setAccessible(true);
            Object o1locationNumber = o1FieldLocationNumber.get(o1);

            Field o2FieldLocationNumber = c.getDeclaredField("locationNumber");
            o2FieldLocationNumber.setAccessible(true);
            Object o2locationNumber = o2FieldLocationNumber.get(o2);

            Field o1FieldSquareFootage = c.getDeclaredField("squareFootage");
            o1FieldSquareFootage.setAccessible(true);
            Object o1squareFootage = o1FieldSquareFootage.get(o1);

            Field o2FieldSquareFootage = c.getDeclaredField("squareFootage");
            o2FieldSquareFootage.setAccessible(true);
            Object o2squareFootage = o2FieldSquareFootage.get(o2);

            Field o1FieldPrice = c.getDeclaredField("price");
            o1FieldPrice.setAccessible(true);
            Object o1Price = o1FieldPrice.get(o1);

            Field o2FieldPrice = c.getDeclaredField("price");
            o2FieldPrice.setAccessible(true);
            Object o2Price = o2FieldPrice.get(o2);

            Field o1FieldBedrooms = c.getDeclaredField("bedrooms");
            o1FieldBedrooms.setAccessible(true);
            Object o1Bedrooms = o1FieldBedrooms.get(o1);

            Field o2FieldBedrooms = c.getDeclaredField("bedrooms");
            o2FieldBedrooms.setAccessible(true);
            Object o2Bedrooms = o2FieldBedrooms.get(o2);

            Field o1FieldBaths = c.getDeclaredField("baths");
            o1FieldBaths.setAccessible(true);
            Object o1Baths = o1FieldBaths.get(o1);

            Field o2FieldBaths = c.getDeclaredField("baths");
            o2FieldBaths.setAccessible(true);
            Object o2Baths = o2FieldBaths.get(o2);

            Field o1FieldStatus = c.getDeclaredField("status");
            o1FieldStatus.setAccessible(true);
            Object o1Status = o1FieldStatus.get(o1);

            Field o2FieldStatus = c.getDeclaredField("status");
            o2FieldStatus.setAccessible(true);
            Object o2Status = o2FieldStatus.get(o2);

            return  o1locationNumber.equals(o2locationNumber) &&
                    o1squareFootage.equals(o2squareFootage) &&
                    o1Price.equals(o2Price) &&
                    o1Bedrooms.equals(o2Bedrooms) &&
                    o1Baths.equals(o2Baths) &&
                    o1Status.equals(o2Status);


        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }

        return false;
    }

}
