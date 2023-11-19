package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class KolekcijaImena implements Kolekcija{
    private List<String> imenaPrezimena=new ArrayList<>();

    public String getNajduzeIme(){
        String max=imenaPrezimena.get(0);
        for(String ime: this.imenaPrezimena){
            if(ime.length()>max.length()) max=ime;
        }
        return max;
    }

    public KolekcijaImena(List<String> imenaPrezimena) {
        this.imenaPrezimena = imenaPrezimena;
    }

    public List<String> getImenaPrezimena() {
        return imenaPrezimena;
    }

    public void setImenaPrezimena(List<String> imenaPrezimena) {
        this.imenaPrezimena = imenaPrezimena;
    }

    @Override
    public String dajNajduzi() {
        return this.getNajduzeIme();
    }
}
