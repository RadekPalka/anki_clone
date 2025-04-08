package pl.radekpalka.anki_clone.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.radekpalka.anki_clone.data.UserData;

public class MainViewController{

    @FXML
    private VBox decksContainer;

    @FXML
    public void initialize(){
        UserData.updateDecksFromLocalDrive();

        for (var deck : UserData.getDecks()){
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/radekpalka/anki_clone/add-deck-view.fxml")); // <- TO BYŁO POMINIĘTE
        Parent root = loader.load();
    
        Stage dialogStage = new Stage();
        dialogStage.setScene(new Scene(root));
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("Add new deck");
        dialogStage.showAndWait();
    }
}