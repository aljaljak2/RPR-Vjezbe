package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.KolekcijaImena;
import java.util.ArrayList;
import java.util.List;
public class Pobjednik {
   private  String ime;
   private String prezime;
    private int brojZnakova;
    private Kolekcija kolekcijaImena;

    public Pobjednik(Kolekcija kolekcijaImena) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        this.kolekcijaImena = kolekcijaImena;
        boolean prelaz=false;
        for(char c:kolekcijaImena.dajNajduzi().toCharArray()){
            if(c!=' '){
                if(!prelaz){sb1.append(c);}
                else {sb2.append(c);}
            }else if(c==' '){
                prelaz=true;
            }
        }
        this.ime=sb1.toString();
        this.prezime=sb2.toString();
        this.brojZnakova=this.ime.length();

    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getBrojZnakova() {
        return brojZnakova;
    }

    public Kolekcija getKolekcijaImena() {
        return kolekcijaImena;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setBrojZnakova(int brojZnakova) {
        this.brojZnakova = brojZnakova;
    }

    public void setKolekcijaImena(KolekcijaImena kolekcijaImena) {
        this.kolekcijaImena = kolekcijaImena;
    }
}
