package pl.radekpalka.anki_clone.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pl.radekpalka.anki_clone.model.Deck;

public class DeckPreviewController {
    @FXML
    private Button deckButton;

    private Deck deck;

    public void setDeck(Deck deck) {
        this.deck = deck;
        deckButton.setText(deck.getTitle());
    }

    @FXML
    private void handleOpen() {
        System.out.println("Otwieram talię: " + deck.getTitle());
       
    }
}
