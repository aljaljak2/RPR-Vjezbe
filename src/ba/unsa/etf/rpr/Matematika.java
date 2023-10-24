package ba.unsa.etf.rpr;

public class Matematika {
    //formula za sinus Suma:(-1.0^n)(x^(2n+1)) / (2n+1)!
public static double sinus(double broj) {
//U ovom slucaju petlja ide do 10 da bi se dobila dovoljna preciznost
    double suma=0;
    for (int i = 0; i < 10; i++) {
     suma=suma+stepen(-1,i)*stepen(broj, 2*i+1)/faktorijel(2*i+1);
    }
    return suma;
}
    //za implementaciju faktorijela na ovom mjestu se koristi
    // funkcija koja je implementirana rekurzivno
    public static long faktorijel(int broj){
        if(broj>=1)
            return broj*faktorijel(broj-1);
        else
            return 1;
}
public static double stepen(double broj, int p){
        double rezultat=1;
        for(int i=0;i<=p;i++) rezultat=rezultat*broj;
        return rezultat;
}

}
