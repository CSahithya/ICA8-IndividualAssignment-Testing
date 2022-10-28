package ICA8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class UrinalsTest {
    static Urinals urinals = new Urinals();
    public static final File inputFile = new File("src\\main\\resources\\urinals.dat");
    String[] urinalArray = {"10010000", "10001", "00000", "010101", "1100101"};

    @BeforeAll
    static void setUpTest(){
        urinals.openFile(inputFile);
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
        //for the correct string
    }

    @Test
    void countForWrongString(){
        assertEquals(-1,urinals.countUrinals(urinalArray[4]));
        //wrong string count
    }

    @Test
    void countZeroIfNoUrinal(){
        assertEquals(0, urinals.countUrinals(urinalArray[3]));
        //correct string when no urinals
    }

    @Test
    void countUrinalsWhenNoOccupancy(){
        assertEquals(3, urinals.countUrinals(urinalArray[2]));
        //string of zeroes
    }

    @Test
    void countWhenOneUrinalPresent(){
        assertEquals(1,urinals.countUrinals(urinalArray[1]));
        //only one urinal present
    }

    @Test
    void countCorrectNumberOfUrinals(){
        assertEquals(2,urinals.countUrinals(urinalArray[0]));
        //random string should generate correct urinal number
    }

    @Test
    void checkIfNoFileExists(){
        assertEquals(-1,urinals.openFile(new File(" ")));

    }

    @Test
    void checkIfInputFileEmpty(){
        File f = new File("src\\main\\resources\\test.dat");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(1,urinals.openFile(f));
        f.delete();
    }

    @Test
    void readFileToString(){
        assertNotEquals("",urinals.getInputString());
    }

    @Test
    void checkOutputStringNotNull(){
        assertNotEquals("",urinals.getOutputString());
    }

    @Test
    void checkCorrectLengthInputAndOutput(){
        File f = urinals.writeToOutputFile();
        assertEquals(urinals.getInputString().split("\n").length,
                urinals.getOutputString().split("\n").length);
        f.delete();
    }

    @Test
    void writeToOutputFile(){
        File f = urinals.writeToOutputFile();
        assertNotNull(f);
        f.delete();
    }

    @Test
    void writeToOutputFileDuplicate(){
        File f = new File("src\\main\\resources\\rest.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File secondFile = urinals.writeToOutputFile();
        assertEquals("rest1.txt", secondFile.getName());
        f.delete();
        secondFile.delete();
    }
}
