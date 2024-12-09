package lang_utils;

/**
 * Represents a component of a sentence, such as a word or a punctuation mark.
 * Each implementing class must provide a string representation of the component.
 */
public interface SentenceComponent {
    /**
     * @return the string representation of the component
     */
    @Override
    String toString();
}
