package main;

public class Course {
    private final Integer courseID;
    private final String courseName;
    private final Integer year;
    private final String semester;
    private final String teacher;

    public Course(Integer id, String name, Integer year, String semester, String teacher){
        this.courseID = id;
        this.courseName = name;
        this.year = year;
        this.semester = semester;
        this.teacher = teacher;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getTeacher() {
        return teacher;
    }
}
