package project4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

public class HouseDataTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }


    double[] squareFootage = {2634.23,2434.67,2790.53,5893.12,3490,2355.78,7900,4356.54};
    double[] assessedPrice = {90456.78,345678.23,892274.90,804392.43,784211.47,823757.02,1453897.44,342190.65};
    double[] disToCenter = {6.4,7.3,1.9,7.9,1.2,3.9,7.5,10.7};
    String[] locations = {"304 Oak Ave","209 Main Dr","27 River St","65 Park Pl","21 Yew Rd","52 Franklin Dr","100 Baltic Ave","200 Maple Dr"};

    double[] newSquareFootage = {6330.01,4589.59,8066.68,3566.37,6603.78,8234.77,4947.55,7263.94};
    double[] newAssessedPrice = {60582.70,72583.18,25530.51,61319.31,43982.57,61139.03,34399.97,5920.41};
    double[] newDisToCenter = {1.6,7.5,4.4,9.6,3.9,9.5,5.1,5.4};
    String[] newLocations = {"304 Fuchsia Ave","29 Saffron Dr","27 Cinnabar St","65 Vermilion Pl","21 Lavender Rd","52 Goldenrod Dr","100 Celadon Ave","151 Pallet Dr"};


    @Test
    public void calcAvgGivenDataTest(){
        double[] squareFootage = {2634.23,2434.67,2790.53,5893.12,3490,2355.78,7900,4356.54};
        double actual = HouseData.calcAvg(squareFootage);
        double expected = 3981.8587;
        assertEquals("When checking the result of calcAvg we",expected,actual,.001);
    }

    @Test
    public void calcAvgUnknownDataTest(){
        double[] newSquareFootage = {6330.01,4589.59,8066.68,3566.37,6603.78,8234.77,4947.55,7263.94};
        double actual = HouseData.calcAvg(newSquareFootage);
        double expected = 6200.3362;
        assertEquals("When checking the result of calcAvg we",expected,actual,.001);
    }

    @Test
    public void findHighestGivenDataTest(){
        double[] assessedPrice = {90456.78,345678.23,892274.90,804392.43,784211.47,823757.02,1453897.44,342190.65};
        double actual = HouseData.findHighest(assessedPrice);
        double expected = 1453897.44;
        assertEquals("When checking the result of findHighest we",expected,actual,.001);
    }

    @Test
    public void findHighestUnknownDataTest(){
        double[] newAssessedPrice = {60582.70,72583.18,25530.51,61319.31,43982.57,61139.03,34399.97,5920.41};
        double actual = HouseData.findHighest(newAssessedPrice);
        double expected = 72583.18;
        assertEquals("When checking the result of findHighest we",expected,actual,.001);
    }

    @Test
    public void findLowestGivenDataTest(){
        double[] disToCenter = {6.4,7.3,1.9,7.9,1.2,3.9,7.5,10.7};
        double actual = HouseData.findLowest(disToCenter);
        double expected = 1.2;
        assertEquals("When checking the result of findLowest we",expected,actual,.001);
    }

    @Test
    public void findLowestUnknownDataTest(){
        double[] newDisToCenter = {1.6,7.5,4.4,9.6,3.9,9.5,5.1,5.4};
        double actual = HouseData.findLowest(newDisToCenter);
        double expected = 1.6;
        assertEquals("When checking the result of findLowest we",expected,actual,.001);
    }

    @Test
    public void findHighestValuesGivenDataTest(){
        double[] squareFootage = {2634.23,2434.67,2790.53,5893.12,3490,2355.78,7900,4356.54};
        String[] locations = {"304 Oak Ave","209 Main Dr","27 River St","65 Park Pl","21 Yew Rd","52 Franklin Dr","100 Baltic Ave","200 Maple Dr"};
        String[] actual = HouseData.findHighestValues(locations,squareFootage);
        String[] expected = {"100 Baltic Ave","65 Park Pl","200 Maple Dr"};
        assertTrue("When checking the result of findHighestValues we expected the resulting array to contain \"100 Baltic Ave\"",Arrays.asList(actual).contains(expected[0]));
        assertTrue("When checking the result of findHighestValues we expected the resulting array to contain \"65 Park Pl\"",Arrays.asList(actual).contains(expected[1]));
        assertTrue("When checking the result of findHighestValues we expected the resulting array to contain \"200 Maple Dr\"",Arrays.asList(actual).contains(expected[2]));
    }

    @Test
    public void findHighestValuesUnknownDataTest(){
        double[] newSquareFootage = {6330.01,4589.59,8066.68,3566.37,6603.78,8234.77,4947.55,7263.94};
        String[] newLocations = {"304 Fuchsia Ave","29 Saffron Dr","27 Cinnabar St","65 Vermilion Pl","21 Lavender Rd","52 Goldenrod Dr","100 Celadon Ave","151 Pallet Dr"};
        String[] actual = HouseData.findHighestValues(newLocations,newSquareFootage);
        String[] expected = {"151 Pallet Dr","27 Cinnabar St","52 Goldenrod Dr"};
        assertTrue("When checking the result of findHighestValues we expected the resulting array to contain \"151 Pallet Dr\"",Arrays.asList(actual).contains(expected[0]));
        assertTrue("When checking the result of findHighestValues we expected the resulting array to contain \"27 Cinnabar St\"",Arrays.asList(actual).contains(expected[1]));
        assertTrue("When checking the result of findHighestValues we expected the resulting array to contain \"52 Goldenrod Dr\"",Arrays.asList(actual).contains(expected[2]));
    }

    @Test
    public void findLowestValuesGivenDataTest(){
        double[] disToCenter = {6.4,7.3,1.9,7.9,1.2,3.9,7.5,10.7};
        String[] locations = {"304 Oak Ave","209 Main Dr","27 River St","65 Park Pl","21 Yew Rd","52 Franklin Dr","100 Baltic Ave","200 Maple Dr"};
        String[] actual = HouseData.findLowestValues(locations,disToCenter);
        String[] expected = {"21 Yew Rd","27 River St","52 Franklin Dr"};
        assertTrue("When checking the result of findLowestValues we expected the resulting array to contain \"21 Yew Rd\"",Arrays.asList(actual).contains(expected[0]));
        assertTrue("When checking the result of findLowestValues we expected the resulting array to contain \"27 River St\"",Arrays.asList(actual).contains(expected[1]));
        assertTrue("When checking the result of findLowestValues we expected the resulting array to contain \"52 Franklin Dr\"",Arrays.asList(actual).contains(expected[2]));
    }

    @Test
    public void findLowestValuesUnknownDataTest(){
        double[] newDisToCenter = {1.6,7.5,4.4,9.6,3.9,9.5,5.1,5.4};
        String[] newLocations = {"304 Fuchsia Ave","29 Saffron Dr","27 Cinnabar St","65 Vermilion Pl","21 Lavender Rd","52 Goldenrod Dr","100 Celadon Ave","151 Pallet Dr"};
        String[] actual = HouseData.findHighestValues(newLocations,newDisToCenter);
        String[] expected = {"29 Saffron Dr","52 Goldenrod Dr","65 Vermilion Pl"};
        assertTrue("When checking the result of findLowestValues we expected the resulting array to contain \"29 Saffron Dr\"",Arrays.asList(actual).contains(expected[0]));
        assertTrue("When checking the result of findLowestValues we expected the resulting array to contain \"52 Goldenrod Dr\"",Arrays.asList(actual).contains(expected[1]));
        assertTrue("When checking the result of findLowestValues we expected the resulting array to contain \"65 Vermilion Pl\"",Arrays.asList(actual).contains(expected[2]));
    }

    @Test
    public void verifyHouseLocationGivenDataTest(){
        String[] locations = {"304 Oak Ave","209 Main Dr","27 River St","65 Park Pl","21 Yew Rd","52 Franklin Dr","100 Baltic Ave","200 Maple Dr"};
        boolean actual = HouseData.verifyHouseLocation(locations,"27 River St");
        assertTrue("When checking the result of verifyHouseLocation the given array contained \"27 River St\" and should return true",actual);

        actual = HouseData.verifyHouseLocation(locations,"1600 Pennsylvania Ave");
        assertFalse("When checking the result of verifyHouseLocation the given array does not contain \"1600 Pennsylvania Ave\" and should return false",actual);

    }

    @Test
    public void verifyHouseLocationUnknownDataTest(){
        String[] newLocations = {"304 Fuchsia Ave","29 Saffron Dr","27 Cinnabar St","65 Vermilion Pl","21 Lavender Rd","52 Goldenrod Dr","100 Celadon Ave","151 Pallet Dr"};
        boolean actual = HouseData.verifyHouseLocation(newLocations,"304 Fuchsia Ave");
        assertTrue("When checking the result of verifyHouseLocation the given array contained \"304 Fuchsia Ave\" and should return true",actual);

        actual = HouseData.verifyHouseLocation(newLocations,"1 Victory Rd");
        assertFalse("When checking the result of verifyHouseLocation the given array does not contain \"1 Victory Rd\" and should return false",actual);
    }

    @Test
    public void mainMethodValidCity(){
        String input = "65 Park Pl";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HouseData.main(null);
        String[] rawOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("When checking the first line of output we","The average square footage is: 3981.86",rawOutput[0].trim());
        assertEquals("When checking the second line of output we","The average assessed price is: 692107.37",rawOutput[1].trim());
        assertEquals("When checking the third line of output we","The highest assessed price is: 1453897.44",rawOutput[2].trim());
        assertEquals("When checking the fourth line of output we","The lowest distance is: 1.20",rawOutput[3].trim());
        assertEquals("When checking the fifth line of output we","The highest three square footage houses are:",rawOutput[4].trim());
        assertEquals("When checking the sixth line of output we","100 Baltic Ave",rawOutput[5].trim());
        assertEquals("When checking the seventh line of output we","65 Park Pl",rawOutput[6].trim());
        assertEquals("When checking the eighth line of output we","200 Maple Dr",rawOutput[7].trim());
        assertEquals("When checking the ninth line of output we","The lowest three distances are:",rawOutput[8].trim());
        assertEquals("When checking the tenth line of output we","21 Yew Rd",rawOutput[9].trim());
        assertEquals("When checking the eleventh line of output we","27 River St",rawOutput[10].trim());
        assertEquals("When checking the twelfth line of output we","52 Franklin Dr",rawOutput[11].trim());
        assertEquals("When checking the thirteenth line of output we","Enter the city:",rawOutput[12].trim());

        assertEquals("When checking the fourteenth line of output we","65 Park Pl is a house in the array.",rawOutput[13].trim());
    }

    @Test
    public void mainMethodInvalidCity(){
        String input = "980 Harrison St";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HouseData.main(null);
        String[] rawOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("When checking the first line of output we","The average square footage is: 3981.86",rawOutput[0].trim());
        assertEquals("When checking the second line of output we","The average assessed price is: 692107.37",rawOutput[1].trim());
        assertEquals("When checking the third line of output we","The highest assessed price is: 1453897.44",rawOutput[2].trim());
        assertEquals("When checking the fourth line of output we","The lowest distance is: 1.20",rawOutput[3].trim());
        assertEquals("When checking the fifth line of output we","The highest three square footage houses are:",rawOutput[4].trim());
        assertEquals("When checking the sixth line of output we","100 Baltic Ave",rawOutput[5].trim());
        assertEquals("When checking the seventh line of output we","65 Park Pl",rawOutput[6].trim());
        assertEquals("When checking the eighth line of output we","200 Maple Dr",rawOutput[7].trim());
        assertEquals("When checking the ninth line of output we","The lowest three distances are:",rawOutput[8].trim());
        assertEquals("When checking the tenth line of output we","21 Yew Rd",rawOutput[9].trim());
        assertEquals("When checking the eleventh line of output we","27 River St",rawOutput[10].trim());
        assertEquals("When checking the twelfth line of output we","52 Franklin Dr",rawOutput[11].trim());
        assertEquals("When checking the thirteenth line of output we","Enter the city:",rawOutput[12].trim());

        assertEquals("When checking the fourteenth line of output we","980 Harrison St is not a house in the array.",rawOutput[13].trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


}
