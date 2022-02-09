package main;

import java.sql.*;
import java.util.ArrayList;

public class Model {
    private final String url;
    private Connection conn = null;

    // Table for students
    public static final String TABLE_STUDENTS = "students";
    public static final String COLUMN_STUDENT_ID = "id";
    public static final String COLUMN_STUDENT_NAME = "name";
    public static final String COLUMN_STUDENT_ADDRESS = "address";

    // Table for


    public Model(String url){
        this.url = url;
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(url);
            return true;
        } catch(SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch(SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    // SQL QUERIES

    // A method to query the database for information on all students
    public ArrayList<Student> queryStudents() {

        try (Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_STUDENTS)) {
            ArrayList<Student> students = new ArrayList<>();
            while(results.next()) {
                Student student = new Student();
                student.setId(results.getInt(COLUMN_STUDENT_ID));
                student.setName(results.getString(COLUMN_STUDENT_NAME));
                student.setAddress(results.getString(COLUMN_STUDENT_ADDRESS));
                students.add(student);
            }

            return students;

        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}
