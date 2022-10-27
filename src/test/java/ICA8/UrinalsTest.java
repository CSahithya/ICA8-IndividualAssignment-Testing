package ICA8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class UrinalsTest {
    static Urinals urinals = new Urinals();
    public static final File DATAFILE = new File("");
    String[] urinalArray = {"10010000", "10001", "00000", "010101", "1100101"};

    @BeforeAll
    static void setUpTest(){
        //urinals.openFile(DATAFILE);
    }

    @Test
    void checkIfGoodString(){
        assertFalse(urinals.goodString("Sahithya"));
        //String should be in a binary format
    }

    @Test
    void checkStringNotNull(){
        assertFalse(urinals.goodString(""));
        //length>=1
    }

    @Test
    void checkStringLength(){
        assertFalse(urinals.goodString("101010101001010000010000100"));
        //length<=20
    }

    @Test
    void checkWrongString(){
        assertFalse(urinals.goodString("101100101010"));
        //given string shouldn't already violate the unwritten male urinal rule
    }

    @Test
    void checkForGoodString(){
        assertTrue(urinals.goodString("10010010101000"));
    }

    @Test
    void countForWrongString(){
        assertEquals(-1,urinals.countUrinals(urinalArray[4]));
    }
}
