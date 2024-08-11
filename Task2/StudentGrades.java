package Task2;
import java.util.*;
public class StudentGrades {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Validate number of subjects
        if (numberOfSubjects <= 0) {
            System.out.println("Number of subjects should be greater than 0.");
            return;
        }

        int totalMarks = 0;
        int[] marks = new int[numberOfSubjects];

        // Input marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            int mark = scanner.nextInt();

            // Validate mark input
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid mark. Please enter a value between 0 and 100.");
                i--; // Re-take input for this subject
                continue;
            }

            marks[i] = mark;
            totalMarks += mark;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        String grade = determineGrade(averagePercentage);

        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static String determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C+";
        } else if (averagePercentage >= 40) {
            return "C";
        } else {
            return "D";
        }
    }

}
