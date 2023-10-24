package ba.unsa.etf.rpr;

import java.util.List;

public class StatistickeFunkcije {
    public static Double min(List<Double> l){
     Double minimum=l.get(0);
     for(int i=0;i<l.size();i++){
         if(l.get(i)<minimum) minimum=l.get(i);
     }
     return minimum;
    }
    public static Double max(List<Double> l){
        Double maximum=l.get(0);
        for(int i=0;i<l.size();i++){
            if(l.get(i)>maximum) maximum=l.get(i);
        }
        return maximum;
    }
  public static Double mean(List<Double> l){
       Double prosjek=0.;
       for(Double x: l){
           prosjek=prosjek+x;
       }
       return prosjek/l.size();
  }
public static Double standardnaDevijacija(List<Double> l){
        Double devijacija;
        Double suma=0.;
        for(Double x:l){
          suma=suma+x-mean(l);
        }
        devijacija=Math.sqrt(suma/l.size());
        return devijacija;
}
}
