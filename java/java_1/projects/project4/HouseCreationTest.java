package projects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

@SuppressWarnings("rawtypes")
public class HouseCreationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void HouseCreation_findHomesOver20kSquareFootageTest(){
        ArrayList<House> expected = new ArrayList<>();
        expected.add(createHouse("924 Gilman St",16000,1000000,25));
        expected.add(createHouse("708 E Broad St",20000,500000.0,1.2));
        expected.add(createHouse("4320 Hampton Blvd",219330.0,1500000.0,35.7));
        expected.add(createHouse("885 S Main St",20000,1000000.0,50.2));
        ArrayList<House> actual = new ArrayList<>(Arrays.asList(HouseCreation.findHomes(generateHouseArray(),true,15000,"sqFootage")));

        testTicketArray("When checking the output of findHomes we", expected,actual);
    }

    @Test
    public void HouseCreation_findHomesUnder20kSquareFootageTest(){
        ArrayList<House> expected = new ArrayList<>();
        expected.add(createHouse("929 W Grace St",6000.0,538000.0,4.2));
        expected.add(createHouse("815 V St NW",10000.0,250000.0,3.1));
        expected.add(createHouse("901 Wharf St SW",12000,750000.0,5.4));
        expected.add(createHouse("2729 W Broad St",2000,30000.0,6.1));
        expected.add(createHouse("317 Monticello Ave",4000.0,400000,10.3));
        expected.add(createHouse("6 N Laurel St",9000.0,678000.0,2.1));
        expected.add(createHouse("15 Lansdowne St",5000.0,1900000.0,0.4));
        expected.add(createHouse("110 E Main St",5000.0,400000.0,0.2));
        expected.add(createHouse("700 E Main St",15000,800000.0,0.2));
        expected.add(createHouse("100 E Jefferson St",1500.0,100000.0,0.2));
        expected.add(createHouse("620 T St NW",9000.0,688000.0,3.3));
        ArrayList<House> actual = new ArrayList<>(Arrays.asList(HouseCreation.findHomes(generateHouseArray(),false,15000,"sqFootage")));

        testTicketArray("When checking the output of findHomes we", expected,actual);
    }

    @Test
    public void HouseCreation_findHomesUnder750kPriceTest(){
        ArrayList<House> expected = new ArrayList<>();
        expected.add(createHouse("929 W Grace St",6000.0,538000.0,4.2));
        expected.add(createHouse("708 E Broad St",20000,500000.0,1.2));
        expected.add(createHouse("815 V St NW",10000.0,250000.0,3.1));
        expected.add(createHouse("901 Wharf St SW",12000,750000.0,5.4));
        expected.add(createHouse("2729 W Broad St",2000,30000.0,6.1));
        expected.add(createHouse("317 Monticello Ave",4000.0,400000,10.3));
        expected.add(createHouse("6 N Laurel St",9000.0,678000.0,2.1));
        expected.add(createHouse("110 E Main St",5000.0,400000.0,0.2));
        expected.add(createHouse("100 E Jefferson St",1500.0,100000.0,0.2));
        expected.add(createHouse("620 T St NW",9000.0,688000.0,3.3));
        ArrayList<House> actual = new ArrayList<>(Arrays.asList(HouseCreation.findHomes(generateHouseArray(),false,750000,"price")));
        testTicketArray("When checking the output of findHomes we", expected,actual);
    }

    @Test
    public void HouseCreation_findHomesOver750kPriceTest(){
        ArrayList<House> expected = new ArrayList<>();
        expected.add(createHouse("924 Gilman St",16000,1000000,25));
        expected.add(createHouse("4320 Hampton Blvd",219330.0,1500000.0,35.7));
        expected.add(createHouse("15 Lansdowne St",5000.0,1900000.0,0.4));
        expected.add(createHouse("885 S Main St",20000,1000000.0,50.2));
        expected.add(createHouse("700 E Main St",15000,800000.0,0.2));
        ArrayList<House> actual = new ArrayList<>(Arrays.asList(HouseCreation.findHomes(generateHouseArray(),true,750000,"price")));
        testTicketArray("When checking the output of findHomes we", expected,actual);
    }

    @Test
    public void HouseCreation_findHomesUnder10DisToCenterTest(){
        ArrayList<House> expected = new ArrayList<>();
        expected.add(createHouse("929 W Grace St",6000.0,538000.0,4.2));
        expected.add(createHouse("708 E Broad St",20000,500000.0,1.2));
        expected.add(createHouse("815 V St NW",10000.0,250000.0,3.1));
        expected.add(createHouse("901 Wharf St SW",12000,750000.0,5.4));
        expected.add(createHouse("2729 W Broad St",2000,30000.0,6.1));
        expected.add(createHouse("6 N Laurel St",9000.0,678000.0,2.1));
        expected.add(createHouse("15 Lansdowne St",5000.0,1900000.0,0.4));
        expected.add(createHouse("110 E Main St",5000.0,400000.0,0.2));
        expected.add(createHouse("700 E Main St",15000,800000.0,0.2));
        expected.add(createHouse("100 E Jefferson St",1500.0,100000.0,0.2));
        expected.add(createHouse("620 T St NW",9000.0,688000.0,3.3));
        ArrayList<House> actual = new ArrayList<>(Arrays.asList(HouseCreation.findHomes(generateHouseArray(),false,10,"distance")));
        testTicketArray("When checking the output of findHomes we", expected,actual);
    }

    @Test
    public void HouseCreation_findHomesOver10DisToCenterTest(){
        ArrayList<House> expected = new ArrayList<>();
        expected.add(createHouse("924 Gilman St",16000,1000000,25));
        expected.add(createHouse("4320 Hampton Blvd",219330.0,1500000.0,35.7));
        expected.add(createHouse("317 Monticello Ave",4000.0,400000,10.3));
        expected.add(createHouse("885 S Main St",20000,1000000.0,50.2));
        ArrayList<House> actual = new ArrayList<>(Arrays.asList(HouseCreation.findHomes(generateHouseArray(),true,10,"distance")));
        testTicketArray("When checking the output of findHomes we", expected,actual);
    }

    @Test
    public void HouseCreation_findHomesInvalidProprietyTest(){
        ArrayList<House> expected = new ArrayList<>();
        ArrayList<House> actual = new ArrayList<>(Arrays.asList(HouseCreation.findHomes(generateHouseArray(),true,10,"")));
        testTicketArray("When checking the output of findHomes we", expected,actual);
        actual = new ArrayList<>(Arrays.asList(HouseCreation.findHomes(generateHouseArray(),true,10,"location")));
        testTicketArray("When checking the output of findHomes we", expected,actual);
        actual = new ArrayList<>(Arrays.asList(HouseCreation.findHomes(generateHouseArray(),true,10,"true")));
        testTicketArray("When checking the output of findHomes we", expected,actual);
    }

    @Test
    public void HouseCreation_findHomesEmptyHousesArrayTest(){
        ArrayList<House> expected = new ArrayList<>();
        ArrayList<House> actual = new ArrayList<>(Arrays.asList(HouseCreation.findHomes(new House[0],true,10,"price")));
        testTicketArray("When checking the output of findHomes we", expected,actual);
    }

    @Test
    public void HouseCreation_displayHousesTest(){
        HouseCreation.displayHouses(generateHouseArray());
        String[] actual = outContent.toString().split(System.lineSeparator());
        String[] expected = new String[] {"924 Gilman St 16000.0 1000000.0 25.0","929 W Grace St 6000.0 538000.0 4.2","708 E Broad St 20000.0 500000.0 1.2","815 V St NW 10000.0 250000.0 3.1","901 Wharf St SW 12000.0 750000.0 5.4","2729 W Broad St 2000.0 30000.0 6.1","4320 Hampton Blvd 219330.0 1500000.0 35.7","317 Monticello Ave 4000.0 400000.0 10.3","6 N Laurel St 9000.0 678000.0 2.1","15 Lansdowne St 5000.0 1900000.0 0.4","885 S Main St 20000.0 1000000.0 50.2","110 E Main St 5000.0 400000.0 0.2","700 E Main St 15000.0 800000.0 0.2","100 E Jefferson St 1500.0 100000.0 0.2","620 T St NW 9000.0 688000.0 3.3"};
        assertArrayEquals("When checking the output of displayHouses",expected,actual);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    private House[] generateHouseArray(){
        return new House[]{createHouse("924 Gilman St",16000,1000000,25),
               createHouse("929 W Grace St",6000.0,538000.0,4.2),
               createHouse("708 E Broad St",20000,500000.0,1.2),
               createHouse("815 V St NW",10000.0,250000.0,3.1),
               createHouse("901 Wharf St SW",12000,750000.0,5.4),
               createHouse("2729 W Broad St",2000,30000.0,6.1),
               createHouse("4320 Hampton Blvd",219330.0,1500000.0,35.7),
               createHouse("317 Monticello Ave",4000.0,400000,10.3),
               createHouse("6 N Laurel St",9000.0,678000.0,2.1),
               createHouse("15 Lansdowne St",5000.0,1900000.0,0.4),
               createHouse("885 S Main St",20000,1000000.0,50.2),
               createHouse("110 E Main St",5000.0,400000.0,0.2),
               createHouse("700 E Main St",15000,800000.0,0.2),
               createHouse("100 E Jefferson St",1500.0,100000.0,0.2),
               createHouse("620 T St NW",9000.0,688000.0,3.3)};
    }

    private void testTicketArray(String message, ArrayList expected, ArrayList actual){
        assertEquals(message + " looked at the size and ", expected.size(), actual.size());

        for (Object o : expected) {
            boolean contains = false;
            for (Object value : actual) {
                if (HouseIsEqual(o, value)) {
                    contains = true;
                }
            }
            if (!contains) {
                fail(message + " expected " + o.toString() + " to be in the returned collection but could not find it");
            }
        }
    }

    private boolean HouseIsEqual(Object o1, Object o2){
        Class c = o1.getClass();
        try {
            Field o1FieldLocation = c.getDeclaredField("location");
            o1FieldLocation.setAccessible(true);
            Object o1location = o1FieldLocation.get(o1);

            Field o2FieldLocation = c.getDeclaredField("location");
            o2FieldLocation.setAccessible(true);
            Object o2location = o2FieldLocation.get(o2);

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

            Field o1FieldDisToCenter = c.getDeclaredField("disToCenter");
            o1FieldDisToCenter.setAccessible(true);
            Object o1DisToCenter = o1FieldDisToCenter.get(o1);

            Field o2FieldDisToCenter = c.getDeclaredField("disToCenter");
            o2FieldDisToCenter.setAccessible(true);
            Object o2DisToCenter = o2FieldDisToCenter.get(o2);

            return  o1location.equals(o2location) &&
                    o1squareFootage.equals(o2squareFootage) &&
                    o1Price.equals(o2Price) &&
                    o1DisToCenter.equals(o2DisToCenter);


        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }

        return false;
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

}
