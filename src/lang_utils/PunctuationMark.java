package lang_utils;

/**
 * Represents a punctuation mark in a sentence.
 */
public class PunctuationMark {
    private final char value;

    /**
     * Constructs a {@code PunctuationMark} object with the specified character.
     *
     * @param value the character value of the punctuation mark
     */
    public PunctuationMark(char value) {
        this.value = value;
    }

    /**
     * @return the character value
     */
    public char getValue() {
        return value;
    }


    /**
     * @return the string representation of the punctuation mark
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

