package lang_utils;


/**
 * Represents a single letter in a word.
 */
public class Letter {
    private final char value;

    /**
     * Constructs a {@code Letter} object with the specified character.
     *
     * @param value the character value of the letter
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * @return the character value
     */
    public char getValue() {
        return value;
    }

    /**
     * @return the string representation of the letter
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

