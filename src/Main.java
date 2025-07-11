import model.Student;
import service.StudentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n1. Add Student\n2. Delete Student\n3. Search Student\n4. Display All\n0. Exit");
            option = sc.nextInt(); sc.nextLine();

            try {
                switch (option) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("GPA: ");
                        double gpa = sc.nextDouble(); sc.nextLine();
                        service.addStudent(new Student(id, name, gpa));
                        break;
                    case 2:
                        System.out.print("Enter ID to delete: ");
                        service.deleteStudent(sc.nextInt()); sc.nextLine();
                        break;
                    case 3:
                        System.out.print("Enter name to search: ");
                        service.searchStudent(sc.nextLine()).forEach(System.out::println);
                        break;
                    case 4:
                        service.displayStudents();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);

        sc.close();
    }
}
