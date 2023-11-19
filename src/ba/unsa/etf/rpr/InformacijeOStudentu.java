package ba.unsa.etf.rpr;

public class InformacijeOStudentu extends LicneInformacije implements MozeSePredstaviti {
    private String brojIndexa;
    private String godinaStudija;
    public InformacijeOStudentu(String ime, String prezime, String brojIndexa, String godinaStudija){
        super(ime, prezime);
        this.brojIndexa=brojIndexa;
        this.godinaStudija=godinaStudija;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    @Override
    public String predstavi() {
        StringBuilder sb=new StringBuilder();
        sb.append("Ime: ").append(this.getIme()).append(" Prezime: ").append(this.getPrezime()).append(" broj indexa ").append(this.getBrojIndexa()).append(" godina studija: ").append(this.getGodinaStudija());
        return sb.toString();
    }
}
