package ba.unsa.etf.rpr.vjezba7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        KorisniciModel model=new KorisniciModel();
        model.napuni();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("izgled.fxml"));

        fxmlLoader.setController(new Controller(model));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}