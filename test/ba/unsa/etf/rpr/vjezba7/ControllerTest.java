package ba.unsa.etf.rpr.vjezba7;

import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
   @Start
    public void start (Stage stage) throws Exception {
       KorisniciModel model=new KorisniciModel();
       model.napuni();
       FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("izgled.fxml"));

       fxmlLoader.setController(new Controller(model));
       Scene scene = new Scene(fxmlLoader.load(), 500, 300);
       stage.setTitle("Korisnici");
       stage.setScene(scene);
       stage.show();
       stage.toFront();
       stage.setResizable(false);
    }
 @Test
    public void test(FxRobot robot){
           Button btnDodaj = robot.lookup("#btnDodaj").queryAs(Button.class);
           robot.clickOn("#btnDodaj");
           ListView lv=robot.lookup("#listView").queryAs(ListView.class);
           robot.clickOn("#listView").clickOn("Ali Ljaljak");
           TextField ime=robot.lookup("#txfIme").queryAs(TextField.class);
           TextField prezime=robot.lookup("#txfPrezime").queryAs(TextField.class);
           TextField kime=robot.lookup("#txfKorisnickoIme").queryAs(TextField.class);
           TextField email=robot.lookup("#txfEmail").queryAs(TextField.class);
           PasswordField lozinka=robot.lookup("#pswfLozinka").queryAs(PasswordField.class);
           assertEquals("aljaljak2",kime.getText() );
           robot.clickOn("#listView").clickOn( " ");
           robot.clickOn("#txfIme");
           robot.write("Almedin");
            robot.clickOn("#txfPrezime");
            robot.write("Šehić");
             robot.clickOn("#txfEmail");
             robot.write("asehic1@etf.unsa.ba");
            robot.clickOn("#txfKorisnickoIme");
            robot.write("asehic1");
            robot.clickOn("#pswfLozinka");
            robot.write("12345");
            robot.clickOn("#listView").clickOn("Hamza Iseric");
            robot.clickOn("#listView").clickOn("Almedin Šehić");
            assertEquals("Šehić", prezime.getText());
            assertEquals("asehic1", kime.getText());
           Button btnKraj=robot.lookup("#btnKraj").queryAs(Button.class);
           robot.clickOn("#btnKraj");


 }
}