package lang_utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sentence composed of {@code Word} and {@code PunctuationMark} objects.
 */
public class Sentence {
    private final List<Object> components;

    /**
     * Constructs a {@code Sentence} object by parsing the specified string.
     *
     * @param sentence the string representation of the sentence
     */
    public Sentence(String sentence) {
        components = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                buffer.append(c);
            } else {
                if (!buffer.isEmpty()) {
                    components.add(new Word(buffer.toString()));
                    buffer.setLength(0);
                }
                if (Character.isWhitespace(c)) {
                    components.add(" ");
                } else {
                    components.add(new PunctuationMark(c));
                }
            }
        }

        if (!buffer.isEmpty()) {
            components.add(new Word(buffer.toString()));
        }
    }

    /**
     * @return the list of components of the sentence (words and punctuations)
     */
    public List<Object> getComponents() {
        return components;
    }

    /**
     * @return the string representation of the sentence
     */
    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Object component : components) {
            sentence.append(component);
        }
        return sentence.toString();
    }
}

