package pl.radekpalka.anki_clone.data;


import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.radekpalka.anki_clone.model.Deck;
import pl.radekpalka.anki_clone.util.FilePaths;

public class UserData {
    private static ObservableList<Deck> decks = FXCollections.observableArrayList();

    public static ObservableList<Deck> getDecks() {
        return decks;
    }

    public static void updateDecksFromLocalDrive(){
        List<Deck> newDecks =  FileManager.loadAllDecks(FilePaths.DECKS_FOLDER);
        decks.addAll(newDecks);
    }


}
