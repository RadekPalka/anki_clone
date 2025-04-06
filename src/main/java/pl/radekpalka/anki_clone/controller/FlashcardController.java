package pl.radekpalka.anki_clone.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FlashcardController {
    @FXML
    private TextField frontInput;

    @FXML
    private TextField backInput;

    public String getFront() {
        return frontInput.getText().trim();
    }

    public String getBack() {
        return backInput.getText().trim();
    }
}
