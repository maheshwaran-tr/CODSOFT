import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Student {
    String name, rollNo, regNo, dept, grade;
    int year;

    public void addStudent() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name : ");
        this.name = sc.next();
        System.out.print("Enter Student Rollno : ");
        this.rollNo = sc.next();
        System.out.print("Enter Student Regno : ");
        this.regNo = sc.next();
        System.out.print("Enter Student Dept : ");
        this.dept = sc.next();
        System.out.print("Enter Student Year : ");
        this.year = sc.nextInt();
        System.out.print("Enter Student Grade : ");
        this.grade = sc.next();
        int rows = StudentDAO.insertStudent(this);
        System.out.println(rows + " Rows Inserted\n");
    }

    public void deleteStudent() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Rollno to delete : ");
        String rollNo = sc.next();
        int rows = StudentDAO.deleteData(rollNo);
        System.out.println(rows + " Rows Deleted\n");
    }

    public void updateStudent() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Rollno to updated : ");
        String updateRollNo = sc.next();
        StudentDAO.searchData(updateRollNo);
        Student student = StudentDAO.getDataObj(updateRollNo);
        System.out.println("Enter 'skip' to skip the columns ! ");

        System.out.print("Enter Student Name : ");
        String name = sc.next();

        System.out.print("Enter Student Rollno : ");
        String rollNo = sc.next();

        System.out.print("Enter Student Regno : ");
        String regNo = sc.next();

        System.out.print("Enter Student Dept : ");
        String dept = sc.next();

        System.out.print("Enter Student Year : ");
        String year = sc.next();

        System.out.print("Enter Student Grade : ");
        String grade = sc.next();

        this.name   = name.equals("skip") ? student.name : name;
        this.rollNo = rollNo.equals("skip") ? student.rollNo : rollNo;
        this.regNo  = regNo.equals("skip") ? student.regNo : regNo;
        this.dept   = dept.equals("skip") ? student.dept : dept;
        this.year   = year.equals("skip") ? student.year : Integer.parseInt(year);
        this.grade  = grade.equals("skip") ? student.grade : grade;
        int rows = StudentDAO.updateData(this,updateRollNo);

        System.out.println(rows + " Rows Updated\n");
    }

    public void searchStudent() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Rollno to search : ");
        String rollNo = sc.next();
        StudentDAO.searchData(rollNo);
    }
}