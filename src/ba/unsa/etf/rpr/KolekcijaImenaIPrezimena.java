package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class KolekcijaImenaIPrezimena implements Kolekcija {
    private List<String> imena=new ArrayList<>();
    private List<String> prezimena=new ArrayList<>();

    public int getIndexNajduzegPara(){
        int max=imena.get(0).length()+prezimena.get(0).length();
        int index=0;
        for(int i=0; i<imena.size();i++){
            int duzina=imena.get(i).length()+prezimena.get(i).length();
            if(duzina>max){
                max=duzina;
                index=i;
            }
        }
        return index;
    }

    public KolekcijaImenaIPrezimena(List<String> imena, List<String> prezimena) {
        if(imena.size()!=prezimena.size()) throw new RazlicitBrojImenaIPrezimena("Morate imati isti broj imena i prezimena u listi!");
        this.imena = imena;
        this.prezimena = prezimena;
    }
    public String getImeIPrezime(int i){
        StringBuilder sb=new StringBuilder();
        sb.append(imena.get(i)).append(" ").append(prezimena.get(i));
        return sb.toString();
    }

    @Override
    public String dajNajduzi() {
        return this.getImeIPrezime(this.getIndexNajduzegPara());
    }
}
