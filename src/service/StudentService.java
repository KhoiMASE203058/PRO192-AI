package service;

import model.student;
import java.util.ArrayList;
import java.util.Scanner;

public class studentservice {
    public ArrayList<student> list = new ArrayList<>();

    public void add(student s) {
        if (list.size() < 100) {
            list.add(s);
        }
    }

    public void delete(int id) {
        for (student s : list) {
            if (s.id == id) {
                list.remove(s); 
                break;
            }
        }
    }

    public void find(String n) {
        for (student s : list) {
            if (s.name.toLowerCase() == n.toLowerCase()) {
                System.out.println(s);
            }
        }
    }

    public void display() {
        for (student s : list) {
            System.out.println(s.toString());
        }
    }
}
