package week2.practice;

public class CsvStudentParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Split by comma with -1 limit to keep trailing empty strings
        String[] fields = csvLine.split(",", -1);

        // Validate that exactly 3 fields exist
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        // Trim individual field values to handle accidental extra spaces
        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        // Check if any required field is empty after trimming
        if (name.isEmpty() || rollNo.isEmpty() || dept.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, rollNo, dept);
    }

    public static void main(String[] args) {
        // Valid Input
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");

        // Edge Cases & Invalid Inputs
        parseStudentRecord("Rahul Sharma,RA2211003010124"); // Too few fields
        parseStudentRecord("Priya,RA2211003010125,ECE,2026"); // Too many fields
        parseStudentRecord("Karan, ,IT"); // Empty field
    }
}