package ba.unsa.etf.rpr;

import java.util.Objects;

public class Korisnik extends Osoba{
    public Racun racun;
    public Korisnik(String ime, String prezime) {
        super(ime, prezime);
    }
    public void DodajRacun(){
        this.racun=racun;
    }
    public Racun getRacun(){
        return this.racun;
    }
    public void setRacun(Racun racun){
        this.racun=racun;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        Korisnik k=(Korisnik) o;
        return Objects.equals(this.racun, k.racun);
    }
}
