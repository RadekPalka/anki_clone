package pl.radekpalka.anki_clone.util;

import java.io.File;

public class Paths {
    private static final String USER_HOME = System.getProperty("user.home");
    public static final String DECKS_FOLDER = USER_HOME + File.separator + "Documents" + File.separator + "anki_clone" + File.separator + "user-decks";
}
