package week1.practice;

import java.util.Random;

public class Bmicalculator {

   
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Computes BMI values and displays a formatted wellness report for the team.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid input: Arrays must be non-null and equal in length.");
            return;
        }

        // Table Header
        System.out.println("=====================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n", 
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("=====================================================================");

        // Process each team member
        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];

            // Avoid division by zero
            double bmi = (height > 0) ? weight / (height * height) : 0;
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    (i + 1), height, weight, bmi, status);
        }

        System.out.println("=====================================================================");
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        Random random = new Random();

        // Generate realistic random data for demonstration
        // Height: 1.50 m to 2.00 m | Weight: 45.0 kg to 110.0 kg
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + (0.50 * random.nextDouble());
            weights[i] = 45.0 + (65.0 * random.nextDouble());
        }

        // Print report
        printWellnessReport(heights, weights);
    }
}
    
}
