package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Main {
    public static MapaKlasa m=new MapaKlasa();
    public Scanner scan=new Scanner(System.in);
    public static void main(String[] args){
    MapaKlasa ik=new MapaKlasa();
    ik.dodaj("Ali","Ljaljak");
    String rez=ik.dajIme("Ljaljak");
    System.out.println(rez);
    }
}
