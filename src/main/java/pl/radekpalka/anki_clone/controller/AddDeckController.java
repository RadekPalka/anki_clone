package pl.radekpalka.anki_clone.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddDeckController {
    private final List<FlashcardController> flashcardControllers = new ArrayList<>();

    @FXML
    private VBox cardsContainer;
    
    @FXML
    private Label titleLabel;

    @FXML
    private TextField deckTitle;

    @FXML
    private void initialize() {
    Platform.runLater(() -> titleLabel.requestFocus());
}

    @FXML
    private void saveDeck(){
        deckTitle.getText();
        System.out.println(deckTitle.getText());
    }

    @FXML
    private void handleAddFlashCard() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/radekpalka/anki_clone/flashcard.fxml"));
    HBox cardRow = loader.load();

    FlashcardController controller = loader.getController();
    flashcardControllers.add(controller);

    cardsContainer.getChildren().add(cardRow);
}
}
