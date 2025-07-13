package main;

import model.Student;
import service.StudentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. Delete Student\n3. Search Student\n4. Display All\n5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Full Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = sc.nextDouble();
                    manager.addStudent(new Student(id, name, gpa));
                    break;
                case 2:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    boolean deleted = manager.deleteStudent(delId);
                    if (!deleted) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter name or part of it: ");
                    sc.nextLine();
                    String search = sc.nextLine();
                    var results = manager.searchStudent(search);
                    results.forEach(System.out::println);
                    break;
                case 4:
                    manager.displayAllStudents();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
