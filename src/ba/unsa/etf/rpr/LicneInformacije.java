package ba.unsa.etf.rpr;

public class LicneInformacije implements MozeSePredstaviti {
    private String ime;
    private String prezime;

    public LicneInformacije(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String predstavi() {
        StringBuilder sb=new StringBuilder();
        sb.append("Ime: ").append(this.getIme()).append(" Prezime: ").append(this.getPrezime());
        return sb.toString();
    }
}
