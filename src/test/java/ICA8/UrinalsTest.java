package ICA8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UrinalsTest {
    static Urinals maleUrinals = new Urinals();
    public static final String DATAFILE = "";

    @BeforeAll
    static void setUpTest(){

    }

    @Test
    void checkIfGoodString(){
        assertFalse(maleUrinals.goodString("Sahithya"));
    }



}
