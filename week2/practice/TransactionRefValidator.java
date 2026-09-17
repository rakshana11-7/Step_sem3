package week2.practice;

public class TransactionRefValidator {

    /**
     * Normalizes a raw reference code by trimming whitespace and converting
     * the first 3 characters (bank code) to uppercase.
     */
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }

        String trimmed = raw.trim();

        // If string length is less than 3, uppercase what is available
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase the first 3 characters and preserve the rest
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);

        return bankCode + remainder;
    }

    /**
     * Validates the normalized reference code and returns a formatted string
     * or a specific validation error message.
     */
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // 1. Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // 2. Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be non-digit free";
            }
        }

        // 3. Extract components
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        // 4. Build formatted string using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        sb.append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    /**
     * Helper pipeline to normalize, validate, and print the output.
     */
    public static void processReference(String rawInput) {
        String normalized = normalizeReference(rawInput);
        String result = validateAndFormat(normalized);
        System.out.printf("Input: \"%s\" -> %s%n", rawInput, result);
    }

    public static void main(String[] args) {
        // Valid Inputs
        processReference(" hdf03022600042 ");
        processReference("icic15082599999");

        // Invalid Inputs
        processReference("12F03022600042"); // Non-letter bank code
        processReference("hdf0302260004"); // Wrong length (13 chars)
        processReference("hdf0302260004A"); // Non-digit body
    }
}