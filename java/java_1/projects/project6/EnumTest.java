package projects.project6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EnumTest {

    @Test
    public void BedroomsTest() {
        try {
            Bedrooms.valueOf("ONE_BEDROOM");
            Bedrooms.valueOf("TWO_BEDROOM");
            Bedrooms.valueOf("THREE_BEDROOM");
            Bedrooms.valueOf("STUDIO");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Bedrooms enum, we",4,Bedrooms.values().length);
    }

    @Test
    public void BathsTest() {
        try {
            Baths.valueOf("ONE");
            Baths.valueOf("TWO");
            Baths.valueOf("THREE");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Baths enum, we",3,Baths.values().length);
    }

    @Test
    public void StatusTest() {
        try {
            Status.valueOf("VACANT");
            Status.valueOf("OCCUPIED");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Status enum, we",2,Status.values().length);
    }

}
