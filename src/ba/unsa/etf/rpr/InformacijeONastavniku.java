package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class InformacijeONastavniku extends LicneInformacije implements MozeSePredstaviti, MozeOcijeniti {
   private String titula;
   private List<Ocjena> ocjene=new ArrayList<>();
    public InformacijeONastavniku(String titula, String ime, String prezime) {
        super(ime,prezime);
        this.titula = titula;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    @Override
    public String predstavi() {
        StringBuilder sb=new StringBuilder();
        sb.append("Ime: ").append(this.getIme()).append(" Prezime: ").append(this.getPrezime()).append(" Titula: ").append(this.getTitula());
        return sb.toString();
    }

    @Override
    public Ocjena ocijeni(int x) {
        Ocjena o=new Ocjena(this, x);
        this.ocjene.add(o);
        return o;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }
}
