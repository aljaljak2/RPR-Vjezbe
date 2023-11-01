package ba.unsa.etf.rpr;

public enum Grad {
    TRAVNIK("030"),
    ODZAK("031"),
    ZENICA("032"),
    SARAJEVO("033"),
    LIVNO("034"),
    TUZLA("035"),
    MOSTAR("036"),
    BIHAC("037"),
    GORAZDE("038"),
    POSUSJE("039"),
    BRCKO("049"),
    MRKONJIC_GRAD("050"),
    BANJA_LUKA("051"),
    PRIJEDOR("052"),
    DOBOJ("053"),
    SAMAC("054"),
    BIJELJINA("055"),
    ZVORNIK("056"),
    PALE("057"),
    FOCA("058"),
    TREBINJE("059");

    private String brojTelefona;

    Grad(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getBrojTelefona() {
        return this.brojTelefona;
    }

    public static Grad fromBrojTelefona(String brojTelefona) {
        for (Grad g : Grad.values()) {
            if (brojTelefona.equals(g.getBrojTelefona())) {
                return g;
            }
        }
        return null;
    }

}