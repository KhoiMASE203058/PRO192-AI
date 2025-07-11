package model;

public class student {
    public int id;
    public String name;
    public double gpa;

    public student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String toString() {
        return id + " | " + name + " | " + gpa;
    }
}
