package lang_utils;

/**
 * Represents a sentence composed of {@code Word} and {@code PunctuationMark} objects.
 */
public class Sentence {
    private final SentenceComponent[] components;

    /**
     * Constructs a {@code Sentence} object by parsing the specified string.
     *
     * @param sentence the string representation of the sentence
     */
    public Sentence(String sentence) {
        int size = sentence.length();
        SentenceComponent[] tempComponents = new SentenceComponent[size];
        int index = 0;
        StringBuilder buffer = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                buffer.append(c);
            } else {
                if (!buffer.isEmpty()) {
                    tempComponents[index++] = new Word(buffer.toString());
                    buffer.setLength(0);
                }
                if (Character.isWhitespace(c)) {
                    tempComponents[index++] = new PunctuationMark(' ');
                } else {
                    tempComponents[index++] = new PunctuationMark(c);
                }
            }
        }

        if (!buffer.isEmpty()) {
            tempComponents[index++] = new Word(buffer.toString());
        }

        if (index < tempComponents.length) {
            SentenceComponent[] exactComponents = new SentenceComponent[index];
            System.arraycopy(tempComponents, 0, exactComponents, 0, index);
            components = exactComponents;
        } else {
            components = tempComponents;
        }
    }

    /**
     * @return the array of components of the sentence (words and punctuations)
     */
    public SentenceComponent[] getComponents() {
        return components;
    }

    /**
     * @return the string representation of the sentence
     */
    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (SentenceComponent component : components) {
            sentence.append(component);
        }
        return sentence.toString();
    }
}

