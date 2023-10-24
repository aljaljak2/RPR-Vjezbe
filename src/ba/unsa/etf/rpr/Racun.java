package ba.unsa.etf.rpr;

public class Racun {
    private long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private double stanjeRacuna;
    private double dozvoljenoPrekoracenje;
    public Racun(long brojRacuna, Osoba korisnikRacuna){
        this.brojRacuna=brojRacuna;
        this.korisnikRacuna=korisnikRacuna;
    }
    public long getBrojRacuna(){
        return this.brojRacuna;
    }
    public Osoba getKorisnikRacuna(){
        return this.korisnikRacuna;
    }
    public boolean isOdobrenjePrekoracenja(){
        return this.odobrenjePrekoracenja;
    }
    public double getStanjeRacuna(){
        return this.stanjeRacuna;
    }
    public double getDozvoljenoPrekoracenje(){
        return this.dozvoljenoPrekoracenje;
    }
    public void setBrojRacuna(long brojRacuna){
        this.brojRacuna=brojRacuna;
    }
    public void setKorisnikRacuna(Osoba korisnikRacuna){
        this.korisnikRacuna=korisnikRacuna;
    }
    public void setOdobrenjePrekoracenja(boolean odobrenjePrekoracenja){
        this.odobrenjePrekoracenja=odobrenjePrekoracenja;
    }
    public void setStanjeRacuna(double stanjeRacuna){
        this.stanjeRacuna=stanjeRacuna;
    }
    public void setDozvoljenoPrekoracenje(double dozvoljenoPrekoracenje){
        this.dozvoljenoPrekoracenje=dozvoljenoPrekoracenje;
    }
    public boolean provjeriOdobrenjePrekoracenja(double iznos){
        return this.dozvoljenoPrekoracenje > iznos;
    }
    public boolean izvrsiUplatu(double iznos){
        this.stanjeRacuna=this.stanjeRacuna+iznos;
        return true;
    }
    public boolean izvrsiIsplatu(double iznos){
        if(this.stanjeRacuna>=iznos) {
            this.stanjeRacuna=this.stanjeRacuna-iznos;
            return true;
        }
        return false;
    }
    public void odobriPrekoracenje(double iznos){
        this.dozvoljenoPrekoracenje=iznos;
    }

}
