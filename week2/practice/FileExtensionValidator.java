package week2.practice;

public class FileExtensionValidator {

    /**
     * Validates if a given filename ends with an allowed extension (pdf, docx,
     * zip).
     * Case-insensitive evaluation.
     * 
     * @param filename The full name of the file
     * @return "Accepted" or "Rejected — invalid file type"
     */
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Rejected — invalid file type";
        }

        // Find the index of the last dot in the filename
        int lastDotIndex = filename.lastIndexOf('.');

        // Check if dot exists and is not the last character (e.g., "filename.") or
        // first character (hidden files like ".pdf")
        if (lastDotIndex <= 0 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        // Extract extension starting right after the dot
        String extension = filename.substring(lastDotIndex + 1);

        // Check against allowed extensions (case-insensitively)
        if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        // Sample Test Cases
        System.out.println("Assignment1.PDF -> " + validateFileExtension("Assignment1.PDF"));
        System.out.println("notes.txt       -> " + validateFileExtension("notes.txt"));

        // Additional Edge Cases
        System.out.println("project.final.zip -> " + validateFileExtension("project.final.zip")); // Multiple dots
        System.out.println("report.DocX       -> " + validateFileExtension("report.DocX")); // Mixed case
        System.out.println("noextension       -> " + validateFileExtension("noextension")); // No dot
        System.out.println(".pdf              -> " + validateFileExtension(".pdf")); // Hidden file edge case
    }
}