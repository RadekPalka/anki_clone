package pl.radekpalka.anki_clone.service;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.radekpalka.anki_clone.model.Deck;

public class DeckServiceTest {

    private Deck deck;

    @BeforeEach
    void setup(){
        deck = new Deck("Testing");
    }
    
    @Test
    void flashcardWithTwoEmptyStringsIsNotAdded() {
        DeckService.addFlashcardIfValid(deck, "", "");
        assertTrue(deck.getFlashcards().isEmpty());
    }

    @Test
    void flashCardWithOneEmptyStringIsNotAdded(){
        DeckService.addFlashcardIfValid(deck, "front", "");
        assertTrue(deck.getFlashcards().isEmpty());
    }

    @Test
    void flashCardWithTwoNullsIsNotAdded(){
        DeckService.addFlashcardIfValid(deck, null, null);
        assertTrue(deck.getFlashcards().isEmpty());
    }

    @Test
    void flashCardWithOneNullIsNotAdded(){
        DeckService.addFlashcardIfValid(deck, "front", null);
        assertTrue(deck.getFlashcards().isEmpty());
    }
}
