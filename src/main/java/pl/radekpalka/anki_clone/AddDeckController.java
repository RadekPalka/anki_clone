package pl.radekpalka.anki_clone;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddDeckController {

    @FXML
    private Label titleLabel;

    @FXML
    private TextField deckTitle;

    @FXML
    private void initialize() {
    Platform.runLater(() -> titleLabel.requestFocus());
}

    @FXML
    private void handleAddDeck() {
        System.out.print("Hello");
    }
    @FXML
    private void saveDeck(){
        deckTitle.getText();
        System.out.println(deckTitle.getText());
    }
}
