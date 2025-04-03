package pl.radekpalka.anki_clone;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FlashCardController {
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
