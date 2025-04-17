package pl.radekpalka.anki_clone.controller;
import java.io.IOException;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.radekpalka.anki_clone.data.UserData;
import pl.radekpalka.anki_clone.model.Deck;
import pl.radekpalka.anki_clone.util.ModalHelper;

public class MainViewController{

    @FXML
    private VBox decksContainer;

    @FXML
    public void initialize(){
        UserData.updateDecksFromLocalDrive();

        UserData.getDecks().addListener((ListChangeListener<Deck>) change -> {
        while (change.next()) {
            if (change.wasAdded() || change.wasRemoved()) {
                renderDeckList();
            }
        }
    });

        renderDeckList();
    }

    private void renderDeckList() {
    decksContainer.getChildren().clear();

    for (Deck deck : UserData.getDecks()) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/radekpalka/anki_clone/deck-preview.fxml"));
            HBox deckRow = loader.load();

            DeckPreviewController controller = loader.getController();
            controller.setDeck(deck);

            decksContainer.getChildren().add(deckRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


    @FXML
    private void addDeck() throws IOException {
        ModalHelper.showModal("/pl/radekpalka/anki_clone/add-deck-view.fxml", "Add new deck");
    }
    @FXML
    private void getOfficialDecks() throws IOException{
        ModalHelper.showModal("/pl/radekpalka/anki_clone/official-decks-view.fxml", "Official decks");
    }
}