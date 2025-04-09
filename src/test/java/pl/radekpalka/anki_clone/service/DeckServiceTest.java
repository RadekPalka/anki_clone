package pl.radekpalka.anki_clone.service;


import org.junit.jupiter.api.Test;
import pl.radekpalka.anki_clone.model.Deck;
import pl.radekpalka.anki_clone.model.Flashcard;
import pl.radekpalka.anki_clone.service.DeckService;


import static org.junit.jupiter.api.Assertions.*;

public class DeckServiceTest {
    
    @Test
    void shouldAddValidFlashcard() {
        Deck deck = new Deck("Test");
        DeckService.addFlashcardIfValid(deck, "front", "back");
        assertEquals(1, deck.flashcards.size());
    }
}
