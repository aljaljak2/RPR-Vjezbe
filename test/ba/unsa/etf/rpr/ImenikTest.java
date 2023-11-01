package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {
   private static Imenik imenik=new Imenik();
   @BeforeAll
   private static void popuniImenik(){
       imenik.dodaj("Amil", new FiksniBroj(Grad.SARAJEVO, "453-172"));
       imenik.dodaj("Zeljko",new MobilniBroj(61, "451-606"));
       imenik.dodaj("Emerald", new MobilniBroj(62, "678-954"));
       imenik.dodaj("Samir", new MobilniBroj(60,"7879-123"));
       imenik.dodaj("Messi", new MedjunarodniBroj("+54", "15563444"));
   }


    @Test
    public void dajDobijeneBrojeve() {
       String tb=imenik.dajBroj("Samir");
       assertEquals(tb, "060/7879-123");
   }
   @Test
   public void dajNull(){
       String tb=imenik.dajBroj("Ronaldo");
       assertNull(tb);
   }
   @Test
   public void dodajTestiranje(){
       MobilniBroj tb=new MobilniBroj(62, "353-816");
       imenik.dodaj("Emir", tb);
       String rezultat=imenik.dajBroj("Emir");
       assertEquals(rezultat, "062/353-816");
   }

    @Test
    void TestMogIzuzetka() {
       assertThrows(IlegalanBrojException.class, ()->{new FiksniBroj(null, "777-585");});

    }
}