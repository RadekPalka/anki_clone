package pl.radekpalka.anki_clone.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController {

    @FXML
    private void handleClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/radekpalka/anki_clone/add-deck-view.fxml")); // <- TO BYŁO POMINIĘTE
        Parent root = loader.load(); // <- tu był problem
    
        Stage dialogStage = new Stage();
        dialogStage.setScene(new Scene(root));
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("Add new deck");
        dialogStage.showAndWait();
    }
}