package main;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class Model {
    public static final String CONNECTION_STRING = "jdbc:sqlite:database.db";

    // Table for students
    public static final String COLUMN_STUDENT_ID = "StudentID";
    public static final String COLUMN_STUDENT_NAME = "StudentName";
    public static final String COLUMN_STUDENT_ADDRESS = "StudentAddress";

    // Table for teachers
    public static final String COLUMN_TEACHER_ID = "TeacherID";
    public static final String COLUMN_TEACHER_NAME = "TeacherName";
    public static final String Column_TEACHER_ADDRESS = "TeacherAddress";

    // Table for courses
    public static final String COLUMN_COURSE_ID = "CourseID";
    public static final String COLUMN_COURSE_NAME = "CourseName";
    public static final String COLUMN_COURSE_YEAR = "CourseYear";
    public static final String COLUMN_COURSE_SEMESTER = "CourseSemester";
    public static final String COLUMN_COURSE_TEACHER_ID = "TeacherID";

    // Table for grades
    public static final String COLUMN_GRADE = "Grade";
    // The last two elements of the table is shared as foreign keys

    private Connection conn;
    private static final Model instance = new Model();

    public Model() {
    }

    public static Model getInstance(){
        return instance;
    }

    public boolean open() {
        try {
            conn = getConnection(CONNECTION_STRING);
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
        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM Students");
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

    // A method to query the database for information on all courses
    public ArrayList<Course> queryCourses() {
        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM Courses");
            ArrayList<Course> courses = new ArrayList<>();
            while(results.next()) {
                Course course = new Course();
                course.setCourseID(results.getInt(COLUMN_COURSE_ID));
                course.setCourseName(results.getString(COLUMN_COURSE_NAME));
                course.setYear(results.getInt(COLUMN_COURSE_YEAR));
                course.setSemester(results.getString(COLUMN_COURSE_SEMESTER));
                course.setTeacher(results.getString(COLUMN_COURSE_TEACHER_ID));
                courses.add(course);
            }
            return courses;

        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // A method to query the database for average grade of student
    public Float getAverageGradeOfStudent(int id){
        Float averageGrade = null;
        String query = "SELECT AVG(Grade) FROM Grades WHERE StudentID = ?;";

        Connection conn = null;

        try {
            conn = getConnection(CONNECTION_STRING);
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                averageGrade = results.getFloat(1);
            }
        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        } finally {
            close();
        }
        return averageGrade;
    }
}
