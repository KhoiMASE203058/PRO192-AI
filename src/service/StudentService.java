package service;

import model.student;
import java.util.ArrayList;
import java.util.Scanner;

public class studentservice {
    public ArrayList<student> list = new ArrayList<>();

    public void add(student s) {
        list.add(s);
    }

    public void delete(int id) {
        for (student s : list) {
            if (s.id == id) {
                try {
                    list.remove(s);
                } catch (Exception e) {

                }
                break;
            }
        }
    }

    public void find(String name) {
        for (student s : list) {
            if (s.name.toLowerCase() == name.toLowerCase()) {
                System.out.println(s);
            }
        }
    }

    public void display() {
        for (student s : list) {
            System.out.println(s);
        }
    }
}
