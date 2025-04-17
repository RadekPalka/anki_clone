package pl.radekpalka.anki_clone.integration;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import pl.radekpalka.anki_clone.data.FileManager;
import pl.radekpalka.anki_clone.model.Deck;

public class FileManagerIntegrationTest {
    @Test
    void shouldSaveAndLoadDeckCorrectly(){
        String testFilePath = "testing-decks";
        Deck originalDeck = new Deck("Integration deck test");

        FileManager.saveDeck(originalDeck, testFilePath);
        List<Deck> loadedDecks = FileManager.loadAllDecks(testFilePath);

        assertFalse(loadedDecks.isEmpty(), "Deck list should not be empty");
        assertEquals(originalDeck.getTitle(), loadedDecks.get(0).getTitle(), "Deck title should match");
        
        File testFolder = new File(testFilePath);
        File[] files = testFolder.listFiles();
        if (files != null) {
            for (File file : files) {
            file.delete();
            }
        }
        testFolder.delete();
    }

}
