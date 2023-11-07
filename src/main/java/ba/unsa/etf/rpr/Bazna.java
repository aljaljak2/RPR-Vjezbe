package ba.unsa.etf.rpr;

public class Bazna {
    public Bazna() {
        this.izvedena = new Izvedena(1,1);
    }

    public Izvedena getIzvedena() {
        return izvedena;
    }

    private Izvedena izvedena;

    public void setIzvedena(int br1, int br2) {
        this.izvedena.setBroj1(br1);
        this.izvedena.setBroj2(br2);
    }
}
