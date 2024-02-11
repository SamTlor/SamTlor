package projects.project7;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.*;

@SuppressWarnings("rawtypes")
public class ArtAnalysisTest {


    @Rule
    public TemporaryFolder folder = new TemporaryFolder();


    @Test
    public void ArtAnalysis_GoodData_readFileTest() throws IOException {
        // Invoke method
        ArrayList<String> actual = ArtAnalysis.readFile(generateGoodInputFile());
        // Check results
        testStringArray("When checking the String array returned from the readFile method given a file with valid input data, we",generateGoodInputStringArray(),actual);
    }

    @Test
    public void ArtAnalysis_GoodData_parseDataTest(){
        ArrayList<Art> actual = ArtAnalysis.parseData(generateGoodInputStringArray());
        testArtArray("When checking the ArrayList returned from the parseData method given data generated from ArtGoodData.txt, we",generateGoodInputArrayList(),actual);
    }

    @Test
    public void ArtAnalysis_GoodData_calcValueAvgTest(){
        double actual = ArtAnalysis.calcValueAvg(generateGoodInputArrayList());
        assertEquals("When checking the return value from the calcValueAvg method given data generated from ArtGoodData.txt, we",82369486.43125,actual,0.01);
    }

    @Test
    public void ArtAnalysis_GoodData_findHighValueTest(){
        double actual = ArtAnalysis.findHighValue(generateGoodInputArrayList());
        assertEquals("When checking the return value from the findHighValue method given data generated from ArtGoodData.txt, we",348900000.0,actual,0.01);
    }

    @Test
    public void ArtAnalysis_GoodData_findHighestArtByValueTest(){
        //testArtArray
        ArrayList<Art> actual = ArtAnalysis.findHighestArtByValue(generateGoodInputArrayList(),25000000.0);
        ArrayList<Art> expected = generateGoodInputArrayList();
        expected.remove(4);expected.remove(3);expected.remove(1);expected.remove(0);
        testStringArray("When checking the return value from the findHighestArtByValue method given data generated from ArtGoodData.txt, we",expected,actual);
    }

    @Test
    public void ArtAnalysis_GoodData_findArtTest(){
        boolean actual = ArtAnalysis.findArt(generateGoodInputArrayList(),createArt("David","Donatello",41642723.44,"823 Harlow St"));

        assertTrue("When checking the return value from the findArt method given data generated from ArtGoodData.txt and a valid Art object, we",actual);

        actual = ArtAnalysis.findArt(generateGoodInputArrayList(),createArt("Untitled","Jean-Michel Basquiat",2000000.24,"1981 W 53rd St"));

        assertFalse("When checking the return value from the findArt method given data generated from ArtGoodData.txt and an invalid Art object, we",actual);


    }

    @Test
    public void ArtAnalysis_GoodData_writeOutArtDataTest() throws IOException {
        File outputFile = folder.newFile("bar.txt");
        PrintWriter outWriter = new PrintWriter(outputFile);
        ArrayList<Art> outputData = generateGoodInputArrayList();
        ArrayList<Art> expected = generateGoodInputArrayList();
        String message = "Hello World: ";
        // Invoke method
        ArtAnalysis.writeOutData(message,outputData,outWriter);
        outWriter.flush();outWriter.close();
        // Check results
        assertTrue("Output file does not exist", outputFile.exists());
        Scanner outputScan = new Scanner(outputFile);

        int i = 0;

        assertEquals("When checking the output file produced by writeOutData given an ArrayList<Art> of good data, at line " +(i+1)+ " we",message,outputScan.nextLine());

        while (outputScan.hasNextLine()){
            String expectedString = "";
            if(i < expected.size()){
                expectedString = expected.get(i).toString();
            }
            assertEquals("When checking the output file produced by writeOutData given an ArrayList<Art> of good data, at line " +(i+2)+ " we",expectedString,outputScan.nextLine().trim());
            i++;
        }
        outputScan.close();
    }

    @Test
    public void ArtAnalysis_GoodData_writeOutDoubleDataTest() throws IOException {
        File outputFile = folder.newFile("bar.txt");
        PrintWriter outWriter = new PrintWriter(outputFile);
        String message = "This is a message: ";
        // Invoke method
        ArtAnalysis.writeOutData(message,100.7564829,outWriter);
        ArtAnalysis.writeOutData(message,256.7544829,outWriter);
        outWriter.flush();outWriter.close();
        // Check results
        assertTrue("Output file does not exist", outputFile.exists());
        Scanner outputScan = new Scanner(outputFile);
        int i = 1;
        try {
            assertEquals("When checking the output file produced by writeOutData given a String message and double value, at line 1 we", message + "100.76", outputScan.nextLine());i++;
            assertEquals("When checking the output file produced by writeOutData given a String message and double value, at line 2 we", "", outputScan.nextLine());i++;

            assertEquals("When checking the output file produced by calling writeOutData a second time given a String message and double value, at line 3 we", message + "256.75", outputScan.nextLine());i++;
            assertEquals("When checking the output file produced by calling writeOutData a second time given a String message and double value, at line 4 we", "", outputScan.nextLine());
        }
        catch (NoSuchElementException e){
            fail("Line " + i + " does not exist but it should");
        }

        outputScan.close();
    }

    @Test
    public void ArtAnalysis_GoodData_writeOutBooleanDataTest() throws IOException {
        File outputFile = folder.newFile("bar.txt");
        PrintWriter outWriter = new PrintWriter(outputFile);
        String message = "This is a message: ";
        // Invoke method
        ArtAnalysis.writeOutData(message,true,outWriter);
        ArtAnalysis.writeOutData(message,false,outWriter);
        outWriter.flush();outWriter.close();
        // Check results
        assertTrue("Output file does not exist", outputFile.exists());
        Scanner outputScan = new Scanner(outputFile);
        int i = 1;
        try {
            assertEquals("When checking the output file produced by writeOutData given a String message and double value, at line 1 we", message + "true", outputScan.nextLine());i++;
            assertEquals("When checking the output file produced by writeOutData given a String message and double value, at line 2 we", "", outputScan.nextLine());i++;

            assertEquals("When checking the output file produced by calling writeOutData a second time given a String message and double value, at line 3 we", message + "false", outputScan.nextLine());i++;
            assertEquals("When checking the output file produced by calling writeOutData a second time given a String message and double value, at line 4 we", "", outputScan.nextLine());
        }
        catch (NoSuchElementException e){
            fail("Line " + i + " does not exist but it should");
        }

        outputScan.close();
    }

    @Test
    public void ArtAnalysis_GoodData_mainMethod(){
        try{
            File outputFile = folder.newFile("bar.txt");
            ArtAnalysis.main(new String[]{generateGoodInputFile().getAbsolutePath(),outputFile.getAbsolutePath()});

            // Check results
            assertTrue("Output file does not exist", outputFile.exists());
            Scanner outputScan = new Scanner(outputFile);
            int i = 1;
            try {
                assertEquals("When checking the output file produced by writeOutData given a String message and double value, at line 1 we", "The average value is: 82369486.43", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given good data, at line 2 we", "", outputScan.nextLine());i++;

                assertEquals("When checking the output file produced by calling the main method given good data, at line 3 we", "The highest value is: 348900000.00", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given good data, at line 4 we", "", outputScan.nextLine());i++;

                assertEquals("When checking the output file produced by calling the main method given good data, at line 5 we", "The art above the average value are: ", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given good data, at line 6 we", "\tTerracotta Warriors Xi'an sculptor 3.489E8 17823 Poplar Dr", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given good data, at line 7 we", "\tVenus de Milo Greek sculptor 2.105656545E8 943 Key Ave", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given good data, at line 8 we", "", outputScan.nextLine());i++;

                assertEquals("When checking the output file produced by calling the main method given good data, at line 9 we", "Is David by Donatello in the data? true", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given good data, at line 10 we", "", outputScan.nextLine());

            }
            catch (NoSuchElementException e){
                fail("Line " + i + " does not exist but it should");
            }

            outputScan.close();

        } catch (IOException e) { e.printStackTrace(); }

    }




    @Test
    public void ArtAnalysis_BadData_readFileTest() throws IOException {
        // Invoke method
        ArrayList<String> actual = ArtAnalysis.readFile(generateBadInputFile());
        // Check results
        testStringArray("When checking the String array returned from the readFile method given a file with invalid input data, we",generateBadInputStringArray(),actual);
    }

    @Test
    public void ArtAnalysis_BadData_parseDataTest(){
        ArrayList<Art> actual = ArtAnalysis.parseData(generateBadInputStringArray());
        testArtArray("When checking the ArrayList returned from the parseData method given data generated from ArtBadData.txt, we",generateBadInputArrayList(),actual);
    }

    @Test
    public void ArtAnalysis_BadData_calcValueAvgTest(){
        double actual = ArtAnalysis.calcValueAvg(generateBadInputArrayList());
        assertEquals("When checking the return value from the calcValueAvg method given data generated from ArtBadData.txt, we",32166629.1,actual,0.01);
    }

    @Test
    public void ArtAnalysis_BadData_findHighValueTest(){
        double actual = ArtAnalysis.findHighValue(generateBadInputArrayList());
        assertEquals("When checking the return value from the findHighValue method given data generated from ArtBadData.txt, we",210565654.5,actual,0.01);
    }

    @Test
    public void ArtAnalysis_BadData_findHighestArtByValueTest(){
        //testArtArray
        ArrayList<Art> actual = ArtAnalysis.findHighestArtByValue(generateBadInputArrayList(),25000000.0);
        ArrayList<Art> expected = generateBadInputArrayList();
        expected.remove(7);expected.remove(4);expected.remove(3);expected.remove(2);expected.remove(1);expected.remove(0);
        testStringArray("When checking the return value from the findHighestArtByValue method given data generated from ArtBadData.txt, we",expected,actual);
    }

    @Test
    public void ArtAnalysis_BadData_findArtTest(){
        boolean actual = ArtAnalysis.findArt(generateBadInputArrayList(),createArt("Nike Of Samothrace","Greek sculptor",0,"34 Cary Dr"));

        assertTrue("When checking the return value from the findArt method given data generated from ArtGoodData.txt and a valid Art object, we",actual);

        actual = ArtAnalysis.findArt(generateBadInputArrayList(),createArt("Untitled","Jean-Michel Basquiat",2000000.24,"1981 W 53rd St"));

        assertFalse("When checking the return value from the findArt method given data generated from ArtGoodData.txt and an invalid Art object, we",actual);


    }

    @Test
    public void ArtAnalysis_BadData_writeOutArtDataTest() throws IOException {
        File outputFile = folder.newFile("bar.txt");
        PrintWriter outWriter = new PrintWriter(outputFile);
        ArrayList<Art> outputData = generateBadInputArrayList();
        ArrayList<Art> expected = generateBadInputArrayList();
        String message = "Hello World: ";
        // Invoke method
        ArtAnalysis.writeOutData(message,outputData,outWriter);
        outWriter.flush();outWriter.close();
        // Check results
        assertTrue("Output file does not exist", outputFile.exists());
        Scanner outputScan = new Scanner(outputFile);

        int i = 0;

        assertEquals("When checking the output file produced by writeOutData given an ArrayList<Art> of good data, at line " +(i+1)+ " we",message,outputScan.nextLine());

        while (outputScan.hasNextLine()){
            String expectedString = "";
            if(i < expected.size()){
                expectedString = expected.get(i).toString();
            }
            assertEquals("When checking the output file produced by writeOutData given an ArrayList<Art> of good data, at line " +(i+2)+ " we",expectedString,outputScan.nextLine().trim());
            i++;
        }
        outputScan.close();
    }

    @Test
    public void ArtAnalysis_BadData_mainMethod(){
        try{
            File outputFile = folder.newFile("bar.txt");
            ArtAnalysis.main(new String[]{generateBadInputFile().getAbsolutePath(),outputFile.getAbsolutePath()});

            // Check results
            assertTrue("Output file does not exist", outputFile.exists());
            Scanner outputScan = new Scanner(outputFile);
            int i = 1;
            try {
                assertEquals("When checking the output file produced by writeOutData given a String message and double value, at line 1 we", "The average value is: 32166629.10", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given bad data, at line 2 we", "", outputScan.nextLine());i++;

                assertEquals("When checking the output file produced by calling the main method given bad data, at line 3 we", "The highest value is: 210565654.50", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given bad data, at line 4 we", "", outputScan.nextLine());i++;

                assertEquals("When checking the output file produced by calling the main method given bad data, at line 5 we", "The art above the average value are: ", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given bad data, at line 6 we", "\tVenus de Milo Greek sculptor 2.105656545E8 943 Key Ave", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given bad data, at line 7 we", "\tDavid Donatello 4.164272344E7 823 Harlow St", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given bad data, at line 8 we", "", outputScan.nextLine());i++;

                assertEquals("When checking the output file produced by calling the main method given bad data, at line 9 we", "Is David by Donatello in the data? true", outputScan.nextLine());i++;
                assertEquals("When checking the output file produced by calling the main method given bad data, at line 10 we", "", outputScan.nextLine());

            }
            catch (NoSuchElementException e){
                fail("Line " + i + " does not exist but it should");
            }

            outputScan.close();

        } catch (IOException e) { e.printStackTrace(); }

    }




    private File generateGoodInputFile() throws IOException {
        final String INPUT_FILENAME = "foo.txt";
        File inputFile = folder.newFile(INPUT_FILENAME);
        PrintWriter write = new PrintWriter(inputFile);
        write.print("Venus of Willendorf\tUnknown\t78945.00\t5th and Main Ave\n" +
                "Nefertiti\tThutmose\t459787.88\t27 Vine St\n" +
                "Terracotta Warriors\tXi'an sculptor\t348900000.00\t17823 Poplar Dr\n" +
                "Laocoön and His Sons\tGreek sculptor\t4664866.98\t5674 Pine Ave\n" +
                "Nike Of Samothrace\tGreek sculptor\t22949367.88 \t34 Cary Dr\n" +
                "Venus de Milo\tGreek sculptor\t210565654.5\t943 Key Ave\n" +
                "David\tDonatello\t41642723.44\t823 Harlow St\n" +
                "The Thinker\tAuguste Rodin\t29694545.77\t732 Sever Ln");
        write.close();
        return inputFile;
    }

    private ArrayList<String> generateGoodInputStringArray(){
        String[] array = {"Venus of Willendorf\tUnknown\t78945.00\t5th and Main Ave",
                "Nefertiti\tThutmose\t459787.88\t27 Vine St",
                "Terracotta Warriors\tXi'an sculptor\t348900000.00\t17823 Poplar Dr",
                "Laocoön and His Sons\tGreek sculptor\t4664866.98\t5674 Pine Ave",
                "Nike Of Samothrace\tGreek sculptor\t22949367.88 \t34 Cary Dr",
                "Venus de Milo\tGreek sculptor\t210565654.5\t943 Key Ave",
                "David\tDonatello\t41642723.44\t823 Harlow St",
                "The Thinker\tAuguste Rodin\t29694545.77\t732 Sever Ln"};
        ArrayList<String> toReturn = new ArrayList<>();
        Collections.addAll(toReturn, array);
        return toReturn;
    }

    private ArrayList<Art> generateGoodInputArrayList(){
        Art[] temp = {
                new Art("Venus of Willendorf","Unknown",78945.00,"5th and Main Ave"),
                new Art("Nefertiti","Thutmose",459787.88,"27 Vine St"),
                new Art("Terracotta Warriors","Xi'an sculptor",348900000.00,"17823 Poplar Dr"),
                new Art("Laocoön and His Sons","Greek sculptor",4664866.98,"5674 Pine Ave"),
                new Art("Nike Of Samothrace","Greek sculptor",22949367.88,"34 Cary Dr"),
                new Art("Venus de Milo","Greek sculptor",210565654.5,"943 Key Ave"),
                new Art("David","Donatello",41642723.44,"823 Harlow St"),
                new Art("The Thinker","Auguste Rodin",29694545.77,"732 Sever Ln")
        };

        return new ArrayList<>(Arrays.asList(temp));
    }


    private File generateBadInputFile() throws IOException {
        final String INPUT_FILENAME = "foo.txt";
        File inputFile = folder.newFile(INPUT_FILENAME);
        PrintWriter write = new PrintWriter(inputFile);
        write.print("Venus of Willendorf\tUnknown\t-78945.00\t5th and Main Ave\n" +
                "Nefertiti\tThutmose\t459787.88\t27 Vine St\n" +
                "Terracotta Warriors\tXi'an sculptor\t3489F00000.00\t17823 Poplar Dr\n" +
                "Laocoön and His Sons\tGreek sculptor\t4664866.98\t5674 Pine Ave\n" +
                "Nike Of Samothrace\tGreek sculptor\t22949367.88% \t34 Cary Dr\n" +
                "Venus de Milo\tGreek sculptor\t210565654.5\t943 Key Ave\n" +
                "David\tDonatello\t41642723.44\t823 Harlow St\n" +
                "The Thinker\tAuguste Rodin\t-29694545.77\t732 Sever Ln");
        write.close();
        return inputFile;
    }

    private ArrayList<String> generateBadInputStringArray(){
        String[] array = {"Venus of Willendorf\tUnknown\t-78945.00\t5th and Main Ave",
                "Nefertiti\tThutmose\t459787.88\t27 Vine St",
                "Terracotta Warriors\tXi'an sculptor\t3489F00000.00\t17823 Poplar Dr",
                "Laocoön and His Sons\tGreek sculptor\t4664866.98\t5674 Pine Ave",
                "Nike Of Samothrace\tGreek sculptor\t22949367.88% \t34 Cary Dr",
                "Venus de Milo\tGreek sculptor\t210565654.5\t943 Key Ave",
                "David\tDonatello\t41642723.44\t823 Harlow St",
                "The Thinker\tAuguste Rodin\t-29694545.77\t732 Sever Ln"};
        ArrayList<String> toReturn = new ArrayList<>();
        Collections.addAll(toReturn, array);
        return toReturn;
    }

    private ArrayList<Art> generateBadInputArrayList(){
        Art[] temp = {
                new Art("Venus of Willendorf","Unknown",0,"5th and Main Ave"),
                new Art("Nefertiti","Thutmose",459787.88,"27 Vine St"),
                new Art("Terracotta Warriors","Xi'an sculptor",0,"17823 Poplar Dr"),
                new Art("Laocoön and His Sons","Greek sculptor",4664866.98,"5674 Pine Ave"),
                new Art("Nike Of Samothrace","Greek sculptor",0,"34 Cary Dr"),
                new Art("Venus de Milo","Greek sculptor",210565654.5,"943 Key Ave"),
                new Art("David","Donatello",41642723.44,"823 Harlow St"),
                new Art("The Thinker","Auguste Rodin",0,"732 Sever Ln")};

        return new ArrayList<>(Arrays.asList(temp));
    }


    private void testArtArray(String message, ArrayList expected, ArrayList actual){
        assertEquals(message + " looked at the size and ",expected.size(),actual.size());

        for(int i = 0; i < expected.size(); i++) {
            if (!ArtIsEqual(expected.get(i), actual.get(i))) {
                assertEquals(message, expected, actual);
            }
        }
    }

    private void testStringArray(String message, ArrayList expected, ArrayList actual){
        assertEquals(message + " looked at the size and ",expected.size(),actual.size());

        for(int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                assertEquals(message, expected, actual);
            }
        }
    }

    private boolean ArtIsEqual(Object o1, Object o2){
        Class c = o1.getClass();
        try {
            Field o1FieldName = c.getDeclaredField("name");
            o1FieldName.setAccessible(true);
            Object o1Name = o1FieldName.get(o1);

            Field o2FieldName = c.getDeclaredField("name");
            o2FieldName.setAccessible(true);
            Object o2Name = o2FieldName.get(o2);

            Field o1FieldCreator = c.getDeclaredField("creator");
            o1FieldCreator.setAccessible(true);
            Object o1Creator = o1FieldCreator.get(o1);

            Field o2FieldCreator = c.getDeclaredField("creator");
            o2FieldCreator.setAccessible(true);
            Object o2Creator = o2FieldCreator.get(o2);

            Field o1FieldValue = c.getDeclaredField("value");
            o1FieldValue.setAccessible(true);
            Object o1Value = o1FieldValue.get(o1);

            Field o2FieldValue = c.getDeclaredField("value");
            o2FieldValue.setAccessible(true);
            Object o2Value = o2FieldValue.get(o2);

            Field o1FieldLocation = c.getDeclaredField("location");
            o1FieldLocation.setAccessible(true);
            Object o1Location = o1FieldLocation.get(o1);

            Field o2FieldLocation = c.getDeclaredField("location");
            o2FieldLocation.setAccessible(true);
            Object o2Location = o2FieldLocation.get(o2);

            return  o1Name.equals(o2Name) &&
                    o1Creator.equals(o2Creator) &&
                    o1Value.equals(o2Value) &&
                    o1Location.equals(o2Location);


        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }

        return false;
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


}
