package ba.unsa.etf.rpr;

public class Drzava {
    private int id;
    private String naziv;
    private int  glavni_grad;

    public Drzava(int id, String naziv, int glavni_grad) {
        this.id = id;
        this.naziv = naziv;
        this.glavni_grad = glavni_grad;
    }

    public Drzava() {
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getGlavni_grad() {
        return glavni_grad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setGlavni_grad(int glavni_grad) {
        this.glavni_grad = glavni_grad;
    }
}
