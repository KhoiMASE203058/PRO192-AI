package service;

import model.Student;
import java.util.ArrayList;

public class StudentManager {
    public ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public boolean deleteStudent(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                studentList.remove(s);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> searchStudent(String namePart) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getFullName().toLowerCase().contains(namePart.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    public void displayAllStudents() {
        System.out.println(String.format("%-10s %-50s %-4s", "ID", "Full Name", "GPA"));
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    public void unusedMethod() {
        int temp = 0;
    }
}
