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
import pl.radekpalka.anki_clone.model.Deck;
import pl.radekpalka.anki_clone.model.Flashcard;

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
    private void createNewDeck(){
        String title= deckTitle.getText().trim();
        if (title.isEmpty()){
            title = "New Deck";
        }

        Deck deck = new Deck(title);
        
        for (var controller : flashcardControllers){
            String front = controller.getFront().trim();
            String back = controller.getBack().trim();
            if (!front.isEmpty() && !back.isBlank()){
                var flashcard = new Flashcard(front, back);
                deck.addFlashcard(flashcard);
            }
        }

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
