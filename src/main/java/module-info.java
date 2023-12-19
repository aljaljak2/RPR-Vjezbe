module com.example.labvjezba7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ba.unsa.etf.rpr.vjezba7 to javafx.fxml;
    exports ba.unsa.etf.rpr.vjezba7;
}