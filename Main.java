package main;

import java.util.Scanner;

import manager.StudentManager;
import model.Student;
import thread.LoadingThread;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        LoadingThread load = new LoadingThread();
        load.start();

        try { load.join(); } catch (Exception e) {}

        manager.loadData();

        while (true) {
            System.out.println("\n=== CAPSTONE STUDENT MENU ===");
            System.out.println("1. Add Student");
            System.out.println("2. Update Marks");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. View All");
            System.out.println("6. Sort by Marks");
            System.out.println("7. Save & Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            try {
                if (ch == 1) {
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();

                    manager.addStudent(new Student(roll, name, email, marks));
                }

                else if (ch == 2) {
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    System.out.print("New Marks: ");
                    double marks = sc.nextDouble();
                    manager.updateStudent(roll, marks);
                }

                else if (ch == 3) {
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    manager.deleteStudent(roll);
                }

                else if (ch == 4) {
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    manager.searchStudent(roll).display();
                }

                else if (ch == 5) manager.viewStudents();

                else if (ch == 6) manager.sortByMarks();

                else if (ch == 7) {
                    manager.saveData();
                    System.out.println("Exiting... Goodbye!");
                    break;
                }

                else System.out.println("Invalid Choice.");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
