package week1.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class Uniqueletterhunt {

    /**
     * Finds the first non-repeating character in a given string.
     * Uses an array-based frequency map for standard ASCII characters.
     * 
     * Time Complexity: O(n) | Space Complexity: O(1) [fixed size 256 array]
     * 
     * @return First non-repeating char, or '\0' (null character) if none exists.
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Frequency array for ASCII (256 characters)
        int[] counts = new int[256];

        // Pass 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i)]++;
        }

        // Pass 2: Find the first character with a count of 1
        for (int i = 0; i < text.length(); i++) {
            if (counts[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Return null char if no unique character exists
    }

    /**
     * Alternative approach using LinkedHashMap (preserves insertion order).
     * Works with all Unicode characters outside standard ASCII.
     */
    public static char findFirstNonRepeatingCharMap(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        Map<Character, Integer> counts = new LinkedHashMap<>();

        for (char ch : text.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0';
    }

    /**
     * Helper method to display search results in the requested format.
     */
    public static void printResult(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.printf("Input: \"%s\" -> First Non-Repeating Character: '%c'%n", text, result);
        } else {
            System.out.printf("Input: \"%s\" -> No Non-Repeating Character Found%n", text);
        }
    }

    public static void main(String[] args) {
        printResult("swiss");
        printResult("aabbcc");
        printResult("codelearning");
    }
}