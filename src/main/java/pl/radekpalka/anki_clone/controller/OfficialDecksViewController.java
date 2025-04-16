package pl.radekpalka.anki_clone.controller;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pl.radekpalka.anki_clone.api.ApiRoutes;
import pl.radekpalka.anki_clone.api.DeckApiClient;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import pl.radekpalka.anki_clone.model.Deck;

public class OfficialDecksViewController {

    @FXML
    private VBox officialDecksContainer;

    @FXML
    public void initialize(){
        String json = DeckApiClient.getDecksFrom(ApiRoutes.OFFICIAL);
        System.out.println(json);
        Type deckListType = new TypeToken<List<Deck>>() {}.getType();
        List<Deck> officialDecks = new Gson().fromJson(json, deckListType);

        for (Deck deck : officialDecks){
            System.out.println(deck);
            Button deckButton = new Button(deck.getTitle());
            deckButton.setOnAction(e -> {
                System.out.println("Clicked deck: " + deck.getTitle());
            });
            officialDecksContainer.getChildren().add(deckButton);
        }
   }

}
