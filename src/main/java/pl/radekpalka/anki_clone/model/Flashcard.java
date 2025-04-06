package pl.radekpalka.anki_clone.model;

public class Flashcard {
    private String front;
    private String back;
    
    public Flashcard(String front, String back){
        this.front = front;
        this.back = back;
    }
    public String getFront(){
        return front;
    }

    public String getBack(){
        return back;
    }

    @Override
    public String toString(){
        return String.format("front: %s, back: %s", front, back);
    }
}
