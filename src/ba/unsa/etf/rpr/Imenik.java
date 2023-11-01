package ba.unsa.etf.rpr;

import java.util.*;

public class Imenik {
    private Map<String, TelefonskiBroj> brojevi;
    public Imenik(){
        this.brojevi=new HashMap<String, TelefonskiBroj>();

    }
    public Map<String, TelefonskiBroj> getBrojevi(){
        return this.brojevi;
    }
    public void setBrojevi(Map<String,TelefonskiBroj> m){
        this.brojevi=m;
    }
    public void dodaj(String ime, TelefonskiBroj broj){
        this.brojevi.put(ime, broj);
    }
    public String dajBroj(String ime){
        TelefonskiBroj broj=this.brojevi.get(ime);
        if(broj!=null){
            return broj.ispisi();
        }
        else return null;
    }
    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String,TelefonskiBroj> polje: this.brojevi.entrySet()){
            if(polje.getValue().ispisi().equals(broj.ispisi())){
               return polje.getKey();
            }
        }
        return null;
    }
    public String naSlovo(char s){
        StringBuilder sb=new StringBuilder();
        Integer redniBr=0;
        for(Map.Entry<String,TelefonskiBroj> polje:this.brojevi.entrySet()){
            if(polje.getKey().charAt(0)==s){
                redniBr=redniBr+1;
                sb.append(redniBr.toString()).append(".").append(polje.getKey()).append("-").
                        append(polje.getValue().ispisi()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
    Set<String> izGrada(Grad g){
       Set<String> s=new TreeSet<>();
       for(Map.Entry<String, TelefonskiBroj> polje: this.brojevi.entrySet()){
           if(jeLiIzGrada(polje.getValue(), g))
               s.add(polje.getKey());
        }
       return s;
    }
    Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Comparator<TelefonskiBroj> abecedniKomparator= new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        };
        Set<TelefonskiBroj> s=new TreeSet<TelefonskiBroj>(abecedniKomparator);
        for(Map.Entry<String, TelefonskiBroj> polje:this.brojevi.entrySet()){
            if(jeLiIzGrada(polje.getValue(),g)){
                s.add(polje.getValue());
            }
        }
        return s;

    }
    private static boolean jeLiIzGrada (TelefonskiBroj broj, Grad g){
        if(broj instanceof FiksniBroj){
            if(((FiksniBroj) broj).getBroj().equals(g)) {
                return true;
            }
            }
            return false;
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        Integer rednibr=0;
        for(Map.Entry<String, TelefonskiBroj> polje:this.brojevi.entrySet()) {
            rednibr=rednibr+1;
            sb.append(rednibr.toString()).append(".").append(polje.getKey()).append("-").
                    append(polje.getValue().ispisi()).append(System.lineSeparator());
        }
        return sb.toString();

    }

}
