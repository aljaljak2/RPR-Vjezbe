package ba.unsa.etf.rpr;

public class Ocjena {
    LicneInformacije osoba;
    int ocjena;

    public Ocjena(LicneInformacije osoba, int ocjena) {
        this.osoba = osoba;
        this.ocjena = ocjena;
    }

    public void setOcjena(int ocjena) {
        if(ocjena>0 && ocjena<=10) {
            this.ocjena = ocjena;
        }
    }
    @Override
    public String toString(){
        return this.osoba.predstavi()+" Ocjena: "+ocjena;
    }
}
