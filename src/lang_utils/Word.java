package lang_utils;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a word composed of {@code Letter} objects.
 */
public class Word {
    private final List<Letter> letters;

    /**
     * Constructs a {@code Word} object by parsing the specified string.
     *
     * @param word the string representation of the word
     */
    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * @return the number of letters in the word
     */
    public int length() {
        return letters.size();
    }

    /**
     * @return the string representation of the word
     */
    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter);
        }
        return word.toString();
    }
}

