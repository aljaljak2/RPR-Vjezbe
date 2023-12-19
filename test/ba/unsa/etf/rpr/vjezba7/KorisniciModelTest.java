package ba.unsa.etf.rpr.vjezba7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {

@Test
public void Test1(){
    KorisniciModel km=new KorisniciModel();
    km.napuni();
    assertEquals(km.getTrenutniKorisnik().getIme(),"Ali");
}

@Test
    public void Test2(){
    KorisniciModel km=new KorisniciModel();
    km.dodaj();
    assertNotEquals(km.getTrenutniKorisnik().getPrezime(), "Ljaljak");
}

@Test
    public void Test3(){
    KorisniciModel km=new KorisniciModel();
    //km.dodaj();
   // km.setTrenutniKorisnik(null);
    assertThrows(NullPointerException.class, ()->{km.getTrenutniKorisnik();});
}
}