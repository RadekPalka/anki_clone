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
import pl.radekpalka.anki_clone.service.DeckService;
import pl.radekpalka.anki_clone.util.FilePaths;

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
        String title= deckTitle.getText();
        
        String cleanedTitle = DeckService.provideDefaultIfBlank(title);
        String verifiedTitle = DeckService.addIndexWhenTitleIsRepeated(cleanedTitle);
        
        Deck deck = new Deck(verifiedTitle);
        
        UserData.getDecks().add(deck);
        for (var controller : flashcardControllers){
            String front = controller.getFront();
            String back = controller.getBack();
            DeckService.addFlashcardIfValid(deck, front, back);
        }

        FileManager.saveDeck(deck, FilePaths.DECKS_FOLDER);
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
