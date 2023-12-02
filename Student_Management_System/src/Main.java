import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("**** STUDENT MANAGEMENT SYSTEM ****");

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display all Students");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your option : ");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    new Student().addStudent();
                    break;
                case 2:
                    new Student().updateStudent();
                    break;
                case 3:
                    new Student().searchStudent();
                    break;
                case 4:
                    StudentDAO.getAllStudents();
                    break;
                case 5:
                    new Student().deleteStudent();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}