package pl.radekpalka.anki_clone.service;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertTrue(deck.getFlashcards().isEmpty(), "Flashcard with empty strings should not be added");
    }

    @Test
    void flashCardWithOneEmptyStringIsNotAdded(){
        DeckService.addFlashcardIfValid(deck, "front", "");
        assertTrue(deck.getFlashcards().isEmpty(), "Flashcard with one empty string should not be added");
    }

    @Test
    void flashCardWithTwoNullsIsNotAdded(){
        DeckService.addFlashcardIfValid(deck, null, null);
        assertTrue(deck.getFlashcards().isEmpty(), "Flashcard with null values should not be added");
    }

    @Test
    void flashCardWithOneNullIsNotAdded(){
        DeckService.addFlashcardIfValid(deck, "front", null);
        assertTrue(deck.getFlashcards().isEmpty(), "Flashcard with one null value should not be added");
    }
    @Test
    void flashcardWithOnlySpacesIsNotAdded(){
        DeckService.addFlashcardIfValid(deck, " ", "back");
        assertTrue(deck.getFlashcards().isEmpty(), "Flashcard with only whitespace should not be added to the deck");
    }
    
    @Test
    void validFlashcardIsAddedToDeckWithCorrectValues(){
        String front = "front";
        String back = "back";
        DeckService.addFlashcardIfValid(deck, front, back);

        assertEquals(1, deck.getFlashcards().size(), 
        "Deck should contain exactly one flashcard when valid data is provided");

    assertAll("Flashcard content should match input values",
        () -> assertEquals(front, deck.getFlashcards().get(0).getFront(), 
            "Front value does not match expected"),
        () -> assertEquals(back, deck.getFlashcards().get(0).getBack(), 
            "Back value does not match expected")
    );
    }

    @Test
    void deckWithEmptyTitleShouldBeHandledProperly(){
        Deck deckWithEmptyTitle = new Deck("");
        
        assertEquals("New deck", deckWithEmptyTitle.getTitle());
    }

    @Test
    void deckWithSpaceInTitleShouldBeHandledProperly(){
        Deck deckWithSpaceInTitle = new Deck(" ");
        
        assertEquals("New deck", deckWithSpaceInTitle.getTitle());
    }
}
