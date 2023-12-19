package ba.unsa.etf.rpr.vjezba7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

public class Controller {
    public PasswordField pswfLozinka;
    public TextField txfKorisnickoIme;
    public TextField txfEmail;
    public TextField txfPrezime;
    public TextField txfIme;
    public ListView listView;

    private KorisniciModel model;
   public Controller(KorisniciModel m){
       this.model=m;
   }

    @FXML
   public void initialize(){
        listView.setItems(model.getKorisnici());

        listView.getSelectionModel().selectedItemProperty().addListener((obs,oldKorisnik, newKorisnik) -> {
            System.out.println("stari korisnik "+oldKorisnik);
            System.out.println("novi korisnik "+newKorisnik);
            model.setTrenutniKorisnik((Korisnik) newKorisnik);
            //listView.refresh();
           Korisnik stariKorisnik=(Korisnik)oldKorisnik;
           Korisnik noviKorisnik=(Korisnik)newKorisnik;
           if(stariKorisnik!=null) {
               txfIme.textProperty().unbindBidirectional(stariKorisnik.imeProperty());
               txfPrezime.textProperty().unbindBidirectional(stariKorisnik.prezimeProperty());
               txfEmail.textProperty().unbindBidirectional(stariKorisnik.emailProperty());
               txfKorisnickoIme.textProperty().unbindBidirectional(stariKorisnik.korisnickoImeProperty());
               pswfLozinka.textProperty().unbindBidirectional(stariKorisnik.lozinkaProperty());
           }
            txfIme.textProperty().bindBidirectional(noviKorisnik.imeProperty());
            txfPrezime.textProperty().bindBidirectional(noviKorisnik.prezimeProperty());
            txfEmail.textProperty().bindBidirectional(noviKorisnik.emailProperty());
            txfKorisnickoIme.textProperty().bindBidirectional(noviKorisnik.korisnickoImeProperty());
            pswfLozinka.textProperty().bindBidirectional(noviKorisnik.lozinkaProperty());

        });
        /*txfIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        txfPrezime.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        txfEmail.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        txfKorisnickoIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        pswfLozinka.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());*/
   }

    public void NaKlik(ActionEvent actionEvent) {
       model.dodaj();
    }

    public void KrajClick(ActionEvent actionEvent) {
       System.exit(0);
    }


}