package ba.unsa.etf.rpr;

import java.util.Scanner;
import java.util.Set;

public class Program {
   public static Scanner ulaz = new Scanner(System.in);
   public static Imenik imenik=new Imenik();
    public static void main(String[] args) {
        popuniImenik();
        while(true) {
            System.out.println("Unesite neku od komandi za rad sa imenikom [dodaj, dajBroj, dajIme, naSlovo, izGrada, izGradaBrojevi, prikazi, izadji");
            String komanda = ulaz.nextLine();
            switch (komanda) {
                case "dodaj":
                    dodaj();
                    break;
                case "dajBroj":
                    dajBroj();
                    break;
                case "dajIme":
                    dajIme();
                    break;
                case "naSlovo":
                    naSlovo();
                    break;
                case "izGrada":
                    izGrada();
                    break;
                case "izGradaBrojevi":
                    izGradaBrojevi();
                    break;
                case "prikazi":
                    ispisi();
                    break;
                case "izadji":
                    System.exit(0);
                default:
                    System.out.println("Pogresna komanda");

            }
        }

    }
        private static TelefonskiBroj unesiBroj(){
            System.out.println("Unesite koju vrstu telefonskog broja zelite [fiksni, mobilni, medjunarodni]");
            String vrstaBroja=ulaz.nextLine();
            switch(vrstaBroja){
                case "fiksni":
                    System.out.println("Unesite pozivni broj ");
                    String grad=ulaz.nextLine();
                    System.out.println("Unesite ostatak broja");
                    String broj=ulaz.nextLine();
                    return new FiksniBroj(Grad.fromBrojTelefona(grad), broj);
                case "mobilni":
                    System.out.println("Unesite mobilnu mrezu: ");
                    Integer mreza=ulaz.nextInt();
                    String mobilni=ulaz.nextLine();
                    System.out.println("Unesite ostatak broja:");
                     mobilni=ulaz.nextLine();
                    return new MobilniBroj(mreza, mobilni);
                case "medjunarodni":
                    System.out.println("Unesite pozivni broj drzave:");
                    String drzava=ulaz.nextLine();
                    System.out.println("Unesite broj telefona:");
                    String brojTelefona=ulaz.nextLine();
                    return new MedjunarodniBroj(drzava, brojTelefona);
            }
            return null;
        }
        public static void dodaj(){
            System.out.println("Unesite ime i prezime osobe ciji broj dodajete u imenik:");
            String imePrezime=ulaz.nextLine();
            TelefonskiBroj tb=unesiBroj();
           imenik.dodaj(imePrezime,tb);
        }
        public static void dajIme(){
        System.out.println("Unesite broj telefona za trazenu osobu:");
        TelefonskiBroj tb=unesiBroj();
        String ime=imenik.dajIme(tb);
        if(ime==null){
            System.out.println("Korisnik sa tim brojem ne postoji.");
        }else
        System.out.println("Osoba koja posjeduje uneseni broj telefona je: "+ime);
        }
        public static void dajBroj(){
        System.out.println("Unesite ime osobe ciji broj trazite: ");
        String ime=ulaz.nextLine();
        String broj=imenik.dajBroj(ime);
        if(broj==null){
            System.out.println("Osoba koju trazite nije upisana u imenik.");
        }else
            System.out.println("Broj telefona osobe "+ime+" je: "+broj);
    }
    public static void naSlovo(){
        System.out.println("Unesite pocetno slovo imena ljudi koje zelite da prikazete: ");
        char znak=ulaz.next().charAt(0);
        String osobe=imenik.naSlovo(znak);
        if(osobe==null){
            System.out.println("Nema osoba cije ime pocinje na trazeno slovo");
        }
        else System.out.println("Osobe cije ime pocinje na slovo "+znak+" su: \n"+osobe);
    }
   public static void izGrada(){
        System.out.println("Unesite grad: ");
        String grad=ulaz.nextLine();
        try{
          Grad g=Grad.valueOf(grad);
          Set<String> povratni=imenik.izGrada(g);
          System.out.println(povratni);
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return;
        }
   }
   public static void izGradaBrojevi(){
       System.out.println("Unesite grad: ");
       String grad=ulaz.nextLine();
       try{
           Grad g=Grad.valueOf(grad);
           Set<TelefonskiBroj> s=imenik.izGradaBrojevi(g);
          for(TelefonskiBroj tb:s){
              System.out.println(tb.ispisi());
          }
       }catch(Exception e) {
           System.out.println(e.getMessage());
           return;
       }
   }
   public static void ispisi(){
        System.out.println(imenik.toString());
   }
   private static void popuniImenik(){
        imenik.dodaj("Amil", new FiksniBroj(Grad.SARAJEVO, "453-172"));
        imenik.dodaj("Zeljko",new MobilniBroj(61, "451-606"));
        imenik.dodaj("Emerald", new MobilniBroj(62, "678-954"));
        imenik.dodaj("Samir", new MobilniBroj(60,"7879-123"));
        imenik.dodaj("Messi", new MedjunarodniBroj("+54", "15563444"));
   }
   }




