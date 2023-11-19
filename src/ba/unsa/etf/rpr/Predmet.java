package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Predmet implements MozeSePredstaviti, MozeOcijeniti{
    private String naziv;
    private  String opis;
    private List<Ocjena> ocjene=new ArrayList<>();

    public Predmet(String naziv, String opis) {
        this.naziv = naziv;
        this.opis = opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String predstavi() {
        StringBuilder sb=new StringBuilder();
        sb.append("Naziv: ").append(this.getNaziv()).append(" Opis: ").append(this.getOpis());
        return sb.toString();
    }

    @Override
    public Ocjena ocijeni(int x) {
        Ocjena o=new Ocjena(new LicneInformacije("N","N"), x);
        this.ocjene.add(o);
        return o;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }
}
