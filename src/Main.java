// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static int sumaCifara(int n){
        int broj=n,suma=0;
        while(broj>0){
            suma=suma+broj%10;
            broj=broj/10;
        }
        return suma;
    }
    public static boolean DaLiJeDjeljivSaSumomSvojihCifara(int n){
        return (n%sumaCifara(n)==0);
    }
    public static void main(String[] args) {
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite neki broj: ");
        int n;
        n=ulaz.nextInt();
        System.out.println("Svi brojevi manji ili jednaki od n koji su djeljivi sa sumom svojih cfara su: ");
        for(int i=1;i<=n;i++){
            if(DaLiJeDjeljivSaSumomSvojihCifara(i)) System.out.println(i+" ");
        }

    }
}