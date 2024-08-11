package Task5;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class StudentManagementSystem {
    private static final String FILE_NAME = "students.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add New Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        if (!validateId(id)) {
            System.out.println("Invalid ID format. ID should be non-empty.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        if (!validateName(name)) {
            System.out.println("Invalid name. Name should be non-empty.");
            return;
        }

        System.out.print("Enter student age: ");
        int age = Integer.parseInt(scanner.nextLine());
        if (age <= 0) {
            System.out.println("Invalid age. Age should be positive.");
            return;
        }

        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        if (!validateGrade(grade)) {
            System.out.println("Invalid grade. Grade should be non-empty.");
            return;
        }

        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(id + "," + name + "," + age + "," + grade);
            bw.newLine();
            System.out.println("Student added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the student.");
            e.printStackTrace();
        }
    }

    private static void editStudent() {
        System.out.print("Enter student ID to edit: ");
        String idToEdit = scanner.nextLine();

        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(idToEdit + ",")) {
                    found = true;
                    System.out.print("Enter new student name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new student age: ");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new student grade: ");
                    String newGrade = scanner.nextLine();

                    lines.add(idToEdit + "," + newName + "," + newAge + "," + newGrade);
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while editing the student.");
            e.printStackTrace();
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
                System.out.println("Student information updated successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while saving changes.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Student ID not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        String idToSearch = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(idToSearch + ",")) {
                    String[] parts = line.split(",");
                    System.out.println("Student ID: " + parts[0]);
                    System.out.println("Name: " + parts[1]);
                    System.out.println("Age: " + parts[2]);
                    System.out.println("Grade: " + parts[3]);
                    return;
                }
            }
            System.out.println("Student not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while searching for the student.");
            e.printStackTrace();
        }
    }

    private static void displayAllStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("Student ID: " + parts[0]);
                System.out.println("Name: " + parts[1]);
                System.out.println("Age: " + parts[2]);
                System.out.println("Grade: " + parts[3]);
                System.out.println("----------------------------");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while displaying all students.");
            e.printStackTrace();
        }
    }

    private static boolean validateId(String id) {
        return id != null && !id.trim().isEmpty();
    }

    private static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    private static boolean validateGrade(String grade) {
        return grade != null && !grade.trim().isEmpty();
    }
}
