module pl.radekpalka.anki_clone {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens pl.radekpalka.anki_clone.controller to javafx.fxml;
    opens pl.radekpalka.anki_clone to javafx.fxml;
    opens pl.radekpalka.anki_clone.model to com.google.gson;

    exports pl.radekpalka.anki_clone;
    exports pl.radekpalka.anki_clone.controller;
}
