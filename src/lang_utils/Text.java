package lang_utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a text composed of {@code Sentence} objects.
 */
public class Text {
    private final List<Sentence> sentences;

    /**
     * Constructs a {@code Text} object by parsing the specified string.
     *
     * @param text the string representation of the text
     */
    public Text(String text) {
        sentences = new ArrayList<>();
        String normalizedText = text.replaceAll("[ \\t]+", " ");
        String[] splitSentences = normalizedText.split("(?<=[.!?])");

        for (String sentence : splitSentences) {
            sentences.add(new Sentence(sentence));
        }
    }

    /**
     * Replaces words of a specified length with a replacement string.
     *
     * @param wordLength  the length of the words to replace
     * @param replacement the replacement string
     * @return a {@link StringBuilder} with the replaced text
     */
    public StringBuilder replaceWords(int wordLength, String replacement) {
        StringBuilder result = new StringBuilder();

        for (Sentence sentence : sentences) {
            for (Object component : sentence.getComponents()) {
                if (component instanceof Word word && word.length() == wordLength) {
                    result.append(replacement);
                } else {
                    result.append(component);
                }
            }
        }
        return result;
    }

    /**
     * @return the string representation of the text
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Sentence sentence : sentences) {
            text.append(sentence).append(" ");
        }
        return text.toString().trim();
    }
}

