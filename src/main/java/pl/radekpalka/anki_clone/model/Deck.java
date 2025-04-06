package pl.radekpalka.anki_clone.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private String title;
    List<Flashcard> flashcards = new ArrayList<>();

    public Deck(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addFlashcard (Flashcard flashcard){
        flashcards.add(flashcard);
    }

    @Override
    public String toString(){
        StringBuilder message = new StringBuilder();
        message.append("Title: " + title +"\n");
        for (var flashcard : flashcards){
            message.append(flashcard.toString()+ "\n");
        }
        return message.toString();
    }
   
}
