package pl.radekpalka.anki_clone.service;

import pl.radekpalka.anki_clone.model.Deck;
import pl.radekpalka.anki_clone.model.Flashcard;

public class DeckService {
    public static void addFlashcardIfValid(Deck deck, String front, String back){
        if (front != null && back != null && !front.isEmpty() && !back.isEmpty()){
                var flashcard = new Flashcard(front, back);
                deck.addFlashcard(flashcard);
            }
    }
}
