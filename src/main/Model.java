package main;

import java.sql.*;
import java.util.ArrayList;

public class Model {
    public static final String DB_NAME = "database.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:";

    // Table for students
    public static final String COLUMN_STUDENT_ID = "StudentID";
    public static final String COLUMN_STUDENT_NAME = "StudentName";
    public static final String COLUMN_STUDENT_ADDRESS = "StudentAddress";

    // Table for teachers


    // Table for

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
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
            ResultSet results = statement.executeQuery("SELECT * FROM Students")) {
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
