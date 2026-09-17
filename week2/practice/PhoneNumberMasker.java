package week2.practice;

public class PhoneNumberMasker {

    /**
     * Validates and masks a 10-digit phone number, hiding the first 6 digits.
     * 
     * @param phone The input phone number string
     * @return Formatted string "XXXXXX-1234" or "Invalid phone number"
     */
    public static String maskPhoneNumber(String phone) {
        // Null check and exact length check (must be 10 characters)
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate that all 10 characters are numeric digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Extract last 4 digits
        String lastFourDigits = phone.substring(6);

        // Build masked phone number using StringBuilder
        StringBuilder maskedBuilder = new StringBuilder();
        maskedBuilder.append("XXXXXX");
        maskedBuilder.append(lastFourDigits);
        maskedBuilder.insert(6, "-"); // Insert hyphen after the 6th character

        return maskedBuilder.toString();
    }

    public static void main(String[] args) {
        // Valid Inputs
        System.out.println("9876543210 -> " + maskPhoneNumber("9876543210"));

        // Invalid Inputs
        System.out.println("98765      -> " + maskPhoneNumber("98765"));
        System.out.println("98765432101-> " + maskPhoneNumber("98765432101"));
        System.out.println("98765a3210 -> " + maskPhoneNumber("98765a3210"));
    }
}