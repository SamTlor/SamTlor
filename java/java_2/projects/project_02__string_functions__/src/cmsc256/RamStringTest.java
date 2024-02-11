package cmsc256;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class RamStringTest {

    RamString ramstring = new RamString();

    @Test
    void testGetWackySTring(){
        assertEquals("Rams! Let's Go Rams and CS@VCU!", ramstring.getWackyString());
    }

    @Test
    void testGetWackyString2(){
        RamString ramstringTestGetWackyString2 = new RamString("jeremy");
        assertEquals("jeremy", ramstringTestGetWackyString2.getWackyString());
    }

    @Test
    void testCountVCURams(){
        RamString ramstringTestCountVCUrams = new RamString("Rodney is the mascot for vcu");
        assertEquals(0, ramstringTestCountVCUrams.countVCURams());
    }
    @Test
    void testCountVCURams2(){
        RamString ramstringTestCountVCUrams2 = new RamString("Rodney is the mascot for VCU, Go RAMS!");
        assertEquals(2, ramstringTestCountVCUrams2.countVCURams());
    }
    @Test
    void testCountVCURams3(){
        RamString ramstringTestCountVCUrams3 = new RamString("Rodney is the mascot for VCu go rams.");
        assertEquals(1, ramstringTestCountVCUrams3.countVCURams());
    }

    @Test
    void testHasRams(){
        RamString ramstringTestHasRams = new RamString("0rams");
        assertEquals(true, ramstringTestHasRams.hasRams());
    }
    @Test
    void testHasRams2(){
        RamString ramstringTestHasRams2 = new RamString("RaMs");
        assertEquals(false, ramstringTestHasRams2.hasRams());
    }
    @Test
    void testHasRams3(){
        RamString ramstringTestHasRams3 = new RamString("ramssfkjshdkjhsdkjhskhf");
        assertEquals(true, ramstringTestHasRams3.hasRams());
    }

    @Test
    void testHasRepeatingPrefix(){
        RamString ramstringTestHasRepeatingPrefix = new RamString("ramsrams");
        assertEquals(true, ramstringTestHasRepeatingPrefix.hasRepeatingPrefix(4));
    }
    @Test
    void testHasRepeatingPrefix2(){
        RamString ramstringTestHasRepeatingPrefix2 = new RamString("ramsasdframs");
        assertEquals(true, ramstringTestHasRepeatingPrefix2.hasRepeatingPrefix(4));
    }
    @Test
    void testHasRepeatingPrefix3(){
        RamString ramstringTestHasRepeatingPrefix3 = new RamString("ramsaskdjhfkjshfk");
        assertEquals(false, ramstringTestHasRepeatingPrefix3.hasRepeatingPrefix(4));
    }
    @Test
    void testHasRepeatingPrefix4(){
        RamString ramstringTestHasRepeatingPrefix4 = new RamString("ramsalskdjfsdfjkhkjdframs");
        assertEquals(false, ramstringTestHasRepeatingPrefix4.hasRepeatingPrefix(9));
    }

    @Test
    void testMakeNumberSubstitutions(){
        RamString ramstringTestMakeNumberSubstitutions = new RamString("indigo");
        assertEquals("1nd1g0", ramstringTestMakeNumberSubstitutions.makeNumberSubstitutions());
    }
    @Test
    void testMakeNumberSubstitutions2(){
        RamString ramstringTestMakeNumberSubstitutions2 = new RamString("1nd1g0");
        assertEquals("1nd1g0", ramstringTestMakeNumberSubstitutions2.makeNumberSubstitutions());
    }
    @Test
    void testMakeNumberSubstitutions3(){
        RamString ramstringTestMakeNumberSubstitutions3 = new RamString("yEllOws");
        assertEquals("Y3ll0w5", ramstringTestMakeNumberSubstitutions3.makeNumberSubstitutions());
    }

    @Test
    void testRemoveNot(){
        RamString ramstringTestRemoveNot = new RamString("Not nottacos not");
        assertEquals("Tacos ", ramstringTestRemoveNot.removeNot());
    }
    @Test
    void testRemoveNot2(){
        RamString ramstringTestRemoveNot2 = new RamString("Not a real note. connotation. hypnotize");
        assertEquals("Not a real e. conation. hypize", ramstringTestRemoveNot2.removeNot());
    }
    @Test
    void testRemoveNot3(){
        RamString ramstringTestRemoveNot3 = new RamString("The word: isn't");
        assertEquals("The word: isn't", ramstringTestRemoveNot3.removeNot());
        
    }
}
