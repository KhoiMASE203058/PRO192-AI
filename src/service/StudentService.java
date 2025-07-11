package service;

import model.Student;
import util.Validator;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student s) throws Exception {
        if (students.size() >= 100) {
            throw new Exception("Maximum student limit reached.");
        }

        if (!Validator.isValidGPA(s.getGpa())) {
            throw new Exception("Invalid GPA.");
        }

        if (getStudentById(s.getId()) != null) {
            throw new Exception("Student ID already exists.");
        }

        students.add(s);
    }

    public void deleteStudent(int id) throws Exception {
        Student s = getStudentById(id);
        if (s == null) {
            throw new Exception("Student not found.");
        }
        students.remove(s);
    }

    public List<Student> searchStudent(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    public void displayStudents() {

        System.out.printf("%-10s %-30s %s\n", "ID", "Full Name", "GPA");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private Student getStudentById(int id) {

        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
