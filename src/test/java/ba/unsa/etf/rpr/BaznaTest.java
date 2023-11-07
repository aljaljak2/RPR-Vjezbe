package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BaznaTest {
    public static Bazna b=new Bazna();
    @BeforeAll
    private static void postaviVrijednost(){
        b.setIzvedena(5,6);
    }

}