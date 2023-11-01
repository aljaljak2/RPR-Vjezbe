package ba.unsa.etf.rpr;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj{
    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza, broj);
    }

    @Override
    public String ispisi() {
    if(broj==null) return null;
    return "0"+mobilnaMreza+"/"+broj;
    }

}
