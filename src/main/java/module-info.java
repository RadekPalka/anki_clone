module pl.radekpalka.anki_clone {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.radekpalka.anki_clone to javafx.fxml;
    exports pl.radekpalka.anki_clone;
}
