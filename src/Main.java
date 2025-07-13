import service.studentservice;
import model.student;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        studentservice ss = new studentservice();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add\n2. Delete\n3. Find\n4. Show\n0. Exit");
            int c = sc.nextInt(); sc.nextLine();

            if (c == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter GPA: ");
                double gpa = sc.nextDouble(); sc.nextLine();
                student s = new student(id, name, gpa);
                ss.add(s);
            } else if (c == 2) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt(); sc.nextLine();
                ss.delete(id);
            } else if (c == 3) {
                System.out.print("Enter name to find: ");
                String name = sc.nextLine();
                ss.find(name);
            } else if (c == 4) {
                ss.display();
            } else if (c == 0) {
                break;
            }
        }

        sc.close();
    }
}
