import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    public static void getAllStudents() throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM students";

        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-10s %-5s%n", "ID", "Roll No", "Name", "Reg No", "Dept", "Year", "Grade");
        System.out.println("-------------------------------------------------------------------------------------------");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String rollNo = resultSet.getString("rollno");
            String name = resultSet.getString("name");
            String regNo = resultSet.getString("regno");
            String dept = resultSet.getString("dept");
            int year = resultSet.getInt("current_year");
            String grade = resultSet.getString("grade");

            System.out.printf("%-5d %-15s %-15s %-15s %-15s %-10d %-5s%n", id, rollNo, name, regNo, dept, year, grade);
        }
        System.out.println();
        con.close();
    }
    public static int insertStudent(Student student) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO students (rollno,name,regno,dept,current_year,grade) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, student.rollNo);
        pst.setString(2, student.name);
        pst.setString(3, student.regNo);
        pst.setString(4, student.dept);
        pst.setInt(5, student.year);
        pst.setString(6, student.grade);
        int rows = pst.executeUpdate();
        con.close();
        return rows;
    }
    public static int updateData(Student student,String updateRollNo) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE students SET rollno = ?, name = ?, regno = ?, dept = ?, current_year = ?, grade = ? WHERE rollno = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, student.rollNo);
        pst.setString(2, student.name);
        pst.setString(3, student.regNo);
        pst.setString(4, student.dept);
        pst.setInt(5, student.year);
        pst.setString(6, student.grade);
        pst.setString(7, updateRollNo);
        int rows = pst.executeUpdate();
        con.close();
        return rows;
    }
    public static int deleteData(String rollno) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "DELETE FROM students where rollno = '" + rollno + "'";

        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);

        con.close();
        return rows;
    }
    public static void searchData(String rollno) throws SQLException{
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM students where rollno = '" + rollno + "'";

        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);

        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-10s %-5s%n", "ID", "Roll No", "Name", "Reg No", "Dept", "Year", "Grade");
        System.out.println("-------------------------------------------------------------------------------------------");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String rollNo = resultSet.getString("rollno");
            String name = resultSet.getString("name");
            String regNo = resultSet.getString("regno");
            String dept = resultSet.getString("dept");
            int year = resultSet.getInt("current_year");
            String grade = resultSet.getString("grade");

            System.out.printf("%-5d %-15s %-15s %-15s %-15s %-10d %-5s%n", id, rollNo, name, regNo, dept, year, grade);
        }
        System.out.println();
        con.close();
    }

    public static Student getDataObj(String rollno) throws SQLException{
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM students where rollno = '" + rollno + "'";
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);
        ArrayList<Student> studentList = new ArrayList<>();
        resultSet.next();
        Student student = new Student();
        student.rollNo = resultSet.getString("rollno");
        student.name = resultSet.getString("name");
        student.regNo = resultSet.getString("regno");
        student.dept = resultSet.getString("dept");
        student.year = resultSet.getInt("current_year");
        student.grade = resultSet.getString("grade");
        con.close();
        return student;
    }
}