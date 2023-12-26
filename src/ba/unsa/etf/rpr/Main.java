package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static GeografijaDAO dao;
    private static Scanner ulaz=new Scanner(System.in);
   // private static Connection conn;
    public static void main(String[] args) throws ClassNotFoundException {
        dao=GeografijaDAO.getInstance();
        int opcija;
        do{
            System.out.println("Unesite opciju:\n1-Ispis svih gardova\n2-Pretraga glavnih gradova na osnovu imena drzave\n0-Izlaz\n");
            opcija=ulaz.nextInt();
            if(ulaz.hasNextLine()) ulaz.nextLine();
            switch(opcija) {
                case 1:
                    ispisiGradove();
                    break;
                case 2:
                    glavniGrad();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Niste unijeli ni jednu od opcija");
            }
        }while(opcija!=0);
    }

    private static void glavniGrad() {
        System.out.println("Unesite naziv drzave: \n");
        String naziv=ulaz.nextLine();
        Grad glavni=dao.glavniGrad(naziv);
        if(glavni!=null) System.out.println("Glavni grad države "+naziv+" je "+glavni.getNaziv());
        else System.out.println("Nepostojeca drzava");
    }

    private static void ispisiGradove() {
        StringBuilder sb=new StringBuilder();
        System.out.println("U bazi podataka postoje sljedeci gradovi: \n");
        Map<Grad, Drzava> mapa=dao.gradoviDrzave();
        for(Map.Entry<Grad, Drzava> entry: mapa.entrySet()){
            sb.append(entry.getKey().getNaziv()+" ("+entry.getValue().getNaziv()+") - "+entry.getKey().getBroj_stanovnika()+"\n");
        }
        System.out.println(sb.toString());
    }



}
