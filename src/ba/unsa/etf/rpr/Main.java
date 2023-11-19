package ba.unsa.etf.rpr;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void OcijeniNastavnika(InformacijeOStudentu student, InformacijeONastavniku nastavnik, int ocj){
        nastavnik.ocijeni(ocj);
    }
    public static void OcijeniPredmet(MozeSePredstaviti osoba, Predmet predmet, int ocj){
        predmet.ocijeni(ocj);
    }
    public static void main(String[] args) {
	InformacijeOStudentu s=new InformacijeOStudentu("Ali", "Ljaljak", "19371", "2");
	System.out.println("Ime: "+ s.getIme()+" Prezime: "+ s.getPrezime());
	s.setIme("Rijad");
        System.out.println("\nIme: "+ s.getIme()+" Prezime: "+ s.getPrezime());

        List<InformacijeOStudentu> listaStudenata=new ArrayList<>();

     listaStudenata.add(s);
        List<MozeSePredstaviti> listaOsoba=new ArrayList<>();
        InformacijeONastavniku ion=new InformacijeONastavniku("prof. doc.", "Samir", "Ribić");
     listaOsoba.add(new InformacijeONastavniku("prof. doc.", "Samir", "Ribić"));
     listaOsoba.add(s);
        KolekcijaPoruka kp=new KolekcijaPoruka(listaOsoba);
        Iterator it=kp.getPoruke().iterator();
        while(it.hasNext()){
            String osoba= (String) it.next();
            System.out.println(osoba);
        }
        Predmet SP=new Predmet("Sistemsko programiranje", "Asemeblerski kod");
        OcijeniNastavnika(listaStudenata.get(0),ion, 8 );
        OcijeniPredmet(ion, SP, 9);
        OcijeniNastavnika(listaStudenata.get(0),ion, 6 );
        OcijeniPredmet(ion, SP, 5);

        for(Ocjena o: SP.getOcjene()){
            System.out.println(o.toString());
        }

        for(Ocjena o: ion.getOcjene()){
            System.out.println(o.toString());
        }
    }

}
