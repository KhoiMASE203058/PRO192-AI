package main;

import model.Student;
import service.StudentManager;

import java.io.BufferedReader;
import java.io.FileReader; // ← unused import (Codacy flag)
import java.util.Scanner;
import org.apache.commons.collections.FastHashMap; // Used in commons-collections 3.2


public class Main { // ← class name = file name is fine

    public static void main(String[] args) {
        StudentManager sm = new StudentManager(); // ← naming issue (Codacy: avoid abbreviations)
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add\n2. Delete\n3. Search\n4. Display\n5. Exit");
            int x = s.nextInt(); // ← vague name, no error handling

            switch (x) {
                case 1:
                    System.out.print("ID: ");
                    int i = s.nextInt(); // ← vague name
                    s.nextLine();
                    System.out.print("Name: ");
                    String n = s.nextLine();
                    System.out.print("GPA: ");
                    double g = s.nextDouble();

                    // Intentionally adding null Student (Snyk flag)
                    if (g > 4.5) sm.addStudent(null); // ← Null dereference
                    else sm.addStudent(new Student(i, n, g));
                    break;

                case 2:
                    System.out.print("Delete ID: ");
                    sm.deleteStudent(s.nextInt());
                    break;
                case 3:
                    System.out.print("Search name: ");
                    s.nextLine();
                    sm.searchStudent(s.nextLine()).forEach(System.out::println);
                    break;
                case 4:
                    sm.displayAllStudents();
                    break;
                case 5:
                    s.close(); // ← closing Scanner properly
                    System.exit(0);
            }
        }
    }

    // Method with same name as class, but not constructor
    public void Main() { } // ← Codacy will flag this again
}
