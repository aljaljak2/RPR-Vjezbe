package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Random;

public class Banka {
private ArrayList<Korisnik> korisnici;
private ArrayList<Uposlenik> uposlenici;
private long brojRacuna;
public Banka(){
    this.korisnici=new ArrayList<Korisnik>();
    this.uposlenici=new ArrayList<Uposlenik>();
}
public Korisnik kreirajNovogKorisnika(String ime, String prezime){
    Korisnik k=new Korisnik(ime,prezime);
    this.korisnici.add(k);
    return k;
}
    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        Uposlenik u=new Uposlenik(ime,prezime);
        this.uposlenici.add(u);
        return u;
    }
    public Racun kreirajRacunZaKorisnika(Korisnik k){
    Racun a=null;
    for(int i=0;i<this.korisnici.size();i++){
        if(this.korisnici.get(i).equals(k)) {
            long broj=(new Random()).nextLong();
          a=new Racun(broj, this.korisnici.get(i));
          break;
        }
    }
    return a;
    }
}
