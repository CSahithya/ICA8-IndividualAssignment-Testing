package ICA8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class UrinalsTest {
    static Urinals urinals = new Urinals();
    public static final File DATAFILE = new File("");

    @BeforeAll
    static void setUpTest(){
        //urinals.openFile(DATAFILE);
    }

    @Test
    void checkIfGoodString(){
        assertFalse(urinals.goodString("Sahithya"));
    }

    @Test
    void checkStringNotNull(){
        assertFalse(urinals.goodString(""));
        //length>=1
    }

    @Test
    void checkStringLength(){
        assertFalse(urinals.goodString("1010101101001010000010000100"));
        //length<=20
    }



}
