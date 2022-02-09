package sample;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    private final Integer studentID;
    private final String studentName;
    private final String studentAddress;

    public Student(Integer id, String name, String address){
        this.studentID = id;
        this.studentName = name;
        this.studentAddress = address;
    }


    public Integer getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }
}
