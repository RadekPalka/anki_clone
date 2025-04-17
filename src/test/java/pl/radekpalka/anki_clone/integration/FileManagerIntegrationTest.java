package pl.radekpalka.anki_clone.integration;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import pl.radekpalka.anki_clone.data.FileManager;
import pl.radekpalka.anki_clone.model.Deck;
import pl.radekpalka.anki_clone.model.Flashcard;

public class FileManagerIntegrationTest {
    static final String TEST_FILE_PATH = "testing-decks";
    @Test
    void shouldSaveAndLoadDeckCorrectly(){
        Deck originalDeck = new Deck("Integration deck test");

        FileManager.saveDeck(originalDeck, TEST_FILE_PATH);
        List<Deck> loadedDecks = FileManager.loadAllDecks(TEST_FILE_PATH);

        assertFalse(loadedDecks.isEmpty(), "Deck list should not be empty");
        assertEquals(originalDeck.getTitle(), loadedDecks.get(0).getTitle(), "Deck title should match");
        
        deleteTestFolder();
    }

    @Test
    void shouldSaveAndLoadDeckWithFlashcardsCorrectly(){
        Deck originalDeck = new Deck("Testing");
        String front = "test front";
        String back = "test back";
        originalDeck.getFlashcards().add(new Flashcard(front, back));

        FileManager.saveDeck(originalDeck, TEST_FILE_PATH);
        List<Deck> loadedDecks = FileManager.loadAllDecks(TEST_FILE_PATH);
        List<Flashcard> testFlashcards = loadedDecks.get(0).getFlashcards();

        assertEquals(originalDeck.getFlashcards().size(), testFlashcards.size(), "Size should be one");

        assertEquals(front, testFlashcards.get(0).getFront(), "Front should be 'test front");

        assertEquals(back, testFlashcards.get(0).getBack(), "Front should be 'test back");

        deleteTestFolder();
    }

    static void deleteTestFolder(){
        File testFolder = new File(TEST_FILE_PATH);
        File[] files = testFolder.listFiles();
        if (files != null) {
            for (File file : files) {
            file.delete();
            }
        }
        testFolder.delete();
    }

}
