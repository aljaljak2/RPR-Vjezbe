package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Map;

import static ba.unsa.etf.rpr.Main.m;
import static org.junit.jupiter.api.Assertions.*;

class MapaKlasaTest {
@BeforeAll
    private static void upisiPodatke(){
     m.dodaj("Mujo","Mujic");
     m.dodaj("Pero", "Peric");
     m.dodaj("Haso","Hasic");
}
@Test
    public  void dajImeTest(){
    MapaKlasa mapa= Mockito.mock(MapaKlasa.class);
    Mockito.when(mapa.dajIme("Mujic")).thenReturn("Nema nista");
    String test=mapa.dajIme("Mujic");
    assertEquals(test,"Nema nista");

}
@Test
    public void TestMape(){
    Map<String,String> mapa=Mockito.mock(Map.class);
    Mockito.when(mapa.get("Haso")).thenReturn("Ovo je lazna Mapa");
    m.setImePrezime(mapa);
    String test=m.dajPrezime("Haso");

    assertNotEquals(test,"Hasic");
    assertNotEquals(test,"Ovo je lazna Mapa");
}
}