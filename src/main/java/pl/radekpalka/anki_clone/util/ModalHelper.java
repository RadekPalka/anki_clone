package pl.radekpalka.anki_clone.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ModalHelper {
    public static void showModal(String fxmlPath, String title) throws IOException, IOException {
        FXMLLoader loader = new FXMLLoader(ModalHelper.class.getResource(fxmlPath));
        Parent root = loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setScene(new Scene(root));
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle(title);
        dialogStage.showAndWait();
    }
}

