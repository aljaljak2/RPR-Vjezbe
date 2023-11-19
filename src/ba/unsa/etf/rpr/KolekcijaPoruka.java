package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class KolekcijaPoruka {
    private List<String> poruke=new ArrayList<>();

    public List<String> getPoruke() {
        return poruke;
    }


    public KolekcijaPoruka(List<MozeSePredstaviti> poruke) {
        for (MozeSePredstaviti mozeSePredstaviti : poruke) {
            this.poruke.add(mozeSePredstaviti.predstavi());
        }
    }
}
