package lang_utils;

/**
 * Represents a text composed of {@code Sentence} objects.
 */
public class Text {
    private final Sentence[] sentences;

    /**
     * Constructs a {@code Text} object by parsing the specified string.
     *
     * @param text the string representation of the text
     */
    public Text(String text) {
        String normalizedText = text.replaceAll("[ \\t]+", " ");
        String[] splitSentences = normalizedText.split("(?<=[.!?])");
        sentences = new Sentence[splitSentences.length];

        for (int i = 0; i < splitSentences.length; i++) {
            sentences[i] = new Sentence(splitSentences[i]);
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


