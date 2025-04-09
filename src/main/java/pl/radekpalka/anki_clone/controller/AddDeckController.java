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
import javafx.stage.Stage;
import pl.radekpalka.anki_clone.data.FileManager;
import pl.radekpalka.anki_clone.data.UserData;
import pl.radekpalka.anki_clone.model.Deck;
import pl.radekpalka.anki_clone.model.Flashcard;
import pl.radekpalka.anki_clone.util.Paths;

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
        UserData.getDecks().add(deck);
        for (var controller : flashcardControllers){
            String front = controller.getFront().trim();
            String back = controller.getBack().trim();
            if (!front.isEmpty() && !back.isEmpty()){
                var flashcard = new Flashcard(front, back);
                deck.addFlashcard(flashcard);
            }
        }

        FileManager.saveDeck(deck, Paths.DECKS_FOLDER);
        Stage stage = (Stage) deckTitle.getScene().getWindow();
        stage.close();
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
