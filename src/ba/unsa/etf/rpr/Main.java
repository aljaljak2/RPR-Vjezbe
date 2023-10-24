package ba.unsa.etf.rpr;

public class Main {

    public static void main(String[] args) {
        //ideja je da uzmemo da prvi clan niza stringova "args" mora biti naziv funkcije
        //koja se poziva a drugi clan niza stringova "args" broj nad kojim pozivamo tu funciju

        try {
            if (args.length != 2) {
                throw new IllegalArgumentException("Moraju se proslijediti dva argumenta");
            } else if (!args[0].equals("sinus") && !args[0].equals("faktorijel")) {
                throw new IllegalArgumentException("Niste pravilno pozvali niti jednu od mogucih funkcija");
            } else {

        double broj = Double.parseDouble(args[1]);
        int brojZaFaktorijel = (int) broj;
        if (args[0].equals("sinus")) {
         System.out.println("Sinus broja " + broj + " iznosi: \n sin(" + broj + ")=" + Matematika.sinus(broj));
         } else if (args[0].equals("faktorijel")) {
        System.out.println("Faktorijel broja " + brojZaFaktorijel + " iznosi:\n " + brojZaFaktorijel + "!=" + Matematika.faktorijel(brojZaFaktorijel));
        }
         }
        }catch(Exception e){
            System.out.println("Doslo je do greske: "+e.getMessage());
        }


    }
}