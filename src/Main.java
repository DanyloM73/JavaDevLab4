import lang_utils.Text;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class to demonstrate text processing functionality.
 * <p>
 * This program reads input text, replaces words of a specified length with a replacement string,
 * and prints the result. It validates user input for correctness.
 * </p>
 */
public class Main {
    /**
     * Entry point of the program.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompting and validating input text
            String inputText = validateInput(scanner, "Enter text: ", String.class);
            Text text = new Text(inputText);

            // Prompting and validating word length
            int wordLength = validateInput(scanner, "Enter the length of the word to replace: ", Integer.class);

            // Prompting and validating replacement string
            String replacement = validateInput(scanner, "Enter the string to replace the words with: ", String.class);

            // Processing the text
            StringBuilder result = text.replaceWords(wordLength, replacement);

            // Displaying the result
            System.out.println("The result of the replacement: " + result);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Validates and retrieves user input based on the specified type.
     *
     * @param <T>    the type of input expected (String or Integer)
     * @param scanner the {@link Scanner} object for reading user input
     * @param prompt  the message displayed to the user
     * @param type    the expected type of input (String.class or Integer.class)
     * @return the validated user input of type {@code T}
     * @throws IllegalArgumentException if an unsupported type is specified
     */
    public static <T> T validateInput(Scanner scanner, String prompt, Class<T> type) {
        T input = null;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            try {
                switch (type.getSimpleName()) {
                    case "Integer":
                        int intValue = scanner.nextInt();
                        if (intValue <= 0) {
                            System.out.println("Invalid input. Number must be greater than zero.");
                        } else {
                            input = type.cast(intValue);
                            validInput = true;
                            scanner.nextLine();
                        }
                        break;

                    case "String":
                        String stringValue = scanner.nextLine();
                        if (stringValue.isBlank()) {
                            System.out.println("Invalid input. String cannot be blank.");
                        } else {
                            input = type.cast(stringValue);
                            validInput = true;
                        }
                        break;

                    default:
                        System.out.println("Unsupported type for input.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a value in the correct format.");
                scanner.next();
            }
        }
        return input;
    }
}