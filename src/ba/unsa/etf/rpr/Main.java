package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> lista=new ArrayList<>();
        lista.addAll(Arrays.asList("Aleksandar Dobrić", "Mirza Kulović", "Kerim Bajraktarević", "Benjamin Hadžihasanović"));
     Kolekcija kolekcijaImena=new KolekcijaImena(lista);
        List<String> imena=new ArrayList<>();
        imena.addAll(Arrays.asList("Tarik", "Mahir", "Vedad"));
        List<String> prezimena=new ArrayList<>();
        prezimena.addAll(Arrays.asList("Čečo", "Rešidović", "Vedo"));
     Kolekcija kolekcija2=new KolekcijaImenaIPrezimena(imena, prezimena);
     Pobjednik pb=new Pobjednik(kolekcijaImena);
     System.out.println(pb.getPrezime());
        System.out.println(pb.getBrojZnakova());
        Pobjednik pb2=new Pobjednik(kolekcija2);
        System.out.println(pb2.getPrezime());
    }

}
