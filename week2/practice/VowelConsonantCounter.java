package week2.practice;

public class VowelConsonantCounter {

    /**
     * Counts and displays the number of vowels and consonants in a text string.
     * Ignores spaces and non-alphabetical characters.
     */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        // Convert to lowercase once to simplify checking
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);

            // Check if character is an alphabetic letter (A-Z or a-z)
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d%n", vowels, consonants);
    }

    public static void main(String[] args) {
        System.out.print("Input: \"Java Programming\" -> ");
        countVowelsAndConsonants("Java Programming");

        System.out.print("Input: \"Library Kiosk 2026\" -> ");
        countVowelsAndConsonants("Library Kiosk 2026");
    }
}