package pl.radekpalka.anki_clone.service;

import pl.radekpalka.anki_clone.data.UserData;
import pl.radekpalka.anki_clone.model.Deck;
import pl.radekpalka.anki_clone.model.Flashcard;

public class DeckService {
    public static void addFlashcardIfValid(Deck deck, String front, String back){
        if (front == null || back == null) return;

        front = front.trim();
        back = back.trim();
        
        if (!front.isEmpty() && !back.isEmpty()){
                var flashcard = new Flashcard(front, back);
                deck.addFlashcard(flashcard);
            }
    }

    public static String provideDefaultIfBlank(String title){
        if (title.isBlank()){
            return "New deck";
        }
        return title.trim();
    }

    public static String addIndexWhenTitleIsRepeated(String title){
        long index = (int) UserData.getDecks().stream().filter(deck -> deck.getTitle().startsWith(title)).count();
        
        if (index == 0){
            return title;
        }
        
        return String.format("%s(%d)", title,index);
    }
}
