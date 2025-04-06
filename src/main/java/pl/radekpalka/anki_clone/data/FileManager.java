package pl.radekpalka.anki_clone.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pl.radekpalka.anki_clone.model.Deck;

public class FileManager {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveDeck(Deck deck, String directoryPath) {
        
        String fileName = deck.getTitle().replaceAll("\\s+", "_") + ".json";
        
        File dir = new File(directoryPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (FileWriter writer = new FileWriter(new File(dir, fileName))) {
            gson.toJson(deck, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
