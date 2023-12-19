package ba.unsa.etf.rpr.vjezba7;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Optional;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private ObjectProperty<Korisnik> trenutniKorisnik=new SimpleObjectProperty<>();


    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        if(this.trenutniKorisnik.get()==null) throw new NullPointerException("Trenutni korisnik je null!");
        return trenutniKorisnik.get();
    }

    public ObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }
    public void ispisiKorisnike() {
        System.out.println("Korisnici su:");
        for (Korisnik k : korisnici)
            System.out.println(k);
    }
    void napuni(){
        Korisnik k1=new Korisnik("Ali", "Ljaljak","aljaljak2@etf.unsa.ba","aljaljak2","12345");
        korisnici.add(k1);
        korisnici.add(new Korisnik("Hamza", "Iseric","hiseric1@etf.unsa.ba","hiseric1","54321"));
        korisnici.add(new Korisnik("Adi","Drakovac", "adrakvac1@etf.unsa.ba","adrakovac1", "13542" ));
        trenutniKorisnik.set(k1);
    }
    void dodaj(){
        Korisnik novi=new Korisnik("", "", "", "", "");
        korisnici.add(novi);
        trenutniKorisnik.set(novi);
    }

}
