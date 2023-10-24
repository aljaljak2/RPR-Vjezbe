package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	Scanner ulaz=new Scanner(System.in);
	List<Double> lista=new ArrayList<Double>();
	String stop="stop";
	while(true){
	    System.out.println("Unosite brojeve ili stop za kraj unosa: ");
	    String s=ulaz.nextLine();
	    try{
	    if(!stop.equalsIgnoreCase(s.trim())) {
            double broj = Double.parseDouble(s);
            lista.add(broj);

        }else {
            break;
        }
    }catch(Exception e){
            continue;
        }

    }
	System.out.println("Maksimalni element liste je max="+StatistickeFunkcije.max(lista));
        System.out.println("Minimalni element liste je min="+StatistickeFunkcije.min(lista));
        System.out.println("Mean vrijednost (prosjek) elemenata u listi je mean="+StatistickeFunkcije.mean(lista));
        System.out.println("Standardna devijacija elemenata ove liste je s="+StatistickeFunkcije.standardnaDevijacija(lista));
    }
}
