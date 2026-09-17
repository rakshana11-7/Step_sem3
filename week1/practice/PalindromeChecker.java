package week1.practice;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null)
            return false;

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Recursive Approach:
     * Recursively compares first and last characters, shrinking the substring
     * bounds.
     * Time Complexity: O(n) | Space Complexity: O(n) call stack memory
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null)
            return false;
        return isPalindromeRecursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int left, int right) {
        // Base cases: single character or empty string remains
        if (left >= right) {
            return true;
        }
        // Character mismatch
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        // Recurse towards the center
        return isPalindromeRecursiveHelper(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null)
            return false;

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return String.valueOf(original).equals(String.valueOf(reversed));
    }

    /**
     * Utility method to run all three checks and display results in the target
     * format.
     */
    public static void verifyPalindrome(String text) {
        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean reversalResult = isPalindromeArrayReversal(text);

        String iterLabel = iterativeResult ? "Palindrome" : "Not Palindrome";
        String recurLabel = recursiveResult ? "Palindrome" : "Not Palindrome";
        String revLabel = reversalResult ? "Palindrome" : "Not Palindrome";

        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                iterLabel, recurLabel, revLabel);
    }

    public static void main(String[] args) {
        verifyPalindrome("madam");
        verifyPalindrome("hello");
    }
}