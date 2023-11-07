package ba.unsa.etf.rpr;

public class Izvedena extends Bazna {
    private int broj1;
    private int broj2;

    public Izvedena(int broj1, int broj2) {
        this.broj1 = broj1;
        this.broj2 = broj2;
    }

    public void setBroj1(int broj1) {
        this.broj1 = broj1;
    }

    public void setBroj2(int broj2) {
        this.broj2 = broj2;
    }

    public Integer dajZbirBrojeva(){
        Integer zbir=broj1+broj2;
        return zbir;
    }
}
