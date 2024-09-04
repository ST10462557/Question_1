/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abc_college;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dudle
 */
public class StudentManager {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManager() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Starting menu to launch program
    public void run() {
        while (true) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("***********************************");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                showMenu();
            } else {
                exitStudentApplication();
                break;
            }
        }
    }
    // Main menu with required menu items
    private void showMenu() {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print student report.");
            System.out.println("(5) Exit Application.");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    captureNewStudent();
                    break;
                case "2":
                    searchStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    printStudentReport();
                    break;
                case "5":
                    exitStudentApplication();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    // Capturing new student by requring their information such as their ID
    private void captureNewStudent() {
        System.out.println("\nCAPTURE A NEW STUDENT");
        System.out.println("***************************");

        System.out.print("Enter the student id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        int age = getValidAgeFromUser();

        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        Student newStudent = new Student(id, name, age, email, course);
        students.add(newStudent);

        System.out.println("Student details have been successfully saved!");
        promptForMenuReturn();
    }
    // ensuring the students age is valid and over 16
    public static int getValidAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput);
            if (age >= 16) {
                return age;
            } else {
                System.out.println("You have entered an incorrect student age!!!");
                System.out.println("Age must be 16 or older");
                return -1; // Indicate invalid age
            }
        } catch (NumberFormatException e) {
            System.out.println("You have entered an incorrect student age!!!");
            System.out.println("Invalid age input: must be a number");
            return -2; // Indicate invalid input
        }
    }

    private int getValidAgeFromUser() {
        while (true) {
            System.out.print("Enter the student age: ");
            String ageInput = scanner.nextLine();
            int result = getValidAge(ageInput);
            if (result >= 16) {
                return result;
            }
            // If result is -1 or -2, the error message has already been printed
            // Just continue the loop to ask for input again
        }
    }
    // Ability to search for a student by using their ID
    private void searchStudent() {
        System.out.print("Enter the student search id to search: ");
        String searchId = scanner.nextLine();

        Student foundStudent = Student.searchStudent(students, searchId);

        if (foundStudent != null) {
            System.out.println("----------------------------------------------");
            System.out.println(foundStudent);
            System.out.println("----------------------------------------------");
        } else {
            System.out.println("-------------------------------------");
            System.out.println("Student with id " + searchId + " was not found!");
            System.out.println("-------------------------------------");
        }

        promptForMenuReturn();
    }
    // Ability to delete student by entering their ID
    private void deleteStudent() {
        System.out.print("Enter the student id to delete: ");
        String deleteId = scanner.nextLine();

        Student studentToDelete = Student.searchStudent(students, deleteId);

        if (studentToDelete != null) {
            System.out.print("Are you sure you want to delete student " + deleteId + " from the system? Yes (y) to delete. ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("y")) {
                Student.deleteStudent(students, deleteId);
                System.out.println("----------------------------------------");
                System.out.println("Student with student id: " + deleteId + " WAS deleted!");
                System.out.println("----------------------------------------");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Student with id " + deleteId + " was not found!");
        }

        promptForMenuReturn();
    }

    private void printStudentReport() {
        Student.studentReport(students);
        promptForMenuReturn();
    }

    private void exitStudentApplication() {
        System.out.println("Exiting application. Goodbye!");
        scanner.close();
    }

    private void promptForMenuReturn() {
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            exitStudentApplication();
            System.exit(0);
        }
    }
}