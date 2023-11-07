package ba.unsa.etf.rpr;

import java.util.HashMap;
import java.util.Map;

public class MapaKlasa {
protected Map<String, String> imePrezime;

    public MapaKlasa(){
        this.imePrezime=new HashMap<String,String>();
    }

    public void setImePrezime(Map<String, String> imePrezime) {
        this.imePrezime = imePrezime;
    }

    public void dodaj(String ime, String prezime){
        this.imePrezime.put(ime, prezime);
   }
    public String dajIme(String prezime){
        for(Map.Entry<String, String> polje: this.imePrezime.entrySet()){
            if(polje.getValue().equals(prezime))
                return polje.getKey();
        }
        return null;
    }
    public String dajPrezime(String ime){
        for(Map.Entry<String, String> polje: this.imePrezime.entrySet()){
            if(polje.getKey().equals(ime))
                return polje.getValue();
        }
        return null;
    }

}