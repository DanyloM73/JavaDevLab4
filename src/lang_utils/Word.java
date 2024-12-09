package lang_utils;

/**
 * Represents a word composed of {@code Letter} objects.
 */
public class Word implements SentenceComponent {
    private final Letter[] letters;

    /**
     * Constructs a {@code Word} object by parsing the specified string.
     *
     * @param word the string representation of the word
     */
    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * @return the number of letters in the word
     */
    public int length() {
        return letters.length;
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
