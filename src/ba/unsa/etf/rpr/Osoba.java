package ba.unsa.etf.rpr;

import java.util.Objects;

public class Osoba {
    private String ime;
    private String prezime;
    public Osoba(String ime, String prezime){
        this.ime=ime;
        this.prezime=prezime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
    public void setPrezime(){
        this.prezime=prezime;
    }
    public String getIme(){
        return this.ime;
    }
    public String getPrezime(){
        return this.prezime;
    }
    @Override
    public String toString(){
        return "Osoba:\n"+"Ime: "+this.ime+"\nPrezime: "+this.prezime+"\n";
    }
    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if(o==null || this.getClass()!=o.getClass()) return false;
        Osoba osoba=(Osoba) o;
        return Objects.equals(osoba.ime,this.ime ) && Objects.equals(osoba.prezime, this.prezime);
    }

}
