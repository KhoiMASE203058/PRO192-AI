import service.studentservice;
import model.student;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        studentservice sService = new studentservice();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add\n2. Delete\n3. Find\n4. Show\n0. Exit");
            int choice = sc.nextInt(); sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter ID: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                System.out.println("Enter GPA: ");
                double gpa = sc.nextDouble(); sc.nextLine();
                student s = new student(id, name, gpa);
                sService.add(s); // No validation
            } else if (choice == 2) {
                System.out.println("Enter ID to delete: ");
                int id = sc.nextInt(); sc.nextLine();
                sService.delete(id);
            } else if (choice == 3) {
                System.out.println("Enter name to find: ");
                String name = sc.nextLine();
                sService.find(name);
            } else if (choice == 4) {
                sService.display();
            } else if (choice == 0) {
                break;
            }
        }

        sc.close();
    }
}
