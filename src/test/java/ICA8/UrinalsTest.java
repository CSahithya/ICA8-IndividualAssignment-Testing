package ICA8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class UrinalsTest {
    static Urinals maleUrinals = new Urinals();
    public static final File DATAFILE = new File("");

    @BeforeAll
    static void setUpTest(){
        //maleUrinals.openFile(DATAFILE);
    }

    @Test
    void checkIfGoodString(){
        assertFalse(maleUrinals.goodString("Sahithya"));
    }

    @Test
    void checkStringNotNull(){
        assertFalse(maleUrinals.goodString(""));
    }



}
