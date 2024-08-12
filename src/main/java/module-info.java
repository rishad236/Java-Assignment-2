module ca.georgiancollege2330 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens ca.georgiancollege2330 to javafx.fxml;
    exports ca.georgiancollege2330;
}
